/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Control.SegmentException;
import Model.*;
import Vues.Vue_Translation;

/**
 *
 * @author Moi
 */
public class Action_Translation {
    
    public Segment executerTranslation(Vue_Translation VT) throws SegmentException{
        VT.saisir();//demande la valeur de translation a l'utilisateur
        double val_transl = VT.getX1();///met la valeur de translation dans la variable val_transl
        double val_trans2 = VT.getY1();
        Segment Seg = Canvas.getSeg();//récupére les données du segment
        if(Seg == null){
            throw new SegmentException("Aucun segment n'a été créé ! ");
        }
        Sommet s1 = Seg.getS1();
        Sommet s2 = Seg.getS2();
        s1.translater(val_transl, val_trans2);//applique la translation aux deux sommets
        Seg.setS1(s1);
        s2.translater(val_transl, val_trans2);
        Seg.setS2(s2);
        Canvas.setSeg(Seg);
        return Seg;
    }
    
}
