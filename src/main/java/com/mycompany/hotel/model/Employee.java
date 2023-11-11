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
public class Employee extends Nguoi {

    @Override
    public String toString() {
        return "Employee{" + "r=" + r + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + '}';
    }

    private Role r;
    private String taikhoan;
    private String matkhau;

    public Employee() {
    }

    public Employee(Role r, String taikhoan, String matkhau, int id, String ten) {
        super(id, ten);
        this.r = r;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
