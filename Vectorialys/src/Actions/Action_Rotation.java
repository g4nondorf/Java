/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Model.*;
import Vues.Vue_Rotation;
/**
 *
 * @author Moi
 */
public class Action_Rotation {
    
    public void actionRotation(){
        Vue_Rotation.saisir();//récupére la valeur de l'angle de rotation
        double angle2 = Vue_Rotation.getAngle();//met la valeur dans la variable angle2
        Segment Seg = Canvas.getSeg();//récupére les données du segment
        Seg.rotation(angle2);//applique la rotation
        System.out.println("Rotation effectué SIR!");
    }
        
}
