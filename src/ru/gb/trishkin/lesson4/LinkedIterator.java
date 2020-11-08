package ru.gb.trishkin.lesson4;

public interface LinkedIterator<E> {
    void reset();
    boolean atEnd();
    void nextLink();
    E getCurrent();
    E deleteCurrent();
    void insertAfter(E value);
    void insertBefore(E value);
}
