/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.sideprojects;

/**
 *
 * @author Diyar
 */
public class ChessTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "C2";

        int col = input.charAt(0);
        int row = Integer.parseInt(input.substring(1, 2));
        
        System.out.println(col + " " + row);
    }
    
}
