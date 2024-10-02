package org.algorithms.letcode.dynamic_programing;

import java.util.HashMap;
import java.util.Map;
/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps

 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step

 * https://leetcode.com/problems/climbing-stairs/description/
 * */
public class ClimbingStairs {
    private int numSteps;
    private Map<Integer, Integer> meotization = new HashMap<>();

    public int climbStairs(int n) {
        if(meotization.containsKey(n)){
            return meotization.get(n);
        }

        //Base case 1: The last step is greater than the staircase, 0 because is not a valid path
        if(n < 0)
            return 0;
        //Base case 2: Exist an exact match of steps, so, return 1 because is a valid path
        if(n == 0)
            return 1;

        //Recursive case: Result should be equals to sum all possible valid paths of 1,2 and 3 steps
        numSteps = climbStairs(n-1)+climbStairs(n-2);

        meotization.put(n, numSteps);

        return numSteps;
    }
}
