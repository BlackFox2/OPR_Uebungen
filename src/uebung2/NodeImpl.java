package uebung2;

/**
 * Created by @author
 */
public class NodeImpl implements Node{
    int key = 0;

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

    @Override
    public String toString() {
        return Integer.toString(key);
    }


}
