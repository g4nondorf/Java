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
import Entites.Etude;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Panel;
import java.util.ArrayList;
import java.util.Collection;
import Entites.Sessions;
import Entites.Lienetudesecteur;
import Entites.Secteur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class EtudeJpaController implements Serializable {

    public EtudeJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Etude etude) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (etude.getPanelCollection() == null) {
            etude.setPanelCollection(new ArrayList<Panel>());
        }
        if (etude.getSessionsCollection() == null) {
            etude.setSessionsCollection(new ArrayList<Sessions>());
        }
        if (etude.getLienetudesecteurCollection() == null) {
            etude.setLienetudesecteurCollection(new ArrayList<Lienetudesecteur>());
        }
        if (etude.getSecteurCollection() == null) {
            etude.setSecteurCollection(new ArrayList<Secteur>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Panel> attachedPanelCollection = new ArrayList<Panel>();
            for (Panel panelCollectionPanelToAttach : etude.getPanelCollection()) {
                panelCollectionPanelToAttach = em.getReference(panelCollectionPanelToAttach.getClass(), panelCollectionPanelToAttach.getPanelPK());
                attachedPanelCollection.add(panelCollectionPanelToAttach);
            }
            etude.setPanelCollection(attachedPanelCollection);
            Collection<Sessions> attachedSessionsCollection = new ArrayList<Sessions>();
            for (Sessions sessionsCollectionSessionsToAttach : etude.getSessionsCollection()) {
                sessionsCollectionSessionsToAttach = em.getReference(sessionsCollectionSessionsToAttach.getClass(), sessionsCollectionSessionsToAttach.getNumerosession());
                attachedSessionsCollection.add(sessionsCollectionSessionsToAttach);
            }
            etude.setSessionsCollection(attachedSessionsCollection);
            Collection<Lienetudesecteur> attachedLienetudesecteurCollection = new ArrayList<Lienetudesecteur>();
            for (Lienetudesecteur lienetudesecteurCollectionLienetudesecteurToAttach : etude.getLienetudesecteurCollection()) {
                lienetudesecteurCollectionLienetudesecteurToAttach = em.getReference(lienetudesecteurCollectionLienetudesecteurToAttach.getClass(), lienetudesecteurCollectionLienetudesecteurToAttach.getLienetudesecteurPK());
                attachedLienetudesecteurCollection.add(lienetudesecteurCollectionLienetudesecteurToAttach);
            }
            etude.setLienetudesecteurCollection(attachedLienetudesecteurCollection);
            Collection<Secteur> attachedSecteurCollection = new ArrayList<Secteur>();
            for (Secteur secteurCollectionSecteurToAttach : etude.getSecteurCollection()) {
                secteurCollectionSecteurToAttach = em.getReference(secteurCollectionSecteurToAttach.getClass(), secteurCollectionSecteurToAttach.getNumerosecteur());
                attachedSecteurCollection.add(secteurCollectionSecteurToAttach);
            }
            etude.setSecteurCollection(attachedSecteurCollection);
            em.persist(etude);
            for (Panel panelCollectionPanel : etude.getPanelCollection()) {
                panelCollectionPanel.getEtudeCollection().add(etude);
                panelCollectionPanel = em.merge(panelCollectionPanel);
            }
            for (Sessions sessionsCollectionSessions : etude.getSessionsCollection()) {
                Etude oldNumeroetudeOfSessionsCollectionSessions = sessionsCollectionSessions.getNumeroetude();
                sessionsCollectionSessions.setNumeroetude(etude);
                sessionsCollectionSessions = em.merge(sessionsCollectionSessions);
                if (oldNumeroetudeOfSessionsCollectionSessions != null) {
                    oldNumeroetudeOfSessionsCollectionSessions.getSessionsCollection().remove(sessionsCollectionSessions);
                    oldNumeroetudeOfSessionsCollectionSessions = em.merge(oldNumeroetudeOfSessionsCollectionSessions);
                }
            }
            for (Lienetudesecteur lienetudesecteurCollectionLienetudesecteur : etude.getLienetudesecteurCollection()) {
                Etude oldEtudeOfLienetudesecteurCollectionLienetudesecteur = lienetudesecteurCollectionLienetudesecteur.getEtude();
                lienetudesecteurCollectionLienetudesecteur.setEtude(etude);
                lienetudesecteurCollectionLienetudesecteur = em.merge(lienetudesecteurCollectionLienetudesecteur);
                if (oldEtudeOfLienetudesecteurCollectionLienetudesecteur != null) {
                    oldEtudeOfLienetudesecteurCollectionLienetudesecteur.getLienetudesecteurCollection().remove(lienetudesecteurCollectionLienetudesecteur);
                    oldEtudeOfLienetudesecteurCollectionLienetudesecteur = em.merge(oldEtudeOfLienetudesecteurCollectionLienetudesecteur);
                }
            }
            for (Secteur secteurCollectionSecteur : etude.getSecteurCollection()) {
                Etude oldNumeroetudeOfSecteurCollectionSecteur = secteurCollectionSecteur.getNumeroetude();
                secteurCollectionSecteur.setNumeroetude(etude);
                secteurCollectionSecteur = em.merge(secteurCollectionSecteur);
                if (oldNumeroetudeOfSecteurCollectionSecteur != null) {
                    oldNumeroetudeOfSecteurCollectionSecteur.getSecteurCollection().remove(secteurCollectionSecteur);
                    oldNumeroetudeOfSecteurCollectionSecteur = em.merge(oldNumeroetudeOfSecteurCollectionSecteur);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEtude(etude.getNumeroetude()) != null) {
                throw new PreexistingEntityException("Etude " + etude + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Etude etude) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Etude persistentEtude = em.find(Etude.class, etude.getNumeroetude());
            Collection<Panel> panelCollectionOld = persistentEtude.getPanelCollection();
            Collection<Panel> panelCollectionNew = etude.getPanelCollection();
            Collection<Sessions> sessionsCollectionOld = persistentEtude.getSessionsCollection();
            Collection<Sessions> sessionsCollectionNew = etude.getSessionsCollection();
            Collection<Lienetudesecteur> lienetudesecteurCollectionOld = persistentEtude.getLienetudesecteurCollection();
            Collection<Lienetudesecteur> lienetudesecteurCollectionNew = etude.getLienetudesecteurCollection();
            Collection<Secteur> secteurCollectionOld = persistentEtude.getSecteurCollection();
            Collection<Secteur> secteurCollectionNew = etude.getSecteurCollection();
            List<String> illegalOrphanMessages = null;
            for (Sessions sessionsCollectionOldSessions : sessionsCollectionOld) {
                if (!sessionsCollectionNew.contains(sessionsCollectionOldSessions)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Sessions " + sessionsCollectionOldSessions + " since its numeroetude field is not nullable.");
                }
            }
            for (Lienetudesecteur lienetudesecteurCollectionOldLienetudesecteur : lienetudesecteurCollectionOld) {
                if (!lienetudesecteurCollectionNew.contains(lienetudesecteurCollectionOldLienetudesecteur)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lienetudesecteur " + lienetudesecteurCollectionOldLienetudesecteur + " since its etude field is not nullable.");
                }
            }
            for (Secteur secteurCollectionOldSecteur : secteurCollectionOld) {
                if (!secteurCollectionNew.contains(secteurCollectionOldSecteur)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Secteur " + secteurCollectionOldSecteur + " since its numeroetude field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Panel> attachedPanelCollectionNew = new ArrayList<Panel>();
            for (Panel panelCollectionNewPanelToAttach : panelCollectionNew) {
                panelCollectionNewPanelToAttach = em.getReference(panelCollectionNewPanelToAttach.getClass(), panelCollectionNewPanelToAttach.getPanelPK());
                attachedPanelCollectionNew.add(panelCollectionNewPanelToAttach);
            }
            panelCollectionNew = attachedPanelCollectionNew;
            etude.setPanelCollection(panelCollectionNew);
            Collection<Sessions> attachedSessionsCollectionNew = new ArrayList<Sessions>();
            for (Sessions sessionsCollectionNewSessionsToAttach : sessionsCollectionNew) {
                sessionsCollectionNewSessionsToAttach = em.getReference(sessionsCollectionNewSessionsToAttach.getClass(), sessionsCollectionNewSessionsToAttach.getNumerosession());
                attachedSessionsCollectionNew.add(sessionsCollectionNewSessionsToAttach);
            }
            sessionsCollectionNew = attachedSessionsCollectionNew;
            etude.setSessionsCollection(sessionsCollectionNew);
            Collection<Lienetudesecteur> attachedLienetudesecteurCollectionNew = new ArrayList<Lienetudesecteur>();
            for (Lienetudesecteur lienetudesecteurCollectionNewLienetudesecteurToAttach : lienetudesecteurCollectionNew) {
                lienetudesecteurCollectionNewLienetudesecteurToAttach = em.getReference(lienetudesecteurCollectionNewLienetudesecteurToAttach.getClass(), lienetudesecteurCollectionNewLienetudesecteurToAttach.getLienetudesecteurPK());
                attachedLienetudesecteurCollectionNew.add(lienetudesecteurCollectionNewLienetudesecteurToAttach);
            }
            lienetudesecteurCollectionNew = attachedLienetudesecteurCollectionNew;
            etude.setLienetudesecteurCollection(lienetudesecteurCollectionNew);
            Collection<Secteur> attachedSecteurCollectionNew = new ArrayList<Secteur>();
            for (Secteur secteurCollectionNewSecteurToAttach : secteurCollectionNew) {
                secteurCollectionNewSecteurToAttach = em.getReference(secteurCollectionNewSecteurToAttach.getClass(), secteurCollectionNewSecteurToAttach.getNumerosecteur());
                attachedSecteurCollectionNew.add(secteurCollectionNewSecteurToAttach);
            }
            secteurCollectionNew = attachedSecteurCollectionNew;
            etude.setSecteurCollection(secteurCollectionNew);
            etude = em.merge(etude);
            for (Panel panelCollectionOldPanel : panelCollectionOld) {
                if (!panelCollectionNew.contains(panelCollectionOldPanel)) {
                    panelCollectionOldPanel.getEtudeCollection().remove(etude);
                    panelCollectionOldPanel = em.merge(panelCollectionOldPanel);
                }
            }
            for (Panel panelCollectionNewPanel : panelCollectionNew) {
                if (!panelCollectionOld.contains(panelCollectionNewPanel)) {
                    panelCollectionNewPanel.getEtudeCollection().add(etude);
                    panelCollectionNewPanel = em.merge(panelCollectionNewPanel);
                }
            }
            for (Sessions sessionsCollectionNewSessions : sessionsCollectionNew) {
                if (!sessionsCollectionOld.contains(sessionsCollectionNewSessions)) {
                    Etude oldNumeroetudeOfSessionsCollectionNewSessions = sessionsCollectionNewSessions.getNumeroetude();
                    sessionsCollectionNewSessions.setNumeroetude(etude);
                    sessionsCollectionNewSessions = em.merge(sessionsCollectionNewSessions);
                    if (oldNumeroetudeOfSessionsCollectionNewSessions != null && !oldNumeroetudeOfSessionsCollectionNewSessions.equals(etude)) {
                        oldNumeroetudeOfSessionsCollectionNewSessions.getSessionsCollection().remove(sessionsCollectionNewSessions);
                        oldNumeroetudeOfSessionsCollectionNewSessions = em.merge(oldNumeroetudeOfSessionsCollectionNewSessions);
                    }
                }
            }
            for (Lienetudesecteur lienetudesecteurCollectionNewLienetudesecteur : lienetudesecteurCollectionNew) {
                if (!lienetudesecteurCollectionOld.contains(lienetudesecteurCollectionNewLienetudesecteur)) {
                    Etude oldEtudeOfLienetudesecteurCollectionNewLienetudesecteur = lienetudesecteurCollectionNewLienetudesecteur.getEtude();
                    lienetudesecteurCollectionNewLienetudesecteur.setEtude(etude);
                    lienetudesecteurCollectionNewLienetudesecteur = em.merge(lienetudesecteurCollectionNewLienetudesecteur);
                    if (oldEtudeOfLienetudesecteurCollectionNewLienetudesecteur != null && !oldEtudeOfLienetudesecteurCollectionNewLienetudesecteur.equals(etude)) {
                        oldEtudeOfLienetudesecteurCollectionNewLienetudesecteur.getLienetudesecteurCollection().remove(lienetudesecteurCollectionNewLienetudesecteur);
                        oldEtudeOfLienetudesecteurCollectionNewLienetudesecteur = em.merge(oldEtudeOfLienetudesecteurCollectionNewLienetudesecteur);
                    }
                }
            }
            for (Secteur secteurCollectionNewSecteur : secteurCollectionNew) {
                if (!secteurCollectionOld.contains(secteurCollectionNewSecteur)) {
                    Etude oldNumeroetudeOfSecteurCollectionNewSecteur = secteurCollectionNewSecteur.getNumeroetude();
                    secteurCollectionNewSecteur.setNumeroetude(etude);
                    secteurCollectionNewSecteur = em.merge(secteurCollectionNewSecteur);
                    if (oldNumeroetudeOfSecteurCollectionNewSecteur != null && !oldNumeroetudeOfSecteurCollectionNewSecteur.equals(etude)) {
                        oldNumeroetudeOfSecteurCollectionNewSecteur.getSecteurCollection().remove(secteurCollectionNewSecteur);
                        oldNumeroetudeOfSecteurCollectionNewSecteur = em.merge(oldNumeroetudeOfSecteurCollectionNewSecteur);
                    }
                }
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
                Integer id = etude.getNumeroetude();
                if (findEtude(id) == null) {
                    throw new NonexistentEntityException("The etude with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Etude etude;
            try {
                etude = em.getReference(Etude.class, id);
                etude.getNumeroetude();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The etude with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Sessions> sessionsCollectionOrphanCheck = etude.getSessionsCollection();
            for (Sessions sessionsCollectionOrphanCheckSessions : sessionsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Etude (" + etude + ") cannot be destroyed since the Sessions " + sessionsCollectionOrphanCheckSessions + " in its sessionsCollection field has a non-nullable numeroetude field.");
            }
            Collection<Lienetudesecteur> lienetudesecteurCollectionOrphanCheck = etude.getLienetudesecteurCollection();
            for (Lienetudesecteur lienetudesecteurCollectionOrphanCheckLienetudesecteur : lienetudesecteurCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Etude (" + etude + ") cannot be destroyed since the Lienetudesecteur " + lienetudesecteurCollectionOrphanCheckLienetudesecteur + " in its lienetudesecteurCollection field has a non-nullable etude field.");
            }
            Collection<Secteur> secteurCollectionOrphanCheck = etude.getSecteurCollection();
            for (Secteur secteurCollectionOrphanCheckSecteur : secteurCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Etude (" + etude + ") cannot be destroyed since the Secteur " + secteurCollectionOrphanCheckSecteur + " in its secteurCollection field has a non-nullable numeroetude field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Panel> panelCollection = etude.getPanelCollection();
            for (Panel panelCollectionPanel : panelCollection) {
                panelCollectionPanel.getEtudeCollection().remove(etude);
                panelCollectionPanel = em.merge(panelCollectionPanel);
            }
            em.remove(etude);
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

    public List<Etude> findEtudeEntities() {
        return findEtudeEntities(true, -1, -1);
    }

    public List<Etude> findEtudeEntities(int maxResults, int firstResult) {
        return findEtudeEntities(false, maxResults, firstResult);
    }

    private List<Etude> findEtudeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Etude.class));
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

    public Etude findEtude(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Etude.class, id);
        } finally {
            em.close();
        }
    }

    public int getEtudeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Etude> rt = cq.from(Etude.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
