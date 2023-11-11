/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.Jframe;

import com.mycompany.hotel.Help.Database;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Computer
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() throws SQLException {
        initComponents();

        this.setExtendedState(MAXIMIZED_BOTH);
        loadFrame();
      
    }

    public void loadFrame() {
        mIDangXuat.setEnabled(false);
        mIDichvu.setEnabled(false);
        mIPhong.setEnabled(false);
        mIKhachhang.setEnabled(false);
        mINhanvien.setEnabled(false);
        mCategory.setEnabled(false);
        Checkout.setEnabled(false);
        mnIdv.setEnabled(false);

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mIDangnhap = new javax.swing.JMenuItem();
        mIDangXuat = new javax.swing.JMenuItem();
        mIExit = new javax.swing.JMenuItem();
        mCategory = new javax.swing.JMenu();
        mIPhong = new javax.swing.JMenuItem();
        mIDichvu = new javax.swing.JMenuItem();
        mIKhachhang = new javax.swing.JMenuItem();
        mINhanvien = new javax.swing.JMenuItem();
        MiThietbi = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Checkout = new javax.swing.JMenu();
        mnIdv = new javax.swing.JMenu();
        imenuDoanhthu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khách Sạn");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenu3.setText("Hệ Thống");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        mIDangnhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mIDangnhap.setText("Đăng nhập");
        mIDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mIDangnhapActionPerformed(evt);
            }
        });
        jMenu3.add(mIDangnhap);

        mIDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mIDangXuat.setText("Đăng Xuất");
        mIDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mIDangXuatActionPerformed(evt);
            }
        });
        jMenu3.add(mIDangXuat);

        mIExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mIExit.setText("Thoát");
        mIExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mIExitActionPerformed(evt);
            }
        });
        jMenu3.add(mIExit);

        jMenuBar1.add(jMenu3);

        mCategory.setText("Danh mục");
        mCategory.setEnabled(false);
        mCategory.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        mIPhong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mIPhong.setText("Quản lý phòng");
        mIPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mIPhongActionPerformed(evt);
            }
        });
        mCategory.add(mIPhong);

        mIDichvu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mIDichvu.setText("Quản lý dịch vụ");
        mIDichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mIDichvuActionPerformed(evt);
            }
        });
        mCategory.add(mIDichvu);

        mIKhachhang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mIKhachhang.setText("Quản lý khách hàng");
        mIKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mIKhachhangActionPerformed(evt);
            }
        });
        mCategory.add(mIKhachhang);

        mINhanvien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mINhanvien.setText("Quản lý nhân viên");
        mINhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mINhanvienActionPerformed(evt);
            }
        });
        mCategory.add(mINhanvien);

        MiThietbi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MiThietbi.setText("Quản lý thiết bị");
        MiThietbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiThietbiActionPerformed(evt);
            }
        });
        mCategory.add(MiThietbi);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Quản lý hóa đơn");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mCategory.add(jMenuItem1);

        jMenuBar1.add(mCategory);

        Checkout.setText("Checkout");
        Checkout.setEnabled(false);
        Checkout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(Checkout);

        mnIdv.setText("Sử dụng dịch vụ");
        mnIdv.setEnabled(false);
        mnIdv.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mnIdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnIdvMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnIdv);

        imenuDoanhthu.setText("Doanh thu");
        imenuDoanhthu.setEnabled(false);
        imenuDoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        imenuDoanhthu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imenuDoanhthuMouseClicked(evt);
            }
        });
        jMenuBar1.add(imenuDoanhthu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIExitActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát phần mềm???", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
        if (kq == JOptionPane.OK_OPTION) {
            System.exit(0);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else {
            return;
        }
    }//GEN-LAST:event_mIExitActionPerformed
    private void mIDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIDangnhapActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        JFLogin l = new JFLogin();
        l.setVisible(true);
        jDesktopPane1.add(l);
        mIDichvu.setEnabled(true);
        mIPhong.setEnabled(true);
        mIKhachhang.setEnabled(true);
        

    }//GEN-LAST:event_mIDangnhapActionPerformed

    private void mIPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIPhongActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        QLRoomFrame r = new QLRoomFrame();
        r.setVisible(true);
        r.setSize(jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
        jDesktopPane1.add(r);
    }//GEN-LAST:event_mIPhongActionPerformed

    private void mIKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIKhachhangActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        QLKH l = new QLKH();
        l.setVisible(true);
        jDesktopPane1.add(l);
    }//GEN-LAST:event_mIKhachhangActionPerformed

    private void mIDichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIDichvuActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        QLDV l = new QLDV();
        l.setVisible(true);
        jDesktopPane1.add(l);
    }//GEN-LAST:event_mIDichvuActionPerformed

    private void mINhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mINhanvienActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        QLNV l = new QLNV();
        l.setVisible(true);
        jDesktopPane1.add(l);
    }//GEN-LAST:event_mINhanvienActionPerformed

    private void MiThietbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiThietbiActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        QLTB l = new QLTB();
        l.setVisible(true);
        jDesktopPane1.add(l);
    }//GEN-LAST:event_MiThietbiActionPerformed

    private void CheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckoutMouseClicked
        // TODO add your handling code here:
        CloseAllFrame();
        if (Checkout.isEnabled()) {
            QLTT l = new QLTT();
            l.setVisible(true);
            try {
                l.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            l.setLocation(getWidth() / 5, l.getHeight() / 10);
            jDesktopPane1.add(l);
            jDesktopPane1.selectFrame(true);
        }

    }//GEN-LAST:event_CheckoutMouseClicked

    private void mnIdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnIdvMouseClicked
        // TODO add your handling code here:
        CloseAllFrame();
        if (mnIdv.isEnabled()) {
            try {
                sudungdichvu l = new sudungdichvu();
                l.setVisible(true);
                try {
                    l.setSelected(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                l.setLocation(getWidth() / 5, l.getHeight() / 10);
                jDesktopPane1.add(l);
                jDesktopPane1.selectFrame(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnIdvMouseClicked

    private void mIDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mIDangXuatActionPerformed
        // TODO add your handling code here:
        CloseAllFrame();
        loadFrame();
        mIDangnhap.setEnabled(true);
        imenuDoanhthu.setEnabled(false);
    }//GEN-LAST:event_mIDangXuatActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            CloseAllFrame();
            QLHoaDon l = new QLHoaDon();
            l.setVisible(true);
            jDesktopPane1.add(l);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void imenuDoanhthuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imenuDoanhthuMouseClicked
        // TODO add your handling code here:
        CloseAllFrame();
        if (Checkout.isEnabled()) {
            try {
                Doanhthu l = new Doanhthu();
                l.setVisible(true);
                try {
                    l.setSelected(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                l.setLocation(getWidth() / 5, l.getHeight() / 10);
                jDesktopPane1.add(l);
                jDesktopPane1.selectFrame(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_imenuDoanhthuMouseClicked
    private boolean checkOpenFrame(String name) {
        JInternalFrame[] frames = jDesktopPane1.getAllFrames();

        boolean isflag = false;
        for (JInternalFrame frame : frames) {
            if (frame.getName().equalsIgnoreCase(name)) {
                isflag = true;
            } else {
                isflag = false;
            }
        }
        return isflag;
    }

    public static void CloseAllFrame() {
        JInternalFrame[] frames = jDesktopPane1.getAllFrames();
        boolean isflag = false;
        for (JInternalFrame frame : frames) {
            frame.dispose();
        }
    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Checkout;
    public static javax.swing.JMenuItem MiThietbi;
    public static javax.swing.JMenu imenuDoanhthu;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenu mCategory;
    public static javax.swing.JMenuItem mIDangXuat;
    public static javax.swing.JMenuItem mIDangnhap;
    public static javax.swing.JMenuItem mIDichvu;
    public javax.swing.JMenuItem mIExit;
    public static javax.swing.JMenuItem mIKhachhang;
    public static javax.swing.JMenuItem mINhanvien;
    public static javax.swing.JMenuItem mIPhong;
    public static javax.swing.JMenu mnIdv;
    // End of variables declaration//GEN-END:variables
}
