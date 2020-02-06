/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author ww
 */
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        double lat1, lon1, lat2, lon2, dist;
        
        // OBJECTS
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please input in radians.. ");
        
        System.out.println("Input the first latitude coordinate: ");
        lat1 = input.nextDouble();
        
        System.out.println("Input the first longitude coordinate: ");
        lon1 = input.nextDouble();
        
        System.out.println("Input the second latitude coordinate: ");
        lat2 = input.nextDouble();
        
        System.out.println("Input the second longitude coordinate: ");
        lon2 = input.nextDouble();
        
        //I need to add the formula to calculate and convert the input to radians maybe?
        
        dist = 6378.8 * Math.acos(Math.sin(lat1) * Math.sin(lat2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2-lon1));
        
        System.out.println("It is a " + dist + " km distance.");
    }
    
}
