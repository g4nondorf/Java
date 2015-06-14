/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vues;

import IO.Clavier;

/**
 *
 * @author Hadj
 */
public class VueSauvegarde {
    public String lire(){
        System.out.print("Nom du fichier ? ");
        String s = Clavier.lireChaine();
        return s;
    }
}
