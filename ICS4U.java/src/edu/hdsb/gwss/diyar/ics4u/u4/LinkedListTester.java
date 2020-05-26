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
        
        // ...add more test cases
    }

}