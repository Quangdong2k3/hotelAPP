/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.Jframe;

import com.mycompany.hotel.Help.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Computer
 */
public class Doanhthu extends javax.swing.JInternalFrame {

    /**
     * Creates new form Doanhthu
     */
    DecimalFormat df = new DecimalFormat("###,###,###");
    private Timer timer;
    private Database db;
    private Connection con = null;

    public Doanhthu() throws SQLException {
        initComponents();
        loadMoneyDT();
        loadMoneyR();
        loadMoneyDV();
    }
    private int currentNumber = 0;

    private void loadMoneyDT() throws SQLException {
        double tien = 0.0;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT sum(Tongtien) as tong FROM `hoadon` hd inner join phieudatphong pd on hd.maphieudatphong = pd.id where pd.trangthai = 2 ;");
            while (rs.next()) {
                tien = rs.getDouble("tong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            lbTotal.setText(df.format(tien));

        }
    }

    private void loadMoneyDV() throws SQLException {
        double tien = 0.0;
        Date d = new Date();
        SimpleDateFormat sau = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("" + sau.format(d));
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *,SUM(dv.gia*ct.soluong) as Tgia FROM chitiethoadon ct INNER JOIN hoadon hd on ct.mahd = hd.id INNER JOIN dichvu dv on ct.madv = dv.id INNER JOIN phieudatphong pd on hd.maPhieuDatPhong = pd.id WHERE DATE(hd.thoigiantra) <= '" + sau.format(d) + "' and pd.trangthai=2;");
            while (rs.next()) {
                tien = rs.getDouble("Tgia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            toatlDV.setText(df.format(tien));

        }
    }

    private void loadMoneyR() throws SQLException {
        double tienPhong = 0;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT sum(gia*DATEDIFF(hd.thoigiantra,hd.thoigiandat)) as tong FROM hoadon hd INNER join phieudatphong pd on hd.maPhieuDatPhong = pd.id INNER join phong p on pd.maPhong = p.id where pd.trangthai=2;");

            while (rs1.next()) {
                tienPhong = rs1.getDouble("tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            totaMR.setText(df.format(tienPhong) + " VND");

        }
    }
private void loadMoneyDT(String date1, String date2) throws SQLException {
        double tien = 0.0;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(Tongtien) as tong FROM `hoadon` where Date(thoigiantra) BETWEEN '"+date1+"' and '"+date2+"'");
            while (rs.next()) {
                tien = rs.getDouble("tong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            lbTotal.setText(df.format(tien));

        }
    }

    private void loadMoneyDV(String date1, String date2) throws SQLException {
        double tien = 0.0;
        Date d = new Date();
        SimpleDateFormat sau = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("" + sau.format(d));
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *,SUM(dv.gia*ct.soluong) as Tgia FROM chitiethoadon ct INNER JOIN hoadon hd on ct.mahd = hd.id INNER JOIN dichvu dv on ct.madv = dv.id INNER JOIN phieudatphong pd on hd.maPhieuDatPhong = pd.id WHERE pd.trangthai=2 and Date(hd.thoigiantra) BETWEEN '"+date1+"' and '"+date2+"' ;");
            while (rs.next()) {
                tien = rs.getDouble("Tgia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            toatlDV.setText(df.format(tien));

        }
    }

    private void loadMoneyR(String date1, String date2) throws SQLException {
        double tienPhong = 0;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT sum(gia*DATEDIFF(hd.thoigiantra,hd.thoigiandat)) as tong FROM hoadon hd INNER join phieudatphong pd on hd.maPhieuDatPhong = pd.id INNER join phong p on pd.maPhong = p.id where pd.trangthai=2 and Date(thoigiantra) BETWEEN '"+date1+"' and '"+date2+"'");

            while (rs1.next()) {
                tienPhong = rs1.getDouble("tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            totaMR.setText(df.format(tienPhong) + " VND");

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datefrom = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateto = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totaMR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        toatlDV = new javax.swing.JTextField();

        setTitle("Doanh thu");

        datefrom.setDateFormatString("dd-MM-yyyy");

        jLabel1.setText("Từ");

        jLabel2.setText("Đến");

        dateto.setDateFormatString("dd-MM-yyyy");

        jButton1.setText("Xem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(51, 0, 153));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("00000");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Tổng doanh thu phòng:");

        totaMR.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Tổng doanh thu sử dụng dịch vụ:");

        toatlDV.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totaMR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36)
                                        .addComponent(toatlDV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 208, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jButton1)
                                .addGap(160, 160, 160)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1))
                .addGap(45, 45, 45)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totaMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(toatlDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat p = new SimpleDateFormat("yyyy-MM-dd");
            Date from = datefrom.getDate();
            Date to = dateto.getDate();
            loadMoneyDT(p.format(from),p.format(to));
            loadMoneyR(p.format(from),p.format(to));
            loadMoneyDV(p.format(from),p.format(to));
        } catch (SQLException ex) {
            Logger.getLogger(Doanhthu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser datefrom;
    private com.toedter.calendar.JDateChooser dateto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTextField toatlDV;
    private javax.swing.JTextField totaMR;
    // End of variables declaration//GEN-END:variables
}
