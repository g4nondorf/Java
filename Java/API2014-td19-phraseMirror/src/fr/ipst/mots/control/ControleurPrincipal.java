package fr.ipst.mots.control;


import fr.ipst.mots.actions.ActionTexteSplit;
import fr.ipst.mots.actions.ActionTexteSubstring;
import fr.ipst.mots.entites.Mot;
import fr.ipst.mots.vues.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class ControleurPrincipal {
    public static void main(String [] args){
        String s = (new VueSaisie()).lire();
        Mot m = new Mot(s);
        Mot r = (new ActionTexteSplit()).executer(m);
//        Mot r = (new ActionTexteSubstring()).executer(m);
       (new VueAffichage()).afficher(m, r);
    }
}
