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
            System.out.println("1 : Créer un segment" +
                "\n2 : Afficher mon segment" +
                "\n3 : Calculer la longueur de mon segment" +
                "\n4 : Effectuer un rotation de mon segment" +
                "\n5 : Effectuer un translation de mon segment" +
                "\n6 : Sortir" +
                "\nChoisis ton camp camarade!");
            x = Clavier.lireInt();
            
            Segment Seg;
            
            try{
                
                switch(x){
                    case(1):
                        Vue_Creation VC = new Vue_Creation();
                        VC.Saisie();
                        Action_Creation AC = new Action_Creation();
                        Seg = AC.executerCreation(VC);
                        new Vue_Affichage().afficher(Seg);
                        break;
                    case(2):
                        Seg = Canvas.getSeg();
                        new Vue_Affichage().afficher(Seg);
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
                        Segment Seg1 = AR.executerRotation(VR);
                        new Vue_Affichage().afficher(Seg1);
                        break;
                    case(5):
                        Vue_Translation VT = new Vue_Translation();
                        Action_Translation AT = new Action_Translation();
                        Segment Seg2 = AT.executerTranslation(VT);
                        new Vue_Affichage().afficher(Seg2);
                        break;
                    case(6):
                        System.out.println("Je vous remercie d'avoir utilisé mon prgramme\nRéaliser par G4nondorf");
                        break;  
                }
            
            }catch(SegmentException e){
                (new Vue_Erreur()).afficher(e);
            }
        
        }
        
    }
    
}
