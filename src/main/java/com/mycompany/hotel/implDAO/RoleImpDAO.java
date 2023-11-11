/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.DAO.roleDAO;
import com.mycompany.hotel.Help.Database;
import com.mycompany.hotel.model.Role;
import com.mycompany.hotel.model.Room;
import java.sql.Connection;
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
public class RoleImpDAO implements roleDAO {

    private Database db;
    private Connection con = null;

    @Override
    public List<Role> getAllRole() {
        List<Role> lstRole = new ArrayList<>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM role");
            while (rs.next()) {
                Role r = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
                lstRole.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleImpDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoleImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstRole;
        }
    }

}
