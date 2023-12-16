package org.example;

import java.util.NoSuchElementException;

public class SingleLinkedListWithTail<E> {

    private static class Element<E> {
        Element<E> next;
        E value;

        public Element(Element<E> next, E value){
            this.next = next;
            this.value = value;
        }
    }
    Element<E> head, tail;
    /**
     * O(n)
     * @return The number of elements in the list.
     */
    public int size(){
        Element<E> head_tmp = head;
        int counter = 0;
        while(head_tmp != null){
            counter++;
            head_tmp = head_tmp.next;
        }
        return counter;
    }
    /** Gets the first element.
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     * Time complexity: O(1)
     */
    public E getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return head.value;
    }
    /**
     * Inserts the given element at the beginning of this list.
     *    // O(1)
     *    //linkFirst
     * @param value An element to insert into the list.
     */
    public void addFirst(E value){
        head = new Element<E>(head, value);
    }
    /**
     * Removes the first element from the list.
     *    // O(1)
     *    //unlinkFirst
     * @throws NoSuchElementException if the list is empty.
     */
    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        head = head.next;
    }
    /** Gets the last element.
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     * Time complexity: O(1)
     */
    public E getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return tail.value;
    }
    /**
     * Inserts the given element at the end of this list.
     *    // O(n)
     *    //linkLast
     * @param value An element to insert into the list.
     */
    public void addLast(E value){
        Element<E> tail_tmp = head;
        Element<E> element = new Element<E>(null, value);

        if(tail_tmp == null) {
            head = element;
            tail = element;
            return;
        }

        while(head_tmp.next != null){
            head_tmp = head_tmp.next;
        }

        head_tmp.next = element;
    }
    /**
     * Removes the first element from the list.
     *    // O(n)
     *    //unlinkLast
     * @throws NoSuchElementException if the list is empty.
     */
    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        if (head.next == null){
            head = null;
            return;
        }
        Element<E> head_tmp = head;
        while(head_tmp.next.next != null){
            head_tmp = head_tmp.next;
        }
        head_tmp.next = null;
    }

    //----------------------------------------------------------------
    /**
     * Returns element at given index.
     *    // O(n)
     * @param index Index of element which should be returned.
     * @throws NoSuchElementException if the list is empty.
     * @throws IndexOutOfBoundsException if index is out of range (0, size()).
     */
    public E get(int index){
        if(isEmpty()) throw new NoSuchElementException();
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Element<E> head_tmp = head;
        while(index-- != 0){
            head_tmp = head_tmp.next;
        }

        return head_tmp.value;
    }
    /**
     * Removes all elements of list.
     * O(1)
     */
    public void clear(){
        head = null;
    }
    /**
     * Check if list is empty.
     * O(1)
     * @return Boolean depending on whether list is empty.
     */
    public boolean isEmpty(){
        return head == null;
    }

    public String iterate(){
        Element<E> head_tmp = head;
        String output = "[";
        while(head_tmp != null){
            output += head_tmp.value + ", ";
            head_tmp = head_tmp.next;
        }
        output = output.substring(0, output.length() - 2);
        return output + "]";
    }
}
