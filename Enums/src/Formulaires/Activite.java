/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.ModeTransport;
import enums.Stationnement;
import enums.TypeActivite;
import java.util.Date;

/**
 *
 * @author Moi
 */
public class Activite {
    private final String libelleCarreau = "Pouvez-vous selectionner sur la carte le lieu de votre déplacement";
    private final String libelleHeureArrivee = "Heure d'arrivé";
    private final String libelleHeureDepart = "Heure de depart";
    private final String libelleModeTransport = "Mode de transport utilisé";
    private final String libelleTypeActivité = "Motif de la personne (plus éventuellement celui de la personne accompagnée)";
    private final String libelleStationnement = "Lieu de stationnement";
    private final String libelleNombreDePersonne = "Nombre de personne";
    private Carreau carreau;
    private int numeroA;
    private Date heureArrivee;
    private Date heureDepart;
    private ModeTransport modeTransport;
    private TypeActivite typeActivite;
    private Stationnement stationnement;
    private int nombrePersonne;

    public Activite(Carreau carreau, int numeroA, Date heureArrivee, Date heureDepart, ModeTransport modeTransport, TypeActivite typeActivite, Stationnement stationnement, int nombrePersonne) {
        this.carreau = carreau;
        this.numeroA = numeroA;
        this.heureArrivee = heureArrivee;
        this.heureDepart = heureDepart;
        this.modeTransport = modeTransport;
        this.typeActivite = typeActivite;
        this.stationnement = stationnement;
        this.nombrePersonne = nombrePersonne;
    }

    public String getLibelleCarreau() {
        return libelleCarreau;
    }

    public String getLibelleHeureArrivee() {
        return libelleHeureArrivee;
    }

    public String getLibelleHeureDepart() {
        return libelleHeureDepart;
    }

    public String getLibelleModeTransport() {
        return libelleModeTransport;
    }

    public String getLibelleTypeActivité() {
        return libelleTypeActivité;
    }

    public String getLibelleStationnement() {
        return libelleStationnement;
    }

    public String getLibelleNombreDePersonne() {
        return libelleNombreDePersonne;
    }

    public Carreau getCarreau() {
        return carreau;
    }

    public int getNumeroA() {
        return numeroA;
    }

    public Date getHeureArrivee() {
        return heureArrivee;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public ModeTransport getModeTransport() {
        return modeTransport;
    }

    public TypeActivite getTypeActivite() {
        return typeActivite;
    }

    public Stationnement getStationnement() {
        return stationnement;
    }

    public int getNombrePersonne() {
        return nombrePersonne;
    }
}
