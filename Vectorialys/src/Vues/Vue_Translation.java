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
    
    private double val_trans;

    public double getVal_trans() {
        return val_trans;
    }
    
    public void saisir(){
        System.out.println("Quelle est la valeur de translation que vous souhaitez?");
        val_trans = Clavier.lireDouble();
    }
}
