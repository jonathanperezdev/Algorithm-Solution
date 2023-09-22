package org.algorithms.books.commond_sense_guide.graph.weighted_graph;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;;

@EqualsAndHashCode(of = {"cityName"})
@Getter
public class City {
    private String cityName;
    //City and cost to travel to this city
    private Map<City, Integer> adjacentCities;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public void addRoute(City city, Integer cost){
        if(Objects.isNull(adjacentCities)){
            this.adjacentCities = new HashMap<>();
        }
        this.adjacentCities.put(city, cost);
    }
}
