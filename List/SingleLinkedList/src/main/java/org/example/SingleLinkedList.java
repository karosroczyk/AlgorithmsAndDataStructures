package org.example;

import java.util.ArrayList;

public class SingleLinkedList {
    Element head;
    //O(n)
    public int size(){
        Element head_tmp = head;
        int counter = 0;
        while(head_tmp != null){
            counter++;
            head_tmp = head_tmp.next;
        }
        return counter;
    }
    /** Gets the first element.
     * @return First element
     * Time complexity: O(1)
     */
    Element getFirst() {
        return head; }
    // O(1)
    public void addFirst(int value){
        Element element = new Element();
        element.value = value;
        element.next = head;
        head = element;
    }
    // O(1)
    void removeFirst(){
        if(head == null) return;
        head = head.next;
    }

    //back
    // O(n)
    Element getLast() {
        Element head_tmp = head;
        while(head_tmp.next != null)
            head_tmp = head_tmp.next;
        return head_tmp;
    }
    // O(n)
    public void addLast(int value){
        Element head_tmp = head;
        Element element = new Element();
        element.value = value;
        element.next = null;

        if(head_tmp == null) {
            head = element;
            return;
        }

        while(head_tmp.next != null){
            head_tmp = head_tmp.next;
        }

        head_tmp.next = element;
    }
    // O(n)
    void removeLast(){
        if(head == null)
            return;
        if (head.next == null){
            head = null;
            return;
        }
        Element head_tmp = head;
        while(head_tmp.next.next != null){
            head_tmp = head_tmp.next;
        }
        head_tmp.next = null;
    }
    //other
    //O(n)
    void linkAfter(int value, int index){
        if(index >= this.size())
            return;

        if(index == this.size()-1) {
            this.addLast(value);
            return;
        }

        Element head_tmp = head;
        Element element = new Element();
        element.value = value;
        int counter = 0;

        while(counter < index){
            head_tmp = head_tmp.next;
            counter ++;
        }
        element.next = head_tmp.next;
        head_tmp.next = element;
    }
    //O(n)
    void linkBeforeIndex(int value, int index){
        if(index >= this.size())
            return;

        if(index == 0) {
            this.addFirst(value);
            return;
        }

        Element head_tmp = head;
        Element element = new Element();
        element.value = value;
        int counter = 0;

        while(counter < (index -1)){
            head_tmp = head_tmp.next;
            counter ++;
        }
        element.next = head_tmp.next;
        head_tmp.next = element;
    }
    //O(n) Inserts element e before non-null Node succ.
    void linkBefore(int e, int elem){
        if (head == null) return;

        if (head.value == elem){
            addFirst(e);
            return;
        }
        Element head_tmp = head;
        while(head_tmp.next != null){
            if (head_tmp.next.value == elem){
                Element element = new Element();
                element.value = e;
                element.next = head_tmp.next;
                head_tmp.next = element;
                return;
            }
            head_tmp = head_tmp.next;
        }
    }
    //O(n)
    void unlink(Element element){
        if (head == null) return;
        if(head == element) this.removeFirst();

        Element head_tmp = head;
        while(head_tmp.next != element){
            head_tmp = head_tmp.next;
        }
        head_tmp.next = element.next;
    }
    boolean contains(Object o){return true;}

    //complex operations
    //zamiana sąsiednich elementów
    public void swapElements(int index){
        if(index >= this.size()-1)
            throw new IllegalArgumentException("No way to swap: argument too big");
        Element head_tmp = head;
        Element a  = head_tmp;
        Element b  = head_tmp.next;
        Element c  = head_tmp.next.next;
        int counter = 0;

        if(index == 0){
            a.next = c;
            b.next = a;
            head = b;
            return;
        }

        while(counter < index-1){
            head_tmp = head_tmp.next;
            counter++;
        }
        a  = head_tmp;
        b  = head_tmp.next;
        c  = head_tmp.next.next;
        Element d  = head_tmp.next.next.next;
        a.next = c;
        b.next = d;
        c.next = b;
    }
    //O(n) - łączenie dwóch list
    public void concatenateList(SingleLinkedList lista){
        Element head_tmp = head;

        while(head_tmp.next != null){
            head_tmp = head_tmp.next;
        }

        head_tmp.next = lista.head;
    }
    //O(n)
    public void iterate(){
        Element head_tmp = head;
        while(head_tmp != null){
            System.out.print(head_tmp.value);
            head_tmp = head_tmp.next;
        }
        System.out.println();
    }
}
