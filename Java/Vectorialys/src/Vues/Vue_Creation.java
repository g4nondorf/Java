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
public class Vue_Creation {
    
    private double x1, y1, x2, y2;
    
    public void Saisie(){
        System.out.println("Valeur de x1?");
        x1 = Clavier.lireDouble();
        System.out.println("Valeur de y1?");
        y1 = Clavier.lireDouble();
        System.out.println("Valeur de x2?");
        x2 = Clavier.lireDouble();
        System.out.println("Valeur de y2?");
        y2 = Clavier.lireDouble();
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
    
}
