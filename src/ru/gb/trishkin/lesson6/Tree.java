package ru.gb.trishkin.lesson6;

import java.util.function.Consumer;

public interface Tree<E extends Comparable<? super E>> {

    boolean isBalanced();

    enum TraverseMode{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    int level();

    boolean add(E value);

    boolean contains(E value);

    boolean remove(E value);

    int size();

    boolean isEmpty();

    void display();

    void traverse(TraverseMode mode, Consumer<E> action);
}
