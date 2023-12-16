package com.SingleLinkedListWithTail;

import org.example.SingleLinkedListWithTail;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SingleLinkedListWithTailTest {
    /**
     * Tests for size()
     */
    @Test
    public void sizeIsZeroWhenListIsEmpty(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        assertEquals(SingleLinkedListWithTail.size(), 0);
    }
    /**
     * Tests for addFirst()
     */
    @ParameterizedTest
    @MethodSource("SingleLinkedListWithTailData")
    public void addFirstIncrementSize(Integer... dataToAdd){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            SingleLinkedListWithTail.addFirst(dataToAdd[i]);
            assertEquals(SingleLinkedListWithTail.size(), size + (i + 1));
        }
    }
    /**
     * Tests for addLast()
     */
    @ParameterizedTest
    @MethodSource("SingleLinkedListWithTailData")
    public void addLastIncrementSize(Integer... dataToAdd){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            SingleLinkedListWithTail.addLast(dataToAdd[i]);
            assertEquals(SingleLinkedListWithTail.size(), size + (i + 1));
        }
    }
    /**
     * Tests for removeFirst()
     */
    @Test
    public void removeFirstThrowsExceptionWhenEmpty(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        assertThrows(NoSuchElementException.class,
                SingleLinkedListWithTail::removeFirst);
    }
    @Test
    public void removeFirstDecrementSize(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.addLast(15);
        SingleLinkedListWithTail.addLast(25);
        int sizeBeforeRemove = SingleLinkedListWithTail.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            SingleLinkedListWithTail.removeFirst();
            assertEquals(SingleLinkedListWithTail.size(), sizeBeforeRemove - (i + 1));
        }
    }
    /**
     * Tests for removeLast()
     */
    @Test
    public void removeLastThrowsExceptionWhenEmpty(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        assertThrows(NoSuchElementException.class,
                SingleLinkedListWithTail::removeLast);
    }
    @Test
    public void removeLastDecrementSize(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.addLast(15);
        SingleLinkedListWithTail.addLast(25);
        int sizeBeforeRemove = SingleLinkedListWithTail.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            SingleLinkedListWithTail.removeLast();
            assertEquals(SingleLinkedListWithTail.size(), sizeBeforeRemove - (i + 1));
        }
    }
    /**
     * Tests for getFirst()
     */
    @Test
    public void getFirstThrowsExceptionWhenEmpty(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        assertThrows(NoSuchElementException.class,
                SingleLinkedListWithTail::getFirst);}
    @Test
    public void getFirstReturnTheSameValueAfterAddFirst(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        int elementToAdd = 4;
        SingleLinkedListWithTail.addFirst(elementToAdd);
        assertEquals(SingleLinkedListWithTail.getFirst(), elementToAdd);
    }
    @Test
    public void getFirstIsNotChangedAfterAddLast() {
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.addLast(15);
        SingleLinkedListWithTail.addLast(25);
        assertEquals(SingleLinkedListWithTail.getFirst(), 1);
    }
    /**
     * Tests for getLast()
     */
    @Test
    public void getLastThrowsExceptionWhenEmpty(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        assertThrows(NoSuchElementException.class,
                SingleLinkedListWithTail::getLast);
    }
    @Test
    public void getLastReturnTheSameValueAfterAddLast(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        int elementToAdd = 4;
        SingleLinkedListWithTail.addLast(elementToAdd);
        assertEquals(SingleLinkedListWithTail.getLast(), elementToAdd);
    }
    @Test
    public void getLastIsNotChangedAfterAddFirst(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addFirst(1);
        SingleLinkedListWithTail.addFirst(15);
        SingleLinkedListWithTail.addFirst(25);
        assertEquals(SingleLinkedListWithTail.getLast(), 1);}
    /**
     * Tests for get()
     */
    @Test
    public void getThrowsExceptionWhenEmpty(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        assertThrows(NoSuchElementException.class,
                () -> SingleLinkedListWithTail.get(0));
    }
    @Test
    public void getThrowsExceptionWhenIndexIncorrect(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addLast(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> SingleLinkedListWithTail.get(-1));
    }
    @Test
    public void getIsChangedAfterAddFirst(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.addLast(10);
        int getBeforeAdding = SingleLinkedListWithTail.get(1);
        SingleLinkedListWithTail.addFirst(15);
        assertNotEquals(getBeforeAdding, SingleLinkedListWithTail.get(1));
        assertEquals(getBeforeAdding, SingleLinkedListWithTail.get(2));
    }
    @Test
    public void getIsNotChangedAfterAddLast(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<Integer>();
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.addLast(10);
        int getBeforeAdding = SingleLinkedListWithTail.get(1);
        SingleLinkedListWithTail.addLast(15);
        assertEquals(getBeforeAdding, SingleLinkedListWithTail.get(1));
    }
    /**
     * Tests for clear()
     */
    @Test
    public void isEmptyRetrunsTrueAfterClearMethod(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<>();
        assertTrue(SingleLinkedListWithTail.isEmpty());
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.addLast(10);
        SingleLinkedListWithTail.addLast(15);
        assertFalse(SingleLinkedListWithTail.isEmpty());
        assertEquals(3, SingleLinkedListWithTail.size());
        SingleLinkedListWithTail.clear();
        assertTrue(SingleLinkedListWithTail.isEmpty());
        assertEquals(0, SingleLinkedListWithTail.size());
    }
    /**
     * Tests for isEmpty()
     */
    @Test
    public void isEmptyRetrunsTrueForListWithoutAnyElements(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<>();
        assertTrue(SingleLinkedListWithTail.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithOneElement(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<>();
        SingleLinkedListWithTail.addFirst(1);
        assertFalse(SingleLinkedListWithTail.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithMultipleElements(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<>();
        SingleLinkedListWithTail.addFirst(1);
        SingleLinkedListWithTail.addFirst(10);
        assertFalse(SingleLinkedListWithTail.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddLastAndRemoveFirst(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<>();
        SingleLinkedListWithTail.addLast(1);
        SingleLinkedListWithTail.removeFirst();
        assertTrue(SingleLinkedListWithTail.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddFirstAndRemoveLast(){
        SingleLinkedListWithTail<Integer> SingleLinkedListWithTail = new SingleLinkedListWithTail<>();
        SingleLinkedListWithTail.addFirst(1);
        SingleLinkedListWithTail.removeLast();
        assertTrue(SingleLinkedListWithTail.isEmpty());
    }

    static Stream<Arguments> SingleLinkedListWithTailData(){
        return  Stream.of(
                arguments((Object)new Integer[]{1,2,3,4})
                //arguments(3, null, 4),
                //arguments("One", "Two", "Three"),
                //arguments(5.0, 4.4, 3.9)
        );
    }
}
