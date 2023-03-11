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
public class RoomType {
    private int maloaiphong;
    private String tenloaiphong;

    public RoomType(int maloaiphong, String tenloaiphong) {
        this.maloaiphong = maloaiphong;
        this.tenloaiphong = tenloaiphong;
    }

    public RoomType() {
    }

    public int getMaloaiphong() {
        return maloaiphong;
    }

    public void setMaloaiphong(int maloaiphong) {
        this.maloaiphong = maloaiphong;
    }

    public String getTenloaiphong() {
        return tenloaiphong;
    }

    public void setTenloaiphong(String tenloaiphong) {
        this.tenloaiphong = tenloaiphong;
    }
    
    
    
}
