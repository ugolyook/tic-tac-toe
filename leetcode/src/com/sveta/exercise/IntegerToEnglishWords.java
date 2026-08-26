package com.sveta.exercise;

import java.util.HashMap;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        HashMap map = new HashMap<>();
        map.put(0,"zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "tree");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        ///

        String numberStr = String.valueOf(num);
        char[] nums = numberStr.toCharArray();

        StringBuilder builder = new StringBuilder();

        if (nums.length >= 7) { //1234567  "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
            for (int i = nums.length; i > 0; i--) {

            }
        }

        if (nums.length >= 4) {//12345  "Twelve Thousand Three Hundred Forty Five"
            for (int i = nums.length; i > 0; i--) {

            }
        }

        if (nums.length <= 3) { //123  "One Hundred Twenty Three"
            for (int i = nums.length; i > 0; i--) {

            }
        }
        return numberStr;
    }
}
//число делить по 3 цифры, каждые 3 рассматривать по разному

