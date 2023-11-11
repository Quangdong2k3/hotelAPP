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
public class Vat {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the donvi
     */
    public String getDonvi() {
        return donvi;
    }

    /**
     * @param donvi the donvi to set
     */
    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
    private int id;
    private String ten;
    private String donvi;

    public Vat(int id, String ten, String donvi) {
        this.id = id;
        this.ten = ten;
        this.donvi = donvi;
    }

    public Vat() {
    }
    
}
