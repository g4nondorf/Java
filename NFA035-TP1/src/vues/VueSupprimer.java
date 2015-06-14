/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import IO.Clavier;

/**
 *
 * @author Moi
 */
public class VueSupprimer {
    public String lire(){
        System.out.print("Nom du fichier ? ");
        String s = Clavier.lireChaine();
        return s;
    }
}
