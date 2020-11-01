package ru.gb.trishkin.lesson3;

import ru.gb.trishkin.lesson3.mydequeue.DeQueue;
import ru.gb.trishkin.lesson3.mydequeue.DeQueueImpl;
import ru.gb.trishkin.lesson3.myqueue.Queue;
import ru.gb.trishkin.lesson3.myqueue.QueueImpl;
import ru.gb.trishkin.lesson3.mystack.Stack;
import ru.gb.trishkin.lesson3.mystack.StackImpl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HomeWork {

    private final static String testString = "This text for test";

    public static void main(String[] args) {
        DeQueue<Integer> deQueue = new DeQueueImpl<>(5);

        System.out.println(deQueue.insertLast(5));
        System.out.println(deQueue.insertLast(2));
        System.out.println(deQueue.insertFirst(1));
        System.out.println(deQueue.insertFirst(4));
        System.out.println(deQueue.insertFirst(6));
        System.out.println(deQueue.insertFirst(7));
        System.out.println("Removed: " + deQueue.removeLast());
        System.out.println("Removed: " + deQueue.removeLast());
        System.out.println("Removed: " + deQueue.removeLast());
        System.out.println("Size: " + deQueue.size());
        System.out.println("First: " + deQueue.peekFirst());
        System.out.println("Last: " + deQueue.peekLast());


//        flippingLine(testString);
//
//        Queue<Integer> queue = new QueueImpl<>(9);
//        System.out.println("Add to queue 4: " + queue.insert(4));
//        System.out.println("Add to queue 8: " + queue.insert(8));
//        System.out.println("Add to queue 15: " + queue.insert(15));
//        System.out.println("Add to queue 5: " + queue.insert(5));
//        System.out.println("Add to queue 35: " + queue.insert(35));
//        System.out.println("Add to queue 8: " + queue.insert(8));
//        System.out.println("Add to queue 0: " + queue.insert(0));
//        System.out.println("Add to queue 79: " + queue.insert(79));
//        System.out.println("Add to queue 13: " + queue.insert(13));
//        System.out.println("Add to queue 1: " + queue.insert(1));
//
//        System.out.println("Queue peek: " + queue.peekHead());
//        System.out.println("Queue size: " + queue.size());
//        System.out.println("Queue is full: " + queue.isFull());
//
//        while (!queue.isEmpty()) {
//            System.out.print(queue.remove() + " ");
//        }
    }

    private static void flippingLine(String text){
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int index = 0; index < text.length(); index++) {
            stack.push(text.charAt(index));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

}
