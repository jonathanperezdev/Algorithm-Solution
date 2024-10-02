package org.algorithms.courses.udemy.master_coding_interview.data_structures;

import org.algorithms.courses.udemy.master_coding_interview.data_structures.utils.Node;

import java.util.Objects;
import java.util.Optional;
/*
 * Data Structure and Algorithms
 *
 * Section 9: Data Structures: Stacks + Queues
 *  124. Exercise: Stack implementation(LinkedList)
 * */
public class MyStack<T> {
    private Node bottom = null;
    private Node top = null;
    private Integer size = 0;

    public Optional<T> peek(){
        if(Objects.isNull(this.top)){
            return Optional.empty();
        }
        return Optional.of((T) this.top.getData());
    }

    public Optional<T> pop(){
        if(size <= 0){
            return Optional.empty();
        }

        Optional<T> data = peek();
        this.size --;

        if(this.bottom == this.top){
            this.bottom = this.top = null;
            return data;
        }

        Node auxNode = this.bottom;
        while (auxNode.getNext() != this.top){
            auxNode = auxNode.getNext();
        }

        this.top = auxNode;
        this.top.setNext(null);

        return  data;
    }

    public MyStack<T> push(T data){
        this.size ++;

        Node newElement = new Node(data, null);

        if(Objects.isNull(this.top)){
            this.bottom = newElement;
        }else{
            this.top.setNext(newElement);
        }
        this.top = newElement;

        return this;
    }

    public static void main(String[] args) {
        MyStack<Integer> numbers = new MyStack<>();
        numbers.push(1);
        numbers.push(2);
        System.out.println(numbers.peek());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
    }
}
