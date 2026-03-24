package com.sveta.collections.test;

import com.sveta.collections.queue.MyBinaryHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MyBinaryHeapTest {

    @Test
    void insert_WhenAddingElement_ShouldIncreaseSize() {
        // given
        MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(10, true);
        heap.insert(5);
        heap.insert(10);
        heap.insert(15);
        heap.insert(20);
        heap.insert(25);

        // when
        heap.insert(8);

        // then
        Assertions.assertEquals(5, heap.getRoot());
    }

    @Test
    void merge_WhenHeapFull_ShouldThrowException() {
        // given
        MyBinaryHeap<Integer> heapA = new MyBinaryHeap<>(3, true);
        heapA.insert(5);
        heapA.insert(10);
        heapA.insert(15);

        MyBinaryHeap<Integer> heapB = new MyBinaryHeap<>(10, true);
        heapB.insert(20);

        // when
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            heapA.merge(heapB);
        });
    }

    @Test
    void extractRoot_getRoot_expectTrue() {
        //given
        MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(10, true);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(5);

        //when
        Integer result = heap.extractRoot();

        //then
        Assertions.assertEquals(10, heap.getRoot());
        Assertions.assertEquals(5, result);

    }

    @Test
    void getRoot_get10_expectParent() {
        MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(10, true);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(5);

        //when
        Integer result = heap.getRoot();

        //then
        Assertions.assertEquals(5, result);
    }

    @Test
    void iterator_WithSingleElement_ShouldReturnElementAsString() {
        // given
        MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(10, true);
        heap.insert(5);

        // when
        String result = heap.toString();

        // then
        Assertions.assertEquals("5", result);
    }

    @Test
    void isContain_heapContainsElement_expectTrue() {
        //given
        MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(10, true);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(5);

        //when
        boolean result = heap.isContain(20);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void isContain_heapNotContainsElement_expectFalse() {
        //given
        MyBinaryHeap<Integer> heap = new MyBinaryHeap<>(10, true);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(5);

        //when
        boolean result = heap.isContain(40);

        //then
        Assertions.assertFalse(result);
    }
}