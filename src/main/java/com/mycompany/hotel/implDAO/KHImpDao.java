/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.KhachHangDao;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.KhachHang;
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
public class KHImpDao implements KhachHangDao {

    private Connection con = null;
    private Database db;

    @Override
    public boolean insert(KhachHang r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO `khachhang`(`id`, `tenKh`, `cccd`, `sdt`) VALUES (NULL,?,?,?)");
            pst.setString(1, r.getTen());
            pst.setString(2, r.getCccd());
            pst.setString(3, r.getSdt());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
            setError(ex.getMessage());

            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("" + ex.getMessage());
                setError(ex.getMessage());
            }
            return isflag;
        }
    }
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String s) {
        error = s;
    }

    @Override
    public boolean update(KhachHang r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `khachhang` SET `tenKh`=?,`cccd`=?,`sdt`=? WHERE `id`=?");
            pst.setString(1, r.getTen());
            pst.setString(2, r.getCccd());
            pst.setString(3, r.getSdt());
            pst.setInt(4, r.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            setError(ex.getMessage());

            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                setError(ex.getMessage());

            }
            return isflag;
        }
    }

    @Override
    public boolean delete(int id) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("DELETE FROM `khachhang` WHERE `id`=?");

            pst.setInt(1, id);

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(KHImpDao.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(KHImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public List<KhachHang> getAllKH() {
        List<KhachHang> lstRooms = new ArrayList<>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `KhachHang`");
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(3), rs.getString(4), rs.getInt(1), rs.getString(2));
                lstRooms.add(kh);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KHImpDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(KHImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstRooms;
        }
    }

    @Override
    public KhachHang getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
