package ru.gb.trishkin.lesson3.mydequeue;


import ru.gb.trishkin.lesson3.myqueue.QueueImpl;

public class DeQueueImpl<E> extends QueueImpl<E> implements DeQueue<E> {

    public DeQueueImpl(int maxSize) {
        super(maxSize);
        head = DEFAULT_TAIL;
        tail = data.length;
    }

    @Override
    public boolean isFull() {
        return head + 1 == tail;
    }

    @Override
    public boolean insertFirst(E value) {
        if (isFull()) {
            return false;
        }

//        if (tail == data.length - 1) {
//            tail = DEFAULT_TAIL;
//        }

        data[++head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(E value) {
        if (isFull()) {
            return false;
        }

//        if (tail == data.length - 1) {
//            tail = DEFAULT_TAIL;
//        }

        data[--tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        E removedValue = data[--head];
        size--;
        return removedValue;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }

        E removedValue = data[tail++];
        size--;
        if(tail == data.length){
            tail = data.length - 1;
        }
        return removedValue;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return data[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return data[tail];
    }
}
