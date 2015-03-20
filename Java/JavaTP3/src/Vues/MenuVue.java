/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

/**
 *
 * @author l.glimois
 */
public class MenuVue {
    public int afficher(){
        int choix;
        System.out.println("Ajouter une planète : 0");
        System.out.println("Rechercher une planète : 1");
        System.out.println("Trier les planètes : 2");
        System.out.println("Calculer la distance entre 2 planètes : 3");
        System.out.println("Afficher les planètes : 4");
        System.out.println("Quitter : 5");
        choix = Clavier.lireInt();
        return choix;
    }
}
