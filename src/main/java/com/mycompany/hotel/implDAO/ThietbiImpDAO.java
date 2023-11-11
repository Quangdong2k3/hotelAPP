/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.ThietBi;
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
import com.mycompany.hotel.DAO.ThietbiDAO;

/**
 *
 * @author Computer
 */
public class ThietbiImpDAO implements ThietbiDAO {

    private Connection con = null;
    private Database db;

    @Override
    public boolean insert(ThietBi r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO `thietbi`(`id`, `ten`, `donvi`, `soluong`, `tinhtrang`) VALUES (NULL,?,?,?,?)");
            pst.setString(1, r.getTen());
            pst.setString(2, r.getDonvi());
            pst.setInt(3, r.getSoluong());
            pst.setBoolean(4, r.isStatus());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public boolean update(ThietBi r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `thietbi` SET `ten`=?,`donvi`=?,`soluong`=?,`tinhtrang` = ? WHERE `id`=?");
            pst.setString(1, r.getTen());
            pst.setString(2, r.getDonvi());
            pst.setInt(3, r.getSoluong());
            pst.setBoolean(4, r.isStatus());
            pst.setInt(5, r.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement pst = con.prepareStatement("DELETE FROM `thietbi` WHERE `id`=?");

            pst.setInt(1, id);

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public List<ThietBi> getAllDV() {
        List<ThietBi> lstDV = new ArrayList<>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `thietbi`");
            while (rs.next()) {
                ThietBi dv = new ThietBi(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(3), rs.getBoolean(5));
                lstDV.add(dv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThietbiImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstDV;
        }
    }

    @Override
    public ThietBi getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
