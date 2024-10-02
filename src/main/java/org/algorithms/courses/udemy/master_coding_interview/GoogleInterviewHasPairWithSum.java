package org.algorithms.courses.udemy.master_coding_interview;

import java.util.HashSet;
import java.util.Set;

/*
 * Data Structure and Algorithms
 *
 * Section 4: How to solve coding problems
 *  59. Review Google Interview
 *
 * Find if two arrays contains common elements
 * */
public class GoogleInterviewHasPairWithSum {
    private static boolean hasPairWithSum(Integer[] arr, Integer sum){
        Set<Integer> complement = new HashSet<>();

        for (Integer value : arr){
            if(complement.contains(value)){
                return true;
            }else if(sum >= value) {
                complement.add(sum-value);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new Integer[]{10, 20, 4, 12}, 30));
        System.out.println(hasPairWithSum(new Integer[]{10, 20, 4, 12}, 34));
    }
}
