/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.DispoVoiture;
import enums.ProblemeStationnement;
import enums.ProblemeStationnementPossible;
import enums.StationnementVeloPossible;
import enums.TypeOccupation;

/**
 *
 * @author Moi
 */
public class OccupationsPrincipales {
    private final String libelleLieu = "Pouvez-vous selectionner sur la carte votre lieu d'activité";
    private final String libelleDispoVoiture = "En général, disposez-vous d’une voiture en tant que conducteur ?";
    private final String libelleProblemeStationnement = "En général, rencontrez-vous des problèmes de stationnement ?";
    private final String libelleProblemeStationnementPossible = "Est-il difficile de stationner ?";
    private final String libelleStationnementVeloPossible = "Avez-vous ou auriez vous la possibilité de stationner un vélo de manière sécurisée ?";
    private Carreau lieu;
    private DispoVoiture dispoVoiture;
    private ProblemeStationnement problemeStationnement;
    private ProblemeStationnementPossible problemeStationnementPossible;
    private StationnementVeloPossible stationnementVeloPossible;
    private TypeOccupation typeOccupation;

    public OccupationsPrincipales(Carreau lieu, DispoVoiture dispoVoiture, ProblemeStationnement problemeStationnement, ProblemeStationnementPossible problemeStationnementPossible, StationnementVeloPossible stationnementVeloPossible, TypeOccupation typeOccupation) {
        this.lieu = lieu;
        this.dispoVoiture = dispoVoiture;
        this.problemeStationnement = problemeStationnement;
        this.problemeStationnementPossible = problemeStationnementPossible;
        this.stationnementVeloPossible = stationnementVeloPossible;
        this.typeOccupation = typeOccupation;
    }

    public String getLibelleLieu() {
        return libelleLieu;
    }

    public String getLibelleDispoVoiture() {
        return libelleDispoVoiture;
    }

    public String getLibelleProblemeStationnement() {
        return libelleProblemeStationnement;
    }

    public String getLibelleProblemeStationnementPossible() {
        return libelleProblemeStationnementPossible;
    }

    public String getLibelleStationnementVeloPossible() {
        return libelleStationnementVeloPossible;
    }

    public Carreau getLieu() {
        return lieu;
    }

    public DispoVoiture getDispoVoiture() {
        return dispoVoiture;
    }

    public ProblemeStationnement getProblemeStationnement() {
        return problemeStationnement;
    }

    public ProblemeStationnementPossible getProblemeStationnementPossible() {
        return problemeStationnementPossible;
    }

    public StationnementVeloPossible getStationnementVeloPossible() {
        return stationnementVeloPossible;
    }

    public TypeOccupation getTypeOccupation() {
        return typeOccupation;
    }
}
