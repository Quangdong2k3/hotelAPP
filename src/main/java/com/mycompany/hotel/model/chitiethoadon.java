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
public class chitiethoadon {

    private Hoadon h;
    private int id;
    private int soluong;
    private Dichvu dv;

    public chitiethoadon() {
    }

    public Hoadon getH() {
        return h;
    }

    public void setH(Hoadon h) {
        this.h = h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public chitiethoadon(Hoadon h, int id, int soluong, Dichvu dv) {
        this.h = h;
        this.id = id;
        this.soluong = soluong;
        this.dv = dv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Dichvu getDv() {
        return dv;
    }

    public void setDv(Dichvu dv) {
        this.dv = dv;
    }
}
