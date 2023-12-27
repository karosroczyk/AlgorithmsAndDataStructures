package org.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList(){
        array = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.array = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    /**
     * O(1)
     * @param index Index of element of array which will be returned.
     * @return The value of the element ad index.
     */
    private E elementData(int index){ return (E) array[index]; }
    /**
     * O(n)
     * Multiply allocated array memory by 2.
     */
    private void resize(){
        Object[] tmpArray = array;
        array = new Object[2 * tmpArray.length];
        System.arraycopy(tmpArray, 0, array, 0, size);
    }
    /**
     * O(1)
     * @return The number of allocated memory of the array.
     */
    public int length(){ return array.length; }
    /**
     * O(1)
     * @return The number of elements in the array.
     */
    public int size(){ return size; }
    /** Gets the first element.
     * @return The head of the array.
     * @throws NoSuchElementException if the array is empty.
     * Time complexity: O(1)
     */
    public E getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return elementData(0);
    }
    /**
     * Inserts the given element at the beginning of this list.
     *    // O(n)
     *    //linkFirst
     * @param value An element to insert into the list.
     */
    public void addFirst(E value){
        if(size == array.length)
            resize();
        System.arraycopy(array, 0, array, 1, size);
        array[0] = value;
        size++;
    }
    /**
     * Removes the first element from the list.
     *    // O(n)
     *    //unlinkFirst
     * @throws NoSuchElementException if the list is empty.
     */
    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        System.arraycopy(array, 1, array, 0, size - 1);
        size--;
    }
    /** Gets the last element.
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     * Time complexity: O(1)
     */
    public E getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return elementData(size - 1);
    }
    /**
     * Inserts the given element at the end of this list.
     *    // O(n)
     *    //linkLast
     * @param value An element to insert into the list.
     */
    public void addLast(E value){
        if(size == array.length)
            resize();
        array[size] = value;
        size++;
    }
    /**
     * Removes the first element from the list.
     *    // O(1)
     *    //unlinkLast
     * @throws NoSuchElementException if the list is empty.
     */
    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        array[size - 1] = null;
        size--;
    }

    //----------------------------------------------------------------
    /**
     * Returns element at given index.
     *    // O(1)
     * @param index Index of element which should be returned.
     * @throws NoSuchElementException if the list is empty.
     * @throws IndexOutOfBoundsException if index is out of range (0, size()).
     */
    public E get(int index){
        if(isEmpty()) throw new NoSuchElementException();
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return elementData(index);
    }
    /**
     * Removes all elements of list.
     * O(1)
     */
    public void clear(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    /**
     * Check if list is empty.
     * O(1)
     * @return Boolean depending on whether list is empty.
     */
    public boolean isEmpty(){ return size == 0; }
    /**
     * Iterate over list.
     * O(n)
     * @return String in format [elem1, elem2, ..., elemn].
     */
    public String iterate(){
        return null;
    }
}
