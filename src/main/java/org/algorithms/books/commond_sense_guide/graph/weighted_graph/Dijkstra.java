package org.algorithms.books.commond_sense_guide.graph.weighted_graph;
import org.apache.commons.collections4.MapUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 19: Connecting Everything with Graphs
 * Dijkstra’s Algorithm
 *
 * Given a weighted graph, find the less cost route from origin to destination
 *
 * Solution:
 *
 *
 * See Knowledge-base Trie data structure
 * */
public class Dijkstra {
    private Set<City> visitedCities = new HashSet<>();
    // Price from origin to city
    private Map<String, Integer> cheapestPrices = new HashMap<>();
    // Has the previous cheapest stop city as value that you have to do to arrive to the key city
    private Map<String, String> cheapestPreviousStopover = new HashMap<>();

    private City originCity;

    public void calculatePrices(City origin){
        this.originCity = origin;
        City currentCity = origin;
        cheapestPrices.put(origin.getCityName(), 0);

        while(!visitedCities.contains(currentCity)){
            visitedCities.add(currentCity);

            Integer cost;
            Map<City, Integer> adjacentCities = currentCity.getAdjacentCities();
            if(MapUtils.isEmpty(adjacentCities)){
                continue;
            }

            // We have to iterate adjacent cities to calculate min cost
            for (Map.Entry<City,Integer> adjacentCity : adjacentCities.entrySet()){

                // Cost = cost to travel from origin city to current city + current city to adjacent city
                cost = calculateCost(currentCity, adjacentCity.getValue());
                if(cost < cheapestPrices.computeIfAbsent(adjacentCity.getKey().getCityName(), key -> Integer.MAX_VALUE)){
                    cheapestPrices.put(adjacentCity.getKey().getCityName(), cost);
                    cheapestPreviousStopover.put(adjacentCity.getKey().getCityName(), currentCity.getCityName());
                }
            }

            // Next city to visit should be adjacent city who has the minimum cost to travel from origin
            currentCity = findNextCity(currentCity);
        }
    }

    // Calculates the cost from the origin city to the current city present in cheapestPrices Map + the cost from current city to the adjacent city
    private Integer calculateCost(City city, Integer price){
        Integer cost = cheapestPrices.computeIfAbsent(city.getCityName(), key -> 0) + price;
        return cost;
    }

    private City findNextCity(City currentCity){
        Optional<Map.Entry<City,Integer>> minCostCity =
                currentCity.getAdjacentCities().entrySet()
                .stream()
                .filter(city -> !visitedCities.contains(city))
                .min(Comparator.comparing(city -> cheapestPrices.computeIfAbsent(city.getKey().getCityName(), key -> 0)));


        return minCostCity.get().getKey();
    }

    public Optional<Integer> getMinCostTo(City city){
        return Optional.ofNullable(cheapestPrices.get(city.getCityName()));
    }

    // Route is calculated starting in destination city until we reach the origin city using cheapestPreviousStopover
    public Stack<String> getRouteTo(City destination){
        Stack<String> route = new Stack<>();

        String origin = originCity.getCityName();
        String current = destination.getCityName();
        while(!origin.equals(current)){
            route.push(current);
            current = cheapestPreviousStopover.get(current);
        }
        route.push(origin);

        return route;
    }
}
