/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Model.*;
import Vues.Vue_Translation;

/**
 *
 * @author Moi
 */
public class Action_Translation {
    
    public void actionTranslation(){
        Vue_Translation.saisir();//demande la valeur de translation a l'utilisateur
        double val_transl = Vue_Translation.getVal_trans();///met la valeur de translation dans la variable val_transl
        Segment Seg = Canvas.getSeg();//récupére les données du segment
        Sommet s1 = Seg.getS1();
        Sommet s2 = Seg.getS2();
        s1.translater(val_transl);//applique la translation aux deux sommets
        s2.translater(val_transl);
        System.out.println("Translation effectué SIR!");
    }
    
}
