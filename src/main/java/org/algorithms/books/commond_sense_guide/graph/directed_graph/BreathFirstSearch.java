package org.algorithms.books.commond_sense_guide.graph.directed_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;

public class BreathFirstSearch {
    private Set<Vertex> visited = new HashSet<>();
    private Queue<Vertex> vertexQueue = new LinkedList<>();

    public Optional<Vertex> search(Vertex initialVertex, String valueSearched){

        Vertex currentVertex;
        vertexQueue.offer(initialVertex);
        visited.add(initialVertex);
        if(valueSearched.equals(initialVertex.getValue())){
            return Optional.of(initialVertex);
        }
        while(CollectionUtils.isNotEmpty(vertexQueue)){
            currentVertex = vertexQueue.poll();

            if(CollectionUtils.isNotEmpty(currentVertex.getAdjacentVertices())) {
                for (Vertex vertex : currentVertex.getAdjacentVertices()) {
                    if (valueSearched.equals(vertex.getValue())) {
                        return Optional.of(vertex);
                    }
                    if (!visited.contains(vertex)) {
                        visited.add(vertex);
                        vertexQueue.offer(vertex);
                    }
                }
            }
        }

        return Optional.empty();
    }
}
