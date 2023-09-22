package org.algorithms.books.commond_sense_guide.graph.directed_graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"value"})
public class Vertex {
    private String value;
    private Set<Vertex> adjacentVertices;

    public Vertex(String value) {
        this.value = value;
    }

    public void addAdjacentVertexCollection(Set<Vertex> vertexList) {
        this.adjacentVertices = vertexList;
    }

    public void addAdjacentVertex(Vertex vertex) {
        if(Objects.isNull(this.adjacentVertices)){
            this.adjacentVertices = new HashSet<>();
        }
        this.adjacentVertices.add(vertex);
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
