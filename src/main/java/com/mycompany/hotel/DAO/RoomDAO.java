/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.DAO;

import com.mycompany.hotel.model.Room;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface RoomDAO {

    boolean insert(Room r);

    boolean update(Room r);

    void updateSTT(int stt, int r);

    boolean delete(int id);

    void updateSTT(int stt, String id);

    List<Room> getAllRoom();
}
