package org.algorithms.books.commond_sense_guide.graph.directed_graph;

import java.util.Arrays;
import java.util.HashSet;

public class ExecuteSearch {
    public static void main(String args[]){
        /*Derek helen return
        Lucia no
        * */


        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.search(createGraph(), "Lucia");
        depthFirstSearch.getFoundVertex().ifPresent(System.out::println);

        BreathFirstSearch breathFirstSearch = new BreathFirstSearch();
        breathFirstSearch.search(createGraph(), "Lucia").ifPresent(System.out::println);
    }

    private static Vertex createGraph(){
        Vertex vertexAlice = new Vertex("Alice");
        Vertex vertexBob = new Vertex("Bob");
        Vertex vertexCandy = new Vertex("Candy");
        Vertex vertexDerek = new Vertex("Derek");
        Vertex vertexElaine = new Vertex("Elaine");

        vertexAlice.addAdjacentVertexCollection(new HashSet<>(Arrays.asList(vertexBob, vertexCandy, vertexDerek, vertexElaine)));

        vertexDerek.addAdjacentVertex(vertexElaine);
        vertexElaine.addAdjacentVertex(vertexDerek);

        Vertex vertexFred = new Vertex("Fred");
        vertexBob.addAdjacentVertex(vertexFred);

        Vertex vertexHelen = new Vertex("Helen");
        vertexFred.addAdjacentVertex(vertexHelen);
        vertexCandy.addAdjacentVertex(vertexHelen);

        return vertexAlice;
    }
}
