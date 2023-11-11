/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.model;

import java.sql.Date;

/**
 *
 * @author Computer
 */
public class Phieudatphong {

    private int id;
    private KhachHang kh;
    private Employee emp;
    private Room r;
    private String thoigiandat;
    private int status;

    @Override
    public String toString() {
        return "Phieudatphong{" + "id=" + id + ", kh=" + kh + ", emp=" + emp + ", r=" + r + ", thoigiandat=" + thoigiandat + ", status=" + status + '}';
    }

    public Phieudatphong(int id, KhachHang kh, Employee emp, Room r, String thoigiandat, int status) {
        this.id = id;
        this.kh = kh;
        this.emp = emp;
        this.r = r;
        this.thoigiandat = thoigiandat;
        this.status = status;
    }

    public Phieudatphong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Room getR() {
        return r;
    }

    public void setR(Room r) {
        this.r = r;
    }

    public String getThoigiandat() {
        return thoigiandat;
    }

    public void setThoigiandat(String thoigiandat) {
        this.thoigiandat = thoigiandat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
