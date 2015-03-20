/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Formulaires.Form_Recherche;

/**
 *
 * @author l.glimois
 */
public class ChercherPlaneteVue {
    public Form_Recherche saisir(){
        System.out.println("Partie du nom de la planete ?");
        String nom=Clavier.lireString();
        return new Form_Recherche(nom);
    }
}
