package org.algorithms.books.commond_sense_guide.node_based_data_structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
class LinkedListPersonal {
    private Node firstNode;

    private LinkedListPersonal(){}

    public void addNode(Node node){
        node.setNext(firstNode);
        firstNode = node;
    }

    public static <T> LinkedListPersonal createLinkedList(T ... dataNodes){
        LinkedListPersonal linkedList = new LinkedListPersonal();

        for(T data : dataNodes){
            linkedList.addNode(new Node(data));
        }

        return linkedList;
    }

    public void printLinkedList(){
        Node node = firstNode;
        while(Objects.nonNull(node)){
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public LinkedListPersonal reverse(){
        reverseNode(this.firstNode);
        return this;
    }

    private void reverseNode(Node current){
        //Base Case
        if(Objects.isNull(current.getNext())){
            firstNode = current;
            return;
        }

        Node previous = current.getNext();
        if(current == firstNode)
            current.setNext(null);

        //Recursive Case: Reducing the problem as I am calculating reverse of next element
        reverseNode(previous);
        previous.setNext(current);
    }
}

@RequiredArgsConstructor
@Setter
@Getter
class Node<T> {
    private final T data;
    private Node next;
}
