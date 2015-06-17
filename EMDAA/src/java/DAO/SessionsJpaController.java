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
import Entites.Panel;
import Entites.Etude;
import Entites.VoitureTourisme;
import java.util.ArrayList;
import java.util.Collection;
import Entites.Personne;
import Entites.Menage;
import Entites.Velo;
import Entites.Occupationprincipale;
import Entites.Activite;
import Entites.Moto;
import Entites.HabitudesUtilisationMode;
import Entites.Sessions;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class SessionsJpaController implements Serializable {

    public SessionsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sessions sessions) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (sessions.getVoitureTourismeCollection() == null) {
            sessions.setVoitureTourismeCollection(new ArrayList<VoitureTourisme>());
        }
        if (sessions.getPersonneCollection() == null) {
            sessions.setPersonneCollection(new ArrayList<Personne>());
        }
        if (sessions.getMenageCollection() == null) {
            sessions.setMenageCollection(new ArrayList<Menage>());
        }
        if (sessions.getVeloCollection() == null) {
            sessions.setVeloCollection(new ArrayList<Velo>());
        }
        if (sessions.getOccupationprincipaleCollection() == null) {
            sessions.setOccupationprincipaleCollection(new ArrayList<Occupationprincipale>());
        }
        if (sessions.getActiviteCollection() == null) {
            sessions.setActiviteCollection(new ArrayList<Activite>());
        }
        if (sessions.getMotoCollection() == null) {
            sessions.setMotoCollection(new ArrayList<Moto>());
        }
        if (sessions.getHabitudesUtilisationModeCollection() == null) {
            sessions.setHabitudesUtilisationModeCollection(new ArrayList<HabitudesUtilisationMode>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Panel panel = sessions.getPanel();
            if (panel != null) {
                panel = em.getReference(panel.getClass(), panel.getPanelPK());
                sessions.setPanel(panel);
            }
            Etude numeroetude = sessions.getNumeroetude();
            if (numeroetude != null) {
                numeroetude = em.getReference(numeroetude.getClass(), numeroetude.getNumeroetude());
                sessions.setNumeroetude(numeroetude);
            }
            Collection<VoitureTourisme> attachedVoitureTourismeCollection = new ArrayList<VoitureTourisme>();
            for (VoitureTourisme voitureTourismeCollectionVoitureTourismeToAttach : sessions.getVoitureTourismeCollection()) {
                voitureTourismeCollectionVoitureTourismeToAttach = em.getReference(voitureTourismeCollectionVoitureTourismeToAttach.getClass(), voitureTourismeCollectionVoitureTourismeToAttach.getVoitureTourismePK());
                attachedVoitureTourismeCollection.add(voitureTourismeCollectionVoitureTourismeToAttach);
            }
            sessions.setVoitureTourismeCollection(attachedVoitureTourismeCollection);
            Collection<Personne> attachedPersonneCollection = new ArrayList<Personne>();
            for (Personne personneCollectionPersonneToAttach : sessions.getPersonneCollection()) {
                personneCollectionPersonneToAttach = em.getReference(personneCollectionPersonneToAttach.getClass(), personneCollectionPersonneToAttach.getPersonnePK());
                attachedPersonneCollection.add(personneCollectionPersonneToAttach);
            }
            sessions.setPersonneCollection(attachedPersonneCollection);
            Collection<Menage> attachedMenageCollection = new ArrayList<Menage>();
            for (Menage menageCollectionMenageToAttach : sessions.getMenageCollection()) {
                menageCollectionMenageToAttach = em.getReference(menageCollectionMenageToAttach.getClass(), menageCollectionMenageToAttach.getNumeromenage());
                attachedMenageCollection.add(menageCollectionMenageToAttach);
            }
            sessions.setMenageCollection(attachedMenageCollection);
            Collection<Velo> attachedVeloCollection = new ArrayList<Velo>();
            for (Velo veloCollectionVeloToAttach : sessions.getVeloCollection()) {
                veloCollectionVeloToAttach = em.getReference(veloCollectionVeloToAttach.getClass(), veloCollectionVeloToAttach.getVeloPK());
                attachedVeloCollection.add(veloCollectionVeloToAttach);
            }
            sessions.setVeloCollection(attachedVeloCollection);
            Collection<Occupationprincipale> attachedOccupationprincipaleCollection = new ArrayList<Occupationprincipale>();
            for (Occupationprincipale occupationprincipaleCollectionOccupationprincipaleToAttach : sessions.getOccupationprincipaleCollection()) {
                occupationprincipaleCollectionOccupationprincipaleToAttach = em.getReference(occupationprincipaleCollectionOccupationprincipaleToAttach.getClass(), occupationprincipaleCollectionOccupationprincipaleToAttach.getOccupationprincipalePK());
                attachedOccupationprincipaleCollection.add(occupationprincipaleCollectionOccupationprincipaleToAttach);
            }
            sessions.setOccupationprincipaleCollection(attachedOccupationprincipaleCollection);
            Collection<Activite> attachedActiviteCollection = new ArrayList<Activite>();
            for (Activite activiteCollectionActiviteToAttach : sessions.getActiviteCollection()) {
                activiteCollectionActiviteToAttach = em.getReference(activiteCollectionActiviteToAttach.getClass(), activiteCollectionActiviteToAttach.getActivitePK());
                attachedActiviteCollection.add(activiteCollectionActiviteToAttach);
            }
            sessions.setActiviteCollection(attachedActiviteCollection);
            Collection<Moto> attachedMotoCollection = new ArrayList<Moto>();
            for (Moto motoCollectionMotoToAttach : sessions.getMotoCollection()) {
                motoCollectionMotoToAttach = em.getReference(motoCollectionMotoToAttach.getClass(), motoCollectionMotoToAttach.getMotoPK());
                attachedMotoCollection.add(motoCollectionMotoToAttach);
            }
            sessions.setMotoCollection(attachedMotoCollection);
            Collection<HabitudesUtilisationMode> attachedHabitudesUtilisationModeCollection = new ArrayList<HabitudesUtilisationMode>();
            for (HabitudesUtilisationMode habitudesUtilisationModeCollectionHabitudesUtilisationModeToAttach : sessions.getHabitudesUtilisationModeCollection()) {
                habitudesUtilisationModeCollectionHabitudesUtilisationModeToAttach = em.getReference(habitudesUtilisationModeCollectionHabitudesUtilisationModeToAttach.getClass(), habitudesUtilisationModeCollectionHabitudesUtilisationModeToAttach.getHabitudesUtilisationModePK());
                attachedHabitudesUtilisationModeCollection.add(habitudesUtilisationModeCollectionHabitudesUtilisationModeToAttach);
            }
            sessions.setHabitudesUtilisationModeCollection(attachedHabitudesUtilisationModeCollection);
            em.persist(sessions);
            if (panel != null) {
                panel.getSessionsCollection().add(sessions);
                panel = em.merge(panel);
            }
            if (numeroetude != null) {
                numeroetude.getSessionsCollection().add(sessions);
                numeroetude = em.merge(numeroetude);
            }
            for (VoitureTourisme voitureTourismeCollectionVoitureTourisme : sessions.getVoitureTourismeCollection()) {
                Sessions oldNumerosessionOfVoitureTourismeCollectionVoitureTourisme = voitureTourismeCollectionVoitureTourisme.getNumerosession();
                voitureTourismeCollectionVoitureTourisme.setNumerosession(sessions);
                voitureTourismeCollectionVoitureTourisme = em.merge(voitureTourismeCollectionVoitureTourisme);
                if (oldNumerosessionOfVoitureTourismeCollectionVoitureTourisme != null) {
                    oldNumerosessionOfVoitureTourismeCollectionVoitureTourisme.getVoitureTourismeCollection().remove(voitureTourismeCollectionVoitureTourisme);
                    oldNumerosessionOfVoitureTourismeCollectionVoitureTourisme = em.merge(oldNumerosessionOfVoitureTourismeCollectionVoitureTourisme);
                }
            }
            for (Personne personneCollectionPersonne : sessions.getPersonneCollection()) {
                Sessions oldNumerosessionOfPersonneCollectionPersonne = personneCollectionPersonne.getNumerosession();
                personneCollectionPersonne.setNumerosession(sessions);
                personneCollectionPersonne = em.merge(personneCollectionPersonne);
                if (oldNumerosessionOfPersonneCollectionPersonne != null) {
                    oldNumerosessionOfPersonneCollectionPersonne.getPersonneCollection().remove(personneCollectionPersonne);
                    oldNumerosessionOfPersonneCollectionPersonne = em.merge(oldNumerosessionOfPersonneCollectionPersonne);
                }
            }
            for (Menage menageCollectionMenage : sessions.getMenageCollection()) {
                Sessions oldNumerosessionOfMenageCollectionMenage = menageCollectionMenage.getNumerosession();
                menageCollectionMenage.setNumerosession(sessions);
                menageCollectionMenage = em.merge(menageCollectionMenage);
                if (oldNumerosessionOfMenageCollectionMenage != null) {
                    oldNumerosessionOfMenageCollectionMenage.getMenageCollection().remove(menageCollectionMenage);
                    oldNumerosessionOfMenageCollectionMenage = em.merge(oldNumerosessionOfMenageCollectionMenage);
                }
            }
            for (Velo veloCollectionVelo : sessions.getVeloCollection()) {
                Sessions oldNumerosessionOfVeloCollectionVelo = veloCollectionVelo.getNumerosession();
                veloCollectionVelo.setNumerosession(sessions);
                veloCollectionVelo = em.merge(veloCollectionVelo);
                if (oldNumerosessionOfVeloCollectionVelo != null) {
                    oldNumerosessionOfVeloCollectionVelo.getVeloCollection().remove(veloCollectionVelo);
                    oldNumerosessionOfVeloCollectionVelo = em.merge(oldNumerosessionOfVeloCollectionVelo);
                }
            }
            for (Occupationprincipale occupationprincipaleCollectionOccupationprincipale : sessions.getOccupationprincipaleCollection()) {
                Sessions oldSessionsOfOccupationprincipaleCollectionOccupationprincipale = occupationprincipaleCollectionOccupationprincipale.getSessions();
                occupationprincipaleCollectionOccupationprincipale.setSessions(sessions);
                occupationprincipaleCollectionOccupationprincipale = em.merge(occupationprincipaleCollectionOccupationprincipale);
                if (oldSessionsOfOccupationprincipaleCollectionOccupationprincipale != null) {
                    oldSessionsOfOccupationprincipaleCollectionOccupationprincipale.getOccupationprincipaleCollection().remove(occupationprincipaleCollectionOccupationprincipale);
                    oldSessionsOfOccupationprincipaleCollectionOccupationprincipale = em.merge(oldSessionsOfOccupationprincipaleCollectionOccupationprincipale);
                }
            }
            for (Activite activiteCollectionActivite : sessions.getActiviteCollection()) {
                Sessions oldSessionsOfActiviteCollectionActivite = activiteCollectionActivite.getSessions();
                activiteCollectionActivite.setSessions(sessions);
                activiteCollectionActivite = em.merge(activiteCollectionActivite);
                if (oldSessionsOfActiviteCollectionActivite != null) {
                    oldSessionsOfActiviteCollectionActivite.getActiviteCollection().remove(activiteCollectionActivite);
                    oldSessionsOfActiviteCollectionActivite = em.merge(oldSessionsOfActiviteCollectionActivite);
                }
            }
            for (Moto motoCollectionMoto : sessions.getMotoCollection()) {
                Sessions oldNumerosessionOfMotoCollectionMoto = motoCollectionMoto.getNumerosession();
                motoCollectionMoto.setNumerosession(sessions);
                motoCollectionMoto = em.merge(motoCollectionMoto);
                if (oldNumerosessionOfMotoCollectionMoto != null) {
                    oldNumerosessionOfMotoCollectionMoto.getMotoCollection().remove(motoCollectionMoto);
                    oldNumerosessionOfMotoCollectionMoto = em.merge(oldNumerosessionOfMotoCollectionMoto);
                }
            }
            for (HabitudesUtilisationMode habitudesUtilisationModeCollectionHabitudesUtilisationMode : sessions.getHabitudesUtilisationModeCollection()) {
                Sessions oldNumerosessionOfHabitudesUtilisationModeCollectionHabitudesUtilisationMode = habitudesUtilisationModeCollectionHabitudesUtilisationMode.getNumerosession();
                habitudesUtilisationModeCollectionHabitudesUtilisationMode.setNumerosession(sessions);
                habitudesUtilisationModeCollectionHabitudesUtilisationMode = em.merge(habitudesUtilisationModeCollectionHabitudesUtilisationMode);
                if (oldNumerosessionOfHabitudesUtilisationModeCollectionHabitudesUtilisationMode != null) {
                    oldNumerosessionOfHabitudesUtilisationModeCollectionHabitudesUtilisationMode.getHabitudesUtilisationModeCollection().remove(habitudesUtilisationModeCollectionHabitudesUtilisationMode);
                    oldNumerosessionOfHabitudesUtilisationModeCollectionHabitudesUtilisationMode = em.merge(oldNumerosessionOfHabitudesUtilisationModeCollectionHabitudesUtilisationMode);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findSessions(sessions.getNumerosession()) != null) {
                throw new PreexistingEntityException("Sessions " + sessions + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sessions sessions) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Sessions persistentSessions = em.find(Sessions.class, sessions.getNumerosession());
            Panel panelOld = persistentSessions.getPanel();
            Panel panelNew = sessions.getPanel();
            Etude numeroetudeOld = persistentSessions.getNumeroetude();
            Etude numeroetudeNew = sessions.getNumeroetude();
            Collection<VoitureTourisme> voitureTourismeCollectionOld = persistentSessions.getVoitureTourismeCollection();
            Collection<VoitureTourisme> voitureTourismeCollectionNew = sessions.getVoitureTourismeCollection();
            Collection<Personne> personneCollectionOld = persistentSessions.getPersonneCollection();
            Collection<Personne> personneCollectionNew = sessions.getPersonneCollection();
            Collection<Menage> menageCollectionOld = persistentSessions.getMenageCollection();
            Collection<Menage> menageCollectionNew = sessions.getMenageCollection();
            Collection<Velo> veloCollectionOld = persistentSessions.getVeloCollection();
            Collection<Velo> veloCollectionNew = sessions.getVeloCollection();
            Collection<Occupationprincipale> occupationprincipaleCollectionOld = persistentSessions.getOccupationprincipaleCollection();
            Collection<Occupationprincipale> occupationprincipaleCollectionNew = sessions.getOccupationprincipaleCollection();
            Collection<Activite> activiteCollectionOld = persistentSessions.getActiviteCollection();
            Collection<Activite> activiteCollectionNew = sessions.getActiviteCollection();
            Collection<Moto> motoCollectionOld = persistentSessions.getMotoCollection();
            Collection<Moto> motoCollectionNew = sessions.getMotoCollection();
            Collection<HabitudesUtilisationMode> habitudesUtilisationModeCollectionOld = persistentSessions.getHabitudesUtilisationModeCollection();
            Collection<HabitudesUtilisationMode> habitudesUtilisationModeCollectionNew = sessions.getHabitudesUtilisationModeCollection();
            List<String> illegalOrphanMessages = null;
            for (VoitureTourisme voitureTourismeCollectionOldVoitureTourisme : voitureTourismeCollectionOld) {
                if (!voitureTourismeCollectionNew.contains(voitureTourismeCollectionOldVoitureTourisme)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain VoitureTourisme " + voitureTourismeCollectionOldVoitureTourisme + " since its numerosession field is not nullable.");
                }
            }
            for (Personne personneCollectionOldPersonne : personneCollectionOld) {
                if (!personneCollectionNew.contains(personneCollectionOldPersonne)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Personne " + personneCollectionOldPersonne + " since its numerosession field is not nullable.");
                }
            }
            for (Menage menageCollectionOldMenage : menageCollectionOld) {
                if (!menageCollectionNew.contains(menageCollectionOldMenage)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Menage " + menageCollectionOldMenage + " since its numerosession field is not nullable.");
                }
            }
            for (Velo veloCollectionOldVelo : veloCollectionOld) {
                if (!veloCollectionNew.contains(veloCollectionOldVelo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Velo " + veloCollectionOldVelo + " since its numerosession field is not nullable.");
                }
            }
            for (Occupationprincipale occupationprincipaleCollectionOldOccupationprincipale : occupationprincipaleCollectionOld) {
                if (!occupationprincipaleCollectionNew.contains(occupationprincipaleCollectionOldOccupationprincipale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Occupationprincipale " + occupationprincipaleCollectionOldOccupationprincipale + " since its sessions field is not nullable.");
                }
            }
            for (Activite activiteCollectionOldActivite : activiteCollectionOld) {
                if (!activiteCollectionNew.contains(activiteCollectionOldActivite)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Activite " + activiteCollectionOldActivite + " since its sessions field is not nullable.");
                }
            }
            for (Moto motoCollectionOldMoto : motoCollectionOld) {
                if (!motoCollectionNew.contains(motoCollectionOldMoto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moto " + motoCollectionOldMoto + " since its numerosession field is not nullable.");
                }
            }
            for (HabitudesUtilisationMode habitudesUtilisationModeCollectionOldHabitudesUtilisationMode : habitudesUtilisationModeCollectionOld) {
                if (!habitudesUtilisationModeCollectionNew.contains(habitudesUtilisationModeCollectionOldHabitudesUtilisationMode)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HabitudesUtilisationMode " + habitudesUtilisationModeCollectionOldHabitudesUtilisationMode + " since its numerosession field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (panelNew != null) {
                panelNew = em.getReference(panelNew.getClass(), panelNew.getPanelPK());
                sessions.setPanel(panelNew);
            }
            if (numeroetudeNew != null) {
                numeroetudeNew = em.getReference(numeroetudeNew.getClass(), numeroetudeNew.getNumeroetude());
                sessions.setNumeroetude(numeroetudeNew);
            }
            Collection<VoitureTourisme> attachedVoitureTourismeCollectionNew = new ArrayList<VoitureTourisme>();
            for (VoitureTourisme voitureTourismeCollectionNewVoitureTourismeToAttach : voitureTourismeCollectionNew) {
                voitureTourismeCollectionNewVoitureTourismeToAttach = em.getReference(voitureTourismeCollectionNewVoitureTourismeToAttach.getClass(), voitureTourismeCollectionNewVoitureTourismeToAttach.getVoitureTourismePK());
                attachedVoitureTourismeCollectionNew.add(voitureTourismeCollectionNewVoitureTourismeToAttach);
            }
            voitureTourismeCollectionNew = attachedVoitureTourismeCollectionNew;
            sessions.setVoitureTourismeCollection(voitureTourismeCollectionNew);
            Collection<Personne> attachedPersonneCollectionNew = new ArrayList<Personne>();
            for (Personne personneCollectionNewPersonneToAttach : personneCollectionNew) {
                personneCollectionNewPersonneToAttach = em.getReference(personneCollectionNewPersonneToAttach.getClass(), personneCollectionNewPersonneToAttach.getPersonnePK());
                attachedPersonneCollectionNew.add(personneCollectionNewPersonneToAttach);
            }
            personneCollectionNew = attachedPersonneCollectionNew;
            sessions.setPersonneCollection(personneCollectionNew);
            Collection<Menage> attachedMenageCollectionNew = new ArrayList<Menage>();
            for (Menage menageCollectionNewMenageToAttach : menageCollectionNew) {
                menageCollectionNewMenageToAttach = em.getReference(menageCollectionNewMenageToAttach.getClass(), menageCollectionNewMenageToAttach.getNumeromenage());
                attachedMenageCollectionNew.add(menageCollectionNewMenageToAttach);
            }
            menageCollectionNew = attachedMenageCollectionNew;
            sessions.setMenageCollection(menageCollectionNew);
            Collection<Velo> attachedVeloCollectionNew = new ArrayList<Velo>();
            for (Velo veloCollectionNewVeloToAttach : veloCollectionNew) {
                veloCollectionNewVeloToAttach = em.getReference(veloCollectionNewVeloToAttach.getClass(), veloCollectionNewVeloToAttach.getVeloPK());
                attachedVeloCollectionNew.add(veloCollectionNewVeloToAttach);
            }
            veloCollectionNew = attachedVeloCollectionNew;
            sessions.setVeloCollection(veloCollectionNew);
            Collection<Occupationprincipale> attachedOccupationprincipaleCollectionNew = new ArrayList<Occupationprincipale>();
            for (Occupationprincipale occupationprincipaleCollectionNewOccupationprincipaleToAttach : occupationprincipaleCollectionNew) {
                occupationprincipaleCollectionNewOccupationprincipaleToAttach = em.getReference(occupationprincipaleCollectionNewOccupationprincipaleToAttach.getClass(), occupationprincipaleCollectionNewOccupationprincipaleToAttach.getOccupationprincipalePK());
                attachedOccupationprincipaleCollectionNew.add(occupationprincipaleCollectionNewOccupationprincipaleToAttach);
            }
            occupationprincipaleCollectionNew = attachedOccupationprincipaleCollectionNew;
            sessions.setOccupationprincipaleCollection(occupationprincipaleCollectionNew);
            Collection<Activite> attachedActiviteCollectionNew = new ArrayList<Activite>();
            for (Activite activiteCollectionNewActiviteToAttach : activiteCollectionNew) {
                activiteCollectionNewActiviteToAttach = em.getReference(activiteCollectionNewActiviteToAttach.getClass(), activiteCollectionNewActiviteToAttach.getActivitePK());
                attachedActiviteCollectionNew.add(activiteCollectionNewActiviteToAttach);
            }
            activiteCollectionNew = attachedActiviteCollectionNew;
            sessions.setActiviteCollection(activiteCollectionNew);
            Collection<Moto> attachedMotoCollectionNew = new ArrayList<Moto>();
            for (Moto motoCollectionNewMotoToAttach : motoCollectionNew) {
                motoCollectionNewMotoToAttach = em.getReference(motoCollectionNewMotoToAttach.getClass(), motoCollectionNewMotoToAttach.getMotoPK());
                attachedMotoCollectionNew.add(motoCollectionNewMotoToAttach);
            }
            motoCollectionNew = attachedMotoCollectionNew;
            sessions.setMotoCollection(motoCollectionNew);
            Collection<HabitudesUtilisationMode> attachedHabitudesUtilisationModeCollectionNew = new ArrayList<HabitudesUtilisationMode>();
            for (HabitudesUtilisationMode habitudesUtilisationModeCollectionNewHabitudesUtilisationModeToAttach : habitudesUtilisationModeCollectionNew) {
                habitudesUtilisationModeCollectionNewHabitudesUtilisationModeToAttach = em.getReference(habitudesUtilisationModeCollectionNewHabitudesUtilisationModeToAttach.getClass(), habitudesUtilisationModeCollectionNewHabitudesUtilisationModeToAttach.getHabitudesUtilisationModePK());
                attachedHabitudesUtilisationModeCollectionNew.add(habitudesUtilisationModeCollectionNewHabitudesUtilisationModeToAttach);
            }
            habitudesUtilisationModeCollectionNew = attachedHabitudesUtilisationModeCollectionNew;
            sessions.setHabitudesUtilisationModeCollection(habitudesUtilisationModeCollectionNew);
            sessions = em.merge(sessions);
            if (panelOld != null && !panelOld.equals(panelNew)) {
                panelOld.getSessionsCollection().remove(sessions);
                panelOld = em.merge(panelOld);
            }
            if (panelNew != null && !panelNew.equals(panelOld)) {
                panelNew.getSessionsCollection().add(sessions);
                panelNew = em.merge(panelNew);
            }
            if (numeroetudeOld != null && !numeroetudeOld.equals(numeroetudeNew)) {
                numeroetudeOld.getSessionsCollection().remove(sessions);
                numeroetudeOld = em.merge(numeroetudeOld);
            }
            if (numeroetudeNew != null && !numeroetudeNew.equals(numeroetudeOld)) {
                numeroetudeNew.getSessionsCollection().add(sessions);
                numeroetudeNew = em.merge(numeroetudeNew);
            }
            for (VoitureTourisme voitureTourismeCollectionNewVoitureTourisme : voitureTourismeCollectionNew) {
                if (!voitureTourismeCollectionOld.contains(voitureTourismeCollectionNewVoitureTourisme)) {
                    Sessions oldNumerosessionOfVoitureTourismeCollectionNewVoitureTourisme = voitureTourismeCollectionNewVoitureTourisme.getNumerosession();
                    voitureTourismeCollectionNewVoitureTourisme.setNumerosession(sessions);
                    voitureTourismeCollectionNewVoitureTourisme = em.merge(voitureTourismeCollectionNewVoitureTourisme);
                    if (oldNumerosessionOfVoitureTourismeCollectionNewVoitureTourisme != null && !oldNumerosessionOfVoitureTourismeCollectionNewVoitureTourisme.equals(sessions)) {
                        oldNumerosessionOfVoitureTourismeCollectionNewVoitureTourisme.getVoitureTourismeCollection().remove(voitureTourismeCollectionNewVoitureTourisme);
                        oldNumerosessionOfVoitureTourismeCollectionNewVoitureTourisme = em.merge(oldNumerosessionOfVoitureTourismeCollectionNewVoitureTourisme);
                    }
                }
            }
            for (Personne personneCollectionNewPersonne : personneCollectionNew) {
                if (!personneCollectionOld.contains(personneCollectionNewPersonne)) {
                    Sessions oldNumerosessionOfPersonneCollectionNewPersonne = personneCollectionNewPersonne.getNumerosession();
                    personneCollectionNewPersonne.setNumerosession(sessions);
                    personneCollectionNewPersonne = em.merge(personneCollectionNewPersonne);
                    if (oldNumerosessionOfPersonneCollectionNewPersonne != null && !oldNumerosessionOfPersonneCollectionNewPersonne.equals(sessions)) {
                        oldNumerosessionOfPersonneCollectionNewPersonne.getPersonneCollection().remove(personneCollectionNewPersonne);
                        oldNumerosessionOfPersonneCollectionNewPersonne = em.merge(oldNumerosessionOfPersonneCollectionNewPersonne);
                    }
                }
            }
            for (Menage menageCollectionNewMenage : menageCollectionNew) {
                if (!menageCollectionOld.contains(menageCollectionNewMenage)) {
                    Sessions oldNumerosessionOfMenageCollectionNewMenage = menageCollectionNewMenage.getNumerosession();
                    menageCollectionNewMenage.setNumerosession(sessions);
                    menageCollectionNewMenage = em.merge(menageCollectionNewMenage);
                    if (oldNumerosessionOfMenageCollectionNewMenage != null && !oldNumerosessionOfMenageCollectionNewMenage.equals(sessions)) {
                        oldNumerosessionOfMenageCollectionNewMenage.getMenageCollection().remove(menageCollectionNewMenage);
                        oldNumerosessionOfMenageCollectionNewMenage = em.merge(oldNumerosessionOfMenageCollectionNewMenage);
                    }
                }
            }
            for (Velo veloCollectionNewVelo : veloCollectionNew) {
                if (!veloCollectionOld.contains(veloCollectionNewVelo)) {
                    Sessions oldNumerosessionOfVeloCollectionNewVelo = veloCollectionNewVelo.getNumerosession();
                    veloCollectionNewVelo.setNumerosession(sessions);
                    veloCollectionNewVelo = em.merge(veloCollectionNewVelo);
                    if (oldNumerosessionOfVeloCollectionNewVelo != null && !oldNumerosessionOfVeloCollectionNewVelo.equals(sessions)) {
                        oldNumerosessionOfVeloCollectionNewVelo.getVeloCollection().remove(veloCollectionNewVelo);
                        oldNumerosessionOfVeloCollectionNewVelo = em.merge(oldNumerosessionOfVeloCollectionNewVelo);
                    }
                }
            }
            for (Occupationprincipale occupationprincipaleCollectionNewOccupationprincipale : occupationprincipaleCollectionNew) {
                if (!occupationprincipaleCollectionOld.contains(occupationprincipaleCollectionNewOccupationprincipale)) {
                    Sessions oldSessionsOfOccupationprincipaleCollectionNewOccupationprincipale = occupationprincipaleCollectionNewOccupationprincipale.getSessions();
                    occupationprincipaleCollectionNewOccupationprincipale.setSessions(sessions);
                    occupationprincipaleCollectionNewOccupationprincipale = em.merge(occupationprincipaleCollectionNewOccupationprincipale);
                    if (oldSessionsOfOccupationprincipaleCollectionNewOccupationprincipale != null && !oldSessionsOfOccupationprincipaleCollectionNewOccupationprincipale.equals(sessions)) {
                        oldSessionsOfOccupationprincipaleCollectionNewOccupationprincipale.getOccupationprincipaleCollection().remove(occupationprincipaleCollectionNewOccupationprincipale);
                        oldSessionsOfOccupationprincipaleCollectionNewOccupationprincipale = em.merge(oldSessionsOfOccupationprincipaleCollectionNewOccupationprincipale);
                    }
                }
            }
            for (Activite activiteCollectionNewActivite : activiteCollectionNew) {
                if (!activiteCollectionOld.contains(activiteCollectionNewActivite)) {
                    Sessions oldSessionsOfActiviteCollectionNewActivite = activiteCollectionNewActivite.getSessions();
                    activiteCollectionNewActivite.setSessions(sessions);
                    activiteCollectionNewActivite = em.merge(activiteCollectionNewActivite);
                    if (oldSessionsOfActiviteCollectionNewActivite != null && !oldSessionsOfActiviteCollectionNewActivite.equals(sessions)) {
                        oldSessionsOfActiviteCollectionNewActivite.getActiviteCollection().remove(activiteCollectionNewActivite);
                        oldSessionsOfActiviteCollectionNewActivite = em.merge(oldSessionsOfActiviteCollectionNewActivite);
                    }
                }
            }
            for (Moto motoCollectionNewMoto : motoCollectionNew) {
                if (!motoCollectionOld.contains(motoCollectionNewMoto)) {
                    Sessions oldNumerosessionOfMotoCollectionNewMoto = motoCollectionNewMoto.getNumerosession();
                    motoCollectionNewMoto.setNumerosession(sessions);
                    motoCollectionNewMoto = em.merge(motoCollectionNewMoto);
                    if (oldNumerosessionOfMotoCollectionNewMoto != null && !oldNumerosessionOfMotoCollectionNewMoto.equals(sessions)) {
                        oldNumerosessionOfMotoCollectionNewMoto.getMotoCollection().remove(motoCollectionNewMoto);
                        oldNumerosessionOfMotoCollectionNewMoto = em.merge(oldNumerosessionOfMotoCollectionNewMoto);
                    }
                }
            }
            for (HabitudesUtilisationMode habitudesUtilisationModeCollectionNewHabitudesUtilisationMode : habitudesUtilisationModeCollectionNew) {
                if (!habitudesUtilisationModeCollectionOld.contains(habitudesUtilisationModeCollectionNewHabitudesUtilisationMode)) {
                    Sessions oldNumerosessionOfHabitudesUtilisationModeCollectionNewHabitudesUtilisationMode = habitudesUtilisationModeCollectionNewHabitudesUtilisationMode.getNumerosession();
                    habitudesUtilisationModeCollectionNewHabitudesUtilisationMode.setNumerosession(sessions);
                    habitudesUtilisationModeCollectionNewHabitudesUtilisationMode = em.merge(habitudesUtilisationModeCollectionNewHabitudesUtilisationMode);
                    if (oldNumerosessionOfHabitudesUtilisationModeCollectionNewHabitudesUtilisationMode != null && !oldNumerosessionOfHabitudesUtilisationModeCollectionNewHabitudesUtilisationMode.equals(sessions)) {
                        oldNumerosessionOfHabitudesUtilisationModeCollectionNewHabitudesUtilisationMode.getHabitudesUtilisationModeCollection().remove(habitudesUtilisationModeCollectionNewHabitudesUtilisationMode);
                        oldNumerosessionOfHabitudesUtilisationModeCollectionNewHabitudesUtilisationMode = em.merge(oldNumerosessionOfHabitudesUtilisationModeCollectionNewHabitudesUtilisationMode);
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
                Integer id = sessions.getNumerosession();
                if (findSessions(id) == null) {
                    throw new NonexistentEntityException("The sessions with id " + id + " no longer exists.");
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
            Sessions sessions;
            try {
                sessions = em.getReference(Sessions.class, id);
                sessions.getNumerosession();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sessions with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<VoitureTourisme> voitureTourismeCollectionOrphanCheck = sessions.getVoitureTourismeCollection();
            for (VoitureTourisme voitureTourismeCollectionOrphanCheckVoitureTourisme : voitureTourismeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the VoitureTourisme " + voitureTourismeCollectionOrphanCheckVoitureTourisme + " in its voitureTourismeCollection field has a non-nullable numerosession field.");
            }
            Collection<Personne> personneCollectionOrphanCheck = sessions.getPersonneCollection();
            for (Personne personneCollectionOrphanCheckPersonne : personneCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the Personne " + personneCollectionOrphanCheckPersonne + " in its personneCollection field has a non-nullable numerosession field.");
            }
            Collection<Menage> menageCollectionOrphanCheck = sessions.getMenageCollection();
            for (Menage menageCollectionOrphanCheckMenage : menageCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the Menage " + menageCollectionOrphanCheckMenage + " in its menageCollection field has a non-nullable numerosession field.");
            }
            Collection<Velo> veloCollectionOrphanCheck = sessions.getVeloCollection();
            for (Velo veloCollectionOrphanCheckVelo : veloCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the Velo " + veloCollectionOrphanCheckVelo + " in its veloCollection field has a non-nullable numerosession field.");
            }
            Collection<Occupationprincipale> occupationprincipaleCollectionOrphanCheck = sessions.getOccupationprincipaleCollection();
            for (Occupationprincipale occupationprincipaleCollectionOrphanCheckOccupationprincipale : occupationprincipaleCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the Occupationprincipale " + occupationprincipaleCollectionOrphanCheckOccupationprincipale + " in its occupationprincipaleCollection field has a non-nullable sessions field.");
            }
            Collection<Activite> activiteCollectionOrphanCheck = sessions.getActiviteCollection();
            for (Activite activiteCollectionOrphanCheckActivite : activiteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the Activite " + activiteCollectionOrphanCheckActivite + " in its activiteCollection field has a non-nullable sessions field.");
            }
            Collection<Moto> motoCollectionOrphanCheck = sessions.getMotoCollection();
            for (Moto motoCollectionOrphanCheckMoto : motoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the Moto " + motoCollectionOrphanCheckMoto + " in its motoCollection field has a non-nullable numerosession field.");
            }
            Collection<HabitudesUtilisationMode> habitudesUtilisationModeCollectionOrphanCheck = sessions.getHabitudesUtilisationModeCollection();
            for (HabitudesUtilisationMode habitudesUtilisationModeCollectionOrphanCheckHabitudesUtilisationMode : habitudesUtilisationModeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sessions (" + sessions + ") cannot be destroyed since the HabitudesUtilisationMode " + habitudesUtilisationModeCollectionOrphanCheckHabitudesUtilisationMode + " in its habitudesUtilisationModeCollection field has a non-nullable numerosession field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Panel panel = sessions.getPanel();
            if (panel != null) {
                panel.getSessionsCollection().remove(sessions);
                panel = em.merge(panel);
            }
            Etude numeroetude = sessions.getNumeroetude();
            if (numeroetude != null) {
                numeroetude.getSessionsCollection().remove(sessions);
                numeroetude = em.merge(numeroetude);
            }
            em.remove(sessions);
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

    public List<Sessions> findSessionsEntities() {
        return findSessionsEntities(true, -1, -1);
    }

    public List<Sessions> findSessionsEntities(int maxResults, int firstResult) {
        return findSessionsEntities(false, maxResults, firstResult);
    }

    private List<Sessions> findSessionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sessions.class));
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

    public Sessions findSessions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sessions.class, id);
        } finally {
            em.close();
        }
    }

    public int getSessionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sessions> rt = cq.from(Sessions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
