/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.DAO;

import com.mycompany.hotel.model.Hoadon;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface HoaDonDAO {
List<Hoadon> lst();
List<Hoadon> lstgetDate(String date);

    boolean insert_hoadon(Hoadon h);
}
