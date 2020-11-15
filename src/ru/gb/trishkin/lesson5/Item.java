package ru.gb.trishkin.lesson5;

import java.util.Objects;

public class Item {
    private final String title;
    private final int weight;
    private final int price;

    public Item(String title, int weight, int price) {
        this.title = title;
        this.weight = weight;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        if (weight != item.weight) return false;
        if (price != item.price) return false;
        return Objects.equals(title, item.title);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + weight;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
