package org.algorithms.courses.udemy.master_coding_interview.data_structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;
    private int numberOfNodes = 0;

    public GraphAdjacencyList(){
        adjacencyList = new HashMap<>();
    }


    public void addVertex(int value){
        numberOfNodes ++;
        adjacencyList.computeIfAbsent(value, s -> new ArrayList<>());
    }

    public void addEdge(int source, int destination){
        if(adjacencyList.containsKey(source)){
            adjacencyList.get(source).add(destination);
        }

        if(adjacencyList.containsKey(destination)){
            adjacencyList.get(destination).add(source);
        }
    }

    public void showConnections(){
        for(var node: this.adjacencyList.entrySet()){
            System.out.println(node.getKey()+" ---> "+node.getValue().stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(4,5);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(6,5);

        graph.showConnections();
    }

}
