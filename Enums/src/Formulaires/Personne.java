/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.LienPersonneReference;
import enums.OccupationPrincipale;
import enums.PossessionPermis;
import enums.Sexe;

/**
 *
 * @author Moi
 */
public class Personne {
    private final String libelleLienPersonneReference = "Lien avec la personne de référence";
    private final String libelleSexe = "Sexe";
    private final String libellePossessionTelephonePortable = "Possession d’un téléphone portable (à titre personnel ou professionnel)";
    private final String libellePossessionPermis = "Possession du permis de conduire VL(tourisme B – valide hier)";
    private final String libelleEmail = "Possession d’une adresse de messagerie électronique (personnelle ou professionnelle) consultée au moins 1 fois par semaine";
    private final String libelleOccupationPrincipale = "Occupation principale";
    private final String libelleNiveauEtude = "Plus haut niveau d'études atteint ";
    private int numero;
    private LienPersonneReference lienPersonneReference;
    private Sexe sexe;
    private boolean possessionTelephonePortable;
    private PossessionPermis possessionPermis;
    private String email;
    private OccupationPrincipale occupationPrincipale;

    public Personne(int numero, LienPersonneReference lienPersonneReference, Sexe sexe, boolean possessionTelephonePortable, PossessionPermis possessionPermis, String email, OccupationPrincipale occupationPrincipale) {
        this.numero = numero;
        this.lienPersonneReference = lienPersonneReference;
        this.sexe = sexe;
        this.possessionTelephonePortable = possessionTelephonePortable;
        this.possessionPermis = possessionPermis;
        this.email = email;
        this.occupationPrincipale = occupationPrincipale;
    }

    public String getLibelleLienPersonneReference() {
        return libelleLienPersonneReference;
    }

    public String getLibelleSexe() {
        return libelleSexe;
    }

    public String getLibellePossessionTelephonePortable() {
        return libellePossessionTelephonePortable;
    }

    public String getLibellePossessionPermis() {
        return libellePossessionPermis;
    }

    public String getLibelleEmail() {
        return libelleEmail;
    }

    public String getLibelleOccupationPrincipale() {
        return libelleOccupationPrincipale;
    }

    public String getLibelleNiveauEtude() {
        return libelleNiveauEtude;
    }

    public int getNumero() {
        return numero;
    }

    public LienPersonneReference getLienPersonneReference() {
        return lienPersonneReference;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public boolean isPossessionTelephonePortable() {
        return possessionTelephonePortable;
    }

    public PossessionPermis getPossessionPermis() {
        return possessionPermis;
    }

    public String getEmail() {
        return email;
    }

    public OccupationPrincipale getOccupationPrincipale() {
        return occupationPrincipale;
    }
}
