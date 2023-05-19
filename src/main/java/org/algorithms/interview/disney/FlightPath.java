package org.algorithms.interview.disney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Company: Disney
 * Type of Algorithms: Recursion bottom-up
 *
 * Given a list of flights represented by pairs of departure and
 * arrival cities [from, to], reconstruct a travel path in order
 * of connected flights.
 *
 * Note 1: We can assume that the travel path always begins from
 * Los Angeles.
 *
 * Note 2: When multiple destinations exist for a given departure,
 * choose destinations alphabetically.
 *
 * Note 3: You can't use the same ticket twice
 *
 * Solution:
 * Basically this problem consist in find the arrival of a departure, and take this arrival as a new departure
 */
class FlightPath {
    private List<String> path = new ArrayList<>();
    private List<List<String>> tickets;
    public List<String> buildFlightPath(List<List<String>> tickets){
        this.tickets = tickets;
        fillPath("Los Angeles");
        return path;
    }

    //Recursive function
    private void fillPath(String departure){
        Optional<String> destination = findArrivalOf(departure);
        path.add(departure);
        //Base case
        if(destination.isEmpty()){
            return;
        }

        //Recursive Case
        fillPath(destination.get());
    }

    private Optional<String> findArrivalOf(String departure){
        Optional<List<String>> nextFlight = tickets.stream()
                .filter(t -> t.get(0).equals(departure))
                .findFirst();

        if(nextFlight.isEmpty()){
            return Optional.empty();
        }else{
            //Reducing the problem
            tickets = tickets.stream()
                    .filter(t -> !(t.get(0).equals(nextFlight.get().get(0)) && t.get(1).equals(nextFlight.get().get(1))))
                    .collect(toList());
            return Optional.of(nextFlight.get().get(1));
        }
    }
}

//region Test
class FlightPathTest{
    private FlightPath flightPath = new FlightPath();

    public static void main(String[] args){
        FlightPathTest test = new FlightPathTest();
        test.test1();
    }

    private void test1(){
        var flights = Arrays.asList(
                List.of("Tokyo", "Seoul"),
                List.of("Los Angeles", "Tokyo"),
                List.of("Singapore", "Toronto"),
                List.of("Seoul", "Singapore")
        );
        var expected = List.of("Los Angeles", "Tokyo", "Seoul", "Singapore", "Toronto");
        var actual =flightPath.buildFlightPath(flights);
        assertEquals(expected, actual);
    }

    private void test2(){
        var flights = Arrays.asList(
                List.of("Los Angeles","Singapore"),
                List.of("Los Angeles","New York"),
                List.of("Singapore","New York"),
                List.of("New York","Los Angeles"),
                List.of("New York","Singapore")
        );

        var expected = List.of("Los Angeles", "New York", "Los Angeles", "Singapore", "New York", "Singapore");
        var actual =flightPath.buildFlightPath(flights);
        assertEquals(expected, actual);
    }
}
//endregion
