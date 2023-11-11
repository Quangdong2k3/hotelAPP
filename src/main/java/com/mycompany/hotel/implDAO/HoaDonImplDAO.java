/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.HoaDonDAO;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.Hoadon;
import com.mycompany.hotel.model.Phieudatphong;
import com.mycompany.hotel.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class HoaDonImplDAO implements HoaDonDAO {

    private Database db;
    private Connection cn = null;

    @Override
    public boolean insert_hoadon(Hoadon h) {
        boolean isflag = false;
        String sql = "INSERT INTO `hoadon`(`id`, `Tongtien`, `trangthai`, `thoigiandat`, `thoigiantra`, `maPhieuDatPhong`) VALUES (null,?,?,?,?,?)";
        try {
            db = new Database();
            cn = db.getcon();
            PreparedStatement pst = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, h.getTongtien());
            pst.setBoolean(2, true);
            pst.setString(3, h.getThoigiandat());
            pst.setString(4, h.getThoigiantra());
            pst.setInt(5, h.getP().getId());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                ResultSet get_key_generate = pst.getGeneratedKeys();
                if (get_key_generate.next()) {
                    setId_gennerate(get_key_generate.getInt(1));
                    isflag = true;
                } else {
                    isflag = false;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            isflag = false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return isflag;
        }
    }
    private int id_gennerate;

    public int getId_gennerate() {
        return id_gennerate;
    }

    public void setId_gennerate(int id_gennerate) {
        this.id_gennerate = id_gennerate;
    }

    @Override
    public List<Hoadon> lst() {
        List<Hoadon> lst = new ArrayList<>();
        try {
            db = new Database();
            cn = db.getcon();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `hoadon` h INNER join phieudatphong pd on h.maPhieuDatPhong = pd.id Inner join phong p on pd.maphong = p.id where pd.trangthai = 2");
            while (rs.next()) {
                Hoadon hd = new Hoadon();
                hd.setId(rs.getInt("h.id"));
                hd.setTongtien(rs.getDouble("h.tongtien"));
                hd.setThoigiandat(rs.getString("h.thoigiandat"));
                hd.setThoigiantra(rs.getString("h.thoigiantra"));
                Phieudatphong p = new Phieudatphong();
                p.setId(rs.getInt("pd.id"));
                Room r = new Room();
                r.setId(rs.getInt("p.id"));
                r.setSoPhong(Integer.parseInt(rs.getString("p.sophong")));
                p.setR(r);
                hd.setP(p);

                hd.setTongtien(rs.getDouble("tongtien"));

                lst.add(hd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonImplDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lst;
        }
    }

    @Override
    public List<Hoadon> lstgetDate(String date) {
        List<Hoadon> lst = new ArrayList<>();
        try {
            db = new Database();
            cn = db.getcon();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `hoadon` h INNER join phieudatphong pd on h.maPhieuDatPhong = pd.id Inner join phong p on pd.maphong = p.id where pd.trangthai = 2 and h.thoigiantra = '"+date+"'");
            while (rs.next()) {
                Hoadon hd = new Hoadon();
                hd.setId(rs.getInt("h.id"));
                hd.setTongtien(rs.getDouble("h.tongtien"));
                hd.setThoigiandat(rs.getString("h.thoigiandat"));
                hd.setThoigiantra(rs.getString("h.thoigiantra"));
                Phieudatphong p = new Phieudatphong();
                p.setId(rs.getInt("pd.id"));
                Room r = new Room();
                r.setId(rs.getInt("p.id"));
                r.setSoPhong(Integer.parseInt(rs.getString("p.sophong")));
                p.setR(r);
                hd.setP(p);

                hd.setTongtien(rs.getDouble("tongtien"));

                lst.add(hd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonImplDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonImplDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lst;
        }
    }

}
