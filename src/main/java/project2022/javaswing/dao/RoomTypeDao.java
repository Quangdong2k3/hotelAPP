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
import project2022.javaswing.models.RoomType;

/**
 *
 * @author Ching
 */
public class RoomTypeDao implements DAO<RoomType> {

    @Override
    public ArrayList<RoomType> getAll() {
        String sql = "SELECT * FROM loaiphong;";
        ArrayList<RoomType> list = new ArrayList<RoomType>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RoomType rt = new RoomType(rs.getInt("maloaiphong"), rs.getString("tenloaiphong"));
                list.add(rt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public RoomType getDetail(RoomType t) {
        String sql = "SELECT * FROM loaiphong; WHERE maloaiphong = ?;";
        RoomType rt = new RoomType();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rt.setMaloaiphong(rs.getInt("maloaiphong"));
                rt.setTenloaiphong(rs.getString("tenloaiphong"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rt;
    }

    @Override
    public void insertDao(RoomType t) {
        String sql = "INSERT INTO loaiphong (tenloaiphong) VALUES (?);";

        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, t.getTenloaiphong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDao(RoomType t) {
        String sql = "UPDATE loaiphong SET tenloaiphong = ? WHERE maloaiphong = ?;";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, t.getTenloaiphong());
            ps.setInt(2, t.getMaloaiphong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteDao(RoomType t) {
        try {
            //delete in phong why foreign key
            String sql = "DELETE FROM phong WHERE loaiphong = ?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ps.setInt(1, t.getMaloaiphong());
            ps.executeUpdate();

            //delete in loaiphong why foreign key
            sql = "DELETE FROM loaiphong WHERE maloaiphong = ?;";
            ps.setInt(1, t.getMaloaiphong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
