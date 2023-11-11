/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.Jframe;

import static com.mycompany.hotel.Jframe.Main.jDesktopPane1;
import com.mycompany.hotel.implDAO.DatPhongImpDAO;
import com.mycompany.hotel.implDAO.EmpImlDAO;
import com.mycompany.hotel.implDAO.RoomImpDao;
import com.mycompany.hotel.model.Employee;
import com.mycompany.hotel.model.KhachHang;
import com.mycompany.hotel.model.Phieudatphong;
import com.mycompany.hotel.model.Room;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Computer
 */
public class ThongtinDAtphong extends javax.swing.JFrame {

    /**
     * Creates new form ThongtinDAtphong
     */
    public ThongtinDAtphong(String id, String nameR, String idnv) {
        initComponents();
        ContentRoom.setText(nameR);
        txtIdRoom.setText(id);
        txtIdnv.setText(idnv);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private ThongtinDAtphong() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ContentRoom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdnv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdRoom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btnDatPhong = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phiếu Đặt Phòng");
        setBackground(new java.awt.Color(0, 153, 153));

        ContentRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ContentRoom.setForeground(new java.awt.Color(255, 102, 102));
        ContentRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContentRoom.setText("Phiếu Đặt Phòng");

        jLabel2.setText("Mã khách hàng:");

        jLabel4.setText("Mã nhân viên:");

        txtIdnv.setEnabled(false);

        jLabel5.setText("Mã phòng:");

        txtIdRoom.setEnabled(false);

        jLabel6.setText("Trạng thái:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Đặt nhé ");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Chưa đặt");

        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ContentRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(txtIdnv, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtidKH, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDatPhong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2))
                            .addComponent(txtIdRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContentRoom)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatPhong)
                    .addComponent(btnHuy))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        // TODO add your handling code here:
        try {
            int idkh = Integer.parseInt(txtidKH.getText());
            int idnv = Integer.parseInt(txtIdnv.getText());
            int idr = Integer.parseInt(txtIdRoom.getText());

            // Print the formatted date
//            System.out.println("Formatted Date: " + formattedDate);
            KhachHang kh = new KhachHang();
            Employee e = new Employee();
            Room r = new Room();
            r.setId(idr);
            kh.setId(idkh);
            e.setId(idnv);
            Phieudatphong pdp = new Phieudatphong(0, kh, e, r, "", 1);
            System.out.println("" + pdp.toString());
            boolean success = new DatPhongImpDAO().insert(pdp);
            if (success) {
//            reset();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                setVisible(false);
                new RoomImpDao().updateSTT(1, idr);
                Main.CloseAllFrame();
                QLRoomFrame q = new QLRoomFrame();
                q.setVisible(true);
                Main.jDesktopPane1.add(q);
//            loadTBL();
            } else {
                JOptionPane.showMessageDialog(null, "Thất bại");
            }
            // Print the current date and time
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnDatPhongActionPerformed
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
            java.util.logging.Logger.getLogger(ThongtinDAtphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongtinDAtphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongtinDAtphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongtinDAtphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongtinDAtphong().setVisible(true);
            }
        });
    }
//private void CloseAllFrame() {
//        JInternalFrame[] frames = jDesktopPane1.getAllFrames();
//        boolean isflag = false;
//        for (JInternalFrame frame : frames) {
//            frame.dispose();
//        }
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContentRoom;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnHuy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField txtIdRoom;
    private javax.swing.JTextField txtIdnv;
    private javax.swing.JTextField txtidKH;
    // End of variables declaration//GEN-END:variables
}