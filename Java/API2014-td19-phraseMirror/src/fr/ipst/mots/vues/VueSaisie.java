package fr.ipst.mots.vues;


import fr.ipst.io.Clavier;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class VueSaisie {
    public String lire(){
        System.out.print("Donner une chaine ?");
        return Clavier.lireChaine();
    }
}
