/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.Jframe;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.mycompany.hotel.Help.Database;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Computer
 */
public class chitiethoadon1 extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("###,###,###");

    private Database db;
    private Connection con = null;

    /**
     * Creates new form chitiethoadon1
     */
    SimpleDateFormat sau = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat trc = new SimpleDateFormat("dd-MM-yyyy");
    int id_hdppp;

    public chitiethoadon1(int cid) throws SQLException {
        try {
            initComponents();

            load(cid);
            id_hdppp = cid;
            loadTBL(id_hdppp);

        } catch (ParseException ex) {
            Logger.getLogger(chitiethoadon1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private chitiethoadon1() throws SQLException {
        initComponents();

    }
    private DefaultTableModel tbl;
    String name, phone, sop, giaP, ngaydatS, ngaytraS, songayO, CCCD;
    double tongtien;
    int idpp;

    private void load(int id) throws SQLException, ParseException {

        try {
            db = new Database();
            con = db.getcon();
            tbl = new DefaultTableModel();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `chitiethoadon` ct INNER join hoadon hd on ct.mahd = hd.id  INNER JOIN\n"
                    + "phieudatphong pd on hd.maPhieuDatPhong = pd.id inner join khachhang kh on pd.maKh=kh.id INNER JOIN phong p on pd.maPhong = p.id where ct.mahd = " + id);
            while (rs.next()) {
//                System.out.println("" + rs.getString("tenkh"));
//                System.out.println("" + rs.getString("hd.thoigiantra"));

                name = rs.getString("tenkh");
                phone = rs.getString("sdt");
                txtmaHD.setText(txtmaHD.getText() + " " + id);
                txtNameKH.setText(txtNameKH.getText() + " " + rs.getString("tenkh"));
                txtPhone.setText(txtPhone.getText() + " " + rs.getString("sdt"));
                txtCCCD.setText(txtCCCD.getText() + " " + rs.getString("cccd"));
                CCCD = rs.getString("cccd");
                txtPhieuID.setText(txtPhieuID.getText() + " " + rs.getInt("hd.maphieudatphong"));
                txtsophongf.setText(txtsophongf.getText() + " " + rs.getInt("p.sophong"));
                sop = String.valueOf(rs.getInt("p.sophong"));
                giaP = df.format(rs.getDouble("p.gia"));
                txtgiaP.setText(txtgiaP.getText() + " " + String.valueOf(giaP));
                Date d1 = sau.parse(rs.getString("hd.thoigiandat"));
                Date d2 = sau.parse(rs.getString("hd.thoigiantra"));

                ngaydatS = trc.format(d1);
                ngaytraS = trc.format(d2);
                String d1s = new SimpleDateFormat("YYYY-MM-dd").format(d1);
                String d2s = new SimpleDateFormat("YYYY-MM-dd").format(d2);
                LocalDate ngay1 = LocalDate.parse(d1s);
                LocalDate ngay2 = LocalDate.parse(d2s);
                long khoangcach = ChronoUnit.DAYS.between(ngay1, ngay2);
                System.out.println("" + ngaydatS);
                ngaydat.setText(ngaydat.getText() + " " + ngaydatS);
                ngaytra.setText(ngaytra.getText() + " " + ngaytraS);
                tongtien = rs.getDouble("hd.tongtien");
                System.out.println("" + df.format(tongtien));
                idpp = rs.getInt("hd.maphieudatphong");
                txttotal.setText(txttotal.getText() + " " + df.format(tongtien)+" VND");
                if(khoangcach==0){
                    khoangcach=1;
                }
                songayo.setText(songayo.getText() + " " + khoangcach);
                songayO = String.valueOf(khoangcach);
                break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(chitiethoadon1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

    }

    void loadTBL(int id) throws SQLException {
        String sql = "select * from chitiethoadon ct INNER join hoadon hd on ct.mahd = hd.id INNER JOIN dichvu dv on ct.madv = dv.id INNER JOIN phieudatphong dp on hd.maPhieuDatPhong = dp.id INNER JOIN phong p on dp.maPhong = p.id where hd.id=" + id;
        Database db = new Database();

        Connection con = db.getcon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        //table
        tbl = new DefaultTableModel();

        tbl.addColumn("Ma dich vu");
        tbl.addColumn("Ten dich vu");
        tbl.addColumn("Giá");
        tbl.addColumn("Số lượng");

        while (rs.next()) {
            String arr[] = {String.valueOf(rs.getInt("dv.id")), rs.getString("dv.tendichvu"), df.format(rs.getDouble("dv.gia")), String.valueOf(rs.getInt("ct.soluong"))};
            tbl.addRow(arr);
        }
        tbCTHOADON.setModel(tbl);

    }

    private void inhoadon(int id) throws SQLException {
        String path = "E:\\";
        String sql = "select * from chitiethoadon ct INNER join hoadon hd on ct.mahd = hd.id INNER JOIN dichvu dv on ct.madv = dv.id INNER JOIN phieudatphong dp on hd.maPhieuDatPhong = dp.id INNER JOIN phong p on dp.maPhong = p.id where hd.id=" + id;
        Database db = new Database();

        PdfWriter pdfWriter;
        try {
            Connection con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            pdfWriter = new PdfWriter(new FileOutputStream(path + id + ".pdf"));
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.addNewPage();
            PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
            com.itextpdf.layout.Style header = new com.itextpdf.layout.Style();
            header.setTextAlignment(TextAlignment.CENTER).setFontSize(15f);
            Text t1 = new Text("Hoa don thanh toan").setFont(font);
            Paragraph p1 = new Paragraph(t1).addStyle(header);

            Paragraph p3 = new Paragraph("BILL ID: " + id);
            String dt = phone;
            Paragraph p4 = new Paragraph("Fullname: " + name + " \nPhone: " + dt + " \nCCCD: " + CCCD);
            Text t2 = new Text("Phieu dat phong: " + String.valueOf(idpp)).setFont(font);
            Paragraph p8 = new Paragraph("So phong: " + sop);
            String gp = giaP + " VND";
            Paragraph p9 = new Paragraph("Gia phong: " + gp);
            Paragraph p10 = new Paragraph("Ngay dat phong: " + ngaydatS);
            Paragraph p11 = new Paragraph("Ngay tra phong: " + ngaytraS);
            Paragraph p12 = new Paragraph("So ngay o: " + songayO);
            header = new com.itextpdf.layout.Style();
            header.setTextAlignment(TextAlignment.LEFT).setFontSize(14f);
            Paragraph p5 = new Paragraph(t2).addStyle(header);
            Paragraph p6 = new Paragraph("Su dung dich vu").setFont(font).addStyle(header);
            //table
            float columnWID[] = {150f, 150f, 150f, 100f};
            Table tablePDH = new Table(columnWID).setMarginBottom(10f);
            tablePDH.addCell(new Cell().add("Ma dich vu").setFont(font));
            tablePDH.addCell(new Cell().add("Ten dich vu").setFont(font));
            tablePDH.addCell(new Cell().add("Gia").setFont(font));
            tablePDH.addCell(new Cell().add("So luong").setFont(font));

            while (rs.next()) {
                tablePDH.addCell(new Cell().add(String.valueOf(rs.getInt("dv.id"))).setFont(font));
                tablePDH.addCell(new Cell().add(rs.getString("dv.tendichvu")).setFont(font));
                String tien = df.format(rs.getDouble("dv.gia")) + " VND";
                tablePDH.addCell(new Cell().add(tien).setFont(font));
                tablePDH.addCell(new Cell().add(String.valueOf(rs.getInt("ct.soluong"))).setFont(font));
            }
            String tongti = df.format(tongtien) + " VND";
            Paragraph tong = new Paragraph("Tong tien: " + tongti).setTextAlignment(TextAlignment.RIGHT);
            com.itextpdf.layout.Document doc = new com.itextpdf.layout.Document(pdfDocument);
            doc.add(p1);
            LineSeparator separator = new LineSeparator(new SolidLine(3f)); // Customize line style
            separator.setBackgroundColor(Color.LIGHT_GRAY); // Customize line color
            doc.add(separator);
            doc.add(p3);
            doc.add(p4);
            doc.add(separator);
            doc.add(p5);
            doc.add(p8);
            doc.add(p9);
            doc.add(p10);
            doc.add(p11);
            doc.add(p12);

            doc.add(separator);
            doc.add(p6);

            doc.add(tablePDH);
            doc.add(separator);
            doc.add(tong);
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QLTT.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QLTT.class
                    .getName()).log(Level.SEVERE, null, ex);
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

        txtNameKH = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        txtPhone = new javax.swing.JLabel();
        txtPhieuID = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtsophongf = new javax.swing.JLabel();
        ngaydat = new javax.swing.JLabel();
        txtprint = new javax.swing.JButton();
        txtgiaP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHOADON = new javax.swing.JTable();
        ngaytra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtmaHD = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtCCCD = new javax.swing.JLabel();
        songayo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết hóa đơn");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        txtNameKH.setText("Họ tên khách hàng:");

        txttotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txttotal.setForeground(new java.awt.Color(204, 153, 0));
        txttotal.setText("Tổng tiền:");

        txtPhone.setText("Số điện thoại:");

        txtPhieuID.setText("Phiếu đặt phòng:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Chi tiết hóa đơn");

        txtsophongf.setText("Số phòng:");

        ngaydat.setText("Ngày đặt phòng:");

        txtprint.setText("In hóa đơn");
        txtprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprintActionPerformed(evt);
            }
        });

        txtgiaP.setText("Giá phòng:");

        tbCTHOADON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbCTHOADON);

        ngaytra.setText("Ngày trả:");

        txtmaHD.setText("Mã hóa đơn:");

        txtCCCD.setText("CCCD:");

        songayo.setText("Số ngày ở:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCCCD)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPhone)
                                .addComponent(txtNameKH)
                                .addComponent(txtmaHD)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                                .addComponent(txtgiaP)
                                .addComponent(jSeparator2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhieuID)
                                        .addComponent(txtsophongf))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(songayo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ngaydat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                            .addComponent(ngaytra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(38, 38, 38))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtprint)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmaHD)
                .addGap(18, 18, 18)
                .addComponent(txtNameKH)
                .addGap(10, 10, 10)
                .addComponent(txtPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCCCD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhieuID)
                    .addComponent(ngaydat))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtsophongf))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ngaytra)))
                .addGap(18, 18, 18)
                .addComponent(txtgiaP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songayo)
                .addGap(58, 58, 58)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtprint)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus

    private void txtprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprintActionPerformed
        try {
            // TODO add your handling code here:
            inhoadon(id_hdppp);
            if (new File("E:\\" + id_hdppp + ".pdf").exists()) {
                int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn in hóa đơn không", "Thanh Toán!!!", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION) {

                    Process ps = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler E:\\" + id_hdppp + ".pdf");
                } else {
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(chitiethoadon1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(chitiethoadon1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtprintActionPerformed

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
            java.util.logging.Logger.getLogger(chitiethoadon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new chitiethoadon1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(chitiethoadon1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel ngaydat;
    private javax.swing.JLabel ngaytra;
    private javax.swing.JLabel songayo;
    private javax.swing.JTable tbCTHOADON;
    private javax.swing.JLabel txtCCCD;
    private javax.swing.JLabel txtNameKH;
    private javax.swing.JLabel txtPhieuID;
    private javax.swing.JLabel txtPhone;
    private javax.swing.JLabel txtgiaP;
    private javax.swing.JLabel txtmaHD;
    private javax.swing.JButton txtprint;
    private javax.swing.JLabel txtsophongf;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
