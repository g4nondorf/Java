/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Formulaires.Form_SDistance;

/**
 *
 * @author l.glimois
 */
public class CalculerDistanceVue {
    public Form_SDistance saisir(){
        System.out.println("Nom de la planete 1 ?");
        String nom1=Clavier.lireString();
        System.out.println("Nom de la planete 2 ?");
        String nom2=Clavier.lireString();
        return new Form_SDistance(nom1,nom2);
    }
}
