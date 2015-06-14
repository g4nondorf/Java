/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import Entites.Menage;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entites.Sessions;
import Entites.Panel;
import Entites.VoitureTourisme;
import java.util.ArrayList;
import java.util.Collection;
import Entites.Velo;
import Entites.Moto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moi
 */
public class MenageJpaController implements Serializable {

    public MenageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Menage menage) throws PreexistingEntityException, Exception {
        if (menage.getVoitureTourismeCollection() == null) {
            menage.setVoitureTourismeCollection(new ArrayList<VoitureTourisme>());
        }
        if (menage.getVeloCollection() == null) {
            menage.setVeloCollection(new ArrayList<Velo>());
        }
        if (menage.getMotoCollection() == null) {
            menage.setMotoCollection(new ArrayList<Moto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sessions numerosession = menage.getNumerosession();
            if (numerosession != null) {
                numerosession = em.getReference(numerosession.getClass(), numerosession.getNumerosession());
                menage.setNumerosession(numerosession);
            }
            Panel panel = menage.getPanel();
            if (panel != null) {
                panel = em.getReference(panel.getClass(), panel.getPanelPK());
                menage.setPanel(panel);
            }
            Collection<VoitureTourisme> attachedVoitureTourismeCollection = new ArrayList<VoitureTourisme>();
            for (VoitureTourisme voitureTourismeCollectionVoitureTourismeToAttach : menage.getVoitureTourismeCollection()) {
                voitureTourismeCollectionVoitureTourismeToAttach = em.getReference(voitureTourismeCollectionVoitureTourismeToAttach.getClass(), voitureTourismeCollectionVoitureTourismeToAttach.getVoitureTourismePK());
                attachedVoitureTourismeCollection.add(voitureTourismeCollectionVoitureTourismeToAttach);
            }
            menage.setVoitureTourismeCollection(attachedVoitureTourismeCollection);
            Collection<Velo> attachedVeloCollection = new ArrayList<Velo>();
            for (Velo veloCollectionVeloToAttach : menage.getVeloCollection()) {
                veloCollectionVeloToAttach = em.getReference(veloCollectionVeloToAttach.getClass(), veloCollectionVeloToAttach.getVeloPK());
                attachedVeloCollection.add(veloCollectionVeloToAttach);
            }
            menage.setVeloCollection(attachedVeloCollection);
            Collection<Moto> attachedMotoCollection = new ArrayList<Moto>();
            for (Moto motoCollectionMotoToAttach : menage.getMotoCollection()) {
                motoCollectionMotoToAttach = em.getReference(motoCollectionMotoToAttach.getClass(), motoCollectionMotoToAttach.getMotoPK());
                attachedMotoCollection.add(motoCollectionMotoToAttach);
            }
            menage.setMotoCollection(attachedMotoCollection);
            em.persist(menage);
            if (numerosession != null) {
                numerosession.getMenageCollection().add(menage);
                numerosession = em.merge(numerosession);
            }
            if (panel != null) {
                panel.getMenageCollection().add(menage);
                panel = em.merge(panel);
            }
            for (VoitureTourisme voitureTourismeCollectionVoitureTourisme : menage.getVoitureTourismeCollection()) {
                Menage oldMenageOfVoitureTourismeCollectionVoitureTourisme = voitureTourismeCollectionVoitureTourisme.getMenage();
                voitureTourismeCollectionVoitureTourisme.setMenage(menage);
                voitureTourismeCollectionVoitureTourisme = em.merge(voitureTourismeCollectionVoitureTourisme);
                if (oldMenageOfVoitureTourismeCollectionVoitureTourisme != null) {
                    oldMenageOfVoitureTourismeCollectionVoitureTourisme.getVoitureTourismeCollection().remove(voitureTourismeCollectionVoitureTourisme);
                    oldMenageOfVoitureTourismeCollectionVoitureTourisme = em.merge(oldMenageOfVoitureTourismeCollectionVoitureTourisme);
                }
            }
            for (Velo veloCollectionVelo : menage.getVeloCollection()) {
                Menage oldMenageOfVeloCollectionVelo = veloCollectionVelo.getMenage();
                veloCollectionVelo.setMenage(menage);
                veloCollectionVelo = em.merge(veloCollectionVelo);
                if (oldMenageOfVeloCollectionVelo != null) {
                    oldMenageOfVeloCollectionVelo.getVeloCollection().remove(veloCollectionVelo);
                    oldMenageOfVeloCollectionVelo = em.merge(oldMenageOfVeloCollectionVelo);
                }
            }
            for (Moto motoCollectionMoto : menage.getMotoCollection()) {
                Menage oldMenageOfMotoCollectionMoto = motoCollectionMoto.getMenage();
                motoCollectionMoto.setMenage(menage);
                motoCollectionMoto = em.merge(motoCollectionMoto);
                if (oldMenageOfMotoCollectionMoto != null) {
                    oldMenageOfMotoCollectionMoto.getMotoCollection().remove(motoCollectionMoto);
                    oldMenageOfMotoCollectionMoto = em.merge(oldMenageOfMotoCollectionMoto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMenage(menage.getNumeromenage()) != null) {
                throw new PreexistingEntityException("Menage " + menage + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menage menage) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menage persistentMenage = em.find(Menage.class, menage.getNumeromenage());
            Sessions numerosessionOld = persistentMenage.getNumerosession();
            Sessions numerosessionNew = menage.getNumerosession();
            Panel panelOld = persistentMenage.getPanel();
            Panel panelNew = menage.getPanel();
            Collection<VoitureTourisme> voitureTourismeCollectionOld = persistentMenage.getVoitureTourismeCollection();
            Collection<VoitureTourisme> voitureTourismeCollectionNew = menage.getVoitureTourismeCollection();
            Collection<Velo> veloCollectionOld = persistentMenage.getVeloCollection();
            Collection<Velo> veloCollectionNew = menage.getVeloCollection();
            Collection<Moto> motoCollectionOld = persistentMenage.getMotoCollection();
            Collection<Moto> motoCollectionNew = menage.getMotoCollection();
            List<String> illegalOrphanMessages = null;
            for (VoitureTourisme voitureTourismeCollectionOldVoitureTourisme : voitureTourismeCollectionOld) {
                if (!voitureTourismeCollectionNew.contains(voitureTourismeCollectionOldVoitureTourisme)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain VoitureTourisme " + voitureTourismeCollectionOldVoitureTourisme + " since its menage field is not nullable.");
                }
            }
            for (Velo veloCollectionOldVelo : veloCollectionOld) {
                if (!veloCollectionNew.contains(veloCollectionOldVelo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Velo " + veloCollectionOldVelo + " since its menage field is not nullable.");
                }
            }
            for (Moto motoCollectionOldMoto : motoCollectionOld) {
                if (!motoCollectionNew.contains(motoCollectionOldMoto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moto " + motoCollectionOldMoto + " since its menage field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (numerosessionNew != null) {
                numerosessionNew = em.getReference(numerosessionNew.getClass(), numerosessionNew.getNumerosession());
                menage.setNumerosession(numerosessionNew);
            }
            if (panelNew != null) {
                panelNew = em.getReference(panelNew.getClass(), panelNew.getPanelPK());
                menage.setPanel(panelNew);
            }
            Collection<VoitureTourisme> attachedVoitureTourismeCollectionNew = new ArrayList<VoitureTourisme>();
            for (VoitureTourisme voitureTourismeCollectionNewVoitureTourismeToAttach : voitureTourismeCollectionNew) {
                voitureTourismeCollectionNewVoitureTourismeToAttach = em.getReference(voitureTourismeCollectionNewVoitureTourismeToAttach.getClass(), voitureTourismeCollectionNewVoitureTourismeToAttach.getVoitureTourismePK());
                attachedVoitureTourismeCollectionNew.add(voitureTourismeCollectionNewVoitureTourismeToAttach);
            }
            voitureTourismeCollectionNew = attachedVoitureTourismeCollectionNew;
            menage.setVoitureTourismeCollection(voitureTourismeCollectionNew);
            Collection<Velo> attachedVeloCollectionNew = new ArrayList<Velo>();
            for (Velo veloCollectionNewVeloToAttach : veloCollectionNew) {
                veloCollectionNewVeloToAttach = em.getReference(veloCollectionNewVeloToAttach.getClass(), veloCollectionNewVeloToAttach.getVeloPK());
                attachedVeloCollectionNew.add(veloCollectionNewVeloToAttach);
            }
            veloCollectionNew = attachedVeloCollectionNew;
            menage.setVeloCollection(veloCollectionNew);
            Collection<Moto> attachedMotoCollectionNew = new ArrayList<Moto>();
            for (Moto motoCollectionNewMotoToAttach : motoCollectionNew) {
                motoCollectionNewMotoToAttach = em.getReference(motoCollectionNewMotoToAttach.getClass(), motoCollectionNewMotoToAttach.getMotoPK());
                attachedMotoCollectionNew.add(motoCollectionNewMotoToAttach);
            }
            motoCollectionNew = attachedMotoCollectionNew;
            menage.setMotoCollection(motoCollectionNew);
            menage = em.merge(menage);
            if (numerosessionOld != null && !numerosessionOld.equals(numerosessionNew)) {
                numerosessionOld.getMenageCollection().remove(menage);
                numerosessionOld = em.merge(numerosessionOld);
            }
            if (numerosessionNew != null && !numerosessionNew.equals(numerosessionOld)) {
                numerosessionNew.getMenageCollection().add(menage);
                numerosessionNew = em.merge(numerosessionNew);
            }
            if (panelOld != null && !panelOld.equals(panelNew)) {
                panelOld.getMenageCollection().remove(menage);
                panelOld = em.merge(panelOld);
            }
            if (panelNew != null && !panelNew.equals(panelOld)) {
                panelNew.getMenageCollection().add(menage);
                panelNew = em.merge(panelNew);
            }
            for (VoitureTourisme voitureTourismeCollectionNewVoitureTourisme : voitureTourismeCollectionNew) {
                if (!voitureTourismeCollectionOld.contains(voitureTourismeCollectionNewVoitureTourisme)) {
                    Menage oldMenageOfVoitureTourismeCollectionNewVoitureTourisme = voitureTourismeCollectionNewVoitureTourisme.getMenage();
                    voitureTourismeCollectionNewVoitureTourisme.setMenage(menage);
                    voitureTourismeCollectionNewVoitureTourisme = em.merge(voitureTourismeCollectionNewVoitureTourisme);
                    if (oldMenageOfVoitureTourismeCollectionNewVoitureTourisme != null && !oldMenageOfVoitureTourismeCollectionNewVoitureTourisme.equals(menage)) {
                        oldMenageOfVoitureTourismeCollectionNewVoitureTourisme.getVoitureTourismeCollection().remove(voitureTourismeCollectionNewVoitureTourisme);
                        oldMenageOfVoitureTourismeCollectionNewVoitureTourisme = em.merge(oldMenageOfVoitureTourismeCollectionNewVoitureTourisme);
                    }
                }
            }
            for (Velo veloCollectionNewVelo : veloCollectionNew) {
                if (!veloCollectionOld.contains(veloCollectionNewVelo)) {
                    Menage oldMenageOfVeloCollectionNewVelo = veloCollectionNewVelo.getMenage();
                    veloCollectionNewVelo.setMenage(menage);
                    veloCollectionNewVelo = em.merge(veloCollectionNewVelo);
                    if (oldMenageOfVeloCollectionNewVelo != null && !oldMenageOfVeloCollectionNewVelo.equals(menage)) {
                        oldMenageOfVeloCollectionNewVelo.getVeloCollection().remove(veloCollectionNewVelo);
                        oldMenageOfVeloCollectionNewVelo = em.merge(oldMenageOfVeloCollectionNewVelo);
                    }
                }
            }
            for (Moto motoCollectionNewMoto : motoCollectionNew) {
                if (!motoCollectionOld.contains(motoCollectionNewMoto)) {
                    Menage oldMenageOfMotoCollectionNewMoto = motoCollectionNewMoto.getMenage();
                    motoCollectionNewMoto.setMenage(menage);
                    motoCollectionNewMoto = em.merge(motoCollectionNewMoto);
                    if (oldMenageOfMotoCollectionNewMoto != null && !oldMenageOfMotoCollectionNewMoto.equals(menage)) {
                        oldMenageOfMotoCollectionNewMoto.getMotoCollection().remove(motoCollectionNewMoto);
                        oldMenageOfMotoCollectionNewMoto = em.merge(oldMenageOfMotoCollectionNewMoto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = menage.getNumeromenage();
                if (findMenage(id) == null) {
                    throw new NonexistentEntityException("The menage with id " + id + " no longer exists.");
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
            Menage menage;
            try {
                menage = em.getReference(Menage.class, id);
                menage.getNumeromenage();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menage with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<VoitureTourisme> voitureTourismeCollectionOrphanCheck = menage.getVoitureTourismeCollection();
            for (VoitureTourisme voitureTourismeCollectionOrphanCheckVoitureTourisme : voitureTourismeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Menage (" + menage + ") cannot be destroyed since the VoitureTourisme " + voitureTourismeCollectionOrphanCheckVoitureTourisme + " in its voitureTourismeCollection field has a non-nullable menage field.");
            }
            Collection<Velo> veloCollectionOrphanCheck = menage.getVeloCollection();
            for (Velo veloCollectionOrphanCheckVelo : veloCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Menage (" + menage + ") cannot be destroyed since the Velo " + veloCollectionOrphanCheckVelo + " in its veloCollection field has a non-nullable menage field.");
            }
            Collection<Moto> motoCollectionOrphanCheck = menage.getMotoCollection();
            for (Moto motoCollectionOrphanCheckMoto : motoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Menage (" + menage + ") cannot be destroyed since the Moto " + motoCollectionOrphanCheckMoto + " in its motoCollection field has a non-nullable menage field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Sessions numerosession = menage.getNumerosession();
            if (numerosession != null) {
                numerosession.getMenageCollection().remove(menage);
                numerosession = em.merge(numerosession);
            }
            Panel panel = menage.getPanel();
            if (panel != null) {
                panel.getMenageCollection().remove(menage);
                panel = em.merge(panel);
            }
            em.remove(menage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menage> findMenageEntities() {
        return findMenageEntities(true, -1, -1);
    }

    public List<Menage> findMenageEntities(int maxResults, int firstResult) {
        return findMenageEntities(false, maxResults, firstResult);
    }

    private List<Menage> findMenageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menage.class));
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

    public Menage findMenage(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menage.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menage> rt = cq.from(Menage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
