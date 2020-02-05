/*
Name: Diyar Yasin
Date: Feb. 15, 2019
Desc: Takes a year and inputs the date of Easter Sunday
 */
package edu.hdsb.gwss.diyar.ics4u.u1;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author ww
 */
public class EasterCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Get year and then begin calculate method
        System.out.println("What year is it?");
        Scanner input = new Scanner(System.in);
        
        int year = input.nextInt();
        
        calculate( year );
        
    }
    
    public static void calculate(int year) {
        int a, b, c, d, e, f, g, h, i, j, k, m, p, month, day;
        
        // calculate the day and month
        
        a = year%19;
        b = year/100;
        c = year%100;
        d = b/4;
        e = b%4;
        f = (b+8)/25;
        g = (b - f + 1)/3;
        h = (19 * a + b - d - g + 15)%30;
        i = c/4;
        k = c%4;
        j = (32 + 2 * e + 2 * i - h - k)/7;
        m = (a + 11 * h + 22 * j)/451;
        p = (h + j - 7 * m + 114)%31;
        month = (h + j - 7 * m + 114)/31;
        day = p + 1;
        
        System.out.println("Easter Sunday will be on " + month + "/" + day + "/" + year );
        
        
    }
    
}
