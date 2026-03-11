package com.sveta.collections.set;

import com.sveta.collections.map.MyHashMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<K> implements Set<K> {
    private static final Object PRESENT = new Object();
    private final MyHashMap<K, Object> map;

    public MyHashSet() {
        map = new MyHashMap<>();
    }

    @Override //O(1)
    public int size() {
        return map.size();
    }

    @Override//O(1)
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override //O(n), O(1)
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override //O(1)
    public Iterator<K> iterator() {
        return map.keySet().iterator();
    }

    @Override//O(n)
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override//O(n)
    public <T> T[] toArray(T[] a) {
        return map.keySet().toArray(a);
    }

    @Override//O(1)
    public boolean add(K k) {
        return map.put(k, PRESENT) == null;
    }

    @Override//O(n), O(1)
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override //O(n*n)
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override //O(n*n)
    public boolean addAll(Collection<? extends K> c) {
        boolean modified = false;
        for (K element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override//O(n*m)  O(m)
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<K> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override //O(n*m)  O(m)
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override //O(size)
    public void clear() {
        map.clear();
    }
}
