/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Formulaires.Form_Creation;

/**
 *
 * @author l.glimois
 */
public class AjoutPlaneteVue {
    public Form_Creation saisir(){
        System.out.println("Nom de la planete ?");
        String nom=Clavier.lireString();
        System.out.println("Distance au soleil ?");
        long distance=Clavier.lireInt();
        System.out.println("Diamètre ?");
        int diametre=Clavier.lireInt();
        return new Form_Creation(nom, distance, diametre);
    }
}
