/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project2022.javaswing.config.DBConnection;
import project2022.javaswing.models.Room;

/**
 *
 * @author Ching
 */
public class RoomDao implements DAO<Room> {

    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM phong;";
        ArrayList<Room> list = new ArrayList<Room>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room(rs.getInt("maphong"), rs.getString("tenphong"), rs.getInt("loaiphong"), rs.getInt("gia"), rs.getInt("trangthai"));
                list.add(room);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public Room getDetail(Room t) {
        Room tmp = new Room();
        try {
            String sql = "SELECT * FROM phong WHERE maphong = ?;";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, t.getMaphong());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tmp.setMaphong(t.getMaphong());
                tmp.setTenphong(rs.getString("tenphong"));
                tmp.setLoaiphong(rs.getInt("loaiphong"));
                tmp.setGia(rs.getInt("gia"));
                tmp.setTrangthai(rs.getInt("trangthai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    @Override
    public void insertDao(Room t) {
        String sql = "INSERT INTO phong (tenphong, loaiphong, gia, trangthai) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, t.getTenphong());
            ps.setInt(2, t.getLoaiphong());
            ps.setInt(3, t.getGia());
            ps.setInt(4, t.getTrangthai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateDao(Room t) {
        String sql = "UPDATE phong SET tenphong = ?, loaiphong = ?, gia = ?, trangthai = ? WHERE maphong = ?;";

        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, t.getTenphong());
            ps.setInt(2, t.getLoaiphong());
            ps.setInt(3, t.getGia());
            ps.setInt(4, t.getTrangthai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteDao(Room t) {
        String sql = "DELETE FROM phong WHERE maphong = ?;";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, t.getMaphong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args ){
        RoomDao rd = new RoomDao();
    }
    

}
