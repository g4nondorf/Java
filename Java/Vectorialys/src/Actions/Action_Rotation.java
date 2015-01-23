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
    
    public Segment executerRotation(Vue_Rotation VR){
        VR.saisir();//récupére la valeur de l'angle de rotation
        double angle2 = VR.getAngle();//met la valeur dans la variable angle2
        double x1 = VR.getX1();
        double y1 = VR.getY1();
        Segment Seg = Canvas.getSeg();//récupére les données du segment
        Seg.rotation(angle2, x1, y1);//applique la rotation
        Canvas.setSeg(Seg);
        return Seg;
    }
        
}
