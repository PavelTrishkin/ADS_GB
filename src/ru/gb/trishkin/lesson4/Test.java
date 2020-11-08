package ru.gb.trishkin.lesson4;

import ru.gb.trishkin.lesson3.myqueue.Queue;
import ru.gb.trishkin.lesson3.mystack.Stack;


public class Test {
    public static void main(String[] args) {
//        testLinkedList();
//        testQueue();
        testForEach();
    }

    private static void testForEach() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

//        linkedList.display();

        for(Integer value: linkedList) {
            System.out.println(value);
        }
        linkedList.display();
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertLast(5);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }

    private static void testStack() {
        Stack<Integer> stack = new LinkedStackImpl<>();

        System.out.println("Add value 1");
        stack.push(1);
        System.out.println("Add value 2");
        stack.push(2);
        System.out.println("Add value 3");
        stack.push(3);
        System.out.println("Add value 4");
        stack.push(4);
        System.out.println("Add value 5");
        stack.push(5);
        System.out.println("Add value 6");
        stack.push(6);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueue<>(5);
        Queue<Integer> queue = new LinkedQueueImpl<>();
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
