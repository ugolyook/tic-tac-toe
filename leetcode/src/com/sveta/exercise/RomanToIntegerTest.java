package com.sveta.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    @Test
    void romanToInt() {
        //give
        RomanToInteger roman = new RomanToInteger();

        Assertions.assertEquals(3,roman.romanToInt("III"));
        Assertions.assertEquals(58,roman.romanToInt("LVIII"));
        Assertions.assertEquals(1994,roman.romanToInt("MCMXCIV"));
    }
}