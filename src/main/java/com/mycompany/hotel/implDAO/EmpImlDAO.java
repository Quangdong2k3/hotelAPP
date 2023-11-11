/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.empDAO;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.Employee;
import com.mycompany.hotel.model.Role;
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
public class EmpImlDAO implements empDAO {

    private Connection con = null;
    private Database db;

    @Override
    public boolean insert(Employee e) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO `nguoidung`(`id`, `quyenHan`, `ten`, `taikhoan`, `matkhau`) VALUES (NULL,?,?,?,?)");
            pst.setInt(1, e.getR().getId());
            pst.setString(2, e.getTen());
            pst.setString(3, e.getTaikhoan());
            pst.setString(4, e.getMatkhau());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpImlDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpImlDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement pst = con.prepareStatement("DELETE FROM `nguoidung` WHERE `id`=?");

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
    public boolean update(Employee e) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `nguoidung` SET `quyenHan`=?,`ten`=?,`taikhoan`=?,`matkhau`=? WHERE `id` = ?");
            pst.setInt(1, e.getR().getId());
            pst.setString(2, e.getTen());
            pst.setString(3, e.getTaikhoan());
            pst.setString(4, e.getMatkhau());
            pst.setInt(5, e.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpImlDAO.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpImlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public List<Employee> getAllEmp() {
        List<Employee> lstE = new ArrayList<>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `nguoidung` e JOIN role r on e.quyenhan = r.id");
            while (rs.next()) {
                Employee dv = new Employee(new Role(rs.getInt(2), rs.getString("r.name"), ""), rs.getString(4), rs.getString(5), rs.getInt(1), rs.getString(3));
                lstE.add(dv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpImlDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpImlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstE;
        }
    }

    @Override
    public Employee login(String u, String pass) {
        Employee e = null;
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `nguoidung` e JOIN role r on e.quyenhan = r.id where e.taikhoan = '" + u + "' and e.matkhau = '" + pass + "'");
            while (rs.next()) {
                e = new Employee(new Role(rs.getInt(2), rs.getString("r.name"), ""), rs.getString(4), rs.getString(5), rs.getInt(1), rs.getString(3));

                break;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());

            }
            return e;
        }
    }

}
