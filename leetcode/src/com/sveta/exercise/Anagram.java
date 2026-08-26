package com.sveta.exercise;

import java.util.HashMap;
//Input: s = "anagram", t = "nagaram"

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (!lengthChecker(s, t)) return false;

        char[] firstString = s.toLowerCase().toCharArray();
        char[] secondString = t.toLowerCase().toCharArray();

        HashMap<String, Integer> map = new HashMap<>();

        for (char c : firstString) {
            String key = String.valueOf(c);
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
        }

        for (char c : secondString) {
            String key = String.valueOf(c);
            int count = map.getOrDefault(key, 0);
            map.put(key, count - 1);
        }

        for (Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean lengthChecker(String s, String t) {
        return s.length() == t.length();
    }
}

