package uebung2;

/**
 * Created by @author
 */
interface Deque {
    /**
     * Adds a node to the beginning of the list.
     *
     * @param e node to add to the beginning
     */
    void addHead(Node e);

    /**
     * Adds a node at the end of the list.
     *
     * @param e node to add at the end
     */
    void addTail(Node e);

    /**
     * Removes the first node of the list
     */
    void removeHead();

    /**
     * Removes the last node in the list
     */
    void removeTail();

    /**
     * @return the first element in the list.
     */
    Node getHead();

    /**
     * @return the last element in the list.
     */
    Node getTail();
}
