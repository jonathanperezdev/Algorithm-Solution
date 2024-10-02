package org.algorithms.courses.udemy.master_coding_interview.data_structures.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Node<T> {
    private T data;
    private Node next;
}
