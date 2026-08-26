package com.sveta.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        MergeSort sort = new MergeSort();
        int[] nums = {9, 5, 3, 2, 8, 1, 0};
        int[] newNums = sort.sort(nums);

        int[] expected = {0, 1, 2, 3, 5, 8, 9};
        Assertions.assertArrayEquals(expected, newNums);
    }
}