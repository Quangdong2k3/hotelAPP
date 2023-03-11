/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.models;

import java.sql.Date;

/**
 *
 * @author Ching
 */
public class User {
    private int manhanvien;
    private String tennhanvien;
    private String matkhau;
    private String email;
    private String sodienthoai;
    private Date ngaysinh;
    private Date ngaylamviec;
    private String gioitinh;
    private String cmnd;
    private int maquyen;
    private int trangthai;

    public User(int manhanvien, String tennhanvien, String matkhau, String email, String sodienthoai, Date ngaysinh, Date ngaylamviec, String gioitinh, String cmnd, int maquyen, int trangthai) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.matkhau = matkhau;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.ngaysinh = ngaysinh;
        this.ngaylamviec = ngaylamviec;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.maquyen = maquyen;
        this.trangthai = trangthai;
    }

    public User() {
        
    }

    @Override
    public String toString() {
        return tennhanvien; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Date getNgaylamviec() {
        return ngaylamviec;
    }

    public void setNgaylamviec(Date ngaylamviec) {
        this.ngaylamviec = ngaylamviec;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(int maquyen) {
        this.maquyen = maquyen;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
