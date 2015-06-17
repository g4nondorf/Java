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
import Entites.Numerocarreau;
import Entites.Personne;
import Entites.HabitudesUtilisationMode;
import Entites.Etude;
import java.util.ArrayList;
import java.util.Collection;
import Entites.Sessions;
import Entites.Menage;
import Entites.Occupationprincipale;
import Entites.Activite;
import Entites.Panel;
import Entites.PanelPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Moi
 */
public class PanelJpaController implements Serializable {

    public PanelJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Panel panel) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (panel.getPanelPK() == null) {
            panel.setPanelPK(new PanelPK());
        }
        if (panel.getEtudeCollection() == null) {
            panel.setEtudeCollection(new ArrayList<Etude>());
        }
        if (panel.getSessionsCollection() == null) {
            panel.setSessionsCollection(new ArrayList<Sessions>());
        }
        if (panel.getMenageCollection() == null) {
            panel.setMenageCollection(new ArrayList<Menage>());
        }
        if (panel.getOccupationprincipaleCollection() == null) {
            panel.setOccupationprincipaleCollection(new ArrayList<Occupationprincipale>());
        }
        if (panel.getActiviteCollection() == null) {
            panel.setActiviteCollection(new ArrayList<Activite>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Numerocarreau numerocarreau = panel.getNumerocarreau();
            if (numerocarreau != null) {
                numerocarreau = em.getReference(numerocarreau.getClass(), numerocarreau.getNumeroc());
                panel.setNumerocarreau(numerocarreau);
            }
            Personne personne = panel.getPersonne();
            if (personne != null) {
                personne = em.getReference(personne.getClass(), personne.getPersonnePK());
                panel.setPersonne(personne);
            }
            HabitudesUtilisationMode habitudesUtilisationMode = panel.getHabitudesUtilisationMode();
            if (habitudesUtilisationMode != null) {
                habitudesUtilisationMode = em.getReference(habitudesUtilisationMode.getClass(), habitudesUtilisationMode.getHabitudesUtilisationModePK());
                panel.setHabitudesUtilisationMode(habitudesUtilisationMode);
            }
            Collection<Etude> attachedEtudeCollection = new ArrayList<Etude>();
            for (Etude etudeCollectionEtudeToAttach : panel.getEtudeCollection()) {
                etudeCollectionEtudeToAttach = em.getReference(etudeCollectionEtudeToAttach.getClass(), etudeCollectionEtudeToAttach.getNumeroetude());
                attachedEtudeCollection.add(etudeCollectionEtudeToAttach);
            }
            panel.setEtudeCollection(attachedEtudeCollection);
            Collection<Sessions> attachedSessionsCollection = new ArrayList<Sessions>();
            for (Sessions sessionsCollectionSessionsToAttach : panel.getSessionsCollection()) {
                sessionsCollectionSessionsToAttach = em.getReference(sessionsCollectionSessionsToAttach.getClass(), sessionsCollectionSessionsToAttach.getNumerosession());
                attachedSessionsCollection.add(sessionsCollectionSessionsToAttach);
            }
            panel.setSessionsCollection(attachedSessionsCollection);
            Collection<Menage> attachedMenageCollection = new ArrayList<Menage>();
            for (Menage menageCollectionMenageToAttach : panel.getMenageCollection()) {
                menageCollectionMenageToAttach = em.getReference(menageCollectionMenageToAttach.getClass(), menageCollectionMenageToAttach.getNumeromenage());
                attachedMenageCollection.add(menageCollectionMenageToAttach);
            }
            panel.setMenageCollection(attachedMenageCollection);
            Collection<Occupationprincipale> attachedOccupationprincipaleCollection = new ArrayList<Occupationprincipale>();
            for (Occupationprincipale occupationprincipaleCollectionOccupationprincipaleToAttach : panel.getOccupationprincipaleCollection()) {
                occupationprincipaleCollectionOccupationprincipaleToAttach = em.getReference(occupationprincipaleCollectionOccupationprincipaleToAttach.getClass(), occupationprincipaleCollectionOccupationprincipaleToAttach.getOccupationprincipalePK());
                attachedOccupationprincipaleCollection.add(occupationprincipaleCollectionOccupationprincipaleToAttach);
            }
            panel.setOccupationprincipaleCollection(attachedOccupationprincipaleCollection);
            Collection<Activite> attachedActiviteCollection = new ArrayList<Activite>();
            for (Activite activiteCollectionActiviteToAttach : panel.getActiviteCollection()) {
                activiteCollectionActiviteToAttach = em.getReference(activiteCollectionActiviteToAttach.getClass(), activiteCollectionActiviteToAttach.getActivitePK());
                attachedActiviteCollection.add(activiteCollectionActiviteToAttach);
            }
            panel.setActiviteCollection(attachedActiviteCollection);
            em.persist(panel);
            if (numerocarreau != null) {
                numerocarreau.getPanelCollection().add(panel);
                numerocarreau = em.merge(numerocarreau);
            }
            if (personne != null) {
                Panel oldPanelOfPersonne = personne.getPanel();
                if (oldPanelOfPersonne != null) {
                    oldPanelOfPersonne.setPersonne(null);
                    oldPanelOfPersonne = em.merge(oldPanelOfPersonne);
                }
                personne.setPanel(panel);
                personne = em.merge(personne);
            }
            if (habitudesUtilisationMode != null) {
                Panel oldPanelOfHabitudesUtilisationMode = habitudesUtilisationMode.getPanel();
                if (oldPanelOfHabitudesUtilisationMode != null) {
                    oldPanelOfHabitudesUtilisationMode.setHabitudesUtilisationMode(null);
                    oldPanelOfHabitudesUtilisationMode = em.merge(oldPanelOfHabitudesUtilisationMode);
                }
                habitudesUtilisationMode.setPanel(panel);
                habitudesUtilisationMode = em.merge(habitudesUtilisationMode);
            }
            for (Etude etudeCollectionEtude : panel.getEtudeCollection()) {
                etudeCollectionEtude.getPanelCollection().add(panel);
                etudeCollectionEtude = em.merge(etudeCollectionEtude);
            }
            for (Sessions sessionsCollectionSessions : panel.getSessionsCollection()) {
                Panel oldPanelOfSessionsCollectionSessions = sessionsCollectionSessions.getPanel();
                sessionsCollectionSessions.setPanel(panel);
                sessionsCollectionSessions = em.merge(sessionsCollectionSessions);
                if (oldPanelOfSessionsCollectionSessions != null) {
                    oldPanelOfSessionsCollectionSessions.getSessionsCollection().remove(sessionsCollectionSessions);
                    oldPanelOfSessionsCollectionSessions = em.merge(oldPanelOfSessionsCollectionSessions);
                }
            }
            for (Menage menageCollectionMenage : panel.getMenageCollection()) {
                Panel oldPanelOfMenageCollectionMenage = menageCollectionMenage.getPanel();
                menageCollectionMenage.setPanel(panel);
                menageCollectionMenage = em.merge(menageCollectionMenage);
                if (oldPanelOfMenageCollectionMenage != null) {
                    oldPanelOfMenageCollectionMenage.getMenageCollection().remove(menageCollectionMenage);
                    oldPanelOfMenageCollectionMenage = em.merge(oldPanelOfMenageCollectionMenage);
                }
            }
            for (Occupationprincipale occupationprincipaleCollectionOccupationprincipale : panel.getOccupationprincipaleCollection()) {
                Panel oldPanelOfOccupationprincipaleCollectionOccupationprincipale = occupationprincipaleCollectionOccupationprincipale.getPanel();
                occupationprincipaleCollectionOccupationprincipale.setPanel(panel);
                occupationprincipaleCollectionOccupationprincipale = em.merge(occupationprincipaleCollectionOccupationprincipale);
                if (oldPanelOfOccupationprincipaleCollectionOccupationprincipale != null) {
                    oldPanelOfOccupationprincipaleCollectionOccupationprincipale.getOccupationprincipaleCollection().remove(occupationprincipaleCollectionOccupationprincipale);
                    oldPanelOfOccupationprincipaleCollectionOccupationprincipale = em.merge(oldPanelOfOccupationprincipaleCollectionOccupationprincipale);
                }
            }
            for (Activite activiteCollectionActivite : panel.getActiviteCollection()) {
                Panel oldPanelOfActiviteCollectionActivite = activiteCollectionActivite.getPanel();
                activiteCollectionActivite.setPanel(panel);
                activiteCollectionActivite = em.merge(activiteCollectionActivite);
                if (oldPanelOfActiviteCollectionActivite != null) {
                    oldPanelOfActiviteCollectionActivite.getActiviteCollection().remove(activiteCollectionActivite);
                    oldPanelOfActiviteCollectionActivite = em.merge(oldPanelOfActiviteCollectionActivite);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPanel(panel.getPanelPK()) != null) {
                throw new PreexistingEntityException("Panel " + panel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Panel panel) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Panel persistentPanel = em.find(Panel.class, panel.getPanelPK());
            Numerocarreau numerocarreauOld = persistentPanel.getNumerocarreau();
            Numerocarreau numerocarreauNew = panel.getNumerocarreau();
            Personne personneOld = persistentPanel.getPersonne();
            Personne personneNew = panel.getPersonne();
            HabitudesUtilisationMode habitudesUtilisationModeOld = persistentPanel.getHabitudesUtilisationMode();
            HabitudesUtilisationMode habitudesUtilisationModeNew = panel.getHabitudesUtilisationMode();
            Collection<Etude> etudeCollectionOld = persistentPanel.getEtudeCollection();
            Collection<Etude> etudeCollectionNew = panel.getEtudeCollection();
            Collection<Sessions> sessionsCollectionOld = persistentPanel.getSessionsCollection();
            Collection<Sessions> sessionsCollectionNew = panel.getSessionsCollection();
            Collection<Menage> menageCollectionOld = persistentPanel.getMenageCollection();
            Collection<Menage> menageCollectionNew = panel.getMenageCollection();
            Collection<Occupationprincipale> occupationprincipaleCollectionOld = persistentPanel.getOccupationprincipaleCollection();
            Collection<Occupationprincipale> occupationprincipaleCollectionNew = panel.getOccupationprincipaleCollection();
            Collection<Activite> activiteCollectionOld = persistentPanel.getActiviteCollection();
            Collection<Activite> activiteCollectionNew = panel.getActiviteCollection();
            List<String> illegalOrphanMessages = null;
            if (personneOld != null && !personneOld.equals(personneNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Personne " + personneOld + " since its panel field is not nullable.");
            }
            if (habitudesUtilisationModeOld != null && !habitudesUtilisationModeOld.equals(habitudesUtilisationModeNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain HabitudesUtilisationMode " + habitudesUtilisationModeOld + " since its panel field is not nullable.");
            }
            for (Sessions sessionsCollectionOldSessions : sessionsCollectionOld) {
                if (!sessionsCollectionNew.contains(sessionsCollectionOldSessions)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Sessions " + sessionsCollectionOldSessions + " since its panel field is not nullable.");
                }
            }
            for (Menage menageCollectionOldMenage : menageCollectionOld) {
                if (!menageCollectionNew.contains(menageCollectionOldMenage)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Menage " + menageCollectionOldMenage + " since its panel field is not nullable.");
                }
            }
            for (Occupationprincipale occupationprincipaleCollectionOldOccupationprincipale : occupationprincipaleCollectionOld) {
                if (!occupationprincipaleCollectionNew.contains(occupationprincipaleCollectionOldOccupationprincipale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Occupationprincipale " + occupationprincipaleCollectionOldOccupationprincipale + " since its panel field is not nullable.");
                }
            }
            for (Activite activiteCollectionOldActivite : activiteCollectionOld) {
                if (!activiteCollectionNew.contains(activiteCollectionOldActivite)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Activite " + activiteCollectionOldActivite + " since its panel field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (numerocarreauNew != null) {
                numerocarreauNew = em.getReference(numerocarreauNew.getClass(), numerocarreauNew.getNumeroc());
                panel.setNumerocarreau(numerocarreauNew);
            }
            if (personneNew != null) {
                personneNew = em.getReference(personneNew.getClass(), personneNew.getPersonnePK());
                panel.setPersonne(personneNew);
            }
            if (habitudesUtilisationModeNew != null) {
                habitudesUtilisationModeNew = em.getReference(habitudesUtilisationModeNew.getClass(), habitudesUtilisationModeNew.getHabitudesUtilisationModePK());
                panel.setHabitudesUtilisationMode(habitudesUtilisationModeNew);
            }
            Collection<Etude> attachedEtudeCollectionNew = new ArrayList<Etude>();
            for (Etude etudeCollectionNewEtudeToAttach : etudeCollectionNew) {
                etudeCollectionNewEtudeToAttach = em.getReference(etudeCollectionNewEtudeToAttach.getClass(), etudeCollectionNewEtudeToAttach.getNumeroetude());
                attachedEtudeCollectionNew.add(etudeCollectionNewEtudeToAttach);
            }
            etudeCollectionNew = attachedEtudeCollectionNew;
            panel.setEtudeCollection(etudeCollectionNew);
            Collection<Sessions> attachedSessionsCollectionNew = new ArrayList<Sessions>();
            for (Sessions sessionsCollectionNewSessionsToAttach : sessionsCollectionNew) {
                sessionsCollectionNewSessionsToAttach = em.getReference(sessionsCollectionNewSessionsToAttach.getClass(), sessionsCollectionNewSessionsToAttach.getNumerosession());
                attachedSessionsCollectionNew.add(sessionsCollectionNewSessionsToAttach);
            }
            sessionsCollectionNew = attachedSessionsCollectionNew;
            panel.setSessionsCollection(sessionsCollectionNew);
            Collection<Menage> attachedMenageCollectionNew = new ArrayList<Menage>();
            for (Menage menageCollectionNewMenageToAttach : menageCollectionNew) {
                menageCollectionNewMenageToAttach = em.getReference(menageCollectionNewMenageToAttach.getClass(), menageCollectionNewMenageToAttach.getNumeromenage());
                attachedMenageCollectionNew.add(menageCollectionNewMenageToAttach);
            }
            menageCollectionNew = attachedMenageCollectionNew;
            panel.setMenageCollection(menageCollectionNew);
            Collection<Occupationprincipale> attachedOccupationprincipaleCollectionNew = new ArrayList<Occupationprincipale>();
            for (Occupationprincipale occupationprincipaleCollectionNewOccupationprincipaleToAttach : occupationprincipaleCollectionNew) {
                occupationprincipaleCollectionNewOccupationprincipaleToAttach = em.getReference(occupationprincipaleCollectionNewOccupationprincipaleToAttach.getClass(), occupationprincipaleCollectionNewOccupationprincipaleToAttach.getOccupationprincipalePK());
                attachedOccupationprincipaleCollectionNew.add(occupationprincipaleCollectionNewOccupationprincipaleToAttach);
            }
            occupationprincipaleCollectionNew = attachedOccupationprincipaleCollectionNew;
            panel.setOccupationprincipaleCollection(occupationprincipaleCollectionNew);
            Collection<Activite> attachedActiviteCollectionNew = new ArrayList<Activite>();
            for (Activite activiteCollectionNewActiviteToAttach : activiteCollectionNew) {
                activiteCollectionNewActiviteToAttach = em.getReference(activiteCollectionNewActiviteToAttach.getClass(), activiteCollectionNewActiviteToAttach.getActivitePK());
                attachedActiviteCollectionNew.add(activiteCollectionNewActiviteToAttach);
            }
            activiteCollectionNew = attachedActiviteCollectionNew;
            panel.setActiviteCollection(activiteCollectionNew);
            panel = em.merge(panel);
            if (numerocarreauOld != null && !numerocarreauOld.equals(numerocarreauNew)) {
                numerocarreauOld.getPanelCollection().remove(panel);
                numerocarreauOld = em.merge(numerocarreauOld);
            }
            if (numerocarreauNew != null && !numerocarreauNew.equals(numerocarreauOld)) {
                numerocarreauNew.getPanelCollection().add(panel);
                numerocarreauNew = em.merge(numerocarreauNew);
            }
            if (personneNew != null && !personneNew.equals(personneOld)) {
                Panel oldPanelOfPersonne = personneNew.getPanel();
                if (oldPanelOfPersonne != null) {
                    oldPanelOfPersonne.setPersonne(null);
                    oldPanelOfPersonne = em.merge(oldPanelOfPersonne);
                }
                personneNew.setPanel(panel);
                personneNew = em.merge(personneNew);
            }
            if (habitudesUtilisationModeNew != null && !habitudesUtilisationModeNew.equals(habitudesUtilisationModeOld)) {
                Panel oldPanelOfHabitudesUtilisationMode = habitudesUtilisationModeNew.getPanel();
                if (oldPanelOfHabitudesUtilisationMode != null) {
                    oldPanelOfHabitudesUtilisationMode.setHabitudesUtilisationMode(null);
                    oldPanelOfHabitudesUtilisationMode = em.merge(oldPanelOfHabitudesUtilisationMode);
                }
                habitudesUtilisationModeNew.setPanel(panel);
                habitudesUtilisationModeNew = em.merge(habitudesUtilisationModeNew);
            }
            for (Etude etudeCollectionOldEtude : etudeCollectionOld) {
                if (!etudeCollectionNew.contains(etudeCollectionOldEtude)) {
                    etudeCollectionOldEtude.getPanelCollection().remove(panel);
                    etudeCollectionOldEtude = em.merge(etudeCollectionOldEtude);
                }
            }
            for (Etude etudeCollectionNewEtude : etudeCollectionNew) {
                if (!etudeCollectionOld.contains(etudeCollectionNewEtude)) {
                    etudeCollectionNewEtude.getPanelCollection().add(panel);
                    etudeCollectionNewEtude = em.merge(etudeCollectionNewEtude);
                }
            }
            for (Sessions sessionsCollectionNewSessions : sessionsCollectionNew) {
                if (!sessionsCollectionOld.contains(sessionsCollectionNewSessions)) {
                    Panel oldPanelOfSessionsCollectionNewSessions = sessionsCollectionNewSessions.getPanel();
                    sessionsCollectionNewSessions.setPanel(panel);
                    sessionsCollectionNewSessions = em.merge(sessionsCollectionNewSessions);
                    if (oldPanelOfSessionsCollectionNewSessions != null && !oldPanelOfSessionsCollectionNewSessions.equals(panel)) {
                        oldPanelOfSessionsCollectionNewSessions.getSessionsCollection().remove(sessionsCollectionNewSessions);
                        oldPanelOfSessionsCollectionNewSessions = em.merge(oldPanelOfSessionsCollectionNewSessions);
                    }
                }
            }
            for (Menage menageCollectionNewMenage : menageCollectionNew) {
                if (!menageCollectionOld.contains(menageCollectionNewMenage)) {
                    Panel oldPanelOfMenageCollectionNewMenage = menageCollectionNewMenage.getPanel();
                    menageCollectionNewMenage.setPanel(panel);
                    menageCollectionNewMenage = em.merge(menageCollectionNewMenage);
                    if (oldPanelOfMenageCollectionNewMenage != null && !oldPanelOfMenageCollectionNewMenage.equals(panel)) {
                        oldPanelOfMenageCollectionNewMenage.getMenageCollection().remove(menageCollectionNewMenage);
                        oldPanelOfMenageCollectionNewMenage = em.merge(oldPanelOfMenageCollectionNewMenage);
                    }
                }
            }
            for (Occupationprincipale occupationprincipaleCollectionNewOccupationprincipale : occupationprincipaleCollectionNew) {
                if (!occupationprincipaleCollectionOld.contains(occupationprincipaleCollectionNewOccupationprincipale)) {
                    Panel oldPanelOfOccupationprincipaleCollectionNewOccupationprincipale = occupationprincipaleCollectionNewOccupationprincipale.getPanel();
                    occupationprincipaleCollectionNewOccupationprincipale.setPanel(panel);
                    occupationprincipaleCollectionNewOccupationprincipale = em.merge(occupationprincipaleCollectionNewOccupationprincipale);
                    if (oldPanelOfOccupationprincipaleCollectionNewOccupationprincipale != null && !oldPanelOfOccupationprincipaleCollectionNewOccupationprincipale.equals(panel)) {
                        oldPanelOfOccupationprincipaleCollectionNewOccupationprincipale.getOccupationprincipaleCollection().remove(occupationprincipaleCollectionNewOccupationprincipale);
                        oldPanelOfOccupationprincipaleCollectionNewOccupationprincipale = em.merge(oldPanelOfOccupationprincipaleCollectionNewOccupationprincipale);
                    }
                }
            }
            for (Activite activiteCollectionNewActivite : activiteCollectionNew) {
                if (!activiteCollectionOld.contains(activiteCollectionNewActivite)) {
                    Panel oldPanelOfActiviteCollectionNewActivite = activiteCollectionNewActivite.getPanel();
                    activiteCollectionNewActivite.setPanel(panel);
                    activiteCollectionNewActivite = em.merge(activiteCollectionNewActivite);
                    if (oldPanelOfActiviteCollectionNewActivite != null && !oldPanelOfActiviteCollectionNewActivite.equals(panel)) {
                        oldPanelOfActiviteCollectionNewActivite.getActiviteCollection().remove(activiteCollectionNewActivite);
                        oldPanelOfActiviteCollectionNewActivite = em.merge(oldPanelOfActiviteCollectionNewActivite);
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
                PanelPK id = panel.getPanelPK();
                if (findPanel(id) == null) {
                    throw new NonexistentEntityException("The panel with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PanelPK id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Panel panel;
            try {
                panel = em.getReference(Panel.class, id);
                panel.getPanelPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The panel with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Personne personneOrphanCheck = panel.getPersonne();
            if (personneOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Panel (" + panel + ") cannot be destroyed since the Personne " + personneOrphanCheck + " in its personne field has a non-nullable panel field.");
            }
            HabitudesUtilisationMode habitudesUtilisationModeOrphanCheck = panel.getHabitudesUtilisationMode();
            if (habitudesUtilisationModeOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Panel (" + panel + ") cannot be destroyed since the HabitudesUtilisationMode " + habitudesUtilisationModeOrphanCheck + " in its habitudesUtilisationMode field has a non-nullable panel field.");
            }
            Collection<Sessions> sessionsCollectionOrphanCheck = panel.getSessionsCollection();
            for (Sessions sessionsCollectionOrphanCheckSessions : sessionsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Panel (" + panel + ") cannot be destroyed since the Sessions " + sessionsCollectionOrphanCheckSessions + " in its sessionsCollection field has a non-nullable panel field.");
            }
            Collection<Menage> menageCollectionOrphanCheck = panel.getMenageCollection();
            for (Menage menageCollectionOrphanCheckMenage : menageCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Panel (" + panel + ") cannot be destroyed since the Menage " + menageCollectionOrphanCheckMenage + " in its menageCollection field has a non-nullable panel field.");
            }
            Collection<Occupationprincipale> occupationprincipaleCollectionOrphanCheck = panel.getOccupationprincipaleCollection();
            for (Occupationprincipale occupationprincipaleCollectionOrphanCheckOccupationprincipale : occupationprincipaleCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Panel (" + panel + ") cannot be destroyed since the Occupationprincipale " + occupationprincipaleCollectionOrphanCheckOccupationprincipale + " in its occupationprincipaleCollection field has a non-nullable panel field.");
            }
            Collection<Activite> activiteCollectionOrphanCheck = panel.getActiviteCollection();
            for (Activite activiteCollectionOrphanCheckActivite : activiteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Panel (" + panel + ") cannot be destroyed since the Activite " + activiteCollectionOrphanCheckActivite + " in its activiteCollection field has a non-nullable panel field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Numerocarreau numerocarreau = panel.getNumerocarreau();
            if (numerocarreau != null) {
                numerocarreau.getPanelCollection().remove(panel);
                numerocarreau = em.merge(numerocarreau);
            }
            Collection<Etude> etudeCollection = panel.getEtudeCollection();
            for (Etude etudeCollectionEtude : etudeCollection) {
                etudeCollectionEtude.getPanelCollection().remove(panel);
                etudeCollectionEtude = em.merge(etudeCollectionEtude);
            }
            em.remove(panel);
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

    public List<Panel> findPanelEntities() {
        return findPanelEntities(true, -1, -1);
    }

    public List<Panel> findPanelEntities(int maxResults, int firstResult) {
        return findPanelEntities(false, maxResults, firstResult);
    }

    private List<Panel> findPanelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Panel.class));
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

    public Panel findPanel(PanelPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Panel.class, id);
        } finally {
            em.close();
        }
    }

    public int getPanelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Panel> rt = cq.from(Panel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
