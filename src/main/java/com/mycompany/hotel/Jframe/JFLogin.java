/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.Jframe;

import static com.mycompany.hotel.Jframe.Main.mCategory;
import static com.mycompany.hotel.Jframe.Main.mIDangXuat;
import static com.mycompany.hotel.Jframe.Main.mINhanvien;
import com.mycompany.hotel.implDAO.EmpImlDAO;
import com.mycompany.hotel.model.Employee;
import java.awt.Cursor;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Computer
 */
public class JFLogin extends javax.swing.JInternalFrame {

    public static int id_role;
    public static int id_nv;

    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
        setLocation(this.getWidth() / 2, this.getHeight() / 2);
        txtPass.setEchoChar('\u25cf');
        jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Đăng nhập");
        setName("Login"); // NOI18N

        jLabel1.setText("Tên đăng nhập");

        jLabel2.setText("Mật Khẩu");

        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/show.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(72, 72, 72)
                                .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnLogin)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (txtPass.getText().equals("") && txtUname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền tài khoản và mật khẩu!!!");

        } else {
            String md5Hex = DigestUtils.md5Hex(txtPass.getText()).toUpperCase();
            if (new EmpImlDAO().login(txtUname.getText(), md5Hex) != null) {
                Employee e = new EmpImlDAO().login(txtUname.getText(), md5Hex);

                id_role = e.getR().getId();
                id_nv = e.getId();
//            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!!!" + id_role);
                setVisible(false);
                //Quanr ly
                if (getId_role() == 5) {
                    Main.mIDangnhap.setEnabled(false);
                    mIDangXuat.setEnabled(true);
                    mINhanvien.setEnabled(true);
                    mCategory.setEnabled(true);
                    Main.Checkout.setEnabled(true);
                    Main.mnIdv.setEnabled(true);
                    Main.imenuDoanhthu.setEnabled(true);

                }

//                EMP
                if (getId_role() == 1) {

                    Main.mIDangnhap.setEnabled(false);
                    mIDangXuat.setEnabled(true);
                    mINhanvien.setEnabled(false);
                    mCategory.setEnabled(true);
                    Main.Checkout.setEnabled(true);
                    Main.mnIdv.setEnabled(true);
                }
                if (getId_role() == 4) {

                    Main.mIDangnhap.setEnabled(false);
                    mIDangXuat.setEnabled(true);
                    mINhanvien.setEnabled(false);
//                    mCategory.setEnabled(true);
                    Main.Checkout.setEnabled(true);
//                    Main.mnIdv.setEnabled(true);
                    Main.imenuDoanhthu.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thông tin đăng nhập sai!!!");
            }
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        if (!txtPass.getText().equals("")) {
            txtPass.setEchoChar('\u25cf');

        }
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        if (!txtPass.getText().equals("")) {
            txtPass.setEchoChar((char) 0);

        }
    }//GEN-LAST:event_jLabel3MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
}
