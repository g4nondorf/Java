/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Formulaires.TriForm;
import java.util.TreeSet;
import Comparateurs.Trie_Factory;
import Modeles.Planete;
import Modeles.SystemeSolaire;
import java.util.Comparator;

/**
 *
 * @author l.glimois
 */
public class TrierPlaneteAction {
    public TreeSet executer(TriForm TF){
        SystemeSolaire ss = SystemeSolaire.getInstance();
        if(ss.getInstance() != null){
            Comparator<Planete> cmp = (new Trie_Factory()).creeComparat(TF.getChoix());
            TreeSet<Planete> set = new TreeSet<Planete>(cmp);
            set.addAll(ss);
            return set;
        }else{
            return null;
        }
    }
}
