package org.algorithms.books.commond_sense_guide;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
/*
* Book: A common sense guide to Data Structures and Algorithms
* Chapter 8: Blazing Fast Lookup with Hash Tables
* Exercise 1 - Find the intersection elements between two arrays
*
* Solution:
* 1. Create an index(Set) to be used as an index in which you add all elements from List1
* 2. Iterate List2 and search each element in index, if element is found, added to result intersection list
* */
public class IntersectionTwoArrays {
    public static void main(String[] args){
        test1();
    }

    private static List<Integer> getIntersectionOf(List<Integer> list1, List<Integer> list2){

        Set<Integer> index = new HashSet<Integer>();
        List<Integer> intersection = new ArrayList<>();

        for(int number : list1){
            index.add(number);
        }

        int i = 0;
        for (int number : list2){
            if(index.contains(number)){
                intersection.add(number);
            }
        }

        return intersection;
    }

    private static void test1(){
        List<Integer> intersection = getIntersectionOf(List.of(1, 2, 3, 4, 5) ,List.of(0, 2, 4, 6, 8));
        assertThat(intersection, Matchers.containsInAnyOrder(List.of(2,4).toArray()));
    }
}
