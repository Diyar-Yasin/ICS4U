/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u3;

/**
 *
 * @author Diyar
 */
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x = -5, y = -2, m = 2, n = 1;               //x, y, m, and n can be assigned any value and will undergo the functins defined
        // below
        System.out.println(functionRun(x, y));          //The first function takes x and y
        System.out.println(ackerRun(m, n));             //The second function will take m and n
    }

    public static int functionRun(int x, int y) {

        int answer;

        if (x < y) {                                    //There are 3 cases, if x < y recall the function flipping x and y and making it 
            answer = -functionRun(y, x);                // negative afterward
        } else if (x > y) {                             //If x > y recall the function where x = x - 1 and add one to what the recall returns
            answer = 1 + functionRun(x - 1, y);
        } else {                                        //If x == y, the answer is 0
            answer = 0;
        }

        return answer;
    }

    public static int ackerRun(int m, int n) {

        int answer;

        if (m == 0) {                                   //Again 3 cases, m == 0: answer is n + 1, m > 0 and n == 0 recall the function
            answer = n + 1;                             // passing it m = m - 1 and n = 1, otherwise recall the function recalling the
        } else if (m > 0 && n == 0) {                   // the function twice (once within itself), where m = m - 1 and n is the second
            answer = ackerRun(m - 1, 1);                // recall of ackerRun with m and n = n - 1.
        } else {
            answer = ackerRun(m - 1, ackerRun(m, n - 1));
        }

        return answer;
    }

}
