package MyLinkedList;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.example.MyLinkedList;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MyLinkedListTest {
    /**
     * Tests for size()
     */
    @Test
    public void sizeIsZeroWhenListIsEmpty(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        assertEquals(0, MyLinkedList.size());
    }
    /**
     * Tests for addFirst()
     */
    @ParameterizedTest
    @MethodSource("MyLinkedListData")
    public void addFirstIncrementSize(Integer... dataToAdd){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            MyLinkedList.addFirst(dataToAdd[i]);
            assertEquals(size + (i + 1), MyLinkedList.size());
        }
    }
    /**
     * Tests for addLast()
     */
    @ParameterizedTest
    @MethodSource("MyLinkedListData")
    public void addLastIncrementSize(Integer... dataToAdd){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            MyLinkedList.addLast(dataToAdd[i]);
            assertEquals(size + (i + 1), MyLinkedList.size());
        }
    }
    /**
     * Tests for removeFirst()
     */
    @Test
    public void removeFirstThrowsExceptionWhenEmpty(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyLinkedList::removeFirst);
    }
    @Test
    public void removeFirstDecrementSize(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addLast(1);
        MyLinkedList.addLast(15);
        MyLinkedList.addLast(25);
        int sizeBeforeRemove = MyLinkedList.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            MyLinkedList.removeFirst();
            assertEquals(sizeBeforeRemove - (i + 1), MyLinkedList.size());
        }
    }
    /**
     * Tests for removeLast()
     */
    @Test
    public void removeLastThrowsExceptionWhenEmpty(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyLinkedList::removeLast);
    }
    @Test
    public void removeLastDecrementSize(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addLast(1);
        MyLinkedList.addLast(15);
        MyLinkedList.addLast(25);
        int sizeBeforeRemove = MyLinkedList.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            MyLinkedList.removeLast();
            assertEquals(sizeBeforeRemove - (i + 1), MyLinkedList.size());
        }
    }
    /**
     * Tests for getFirst()
     */
    @Test
    public void getFirstThrowsExceptionWhenEmpty(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyLinkedList::getFirst);}
    @Test
    public void getFirstReturnTheSameValueAfterAddFirst(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        int elementToAdd = 4;
        MyLinkedList.addFirst(elementToAdd);
        assertEquals(elementToAdd, MyLinkedList.getFirst());
    }
    @Test
    public void getFirstIsNotChangedAfterAddLast() {
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addLast(1);
        MyLinkedList.addLast(15);
        MyLinkedList.addLast(25);
        assertEquals(1, MyLinkedList.getFirst());
    }
    /**
     * Tests for getLast()
     */
    @Test
    public void getLastThrowsExceptionWhenEmpty(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                MyLinkedList::getLast);
    }
    @Test
    public void getLastReturnTheSameValueAfterAddLast(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        int elementToAdd = 4;
        MyLinkedList.addLast(elementToAdd);
        assertEquals(elementToAdd, MyLinkedList.getLast());
    }
    @Test
    public void getLastIsNotChangedAfterAddFirst(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addFirst(1);
        MyLinkedList.addFirst(15);
        MyLinkedList.addFirst(25);
        assertEquals(1, MyLinkedList.getLast());}
    /**
     * Tests for get()
     */
    @Test
    public void getThrowsExceptionWhenEmpty(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        assertThrows(NoSuchElementException.class,
                () -> MyLinkedList.get(0));
    }
    @Test
    public void getThrowsExceptionWhenIndexIncorrect(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addLast(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> MyLinkedList.get(-1));
    }
    @Test
    public void getIsChangedAfterAddFirst(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addLast(1);
        MyLinkedList.addLast(10);
        MyLinkedList.addLast(15);
        MyLinkedList.addLast(20);
        MyLinkedList.addLast(25);
        int getBeforeAdding = MyLinkedList.get(3);
        MyLinkedList.addFirst(15);
        assertNotEquals(getBeforeAdding, MyLinkedList.get(3));
        assertEquals(getBeforeAdding, MyLinkedList.get(4));
    }
    @Test
    public void getIsNotChangedAfterAddLast(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
        MyLinkedList.addLast(1);
        MyLinkedList.addLast(10);
        int getBeforeAdding = MyLinkedList.get(1);
        MyLinkedList.addLast(15);
        assertEquals(getBeforeAdding, MyLinkedList.get(1));
    }
    /**
     * Tests for clear()
     */
    @Test
    public void isEmptyRetrunsTrueAfterClearMethod(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
        assertTrue(MyLinkedList.isEmpty());
        MyLinkedList.addLast(1);
        MyLinkedList.addLast(10);
        MyLinkedList.addLast(15);
        assertFalse(MyLinkedList.isEmpty());
        assertEquals(3, MyLinkedList.size());
        MyLinkedList.clear();
        assertTrue(MyLinkedList.isEmpty());
        assertEquals(0, MyLinkedList.size());
    }
    /**
     * Tests for isEmpty()
     */
    @Test
    public void isEmptyRetrunsTrueForListWithoutAnyElements(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
        assertTrue(MyLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithOneElement(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
        MyLinkedList.addFirst(1);
        assertFalse(MyLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithMultipleElements(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
        MyLinkedList.addFirst(1);
        MyLinkedList.addFirst(10);
        assertFalse(MyLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddLastAndRemoveFirst(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
        MyLinkedList.addLast(1);
        MyLinkedList.removeFirst();
        assertTrue(MyLinkedList.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddFirstAndRemoveLast(){
        MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
        MyLinkedList.addFirst(1);
        MyLinkedList.removeLast();
        assertTrue(MyLinkedList.isEmpty());
    }

    static Stream<Arguments> MyLinkedListData(){
        return  Stream.of(
                arguments((Object)new Integer[]{1,2,3,4})
                //arguments(3, null, 4),
                //arguments("One", "Two", "Three"),
                //arguments(5.0, 4.4, 3.9)
        );
    }
}
