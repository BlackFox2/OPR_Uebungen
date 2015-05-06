package uebung2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitTest for testing the uebung2.ArrayList class and the functionality needed from implementing uebung2.Deque
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class DequeListTest {
    private ArrayList list = new ArrayList();

    /**
     * Checks the addHead function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testAddHead() throws Exception {
        NodeImpl[] array = new NodeImpl[5];
        for(int i = 0; i < 4; i++) {
            array[i] = new NodeImpl(i);
            list.add(array[i]);
        }
        Node head = new NodeImpl(7);
        list.addHead(head);
        assertSame(head, list.elements[0]);
        for(int i = 1; i < 5; i++) {
            assertSame(array[i-1], list.get(i));
        }
    }

    /**
     * Checks the addTail function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testAddTail() throws Exception {
        for(int i = 0; i < 5; i++) {
            NodeImpl n = new NodeImpl(i);
            list.add(n);
        }
        NodeImpl tail = new NodeImpl(7);
        list.addTail(tail);
        assertSame(tail, list.elements[list.counter-1]);
    }

    /**
     * Checks the removeHead function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testRemoveHead() throws Exception {
        NodeImpl[] array = new NodeImpl[5];
        for(int i = 0; i < 5; i++) {
            array[i] = new NodeImpl(i);
            list.add(array[i]);
        }
        list.removeHead();
        assertSame(array[1], list.elements[0]);
    }

    /**
     * Checks the removeTail function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testRemoveTail() throws Exception {
        NodeImpl[] array = new NodeImpl[5];
        for(int i = 0; i < 5; i++) {
            array[i] = new NodeImpl(i);
            list.add(array[i]);
        }
        list.removeTail();
        assertSame(array[3], list.elements[list.counter-1]);
    }

    /**
     * Checks the getHead function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testGetHead() throws Exception {
        NodeImpl[] array = new NodeImpl[5];
        for(int i = 0; i < 5; i++) {
            array[i] = new NodeImpl(i);
            list.add(array[i]);
        }
        assertSame(array[0], list.getHead());
    }

    /**
     * Checks the getTail function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testGetTail() throws Exception {
        NodeImpl[] array = new NodeImpl[5];
        for(int i = 0; i < 5; i++) {
            array[i] = new NodeImpl(i);
            list.add(array[i]);
        }
        assertSame(array[4], list.getTail());
    }
}