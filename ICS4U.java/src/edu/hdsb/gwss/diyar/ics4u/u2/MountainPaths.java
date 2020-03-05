/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ww
 */
public class MountainPaths {

    /**
     * @param args the command line arguments
     */
    private static final String FS = File.separator;

    public static void main(String[] args) throws FileNotFoundException {

        // TASK 1
        File file = new File("." + FS + "data" + FS + "Mountaineer.txt");
        int rows = 0, cols;
        int[][] data;
        String firstLine;

        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNext()) {
            fileReader.nextLine();
            rows++;
        }

        fileReader = new Scanner(file);

        firstLine = fileReader.nextLine();
        StringTokenizer st = new StringTokenizer(firstLine);
        cols = st.countTokens();

        data = new int[cols][rows];
        System.out.println(cols);
        System.out.println(rows);

        for (int i = 0; st.hasMoreTokens();i++) {
            data[0][i] = Integer.parseInt(st.nextToken());
            System.out.println(data[0][i]);
        }

        //THIS PART DOES NOTHING YET
        for (int i = 1; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.println("ok");
            }
        }

    }
}
