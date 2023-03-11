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
public class Service {
    private int madichvu;
    private String tendichvu;
    private String donvitinh;
    private int dongia;

    public Service(int madichvu, String tendichvu, String donvitinh, int dongia) {
        this.madichvu = madichvu;
        this.tendichvu = tendichvu;
        this.donvitinh = donvitinh;
        this.dongia = dongia;
    }

    public Service() {
    }

    public int getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(int madichvu) {
        this.madichvu = madichvu;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    
    
}
