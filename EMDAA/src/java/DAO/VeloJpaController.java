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
import Entites.Velo;
import Entites.VeloPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class VeloJpaController implements Serializable {

    public VeloJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Velo velo) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (velo.getVeloPK() == null) {
            velo.setVeloPK(new VeloPK());
        }
        velo.getVeloPK().setNumeromenage(velo.getMenage().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions numerosession = velo.getNumerosession();
            if (numerosession != null) {
                numerosession = em.getReference(numerosession.getClass(), numerosession.getNumerosession());
                velo.setNumerosession(numerosession);
            }
            Menage menage = velo.getMenage();
            if (menage != null) {
                menage = em.getReference(menage.getClass(), menage.getNumeromenage());
                velo.setMenage(menage);
            }
            em.persist(velo);
            if (numerosession != null) {
                numerosession.getVeloCollection().add(velo);
                numerosession = em.merge(numerosession);
            }
            if (menage != null) {
                menage.getVeloCollection().add(velo);
                menage = em.merge(menage);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findVelo(velo.getVeloPK()) != null) {
                throw new PreexistingEntityException("Velo " + velo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Velo velo) throws NonexistentEntityException, RollbackFailureException, Exception {
        velo.getVeloPK().setNumeromenage(velo.getMenage().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Velo persistentVelo = em.find(Velo.class, velo.getVeloPK());
            Sessions numerosessionOld = persistentVelo.getNumerosession();
            Sessions numerosessionNew = velo.getNumerosession();
            Menage menageOld = persistentVelo.getMenage();
            Menage menageNew = velo.getMenage();
            if (numerosessionNew != null) {
                numerosessionNew = em.getReference(numerosessionNew.getClass(), numerosessionNew.getNumerosession());
                velo.setNumerosession(numerosessionNew);
            }
            if (menageNew != null) {
                menageNew = em.getReference(menageNew.getClass(), menageNew.getNumeromenage());
                velo.setMenage(menageNew);
            }
            velo = em.merge(velo);
            if (numerosessionOld != null && !numerosessionOld.equals(numerosessionNew)) {
                numerosessionOld.getVeloCollection().remove(velo);
                numerosessionOld = em.merge(numerosessionOld);
            }
            if (numerosessionNew != null && !numerosessionNew.equals(numerosessionOld)) {
                numerosessionNew.getVeloCollection().add(velo);
                numerosessionNew = em.merge(numerosessionNew);
            }
            if (menageOld != null && !menageOld.equals(menageNew)) {
                menageOld.getVeloCollection().remove(velo);
                menageOld = em.merge(menageOld);
            }
            if (menageNew != null && !menageNew.equals(menageOld)) {
                menageNew.getVeloCollection().add(velo);
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
                VeloPK id = velo.getVeloPK();
                if (findVelo(id) == null) {
                    throw new NonexistentEntityException("The velo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(VeloPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Velo velo;
            try {
                velo = em.getReference(Velo.class, id);
                velo.getVeloPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The velo with id " + id + " no longer exists.", enfe);
            }
            Sessions numerosession = velo.getNumerosession();
            if (numerosession != null) {
                numerosession.getVeloCollection().remove(velo);
                numerosession = em.merge(numerosession);
            }
            Menage menage = velo.getMenage();
            if (menage != null) {
                menage.getVeloCollection().remove(velo);
                menage = em.merge(menage);
            }
            em.remove(velo);
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

    public List<Velo> findVeloEntities() {
        return findVeloEntities(true, -1, -1);
    }

    public List<Velo> findVeloEntities(int maxResults, int firstResult) {
        return findVeloEntities(false, maxResults, firstResult);
    }

    private List<Velo> findVeloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Velo.class));
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

    public Velo findVelo(VeloPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Velo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVeloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Velo> rt = cq.from(Velo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
