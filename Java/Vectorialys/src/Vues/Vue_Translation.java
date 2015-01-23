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

public class Vue_Translation {
    
    private double x1, y1;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }
    
    public void saisir(){//récupére la valeur de translation
        System.out.print("Quelle est la valeur de translation que vous souhaitez? "
                + "\nPour cela nous considérons un vecteur donc il me faut un x : ");
        x1 = Clavier.lireDouble();
        System.out.print("et un y : ");
        y1 = Clavier.lireDouble();
    }
    
}
