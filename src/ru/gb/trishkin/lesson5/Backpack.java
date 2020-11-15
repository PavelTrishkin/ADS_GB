package ru.gb.trishkin.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final int maxSize;

    private int bestPrice;
    private List<Item> itemList;

    public Backpack(int maxSize) {
        this.maxSize = maxSize;
    }

    private  int calcWeight(List<Item> items) {
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.getWeight();
        }
        return sumWeight;
    }

    private int calcPrice(List<Item> items) {
        int sumPrice = 0;
        for (Item item : items) {
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }

    private void bestSet(List<Item> items) {
        int sumPrice = calcPrice(items);
        int sumWeight = calcWeight(items);
        if (sumWeight <= maxSize && (itemList == null || sumPrice > bestPrice)) {
            itemList = items;
            bestPrice = sumPrice;
        }
    }

    public List<Item> getBestSet() {
        return itemList;
    }

    public void calcBestSet(List<Item> items) {
        if (items.isEmpty()) {
            return;
        }

        bestSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> copiedItems = new ArrayList<>(items);
            copiedItems.remove(i);
            calcBestSet(copiedItems);
        }
    }

    public int getBestPrice() {
        return bestPrice;
    }

}
