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
import Entites.Iris;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Lienetudesecteur;
import java.util.ArrayList;
import java.util.Collection;
import Entites.Numerocarreau;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class IrisJpaController implements Serializable {

    public IrisJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Iris iris) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (iris.getLienetudesecteurCollection() == null) {
            iris.setLienetudesecteurCollection(new ArrayList<Lienetudesecteur>());
        }
        if (iris.getNumerocarreauCollection() == null) {
            iris.setNumerocarreauCollection(new ArrayList<Numerocarreau>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Lienetudesecteur> attachedLienetudesecteurCollection = new ArrayList<Lienetudesecteur>();
            for (Lienetudesecteur lienetudesecteurCollectionLienetudesecteurToAttach : iris.getLienetudesecteurCollection()) {
                lienetudesecteurCollectionLienetudesecteurToAttach = em.getReference(lienetudesecteurCollectionLienetudesecteurToAttach.getClass(), lienetudesecteurCollectionLienetudesecteurToAttach.getLienetudesecteurPK());
                attachedLienetudesecteurCollection.add(lienetudesecteurCollectionLienetudesecteurToAttach);
            }
            iris.setLienetudesecteurCollection(attachedLienetudesecteurCollection);
            Collection<Numerocarreau> attachedNumerocarreauCollection = new ArrayList<Numerocarreau>();
            for (Numerocarreau numerocarreauCollectionNumerocarreauToAttach : iris.getNumerocarreauCollection()) {
                numerocarreauCollectionNumerocarreauToAttach = em.getReference(numerocarreauCollectionNumerocarreauToAttach.getClass(), numerocarreauCollectionNumerocarreauToAttach.getNumeroc());
                attachedNumerocarreauCollection.add(numerocarreauCollectionNumerocarreauToAttach);
            }
            iris.setNumerocarreauCollection(attachedNumerocarreauCollection);
            em.persist(iris);
            for (Lienetudesecteur lienetudesecteurCollectionLienetudesecteur : iris.getLienetudesecteurCollection()) {
                Iris oldIrisOfLienetudesecteurCollectionLienetudesecteur = lienetudesecteurCollectionLienetudesecteur.getIris();
                lienetudesecteurCollectionLienetudesecteur.setIris(iris);
                lienetudesecteurCollectionLienetudesecteur = em.merge(lienetudesecteurCollectionLienetudesecteur);
                if (oldIrisOfLienetudesecteurCollectionLienetudesecteur != null) {
                    oldIrisOfLienetudesecteurCollectionLienetudesecteur.getLienetudesecteurCollection().remove(lienetudesecteurCollectionLienetudesecteur);
                    oldIrisOfLienetudesecteurCollectionLienetudesecteur = em.merge(oldIrisOfLienetudesecteurCollectionLienetudesecteur);
                }
            }
            for (Numerocarreau numerocarreauCollectionNumerocarreau : iris.getNumerocarreauCollection()) {
                Iris oldNumeroirisOfNumerocarreauCollectionNumerocarreau = numerocarreauCollectionNumerocarreau.getNumeroiris();
                numerocarreauCollectionNumerocarreau.setNumeroiris(iris);
                numerocarreauCollectionNumerocarreau = em.merge(numerocarreauCollectionNumerocarreau);
                if (oldNumeroirisOfNumerocarreauCollectionNumerocarreau != null) {
                    oldNumeroirisOfNumerocarreauCollectionNumerocarreau.getNumerocarreauCollection().remove(numerocarreauCollectionNumerocarreau);
                    oldNumeroirisOfNumerocarreauCollectionNumerocarreau = em.merge(oldNumeroirisOfNumerocarreauCollectionNumerocarreau);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findIris(iris.getNumeroiris()) != null) {
                throw new PreexistingEntityException("Iris " + iris + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Iris iris) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Iris persistentIris = em.find(Iris.class, iris.getNumeroiris());
            Collection<Lienetudesecteur> lienetudesecteurCollectionOld = persistentIris.getLienetudesecteurCollection();
            Collection<Lienetudesecteur> lienetudesecteurCollectionNew = iris.getLienetudesecteurCollection();
            Collection<Numerocarreau> numerocarreauCollectionOld = persistentIris.getNumerocarreauCollection();
            Collection<Numerocarreau> numerocarreauCollectionNew = iris.getNumerocarreauCollection();
            List<String> illegalOrphanMessages = null;
            for (Lienetudesecteur lienetudesecteurCollectionOldLienetudesecteur : lienetudesecteurCollectionOld) {
                if (!lienetudesecteurCollectionNew.contains(lienetudesecteurCollectionOldLienetudesecteur)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lienetudesecteur " + lienetudesecteurCollectionOldLienetudesecteur + " since its iris field is not nullable.");
                }
            }
            for (Numerocarreau numerocarreauCollectionOldNumerocarreau : numerocarreauCollectionOld) {
                if (!numerocarreauCollectionNew.contains(numerocarreauCollectionOldNumerocarreau)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Numerocarreau " + numerocarreauCollectionOldNumerocarreau + " since its numeroiris field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Lienetudesecteur> attachedLienetudesecteurCollectionNew = new ArrayList<Lienetudesecteur>();
            for (Lienetudesecteur lienetudesecteurCollectionNewLienetudesecteurToAttach : lienetudesecteurCollectionNew) {
                lienetudesecteurCollectionNewLienetudesecteurToAttach = em.getReference(lienetudesecteurCollectionNewLienetudesecteurToAttach.getClass(), lienetudesecteurCollectionNewLienetudesecteurToAttach.getLienetudesecteurPK());
                attachedLienetudesecteurCollectionNew.add(lienetudesecteurCollectionNewLienetudesecteurToAttach);
            }
            lienetudesecteurCollectionNew = attachedLienetudesecteurCollectionNew;
            iris.setLienetudesecteurCollection(lienetudesecteurCollectionNew);
            Collection<Numerocarreau> attachedNumerocarreauCollectionNew = new ArrayList<Numerocarreau>();
            for (Numerocarreau numerocarreauCollectionNewNumerocarreauToAttach : numerocarreauCollectionNew) {
                numerocarreauCollectionNewNumerocarreauToAttach = em.getReference(numerocarreauCollectionNewNumerocarreauToAttach.getClass(), numerocarreauCollectionNewNumerocarreauToAttach.getNumeroc());
                attachedNumerocarreauCollectionNew.add(numerocarreauCollectionNewNumerocarreauToAttach);
            }
            numerocarreauCollectionNew = attachedNumerocarreauCollectionNew;
            iris.setNumerocarreauCollection(numerocarreauCollectionNew);
            iris = em.merge(iris);
            for (Lienetudesecteur lienetudesecteurCollectionNewLienetudesecteur : lienetudesecteurCollectionNew) {
                if (!lienetudesecteurCollectionOld.contains(lienetudesecteurCollectionNewLienetudesecteur)) {
                    Iris oldIrisOfLienetudesecteurCollectionNewLienetudesecteur = lienetudesecteurCollectionNewLienetudesecteur.getIris();
                    lienetudesecteurCollectionNewLienetudesecteur.setIris(iris);
                    lienetudesecteurCollectionNewLienetudesecteur = em.merge(lienetudesecteurCollectionNewLienetudesecteur);
                    if (oldIrisOfLienetudesecteurCollectionNewLienetudesecteur != null && !oldIrisOfLienetudesecteurCollectionNewLienetudesecteur.equals(iris)) {
                        oldIrisOfLienetudesecteurCollectionNewLienetudesecteur.getLienetudesecteurCollection().remove(lienetudesecteurCollectionNewLienetudesecteur);
                        oldIrisOfLienetudesecteurCollectionNewLienetudesecteur = em.merge(oldIrisOfLienetudesecteurCollectionNewLienetudesecteur);
                    }
                }
            }
            for (Numerocarreau numerocarreauCollectionNewNumerocarreau : numerocarreauCollectionNew) {
                if (!numerocarreauCollectionOld.contains(numerocarreauCollectionNewNumerocarreau)) {
                    Iris oldNumeroirisOfNumerocarreauCollectionNewNumerocarreau = numerocarreauCollectionNewNumerocarreau.getNumeroiris();
                    numerocarreauCollectionNewNumerocarreau.setNumeroiris(iris);
                    numerocarreauCollectionNewNumerocarreau = em.merge(numerocarreauCollectionNewNumerocarreau);
                    if (oldNumeroirisOfNumerocarreauCollectionNewNumerocarreau != null && !oldNumeroirisOfNumerocarreauCollectionNewNumerocarreau.equals(iris)) {
                        oldNumeroirisOfNumerocarreauCollectionNewNumerocarreau.getNumerocarreauCollection().remove(numerocarreauCollectionNewNumerocarreau);
                        oldNumeroirisOfNumerocarreauCollectionNewNumerocarreau = em.merge(oldNumeroirisOfNumerocarreauCollectionNewNumerocarreau);
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
                String id = iris.getNumeroiris();
                if (findIris(id) == null) {
                    throw new NonexistentEntityException("The iris with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Iris iris;
            try {
                iris = em.getReference(Iris.class, id);
                iris.getNumeroiris();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The iris with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Lienetudesecteur> lienetudesecteurCollectionOrphanCheck = iris.getLienetudesecteurCollection();
            for (Lienetudesecteur lienetudesecteurCollectionOrphanCheckLienetudesecteur : lienetudesecteurCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Iris (" + iris + ") cannot be destroyed since the Lienetudesecteur " + lienetudesecteurCollectionOrphanCheckLienetudesecteur + " in its lienetudesecteurCollection field has a non-nullable iris field.");
            }
            Collection<Numerocarreau> numerocarreauCollectionOrphanCheck = iris.getNumerocarreauCollection();
            for (Numerocarreau numerocarreauCollectionOrphanCheckNumerocarreau : numerocarreauCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Iris (" + iris + ") cannot be destroyed since the Numerocarreau " + numerocarreauCollectionOrphanCheckNumerocarreau + " in its numerocarreauCollection field has a non-nullable numeroiris field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(iris);
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

    public List<Iris> findIrisEntities() {
        return findIrisEntities(true, -1, -1);
    }

    public List<Iris> findIrisEntities(int maxResults, int firstResult) {
        return findIrisEntities(false, maxResults, firstResult);
    }

    private List<Iris> findIrisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Iris.class));
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

    public Iris findIris(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Iris.class, id);
        } finally {
            em.close();
        }
    }

    public int getIrisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Iris> rt = cq.from(Iris.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
