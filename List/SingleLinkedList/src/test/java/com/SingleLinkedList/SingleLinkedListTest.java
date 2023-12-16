package com.SingleLinkedList;

import org.example.SingleLinkedList;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.lang.model.element.Element;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
public class SingleLinkedListTest {
    /**
     * Tests for size()
     */
    @Test
    public void sizeIsZeroWhenListIsEmpty(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertEquals(singleLinkedList.size(), 0);
    }
    /**
     * Tests for addFirst()
     */
    @ParameterizedTest
    @MethodSource("singleLinkedListData")
    public void addFirstIncrementSize(Integer... dataToAdd){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            singleLinkedList.addFirst(dataToAdd[i]);
            assertEquals(singleLinkedList.size(), size + (i + 1));
        }
    }
    /**
     * Tests for addLast()
     */
    @ParameterizedTest
    @MethodSource("singleLinkedListData")
    public void addLastIncrementSize(Integer... dataToAdd){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            singleLinkedList.addLast(dataToAdd[i]);
            assertEquals(singleLinkedList.size(), size + (i + 1));
        }
    }
    /**
     * Tests for removeFirst()
     */
    @Test
    public void removeFirstThrowsExceptionWhenEmpty(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                singleLinkedList::removeFirst);
    }
    @Test
    public void removeFirstDecrementSize(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(15);
        singleLinkedList.addLast(25);
        int sizeBeforeRemove = singleLinkedList.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            singleLinkedList.removeFirst();
            assertEquals(singleLinkedList.size(), sizeBeforeRemove - (i + 1));
        }
    }
    /**
     * Tests for removeLast()
     */
    @Test
    public void removeLastThrowsExceptionWhenEmpty(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                singleLinkedList::removeLast);
    }
    @Test
    public void removeLastDecrementSize(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(15);
        singleLinkedList.addLast(25);
        int sizeBeforeRemove = singleLinkedList.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            singleLinkedList.removeLast();
            assertEquals(singleLinkedList.size(), sizeBeforeRemove - (i + 1));
        }
    }
    /**
     * Tests for getFirst()
     */
    @Test
    public void getFirstThrowsExceptionWhenEmpty(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                singleLinkedList::getFirst);}
    @Test
    public void getFirstReturnTheSameValueAfterAddFirst(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        int elementToAdd = 4;
        singleLinkedList.addFirst(elementToAdd);
        assertEquals(singleLinkedList.getFirst(), elementToAdd);
    }
    @Test
    public void getFirstIsNotChangedAfterAddLast() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(15);
        singleLinkedList.addLast(25);
        assertEquals(singleLinkedList.getFirst(), 1);
    }
    /**
     * Tests for getLast()
     */
    @Test
    public void getLastThrowsExceptionWhenEmpty(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                singleLinkedList::getLast);
    }
    @Test
    public void getLastReturnTheSameValueAfterAddLast(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        int elementToAdd = 4;
        singleLinkedList.addLast(elementToAdd);
        assertEquals(singleLinkedList.getLast(), elementToAdd);
    }
    @Test
    public void getLastIsNotChangedAfterAddFirst(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(15);
        singleLinkedList.addFirst(25);
        assertEquals(singleLinkedList.getLast(), 1);}
    /**
     * Tests for get()
     */
    @Test
    public void getThrowsExceptionWhenEmpty(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                () -> singleLinkedList.get(0));
    }
    @Test
    public void getThrowsExceptionWhenIndexIncorrect(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addLast(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> singleLinkedList.get(-1));
    }
    @Test
    public void getIsChangedAfterAddFirst(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(10);
        int getBeforeAdding = singleLinkedList.get(1);
        singleLinkedList.addFirst(15);
        assertNotEquals(getBeforeAdding, singleLinkedList.get(1));
        assertEquals(getBeforeAdding, singleLinkedList.get(2));
    }
    @Test
    public void getIsNotChangedAfterAddLast(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(10);
        int getBeforeAdding = singleLinkedList.get(1);
        singleLinkedList.addLast(15);
        assertEquals(getBeforeAdding, singleLinkedList.get(1));
    }
    /**
     * Tests for clear()
     */
    @Test
    public void isEmptyRetrunsTrueAfterClearMethod(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        assertTrue(singleLinkedList.isEmpty());
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(10);
        singleLinkedList.addLast(15);
        assertFalse(singleLinkedList.isEmpty());
        assertEquals(3, singleLinkedList.size());
        singleLinkedList.clear();
        assertTrue(singleLinkedList.isEmpty());
        assertEquals(0, singleLinkedList.size());
    }
    /**
     * Tests for isEmpty()
     */
    @Test
    public void isEmptyRetrunsTrueForListWithoutAnyElements(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        assertTrue(singleLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithOneElement(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        assertFalse(singleLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithMultipleElements(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(10);
        assertFalse(singleLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddLastAndRemoveFirst(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addLast(1);
        singleLinkedList.removeFirst();
        assertTrue(singleLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddFirstAndRemoveLast(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
        singleLinkedList.removeLast();
        assertTrue(singleLinkedList.isEmpty());
    }

    static Stream<Arguments> singleLinkedListData(){
        return  Stream.of(
                arguments((Object)new Integer[]{1,2,3,4})
                //arguments(3, null, 4),
                //arguments("One", "Two", "Three"),
                //arguments(5.0, 4.4, 3.9)
        );
    }
}
