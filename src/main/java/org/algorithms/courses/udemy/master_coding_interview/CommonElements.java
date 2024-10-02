package org.algorithms.courses.udemy.master_coding_interview;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Data Structure and Algorithms
*
* Section 4: How to solve coding problems
*  58. Exercise Interview Question 2
*
* Find if two arrays contains common elements
* */
public class CommonElements {
    private static boolean existCommonElements(String[] array1, String[] array2){
        if(isEmptyArray(array1) || isEmptyArray(array2)){
            return false;
        }

        Set<String> elements = Stream.of(array1).collect(Collectors.toSet());
        for(String element: array2){
            if(elements.contains(element)){
                return true;
            }
        }

        return false;
    }

    private static boolean isEmptyArray(String[] array){
        return Objects.isNull(array) || array.length == 0;
    }

    public static void main(String[] args) {
        System.out.println(existCommonElements(new String[]{"a","b", "c", "d"}, new String[]{"z","y","i"}));
        System.out.println(existCommonElements(new String[]{"a","b", "c", "d"}, new String[]{"z","b","c"}));
    }
}
