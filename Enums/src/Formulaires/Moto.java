/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.GenreM;
import enums.LieuStationnementNuitVMO;
import enums.PuissanceM;
import enums.TypeMoteur;
import enums.TypeStationnementNuitVMO;

/**
 *
 * @author Moi
 */
public class Moto {
    private final String libelleGenreM = "Genre du 2 ou 3 roues à moteur ?";
    private final String libellePuissanceM = "Cylindrée - Puissance";
    private final String libelleTypeMoteur = "Type de moteur thermique";
    private final String libelleAnnee = "Année de première mise en circulation";
    private final String libellePuissance = "Puissance fiscale (en chevaux)";
    private final String libelleLieuStationnementNuit = "La nuit, où stationne le plus souvent, le véhicule ?";
    private final String libelleTypeStationnementNuit = "La nuit, ce stationnement est-il ?";
    private int annee;
    private int puissance;
    private LieuStationnementNuitVMO LieuStationnementNuit;
    private TypeStationnementNuitVMO TypeStationnementNuit;
    private GenreM genreM;
    private PuissanceM puissanceM;
    private TypeMoteur typeMoteur;

    public Moto(int annee, int puissance, LieuStationnementNuitVMO LieuStationnementNuit, TypeStationnementNuitVMO TypeStationnementNuit, GenreM genreM, PuissanceM puissanceM, TypeMoteur typeMoteur) {
        this.annee = annee;
        this.puissance = puissance;
        this.LieuStationnementNuit = LieuStationnementNuit;
        this.TypeStationnementNuit = TypeStationnementNuit;
        this.genreM = genreM;
        this.puissanceM = puissanceM;
        this.typeMoteur = typeMoteur;
    }

    public String getLibelleGenreM() {
        return libelleGenreM;
    }

    public String getLibellePuissanceM() {
        return libellePuissanceM;
    }

    public String getLibelleTypeMoteur() {
        return libelleTypeMoteur;
    }

    public String getLibelleAnnee() {
        return libelleAnnee;
    }

    public String getLibellePuissance() {
        return libellePuissance;
    }

    public String getLibelleLieuStationnementNuit() {
        return libelleLieuStationnementNuit;
    }

    public String getLibelleTypeStationnementNuit() {
        return libelleTypeStationnementNuit;
    }

    public int getAnnee() {
        return annee;
    }

    public int getPuissance() {
        return puissance;
    }

    public LieuStationnementNuitVMO getLieuStationnementNuit() {
        return LieuStationnementNuit;
    }

    public TypeStationnementNuitVMO getTypeStationnementNuit() {
        return TypeStationnementNuit;
    }

    public GenreM getGenreM() {
        return genreM;
    }

    public PuissanceM getPuissanceM() {
        return puissanceM;
    }

    public TypeMoteur getTypeMoteur() {
        return typeMoteur;
    }
}
