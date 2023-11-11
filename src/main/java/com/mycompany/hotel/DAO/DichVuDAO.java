/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.DAO;

import com.mycompany.hotel.model.Dichvu;
import com.mycompany.hotel.model.ThietBi;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface DichVuDAO {

    boolean insert(Dichvu r);

    boolean update(Dichvu r);

    boolean delete(int id);

    List<Dichvu> getAllDV();

    ThietBi getById(int id);
}
