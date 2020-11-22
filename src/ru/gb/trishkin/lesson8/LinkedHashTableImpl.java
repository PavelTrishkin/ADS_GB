package ru.gb.trishkin.lesson8;

import java.util.LinkedList;

public class LinkedHashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final LinkedList<Item<K, V>>[] data;
    private int size;

    public LinkedHashTableImpl(int maxSize) {
        data = new LinkedList[maxSize];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);
        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        int listIndex = indexOf(key);

        return listIndex != -1 ? data[index].get(listIndex).getValue() : null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        int listIndex = indexOf(key);

        if (listIndex == -1){
            return null;
        }

        Item<K, V> temp = data[index].remove(listIndex);
        size--;
        return temp.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        int index = hash(key);

        LinkedList<Item<K, V>> items = data[index];
        for (int i = 0; i < items.size(); i++) {
            Item<K, V> item = items.get(i);
            if (item.getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }
}
