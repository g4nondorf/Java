/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Moi
 */
import Vues.*;
import Actions.*;
import Model.*;

public class Controleur {
    
    public static void main(String[] args){
        
        int x=0;
        
        while(x!=6){
            System.out.println("Bienvenue dans ce super logiciel concernant les segments!!" +
                "Taper :" +
                "\n1 : Créer un segment" +
                "\n2 : Afficher mon segment" +
                "\n3 : Calculer la longueur de mon segment" +
                "\n4 : Effectuer un rotation de mon segment" +
                "\n5 : Effectuer un translation de mon segment" +
                "\n6 : Sortir");
            x = Clavier.lireInt();
            
            Segment Seg;
            
            switch(x){
                case(1):
                    Vue_Creation VC = new Vue_Creation();
                    VC.Saisie();
                    Action_Creation AC = new Action_Creation();
                    Seg = AC.executerCreation(VC);
                    Canvas.setSeg(Seg);
                    System.out.println("Votre segment a bien été créer :)");
                    break;
                case(2):
                    Seg = Canvas.getSeg();
                    Vue_Affichage VA = new Vue_Affichage();
                    VA.attribution(Seg);
                    VA.afficher();
                    break;
                case(3):
                    
                    break;
                case(4):
                    
                    break;
                case(5):
                    
                    break;
                case(6):
                    System.out.println("OK bon ben salut alors :)");
                    break;
                    
            }
            
        }
        
    }
    
}
