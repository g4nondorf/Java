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
    
    private double angle;

    public double getAngle() {
        return angle;
    }
    
    public void saisir(){
        System.out.println("Quelle est la valeur de l'angle pour la rotation?");
        angle = Clavier.lireDouble();
    }
    
}
