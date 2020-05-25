/**
 * Linked List of String Nodes
 *
 * @author Wm.Muir
 * @version 2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u4;

/**
 * Linked List Interface
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
public class LinkedList {

    // HEAD & TAIL
    private Node head;
    private Node tail;

    /**
     * Linked List Constructor; done for you
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds the String to the front of the linked list.
     *
     * @param str
     */
    public void addAtFront( String str ) {
        // TO DO
    }

    /**
     * Adds the String to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str ) {
        // TO DO
    }

    /**
     * Removes the first occurrence of the given string.
     *
     * @param str
     */
    public void remove( String str ) {
        // TO DO
    }

    public String removeHead() {
        // TO DO
        return null;
    }

    public String removeTail() {
        // TO DO
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String head() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the tail of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String tail() {
        return null;
    }

    /**
     * Returns the number of Strings in the Linked List.
     *
     * @return
     */
    public int size() {
        return -1;
    }

    /**
     * Tests if this Linked List is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * The Linked List will be empty after this call returns.
     */
    public void makeEmpty() {

    }

    /**
     * Creates a String that lists the nodes of the linked list.
     *
     * Head --> A --> B -- > C --> Tail
     *
     * @return string
     */
    public String toString() {
        return null;
    }

}