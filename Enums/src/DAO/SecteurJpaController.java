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
import Entites.Etude;
import Entites.Lienetudesecteur;
import Entites.Secteur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moi
 */
public class SecteurJpaController implements Serializable {

    public SecteurJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Secteur secteur) throws PreexistingEntityException, Exception {
        if (secteur.getLienetudesecteurCollection() == null) {
            secteur.setLienetudesecteurCollection(new ArrayList<Lienetudesecteur>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Etude numeroetude = secteur.getNumeroetude();
            if (numeroetude != null) {
                numeroetude = em.getReference(numeroetude.getClass(), numeroetude.getNumeroetude());
                secteur.setNumeroetude(numeroetude);
            }
            Collection<Lienetudesecteur> attachedLienetudesecteurCollection = new ArrayList<Lienetudesecteur>();
            for (Lienetudesecteur lienetudesecteurCollectionLienetudesecteurToAttach : secteur.getLienetudesecteurCollection()) {
                lienetudesecteurCollectionLienetudesecteurToAttach = em.getReference(lienetudesecteurCollectionLienetudesecteurToAttach.getClass(), lienetudesecteurCollectionLienetudesecteurToAttach.getLienetudesecteurPK());
                attachedLienetudesecteurCollection.add(lienetudesecteurCollectionLienetudesecteurToAttach);
            }
            secteur.setLienetudesecteurCollection(attachedLienetudesecteurCollection);
            em.persist(secteur);
            if (numeroetude != null) {
                numeroetude.getSecteurCollection().add(secteur);
                numeroetude = em.merge(numeroetude);
            }
            for (Lienetudesecteur lienetudesecteurCollectionLienetudesecteur : secteur.getLienetudesecteurCollection()) {
                Secteur oldSecteurOfLienetudesecteurCollectionLienetudesecteur = lienetudesecteurCollectionLienetudesecteur.getSecteur();
                lienetudesecteurCollectionLienetudesecteur.setSecteur(secteur);
                lienetudesecteurCollectionLienetudesecteur = em.merge(lienetudesecteurCollectionLienetudesecteur);
                if (oldSecteurOfLienetudesecteurCollectionLienetudesecteur != null) {
                    oldSecteurOfLienetudesecteurCollectionLienetudesecteur.getLienetudesecteurCollection().remove(lienetudesecteurCollectionLienetudesecteur);
                    oldSecteurOfLienetudesecteurCollectionLienetudesecteur = em.merge(oldSecteurOfLienetudesecteurCollectionLienetudesecteur);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSecteur(secteur.getNumerosecteur()) != null) {
                throw new PreexistingEntityException("Secteur " + secteur + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Secteur secteur) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Secteur persistentSecteur = em.find(Secteur.class, secteur.getNumerosecteur());
            Etude numeroetudeOld = persistentSecteur.getNumeroetude();
            Etude numeroetudeNew = secteur.getNumeroetude();
            Collection<Lienetudesecteur> lienetudesecteurCollectionOld = persistentSecteur.getLienetudesecteurCollection();
            Collection<Lienetudesecteur> lienetudesecteurCollectionNew = secteur.getLienetudesecteurCollection();
            List<String> illegalOrphanMessages = null;
            for (Lienetudesecteur lienetudesecteurCollectionOldLienetudesecteur : lienetudesecteurCollectionOld) {
                if (!lienetudesecteurCollectionNew.contains(lienetudesecteurCollectionOldLienetudesecteur)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lienetudesecteur " + lienetudesecteurCollectionOldLienetudesecteur + " since its secteur field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (numeroetudeNew != null) {
                numeroetudeNew = em.getReference(numeroetudeNew.getClass(), numeroetudeNew.getNumeroetude());
                secteur.setNumeroetude(numeroetudeNew);
            }
            Collection<Lienetudesecteur> attachedLienetudesecteurCollectionNew = new ArrayList<Lienetudesecteur>();
            for (Lienetudesecteur lienetudesecteurCollectionNewLienetudesecteurToAttach : lienetudesecteurCollectionNew) {
                lienetudesecteurCollectionNewLienetudesecteurToAttach = em.getReference(lienetudesecteurCollectionNewLienetudesecteurToAttach.getClass(), lienetudesecteurCollectionNewLienetudesecteurToAttach.getLienetudesecteurPK());
                attachedLienetudesecteurCollectionNew.add(lienetudesecteurCollectionNewLienetudesecteurToAttach);
            }
            lienetudesecteurCollectionNew = attachedLienetudesecteurCollectionNew;
            secteur.setLienetudesecteurCollection(lienetudesecteurCollectionNew);
            secteur = em.merge(secteur);
            if (numeroetudeOld != null && !numeroetudeOld.equals(numeroetudeNew)) {
                numeroetudeOld.getSecteurCollection().remove(secteur);
                numeroetudeOld = em.merge(numeroetudeOld);
            }
            if (numeroetudeNew != null && !numeroetudeNew.equals(numeroetudeOld)) {
                numeroetudeNew.getSecteurCollection().add(secteur);
                numeroetudeNew = em.merge(numeroetudeNew);
            }
            for (Lienetudesecteur lienetudesecteurCollectionNewLienetudesecteur : lienetudesecteurCollectionNew) {
                if (!lienetudesecteurCollectionOld.contains(lienetudesecteurCollectionNewLienetudesecteur)) {
                    Secteur oldSecteurOfLienetudesecteurCollectionNewLienetudesecteur = lienetudesecteurCollectionNewLienetudesecteur.getSecteur();
                    lienetudesecteurCollectionNewLienetudesecteur.setSecteur(secteur);
                    lienetudesecteurCollectionNewLienetudesecteur = em.merge(lienetudesecteurCollectionNewLienetudesecteur);
                    if (oldSecteurOfLienetudesecteurCollectionNewLienetudesecteur != null && !oldSecteurOfLienetudesecteurCollectionNewLienetudesecteur.equals(secteur)) {
                        oldSecteurOfLienetudesecteurCollectionNewLienetudesecteur.getLienetudesecteurCollection().remove(lienetudesecteurCollectionNewLienetudesecteur);
                        oldSecteurOfLienetudesecteurCollectionNewLienetudesecteur = em.merge(oldSecteurOfLienetudesecteurCollectionNewLienetudesecteur);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = secteur.getNumerosecteur();
                if (findSecteur(id) == null) {
                    throw new NonexistentEntityException("The secteur with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Secteur secteur;
            try {
                secteur = em.getReference(Secteur.class, id);
                secteur.getNumerosecteur();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The secteur with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Lienetudesecteur> lienetudesecteurCollectionOrphanCheck = secteur.getLienetudesecteurCollection();
            for (Lienetudesecteur lienetudesecteurCollectionOrphanCheckLienetudesecteur : lienetudesecteurCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Secteur (" + secteur + ") cannot be destroyed since the Lienetudesecteur " + lienetudesecteurCollectionOrphanCheckLienetudesecteur + " in its lienetudesecteurCollection field has a non-nullable secteur field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Etude numeroetude = secteur.getNumeroetude();
            if (numeroetude != null) {
                numeroetude.getSecteurCollection().remove(secteur);
                numeroetude = em.merge(numeroetude);
            }
            em.remove(secteur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Secteur> findSecteurEntities() {
        return findSecteurEntities(true, -1, -1);
    }

    public List<Secteur> findSecteurEntities(int maxResults, int firstResult) {
        return findSecteurEntities(false, maxResults, firstResult);
    }

    private List<Secteur> findSecteurEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Secteur.class));
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

    public Secteur findSecteur(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Secteur.class, id);
        } finally {
            em.close();
        }
    }

    public int getSecteurCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Secteur> rt = cq.from(Secteur.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
