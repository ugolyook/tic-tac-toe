package com.sveta.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidBracesTest {

    @Test
    void isValidBraces_true() {
        ValidBraces valid = new ValidBraces();
        var temp = valid.isValidBraces("[]");
        var temp1 = valid.isValidBraces("{}");
        var temp2 = valid.isValidBraces("()");

        Assertions.assertTrue(temp);
        Assertions.assertTrue(temp1);
        Assertions.assertTrue(temp2);
    }

    @Test
    void isValidBraces_false() {
        ValidBraces valid = new ValidBraces();
        var temp = valid.isValidBraces("[)");
        var temp1 = valid.isValidBraces("[{]}");
        var temp2 = valid.isValidBraces("{)");

        Assertions.assertFalse(temp);
        Assertions.assertFalse(temp1);
        Assertions.assertFalse(temp2);
    }
}