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
import Entites.VoitureTourisme;
import Entites.VoitureTourismePK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class VoitureTourismeJpaController implements Serializable {

    public VoitureTourismeJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VoitureTourisme voitureTourisme) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (voitureTourisme.getVoitureTourismePK() == null) {
            voitureTourisme.setVoitureTourismePK(new VoitureTourismePK());
        }
        voitureTourisme.getVoitureTourismePK().setNumeromenage(voitureTourisme.getMenage().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions numerosession = voitureTourisme.getNumerosession();
            if (numerosession != null) {
                numerosession = em.getReference(numerosession.getClass(), numerosession.getNumerosession());
                voitureTourisme.setNumerosession(numerosession);
            }
            Menage menage = voitureTourisme.getMenage();
            if (menage != null) {
                menage = em.getReference(menage.getClass(), menage.getNumeromenage());
                voitureTourisme.setMenage(menage);
            }
            em.persist(voitureTourisme);
            if (numerosession != null) {
                numerosession.getVoitureTourismeCollection().add(voitureTourisme);
                numerosession = em.merge(numerosession);
            }
            if (menage != null) {
                menage.getVoitureTourismeCollection().add(voitureTourisme);
                menage = em.merge(menage);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findVoitureTourisme(voitureTourisme.getVoitureTourismePK()) != null) {
                throw new PreexistingEntityException("VoitureTourisme " + voitureTourisme + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VoitureTourisme voitureTourisme) throws NonexistentEntityException, RollbackFailureException, Exception {
        voitureTourisme.getVoitureTourismePK().setNumeromenage(voitureTourisme.getMenage().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            VoitureTourisme persistentVoitureTourisme = em.find(VoitureTourisme.class, voitureTourisme.getVoitureTourismePK());
            Sessions numerosessionOld = persistentVoitureTourisme.getNumerosession();
            Sessions numerosessionNew = voitureTourisme.getNumerosession();
            Menage menageOld = persistentVoitureTourisme.getMenage();
            Menage menageNew = voitureTourisme.getMenage();
            if (numerosessionNew != null) {
                numerosessionNew = em.getReference(numerosessionNew.getClass(), numerosessionNew.getNumerosession());
                voitureTourisme.setNumerosession(numerosessionNew);
            }
            if (menageNew != null) {
                menageNew = em.getReference(menageNew.getClass(), menageNew.getNumeromenage());
                voitureTourisme.setMenage(menageNew);
            }
            voitureTourisme = em.merge(voitureTourisme);
            if (numerosessionOld != null && !numerosessionOld.equals(numerosessionNew)) {
                numerosessionOld.getVoitureTourismeCollection().remove(voitureTourisme);
                numerosessionOld = em.merge(numerosessionOld);
            }
            if (numerosessionNew != null && !numerosessionNew.equals(numerosessionOld)) {
                numerosessionNew.getVoitureTourismeCollection().add(voitureTourisme);
                numerosessionNew = em.merge(numerosessionNew);
            }
            if (menageOld != null && !menageOld.equals(menageNew)) {
                menageOld.getVoitureTourismeCollection().remove(voitureTourisme);
                menageOld = em.merge(menageOld);
            }
            if (menageNew != null && !menageNew.equals(menageOld)) {
                menageNew.getVoitureTourismeCollection().add(voitureTourisme);
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
                VoitureTourismePK id = voitureTourisme.getVoitureTourismePK();
                if (findVoitureTourisme(id) == null) {
                    throw new NonexistentEntityException("The voitureTourisme with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(VoitureTourismePK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            VoitureTourisme voitureTourisme;
            try {
                voitureTourisme = em.getReference(VoitureTourisme.class, id);
                voitureTourisme.getVoitureTourismePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The voitureTourisme with id " + id + " no longer exists.", enfe);
            }
            Sessions numerosession = voitureTourisme.getNumerosession();
            if (numerosession != null) {
                numerosession.getVoitureTourismeCollection().remove(voitureTourisme);
                numerosession = em.merge(numerosession);
            }
            Menage menage = voitureTourisme.getMenage();
            if (menage != null) {
                menage.getVoitureTourismeCollection().remove(voitureTourisme);
                menage = em.merge(menage);
            }
            em.remove(voitureTourisme);
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

    public List<VoitureTourisme> findVoitureTourismeEntities() {
        return findVoitureTourismeEntities(true, -1, -1);
    }

    public List<VoitureTourisme> findVoitureTourismeEntities(int maxResults, int firstResult) {
        return findVoitureTourismeEntities(false, maxResults, firstResult);
    }

    private List<VoitureTourisme> findVoitureTourismeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VoitureTourisme.class));
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

    public VoitureTourisme findVoitureTourisme(VoitureTourismePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VoitureTourisme.class, id);
        } finally {
            em.close();
        }
    }

    public int getVoitureTourismeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VoitureTourisme> rt = cq.from(VoitureTourisme.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
