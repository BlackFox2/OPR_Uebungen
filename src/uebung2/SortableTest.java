package uebung2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitTest for testing the uebung2.ArrayList class and the functionality needed from implementing uebung2.Sortable
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class SortableTest {
    private ArrayList list = new ArrayList();

    /**
     * Checks the sortAscending function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testSortAscending() throws Exception {
        NodeImpl n = new NodeImpl(1);
        NodeImpl n1 = new NodeImpl(2);
        NodeImpl n2 = new NodeImpl(3);
        NodeImpl n3 = new NodeImpl(4);
        NodeImpl n4 = new NodeImpl(5);
        list.add(n3);
        list.add(n);
        list.add(n4);
        list.add(n1);
        list.add(n2);
        list.sortAscending();
        for(int i = 0; i < 5; i++) {
            assertEquals(i+1, list.get(i).getKey(), 0.0);
        }

    }

    /**
     * Checks the sortDescending function from uebung2.ArrayList class.
     * @throws Exception
     */
    @Test
    public void testSortDescending() throws Exception {
        NodeImpl n = new NodeImpl(1);
        NodeImpl n1 = new NodeImpl(2);
        NodeImpl n2 = new NodeImpl(3);
        NodeImpl n3 = new NodeImpl(4);
        NodeImpl n4 = new NodeImpl(5);
        list.add(n3);
        list.add(n);
        list.add(n4);
        list.add(n1);
        list.add(n2);
        list.sortDescending();
        for(int i = 0; i < 5; i++) {
            assertEquals(5-i, list.get(i).getKey(), 0.0);
        }

    }
}