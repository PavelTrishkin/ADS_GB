package ru.gb.trishkin.lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestArray {
    private static final int MAX_CAPACITY = 10000;
    private static final int MAX_VALUE = 10000;
    public static void main(String[] args) {

        Array<Integer> array = new ArrayImpl<>(MAX_CAPACITY);
        addArr(array);
        array.display();

        System.out.println("************************** START TEST ***************************");
        System.out.println("************************** SORT BUBBLE **************************");
        timeDimensionBubble(array);
        System.out.println("************************** SORT INSERT **************************");
        timeDimensionInsert(array);
        System.out.println("************************** SORT SELECT **************************");
        timeDimensionSelect(array);
    }

    private static void addArr(Array<Integer> array){
        Random random = new Random();
        for (int i = 0; i < MAX_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            array.add(value);
        }
    }

    private static void timeDimensionBubble(Array<Integer> array){
        Array<Integer> test = array.copy();
        long timeStart = System.nanoTime();
        test.sortBubble();
        long timeFinish = System.nanoTime();
        System.out.println("Execution time: " + TimeUnit.MILLISECONDS.toMillis(timeFinish - timeStart));
    }

    private static void timeDimensionInsert(Array<Integer> array){
        Array<Integer> test = array.copy();
        long timeStart = System.nanoTime();
        test.sortInsert();
        long timeFinish = System.nanoTime();

        System.out.println("Execution time: " + TimeUnit.MILLISECONDS.toMillis(timeFinish - timeStart));
    }

    private static void timeDimensionSelect(Array<Integer> array){
        Array<Integer> test = array.copy();
        long timeStart = System.nanoTime();
        test.sortSelect();
        long timeFinish = System.nanoTime();

        System.out.println("Execution time: " + TimeUnit.MILLISECONDS.toMillis(timeFinish - timeStart));
    }
}
