/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

/**
 *
 * @author Moi
 */
import Control.SegmentException;
import Model.*;

public class Vue_Affichage {
    
    public void afficher(Segment Seg) throws SegmentException{
        //récupére les données du segment et en affiche les données
        if(Seg == null){
            throw new SegmentException("Aucun segment n'a été créé ! ");
        }
        Sommet s1 = Seg.getS1();
        Sommet s2 = Seg.getS2();
        double x1 = s1.getX();
        double y1 = s1.getY();
        double x2 = s2.getX();
        double y2 = s2.getY();
        System.out.println("x : (" + x1 + "," + y1 + ") | " +
                "y : (" + x2 + "," + y2 + ")");
    }
    
}
