/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Computer
 */
public class HomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() throws SQLException {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        jDesktopPane1.removeAll();

        BookingRoom bk = new BookingRoom();
        jDesktopPane1.add(bk);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnManagementBookingRoom = new javax.swing.JButton();
        btnManagementFood = new javax.swing.JButton();
        btnManagementEmpl = new javax.swing.JButton();
        btnManagementRoom = new javax.swing.JButton();
        btnManagementGuess = new javax.swing.JButton();
        btnManagementStaticss = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khách Sạn");

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1225, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnManagementBookingRoom.setText("Quản Lý Đặt Phòng");
        btnManagementBookingRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagementBookingRoomMouseClicked(evt);
            }
        });
        btnManagementBookingRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementBookingRoomActionPerformed(evt);
            }
        });

        btnManagementFood.setText("Quản Lý Hàng");
        btnManagementFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementFoodActionPerformed(evt);
            }
        });

        btnManagementEmpl.setText("Quản Lý Nhân Viên");
        btnManagementEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementEmplActionPerformed(evt);
            }
        });

        btnManagementRoom.setText("Quản Lý Phòng");
        btnManagementRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementRoomActionPerformed(evt);
            }
        });

        btnManagementGuess.setText("Quản Lý Khách");
        btnManagementGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementGuessActionPerformed(evt);
            }
        });

        btnManagementStaticss.setText("Quản Lý Thống Kê");
        btnManagementStaticss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementStaticssActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power-on.png"))); // NOI18N
        jLabel1.setName("logout"); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MENU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManagementBookingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManagementFood, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(btnManagementEmpl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(btnManagementRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(btnManagementGuess, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(btnManagementStaticss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManagementBookingRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManagementFood, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManagementEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManagementRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManagementGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManagementStaticss, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnManagementBookingRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagementBookingRoomMouseClicked
        try {
            // TODO add your handling code here:
            jDesktopPane1.getComponent(0).setVisible(false);
            jDesktopPane1.removeAll();
            BookingRoom bk;
            
            bk = new BookingRoom();
            
            bk.setSize(1225, 1000);
            jDesktopPane1.add(bk).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnManagementBookingRoomMouseClicked

    private void btnManagementFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementFoodActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.getComponent(0).setVisible(false);
        jDesktopPane1.remove(0);
        MangamentFood mF = new MangamentFood();
        mF.setSize(1225, 1000);

        jDesktopPane1.add(mF).setVisible(true);
    }//GEN-LAST:event_btnManagementFoodActionPerformed

    private void btnManagementEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementEmplActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.getComponent(0).setVisible(false);
        jDesktopPane1.remove(0);
        ManagementEmployee Me = new project2022.javaswing.view.ManagementEmployee();
        Me.setSize(1225, 1000);

        jDesktopPane1.add(Me).setVisible(true);
    }//GEN-LAST:event_btnManagementEmplActionPerformed

    private void btnManagementRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementRoomActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.getComponent(0).setVisible(false);
        jDesktopPane1.remove(0);
        ManagementRoom mR = new ManagementRoom();
        mR.setSize(1225, 1000);

        jDesktopPane1.add(mR).setVisible(true);
    }//GEN-LAST:event_btnManagementRoomActionPerformed

    private void btnManagementGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementGuessActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.getComponent(0).setVisible(false);
        jDesktopPane1.remove(0);
        ManagementGuess mG = new ManagementGuess();
        mG.setSize(1225, 1000);

        jDesktopPane1.add(mG).setVisible(true);
    }//GEN-LAST:event_btnManagementGuessActionPerformed

    private void btnManagementStaticssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementStaticssActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.getComponent(0).setVisible(false);
        jDesktopPane1.remove(0);
        ManagementStatistics mS = new ManagementStatistics();
        mS.setSize(1225, 1000);

        jDesktopPane1.add(mS);
        mS.setVisible(true);

    }//GEN-LAST:event_btnManagementStaticssActionPerformed

    private void btnManagementBookingRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementBookingRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagementBookingRoomActionPerformed

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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomeFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManagementBookingRoom;
    private javax.swing.JButton btnManagementEmpl;
    private javax.swing.JButton btnManagementFood;
    private javax.swing.JButton btnManagementGuess;
    private javax.swing.JButton btnManagementRoom;
    private javax.swing.JButton btnManagementStaticss;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
