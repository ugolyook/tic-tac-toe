package com.sveta.collections.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void size_sizeZero_expectedZero() {
        // when
        int result = map.size();

        // then
        Assertions.assertEquals(0, result);
    }

    @Test
    void size_sizeOne_expectedOne() {
        // given
        map.put("Cat", 2);

        // when
        int result = map.size();

        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    void isEmpty_mapEmpty_expectTrue() {
        // when
        boolean result = map.isEmpty();

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void isEmpty_mapIsNotEmpty_expectFalse() {
        // given
        map.put("Potato", 2);

        // when
        boolean result = map.isEmpty();

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void containsKey_containKey_expectTrue() {
        // given
        map.put("Pot", 3);
        map.put("Fish", 5);
        map.put("Potato", 2);
        map.put("French", 9);

        // when
        boolean result = map.containsKey("Potato");

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void containsKey_isNotContainKey_expectFalse() {
        // given
        map.put("Potato", 2);
        map.put("Potter", 5);

        // when
        boolean result = map.containsKey("Pot");

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void containsValue_containValue_expectTrue() {
        // given
        map.put("Potato", 2);

        // when
        boolean result = map.containsValue(2);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void containsValue_tableNull_expectFalse() {
        // when
        boolean result = map.containsValue(2);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void containsValue_isNotContainValue_expectFalse() {
        // given
        map.put("Potato", 2);

        // when
        boolean result = map.containsValue(3);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void get_getValue_expectValue() {
        // given
        map.put("Pot", 4);
        map.put("Potato", 2);
        map.put("Harry", 6);

        // when
        int result = map.get("Potato");

        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void get_isNotGetValue_expectNull() {
        // when
        Integer result = map.get("pot");

        // then
        assertNull(result);
    }

    @Test
    void put_putElement_expectNull() {
        // when
        Integer result = map.put("Potato", 2);

        // then
        assertNull(result);
    }

    @Test
    void put_changeElement_expectOldElement() {
        // given
        map.put("Pot", 5);
        map.put("Potato", 2);

        // when
        Integer result = map.put("Potato", 3);

        // then
        Assertions.assertEquals(2, result);
        Assertions.assertEquals(2, map.size());
    }

    @Test
    void remove_removeElement_expectOldValue() {
        // given
        map.put("Pot", 4);
        map.put("Potato", 2);
        map.put("Frog", 2);

        // when
        int result = map.remove("Potato");

        // then
        Assertions.assertEquals(2, result);
        Assertions.assertEquals(2, map.size());
    }

    @Test
    void remove_tableIsEmpty_expectNull() {
        // when
        Integer result = map.remove("Potato");

        // then
        assertNull(result);
    }

    @Test
    void remove_noElement_expectNull() {
        // given
        map.put("Potato", 2);
        map.put("Frog", 2);

        // when
        Integer result = map.remove("Pot");

        // then
        assertNull(result);
        Assertions.assertEquals(2, map.size());
    }

    @Test
    void clear_clearElements_expectNull() {
        // given
        map.put("Potato", 2);
        map.put("Frog", 2);

        // when
        map.clear();

        // then
        Assertions.assertEquals(0, map.size());
    }

    @Test
    void putAll_emptyMap_noChanges() {
        // given
        map.put("one", 1);
        map.put("two", 2);
        Map<String, Integer> emptyMap = new HashMap<>();

        // when
        map.putAll(emptyMap);

        // then
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals(1, map.get("one"));
        Assertions.assertEquals(2, map.get("two"));
        Assertions.assertNull(map.get("three"));
    }

    @Test
    void putAll_mapWithNewKeys_addsAllElements() {
        // given
        map.put("one", 1);

        Map<String, Integer> other = new HashMap<>();
        other.put("two", 2);
        other.put("three", 3);

        // when
        map.putAll(other);

        // then
        Assertions.assertEquals(3, map.size());
        Assertions.assertEquals(1, map.get("one"));
        Assertions.assertEquals(2, map.get("two"));
        Assertions.assertEquals(3, map.get("three"));
    }

    @Test
    void keySet_setAllKeys_expectedKeys() {
        // given
        map.put("Frog", 1);
        map.put("Fro", 3);
        map.put("Frodo", 2);

        // when
        Set<String> result = map.keySet();

        // then
        Assertions.assertEquals(3, result.size());
        Assertions.assertTrue(result.contains("Frog"));
        Assertions.assertTrue(result.contains("Fro"));
        Assertions.assertTrue(result.contains("Frodo"));
    }

    @Test
    void values_setAllValues_expectedValues() {
        // given
        map.put("Frog", 1);
        map.put("Fro", 3);
        map.put("Frodo", 2);

        // when
        Collection<Integer> result = map.values();

        // then
        Assertions.assertEquals(3, result.size());
        Assertions.assertTrue(result.contains(1));
        Assertions.assertTrue(result.contains(3));
        Assertions.assertTrue(result.contains(2));
    }

    @Test
    void entrySet() {
        // given
        map.put("Frog", 1);
        map.put("Fro", 3);
        map.put("Frodo", 2);

        // when
        Set<Map.Entry<String, Integer>> result = map.entrySet();

        // then
        result.contains(Map.entry("Frog", 1));
        Assertions.assertTrue(result.contains(new MyHashMap.Node<>("Frog", 1)));
        Assertions.assertTrue(result.contains(new MyHashMap.Node<>("Fro", 3)));
        Assertions.assertTrue(result.contains(Map.entry("Frodo", 2)));
    }
}