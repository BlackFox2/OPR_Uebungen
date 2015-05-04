package uebung2;

/**
 * Created by @author
 */
public class ArrayList implements List, Sortable {
    Node[] elements = new Node[4];
    int counter = 0;

    /**
     * Adds an element to the list.
     * <p>
     * The element is inserted at the end of the list.
     *
     * @param element
     *                  the element which should be added to the list.
     */
    @Override
    public void add(Node element) {
        if(counter == elements.length) {
            Node[] helper = new Node[elements.length*2];
            for(int i = 0; i < elements.length; i++) {
                helper[i] = elements[i];
            }
            elements = helper;
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
        for(int i = 0; i < counter-1; i++) {
            if(elements[i].getKey() == key) {
                elements[i] = null;
                counter--;
            }
        }
        for(int i = 0; i < elements.length; i++) {
            if(elements[i] == null) {
                int moved = 0;
                for(int x = i; x < counter; i++) {
                    if(moved == counter) {
                        break;
                    }
                    if(elements[x] != null) {
                        elements[x-1] = elements[x];
                        moved++;
                    }

                }
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
        if(counter == 0) {
            return true;
        }
        return false;
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
        if(index >= 0 && index <= counter) {
            return elements[index];
        }
        return null;
    }

    /**
     * @return the first element in the list.
     */
    @Override
    public Node getHead() {
        if(counter != 0) {
            return elements[0];
        }
        return null;
    }

    /**
     * @return the last element in the list.
     */
    @Override
    public Node getTail() {
        if(counter != 0) {
            return elements[counter-1];
        }
        return null;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        for(int i = 0; i < counter-1; i++) {
            elements[i] = null;
        }
        counter = 0;
    }

    @Override
    public void sortAscending() {
        int n = counter;
        do{
            int newn = 1;
            for(int i = 0; i < n-1; ++i) {
                if(elements[i].getKey() > elements[i+1].getKey()) {
                    Node helper = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = helper;
                    newn = i+1;
                }
            }
            n = newn;
        }while(n > 1);
    }

    @Override
    public void sortDescending() {
        int n = counter;
        do{
            int newn = 1;
            for(int i = 0; i < n-1; ++i) {
                if(elements[i].getKey() < elements[i+1].getKey()) {
                    Node helper = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = helper;
                    newn = i+1;
                }
            }
            n = newn;
        }while(n > 1);
    }

    public String toString() {
        String res = "";
        for(int i = 0; i < counter-1; i++) {
            res += elements[i].toString();
        }
        return res;
    }
}
