package ru.gb.trishkin.lesson3.mydequeue;

import ru.gb.trishkin.lesson3.myqueue.Queue;


public interface DeQueue<E> extends Queue<E> {
    boolean insertFirst(E value);

    boolean insertLast(E value);

    E removeFirst();

    E removeLast();

    E peekFirst();

    E peekLast();
}
