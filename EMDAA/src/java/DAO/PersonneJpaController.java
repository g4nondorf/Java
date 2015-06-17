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
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Sessions;
import Entites.Panel;
import Entites.Personne;
import Entites.PersonnePK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class PersonneJpaController implements Serializable {

    public PersonneJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Personne personne) throws IllegalOrphanException, PreexistingEntityException, RollbackFailureException, Exception {
        if (personne.getPersonnePK() == null) {
            personne.setPersonnePK(new PersonnePK());
        }
        personne.getPersonnePK().setNumeropersonne(personne.getPanel().getPanelPK().getNumeropersonne());
        personne.getPersonnePK().setNumeromenage(personne.getPanel().getPanelPK().getNumeromenage());
        List<String> illegalOrphanMessages = null;
        Panel panelOrphanCheck = personne.getPanel();
        if (panelOrphanCheck != null) {
            Personne oldPersonneOfPanel = panelOrphanCheck.getPersonne();
            if (oldPersonneOfPanel != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Panel " + panelOrphanCheck + " already has an item of type Personne whose panel column cannot be null. Please make another selection for the panel field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions numerosession = personne.getNumerosession();
            if (numerosession != null) {
                numerosession = em.getReference(numerosession.getClass(), numerosession.getNumerosession());
                personne.setNumerosession(numerosession);
            }
            Panel panel = personne.getPanel();
            if (panel != null) {
                panel = em.getReference(panel.getClass(), panel.getPanelPK());
                personne.setPanel(panel);
            }
            em.persist(personne);
            if (numerosession != null) {
                numerosession.getPersonneCollection().add(personne);
                numerosession = em.merge(numerosession);
            }
            if (panel != null) {
                panel.setPersonne(personne);
                panel = em.merge(panel);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPersonne(personne.getPersonnePK()) != null) {
                throw new PreexistingEntityException("Personne " + personne + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Personne personne) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        personne.getPersonnePK().setNumeropersonne(personne.getPanel().getPanelPK().getNumeropersonne());
        personne.getPersonnePK().setNumeromenage(personne.getPanel().getPanelPK().getNumeromenage());
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Personne persistentPersonne = em.find(Personne.class, personne.getPersonnePK());
            Sessions numerosessionOld = persistentPersonne.getNumerosession();
            Sessions numerosessionNew = personne.getNumerosession();
            Panel panelOld = persistentPersonne.getPanel();
            Panel panelNew = personne.getPanel();
            List<String> illegalOrphanMessages = null;
            if (panelNew != null && !panelNew.equals(panelOld)) {
                Personne oldPersonneOfPanel = panelNew.getPersonne();
                if (oldPersonneOfPanel != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Panel " + panelNew + " already has an item of type Personne whose panel column cannot be null. Please make another selection for the panel field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (numerosessionNew != null) {
                numerosessionNew = em.getReference(numerosessionNew.getClass(), numerosessionNew.getNumerosession());
                personne.setNumerosession(numerosessionNew);
            }
            if (panelNew != null) {
                panelNew = em.getReference(panelNew.getClass(), panelNew.getPanelPK());
                personne.setPanel(panelNew);
            }
            personne = em.merge(personne);
            if (numerosessionOld != null && !numerosessionOld.equals(numerosessionNew)) {
                numerosessionOld.getPersonneCollection().remove(personne);
                numerosessionOld = em.merge(numerosessionOld);
            }
            if (numerosessionNew != null && !numerosessionNew.equals(numerosessionOld)) {
                numerosessionNew.getPersonneCollection().add(personne);
                numerosessionNew = em.merge(numerosessionNew);
            }
            if (panelOld != null && !panelOld.equals(panelNew)) {
                panelOld.setPersonne(null);
                panelOld = em.merge(panelOld);
            }
            if (panelNew != null && !panelNew.equals(panelOld)) {
                panelNew.setPersonne(personne);
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
                PersonnePK id = personne.getPersonnePK();
                if (findPersonne(id) == null) {
                    throw new NonexistentEntityException("The personne with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PersonnePK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Personne personne;
            try {
                personne = em.getReference(Personne.class, id);
                personne.getPersonnePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personne with id " + id + " no longer exists.", enfe);
            }
            Sessions numerosession = personne.getNumerosession();
            if (numerosession != null) {
                numerosession.getPersonneCollection().remove(personne);
                numerosession = em.merge(numerosession);
            }
            Panel panel = personne.getPanel();
            if (panel != null) {
                panel.setPersonne(null);
                panel = em.merge(panel);
            }
            em.remove(personne);
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

    public List<Personne> findPersonneEntities() {
        return findPersonneEntities(true, -1, -1);
    }

    public List<Personne> findPersonneEntities(int maxResults, int firstResult) {
        return findPersonneEntities(false, maxResults, firstResult);
    }

    private List<Personne> findPersonneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Personne.class));
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

    public Personne findPersonne(PersonnePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Personne.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Personne> rt = cq.from(Personne.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
