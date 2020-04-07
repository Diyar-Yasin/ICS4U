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
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5;
        int counter = 0;
        triangleRun(n, counter);
    }

    public static void triangleRun(int n, int counter) {
        
        counter++;
        
        if (n > 0){ 
            
            for (int i = counter; i > 0; i--){
                if (i - counter == 0 || n - 1 == 0){
                System.out.print("1");
                }
                else if(){
                    
                }
            }
            System.out.println("");
            n--;
            triangleRun(n, counter);
        }
    }
}
