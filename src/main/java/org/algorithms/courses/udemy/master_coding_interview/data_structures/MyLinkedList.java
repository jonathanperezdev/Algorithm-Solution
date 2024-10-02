package org.algorithms.courses.udemy.master_coding_interview.data_structures;

import org.algorithms.courses.udemy.master_coding_interview.data_structures.utils.Node;

import java.util.Objects;

/*
 * Data Structure and Algorithms
 *
 * Section 8: Data Structures: LinkedList
 *  98. Our First Linked List
 * */
public class MyLinkedList<T> {

    private Node head;
    private Node tail;
    private Integer size;

    public MyLinkedList(T data){
        this.head = new Node(data, null);
        this.size = 1;
        this.tail = this.head;
    }

    public MyLinkedList<T> add(T data){
        Node auxNode = new Node(data, null);
        this.tail.setNext(auxNode);
        this.tail = auxNode;
        this.size ++;

        return this;
    }

    public MyLinkedList<T> addFirst(T data){
        Node auxNode = new Node(data, this.head);
        this.head = auxNode;
        this.size ++;

        return this;
    }

    public MyLinkedList<T> insert(int index, T data){
        Node auxNode;
        Node newNode;
        if(index >= this.size){
            throw new IndexOutOfBoundsException("Index is greater than size: "+this.size);
        }

        if(index == 0){
            addFirst(data);
            return this;
        }

        if(index == size-1){
            add(data);
            return this;
        }

        auxNode = this.head;
        for(int i =0; i < index-1; i++){
            auxNode = auxNode.getNext();
        }

        newNode = new Node(data,auxNode.getNext());
        auxNode.setNext(newNode);
        this.size ++;
        return this;
    }

    public MyLinkedList<T> delete(T data){
        Node auxNode;
        Node deleteNode;

        if(this.size < 1){
            return this;
        }

        if(data.equals(this.head.getData())){
            this.head = this.head.getNext();
            return this;
        }

        auxNode = this.head;

        while (Objects.nonNull(auxNode.getNext())){
            if(auxNode.getNext().getData().equals(data)){
                deleteNode = auxNode.getNext();
                auxNode.setNext(deleteNode.getNext());

                if(deleteNode == this.head){
                    this.tail = auxNode;
                }
                deleteNode.setNext(null);
                this.size --;
                break;
            }
            auxNode = auxNode.getNext();
        }
        return this;
    }

    public void print(){
        Node auxNode = this.head;
        System.out.println("This is the content: ");
        while (Objects.nonNull(auxNode)){
            System.out.print(auxNode.getData()+",");
            auxNode = auxNode.getNext();
        }
        System.out.println();
    }

    public void reverse(Node current){
        //Base case
        if(Objects.isNull(current.getNext())){
            this.head = current;
            return;
        }

        Node previous = current.getNext();
        if(this.head == current){
            current.setNext(null);
        }

        //Recursive Case: Reducing the problem as I am calculating reverse of next element
        reverse(previous);
        previous.setNext(current);
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("first");
        myLinkedList.add("second");
        myLinkedList.add("third");
        myLinkedList.add("fourth");
        myLinkedList.addFirst("zero");
        myLinkedList.insert(2, "newPosition");
        myLinkedList.insert(5,"last");

        myLinkedList.print();

        myLinkedList.reverse(myLinkedList.head);
        myLinkedList.print();
    }
}
