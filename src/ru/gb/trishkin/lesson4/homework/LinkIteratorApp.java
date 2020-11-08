package ru.gb.trishkin.lesson4.homework;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertAfter("Bob", 25);
        itr.insertAfter("Kate", 21);

        list.display();

    }
}
