/**
 * <a href=https://neerc.ifmo.ru/wiki/index.php?title=Двоичная_куча>куча</a>
 */

package com.sveta.collections.queue;

public class MyBinaryHeap {
    public int heapSize;
    public int[] heap;
    private int capacity;
    private boolean isMinHeap;

    public MyBinaryHeap(int capacity, boolean isMinHeap) {
        this.capacity = capacity;
        this.isMinHeap = isMinHeap;
        this.heapSize = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i + 1);
    }

    private int rightChild(int i) {
        return (2 * i + 2);
    }

    public void shiftDown(int i) {
        while (2 * i + 1 < heapSize) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;

            if (right < heapSize && heap[right] < heap[left]) {
                j = right;
            }

            if (heap[i] <= heap[j]) {
                break;
            }

            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
            i = j;
        }
    }

    public void shiftUp(int i) {
        while (heap[i] < heap[(i - 1) / 2]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    public void insert(int key) {
        heapSize = heapSize + 1;
        heap[heapSize - 1] = key;
        shiftUp(heapSize - 1);
    }

    public void merge(MyBinaryHeap a, MyBinaryHeap b) {
        for (int i = 0; i < b.heapSize; i++) {
            a.heap[a.heapSize] = b.heap[i];
            a.heapSize++;
        }
        a.heapify();
    }

    public void heapify() {
        for (int i = (heapSize - 2) / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int extractRoot() {
        int root = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        shiftDown(0);
        return root;
    }

    public int getRoot() {
        return heap[0];
    }

    public String iterator() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < heapSize; i++){
            buffer.append(heap[i]);
        }
        return buffer.toString();
    }

    public boolean isContain(int j){
        for (int i = 0; i < heapSize; i++){
            if(heap[i] == j){
                return true;
            }
        }
        return false;
    }
}
