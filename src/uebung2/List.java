package uebung2;

/**
 * A dynamically growing list.
 * <p>
 * The elements stored in the list each have a specific key. This key is not
 * necessarily unique throughout the list.
 * 
 * @see Node
 * 
 * @author Claudia
 * @version 1.0
 */
interface List {

	/**
	 * Adds an element to the list.
	 * 
	 * The element is inserted at the end of the list.
	 * 
	 * @param element
	 * 					the element which should be added to the list.
	 */
	void add(Node element);

	/**
	 * Removes elements with the given key from the list.
	 * <p>
	 * If there are more elements with the same key, all elements with the key
	 * are removed.
	 * 
	 * @param key
	 *            all elements with this key are to be removed
	 */
	void remove(int key);

	/**
	 * @return the current number of elements in the list.
	 */
	int size();

	/**
	 * @return <code>true</code> if there are no elements in the list,
	 *         <code>false</code> otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the element with the given index from the list.
	 * 
	 * If the index has no suitable value, the method returns <code>null</code>.
	 * 
	 * @param index
	 *            the position of the element in the list
	 * @return the element at the given position
	 */
	Node get(int index);

	/**
	 * @return the first element in the list.
	 */
	Node getHead();

	/**
	 * @return the last element in the list.
	 */
	Node getTail();

	/**
	 * Removes all elements from the list.
	 */
	void clear();

	/**
	 * @return a <code>String</code> representation of the list.
	 */
	String toString();

}
 
