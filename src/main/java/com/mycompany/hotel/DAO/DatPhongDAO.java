/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.DAO;

import com.mycompany.hotel.model.Phieudatphong;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface DatPhongDAO {

    boolean insert(Phieudatphong p);

    Phieudatphong getSTTIDROOM();

    Phieudatphong searchNameRoom(String name);

    List<Phieudatphong> getAllPD();

    void UpdatePhieuSTT(int id, int i);


    List<Phieudatphong> searchNameRooms(String name);
}
