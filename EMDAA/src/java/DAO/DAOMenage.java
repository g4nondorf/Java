/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DAO.exceptions.RollbackFailureException;
import Entites.Menage;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moi
 */
public interface DAOMenage {

    void create(Menage menage) throws PreexistingEntityException, RollbackFailureException, Exception;

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception;

    void edit(Menage menage) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception;

    Menage findMenage(Integer id);

    List<Menage> findMenageEntities();

    List<Menage> findMenageEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getMenageCount();
    
}
