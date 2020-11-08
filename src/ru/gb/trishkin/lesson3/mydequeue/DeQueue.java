package ru.gb.trishkin.lesson3.mydequeue;

import ru.gb.trishkin.lesson3.myqueue.Queue;


public interface DeQueue<E> extends Queue<E> {
    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}
