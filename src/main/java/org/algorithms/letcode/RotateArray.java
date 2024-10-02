package org.algorithms.letcode;

import java.util.Arrays;

/**
 * 189. Rotate Array

 *Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]

 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] auxNums = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            auxNums[(k+i) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = auxNums[i];
        }

        Arrays.stream(nums).forEach(n -> System.out.print(n+","));
        System.out.println();
    }

    public static void main(String[] args) {
        RotateArray t = new RotateArray();

        t.rotate(new int[]{1,2,3,4,5,6,7}, 3);
        t.rotate(new int[]{1,2,3,4,5,6}, 4);
    }
}
