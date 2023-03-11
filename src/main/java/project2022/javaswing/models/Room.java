/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.models;

/**
 *
 * @author Ching
 */
public class Room {
    private int maphong;
    private String tenphong;
    private int loaiphong;
    private int gia;
    private int trangthai;

    public Room(int maphong, String tenphong, int loaiphong, int gia, int trangthai) {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.loaiphong = loaiphong;
        this.gia = gia;
        this.trangthai = trangthai;
    }

    public Room() {
    }

    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public int getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(int loaiphong) {
        this.loaiphong = loaiphong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
    
    
    
}
