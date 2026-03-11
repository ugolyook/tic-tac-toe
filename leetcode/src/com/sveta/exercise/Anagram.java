package com.sveta.exercise;

import java.util.Arrays;
import java.util.TreeSet;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (!lengthChecker(s, t)) return false;

        char[] firstString = s.toLowerCase().toCharArray();
        char[] secondString = t.toLowerCase().toCharArray();

        TreeSet<char[]> set = new TreeSet<>();

        set.add(firstString);
        set.add(secondString);

        if (set.size() == 1) {
            return false;
        }

        return Arrays.equals(firstString, secondString);
    }

    public boolean lengthChecker(String s, String t) {
        return s.length() == t.length();
    }
}

