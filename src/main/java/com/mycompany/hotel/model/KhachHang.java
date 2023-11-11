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
public class KhachHang extends Nguoi{
    
    private String cccd;
    private String sdt;

    public KhachHang() {
    }

    public KhachHang(String cccd, String sdt) {
        this.cccd = cccd;
        this.sdt = sdt;
    }

    public KhachHang(String cccd, String sdt, int id, String ten) {
        super(id, ten);
        this.cccd = cccd;
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
    
}
