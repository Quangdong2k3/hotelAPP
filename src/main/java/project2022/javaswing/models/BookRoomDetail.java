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
public class BookRoomDetail {
    private int machitiet;
    private int madatphong;
    private int madichvu;
    private int soluong;
    private int gia;

    public BookRoomDetail(int machitiet, int madatphong, int madichvu, int soluong, int gia) {
        this.machitiet = machitiet;
        this.madatphong = madatphong;
        this.madichvu = madichvu;
        this.soluong = soluong;
        this.gia = gia;
    }

    public BookRoomDetail() {
    }

    public int getMachitiet() {
        return machitiet;
    }

    public void setMachitiet(int machitiet) {
        this.machitiet = machitiet;
    }

    public int getMadatphong() {
        return madatphong;
    }

    public void setMadatphong(int madatphong) {
        this.madatphong = madatphong;
    }

    public int getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(int madichvu) {
        this.madichvu = madichvu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    
}
