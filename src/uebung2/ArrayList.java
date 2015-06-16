package uebung2;

/**
 * Class which provides an easy way to handle lists of objects. All the trouble with array size, deleting elements and
 * filling the occuring holes will be handled.
 * The class provides methods for different sorting orders.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class ArrayList implements List, Sortable, Deque {
    Node[] elements = new Node[4];
    int counter = 0;

    /**
     * Adds an element to the list.
     * <p>
     * The element is inserted at the end of the list.
     *
     * @param element the element which should be added to the list.
     */
    @Override
    public void add(Node element) {
        if (counter == elements.length) {
            elements = doubleArraySize(elements, 0);
        }
        elements[counter] = element;
        counter++;
    }

    /**
     * Removes elements with the given key from the list.
     * <p>
     * If there are more elements with the same key, all elements with the key
     * are removed.
     *
     * @param key all elements with this key are to be removed
     */
    @Override
    public void remove(int key) {
        int max = counter;                  /* save how many elements there are in the list for later*/
        int lastIndex = counter - 1;
        /* we search from end to beginning because it's easier to handle if the last elements are removed */
        for (int i = lastIndex; i > -1; i--) {/* analyse how many elements will be removed and remove them */
            if (elements[i].getKey() == key) {
                if (i == lastIndex) {
                    lastIndex--;            /* when the last item is removed the last index is decreased */
                }
                elements[i] = null;
                counter--;
            }
        }

        /* at this step it is assumed that every element which has been removed and wasn't the last element
         * left a gap in our list.
         * max = number of elements before deletion
         * lasIndex = index of the now last element
         * max - (lastIndex+1) = how many elements from the end have been removed
         * max - (max - (lastIndex+1)) = how many positions there are from the beginning to the end
         * (max - (max - (lastIndex+1))) - counter = number of gaps (under the above assumption)
         * */
        int gaps = (max - (max - (lastIndex + 1))) - counter;
        int closed = 0;                     /* how many gaps are closed */
        for (int i = 0; closed < gaps; i++) {
            if (elements[i] == null) {       /* beginning of a gap */
                int y = i + 1;
                while (elements[y] == null) {
                    y++;                    /* the actual gap consists of more than 1 positions */
                    if (y - i > 1) {
                        gaps -= (y - i);             /* decrease the amount of gaps */
                    }
                }
                for (int x = y; x <= lastIndex; x++) {   /* close the actual gap by moving the elements */
                    elements[i + (x - y)] = elements[x];
                    elements[x] = null;
                }
                closed++;                   /* gap closed */
            }
        }
    }

    /**
     * @return the current number of elements in the list.
     */
    @Override
    public int size() {
        return counter;
    }

    /**
     * @return <code>true</code> if there are no elements in the list,
     * <code>false</code> otherwise
     */
    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * Returns the element with the given index from the list.
     * <p>
     * If the index has no suitable value, the method returns <code>null</code>.
     *
     * @param index the position of the element in the list
     * @return the element at the given position
     */
    @Override
    public Node get(int index) {
        if (index >= 0 && index < counter) {
            return elements[index];
        }
        return null;
    }

    /**
     * @return the first element in the list.
     */
    @Override
    public Node getHead() {
        if (counter != 0) {
            return elements[0];
        }
        return null;
    }

    /**
     * @return the last element in the list.
     */
    @Override
    public Node getTail() {
        if (counter != 0) {
            return elements[counter - 1];
        }
        return null;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < counter - 1; i++) {
            elements[i] = null;
        }
        counter = 0;
    }

    /**
     * Sorts the elements in the list in ascending order regarding the elements key value
     */
    @Override
    public void sortAscending() {
        int j;
        boolean flag = true;
        Node temp;
        while (flag) {
            flag = false;
            for (j = 0; j < counter - 1; j++) {
                if (elements[j].getKey() > elements[j + 1].getKey()) {
                    temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    /**
     * Sorts the elements in the list in descending order regarding the elements key value
     */
    @Override
    public void sortDescending() {
        int j;
        boolean flag = true;
        Node temp;
        while (flag) {
            flag = false;
            for (j = 0; j < counter - 1; j++) {
                if (elements[j].getKey() < elements[j + 1].getKey()) {
                    temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    /**
     * Doubles the size of the array.
     * Values from the original array are copied into the new one including the possibility to copy it with an offset.
     *
     * @param array  array to double
     * @param offset where to copy the nodes of the old array to the new one
     * @return the new array
     */
    private Node[] doubleArraySize(Node[] array, int offset) {
        Node[] res = new Node[array.length * 2];
        System.arraycopy(array, 0, res, offset, array.length);
        return res;
    }

    /**
     * Adds a node to the beginning of the list.
     *
     * @param e node to add to the beginning
     */
    @Override
    public void addHead(Node e) {
        Node[] helper = elements;
        if (counter + 1 >= elements.length) {      /* check if there's enough space left for the new node */
            elements = doubleArraySize(helper, 1);
        } else {
            System.arraycopy(helper, 0, elements, 1, helper.length - 1);
        }
        elements[0] = e;
        counter++;
    }

    /**
     * Adds a node at the end of the list.
     *
     * @param e node to add at the end
     */
    @Override
    public void addTail(Node e) {
        add(e);
    }

    /**
     * Removes the first node of the list
     */
    @Override
    public void removeHead() {
        remove(elements[0].getKey());
    }

    /**
     * Removes the last node in the list
     */
    @Override
    public void removeTail() {
        remove(elements[counter - 1].getKey());
    }

    /**
     * Calls the toString method of every element in the list and connects the results together
     *
     * @return string with all returns of toString methods
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < counter; i++) {
            res += elements[i].toString();
        }
        return res;
    }
}
