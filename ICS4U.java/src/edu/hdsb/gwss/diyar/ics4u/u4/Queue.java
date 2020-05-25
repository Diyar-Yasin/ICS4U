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
        this( DEFAULT_SIZE );
    }

    /**
     * Queue Constructor; done for you
     */
    public Queue( int initialCapacity ) {
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
        return null;
    }

    /**
     * Retrieves, but does not remove, the END of this queue, or returns null if
     * this queue is empty.
     *
     * @return the head of this queue.
     */
    public String end() {
        return null;
    }

    /**
     * Inserts the String into this queue, if space is available.
     *
     * @param value
     */
    public void enqueue( String value ) {

    }

    /**
     * Retrieves and removes the String at the FRONT of this queue.
     *
     * @return the head of this queue.
     */
    public String dequeue() {
        return null;
    }

    /**
     * Returns the number of Strings in the QUEUE.
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * Returns the capacity of the QUEUE.
     *
     * @return
     */
    public int capacity() {
        return -1;
    }

    /**
     * Tests if this QUEUE is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Tests if the QUEUE is full.
     *
     * @return
     */
    public boolean isFull() {
        return false;
    }

    /**
     * The QUEUE will be empty after this call returns.
     */
    public void makeEmpty() {

    }

    /**
     *
     */
    public String toString() {

        String s = "---------------------------------------------\n";
        s = s + "QUEUE: \n";
        for( int i = 0; i < data.length; i++ ) {
            s = s + s.format( "%5s |", data[i] );
        }
        s = s + "\n";
        if( this.front != -1 ) {
            for( int i = 0; i < data.length; i++ ) {
                if( this.front == this.back && this.front == i ) {
                    s = s + s.format( "%5s |", "F / B" );
                } else if( this.front == i ) {
                    s = s + s.format( "%5s |", "  F  " );
                } else if( this.back == i ) {
                    s = s + s.format( "%5s |", "  B  " );
                } else {
                    s = s + s.format( "%5s |", "     " );
                }

            }

        }

        return s;
    }

}