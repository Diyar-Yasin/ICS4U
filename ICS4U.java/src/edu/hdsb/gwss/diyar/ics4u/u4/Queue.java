/**
 * Queue of Strings.
 *
 * @author Wm.Muir
 * @version 2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u4;

public class Queue {

    public static final int DEFAULT_SIZE = 11;

    // DATA
    private String[] data;

    // POINTER TO THE TOP OF THE STACK
    private int front;
    private int back;

    /**
     * Queue Constructor; done for you
     */
    public Queue() {
        this(DEFAULT_SIZE);
    }

    /**
     * Queue Constructor; done for you
     */
    public Queue(int initialCapacity) {
        this.front = -1;
        this.back = -1;
        this.data = new String[initialCapacity];
    }

    /**
     * Retrieves, but does not remove, the front of this queue, or returns null
     * if this queue is empty.
     *
     * @return the head of this queue.
     */
    public String front() {

        if (data[0] != null) {
            return data[0];
        }

        return null;
    }

    /**
     * Retrieves, but does not remove, the END of this queue, or returns null if
     * this queue is empty.
     *
     * @return the head of this queue.
     */
    public String end() {

        for (int i = data.length - 1; i > 0; i--) {
            if (data[i] == null) {

            } else {
                return data[i];
            }
        }
        return null;

    }

    /**
     * Inserts the String into this queue, if space is available.
     *
     * @param value
     */
    public void enqueue(String value) {

        if (!isFull()) {
            for (int i = data.length; i > 1; i--) {
                data[i - 1] = data[i - 2];
            }
            data[0] = value;
        }
    }

    /**
     * Retrieves and removes the String at the FRONT of this queue.
     *
     * @return the head of this queue.
     */
    public String dequeue() {

        int size = size();

        String holder = data[size];

        if (!isEmpty()) {
            data[size - 1] = null;
        }

        return holder;
    }

    /**
     * Returns the number of Strings in the QUEUE.
     *
     * @return
     */
    public int size() {

        int n = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                n++;
            } else {
                i = data.length;
            }
        }
        return n;
    }

    /**
     * Returns the capacity of the QUEUE.
     *
     * @return
     */
    public int capacity() {
        return data.length;
    }

    /**
     * Tests if this QUEUE is empty.
     *
     * @return
     */
    public boolean isEmpty() {

        if (data[0] == null) {
            return true;
        }
        return false;
    }

    /**
     * Tests if the QUEUE is full.
     *
     * @return
     */
    public boolean isFull() {

        if (data[data.length - 1] != null) {
            return true;
        }
        return false;
    }

    /**
     * The QUEUE will be empty after this call returns.
     */
    public void makeEmpty() {
        for (int i = data.length; i > 0; i--) {
            data[i - 1] = null;
        }
    }

    /**
     *
     */
    public String toString() {

        String s = "---------------------------------------------\n";
        s = s + "QUEUE: \n";
        for (int i = 0; i < data.length; i++) {
            s = s + s.format("%5s |", data[i]);
        }
        s = s + "\n";
        if (this.front != -1) {
            for (int i = 0; i < data.length; i++) {
                if (this.front == this.back && this.front == i) {
                    s = s + s.format("%5s |", "F / B");
                } else if (this.front == i) {
                    s = s + s.format("%5s |", "  F  ");
                } else if (this.back == i) {
                    s = s + s.format("%5s |", "  B  ");
                } else {
                    s = s + s.format("%5s |", "     ");
                }

            }

        }

        return s;
    }

}
