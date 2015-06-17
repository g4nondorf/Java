/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DAO.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Sessions;
import Entites.Menage;
import Entites.Moto;
import Entites.MotoPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class MotoJpaController implements Serializable {

    public MotoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moto moto) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (moto.getMotoPK() == null) {
            moto.setMotoPK(new MotoPK());
        }
        moto.getMotoPK().setNumeromenage(moto.getMenage().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions numerosession = moto.getNumerosession();
            if (numerosession != null) {
                numerosession = em.getReference(numerosession.getClass(), numerosession.getNumerosession());
                moto.setNumerosession(numerosession);
            }
            Menage menage = moto.getMenage();
            if (menage != null) {
                menage = em.getReference(menage.getClass(), menage.getNumeromenage());
                moto.setMenage(menage);
            }
            em.persist(moto);
            if (numerosession != null) {
                numerosession.getMotoCollection().add(moto);
                numerosession = em.merge(numerosession);
            }
            if (menage != null) {
                menage.getMotoCollection().add(moto);
                menage = em.merge(menage);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMoto(moto.getMotoPK()) != null) {
                throw new PreexistingEntityException("Moto " + moto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moto moto) throws NonexistentEntityException, RollbackFailureException, Exception {
        moto.getMotoPK().setNumeromenage(moto.getMenage().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Moto persistentMoto = em.find(Moto.class, moto.getMotoPK());
            Sessions numerosessionOld = persistentMoto.getNumerosession();
            Sessions numerosessionNew = moto.getNumerosession();
            Menage menageOld = persistentMoto.getMenage();
            Menage menageNew = moto.getMenage();
            if (numerosessionNew != null) {
                numerosessionNew = em.getReference(numerosessionNew.getClass(), numerosessionNew.getNumerosession());
                moto.setNumerosession(numerosessionNew);
            }
            if (menageNew != null) {
                menageNew = em.getReference(menageNew.getClass(), menageNew.getNumeromenage());
                moto.setMenage(menageNew);
            }
            moto = em.merge(moto);
            if (numerosessionOld != null && !numerosessionOld.equals(numerosessionNew)) {
                numerosessionOld.getMotoCollection().remove(moto);
                numerosessionOld = em.merge(numerosessionOld);
            }
            if (numerosessionNew != null && !numerosessionNew.equals(numerosessionOld)) {
                numerosessionNew.getMotoCollection().add(moto);
                numerosessionNew = em.merge(numerosessionNew);
            }
            if (menageOld != null && !menageOld.equals(menageNew)) {
                menageOld.getMotoCollection().remove(moto);
                menageOld = em.merge(menageOld);
            }
            if (menageNew != null && !menageNew.equals(menageOld)) {
                menageNew.getMotoCollection().add(moto);
                menageNew = em.merge(menageNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MotoPK id = moto.getMotoPK();
                if (findMoto(id) == null) {
                    throw new NonexistentEntityException("The moto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MotoPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Moto moto;
            try {
                moto = em.getReference(Moto.class, id);
                moto.getMotoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moto with id " + id + " no longer exists.", enfe);
            }
            Sessions numerosession = moto.getNumerosession();
            if (numerosession != null) {
                numerosession.getMotoCollection().remove(moto);
                numerosession = em.merge(numerosession);
            }
            Menage menage = moto.getMenage();
            if (menage != null) {
                menage.getMotoCollection().remove(moto);
                menage = em.merge(menage);
            }
            em.remove(moto);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moto> findMotoEntities() {
        return findMotoEntities(true, -1, -1);
    }

    public List<Moto> findMotoEntities(int maxResults, int firstResult) {
        return findMotoEntities(false, maxResults, firstResult);
    }

    private List<Moto> findMotoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Moto findMoto(MotoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moto.class, id);
        } finally {
            em.close();
        }
    }

    public int getMotoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moto> rt = cq.from(Moto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
