/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Formulaires.Form_Creation;
import Modeles.*;

/**
 *
 * @author l.glimois
 */
public class AjoutPlaneteAction {
    public void executer(Form_Creation FC){
        if(SystemeSolaire.getInstance()==null){
            SystemeSolaire.creation();
        }
        SystemeSolaire.getInstance().add(new Planete(FC.getNom(),FC.getDistance(),FC.getDiametre()));
    }
}
