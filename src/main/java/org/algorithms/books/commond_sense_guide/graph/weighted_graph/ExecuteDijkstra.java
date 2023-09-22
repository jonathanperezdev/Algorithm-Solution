package org.algorithms.books.commond_sense_guide.graph.weighted_graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecuteDijkstra {
    public static void main(String args[]){
        Dijkstra dijkstra = new Dijkstra();
        Map<String, City> cities = createCities();
        dijkstra.calculatePrices(cities.get("Atlanta"));

        dijkstra.getMinCostTo(cities.get("El Paso"))
                .ifPresentOrElse(System.out::println, ()-> System.out.println("No cost found"));

        Stack<String> route = dijkstra.getRouteTo(cities.get("El Paso"));
        while(!route.isEmpty()){
            System.out.print(route.pop()+"->");
        }
    }

    private static Map<String, City> createCities(){
        Map<String, City> cities = new HashMap<>();

        City atlanta = new City("Atlanta");
        City boston = new City("Boston");
        City chicago = new City("Chicago");
        City denver = new City("Denver");
        City elPaso = new City("El Paso");

        atlanta.addRoute(boston, 100);
        atlanta.addRoute(denver, 160);
        boston.addRoute(chicago, 120);
        boston.addRoute(denver, 180);
        chicago.addRoute(elPaso, 80);
        denver.addRoute(chicago, 40);
        denver.addRoute(elPaso, 140);

        cities.put(atlanta.getCityName(), atlanta);
        cities.put(boston.getCityName(), boston);
        cities.put(chicago.getCityName(), chicago);
        cities.put(denver.getCityName(), denver);
        cities.put(elPaso.getCityName(), elPaso);

        return cities;
    }
}
