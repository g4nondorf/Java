/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

import enums.EnergieV;
import enums.GenreV;
import enums.LieuStationnementNuitVMO;
import enums.PossessionV;
import enums.TypeStationnementNuitVMO;

/**
 *
 * @author Moi
 */
public class VoitureTourisme {
    private final String libelleGenreV = "Genre du véhicule";
    private final String libelleEnergieV = "Énergie du véhicule ";
    private final String libellePossesionV = "Le véhicule est-il ?";
    private final String libelleAnnee = "Année de première mise en circulation";
    private final String libellePuissance = "Puissance fiscale (en chevaux)";
    private final String libelleLieuStationnementNuit = "La nuit, où stationne le plus souvent, le véhicule ?";
    private final String libelleTypeStationnementNuit = "La nuit, ce stationnement est-il ?";
    private int annee;
    private int puissance;
    private LieuStationnementNuitVMO LieuStationnementNuit;
    private TypeStationnementNuitVMO TypeStationnementNuit;
    private GenreV genreV;
    private EnergieV energieV;
    private PossessionV possessionV;

    public VoitureTourisme(int annee, int puissance, LieuStationnementNuitVMO LieuStationnementNuit, TypeStationnementNuitVMO TypeStationnementNuit, GenreV genreV, EnergieV energieV, PossessionV possessionV) {
        this.annee = annee;
        this.puissance = puissance;
        this.LieuStationnementNuit = LieuStationnementNuit;
        this.TypeStationnementNuit = TypeStationnementNuit;
        this.genreV = genreV;
        this.energieV = energieV;
        this.possessionV = possessionV;
    }

    public String getLibelleGenreV() {
        return libelleGenreV;
    }

    public String getLibelleEnergieV() {
        return libelleEnergieV;
    }

    public String getLibellePossesionV() {
        return libellePossesionV;
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

    public GenreV getGenreV() {
        return genreV;
    }

    public EnergieV getEnergieV() {
        return energieV;
    }

    public PossessionV getPossessionV() {
        return possessionV;
    }
}
