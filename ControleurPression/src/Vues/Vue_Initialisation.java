/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;
import Formulaires.Form_Initialisation;

/**
 *
 * @author Moi
 */
public class Vue_Initialisation {
    public Form_Initialisation saisir(){
        double[] pressions = new double[4];
        for(int i = 0; i < 4; i++){
            System.out.println("Saisir la pression n°" + i);
            pressions[i] = Clavier.lireDouble();
        }
        return new Form_Initialisation(pressions[0], pressions[0], pressions[0], pressions[0]);
    }
}
