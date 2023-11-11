/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.model;

/**
 *
 * @author Computer
 */
public class Hoadon {

    private int id;
    private double Tongtien;
    private boolean trangthai;
    private String thoigiandat;
    private String thoigiantra;
    private Phieudatphong p;

    public Hoadon(int id, double Tongtien, boolean trangthai, String thoigiandat, String thoigiantra, Phieudatphong p) {
        this.id = id;
        this.Tongtien = Tongtien;
        this.trangthai = trangthai;
        this.thoigiandat = thoigiandat;
        this.thoigiantra = thoigiantra;
        this.p = p;
    }

    public Hoadon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getThoigiandat() {
        return thoigiandat;
    }

    public void setThoigiandat(String thoigiandat) {
        this.thoigiandat = thoigiandat;
    }

    public String getThoigiantra() {
        return thoigiantra;
    }

    public void setThoigiantra(String thoigiantra) {
        this.thoigiantra = thoigiantra;
    }

    public Phieudatphong getP() {
        return p;
    }

    public void setP(Phieudatphong p) {
        this.p = p;
    }

}
