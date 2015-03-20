/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Formulaires.Form_Recherche;
import Modeles.Planete;
import Modeles.SystemeSolaire;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author l.glimois
 */
public class ChercherPlaneteAction {
    public Planete[] executer(Form_Recherche FR){
        SystemeSolaire ss = SystemeSolaire.getInstance();
        Iterator<Planete> iterator = ss.iterator();
        ArrayList<Planete> planetes = new ArrayList<Planete>();
        while (iterator.hasNext()) {
            Planete p=iterator.next();
            if(p.getNom().contains(FR.getMorceau_nom_planete())){
                planetes.add(p);
            } 
        }
        Planete[] resultats;
        if(planetes!=null){
            resultats=new Planete[planetes.size()];
            for (int i = 0; i < planetes.size(); i++) {
                resultats[i]=planetes.get(i);
            }
        }else{
            resultats=null;
        }
        return resultats;
    }
}
