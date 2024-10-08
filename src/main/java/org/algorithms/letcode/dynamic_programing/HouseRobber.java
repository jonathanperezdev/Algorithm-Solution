package org.algorithms.letcode.dynamic_programing;

import java.util.HashMap;
import java.util.Map;

/**
 * 198. House Robber

 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.

 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.

 * https://leetcode.com/problems/house-robber/description/
 * */
public class HouseRobber {

    private int[] nums;
    private Map<Integer, Integer> memoization = new HashMap<>();
    public int rob(int[] nums) {
        this.nums = nums;
        return max(calculateStolen(nums.length-1, 0), calculateStolen(nums.length-2,0));
    }

    private int calculateStolen(int numCasa, int stolen){
        if(numCasa < 0){
            return 0;
        }

        if(numCasa < 2){
            return nums[numCasa];
        }

        if(memoization.containsKey(numCasa)){
            return memoization.get(numCasa);
        }

        stolen =+ nums[numCasa] + max(calculateStolen(numCasa - 2, stolen), calculateStolen(numCasa - 3, stolen));
        memoization.put(numCasa, stolen);

        return stolen;
    }

    private int max(int stolen1, int stolen2){
        if(stolen1 > stolen2){
            return stolen1;
        }else{
            return  stolen2;
        }
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{2,7,9,3,1}));
    }
}
