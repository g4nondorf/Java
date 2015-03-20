/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;
import Modeles.Planete;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Moi
 */
public class AfficherTrieVue {
    public void afficher(TreeSet t){
        if(t == null){
            System.out.println("Pas de planete a afficher");
        }else{
            if(t.isEmpty()){
                System.out.println("Pas de planete a afficher");
            }else{
                Iterator i = t.iterator();
                while(i.hasNext()){
                    System.out.println(i.next());
                }
            }
        }
    }
}
