package com.sveta.collections.map;

import com.sveta.collections.list.MyArrayList;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {
    private static final int CAPACITY = 16;
    private Node<K, V>[] table;
    int size = 0;

    public MyHashMap() {
        table = (Node<K, V>[]) new Node[CAPACITY];
    }

    public static class Node<K, V> implements Entry<K, V>, Iterable<Node<K, V>> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.value = value;
            this.next = next;
            this.key = key;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override //O(1)
        public K getKey() {
            return key;
        }

        @Override //O(1)
        public V getValue() {
            return value;
        }

        @Override //O(1)
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Map.Entry<?, ?> entry)) return false;

            return Objects.equals(key, entry.getKey()) &&
                    Objects.equals(value, entry.getValue());
        }

        @Override
        public int hashCode() { //O(1)
            return key.hashCode() ^ value.hashCode();
        }

        @Override //O(1)
        public Iterator<Node<K, V>> iterator() {
            return new MyIterator();
        }

        private class MyIterator implements Iterator<Node<K, V>> {
            Node<K, V> current = Node.this;

            public MyIterator() {
            }

            @Override
            public boolean hasNext() { //O(1)
                return current != null;
            }

            @Override
            public Node<K, V> next() { //O(1)
                if (current == null) {
                    throw new NoSuchElementException();
                }
                Node<K, V> temp = current;
                current = current.next;
                return temp;
            }
        }
    }

    private int hash(Object key) { //O(1)
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public int size() { //O(1)
        return size;
    }

    @Override //O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override //O(n), O(1)
    public boolean containsKey(Object key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if (Objects.equals(key, current.key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private int getIndex(Object key) {//O(1)
        return hash(key) % table.length;
    }

    @Override//O(n),
    public boolean containsValue(Object value) {
        if (table == null || size == 0) {
            return false;
        }

        for (Node<K, V> node : table) {
            Node<K, V> current = node;
            while (current != null) {
                if (Objects.equals(value, current.value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override //O(n),O(1)
    public V get(Object key) {
        if (isTableEmpty()) {
            return null;
        }

        int index = getIndex(key);
        var nodeByIndex = table[index];

        var foundNode = findByKey(key, nodeByIndex);
        return foundNode == null ? null : foundNode.value;
    }

    private Node<K, V> findByKey(Object key, Node<K, V> current) {//O(n)
        while (current != null) {
            if (Objects.equals(key, current.key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) { //O(n)
        if (table == null || table.length == 0) {
            table = (Node<K, V>[]) new Node[CAPACITY];
        }

        int index = getIndex(key);
        var current = table[index];

        while (current != null) {
            if (Objects.equals(key, current.key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }

        var newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;

        if (size > table.length * 2) {
            resize();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() { //O(n)
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];

        for (Node<K, V> node : table) {
            Node<K, V> current = node;
            while (current != null) {
                Node<K, V> next = current.next;

                int newIndex = hash(current.key) % newCapacity;

                current.next = newTable[newIndex];
                newTable[newIndex] = current;

                current = next;
            }
        }

        table = newTable;
    }

    @Override
    public V remove(Object key) {//O(n),O(1)
        if (isTableEmpty()) {
            return null;
        }

        int index = getIndex(key);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (Objects.equals(key, current.key)) {
                V oldValue = current.value;

                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                current.value = null;
                current.next = null;

                return oldValue;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override//O(1)
    public void clear() {
        if (table != null) {
            Arrays.fill(table, null);
        }
        size = 0;
    }

    private boolean isTableEmpty() {//O(1)
        return (table == null || table.length == 0 || size == 0);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {//O(n)
        if (m.isEmpty()) return;
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Set<K> keySet() {//O(n)
        Set<K> keys = new HashSet<>();
        for (Node<K, V> nodeByIndex : table) {
            if (nodeByIndex != null) {
                for (Node<K, V> node : nodeByIndex) {
                    keys.add(node.key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {//O(n)
        List<V> values = new MyArrayList<>();
        for (Node<K, V> node : table) {
            Node<K, V> current = node;
            while (current != null) {
                values.add(current.value);
                current = current.next;
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {//O(n)
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Node<K, V> bucket : table) {
            Node<K, V> current = bucket;
            while (current != null) {
                entries.add(current);
                current = current.next;
            }
        }
        return entries;
    }
}
