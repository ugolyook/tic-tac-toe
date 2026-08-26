/**
 * <a href=https://neerc.ifmo.ru/wiki/index.php?title=Двоичная_куча>куча</a>
 */

package com.sveta.collections.queue;

import java.util.*;

public class MyBinaryHeap<T extends Comparable<T>> implements Iterable<T> {
    private int heapSize;
    private final T[] heap;
    private final boolean isMinHeap;
    private Comparator<T> customComparator;

    public MyBinaryHeap(int capacity, boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
        this.heapSize = 0;
        this.heap = (T[]) new Comparable[capacity];
    }

    public MyBinaryHeap(Collection<T> collection) {
        this(collection, null);
    }

    public MyBinaryHeap(Collection<T> collection, Comparator<T> comparator) {
        this.customComparator = comparator;
        this.isMinHeap = true;
        this.heap = (T[]) new Comparable[collection.size()];
        this.heapSize = 0;
    }

    private boolean compare(T a, T b) {
        int cmp;
        if (customComparator != null) {
            cmp = customComparator.compare(a, b);
        } else {
            cmp = a.compareTo(b);
        }
        return isMinHeap ? cmp < 0 : cmp > 0;
    }

    private void shiftDown(int i) {
        while (getLeftChild(i) < heapSize) {
            int left = getLeftChild(i);
            int right = getRightChild(i);
            int smallest = left;

            if (right < heapSize && compare(heap[right], heap[left])) {
                smallest = right;
            }

            if (compare(heap[i], heap[smallest])) {
                break;
            }

            T temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            i = smallest;
        }
    }


    private void shiftUp(int i) {
        while (compare(heap[i], heap[getParent(i)])) {
            T temp = heap[i];
            heap[i] = heap[getParent(i)];
            heap[getParent(i)] = temp;
            i = getParent(i);
        }
    }

    public void insert(T key) {
        heapSize = heapSize + 1;
        heap[heapSize - 1] = key;
        shiftUp(heapSize - 1);
    }

    public void merge(MyBinaryHeap<T> b) {
        for (int i = 0; i < b.heapSize; i++) {
            heap[heapSize] = b.heap[i];
            heapSize++;
        }
        heapify();
    }

    public void heapify() {
        for (int i = (heapSize - 2) / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public T extractRoot() {
        T root = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        shiftDown(0);
        return root;
    }

    public T getRoot() {
        return heap[0];
    }

    public boolean isContain(T j) {
        for (int i = 0; i < heapSize; i++) {
            if (heap[i] == j) {
                return true;
            }
        }
        return false;
    }

    private static int getRightChild(int i) {
        return 2 * i + 2;
    }

    private static int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private static int getParent(int i) {
        return (i - 1) / 2;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(heap).iterator();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < heapSize; i++) {
            buffer.append(heap[i]);
        }
        return buffer.toString();
    }
}
