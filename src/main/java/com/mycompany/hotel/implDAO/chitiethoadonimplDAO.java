/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.chitiethdDAO;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.chitiethoadon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Computer
 */
public class chitiethoadonimplDAO implements chitiethdDAO {

    private Database db;
    private Connection cn = null;

    @Override
    public boolean insert(chitiethoadon ct) {
        boolean isflag = false;
        try {
            db = new Database();
            cn = db.getcon();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `chitiethoadon`(`id`, `maHD`, `madv`, `soluong`) VALUES (null,?,?,?)\n"
                    + "");

            pst.setInt(1, ct.getH().getId());
            pst.setInt(2, ct.getDv().getId());

            pst.setInt(3, ct.getSoluong());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            isflag = false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(""+ex.getMessage());
            }
            return isflag;
        }
    }

}
