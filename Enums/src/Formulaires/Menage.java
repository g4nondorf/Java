/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.Habitat;
import enums.PossessionHabitat;
import enums.TypeAbonnementTelephoneFixe;

/**
 *
 * @author Moi
 */
public class Menage {
    private final String libelleTelephoneFixe = "Avez-vous le téléphone fixe au domicile ? ";
    private final String libelleTypeAbonnementTelephone = "Si oui, êtes-vous ?";
    private final String libelleInternet = "Avez-vous une connexion Internet ?";
    private final String libelleHabitat = "Type d’habitat dans lequel est intégré le logement";
    private final String libellePossessionHabitat = "Le ménage est-il ? ";
    private final String libelleCarreau = "Pouvez-vous selectionner votre lieu d'habitat sur la carte";
    private int numeroM;
    private boolean telephoneFixe;
    private TypeAbonnementTelephoneFixe AboTelephone;
    private boolean internet;
    private Habitat habitat;
    private PossessionHabitat possessionHabitat;
    private Carreau carreau;

    public Menage(int numeroM, boolean telephoneFixe, TypeAbonnementTelephoneFixe AboTelephone, boolean internet, Habitat habitat, PossessionHabitat possessionHabitat, Carreau lieu) {
        this.numeroM = numeroM;
        this.telephoneFixe = telephoneFixe;
        this.AboTelephone = AboTelephone;
        this.internet = internet;
        this.habitat = habitat;
        this.possessionHabitat = possessionHabitat;
        this.carreau = lieu;
    }

    public String getLibelleTelephoneFixe() {
        return libelleTelephoneFixe;
    }

    public String getLibelleTypeAbonnementTelephone() {
        return libelleTypeAbonnementTelephone;
    }

    public String getLibelleInternet() {
        return libelleInternet;
    }

    public String getLibelleHabitat() {
        return libelleHabitat;
    }

    public String getLibellePossessionHabitat() {
        return libellePossessionHabitat;
    }

    public String getLibelleLieu() {
        return libelleCarreau;
    }

    public int getNumeroM() {
        return numeroM;
    }

    public boolean isTelephoneFixe() {
        return telephoneFixe;
    }

    public TypeAbonnementTelephoneFixe getAboTelephone() {
        return AboTelephone;
    }

    public boolean isInternet() {
        return internet;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public PossessionHabitat getPossessionHabitat() {
        return possessionHabitat;
    }

    public Carreau getLieu() {
        return carreau;
    }
}
