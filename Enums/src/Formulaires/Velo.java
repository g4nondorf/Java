/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

/**
 *
 * @author Moi
 */
public class Velo {
    private final String libelleAssistanceElectrique = "Le velo est-il équipé dd'une assistance électrique ?";
    private final String libelleLieuStationnementNuit = "Disposez-vous d'un lieu de stationnement sécurisé pour un vélo de type cave, box, local dédié, cour fermée à domicile ?";
    private boolean LieuStationnementNuit;
    private boolean assistanceElectrique;

    public Velo(boolean LieuStationnementNuit, boolean assistanceElectrique) {
        this.LieuStationnementNuit = LieuStationnementNuit;
        this.assistanceElectrique = assistanceElectrique;
    }

    public String getLibelleAssistanceElectrique() {
        return libelleAssistanceElectrique;
    }

    public String getLibelleLieuStationnementNuit() {
        return libelleLieuStationnementNuit;
    }

    public boolean isLieuStationnementNuit() {
        return LieuStationnementNuit;
    }

    public boolean isAssistanceElectrique() {
        return assistanceElectrique;
    }
}
