/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.Frequence;

/**
 *
 * @author Moi
 */
public class HabitudeUtilisationMode {
    private final String libelleApied = "Frequence de déplacements marche à pied";
    private final String libelleBicycletteConducteur = "Frequence de déplacements velo";
    private final String libelleMoto = "Frequence de déplacements moto";
    private final String libelleVoiturePersonnelleConducteur = "Frequence de déplacements VP (véhicules particuliers conducteur)";
    private final String libelleVoiturePersonnellePassager = "Frequence de déplacements VP (véhicules particuliers passager)";
    private final String libelleEnsembleDuReseauUrbain = "Frequence de déplacements réseaux urbains (bus urbains, tramway, métro)";
    private Frequence aPied;
    private Frequence bicycletteConducteur;
    private Frequence moto;
    private Frequence voiturePersonnelleConducteur;
    private Frequence voiturePersonnellePassager;
    private Frequence ensembleDuReseauUrbain;

    public HabitudeUtilisationMode(Frequence aPied, Frequence bicycletteConducteur, Frequence moto, Frequence voiturePersonnelleConducteur, Frequence voiturePersonnellePassager, Frequence ensembleDuReseauUrbain) {
        this.aPied = aPied;
        this.bicycletteConducteur = bicycletteConducteur;
        this.moto = moto;
        this.voiturePersonnelleConducteur = voiturePersonnelleConducteur;
        this.voiturePersonnellePassager = voiturePersonnellePassager;
        this.ensembleDuReseauUrbain = ensembleDuReseauUrbain;
    }

    public String getLibelleApied() {
        return libelleApied;
    }

    public String getLibelleBicycletteConducteur() {
        return libelleBicycletteConducteur;
    }

    public String getLibelleMoto() {
        return libelleMoto;
    }

    public String getLibelleVoiturePersonnelleConducteur() {
        return libelleVoiturePersonnelleConducteur;
    }

    public String getLibelleVoiturePersonnellePassager() {
        return libelleVoiturePersonnellePassager;
    }

    public String getLibelleEnsembleDuReseauUrbain() {
        return libelleEnsembleDuReseauUrbain;
    }

    public Frequence getaPied() {
        return aPied;
    }

    public Frequence getBicycletteConducteur() {
        return bicycletteConducteur;
    }

    public Frequence getMoto() {
        return moto;
    }

    public Frequence getVoiturePersonnelleConducteur() {
        return voiturePersonnelleConducteur;
    }

    public Frequence getVoiturePersonnellePassager() {
        return voiturePersonnellePassager;
    }

    public Frequence getEnsembleDuReseauUrbain() {
        return ensembleDuReseauUrbain;
    }
}
