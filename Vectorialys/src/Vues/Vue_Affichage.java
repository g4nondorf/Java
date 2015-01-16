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
import Model.*;

public class Vue_Affichage {
    
    Segment Seg;

    public Vue_Affichage(Segment Seg) {
        this.Seg = Seg;
    }
    
    public void afficher(){
        Segment Seg = Canvas.getSeg();
        Sommet s1 = Seg.getS1();
        Sommet s2 = Seg.getS2();
        double x1 = s1.getX();
        double y1 = s1.getY();
        double x2 = s2.getX();
        double y2 = s2.getY();
        System.out.println("Le segment est formé par les points de coordonnées (x,y)"
                + "\nx : (" + x1 + "," +y1 +
                "\ny : (" + x2 + "," + y2);
    }
    
}
