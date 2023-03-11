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
public class BookRoom {
    private int madatphong;
    private int manhanvien;
    private int makhachhang;
    private int maphong;
    private Date ngaydat;
    private Date ngaytra;
    private int tonggiatri;
    private int trangthai;

    public BookRoom(int madatphong, int manhanvien, int makhachhang, int maphong, Date ngaydat, Date ngaytra, int tonggiatri, int trangthai) {
        this.madatphong = madatphong;
        this.manhanvien = manhanvien;
        this.makhachhang = makhachhang;
        this.maphong = maphong;
        this.ngaydat = ngaydat;
        this.ngaytra = ngaytra;
        this.tonggiatri = tonggiatri;
        this.trangthai = trangthai;
    }

    public BookRoom() {
    }

    public int getMadatphong() {
        return madatphong;
    }

    public void setMadatphong(int madatphong) {
        this.madatphong = madatphong;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public int getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(int makhachhang) {
        this.makhachhang = makhachhang;
    }

    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public Date getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public int getTonggiatri() {
        return tonggiatri;
    }

    public void setTonggiatri(int tonggiatri) {
        this.tonggiatri = tonggiatri;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
