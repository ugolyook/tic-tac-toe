package com.sveta.exercise;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) < nums.length && nums[i] + nums[i + 1] == target) {
                int j = i + 1;
                answer[0] = i;
                answer[1] = j;
            }
        }
        return answer;
    }
}
