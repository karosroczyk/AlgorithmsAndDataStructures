package com.MyArrayList;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
        import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.example.MyArrayList;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MyArrayListTest {
    /**
     * Tests for size()
     */
    @Test
    public void sizeIsZeroWhenListIsEmpty(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        assertEquals(0, MyArrayList.size());
    }
    /**
     * Tests for addFirst()
     */
    @ParameterizedTest
    @MethodSource("MyArrayListData")
    public void addFirstIncrementSize(Integer... dataToAdd){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            MyArrayList.addFirst(dataToAdd[i]);
            assertEquals(size + (i + 1), MyArrayList.size());
        }
    }
    /**
     * Tests for addLast()
     */
    @ParameterizedTest
    @MethodSource("MyArrayListData")
    public void addLastIncrementSize(Integer... dataToAdd){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            MyArrayList.addLast(dataToAdd[i]);
            assertEquals(size + (i + 1), MyArrayList.size());
        }
    }
    /**
     * Tests for removeFirst()
     */
    @Test
    public void removeFirstThrowsExceptionWhenEmpty(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyArrayList::removeFirst);
    }
    @Test
    public void removeFirstDecrementSize(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addLast(1);
        MyArrayList.addLast(15);
        MyArrayList.addLast(25);
        int sizeBeforeRemove = MyArrayList.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            MyArrayList.removeFirst();
            assertEquals(sizeBeforeRemove - (i + 1), MyArrayList.size());
        }
    }
    /**
     * Tests for removeLast()
     */
    @Test
    public void removeLastThrowsExceptionWhenEmpty(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyArrayList::removeLast);
    }
    @Test
    public void removeLastDecrementSize(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addLast(1);
        MyArrayList.addLast(15);
        MyArrayList.addLast(25);
        int sizeBeforeRemove = MyArrayList.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            MyArrayList.removeLast();
            assertEquals(sizeBeforeRemove - (i + 1), MyArrayList.size());
        }
    }
    /**
     * Tests for getFirst()
     */
    @Test
    public void getFirstThrowsExceptionWhenEmpty(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyArrayList::getFirst);}
    @Test
    public void getFirstReturnTheSameValueAfterAddFirst(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        int elementToAdd = 4;
        MyArrayList.addFirst(elementToAdd);
        assertEquals(elementToAdd, MyArrayList.getFirst());
    }
    @Test
    public void getFirstIsNotChangedAfterAddLast() {
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addLast(1);
        MyArrayList.addLast(15);
        MyArrayList.addLast(25);
        assertEquals(1, MyArrayList.getFirst());
    }
    /**
     * Tests for getLast()
     */
    @Test
    public void getLastThrowsExceptionWhenEmpty(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyArrayList::getLast);
    }
    @Test
    public void getLastReturnTheSameValueAfterAddLast(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        int elementToAdd = 4;
        MyArrayList.addLast(elementToAdd);
        assertEquals(elementToAdd, MyArrayList.getLast());
    }
    @Test
    public void getLastIsNotChangedAfterAddFirst(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(15);
        MyArrayList.addFirst(25);
        assertEquals(1, MyArrayList.getLast());}
    /**
     * Tests for get()
     */
    @Test
    public void getThrowsExceptionWhenEmpty(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        assertThrows(NoSuchElementException.class,
                () -> MyArrayList.get(0));
    }
    @Test
    public void getThrowsExceptionWhenIndexIncorrect(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addLast(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> MyArrayList.get(-1));
    }
    @Test
    public void getIsChangedAfterAddFirst(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addLast(1);
        MyArrayList.addLast(10);
        MyArrayList.addLast(15);
        MyArrayList.addLast(20);
        MyArrayList.addLast(25);
        int getBeforeAdding = MyArrayList.get(3);
        MyArrayList.addFirst(15);
        assertNotEquals(getBeforeAdding, MyArrayList.get(3));
        assertEquals(getBeforeAdding, MyArrayList.get(4));
    }
    @Test
    public void getIsNotChangedAfterAddLast(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<Integer>();
        MyArrayList.addLast(1);
        MyArrayList.addLast(10);
        int getBeforeAdding = MyArrayList.get(1);
        MyArrayList.addLast(15);
        assertEquals(getBeforeAdding, MyArrayList.get(1));
    }
    /**
     * Tests for clear()
     */
    @Test
    public void isEmptyRetrunsTrueAfterClearMethod(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        assertTrue(MyArrayList.isEmpty());
        MyArrayList.addLast(1);
        MyArrayList.addLast(10);
        MyArrayList.addLast(15);
        assertFalse(MyArrayList.isEmpty());
        assertEquals(3, MyArrayList.size());
        MyArrayList.clear();
        assertTrue(MyArrayList.isEmpty());
        assertEquals(0, MyArrayList.size());
    }
    /**
     * Tests for isEmpty()
     */
    @Test
    public void isEmptyRetrunsTrueForListWithoutAnyElements(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        assertTrue(MyArrayList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithOneElement(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        MyArrayList.addFirst(1);
        assertFalse(MyArrayList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithMultipleElements(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(10);
        assertFalse(MyArrayList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddLastAndRemoveFirst(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        MyArrayList.addLast(1);
        MyArrayList.removeFirst();
        assertTrue(MyArrayList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddFirstAndRemoveLast(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        MyArrayList.addFirst(1);
        MyArrayList.removeLast();
        assertTrue(MyArrayList.isEmpty());
    }

    @Test
    public void resizeTest(){
        MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        MyArrayList.addFirst(1);
        assertFalse(MyArrayList.isEmpty());
        assertEquals(10, MyArrayList.size());
        assertEquals(10, MyArrayList.length());

        MyArrayList.addFirst(1);
        assertFalse(MyArrayList.isEmpty());
        assertEquals(11, MyArrayList.size());
        assertEquals(20, MyArrayList.length());

    }

    static Stream<Arguments> MyArrayListData(){
        return  Stream.of(
                arguments((Object)new Integer[]{1,2,3,4})
                //arguments(3, null, 4),
                //arguments("One", "Two", "Three"),
                //arguments(5.0, 4.4, 3.9)
        );
    }
}
