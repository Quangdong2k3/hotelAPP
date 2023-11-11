/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel.DAO;

import com.mycompany.hotel.model.Employee;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface empDAO {

    boolean insert(Employee e);

    boolean delete(int id);

    boolean update(Employee e);

    List<Employee> getAllEmp();

    Employee login(String u, String pass);

}
