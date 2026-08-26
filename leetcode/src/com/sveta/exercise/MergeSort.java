package com.sveta.exercise;

public class MergeSort {
    public int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] right = new int[nums.length - mid];
        int[] left = new int[mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }

        for (int i = mid; i < nums.length; i++) {
            right[i - mid] = nums[i];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while(leftIndex < left.length){
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while(rightIndex < right.length){
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        return result;
    }
}
