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
        
        System.out.println("Bienvenue dans ce super logiciel concernant les segments!!");
                
        while(x!=6){
            System.out.println("Taper 1, 2, 3, 4, 5 ou 6" +
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
                    Action_Longueur AL = new Action_Longueur();
                    double longr = AL.executerLongueur();
                    Vue_Longueur VL = new Vue_Longueur();
                    VL.setLongueur(longr);
                    VL.afficher();
                    break;
                case(4):
                    Vue_Rotation VR = new Vue_Rotation();
                    Action_Rotation AR = new Action_Rotation();
                    Segment Seg2 = AR.executerRotation(VR);
                    Canvas.setSeg(Seg2);
                    System.out.println("Rotation effectuer connard!");
                    break;
                case(5):
                    Vue_Translation VT = new Vue_Translation();
                    Action_Translation AT = new Action_Translation();
                    Segment Seg1 = AT.executerTranslation(VT);
                    Canvas.setSeg(Seg1);
                    System.out.println("Translation effectuer connard!");
                    break;
                case(6):
                    System.out.println("OK bon ben salut alors :)");
                    break;  
            }
            
        }
        
    }
    
}
