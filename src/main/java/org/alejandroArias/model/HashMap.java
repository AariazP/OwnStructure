package org.alejandroArias.model;

import java.util.*;

public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    private int capacity;
    private float loadFactor;
    private Node<K, V>[] buckets;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(K key) {
        int h = key.hashCode();
        double a = 0.6180339887; // The golden ratio
        double frac = h * a - Math.floor(h * a);
        return (int) Math.floor(capacity * frac);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new Node<>(key, value, buckets[index]);
        buckets[index] = node;
        size++;
        if (size > capacity * loadFactor) {
            resize(capacity * 2);
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        Node<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        buckets = new Node[capacity];
        size = 0;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (int i = 0; i < buckets.length; i++) {
            Node<K, V> node = buckets[i];
            while (node != null) {
                keySet.add(node.key);
                node = node.next;
            }
        }
        return keySet;
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Node<K, V> bucket : buckets) {
            Node<K, V> node = bucket;
            while (node != null) {
                values.add(node.value);
                node = node.next;
            }
        }
        return values;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet = new HashSet<>();
        for (Node<K, V> bucket : buckets) {
            Node<K, V> node = bucket;
            while (node != null) {
                entrySet.add(new AbstractMap.SimpleEntry<>(node.key, node.value));
                node = node.next;
            }
        }
        return entrySet;
    }

    private void resize(int newCapacity) {
        Node<K, V>[] newBuckets = new Node[newCapacity];
        for (Node<K, V> bucket : buckets) {
            Node<K, V> node = bucket;
            while (node != null) {
                Node<K, V> next = node.next;
                int index = hash(node.key) % newCapacity;
                node.next = newBuckets[index];
                newBuckets[index] = node;
                node = next;
            }
        }
        buckets = newBuckets;
        capacity = newCapacity;
    }
}
