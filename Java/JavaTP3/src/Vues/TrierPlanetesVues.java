/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Formulaires.TriForm;

/**
 *
 * @author l.glimois
 */
public class TrierPlanetesVues {
    public TriForm saisir(){
        System.out.println("Taper 1 pour trier par nom, 2 pour trier par distance, 3 pour trier par diamètre");
        int choix = Clavier.lireInt();
        return new TriForm(choix);
    }
}
