package uebung2;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * JUnitTest for testing the uebung2.ArrayList class the base functionality and additionally the functionality needed
 * from implementing uebung2.List
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class ListTest {
    private ArrayList list = new ArrayList();
    private int counter = 1;
    private NodeImpl n;

    /**
     * Insert the given amount of nodes into the list.
     * Key of the nodes is increasing from zero to n
     * @param n     amount of nodes to insert
     */
    private void insertNodes(int n) {
        for(int i = 0; i < n+1; i++) {
            NodeImpl x = new NodeImpl(i);
            list.add(x);
        }
    }

    /**
     * Checks the add function from uebung2.ArrayList class with different amounts of nodes.
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        n = new NodeImpl(counter);
        list.add(n);
        /* check the inserted element */
        assertTrue(n == list.elements[counter-1]);
        /* generate more elements and check their insertion */
        for(counter += 1; counter < 5; counter++) {
            NodeImpl testNode = new NodeImpl(counter);
            list.add(testNode);
            assertTrue(testNode == list.elements[counter-1]);
        }
        /* check if the size of the array is increased when the fifth element is added */
        int listSize = list.elements.length;
        NodeImpl n2  = new NodeImpl(counter);
        list.add(n2);
        assertTrue(n2 == list.elements[counter - 1]);
        assertEquals(listSize*2, list.elements.length, 0.0);

    }

    /**
     * Checks the remove function from uebung2.ArrayList class with different amounts of nodes and orders.
     * @throws Exception
     */
    @Test
    public void testRemove() throws Exception {
        // Test if it's possible to remove the first element and the list fills the hole automatically.
        n = new NodeImpl(counter);
        list.add(n);
        for(counter += 1; counter < 6; counter++) {
            NodeImpl testNode = new NodeImpl(counter);
            list.add(testNode);
        }
        counter--;
        list.remove(n.getKey());
        assertFalse(list.elements[0] == n);
        counter--;
        boolean holes = false;
        for(int i = 0; i < counter; i++) {
            if(list.elements[i] == null) {
                holes = true;
            }
        }
        assertFalse(holes);

        // Test if the "hole-closing" algorithm still works when 3 elements which are consecutive are removed.
        int key = 10;
        NodeImpl sameKeyOne = new NodeImpl(key);
        NodeImpl sameKeyTwo = new NodeImpl(key);
        NodeImpl sameKeyThree = new NodeImpl(key);
        NodeImpl afterKeys = new NodeImpl(777);
        list.add(sameKeyOne);
        int indexOne = counter;
        counter++;
        list.add(sameKeyTwo);
        int indexTwo = counter;
        counter++;
        list.add(sameKeyThree);
        int indexThree = counter;
        counter++;
        list.add(afterKeys);
        counter++;
        list.remove(key);
        assertFalse(sameKeyOne == list.elements[indexOne]);
        assertFalse(sameKeyTwo == list.elements[indexTwo]);
        assertFalse(sameKeyThree == list.elements[indexThree]);
        assertTrue(afterKeys == list.elements[indexOne]);
        counter -= 3;


        // Test what happens when we remove the last 2 elements
        sameKeyOne = new NodeImpl(key);
        sameKeyTwo = new NodeImpl(key);
        list.add(sameKeyOne);
        indexOne = counter;
        counter++;
        list.add(sameKeyTwo);
        indexTwo = counter;
        counter++;
        list.remove(key);
        assertNull(list.elements[indexOne]);
        assertNull(list.elements[indexTwo]);
        counter -= 2;

        // Test if it still works when at least two holes are not consecutive.
        NodeImpl between = new NodeImpl(444);
        list.add(sameKeyOne);
        indexOne = counter;
        counter++;
        list.add(between);
        counter++;
        list.add(sameKeyTwo);
        indexTwo = counter;
        counter++;
        list.add(afterKeys);
        counter++;
        list.remove(key);
        assertFalse(sameKeyOne == list.elements[indexOne]);
        assertFalse(sameKeyTwo == list.elements[indexTwo]);
        assertTrue(between == list.elements[indexOne]);
        assertTrue(afterKeys == list.elements[indexOne+1]);
        counter -= 2;
    }

    /**
     * Checks the size function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testSize() throws Exception {
        for(int i = 0; i < 20; i++) {
            NodeImpl n = new NodeImpl(i);
            list.add(n);
            assertEquals(i+1, list.size(),0.0);
        }
        for(int i = 19; i > -1; i--) {
            list.remove(i);
            assertEquals(i, list.size(),0.0);
        }
    }

    /**
     * Checks the isEmpty function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(list.isEmpty());
        NodeImpl n = new NodeImpl(1);
        list.add(n);
        assertFalse(list.isEmpty());
    }

    /**
     * Checks the get function from uebung2.ArrayList class with different amount of nodes.
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        NodeImpl n = new NodeImpl(1);
        list.add(n);
        Node test = list.get(0);
        assertTrue(test == n);

        assertNull(list.get(1));
        assertNull(list.get(-1));
    }

    /**
     * Checks the getHead function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testGetHead() throws Exception {
        NodeImpl head = new NodeImpl(1);
        list.add(head);
        insertNodes(5);
        Node test = list.getHead();
        assertSame(head, test);
    }

    /**
     * Checks the getTail function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testGetTail() throws Exception {
       insertNodes(5);
        NodeImpl tail = new NodeImpl(6);
        list.add(tail);
        Node test = list.getTail();
        assertTrue(test == tail);
        assertSame(tail, test);
    }

    /**
     * Checks the clear function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testClear() throws Exception {
        insertNodes(5);
        list.clear();
        assertEquals(0, list.size(), 0.0);
    }

    /**
     * Checks the toString function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        NodeImpl n = new NodeImpl(1);
        NodeImpl n2 = new NodeImpl(2);
        list.add(n);
        list.add(n2);
        assertEquals("12", list.toString());
    }
}