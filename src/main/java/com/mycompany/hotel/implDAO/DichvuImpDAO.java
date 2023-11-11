/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.DichVuDAO;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.Dichvu;
import com.mycompany.hotel.model.ThietBi;
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
public class DichvuImpDAO implements DichVuDAO{
    private Connection con = null;
    private Database db;

    @Override
    public boolean insert(Dichvu r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO `dichvu`(`id`, `tendichvu`, `gia`,`donvi`) VALUES (NULL,?,?,?)");
            pst.setString(1, r.getTen());
            pst.setString(3, r.getDonvi());
            pst.setDouble(2, r.getGia());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public boolean update(Dichvu r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `dichvu` SET `tendichvu`=?,`gia`=?,`donvi`=? WHERE `id`=?");
            pst.setString(1, r.getTen());
            pst.setString(3, r.getDonvi());
            pst.setDouble(2, r.getGia());
            pst.setInt(4, r.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement pst = con.prepareStatement("DELETE FROM `dichvu` WHERE `id`=?");

            pst.setInt(1, id);

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public List<Dichvu> getAllDV() {
        List<Dichvu> lstDV = new ArrayList<>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `dichvu`");
            while (rs.next()) {
                Dichvu dv = new Dichvu(rs.getInt("id"), rs.getString("Tendichvu"), rs.getDouble("gia"), rs.getString("donvi"));
                lstDV.add(dv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DichvuImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstDV;
        }
    }

    @Override
    public ThietBi getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
