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
import Entites.Secteur;
import Entites.Iris;
import Entites.Etude;
import Entites.Lienetudesecteur;
import Entites.LienetudesecteurPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class LienetudesecteurJpaController implements Serializable {

    public LienetudesecteurJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lienetudesecteur lienetudesecteur) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (lienetudesecteur.getLienetudesecteurPK() == null) {
            lienetudesecteur.setLienetudesecteurPK(new LienetudesecteurPK());
        }
        lienetudesecteur.getLienetudesecteurPK().setNumerosecteur(lienetudesecteur.getSecteur().getNumerosecteur());
        lienetudesecteur.getLienetudesecteurPK().setNumeroetude(lienetudesecteur.getEtude().getNumeroetude());
        lienetudesecteur.getLienetudesecteurPK().setNumeroiris(lienetudesecteur.getIris().getNumeroiris());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Secteur secteur = lienetudesecteur.getSecteur();
            if (secteur != null) {
                secteur = em.getReference(secteur.getClass(), secteur.getNumerosecteur());
                lienetudesecteur.setSecteur(secteur);
            }
            Iris iris = lienetudesecteur.getIris();
            if (iris != null) {
                iris = em.getReference(iris.getClass(), iris.getNumeroiris());
                lienetudesecteur.setIris(iris);
            }
            Etude etude = lienetudesecteur.getEtude();
            if (etude != null) {
                etude = em.getReference(etude.getClass(), etude.getNumeroetude());
                lienetudesecteur.setEtude(etude);
            }
            em.persist(lienetudesecteur);
            if (secteur != null) {
                secteur.getLienetudesecteurCollection().add(lienetudesecteur);
                secteur = em.merge(secteur);
            }
            if (iris != null) {
                iris.getLienetudesecteurCollection().add(lienetudesecteur);
                iris = em.merge(iris);
            }
            if (etude != null) {
                etude.getLienetudesecteurCollection().add(lienetudesecteur);
                etude = em.merge(etude);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findLienetudesecteur(lienetudesecteur.getLienetudesecteurPK()) != null) {
                throw new PreexistingEntityException("Lienetudesecteur " + lienetudesecteur + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lienetudesecteur lienetudesecteur) throws NonexistentEntityException, RollbackFailureException, Exception {
        lienetudesecteur.getLienetudesecteurPK().setNumerosecteur(lienetudesecteur.getSecteur().getNumerosecteur());
        lienetudesecteur.getLienetudesecteurPK().setNumeroetude(lienetudesecteur.getEtude().getNumeroetude());
        lienetudesecteur.getLienetudesecteurPK().setNumeroiris(lienetudesecteur.getIris().getNumeroiris());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Lienetudesecteur persistentLienetudesecteur = em.find(Lienetudesecteur.class, lienetudesecteur.getLienetudesecteurPK());
            Secteur secteurOld = persistentLienetudesecteur.getSecteur();
            Secteur secteurNew = lienetudesecteur.getSecteur();
            Iris irisOld = persistentLienetudesecteur.getIris();
            Iris irisNew = lienetudesecteur.getIris();
            Etude etudeOld = persistentLienetudesecteur.getEtude();
            Etude etudeNew = lienetudesecteur.getEtude();
            if (secteurNew != null) {
                secteurNew = em.getReference(secteurNew.getClass(), secteurNew.getNumerosecteur());
                lienetudesecteur.setSecteur(secteurNew);
            }
            if (irisNew != null) {
                irisNew = em.getReference(irisNew.getClass(), irisNew.getNumeroiris());
                lienetudesecteur.setIris(irisNew);
            }
            if (etudeNew != null) {
                etudeNew = em.getReference(etudeNew.getClass(), etudeNew.getNumeroetude());
                lienetudesecteur.setEtude(etudeNew);
            }
            lienetudesecteur = em.merge(lienetudesecteur);
            if (secteurOld != null && !secteurOld.equals(secteurNew)) {
                secteurOld.getLienetudesecteurCollection().remove(lienetudesecteur);
                secteurOld = em.merge(secteurOld);
            }
            if (secteurNew != null && !secteurNew.equals(secteurOld)) {
                secteurNew.getLienetudesecteurCollection().add(lienetudesecteur);
                secteurNew = em.merge(secteurNew);
            }
            if (irisOld != null && !irisOld.equals(irisNew)) {
                irisOld.getLienetudesecteurCollection().remove(lienetudesecteur);
                irisOld = em.merge(irisOld);
            }
            if (irisNew != null && !irisNew.equals(irisOld)) {
                irisNew.getLienetudesecteurCollection().add(lienetudesecteur);
                irisNew = em.merge(irisNew);
            }
            if (etudeOld != null && !etudeOld.equals(etudeNew)) {
                etudeOld.getLienetudesecteurCollection().remove(lienetudesecteur);
                etudeOld = em.merge(etudeOld);
            }
            if (etudeNew != null && !etudeNew.equals(etudeOld)) {
                etudeNew.getLienetudesecteurCollection().add(lienetudesecteur);
                etudeNew = em.merge(etudeNew);
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
                LienetudesecteurPK id = lienetudesecteur.getLienetudesecteurPK();
                if (findLienetudesecteur(id) == null) {
                    throw new NonexistentEntityException("The lienetudesecteur with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(LienetudesecteurPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Lienetudesecteur lienetudesecteur;
            try {
                lienetudesecteur = em.getReference(Lienetudesecteur.class, id);
                lienetudesecteur.getLienetudesecteurPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lienetudesecteur with id " + id + " no longer exists.", enfe);
            }
            Secteur secteur = lienetudesecteur.getSecteur();
            if (secteur != null) {
                secteur.getLienetudesecteurCollection().remove(lienetudesecteur);
                secteur = em.merge(secteur);
            }
            Iris iris = lienetudesecteur.getIris();
            if (iris != null) {
                iris.getLienetudesecteurCollection().remove(lienetudesecteur);
                iris = em.merge(iris);
            }
            Etude etude = lienetudesecteur.getEtude();
            if (etude != null) {
                etude.getLienetudesecteurCollection().remove(lienetudesecteur);
                etude = em.merge(etude);
            }
            em.remove(lienetudesecteur);
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

    public List<Lienetudesecteur> findLienetudesecteurEntities() {
        return findLienetudesecteurEntities(true, -1, -1);
    }

    public List<Lienetudesecteur> findLienetudesecteurEntities(int maxResults, int firstResult) {
        return findLienetudesecteurEntities(false, maxResults, firstResult);
    }

    private List<Lienetudesecteur> findLienetudesecteurEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lienetudesecteur.class));
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

    public Lienetudesecteur findLienetudesecteur(LienetudesecteurPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lienetudesecteur.class, id);
        } finally {
            em.close();
        }
    }

    public int getLienetudesecteurCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lienetudesecteur> rt = cq.from(Lienetudesecteur.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
