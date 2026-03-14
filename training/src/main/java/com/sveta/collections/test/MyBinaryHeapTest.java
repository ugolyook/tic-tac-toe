package com.sveta.collections.test;

import com.sveta.collections.queue.MyBinaryHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MyBinaryHeapTest {

    @Test
    void shiftDown_shiftDown30_exceptArray() {
        //given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.heap = new int[]{30, 10, 15, 20, 25};
        heap.heapSize = 5;

        //when
        heap.shiftDown(0);

        //then
        assertArrayEquals(new int[]{10, 20, 15, 30, 25}, heap.heap);
    }

    @Test
    void shiftUp_shiftUp5_exceptArray() {
        //given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.heap = new int[]{10, 20, 15, 30, 5};
        heap.heapSize = 5;

        //when
        heap.shiftUp(4);

        //then
        assertArrayEquals(new int[]{5, 10, 15, 30, 20}, heap.heap);
    }

    @Test
    void insert_WhenAddingElement_ShouldIncreaseSize() {
        // given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.insert(5);
        heap.insert(10);
        heap.insert(15);
        heap.insert(20);
        heap.insert(25);

        // when
        heap.insert(8);

        // then
        Assertions.assertEquals(6, heap.heapSize);
    }

    @Test
    void merge_WhenHeapFull_ShouldThrowException() {
        // given
        MyBinaryHeap heapA = new MyBinaryHeap(3, true);
        heapA.insert(5);
        heapA.insert(10);
        heapA.insert(15);

        MyBinaryHeap heapB = new MyBinaryHeap(10, true);
        heapB.insert(20);

        // when
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            heapA.merge(heapA, heapB);
        });
    }

    @Test
    void extractRoot_getRoot_expectTrue() {
        //given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.heap = new int[]{10, 20, 15, 30, 5};
        heap.heapSize = 5;

        //when
        int result = heap.extractRoot();

        //then
        Assertions.assertEquals(10, result);
        Assertions.assertEquals(4, heap.heapSize);

    }

    @Test
    void getRoot_get10_expectParent() {
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.heap = new int[]{10, 20, 15, 30, 5};
        heap.heapSize = 5;

        //when
        int result = heap.getRoot();

        //then
        Assertions.assertEquals(10, result);
    }

    @Test
    void iterator_WithSingleElement_ShouldReturnElementAsString() {
        // given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.insert(5);

        // when
        String result = heap.iterator();

        // then
        Assertions.assertEquals("5", result);
    }

    @Test
    void isContain_heapContainsElement_expectTrue() {
        //given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.heap = new int[]{10, 20, 15, 30, 5};
        heap.heapSize = 5;

        //when
        boolean result = heap.isContain(20);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void isContain_heapNotContainsElement_expectFalse() {
        //given
        MyBinaryHeap heap = new MyBinaryHeap(10, true);
        heap.heap = new int[]{10, 20, 15, 30, 5};
        heap.heapSize = 5;

        //when
        boolean result = heap.isContain(40);

        //then
        Assertions.assertFalse(result);
    }
}