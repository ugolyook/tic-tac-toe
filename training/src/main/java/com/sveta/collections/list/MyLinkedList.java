package com.sveta.collections.list;

import java.lang.reflect.Array;
import java.util.*;

public class MyLinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, Node<T> next, T data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int capacity = 0;

    public MyLinkedList() {
    }

    @Override
    public int size() { //O(1)
        return capacity;
    }

    @Override
    public boolean isEmpty() { //O(1)
        return capacity == 0;
    }

    @Override
    public boolean contains(Object o) { //O(n)
        Node<T> current = first;
        if (o == null) {
            while (current != null) {
                if (current.data == null) {
                    return true;
                }
                current = current.next;
            }
        } else {
            while (current != null) {
                if (o.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) { // O(n)
        Node<T> current = first;
        while (current != null) {
            if (Objects.equals(o, current.data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    first = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    last = current.prev;
                }

                current.prev = null;
                current.next = null;
                current.data = null;

                capacity--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean add(T t) { //O(n)
        Node<T> newNode = new Node<>(last, null, t);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        capacity++;
        return true;
    }

    @Override
    public void clear() { //O(1)
        first = null;
        last = null;
        capacity = 0;
    }

    @Override
    public T get(int index) { //O(n)
        return getNode(index).data;
    }

    private Node<T> getNode(int index) { //O(n)
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        }
        return getCurrent(index);
    }

    private Node<T> getCurrent(int index) { //O(n)
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T set(int index, T element) { //O(n)
        Node<T> current = getNode(index);

        T prevCurrent = current.data;
        current.data = element;

        return prevCurrent;
    }

    @Override
    public void add(int index, T element) { //O(n)
        if (index == capacity) {
            Node<T> newNode = new Node<>(last, null, element);
            if (last == null) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
            capacity++;
            return;
        }

        if (index == 0) {
            Node<T> newNode = new Node<>(null, first, element);
            if (first != null) {
                first.prev = newNode;
            }
            first = newNode;
            capacity++;
            return;
        }

        Node<T> current = getNode(index);

        Node<T> prev = current.prev;
        Node<T> newNode = new Node<>(prev, current, element);

        prev.next = newNode;
        current.prev = newNode;

        capacity++;
    }

    @Override
    public T remove(int index) { //O(log n)
        Node<T> oldCurrent = getNode(index);
        remove(oldCurrent);

        return oldCurrent.data;
    }

    @Override
    public int indexOf(Object o) { //O(n)
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (o.equals(current.data)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {//O(n)
        Node<T> current = last;
        for (int i = capacity - 1; i >= 0; i--) {
            if (o.equals(current.data)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) { //O(n)

        if (c.isEmpty()) {
            return true;
        }

        if (isEmpty()) {
            return false;
        }

        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) { //O(n)
        for (T element : c) {
            add(element);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) { //O(n)
        Node<T> ignore = getNode(index);

        if (c.isEmpty()) {
            return false;
        }

        int currentIndex = index;
        for (T element : c) {
            add(currentIndex, element);
            currentIndex++;
        }
        return true;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) { //O(n)
        if (fromIndex < 0 || toIndex > capacity || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        MyLinkedList<T> subList = new MyLinkedList<>();
        Node<T> current = getNode(fromIndex);

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
        }
        return subList;
    }

    @Override
    public Object[] toArray() { //O(n)
        Object[] result = new Object[capacity];
        Node<T> current = first;
        int index = 0;

        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) { //O(n)
        if (a.length < capacity) {
            a = (T1[]) Array.newInstance(
                    a.getClass().getComponentType(), capacity
            );
        }

        Node<T> current = first;
        int index = 0;
        while (current != null) {
            a[index] = (T1) current.data;
            current = current.next;
            index++;
        }

        if (a.length > capacity) {
            a[capacity] = null;
        }

        return a;
    }

    @Override //not
    public boolean removeAll(Collection<?> c) { //O(n)
        if (c.isEmpty()) {
            return false;
        }

        boolean modified = false;
        for (Object element : c) {
            while (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override //not ///O(n)
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = first;

        while (current != null) {
            Node<T> next = current.next;

            if (!c.contains(current.data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    first = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    last = current.prev;
                }

                capacity--;
                modified = true;
            }

            current = next;
        }

        return modified;
    }

    @Override //not
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override //not
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override //not
    public Iterator<T> iterator() {
        return null;
    }
}
