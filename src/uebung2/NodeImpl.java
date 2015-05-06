package uebung2;

/**
 * Only a test implementation to put in the ArrayList object for testing purposes. No real functionality implemented.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class NodeImpl implements Node{
    private int key = 0;

    public NodeImpl(int value) {
        this.key = value;
    }
    /**
     * Returns the key value for the element.
     *
     * @return the key for the element.
     */
    @Override
    public int getKey() {
        return key;
    }

    /**
     * @return a <code>String</code> representation of the element.
     */
    @Override
    public String toString() {
        return Integer.toString(key);
    }


}
