/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project2022.javaswing.config.DBConnection;
import project2022.javaswing.models.User;

/**
 *
 * @author Ching
 */
public class UserDao implements DAO<User> {

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> listUser = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM nhanvien;";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User tmp = new User(rs.getInt("manhanvien"), rs.getString("tennhanvien"), rs.getString("matkhau"), rs.getString("email"), rs.getString("sodienthoai"), rs.getDate("ngaysinh"), rs.getDate("ngaylamviec"), rs.getString("gioitinh"), rs.getString("cmnd"), rs.getInt("maquyen"), rs.getInt("maquyen"));
                listUser.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;

    }

    @Override
    public void insertDao(User t) {
        try {
            String sql = "INSERT INTO nhanvien (tennhanvien, matkhau, email, sodienthoai, ngaysinh, ngaylamviec, gioitinh, cmnd, maquyen, trangthai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, t.getTennhanvien());
            ps.setString(2, t.getMatkhau());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSodienthoai());
            ps.setDate(5, t.getNgaysinh());
            ps.setDate(6, t.getNgaylamviec());
            ps.setString(7, t.getGioitinh());
            ps.setString(8, t.getCmnd());
            ps.setInt(9, t.getMaquyen());
            ps.setInt(10, t.getTrangthai());
            if (ps.executeUpdate() < 1) {
                throw new Exception("Xảy ra lỗi khi thực hiện thêm nhân viên");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDao(User t) {
        try {
            String sql = "UPDATE nhanvien SET tennhanvien = ?, matkhau = ?, email = ?, sodienthoai = ?, ngaysinh = ?, ngaylamviec = ?, gioitinh = ?, cmnd = ?, maquyen = ?, trangthai = ? WHERE manhanvien = ?;";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, t.getTennhanvien());
            ps.setString(2, t.getMatkhau());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSodienthoai());
            ps.setDate(5, t.getNgaysinh());
            ps.setDate(6, t.getNgaylamviec());
            ps.setString(7, t.getGioitinh());
            ps.setString(8, t.getCmnd());
            ps.setInt(9, t.getMaquyen());
            ps.setInt(10, t.getTrangthai());
            ps.setInt(11, t.getManhanvien());
            if (ps.executeUpdate() < 1) {
                throw new Exception("Xảy ra lỗi khi thực hiện thêm nhân viên");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteDao(User t) {
        try {
            String sql = "DELETE FROM nhanvien WHERE manhanvien = ?;";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ps.setInt(1, t.getManhanvien());
            if (ps.executeUpdate() < 1) {
                throw new Exception("Xảy ra lỗi khi thực hiện thêm nhân viên");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkLogin(String email, String upass) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?;";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User getDetail(User t) {
        User user = new User();
        try {
            String sql = "SELECT * FROM nhanvien WHERE manhanvien = ? ;";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, t.getManhanvien());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("manhanvien"), rs.getString("tennhanvien"), rs.getString("matkhau"), rs.getString("email"), rs.getString("sodienthoai"), rs.getDate("ngaysinh"), rs.getDate("ngaylamviec"), rs.getString("gioitinh"), rs.getString("cmnd"), rs.getInt("maquyen"), rs.getInt("maquyen"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static void main(String[] args) {
        UserDao ud = new UserDao();
        Date date = Date.valueOf("2015-03-31");
        User user = new User();
        user.setManhanvien(1);
        System.out.println(ud.getDetail(user).toString());
    }

}
