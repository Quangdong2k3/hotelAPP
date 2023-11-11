/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.DatPhongDAO;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.Dichvu;
import com.mycompany.hotel.model.Employee;
import com.mycompany.hotel.model.KhachHang;
import com.mycompany.hotel.model.Phieudatphong;
import com.mycompany.hotel.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class DatPhongImpDAO implements DatPhongDAO {

    private Connection con = null;
    private Database db;

    @Override
    public boolean insert(Phieudatphong p) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO `phieudatphong`(`id`, `maKh`, `maNV`, `maPhong`, `thoigiandat`, `trangthai`) VALUES (null,?,?,?,?,?)\n"
                    + "");
            pst.setInt(1, p.getKh().getId());
            pst.setInt(2, p.getEmp().getId());
            pst.setInt(3, p.getR().getId());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Format the date as a string
            Date d = new Date();
            String formattedDate = dateFormat.format(d);
            pst.setString(4, formattedDate);
            pst.setInt(5, p.getStatus());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return isflag;
        }
    }

    @Override
    public Phieudatphong getSTTIDROOM() {
        Phieudatphong p = null;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `phieudatphong` pd INNER JOIN phong p on pd.maPhong = p.id WHERE p.id = 2 and pd.trangthai=1\n"
                    + "");
            while (rs.next()) {
                p = new Phieudatphong();
                p.setId(rs.getInt("pd.id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return p;
        }
    }
//vừa sửa

    @Override
    public Phieudatphong searchNameRoom(String name) {
        Phieudatphong p = null;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM `phieudatphong` dp INNER JOIN `phong` p ON dp.maPhong = p.id inner Join `nguoidung` n on dp.manv = n.id Inner Join khachhang k on dp.makh = k.id WHERE dp.trangthai = 1 and p.soPhong ='" + name + "'");

            while (rs.next()) {
                p = new Phieudatphong();
                p.setId(rs.getInt("dp.id"));
                Employee e = new Employee();
                e.setId(rs.getInt("n.id"));
                e.setTen(rs.getString("n.ten"));
                Room r = new Room();
                r.setId(rs.getInt("p.id"));
                r.setGia(rs.getDouble("p.gia"));
                KhachHang k = new KhachHang();
                k.setCccd(rs.getString("k.cccd"));
                k.setTen(rs.getString("k.tenKh"));
                k.setSdt(rs.getString("k.sdt"));

                p.setR(r);
                p.setThoigiandat(rs.getString("thoigiandat"));
                p.setKh(k);
                p.setEmp(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return p;
        }
    }
@Override
    public void UpdatePhieuSTT(int id,int i) {
        Phieudatphong p = null;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();

            int rs = st.executeUpdate("Update  `phieudatphong`  set trangthai = "+i+" where id="+id);

           if(rs>0){
               System.out.println("cap nhat thanh cong trang thai phieu phong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public List<Phieudatphong> searchNameRooms(String name) {
        List<Phieudatphong> lst = new ArrayList<Phieudatphong>();

        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM sudungdv sd INNER JOIN phieudatphong dp on sd.maDPh = dp.id INNER JOIN phong p on dp.maPhong = p.id inner Join `nguoidung` n on dp.manv = n.id Inner Join khachhang k on dp.makh = k.id where dp.trangthai = 1 AND p.soPhong = '" + name + "'");

            while (rs.next()) {
                Phieudatphong p = new Phieudatphong();
                p.setId(rs.getInt("dp.id"));
                Employee e = new Employee();
                e.setId(rs.getInt("n.id"));
                e.setTen(rs.getString("n.ten"));
                Room r = new Room();
                r.setGia(rs.getDouble("p.gia"));
                KhachHang k = new KhachHang();
                k.setCccd(rs.getString("k.cccd"));
                k.setTen(rs.getString("k.tenKh"));
                k.setSdt(rs.getString("k.sdt"));

                p.setR(r);
                p.setThoigiandat(rs.getString("thoigiandat"));
                p.setKh(k);
                p.setEmp(e);
                lst.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lst;
        }
    }

    @Override
    public List<Phieudatphong> getAllPD() {
        List<Phieudatphong> lst = new ArrayList<Phieudatphong>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `phieudatphong` dp INNER JOIN `phong` p ON dp.maPhong = p.id inner Join `nguoidung` n on dp.manv = n.id Inner Join khachhang k on dp.makh = k.id where dp.trangthai = 1");

            while (rs.next()) {

                Phieudatphong p = new Phieudatphong();
                p.setId(rs.getInt("dp.id"));
                Employee e = new Employee();
                e.setId(rs.getInt("n.id"));
                e.setTen(rs.getString("n.ten"));
                Room r = new Room();
                r.setGia(rs.getDouble("p.gia"));
                r.setSoPhong(rs.getInt("sophong"));
                KhachHang k = new KhachHang();
                k.setCccd(rs.getString("k.cccd"));
                k.setTen(rs.getString("k.tenKh"));
                k.setSdt(rs.getString("k.sdt"));
                p.setR(r);
                p.setThoigiandat(rs.getString("thoigiandat"));
                p.setKh(k);
                p.setEmp(e);

                lst.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lst;
        }
    }

    public double MoneyService(int id) throws SQLException {
        double gia = 0;

        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT *,(sd.soluong*dv.gia) AS TONGTIEN FROM `sudungdv` sd INNER JOIN dichvu dv oN sd.maDV = dv.id INNER JOIN phieudatphong dp on sd.maDPh = dp.id WHERE dp.id = " + id);
            while (rs1.next()) {
                gia += rs1.getDouble("tongtien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return gia;
    }
    public int soluong = 0;

    public List<Dichvu> getSDDichvu(int PhieuDPid) throws SQLException {
        List<Dichvu> lstdv = new ArrayList<>();

        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT *,(sd.soluong*dv.gia) AS TONGTIEN FROM `sudungdv` sd INNER JOIN dichvu dv oN sd.maDV = dv.id INNER JOIN phieudatphong dp on sd.maDPh = dp.id WHERE dp.id = " + PhieuDPid);
            while (rs1.next()) {
                Dichvu dv = new Dichvu();
                dv.setId(rs1.getInt("dv.id"));
                dv.setSoluong(rs1.getInt("sd.soluong"));
                lstdv.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            return lstdv;

        }
    }
}
