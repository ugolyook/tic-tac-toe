package com.sveta.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0] * p[0] + p[1]*p[1]));
        return Arrays.copyOfRange(points,0,k);
    }
}
