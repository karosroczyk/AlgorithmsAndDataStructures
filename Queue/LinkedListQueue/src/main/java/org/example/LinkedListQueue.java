package org.example;

import java.util.LinkedList;
import java.util.NoSuchElementException;
public class LinkedListQueue<E> {
    private static class Element<E> {
        Element<E> next, prev;
        E value;

        public Element(Element<E> next, Element<E> prev, E value){
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
    Element<E> head, tail;
    int size;
    /**
     * O(1)
     * @return The number of elements in the list.
     */
    public int size(){
        return size;
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
        Element<E> head_tmp = head;
        Element<E> element = new Element<E>(head, null, value);


        if(isEmpty()) {
            tail = element;
        }else{
            head_tmp.prev = element;
        }
        head = element;
        size++;
    }
    /**
     * Removes the first element from the list.
     *    // O(1)
     */
    public void unlinkFirst(){
        size--;
        if(head.next == null && tail.next == null) {
            clear();
            return;
        }
        head = head.next;
        head.prev = null;
    }
    /**
     * Removes the first element from the list.
     *    // O(1)
     * @throws NoSuchElementException if the list is empty.
     */
    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        unlinkFirst();
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
     *    // O(1)
     *    //linkLast
     * @param value An element to insert into the list.
     */
    public void addLast(E value){
        Element<E> tail_tmp = tail;
        Element<E> element = new Element<E>(null, tail, value);

        if(isEmpty()) {
            head = element;
        }else{
            tail_tmp.next = element;
        }

        tail = element;
        size++;
    }
    /**
     * Removes the first element from the list.
     *    // O(1)
     */
    public void unlinkLast(){
        size--;
        if (head.next == null && head.prev == null){
            clear();
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    /**
     * Removes the first element from the list.
     *    // O(1)
     *    //unlinkLast
     * @throws NoSuchElementException if the list is empty.
     */
    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        unlinkLast();
    }

    //--------------------Queue Interface Implementation--------------

    /** Gets the head of the queue.
     * @return The head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     * Time complexity: O(1)
     */
    public E element(){
        return getFirst();
    }

    /** Gets the head of the queue.
     * @return The head of the queue or null in case of empty queue.
     * Time complexity: O(1)
     */
    public E peek(){
        final Element<E> e = head;
        return (e == null) ? null : e.value;
    }

    /** Add element at the end of queue.
     * @return Return false in case of failure to add element.
     * @throws IllegalStateException if addition would violate capacity restrictions.
     * Time complexity: O(1)
     */
    public boolean add(E element){
        addLast(element);
        return true;
    }

    /** Add element at the end of queue.
     * @return Return false in case of failure to add element.
     * Time complexity: O(1)
     */
    public boolean offer(E element){
        return add(element);
    }

    /** Removes element from the beginning of the queue.
     * @return The head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     * Time complexity: O(1)
     */
    public E remove(){
        final E value = getFirst();
        removeFirst();
        return value;
    }

    /** Removes element from the beginning of the queue.
     * @return The head of the queue or null in case of empty queue.
     * Time complexity: O(1)
     */
    public E poll(){
        final Element<E> e = head;
        if(head == null) return null;
        unlinkFirst();
        return e.value;
    }

    //--------------------Deque Interface Implementation--------------
    /** Add element at the beginning of the queue.
     * @return Return false in case of failure to add element.
     * Time complexity: O(1)
     */
    public boolean offerFirst(E element){
        addFirst(element);
        return true;
    }

    /** Add element at the end of queue.
     * @return Return false in case of failure to add element.
     * Time complexity: O(1)
     */
    public boolean offerLast(E element){
        addLast(element);
        return true;
    }

    /** Removes element from the beginning of the queue.
     * @return The head of the queue or null in case of empty queue.
     * Time complexity: O(1)
     */
    public E pollFirst(){
        final Element<E> e = head;
        if(head == null) return null;
        unlinkFirst();
        return e.value;
    }

    /** Removes element from the end of the queue.
     * @return The tail of the queue or null in case of empty queue.
     * Time complexity: O(1)
     */
    public E pollLast(){
        final Element<E> e = tail;
        if(tail == null) return null;
        unlinkLast();
        return e.value;
    }

    /** Gets element from the beginning of the queue.
     * @return The head of the queue or null in case of empty queue.
     * Time complexity: O(1)
     */
    public E peekFirst(){
        final Element<E> e = head;
        return (e == null) ? null : e.value;
    }

    /** Gets element from the end of the queue.
     * @return The tail of the queue or null in case of empty queue.
     * Time complexity: O(1)
     */
    public E peekLast(){
        final Element<E> e = tail;
        return (e == null) ? null : e.value;
    }
    //--------------------Stack Interface Implementation--------------

    /** Add element to the beginning of the stack.
     * @throws NoSuchElementException if the stack is empty.
     * Time complexity: O(1)
     */
    public void push(E element){
        addFirst(element);
    }

    /** Removes element from the beginning of the stack.
     * @return Return first element of the stack.
     * @throws NoSuchElementException if the stack is empty.
     * Time complexity: O(1)
     */
    public E pop(){
        E first = getFirst();
        removeFirst();
        return first;
    }

    //----------------------------------------------------------------

    /**
     * Returns element at given index.
     *    // O(n/2) ??
     * @param index Index of element which should be returned.
     * @throws NoSuchElementException if the list is empty.
     * @throws IndexOutOfBoundsException if index is out of range (0, size()).
     */
    public E get(int index){
        if(isEmpty()) throw new NoSuchElementException();
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Element<E> head_tmp = head;
        Element<E> tail_tmp = tail;
        int count = size()/2;
        if(index <= count){
            while(index-- > 0){
                head_tmp = head_tmp.next;
            }
            return head_tmp.value;
        }else{
            while(index-- > count){
                tail_tmp = tail_tmp.prev;
            }
            return tail_tmp.value;
        }


    }
    /**
     * Removes all elements of list.
     * O(1)
     */
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * Check if list is empty.
     * O(1)
     * @return Boolean depending on whether list is empty.
     */
    public boolean isEmpty(){
        return (head == null && tail == null);
    }
    /**
     * Iterate over list.
     * O(n)
     * @return String in format [elem1, elem2, ..., elemn].
     */
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
