package org.algorithms.letcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 1. Two Sum

 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice. *
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]

 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * https://leetcode.com/problems/two-sum/description/
 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        //complement, Index
        Map<Integer, Integer> complents = new HashMap<>();

        int num;
        for(int index =0; index < nums.length; index ++){
            num = nums[index];
            if(complents.containsKey(num)){
                return new int[]{complents.get(num), index};
            }else{
                complents.put(target-num, index);
            }
        }

        return null;
    }
}
