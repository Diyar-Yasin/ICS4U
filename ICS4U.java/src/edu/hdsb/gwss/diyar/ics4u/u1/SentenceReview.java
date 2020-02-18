/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        List<Double> totalScores = new ArrayList<>();
        
        totalScores.add(1.0);
        totalScores.add(2.0);
        totalScores.add(3.0);
        
        totalScores.remove(1);
        for(int n = 0; n < totalScores.size();n++){
            System.out.println(totalScores.get(n));
        }
    }
}
