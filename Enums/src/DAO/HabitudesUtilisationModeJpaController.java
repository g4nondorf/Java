/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import Entites.HabitudesUtilisationMode;
import Entites.HabitudesUtilisationModePK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Sessions;
import Entites.Panel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moi
 */
public class HabitudesUtilisationModeJpaController implements Serializable {

    public HabitudesUtilisationModeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HabitudesUtilisationMode habitudesUtilisationMode) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (habitudesUtilisationMode.getHabitudesUtilisationModePK() == null) {
            habitudesUtilisationMode.setHabitudesUtilisationModePK(new HabitudesUtilisationModePK());
        }
        habitudesUtilisationMode.getHabitudesUtilisationModePK().setNumeropersonne(habitudesUtilisationMode.getPanel().getPanelPK().getNumeropersonne());
        habitudesUtilisationMode.getHabitudesUtilisationModePK().setNumeromenage(habitudesUtilisationMode.getPanel().getPanelPK().getNumeromenage());
        List<String> illegalOrphanMessages = null;
        Panel panelOrphanCheck = habitudesUtilisationMode.getPanel();
        if (panelOrphanCheck != null) {
            HabitudesUtilisationMode oldHabitudesUtilisationModeOfPanel = panelOrphanCheck.getHabitudesUtilisationMode();
            if (oldHabitudesUtilisationModeOfPanel != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Panel " + panelOrphanCheck + " already has an item of type HabitudesUtilisationMode whose panel column cannot be null. Please make another selection for the panel field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sessions numerosession = habitudesUtilisationMode.getNumerosession();
            if (numerosession != null) {
                numerosession = em.getReference(numerosession.getClass(), numerosession.getNumerosession());
                habitudesUtilisationMode.setNumerosession(numerosession);
            }
            Panel panel = habitudesUtilisationMode.getPanel();
            if (panel != null) {
                panel = em.getReference(panel.getClass(), panel.getPanelPK());
                habitudesUtilisationMode.setPanel(panel);
            }
            em.persist(habitudesUtilisationMode);
            if (numerosession != null) {
                numerosession.getHabitudesUtilisationModeCollection().add(habitudesUtilisationMode);
                numerosession = em.merge(numerosession);
            }
            if (panel != null) {
                panel.setHabitudesUtilisationMode(habitudesUtilisationMode);
                panel = em.merge(panel);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHabitudesUtilisationMode(habitudesUtilisationMode.getHabitudesUtilisationModePK()) != null) {
                throw new PreexistingEntityException("HabitudesUtilisationMode " + habitudesUtilisationMode + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HabitudesUtilisationMode habitudesUtilisationMode) throws IllegalOrphanException, NonexistentEntityException, Exception {
        habitudesUtilisationMode.getHabitudesUtilisationModePK().setNumeropersonne(habitudesUtilisationMode.getPanel().getPanelPK().getNumeropersonne());
        habitudesUtilisationMode.getHabitudesUtilisationModePK().setNumeromenage(habitudesUtilisationMode.getPanel().getPanelPK().getNumeromenage());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HabitudesUtilisationMode persistentHabitudesUtilisationMode = em.find(HabitudesUtilisationMode.class, habitudesUtilisationMode.getHabitudesUtilisationModePK());
            Sessions numerosessionOld = persistentHabitudesUtilisationMode.getNumerosession();
            Sessions numerosessionNew = habitudesUtilisationMode.getNumerosession();
            Panel panelOld = persistentHabitudesUtilisationMode.getPanel();
            Panel panelNew = habitudesUtilisationMode.getPanel();
            List<String> illegalOrphanMessages = null;
            if (panelNew != null && !panelNew.equals(panelOld)) {
                HabitudesUtilisationMode oldHabitudesUtilisationModeOfPanel = panelNew.getHabitudesUtilisationMode();
                if (oldHabitudesUtilisationModeOfPanel != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Panel " + panelNew + " already has an item of type HabitudesUtilisationMode whose panel column cannot be null. Please make another selection for the panel field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (numerosessionNew != null) {
                numerosessionNew = em.getReference(numerosessionNew.getClass(), numerosessionNew.getNumerosession());
                habitudesUtilisationMode.setNumerosession(numerosessionNew);
            }
            if (panelNew != null) {
                panelNew = em.getReference(panelNew.getClass(), panelNew.getPanelPK());
                habitudesUtilisationMode.setPanel(panelNew);
            }
            habitudesUtilisationMode = em.merge(habitudesUtilisationMode);
            if (numerosessionOld != null && !numerosessionOld.equals(numerosessionNew)) {
                numerosessionOld.getHabitudesUtilisationModeCollection().remove(habitudesUtilisationMode);
                numerosessionOld = em.merge(numerosessionOld);
            }
            if (numerosessionNew != null && !numerosessionNew.equals(numerosessionOld)) {
                numerosessionNew.getHabitudesUtilisationModeCollection().add(habitudesUtilisationMode);
                numerosessionNew = em.merge(numerosessionNew);
            }
            if (panelOld != null && !panelOld.equals(panelNew)) {
                panelOld.setHabitudesUtilisationMode(null);
                panelOld = em.merge(panelOld);
            }
            if (panelNew != null && !panelNew.equals(panelOld)) {
                panelNew.setHabitudesUtilisationMode(habitudesUtilisationMode);
                panelNew = em.merge(panelNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                HabitudesUtilisationModePK id = habitudesUtilisationMode.getHabitudesUtilisationModePK();
                if (findHabitudesUtilisationMode(id) == null) {
                    throw new NonexistentEntityException("The habitudesUtilisationMode with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(HabitudesUtilisationModePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HabitudesUtilisationMode habitudesUtilisationMode;
            try {
                habitudesUtilisationMode = em.getReference(HabitudesUtilisationMode.class, id);
                habitudesUtilisationMode.getHabitudesUtilisationModePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habitudesUtilisationMode with id " + id + " no longer exists.", enfe);
            }
            Sessions numerosession = habitudesUtilisationMode.getNumerosession();
            if (numerosession != null) {
                numerosession.getHabitudesUtilisationModeCollection().remove(habitudesUtilisationMode);
                numerosession = em.merge(numerosession);
            }
            Panel panel = habitudesUtilisationMode.getPanel();
            if (panel != null) {
                panel.setHabitudesUtilisationMode(null);
                panel = em.merge(panel);
            }
            em.remove(habitudesUtilisationMode);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HabitudesUtilisationMode> findHabitudesUtilisationModeEntities() {
        return findHabitudesUtilisationModeEntities(true, -1, -1);
    }

    public List<HabitudesUtilisationMode> findHabitudesUtilisationModeEntities(int maxResults, int firstResult) {
        return findHabitudesUtilisationModeEntities(false, maxResults, firstResult);
    }

    private List<HabitudesUtilisationMode> findHabitudesUtilisationModeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HabitudesUtilisationMode.class));
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

    public HabitudesUtilisationMode findHabitudesUtilisationMode(HabitudesUtilisationModePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HabitudesUtilisationMode.class, id);
        } finally {
            em.close();
        }
    }

    public int getHabitudesUtilisationModeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HabitudesUtilisationMode> rt = cq.from(HabitudesUtilisationMode.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
