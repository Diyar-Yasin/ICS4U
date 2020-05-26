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
        if (head == null) {
            head = new Node(str);
            tail = new Node(str);                                                    //needed?
        } else {
            Node node = new Node(str);
            node.next = head;
            head = node;
        }
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

        if (!isEmpty()) {

            //Case: If the head node is to be removed
            if (head.getData().equals(str)) {
                head = head.next;
            } //Case: If a body node is to be removed
            else {
                while (!head.next.getData().equals(str) && strExists) {
                    head = head.next;

                    if (head.next == null) {
                        strExists = false;
                    }
                }
                if (strExists) {
                    head.next = head.next.next;                   //If the tail is to be removed, head.next.next should be a null
                }
            }
        }
    }

    public String removeHead() {
        // TO DO
        String headNode = null;

        if (!isEmpty()) {
            headNode = head.getData();
            head = head.next;
        }

        return headNode;
    }

    public String removeTail() {
        // TO DO
        String tailNode = null;

        if (!isEmpty()) {
            tailNode = tail.getData();
            tail = null;                                //Is this a correct way to do things?
            
            while (head.next != null){
                head = head.next;
            }
            head.next = tail;                           //Is this redundant? Did I just set tail to null and then do it again?
        }

        return tailNode;
    }

    /**
     * Retrieves, but does not remove, the head of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String head() {
        String headNode = null;

        if (!isEmpty()) {
            headNode = head.getData();
        }

        return headNode;
    }

    /**
     * Retrieves, but does not remove, the tail of this Linked List, or returns
     * null if this Linked List is empty.
     */
    public String tail() {
        String tailNode = null;

        if (!isEmpty()) {
            tailNode = tail.getData();
        }

        return tailNode;
    }

    /**
     * Returns the number of Strings in the Linked List.
     *
     * @return
     */
    public int size() {
        int counter = 0;
        pointer = head;

        if (pointer != null) {
            counter++;
            while (pointer.next != null) {
                counter++;
                pointer = head.next;
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
        head = new Node(null);
        tail = new Node(null);
    }

    /**
     * Creates a String that lists the nodes of the linked list.
     *
     * Head --> A --> B -- > C --> Tail
     *
     * @return string
     */
    public String toString() {
        String ll = "";
        pointer = head;

        while (pointer != null) {

            ll = ll + pointer.getData();

            if (pointer.next == null) {
                ll = ll + " --> ";
            }

            pointer = pointer.next;
        }

        ll = ll + "null";

        return ll;
    }

}
