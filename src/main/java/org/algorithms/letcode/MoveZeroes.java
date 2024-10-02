package org.algorithms.letcode;

/**
* 283. Move Zeroes

* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Note that you must do this in-place without making a copy of the array.

* Example 1:
* Input: nums = [0,1,0,3,12]
* Output: [1,3,12,0,0]

* Example 2:
* Input: nums = [0]
* Output: [0]
* https://leetcode.com/problems/move-zeroes/description/
* */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int numOfZeros = 0;
        int num;

        while(index < nums.length){
            num = nums[index];

            if(num == 0){
                numOfZeros++;
            }else if(numOfZeros > 0){
                nums[index-numOfZeros]=num;
                nums[index]=0;
            }

            index ++;
        }
    }
}
