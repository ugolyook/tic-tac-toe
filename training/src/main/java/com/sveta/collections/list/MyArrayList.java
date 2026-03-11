package com.sveta.collections.list;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    public T[] array;
    int capacity = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(T[] array) {
        this.array = array;
        this.capacity = array.length;
    }

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override //1
    public int size() {
        return capacity;
    }

    @Override //1
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override //1
    public boolean contains(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (o == null && array[i] == null) return true;
            if (o != null && o.equals(array[i])) return true;
        }
        return false;
    }

    @Override //1
    public boolean add(T s) {
        grow(1);
        array[capacity] = s;
        capacity++;
        return true;
    }

    private void grow(int needed) {
        if (capacity + needed > array.length) {
            int newCapacity = Math.max(array.length * 2, capacity + needed);
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, capacity);
            array = newArray;
        }
    }

    @Override //1
    public boolean remove(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (o == null && array[i] == null || o != null && o.equals(array[i])) {
                for (int j = i; j < capacity - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[capacity - 1] = null;
                capacity--;
                return true;
            }
        }
        return false;
    }

    @Override //1
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        capacity = 0;
    }

    @Override //1
    public T get(int index) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        return array[index];
    }

    @Override //1
    public T set(int index, T element) {
        T prevElement = get(index);
        array[index] = element;
        return prevElement;
    }

    @Override //1
    public void add(int index, T element) {
        if (index < 0 || index > capacity)
            throw new IndexOutOfBoundsException(index);

        grow(index);
        shift(index);
        array[index] = element;
        capacity++;
    }

    private void shift(int index) {
        for (int i = capacity; i > index; i--) {
            array[i] = array[i - 1];
        }
    }

    @Override //1
    public T remove(int index) {
        T prevElement = get(index);
        shift(index);
        capacity--;
        return prevElement;
    }

    @Override //1
    public int indexOf(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (o == array[i]) return i;
        }
        return -1;
    }

    @Override //1
    public int lastIndexOf(Object o) {
        for (int i = capacity; i > 0; i--) {
            if (o == array[i]) return i;
        }
        return -1;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            buffer.append(array[i]);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[capacity];
        System.arraycopy(array, 0, result, 0, capacity);
        return result;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < capacity) {
            return (E[]) Arrays.copyOf(array, capacity, a.getClass());
        }

        System.arraycopy(array, 0, a, 0, capacity);

        if (a.length > capacity) {
            a[capacity] = null;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        T ignore = get(index);
        if (c == null) {
            throw new NullPointerException("Collection can't be null");
        }

        if (c.isEmpty()) {
            return false;
        }
        grow(c.size());

        int currentIndex = index;
        for (T element : c) {
            add(currentIndex, element);
            currentIndex++;
        }
        return true;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > capacity || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        int newArraySize = toIndex - fromIndex;
        T[] newArray = (T[]) new Object[newArraySize];
        System.arraycopy(array, fromIndex, newArray, 0, newArraySize);

        return new <T>MyArrayList(newArray);
    }

    @Override //not
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override //not
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override//not
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        T ignore = get(index);

        return new ListIterator<T>() {
            private int cursor = index;
            private int lastReturned = -1;
            private boolean canSetOrRemove = false;

            @Override
            public boolean hasNext() {
                return cursor < capacity;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                lastReturned = cursor;
                canSetOrRemove = true;
                cursor++;
                return array[lastReturned];
            }

            @Override
            public boolean hasPrevious() {
                return cursor > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                cursor--;
                lastReturned = cursor;
                canSetOrRemove = true;
                return array[lastReturned];
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T t) {
                if (!canSetOrRemove) {
                    throw new IllegalStateException();
                }
                array[lastReturned] = t;
            }

            @Override
            public void add(T t) {
                MyArrayList.this.add(cursor + 1, t);
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = 0;

        public MyIterator() {
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(currentIndex++);
        }
    }
}
