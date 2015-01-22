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
    
    public Segment executerCreation(Vue_Creation VC){
        double x1 = VC.getX1();
        double y1 = VC.getY1();
        double x2 = VC.getX2();
        double y2 = VC.getY2();
        Sommet s1 = new Sommet(x1,y1);
        Sommet s2 = new Sommet(x2,y2);
        Segment Seg = new Segment(s1,s2);
        return Seg;
    }
    
}
