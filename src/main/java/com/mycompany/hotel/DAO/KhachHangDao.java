/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.DAO;

import com.mycompany.hotel.model.KhachHang;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface KhachHangDao {

    boolean insert(KhachHang r);

    boolean update(KhachHang r);

    boolean delete(int id);

    List<KhachHang> getAllKH();

    KhachHang getById(int id);

}
