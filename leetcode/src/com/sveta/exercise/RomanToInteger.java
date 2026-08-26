package com.sveta.exercise;
import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        char[] roman = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < roman.length; i++) {
            if ((i + 1) < roman.length && map.get(String.valueOf(roman[i])) < map.get(String.valueOf(roman[i + 1]))) {
                sum -= map.get(String.valueOf((roman[i])));
            } else {
                sum += map.get(String.valueOf((roman[i])));
            }
        }
        return sum;
    }
}
