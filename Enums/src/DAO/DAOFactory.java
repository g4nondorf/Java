/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Moi
 */
public class DAOFactory {
    public static DAOMenage getDAOMenage(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EnumsPU");
        MenageJpaController dao = new MenageJpaController(emf);
        return dao;
    }
}
