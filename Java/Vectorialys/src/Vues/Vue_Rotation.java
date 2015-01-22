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

public class Vue_Rotation {
    
    private double angle, x1, y1;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void saisir(){//récupére l'angle de rotation
        System.out.println("Quelle est la valeur de l'angle pour la rotation?");
        angle = Clavier.lireDouble();
        System.out.println("A partir de quel point pour la rotation?" +
                "\nx ?");
        x1 = Clavier.lireDouble();
        System.out.println("y ?");
        y1 = Clavier.lireDouble();
    }
    
}
