package com.sveta.test;

import com.sveta.exercise.Anagram;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AnagramTest {

    @Test
    public void isAnagram() {
        //given
        String s = "anagram";
        String t = "margana";
        Anagram anagram = new Anagram();

        //when
        boolean result = anagram.isAnagram(s,t);

        //than
        Assertions.assertTrue(result);
    }
}