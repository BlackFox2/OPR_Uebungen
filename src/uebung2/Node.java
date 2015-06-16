package uebung2;

/**
 * This interface has to be implemented by all classes which should be added to
 * instances of a {@link List} implementation.
 *
 * @author Claudia
 * @version 1.0
 */
interface Node {

    /**
     * Returns the key value for the element.
     *
     * @return the key for the element.
     */
    int getKey();

    /**
     * @return a <code>String</code> representation of the element.
     */
    String toString();

}
