/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

/**
 *
 * @author Moi
 */
import Model.*;

public class Vue_Longueur {
    
    private double longueur;

    public void setLongueur(double longueur) {//met a jour la variable longueur
        this.longueur = longueur;
    }
    
    public void afficher(){//affiche le longueur
        System.out.println("La longueur de votre segment est : " + longueur);
    }
    
}
