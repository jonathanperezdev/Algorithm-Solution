package org.algorithms.courses.udemy.master_coding_interview.data_structures;

import java.util.AbstractList;
import java.util.List;

/*
 * Data Structure and Algorithms
 *
 * Section 6: Data Structures: Arrays
 *  71. Implementing an array
 * */

public class MyArrayList<E> extends AbstractList<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 2;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("The index is greater than size");
        }
        return (E)elements[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E element) {
        if(size >= elements.length){
            this.elements = resizeElements(this.elements);
        }
        elements[size] = element;
        size++;

        return true;
    }

    private Object[] resizeElements(Object[] elementsBefore){
        Object[] resizedElements = new Object[elementsBefore.length*2];
        for(int i =0; i < elementsBefore.length; i++){
            resizedElements[i] = elementsBefore[i];
        }
        return resizedElements;
    }

    public static void main(String[] args) {
        List<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("MyArrayList: " + list);
    }
}
