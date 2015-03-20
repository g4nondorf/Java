/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Formulaires.Form_SDistance;
import Modeles.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author l.glimois
 */
public class CalculDistanceAction {

    public double executer(Form_SDistance FSD) {
        double distance = -1;
        SystemeSolaire ss = SystemeSolaire.getInstance();
        Iterator<Planete> iterator = ss.iterator();
        ArrayList<Planete> planetes = new ArrayList<Planete>();
        while (iterator.hasNext()) {
            planetes.add(iterator.next());
        }
        Planete planete1 = null, planete2 = null;
        for (int i = 0; i < planetes.size(); i++) {
            if (planetes.get(i).getNom().equals(FSD.getNomP1())) {
                planete1 = planetes.get(i);
            } else if (planetes.get(i).getNom().equals(FSD.getNomP2())) {
                planete2 = planetes.get(i);
            }
            if (planete1 != null && planete2 != null) {
                break;
            }
        }
        if (planete1 != null && planete2 != null) {
            distance = planete1.calculerDistance(planete2);
        }
        return distance;
        /*SystemeSolaire ss = SystemeSolaire.getInstance();
        Iterator<Planete> it = ss.iterator();
        Planete p1=null,p2=null,pc;
        while(it.hasNext() && p1==null && p2==null){
            pc=it.next();
            if(p1==null && pc.getNom().equals(FSD.getNomP1())){
                p1=pc;
            }
            if(p2==null && pc.getNom().equals(FSD.getNomP2())){
                p2=pc;
            }
        }
        if(p1==null || p2==null){
            return -1;
        }else{
            return p1.calculerDistance(p2);
        }*/
    }
}
