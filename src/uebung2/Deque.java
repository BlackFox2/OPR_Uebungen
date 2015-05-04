package uebung2;

/**
 * Created by @author
 */
public interface Deque {
    void addHead(Node e);
    void addTail(Node e);
    void removeHead();
    void removeTail();
    Node getHead();
    Node getTail();
}
