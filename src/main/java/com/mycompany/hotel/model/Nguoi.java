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
public class Nguoi {
    private int id;
    private String ten;

    public Nguoi() {
    }

    public Nguoi(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
