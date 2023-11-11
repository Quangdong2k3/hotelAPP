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
public class ThietBi extends Vat{

    
    private int soluong;
    private boolean status;

    public ThietBi(int id, String ten, String donvi, int soluong, boolean status) {
        super(id, ten, donvi);
        this.soluong = soluong;
        this.status = status;
    }

    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public ThietBi() {
    }

}
