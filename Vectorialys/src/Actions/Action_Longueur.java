/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

/**
 *
 * @author Moi
 */
import Model.*;
import Vues.Vue_Longueur;

public class Action_Longueur {
    
    public void actionLongueur(){
        double longr;
        Segment Seg = Canvas.getSeg();//récupére les données du segment
        longr = Seg.longueur();//calcul la longueur du segment
        Vue_Longueur attribution = new Vue_Longueur();
        attribution.setLongueur(longr);//attribut la loongueur calculée
        Vue_Longueur.afficher();//affiche la valeur calculée
    }
    
}
