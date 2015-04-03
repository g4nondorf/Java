package fr.ipst.mots.vues;

import fr.ipst.mots.entites.Mot;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class VueAffichage {
    public void afficher(Mot s, Mot r){
        System.out.println(s.getValeur());
        System.out.println(r.getValeur());
    }
}
