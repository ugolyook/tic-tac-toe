package com.sveta.exercise;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * <p>
 * <a href="https://leetcode.com/problems/valid-palindrome/description/">Leetcode</a>
 */

class Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        String result = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return result.equals(reverse(result));
    }

    public String reverse(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }
}


