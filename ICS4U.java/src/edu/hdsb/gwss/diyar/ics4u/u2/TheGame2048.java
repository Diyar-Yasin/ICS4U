/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.u2;

import static edu.hdsb.gwss.diyar.ics4u.u2.dataShift.display;
import static edu.hdsb.gwss.diyar.ics4u.u2.dataShift.mergeLeft;
import static edu.hdsb.gwss.diyar.ics4u.u2.dataShift.shiftLeft;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author ww
 */
public class TheGame2048 extends javax.swing.JFrame {

    private int[][] data;
    private JLabel[][] boxes;

    /**
     * Creates new form TheGame2048
     */
    public TheGame2048() {
        initComponents();

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

        manager.addKeyEventDispatcher(new MyDispatcher());

        data = new int[4][4];
        boxes = new JLabel[4][4];

        // SORRY!
        boxes[0][0] = jLabel00;
        boxes[0][1] = jLabel01;
        boxes[0][2] = jLabel02;
        boxes[0][3] = jLabel03;

        boxes[1][0] = jLabel10;
        boxes[1][1] = jLabel11;
        boxes[1][2] = jLabel12;
        boxes[1][3] = jLabel13;

        boxes[2][0] = jLabel20;
        boxes[2][1] = jLabel21;
        boxes[2][2] = jLabel22;
        boxes[2][3] = jLabel23;

        boxes[3][0] = jLabel30;
        boxes[3][1] = jLabel31;
        boxes[3][2] = jLabel32;
        boxes[3][3] = jLabel33;

        // RANDOM
        random(data);
        refreshScreen();
    }

    private class MyDispatcher implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent evt) {
            if (evt.getID() == KeyEvent.KEY_PRESSED) {
                System.out.print("KEY PRESSED: ");

                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        System.out.println("UP");
                        shiftUp(data);
                        mergeUp(data);
                        shiftUp(data);
                        mergeUp(data);
                        shiftUp(data);
                        random(data);
                        refreshScreen();
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("DOWN");
                        shiftDown(data);
                        mergeDown(data);
                        shiftDown(data);
                        mergeDown(data);
                        shiftDown(data);
                        random(data);
                        refreshScreen();
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("LEFT");
                        shiftLeft(data);
                        mergeLeft(data);
                        shiftLeft(data);
                        mergeLeft(data);
                        shiftLeft(data);
                        random(data);
                        refreshScreen();
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("RIGHT");
                        shiftRight(data);
                        mergeRight(data);
                        shiftRight(data);
                        mergeRight(data);
                        shiftRight(data);
                        random(data);
                        refreshScreen();
                        break;
                } // END Key Even

            } // END METHOD: dispatchKeyEvent
            return false;
        } // END CLASS: MyDispatcher
    }

    public void refreshScreen() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (data[r][c] != 0) {
                    boxes[r][c].setText("" + data[r][c]);
                } else {
                    boxes[r][c].setText("");
                }

            }
        }
    }

    public static void random(int[][] data) {
        
        // VARIABLES
        int random1 = (int) (Math.random() * 4), random2 = (int) (Math.random() * 4);

        // INPUT
        while (random1 == random2 && data[random1][random1] != 0 && data[random2][random2] != 0 ) {
            random1 = (int) (Math.random() * 4);
            random2 = (int) (Math.random() * 4);
        }
        data[random1][random1] = 4;
        data[random2][random2] = 2;
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

        return data;
    }

    public static int[][] shiftRight(int[][] data) {

        // VARIABLES
        int first, second;

        // INPUT
        for (int r = data.length - 1; r >= 0; r--) {
            for (int c = data.length - 1; c > 0; c--) {
                first = data[r][c];
                second = data[r][c - 1];

                if (first == 0) {
                    data[r][c] = second;
                    data[r][c - 1] = 0;
                }
            }
        }

        return data;
    }

    public static int[][] mergeRight(int[][] data) {

        //  VARIABLES
        int first, second;

        // INPUT
        for (int r = data.length - 1; r >= 0; r--) {
            for (int c = data.length - 1; c > 0; c--) {
                first = data[r][c];
                second = data[r][c - 1];

                if (first == second) {
                    data[r][c] = first * 2;
                    data[r][c - 1] = 0;
                }
            }
        }

        return data;
    }

    public static int[][] shiftUp(int[][] data) {

        // VARIABLES
        int first, second;

        // INPUT
        for (int r = 0; r < data.length - 1; r++) {
            for (int c = 0; c < data.length; c++) {
                first = data[r][c];
                second = data[r + 1][c];

                if (first == 0) {
                    data[r][c] = second;
                    data[r + 1][c] = 0;
                }
            }
        }
        return data;
    }

    public static int[][] mergeUp(int[][] data) {

        // VARIABLES
        int first, second;

        // INPUT
        for (int r = 0; r < data.length - 1; r++) {
            for (int c = 0; c < data.length; c++) {
                first = data[r][c];
                second = data[r + 1][c];

                if (first == second) {
                    data[r][c] = first * 2;
                    data[r + 1][c] = 0;
                }
            }
        }
        return data;
    }

    public static int[][] shiftDown(int[][] data) {

        // VARIABLES
        int first, second;

        // INPUT
        for (int r = data.length - 1; r > 0; r--) {
            for (int c = data.length - 1; c >= 0; c--) {
                first = data[r][c];
                second = data[r - 1][c];

                if (first == 0) {
                    data[r][c] = second;
                    data[r - 1][c] = 0;
                }
            }
        }

        return data;
    }

    public static int[][] mergeDown(int[][] data) {

        // VARIABLES
        int first, second;

        // INPUT
        for (int r = data.length - 1; r > 0; r--) {
            for (int c = data.length - 1; c >= 0; c--) {
                first = data[r][c];
                second = data[r - 1][c];

                if (first == second) {
                    data[r][c] = first * 2;
                    data[r - 1][c] = 0;
                }
            }
        }
        return data;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelTop.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("POGGERS");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel00.setBackground(new java.awt.Color(255, 255, 255));
        jLabel00.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel00.setText("        2");
        jLabel00.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel10.setText("        2");
        jLabel10.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel12.setText("        2");
        jLabel12.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel11.setText("        2");
        jLabel11.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel20.setText("        2");
        jLabel20.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel21.setText("        2");
        jLabel21.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel13.setText("        2");
        jLabel13.setOpaque(true);

        jLabel02.setBackground(new java.awt.Color(255, 255, 255));
        jLabel02.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel02.setText("        2");
        jLabel02.setOpaque(true);

        jLabel01.setBackground(new java.awt.Color(255, 255, 255));
        jLabel01.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel01.setText("        2");
        jLabel01.setOpaque(true);

        jLabel03.setBackground(new java.awt.Color(255, 255, 255));
        jLabel03.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel03.setText("        2");
        jLabel03.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel15.setText("        2");
        jLabel15.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel16.setText("        2");
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel17.setText("        2");
        jLabel17.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel23.setText("        2");
        jLabel23.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel22.setText("        2");
        jLabel22.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel30.setText("        2");
        jLabel30.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel31.setText("        2");
        jLabel31.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel32.setText("        2");
        jLabel32.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel33.setText("        2");
        jLabel33.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheGame2048().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
