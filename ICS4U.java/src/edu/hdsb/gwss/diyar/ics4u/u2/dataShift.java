/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u2;

import java.awt.KeyboardFocusManager;

/**
 *
 * @author ww
 */
public class dataShift {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        // VARIABLES
        int[][] data = {
            {2, 0, 0, 2},
            {0, 2, 2, 0},
            {0, 0, 0, 2},
            {2, 0, 2, 2}
        };

        display(data);

        shiftLeft(data);
        mergeLeft(data);
        shiftLeft(data);
    }

    public static void display(int[][] data) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(data[r][c] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] shiftLeft(int[][] data) {

        // VARIABLES
        int first, second;

        System.out.println("SHIFT LEFT");

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                first = data[r][c];
                second = data[r][c + 1];

                if (first == 0) {
                    data[r][c] = second;
                    data[r][c + 1] = 0;
                }

            }
        }

        display(data);

        return data;
    }

    public static int[][] mergeLeft(int[][] data) {

        int first, second;

        System.out.println("MERGE LEFT");

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                first = data[r][c];
                second = data[r][c + 1];

                if (first == second) {
                    data[r][c] = first * 2;
                    data[r][c + 1] = 0;
                }
            }
        }

        display(data);

        return data;
    }

}
