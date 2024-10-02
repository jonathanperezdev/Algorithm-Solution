package org.algorithms.books.commond_sense_guide.graph.directed_graph;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DepthFirstSearch {
    private Set<Vertex> visited = new HashSet<>();
    private Vertex foundVertex;
    public void search(Vertex nextVertex, String valueSearched){
        //Base Case: We found the node
        if(valueSearched.equals(nextVertex.getValue())){
            foundVertex = nextVertex;
            return;
        }

        //Base Case: we already visited the node
        if(visited.contains(nextVertex)){
            return;
        }

        visited.add(nextVertex);
        if(CollectionUtils.isNotEmpty(nextVertex.getAdjacentVertices())) {
            for (Vertex vertex : nextVertex.getAdjacentVertices()) {
                search(vertex, valueSearched);
            }
        }
    }

    public Optional<Vertex> getFoundVertex(){
        return Optional.ofNullable(foundVertex);
    }
}
