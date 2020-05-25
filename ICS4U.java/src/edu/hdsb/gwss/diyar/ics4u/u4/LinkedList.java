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
    private Node pointer;

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
    public void addAtFront(String str) {
        // TO DO
        Node node = new Node(str);
        node.next = head;
        head = node;

    }

    /**
     * Adds the String to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd(String str) {
        // TO DO
        Node node = new Node(str);

        while (node.next != null) {
            node = node.next;
        }

        node.next = node;
    }

    /**
     * Removes the first occurrence of the given string.
     *
     * @param str
     */
    public void remove(String str) {
        // TO DO
        boolean strExists = true;

        pointer = head;

        if (!isEmpty() && pointer.next != null) {
            while (!pointer.next.equals(str)) {
                if (pointer.next != null) {
                    pointer = pointer.next;
                } else {
                    strExists = false;
                }
            }
            if (strExists) {
                pointer.next = pointer.next.next;
                //Set the pointer of the current node to a node two down (skipping the node with str in it).
            }
        }
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
        int counter = 0;

        if (head != null) {
            counter++;
            while (pointer.next != null) {
                counter++;
                pointer = pointer.next;
            }
        }

        return counter;
    }

    /**
     * Tests if this Linked List is empty.
     *
     * @return
     */
    public boolean isEmpty() {

        if (head == null) {
            return true;
        }
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
