package org.algorithms.courses.udemy.master_coding_interview.data_structures;

import org.algorithms.courses.udemy.master_coding_interview.data_structures.utils.Node;

import java.util.Objects;
import java.util.Optional;

/*
 * Data Structure and Algorithms
 *
 * Section 9: Data Structures: Stacks + Queues
 *  124. Exercise: Queue implementation
 * */
public class MyQueue<T> {
    private Node first = null;
    private Node last = null;
    private Integer size = 0;

    public Optional<T> peek(){
        if(Objects.isNull(this.first)){
            return Optional.empty();
        }
        return Optional.of((T) this.first.getData());
    }

    public Optional<T> poll(){
        if(size <= 0){
            return Optional.empty();
        }

        Optional<T> data = peek();
        this.size --;

        if(this.first == this.last){
            this.first = this.last = null;
            return data;
        }

        this.first = this.first.getNext();
        return  data;
    }

    public MyQueue<T> offer(T data){
        this.size ++;

        Node newElement = new Node(data, null);
        if(Objects.isNull(this.last)){
            this.first = newElement;
        }else{
            this.last.setNext(newElement);
        }
        this.last = newElement;

        return this;
    }

    public static void main(String[] args) {
        MyQueue<String> storeQueue = new MyQueue<>();
        storeQueue.offer("Jhon");
        storeQueue.offer("Andres");
        storeQueue.offer("Camilo");

        System.out.println(storeQueue.peek());
        System.out.println(storeQueue.poll());
        System.out.println(storeQueue.poll());
        System.out.println(storeQueue.poll());
        System.out.println(storeQueue.poll());
    }


}
