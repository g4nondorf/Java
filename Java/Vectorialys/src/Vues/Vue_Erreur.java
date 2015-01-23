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
public class Vue_Erreur {
    
    public void afficher(Exception e){
        System.out.println("ERREUR : " + e.getMessage());
    }
    
}
