package com.sveta.collections.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashSetTest {
    private MyHashSet<String> set;

    @BeforeEach
    void setUp() {
        set = new MyHashSet<>();
    }

    @Test
    void size_addElement_expectSize() {
        //given
        set.add("Frog");
        set.add("Frodo");

        //when
        int result = set.size();

        //then
        Assertions.assertEquals(2,result);
    }

    @Test
    void isEmpty_addElement_expectFalse() {
        //given
        set.add("Frog");
        set.add("Frodo");

        //then
        Assertions.assertFalse(set.isEmpty());
    }

    @Test
    void contains_containsElement_expectTrue() {
        //given
        set.add("Frog");
        set.add("Frodo");

        //then
        Assertions.assertTrue(set.contains("Frodo"));
    }

    @Test
    void remove() {
        //given
        set.add("Frog");
        set.add("Frodo");

        //when
        boolean result = set.remove("Frodo");

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void clear() {
        //given
        set.add("Frog");
        set.add("Frodo");

        //when
        set.clear();

        //then
        Assertions.assertEquals(0,set.size());
    }
}