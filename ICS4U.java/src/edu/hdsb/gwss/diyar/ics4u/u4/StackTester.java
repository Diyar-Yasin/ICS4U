/**
 * Stack Tester.
 *
 * @author Wm.Muir
 * @version 2020.S2
 */
package edu.hdsb.gwss.diyar.ics4u.u4;

/**
 * @author Wm.Muir
 */
public class StackTester {

    public static void main( String[] args ) {
        
        int initialCapcaity = 11;
        Stack stack = new Stack();
        
        // PLEASE TURN ASSERTIONS ON
        // Right-Click on your Netbean Projects
        // Select:  Properties --> Run
        // VM Options Box:
        //   -ea
        
        // EXAMPLE
        //
        // TEST CASE #1 - Empty Stack
        assert( stack.isEmpty() == true );                  // stack must be empty
        assert( stack.isFull() == false );                  // stack is empty, so not full
        assert( stack.size() == 0 );                        // nothing on the stack
        assert( stack.capacity() == initialCapcaity );      // default size is 11
        assert( stack.peek() == null );                     // stack is empty, nothing on top
        assert( stack.pop() == null );                      // stack is empty, nothing to remove
        
        // TEST CASE #2 - ADD ONE ITEM ON STACK
        stack.push( 0  );
        assert( stack.isEmpty() == false );                 // stack has one value
        assert( stack.isFull() == false );                  // stack is not full
        assert( stack.size() == 1 );                        // one value added
        assert( stack.capacity() == initialCapcaity );      // default size is still 11
        assert( stack.peek() == 0 );                     // a ZERO is the only element
        
        
        // ...continue test cases
        
        // TEST CASE #3 - FILL THE STACK
        stack.push( 1 );
        stack.push( 4 );
        stack.push( 1 );
        stack.push( 4 );
        stack.push( 1 );
        stack.push( 4 );
        stack.push( 1 );
        stack.push( 4 );
        stack.push( 1 );
        stack.push( 4 );
        
        stack.push( 3 );                                      // Adds more while stack is already full, nothing happens
        
        assert(stack.isFull() == true);                       // Stack is full
        
        stack.pop();

        assert(stack.size() == 10);
        
        stack.makeEmpty();
        
        assert(stack.size() == 0);
        assert(stack.isEmpty() == true);
        
    }
    
}