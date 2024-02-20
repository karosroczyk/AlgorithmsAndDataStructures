package LinkedListQueue;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.example.LinkedListQueue;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LinkedListQueueTest {
    /**
     * Tests for size()
     */
    @Test
    public void sizeIsZeroWhenListIsEmpty(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        assertEquals(0, LinkedListQueue.size());
    }
    /**
     * Tests for addFirst()
     */
    @ParameterizedTest
    @MethodSource("LinkedListQueueData")
    public void addFirstIncrementSize(Integer... dataToAdd){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            LinkedListQueue.addFirst(dataToAdd[i]);
            assertEquals(size + (i + 1), LinkedListQueue.size());
        }
    }
    /**
     * Tests for addLast()
     */
    @ParameterizedTest
    @MethodSource("LinkedListQueueData")
    public void addLastIncrementSize(Integer... dataToAdd){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        int size = 0;
        for(int i = 0; i < dataToAdd.length; i++){
            LinkedListQueue.addLast(dataToAdd[i]);
            assertEquals(size + (i + 1), LinkedListQueue.size());
        }
    }
    /**
     * Tests for removeFirst()
     */
    @Test
    public void removeFirstThrowsExceptionWhenEmpty(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        assertThrows(NoSuchElementException.class,
                LinkedListQueue::removeFirst);
    }
    @Test
    public void removeFirstDecrementSize(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addLast(1);
        LinkedListQueue.addLast(15);
        LinkedListQueue.addLast(25);
        int sizeBeforeRemove = LinkedListQueue.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            LinkedListQueue.removeFirst();
            assertEquals(sizeBeforeRemove - (i + 1), LinkedListQueue.size());
        }
    }
    /**
     * Tests for removeLast()
     */
    @Test
    public void removeLastThrowsExceptionWhenEmpty(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        assertThrows(NoSuchElementException.class,
                LinkedListQueue::removeLast);
    }
    @Test
    public void removeLastDecrementSize(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addLast(1);
        LinkedListQueue.addLast(15);
        LinkedListQueue.addLast(25);
        int sizeBeforeRemove = LinkedListQueue.size();
        for(int i = 0; i < sizeBeforeRemove; i++)
        {
            LinkedListQueue.removeLast();
            assertEquals(sizeBeforeRemove - (i + 1), LinkedListQueue.size());
        }
    }
    /**
     * Tests for getFirst()
     */
    @Test
    public void getFirstThrowsExceptionWhenEmpty(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        assertThrows(NoSuchElementException.class,
                LinkedListQueue::getFirst);}
    @Test
    public void getFirstReturnTheSameValueAfterAddFirst(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        int elementToAdd = 4;
        LinkedListQueue.addFirst(elementToAdd);
        assertEquals(elementToAdd, LinkedListQueue.getFirst());
    }
    @Test
    public void getFirstIsNotChangedAfterAddLast() {
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addLast(1);
        LinkedListQueue.addLast(15);
        LinkedListQueue.addLast(25);
        assertEquals(1, LinkedListQueue.getFirst());
    }
    /**
     * Tests for getLast()
     */
    @Test
    public void getLastThrowsExceptionWhenEmpty(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        assertThrows(NoSuchElementException.class,
                LinkedListQueue::getLast);
    }
    @Test
    public void getLastReturnTheSameValueAfterAddLast(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        int elementToAdd = 4;
        LinkedListQueue.addLast(elementToAdd);
        assertEquals(elementToAdd, LinkedListQueue.getLast());
    }
    @Test
    public void getLastIsNotChangedAfterAddFirst(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addFirst(1);
        LinkedListQueue.addFirst(15);
        LinkedListQueue.addFirst(25);
        assertEquals(1, LinkedListQueue.getLast());}
    /**
     * Tests for get()
     */
    @Test
    public void getThrowsExceptionWhenEmpty(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        assertThrows(NoSuchElementException.class,
                () -> LinkedListQueue.get(0));
    }
    @Test
    public void getThrowsExceptionWhenIndexIncorrect(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addLast(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> LinkedListQueue.get(-1));
    }
    @Test
    public void getIsChangedAfterAddFirst(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addLast(1);
        LinkedListQueue.addLast(10);
        LinkedListQueue.addLast(15);
        LinkedListQueue.addLast(20);
        LinkedListQueue.addLast(25);
        int getBeforeAdding = LinkedListQueue.get(3);
        LinkedListQueue.addFirst(15);
        assertNotEquals(getBeforeAdding, LinkedListQueue.get(3));
        assertEquals(getBeforeAdding, LinkedListQueue.get(4));
    }
    @Test
    public void getIsNotChangedAfterAddLast(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<Integer>();
        LinkedListQueue.addLast(1);
        LinkedListQueue.addLast(10);
        int getBeforeAdding = LinkedListQueue.get(1);
        LinkedListQueue.addLast(15);
        assertEquals(getBeforeAdding, LinkedListQueue.get(1));
    }
    /**
     * Tests for clear()
     */
    @Test
    public void isEmptyRetrunsTrueAfterClearMethod(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<>();
        assertTrue(LinkedListQueue.isEmpty());
        LinkedListQueue.addLast(1);
        LinkedListQueue.addLast(10);
        LinkedListQueue.addLast(15);
        assertFalse(LinkedListQueue.isEmpty());
        assertEquals(3, LinkedListQueue.size());
        LinkedListQueue.clear();
        assertTrue(LinkedListQueue.isEmpty());
        assertEquals(0, LinkedListQueue.size());
    }
    /**
     * Tests for isEmpty()
     */
    @Test
    public void isEmptyRetrunsTrueForListWithoutAnyElements(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<>();
        assertTrue(LinkedListQueue.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithOneElement(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<>();
        LinkedListQueue.addFirst(1);
        assertFalse(LinkedListQueue.isEmpty());
    }
    @Test
    public void isEmptyRetrunsFalseForListWithMultipleElements(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<>();
        LinkedListQueue.addFirst(1);
        LinkedListQueue.addFirst(10);
        assertFalse(LinkedListQueue.isEmpty());
    }
    @Test
    public void isEmptyRetrunsTrueAfterAddLastAndRemoveFirst(){
        LinkedListQueue<Integer> LinkedListQueue = new LinkedListQueue<>();
        LinkedListQueue.addLast(1);
        LinkedListQueue.removeFirst();
        assertTrue(LinkedListQueue.isEmpty());
    }

    @Test
    public void offerAddsElementToTheEndOfFIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.offer(1);
        linkedListQueue.offer(4);
        assertEquals(1, linkedListQueue.getFirst());
        assertEquals(4, linkedListQueue.getLast());

        linkedListQueue.offer(2);
        assertEquals(1, linkedListQueue.getFirst());
        assertEquals(2, linkedListQueue.getLast());
    }

    @Test
    public void addAddsElementToTheEndOfFIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.offer(1);
        linkedListQueue.offer(4);
        assertEquals(1, linkedListQueue.getFirst());
        assertEquals(4, linkedListQueue.getLast());

        linkedListQueue.offer(2);
        assertEquals(1, linkedListQueue.getFirst());
        assertEquals(2, linkedListQueue.getLast());
    }

    @Test
    public void pollRemovesElementFromTheBeginningOfFIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.offer(1);
        linkedListQueue.offer(4);
        linkedListQueue.offer(2);
        linkedListQueue.poll();
        assertEquals(4, linkedListQueue.getFirst());
        assertEquals(2, linkedListQueue.getLast());
    }

    @Test
    public void pollReturnsNullIfQueueIsEmptyTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());
        assertNull(linkedListQueue.poll());
    }

    @Test
    public void removeRemovesElementFromTheBeginningOfFIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.add(1);
        linkedListQueue.add(4);
        linkedListQueue.add(2);
        linkedListQueue.remove();
        assertEquals(4, linkedListQueue.getFirst());
        assertEquals(2, linkedListQueue.getLast());
    }

    @Test
    public void removeThrowsNoSuchElementExceptionIfQueueIsEmptyTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());
        assertThrows(NoSuchElementException.class,
                () -> linkedListQueue.remove());
    }
    @Test
    public void peekReturnsElementFromTheBeginningOfFIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.offer(1);
        linkedListQueue.offer(4);
        linkedListQueue.offer(2);
        linkedListQueue.poll();
        assertEquals(4, linkedListQueue.peek());
        assertEquals(2, linkedListQueue.getLast());
    }

    @Test
    public void peekReturnsNullIfQueueIsEmptyTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());
        assertNull(linkedListQueue.peek());
    }

    @Test
    public void elementReturnsElementFromTheBeginningOfFIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.add(1);
        linkedListQueue.add(4);
        linkedListQueue.add(2);
        linkedListQueue.remove();
        assertEquals(4, linkedListQueue.element());
        assertEquals(2, linkedListQueue.getLast());
    }

    @Test
    public void elementThrowsNoSuchElementExceptionIfQueueIsEmptyTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());
        assertThrows(NoSuchElementException.class,
                () -> linkedListQueue.element());
    }

    @Test
    public void popRemovesElementFromTheBeginningOfLIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.push(1);
        linkedListQueue.push(4);
        linkedListQueue.push(2);
        linkedListQueue.pop();
        assertEquals(4, linkedListQueue.getFirst());
        assertEquals(1, linkedListQueue.getLast());
    }

    @Test
    public void popReturnesElementFromTheBeginningOfLIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.push(1);
        linkedListQueue.push(4);
        linkedListQueue.push(2);
        assertEquals(2, linkedListQueue.pop());
    }
    @Test
    public void popThrowsNoSuchElementExceptionIfQueueIsEmptyTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());
        assertThrows(NoSuchElementException.class,
                () -> linkedListQueue.pop());
    }
    @Test
    public void pushAddsElementToTheBeginningOfLIFOQueueTest(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        assertTrue(linkedListQueue.isEmpty());

        linkedListQueue.push(1);
        linkedListQueue.push(4);
        linkedListQueue.push(2);
        assertEquals(2, linkedListQueue.getFirst());
        assertEquals(1, linkedListQueue.getLast());
    }
static Stream<Arguments> LinkedListQueueData() {
    return Stream.of(
            arguments((Object) new Integer[]{1, 2, 3, 4})
            //arguments(3, null, 4),
            //arguments("One", "Two", "Three"),
            //arguments(5.0, 4.4, 3.9)
    );

}
}