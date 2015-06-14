/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Iris;
import Entites.Numerocarreau;
import Entites.Panel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moi
 */
public class NumerocarreauJpaController implements Serializable {

    public NumerocarreauJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Numerocarreau numerocarreau) throws PreexistingEntityException, Exception {
        if (numerocarreau.getPanelCollection() == null) {
            numerocarreau.setPanelCollection(new ArrayList<Panel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Iris numeroiris = numerocarreau.getNumeroiris();
            if (numeroiris != null) {
                numeroiris = em.getReference(numeroiris.getClass(), numeroiris.getNumeroiris());
                numerocarreau.setNumeroiris(numeroiris);
            }
            Collection<Panel> attachedPanelCollection = new ArrayList<Panel>();
            for (Panel panelCollectionPanelToAttach : numerocarreau.getPanelCollection()) {
                panelCollectionPanelToAttach = em.getReference(panelCollectionPanelToAttach.getClass(), panelCollectionPanelToAttach.getPanelPK());
                attachedPanelCollection.add(panelCollectionPanelToAttach);
            }
            numerocarreau.setPanelCollection(attachedPanelCollection);
            em.persist(numerocarreau);
            if (numeroiris != null) {
                numeroiris.getNumerocarreauCollection().add(numerocarreau);
                numeroiris = em.merge(numeroiris);
            }
            for (Panel panelCollectionPanel : numerocarreau.getPanelCollection()) {
                Numerocarreau oldNumerocarreauOfPanelCollectionPanel = panelCollectionPanel.getNumerocarreau();
                panelCollectionPanel.setNumerocarreau(numerocarreau);
                panelCollectionPanel = em.merge(panelCollectionPanel);
                if (oldNumerocarreauOfPanelCollectionPanel != null) {
                    oldNumerocarreauOfPanelCollectionPanel.getPanelCollection().remove(panelCollectionPanel);
                    oldNumerocarreauOfPanelCollectionPanel = em.merge(oldNumerocarreauOfPanelCollectionPanel);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNumerocarreau(numerocarreau.getNumeroc()) != null) {
                throw new PreexistingEntityException("Numerocarreau " + numerocarreau + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Numerocarreau numerocarreau) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Numerocarreau persistentNumerocarreau = em.find(Numerocarreau.class, numerocarreau.getNumeroc());
            Iris numeroirisOld = persistentNumerocarreau.getNumeroiris();
            Iris numeroirisNew = numerocarreau.getNumeroiris();
            Collection<Panel> panelCollectionOld = persistentNumerocarreau.getPanelCollection();
            Collection<Panel> panelCollectionNew = numerocarreau.getPanelCollection();
            List<String> illegalOrphanMessages = null;
            for (Panel panelCollectionOldPanel : panelCollectionOld) {
                if (!panelCollectionNew.contains(panelCollectionOldPanel)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Panel " + panelCollectionOldPanel + " since its numerocarreau field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (numeroirisNew != null) {
                numeroirisNew = em.getReference(numeroirisNew.getClass(), numeroirisNew.getNumeroiris());
                numerocarreau.setNumeroiris(numeroirisNew);
            }
            Collection<Panel> attachedPanelCollectionNew = new ArrayList<Panel>();
            for (Panel panelCollectionNewPanelToAttach : panelCollectionNew) {
                panelCollectionNewPanelToAttach = em.getReference(panelCollectionNewPanelToAttach.getClass(), panelCollectionNewPanelToAttach.getPanelPK());
                attachedPanelCollectionNew.add(panelCollectionNewPanelToAttach);
            }
            panelCollectionNew = attachedPanelCollectionNew;
            numerocarreau.setPanelCollection(panelCollectionNew);
            numerocarreau = em.merge(numerocarreau);
            if (numeroirisOld != null && !numeroirisOld.equals(numeroirisNew)) {
                numeroirisOld.getNumerocarreauCollection().remove(numerocarreau);
                numeroirisOld = em.merge(numeroirisOld);
            }
            if (numeroirisNew != null && !numeroirisNew.equals(numeroirisOld)) {
                numeroirisNew.getNumerocarreauCollection().add(numerocarreau);
                numeroirisNew = em.merge(numeroirisNew);
            }
            for (Panel panelCollectionNewPanel : panelCollectionNew) {
                if (!panelCollectionOld.contains(panelCollectionNewPanel)) {
                    Numerocarreau oldNumerocarreauOfPanelCollectionNewPanel = panelCollectionNewPanel.getNumerocarreau();
                    panelCollectionNewPanel.setNumerocarreau(numerocarreau);
                    panelCollectionNewPanel = em.merge(panelCollectionNewPanel);
                    if (oldNumerocarreauOfPanelCollectionNewPanel != null && !oldNumerocarreauOfPanelCollectionNewPanel.equals(numerocarreau)) {
                        oldNumerocarreauOfPanelCollectionNewPanel.getPanelCollection().remove(panelCollectionNewPanel);
                        oldNumerocarreauOfPanelCollectionNewPanel = em.merge(oldNumerocarreauOfPanelCollectionNewPanel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = numerocarreau.getNumeroc();
                if (findNumerocarreau(id) == null) {
                    throw new NonexistentEntityException("The numerocarreau with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Numerocarreau numerocarreau;
            try {
                numerocarreau = em.getReference(Numerocarreau.class, id);
                numerocarreau.getNumeroc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The numerocarreau with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Panel> panelCollectionOrphanCheck = numerocarreau.getPanelCollection();
            for (Panel panelCollectionOrphanCheckPanel : panelCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Numerocarreau (" + numerocarreau + ") cannot be destroyed since the Panel " + panelCollectionOrphanCheckPanel + " in its panelCollection field has a non-nullable numerocarreau field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Iris numeroiris = numerocarreau.getNumeroiris();
            if (numeroiris != null) {
                numeroiris.getNumerocarreauCollection().remove(numerocarreau);
                numeroiris = em.merge(numeroiris);
            }
            em.remove(numerocarreau);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Numerocarreau> findNumerocarreauEntities() {
        return findNumerocarreauEntities(true, -1, -1);
    }

    public List<Numerocarreau> findNumerocarreauEntities(int maxResults, int firstResult) {
        return findNumerocarreauEntities(false, maxResults, firstResult);
    }

    private List<Numerocarreau> findNumerocarreauEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Numerocarreau.class));
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

    public Numerocarreau findNumerocarreau(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Numerocarreau.class, id);
        } finally {
            em.close();
        }
    }

    public int getNumerocarreauCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Numerocarreau> rt = cq.from(Numerocarreau.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
