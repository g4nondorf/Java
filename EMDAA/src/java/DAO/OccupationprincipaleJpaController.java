/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DAO.exceptions.RollbackFailureException;
import Entites.Occupationprincipale;
import Entites.OccupationprincipalePK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Sessions;
import Entites.Panel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class OccupationprincipaleJpaController implements Serializable {

    public OccupationprincipaleJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Occupationprincipale occupationprincipale) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (occupationprincipale.getOccupationprincipalePK() == null) {
            occupationprincipale.setOccupationprincipalePK(new OccupationprincipalePK());
        }
        occupationprincipale.getOccupationprincipalePK().setNumeropersonne(occupationprincipale.getPanel().getPanelPK().getNumeropersonne());
        occupationprincipale.getOccupationprincipalePK().setNumeromenage(occupationprincipale.getPanel().getPanelPK().getNumeromenage());
        occupationprincipale.getOccupationprincipalePK().setNumerosession(occupationprincipale.getSessions().getNumerosession());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions sessions = occupationprincipale.getSessions();
            if (sessions != null) {
                sessions = em.getReference(sessions.getClass(), sessions.getNumerosession());
                occupationprincipale.setSessions(sessions);
            }
            Panel panel = occupationprincipale.getPanel();
            if (panel != null) {
                panel = em.getReference(panel.getClass(), panel.getPanelPK());
                occupationprincipale.setPanel(panel);
            }
            em.persist(occupationprincipale);
            if (sessions != null) {
                sessions.getOccupationprincipaleCollection().add(occupationprincipale);
                sessions = em.merge(sessions);
            }
            if (panel != null) {
                panel.getOccupationprincipaleCollection().add(occupationprincipale);
                panel = em.merge(panel);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findOccupationprincipale(occupationprincipale.getOccupationprincipalePK()) != null) {
                throw new PreexistingEntityException("Occupationprincipale " + occupationprincipale + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Occupationprincipale occupationprincipale) throws NonexistentEntityException, RollbackFailureException, Exception {
        occupationprincipale.getOccupationprincipalePK().setNumeropersonne(occupationprincipale.getPanel().getPanelPK().getNumeropersonne());
        occupationprincipale.getOccupationprincipalePK().setNumeromenage(occupationprincipale.getPanel().getPanelPK().getNumeromenage());
        occupationprincipale.getOccupationprincipalePK().setNumerosession(occupationprincipale.getSessions().getNumerosession());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Occupationprincipale persistentOccupationprincipale = em.find(Occupationprincipale.class, occupationprincipale.getOccupationprincipalePK());
            Sessions sessionsOld = persistentOccupationprincipale.getSessions();
            Sessions sessionsNew = occupationprincipale.getSessions();
            Panel panelOld = persistentOccupationprincipale.getPanel();
            Panel panelNew = occupationprincipale.getPanel();
            if (sessionsNew != null) {
                sessionsNew = em.getReference(sessionsNew.getClass(), sessionsNew.getNumerosession());
                occupationprincipale.setSessions(sessionsNew);
            }
            if (panelNew != null) {
                panelNew = em.getReference(panelNew.getClass(), panelNew.getPanelPK());
                occupationprincipale.setPanel(panelNew);
            }
            occupationprincipale = em.merge(occupationprincipale);
            if (sessionsOld != null && !sessionsOld.equals(sessionsNew)) {
                sessionsOld.getOccupationprincipaleCollection().remove(occupationprincipale);
                sessionsOld = em.merge(sessionsOld);
            }
            if (sessionsNew != null && !sessionsNew.equals(sessionsOld)) {
                sessionsNew.getOccupationprincipaleCollection().add(occupationprincipale);
                sessionsNew = em.merge(sessionsNew);
            }
            if (panelOld != null && !panelOld.equals(panelNew)) {
                panelOld.getOccupationprincipaleCollection().remove(occupationprincipale);
                panelOld = em.merge(panelOld);
            }
            if (panelNew != null && !panelNew.equals(panelOld)) {
                panelNew.getOccupationprincipaleCollection().add(occupationprincipale);
                panelNew = em.merge(panelNew);
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
                OccupationprincipalePK id = occupationprincipale.getOccupationprincipalePK();
                if (findOccupationprincipale(id) == null) {
                    throw new NonexistentEntityException("The occupationprincipale with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(OccupationprincipalePK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Occupationprincipale occupationprincipale;
            try {
                occupationprincipale = em.getReference(Occupationprincipale.class, id);
                occupationprincipale.getOccupationprincipalePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The occupationprincipale with id " + id + " no longer exists.", enfe);
            }
            Sessions sessions = occupationprincipale.getSessions();
            if (sessions != null) {
                sessions.getOccupationprincipaleCollection().remove(occupationprincipale);
                sessions = em.merge(sessions);
            }
            Panel panel = occupationprincipale.getPanel();
            if (panel != null) {
                panel.getOccupationprincipaleCollection().remove(occupationprincipale);
                panel = em.merge(panel);
            }
            em.remove(occupationprincipale);
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

    public List<Occupationprincipale> findOccupationprincipaleEntities() {
        return findOccupationprincipaleEntities(true, -1, -1);
    }

    public List<Occupationprincipale> findOccupationprincipaleEntities(int maxResults, int firstResult) {
        return findOccupationprincipaleEntities(false, maxResults, firstResult);
    }

    private List<Occupationprincipale> findOccupationprincipaleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Occupationprincipale.class));
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

    public Occupationprincipale findOccupationprincipale(OccupationprincipalePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Occupationprincipale.class, id);
        } finally {
            em.close();
        }
    }

    public int getOccupationprincipaleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Occupationprincipale> rt = cq.from(Occupationprincipale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
