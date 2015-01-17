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
import Vues.Vue_Creation;

public class Action_Creation {
    
    public void actionCreation(){
        Vue_Creation.Saisie();
        Vue_Creation valeur = new Vue_Creation();
        double x1 = valeur.getX1();
        double y1 = valeur.getY1();
        double x2 = valeur.getX2();
        double y2 = valeur.getY2();
        Sommet s1 = new Sommet(x1,y1);
        Sommet s2 = new Sommet(x2,y2);
        Segment Seg = new Segment(s1,s2);
        Canvas.setSeg(Seg);
        System.out.println("Votre segment a bien été créer :)");
    }
    
}
