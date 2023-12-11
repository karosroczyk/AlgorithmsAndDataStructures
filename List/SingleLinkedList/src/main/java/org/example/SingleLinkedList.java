package org.example;

public class SingleLinkedList {
    Element head;

    //O(n)
    void iterate(){
        Element head_tmp = head;
        while(head_tmp != null){
            System.out.print(head_tmp.value);
            head_tmp = head_tmp.next;
        }
        System.out.println();
    }
    //O(n)
    int count(){
        Element head_tmp = head;
        int counter = 0;
        while(head_tmp != null){
            counter++;
            head_tmp = head_tmp.next;
        }
        return counter;
    }

    // front
    //O(1)
    Element getElementFront() {
        return head; }
    // O(1)
    void addElementFront(int value){
        Element element = new Element();
        element.value = value;
        element.next = head;
        head = element;
    }
    // O(1)
    void eraseElementFront(){
        if(head == null) return;
        head = head.next;
    }

    //back
    // O(n)
    Element getElementBack() {
        Element head_tmp = head;
        while(head_tmp.next != null)
            head_tmp = head_tmp.next;
        return head_tmp;
    }
    // O(n)
    void addElementBack(int value){
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
    void eraseElementBack(){
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
    void insertAfter(int value, int index){
        if(index >= this.count())
            return;

        if(index == this.count()-1) {
            this.addElementBack(value);
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
    void deleteElement(Element element){
        if (head == null) return;
        if(head == element) this.eraseElementFront();

        Element head_tmp = head;
        while(head_tmp.next != element){
            head_tmp = head_tmp.next;
        }
        head_tmp.next = element.next;
    }
    //O(n)
    void insertBefore(int value, int index){
        if(index >= this.count())
            return;

        if(index == 0) {
            this.addElementFront(value);
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
    //O(n)
    void insertBeforeElement(int to_insert, int elem){
        if (head == null) return;

        if (head.value == elem){
            addElementFront(to_insert);
            return;
        }
        Element head_tmp = head;
        while(head_tmp.next != null){
            if (head_tmp.next.value == elem){
                Element element = new Element();
                element.value = to_insert;
                element.next = head_tmp.next;
                head_tmp.next = element;
                return;
            }
            head_tmp = head_tmp.next;
        }
    }
    //O(n) - łączenie dwóch list
    void concatenateList(SingleLinkedList lista){
        Element head_tmp = head;

        while(head_tmp.next != null){
            head_tmp = head_tmp.next;
        }

        head_tmp.next = lista.head;
    }

    //complex operations
    //zamiana sąsiednich elementów
    void swapElements(int index){
        if(index >= this.count()-1)
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
    //przestawianie i-tego elementu na początek
    void elementToFront(int index){}
    //przestawianie i-tego elementu na koniec
    void elementToBack(int index){}
    //wstawianie listy za i-ty element
    void insertListAfterElement(SingleLinkedList lista, int index){}
    //odwracanie listy
    void swapList(){}
}
