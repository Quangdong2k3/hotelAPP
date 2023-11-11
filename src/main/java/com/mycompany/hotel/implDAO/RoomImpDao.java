/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.implDAO;

import com.mycompany.hotel.model.Room;
import java.util.List;
import com.mycompany.hotel.DAO.RoomDAO;
import com.mycompany.hotel.Help.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class RoomImpDao implements RoomDAO {

    private Connection con = null;
    private Database db;
    private List<Room> lstRooms;

    @Override
    public boolean insert(Room r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO `phong` (`id`, `soPhong`, `soTang`, `soGiuong`, `gia`, `trangThai`) VALUES (NULL, ?, ?, ?, ?, ?)");
            pst.setInt(1, r.getSoPhong());
            pst.setInt(2, r.getSoTang());
            pst.setInt(3, r.getSoGiuong());
            pst.setDouble(4, r.getGia());
            pst.setBoolean(5, r.isStatus());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public boolean update(Room r) {
        boolean isflag = false;
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `phong` SET `soPhong`=?,`soTang`=?,`soGiuong`=?,`gia`=?,`trangThai`=? WHERE `id`=?");

            pst.setInt(1, r.getSoPhong());
            pst.setInt(2, r.getSoTang());
            pst.setInt(3, r.getSoGiuong());
            pst.setDouble(4, r.getGia());
            pst.setBoolean(5, r.isStatus());
            pst.setInt(6, r.getId());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement pst = con.prepareStatement("DELETE FROM `phong` WHERE `id` = ?");

            pst.setInt(1, id);

            int rs = pst.executeUpdate();
            if (rs > 0) {
                isflag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            isflag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isflag;
        }
    }

    @Override
    public List<Room> getAllRoom() {
        lstRooms = new ArrayList<>();
        try {
            db = new Database();
            con = db.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phong");
            while (rs.next()) {
                Room r = new Room(rs.getInt("id"), rs.getInt("Sophong"), rs.getInt("Sotang"), rs.getInt("Sogiuong"), rs.getDouble("gia"), rs.getBoolean("trangthai"));
                lstRooms.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstRooms;
        }
    }

    @Override
    public void updateSTT(int stt, int id) {
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `phong` SET `trangThai`=?\n"
                    + "WHERE `id` = ?");

            pst.setInt(1, stt);
            pst.setInt(2, id);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("cap nhat thanh cong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    @Override
    public void updateSTT(int stt, String id) {
        try {
            db = new Database();
            con = db.getcon();
            PreparedStatement pst = con.prepareStatement("UPDATE `phong` SET `trangThai`=?\n"
                    + "WHERE `sophong` = ?");

            pst.setInt(1, stt);
            pst.setString(2, id);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("cap nhat thanh cong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomImpDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
