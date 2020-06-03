/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u4;

/**
 *
 * @author Wm.Muir
 */
public class LinkedListTester {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {

        LinkedList ll = new LinkedList();

        // EMPTY
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // REMOVE: EMPTY
        System.out.println( "CASE 1: REMOVE NON EXISTING" );
        ll.remove( "ABC" );
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );
        
        // ADD @ FRONT; SIZE 1
        System.out.println( "CASE 2: ADD AT FRONT / REMOVE ONLY ELEMENT" );
        ll.addAtFront( "A" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.head().equals( "A" ) );
        assert ( ll.tail().equals( "A" ) );
        assert ( ll.size() == 1 );
        assert ( !ll.isEmpty() );

        // REMOVE "A"
        ll.remove( "A" );
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );
        
        
        System.out.println("CREATE LL: B --> A --> B --> C --> null");
        ll.addAtFront("A");
        ll.addAtFront("B");
        ll.addAtEnd("B");
        ll.addAtEnd("C");
        
        assert( ll.head().equals("B"));
        assert( ll.tail().equals("C"));
        assert( ll.size() == 4);
        System.out.println( "DATA: " + ll.toString() );
         
        assert( ll.removeHead().equals("B"));
        assert( ll.removeTail().equals("C"));
        System.out.println( "DATA: " + ll.toString() );
        
        // MAKE EMPTY THEN PRINT
        ll.makeEmpty();
        assert( ll.head() == null );
        assert( ll.tail() == null );
        System.out.println( "DATA: " + ll.toString() );                          //Even though Head and Tail are null
                                                                                 //they will always exist
    }

}