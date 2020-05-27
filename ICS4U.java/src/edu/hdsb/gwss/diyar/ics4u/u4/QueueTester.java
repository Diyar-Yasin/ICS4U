/*
 */
package edu.hdsb.gwss.diyar.ics4u.u4;

/**
 */
public class QueueTester {

    /**
     */
    public static void main( String[] args ) {

        // PLEASE TURN ASSERTIONS ON
        // Right-Click on your Netbean Projects
        // Select:  Properties --> Run
        // VM Options Box:
        //   -ea
        
        
        // EXAMPLE
        int initialCapcaity = 26;
        Queue q = new Queue( initialCapcaity );

        // TEST CASE #1 - Empty Stack
        assert ( q.size() == 0 );
        assert ( q.isEmpty() == true );
        assert ( q.isFull() == false );
        System.out.println( "CASE 1: DEQUEUE EMPTY" );
        assert ( q.dequeue() == null );
        assert ( q.front() == null);
        assert ( q.end() == null);
        System.out.println( q.toString() );
        
        // TEST CASE #2 - ADD ONE ITEM ON STACK
        q.enqueue( "A" );
        assert( q.isEmpty() == false );                 // queue has one value
        assert( q.isFull() == false );                  // queue is not full
        assert( q.size() == 1 );                        // one value added
        assert( q.capacity() == initialCapcaity );      // default size is still 26
        assert( q.front().equals( "A" ) );              // a A is the only element
        q.dequeue();
        
        System.out.println( q.toString() );
        
        // TEST CASE #3 - FULL STACK
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        q.enqueue( "X" );
        
        assert( q.isFull() == true);
        System.out.println( q.toString() );
        
        q.enqueue( "X" );                                           //Tries adding another item to already full queue
        
        q.makeEmpty();
        assert( q.isEmpty() == true);
    }

}