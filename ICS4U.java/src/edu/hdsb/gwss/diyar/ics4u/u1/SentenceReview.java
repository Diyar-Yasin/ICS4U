/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ww
 */
public class SentenceReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        // VARIABLES
        String currentWord, currentLine;
        double averageScore;
        int score;
        File file = new File("simple.txt");
        
        // OBJECTS
        Scanner input = new Scanner(System.in);
        Scanner reader = new Scanner(file);
        
        // INPUT
        currentLine
        score = Integer.parseInt(reader.nextLine().substring(0, 1));
        currentWord = reader
    }
    
}
