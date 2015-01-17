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
    
    private static double val_trans;

    public static double getVal_trans() {
        return val_trans;
    }
    
    public static void saisir(){//récupére la valeur de translation
        System.out.println("Quelle est la valeur de translation que vous souhaitez?");
        val_trans = Clavier.lireDouble();
    }
}
