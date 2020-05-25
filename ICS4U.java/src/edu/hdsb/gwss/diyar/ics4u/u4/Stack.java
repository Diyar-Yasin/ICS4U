/**
 * Stack of Integers.
 *
 * @author Wm.Muir
 * @version 2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u4;

public class Stack {

    public static final int DEFAULT_SIZE = 11;

    private Integer[] data;

    /**
     * Stack Constructor; done for you
     */
    public Stack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Stack Constructor; done for you
     */
    public Stack(int initialCapacity) {
        data = new Integer[initialCapacity];
    }

    /**
     * Looks at the Integer object at the top of this stack without removing it
     * from the stack.
     *
     * @return the Integer at the top of this stack, or NULL if stack is empty.
     */
    public Integer peek() {

        for (int i = DEFAULT_SIZE; i > 0; i--) {
            if (data[i - 1] == null) {
            } else {
                return data[i - 1];
            }
        }
        return null;
    }

    /**
     * Removes the Integer object at the top of this stack and returns the
     * Integer Object.
     *
     * @return the Integer at the top of this stack, or NULL if the stack is
     * empty.
     */
    public Integer pop() {

        for (int i = DEFAULT_SIZE; i > 0; i--) {
            if (data[i - 1] == null) {
            } else {
                data[i - 1] = null;
                return data[i - 1];
            }
        }
        return null;
    }

    /**
     * Pushes the Integer onto the top of this stack.
     */
    public void push(Integer value) {

        int n = 0;

        for (int i = DEFAULT_SIZE; i > 0; i--) {
            if (data[i - 1] == null) {
            } else {
                n = i;
                i = 0;
            }
        }

        data[n] = value;
    }

    /**
     * Returns the number of Integers on the stack.
     *
     * @return
     */
    public int size() {

        int n = 0;

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            if (data[i] != null) {
                n++;
            } else {
                i = DEFAULT_SIZE;
            }
        }

        return n;
    }

    /**
     * Returns the current capacity of the Stack.
     *
     * @return
     */
    public int capacity() {

        return data.length;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return
     */
    public boolean isEmpty() {

        if (data[0] == null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Tests if the Stack is full.
     *
     * @return
     */
    public boolean isFull() {

        if (data[DEFAULT_SIZE - 1] != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The Stack will be empty after this call.
     */
    public void makeEmpty() {
        for (int i = DEFAULT_SIZE; i > 0; i--){
            data[i - 1] = null;
        }
    }

//This prints out the stack top down so I can test the data
//    public void output(){
//        System.out.println("NEW STACK");
//        for (int i = DEFAULT_SIZE; i > 0; i--){
//            System.out.println(data[i-1]);
//        }
//    }

}
