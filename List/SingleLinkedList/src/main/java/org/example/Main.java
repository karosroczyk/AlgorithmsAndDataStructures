package org.example;
public class Main {

    public static void main(String[] args) {
        showList();
    }

    static void showList(){
        SingleLinkedList l = new SingleLinkedList();
        l.addElementFront(1);
        l.addElementFront(2);
        l.iterate();

        SingleLinkedList l2 = new SingleLinkedList();
        l2.addElementBack(3);
        l2.addElementBack(4);
        l2.addElementBack(5);
        l2.iterate();

        l.concatenateList(l2);
        l.iterate();

        l.swapElements(1);
        l.iterate();
    }
}