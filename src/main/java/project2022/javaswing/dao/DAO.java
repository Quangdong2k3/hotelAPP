/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.dao;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Ching
 */
public interface DAO<T> {
    ArrayList<T> getAll();
    T getDetail(T t) ;
    void insertDao(T t);
    void updateDao(T t);
    void deleteDao(T t);
}
