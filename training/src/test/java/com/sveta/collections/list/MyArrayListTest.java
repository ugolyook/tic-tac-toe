package com.sveta.collections.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void isEmpty_listEmpty_expectTrue() {
        // given
        List<String> list = new MyArrayList();

        // when
        boolean result = list.isEmpty();

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void isEmpty_listIsNotEmpty_expectFalse() {
        // given
        List<String> list = new MyArrayList();
        list.add("Potato");

        // when
        boolean result = list.isEmpty();

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void size_sizeZero_expectedZero() {
        // given
        List<String> list = new MyArrayList();

        // when
        int result = list.size();

        // then
        Assertions.assertEquals(0, result);
    }

    @Test
    void size_sizeOne_expectedOne() {
        // given
        List<String> list = new MyArrayList();
        list.add("Cat");

        // when
        int result = list.size();

        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    void contains_listContainsElement_expectedTrue() {
        // given
        List<String> list = new MyArrayList();
        list.add("Cat");

        // when
        boolean result = list.contains("Cat");

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void contains_listIsNotContainsElement_expectedFalse() {
        // given
        List<String> list = new MyArrayList();
        list.add("Dog");

        // when
        boolean result = list.contains("Cat");

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void add_listAddElement_expectedTrue() {
        // given
        List<String> list = new MyArrayList();

        // when
        list.add("Dog");

        // then
        boolean result = list.contains("Dog");
        Assertions.assertTrue(result);
    }

    @Test
    void remove_listRemoveElement_expectedTrue() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        boolean result = list.remove("Frog");

        // then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, list.size());
        Assertions.assertFalse(list.contains("Frog"));
    }

    @Test
    void remove_listNotFoundElement_expectedFalse() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        boolean result = list.remove("Fro");

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void clear_listIsClear_expectedZero() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        list.clear();

        // then
        int result = list.size();
        Assertions.assertEquals(0, result);
    }

    @Test
    void get_indexOutOfBond_expectException() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        var exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(2)
        );

        // then
        assertEquals("Index out of range: 2", exception.getMessage());
    }

    @Test
    void get_existingIndex_expectElement() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        String result = list.get(0);

        // then
        Assertions.assertEquals("Frog", result);
    }

    @Test
    void get_negativeIndex_expectException() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        var exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(-1)
        );

        // then
        assertEquals("Index out of range: -1", exception.getMessage());
    }

    @Test
    void set_setNewElement_expectPreviousElement() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        String result = list.set(0, "Cat");

        // then
        Assertions.assertEquals("Frog", result);
        Assertions.assertEquals("Cat", list.getFirst());
    }

    @Test
    void set_elementIndexOutOfBond_expectException() {
        // given
        List<String> list = new MyArrayList();

        // when
        var exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.set(10, "Frog")
        );

        // then
        assertEquals("Index out of range: 10", exception.getMessage());
    }

    @Test
    void add_addElementOutOfRange_expectException() {
        // given
        List<String> list = new MyArrayList();

        // when
        var exception = assertThrows(IndexOutOfBoundsException.class,
                () -> list.add(100, "Frog")
        );

        // then
        assertEquals("Index out of range: 100", exception.getMessage());
    }

    @Test
    void add_addElement_expectElement() {
        // given
        List<String> list = new MyArrayList();
        list.add("Cat");
        list.add("Dog");
        list.add("Frog");

        // when
        list.add(1, "Frog");

        // then
        int result = list.size();
        Assertions.assertEquals(4, result);
    }

    @Test
    void add_elementIndexOutOfBond_expectException() {
        // given
        List<String> list = new MyArrayList();

        // when
        var exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(-10, "Frog")
        );

        // then
        assertEquals("Index out of range: -10", exception.getMessage());
    }

    @Test
    void testAdd_testCapacity_expectCapacity() {
        // given
        List<String> list = new MyArrayList();
        list.add("Fro");

        // when
        list.add(1, "Frog");

        // then
        int result = list.size();
        Assertions.assertEquals(2, result);
    }

    @Test
    void testRemove_removeElement_expectPrevElement() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        String result = list.remove(0);

        // then
        Assertions.assertEquals("Frog", result);
    }

    @Test
    void testRemove_elementIndexOutOfBond_expectException() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        var exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.remove(10)
        );

        // then
        assertEquals("Index out of range: 10", exception.getMessage());
    }

    @Test
    void indexOf_findElementByName_expectIndex() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frogs");
        list.add("Frog");
        list.add("Frogg");
        list.add("Frog");

        // when
        int result = list.indexOf("Frog");

        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    void indexOf_notFindElementByName_expectMinusOne() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");

        // when
        int result = list.indexOf("Fro");

        // then
        Assertions.assertEquals(-1, result);
    }

    @Test
    void lastIndexOf_returnLastIndexOfElement_expectIndex() {
        // given
        List<String> list = new MyArrayList();
        list.add("Frog");
        list.add("Frogg");
        list.add("Frog");
        list.add("Fro");

        // when
        int result = list.lastIndexOf("Frog");

        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void lastIndexOf_notFindLastIndexOfElement_expectMinusOne() {
        // given
        List<String> list = new MyArrayList();
        list.add("Rabbit");

        // when
        int result = list.lastIndexOf("Frog");

        // then
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testToString_returnString_expectString() {
        // given
        List<String> list = new MyArrayList();
        list.add("Hello");
        list.add("World");

        // when
        String result = list.toString();

        // then
        Assertions.assertEquals("Hello\nWorld\n", result);
    }

    @Test
    void toArray_transformFromListToArray_expectArray() {
        // given
        List<String> list = new MyArrayList();
        list.add("Hello");
        list.add("World");

        // when
        Object[] result = list.toArray();

        // then
        assertEquals(2, result.length);
        assertEquals("Hello", result[0]);
        assertEquals("World", result[1]);
    }

    @Test
    void testToArray_transformFromListToArray_expectArray() {
        // given
        List<String> list = new MyArrayList();
        list.add("Hello");
        list.add("World");

        // when
        String[] result = list.toArray(new String[0]);

        // then
        assertEquals(2, result.length);
        assertEquals("Hello", result[0]);
        assertEquals("World", result[1]);
    }

    @Test
    void containsAll_listContainsAllElement_expectTrue() {
        // given
        List<String> list = new MyArrayList();
        list.add("Hello");
        list.add("World");
        list.add("Warms");
        Collection<String> elementsToCheck = List.of("Hello", "World");

        // when
        boolean actual = list.containsAll(elementsToCheck);

        // then
        assertTrue(actual);
    }

    @Test
    void containsAll_listNotContainsAllElement_expectFalse() {
        // given
        List<String> list = new MyArrayList();
        list.add("Hello");
        list.add("World");
        Collection<String> elementsToCheck = List.of("Hello", "Java");

        // when
        boolean actual = list.containsAll(elementsToCheck);

        // then
        assertFalse(actual);
    }

    @Test
    void addAll_addElements_expectElementsAdded() {
        // given
        List<String> list = new MyArrayList<>();
        List<String> input = List.of("A", "B", "C");

        // when
        boolean result = list.addAll(input);

        // then
        Assertions.assertTrue(result);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("B", list.get(1));
        Assertions.assertEquals("C", list.get(2));
    }

    @Test
    void addAll_emptyCollection_expectFalse() {
        // given
        List<String> list = new MyArrayList<>();
        List<String> empty = List.of();

        // when
        boolean result = list.addAll(empty);

        // then
        Assertions.assertFalse(result);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testAddAll_intoMiddle_expectTrue() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");
        list.add("D");

        // when
        boolean result = list.addAll(1, List.of("B", "C"));

        // then
        Assertions.assertTrue(result);
        Assertions.assertEquals(4, list.size());
        Assertions.assertArrayEquals(
                new Object[]{"A", "B", "C", "D"},
                list.toArray()
        );
    }

    @Test
    void addAll_emptyCollection_returnsFalse() {
        // given
        List<Integer> list = new MyArrayList<>();
        list.add(1);

        // when
        boolean result = list.addAll(0, List.of());

        // then
        Assertions.assertFalse(result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void subList_middleRange() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // when
        List<String> sub = list.subList(1, 3);

        // then
        Assertions.assertArrayEquals(
                new Object[]{"B", "C"},
                sub.toArray()
        );
    }

    @Test
    void subList_negativeFromIndex_throwException() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");

        // when
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.subList(-1, 1)
        );
    }

    @Test
    void subList_toIndexGreaterThanSize_throwException() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");

        // when
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.subList(0, 2)
        );
    }

    @Test
    void subList_fromGreaterThanTo_throwException() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");

        // when
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.subList(2, 1)
        );
    }

    @Test
    void iterator_nextElement_expectNextElement() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // when
        Iterator<String> iterator = list.iterator();
        iterator.next();

        // then
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertEquals("D", iterator.next());
        Assertions.assertThrows(NoSuchElementException.class,
                iterator::next
        );
        assertFalse(iterator.hasNext());
    }


    @Test
    void listIterator_nextElement_expectNextElement() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // when
        ListIterator<String> iterator = list.listIterator(1);
        iterator.next();

        // then
        assertEquals("C", iterator.next());
        assertEquals("D", iterator.next());
        Assertions.assertThrows(NoSuchElementException.class,
                iterator::next
        );
        assertFalse(iterator.hasNext());
    }

    @Test
    void listIterator_previousElement_expectPrevElement() {
        // given
        List<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // when
        ListIterator<String> iterator = list.listIterator(3);
        iterator.previous();

        // then
        assertEquals("B", iterator.previous());
        assertEquals("A", iterator.previous());
        Assertions.assertThrows(NoSuchElementException.class,
                iterator::previous
        );
        assertFalse(iterator.hasPrevious());
    }
}