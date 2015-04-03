package fr.ipst.chiffres.controleurs;


import fr.ipst.chiffres.actions.ActionConversion;
import fr.ipst.io.Clavier;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class Controleur {
    public static void main(String[] args){
        System.out.print("Donner un mot indiquant un nombre ?");
        String x = Clavier.lireChaine();
        
        long n = (new ActionConversion()).convertir(x);
        System.out.println(n);
        
    }
        

}
