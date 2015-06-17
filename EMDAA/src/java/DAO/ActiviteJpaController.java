/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DAO.exceptions.RollbackFailureException;
import Entites.Activite;
import Entites.ActivitePK;
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
public class ActiviteJpaController implements Serializable {

    public ActiviteJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Activite activite) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (activite.getActivitePK() == null) {
            activite.setActivitePK(new ActivitePK());
        }
        activite.getActivitePK().setNumeromenage(activite.getPanel().getPanelPK().getNumeromenage());
        activite.getActivitePK().setNumeropersonne(activite.getPanel().getPanelPK().getNumeropersonne());
        activite.getActivitePK().setNumerosession(activite.getSessions().getNumerosession());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions sessions = activite.getSessions();
            if (sessions != null) {
                sessions = em.getReference(sessions.getClass(), sessions.getNumerosession());
                activite.setSessions(sessions);
            }
            Panel panel = activite.getPanel();
            if (panel != null) {
                panel = em.getReference(panel.getClass(), panel.getPanelPK());
                activite.setPanel(panel);
            }
            em.persist(activite);
            if (sessions != null) {
                sessions.getActiviteCollection().add(activite);
                sessions = em.merge(sessions);
            }
            if (panel != null) {
                panel.getActiviteCollection().add(activite);
                panel = em.merge(panel);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findActivite(activite.getActivitePK()) != null) {
                throw new PreexistingEntityException("Activite " + activite + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Activite activite) throws NonexistentEntityException, RollbackFailureException, Exception {
        activite.getActivitePK().setNumeromenage(activite.getPanel().getPanelPK().getNumeromenage());
        activite.getActivitePK().setNumeropersonne(activite.getPanel().getPanelPK().getNumeropersonne());
        activite.getActivitePK().setNumerosession(activite.getSessions().getNumerosession());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Activite persistentActivite = em.find(Activite.class, activite.getActivitePK());
            Sessions sessionsOld = persistentActivite.getSessions();
            Sessions sessionsNew = activite.getSessions();
            Panel panelOld = persistentActivite.getPanel();
            Panel panelNew = activite.getPanel();
            if (sessionsNew != null) {
                sessionsNew = em.getReference(sessionsNew.getClass(), sessionsNew.getNumerosession());
                activite.setSessions(sessionsNew);
            }
            if (panelNew != null) {
                panelNew = em.getReference(panelNew.getClass(), panelNew.getPanelPK());
                activite.setPanel(panelNew);
            }
            activite = em.merge(activite);
            if (sessionsOld != null && !sessionsOld.equals(sessionsNew)) {
                sessionsOld.getActiviteCollection().remove(activite);
                sessionsOld = em.merge(sessionsOld);
            }
            if (sessionsNew != null && !sessionsNew.equals(sessionsOld)) {
                sessionsNew.getActiviteCollection().add(activite);
                sessionsNew = em.merge(sessionsNew);
            }
            if (panelOld != null && !panelOld.equals(panelNew)) {
                panelOld.getActiviteCollection().remove(activite);
                panelOld = em.merge(panelOld);
            }
            if (panelNew != null && !panelNew.equals(panelOld)) {
                panelNew.getActiviteCollection().add(activite);
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
                ActivitePK id = activite.getActivitePK();
                if (findActivite(id) == null) {
                    throw new NonexistentEntityException("The activite with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ActivitePK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Activite activite;
            try {
                activite = em.getReference(Activite.class, id);
                activite.getActivitePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The activite with id " + id + " no longer exists.", enfe);
            }
            Sessions sessions = activite.getSessions();
            if (sessions != null) {
                sessions.getActiviteCollection().remove(activite);
                sessions = em.merge(sessions);
            }
            Panel panel = activite.getPanel();
            if (panel != null) {
                panel.getActiviteCollection().remove(activite);
                panel = em.merge(panel);
            }
            em.remove(activite);
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

    public List<Activite> findActiviteEntities() {
        return findActiviteEntities(true, -1, -1);
    }

    public List<Activite> findActiviteEntities(int maxResults, int firstResult) {
        return findActiviteEntities(false, maxResults, firstResult);
    }

    private List<Activite> findActiviteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Activite.class));
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

    public Activite findActivite(ActivitePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Activite.class, id);
        } finally {
            em.close();
        }
    }

    public int getActiviteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Activite> rt = cq.from(Activite.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
