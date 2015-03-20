/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Moi
 */
public class TestMap {
    public static void main(String[] args){
        int[] tab = {1,2,0,3,2
                ,2,1,0,3,8};
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < tab.length; i++){
            Integer key = new Integer(tab[i]);
            Integer frequence = index.get(key);
            if(frequence == null){
                frequence = new Integer(1);
            }else{
                int valeur = frequence.intValue();
                frequence = new Integer(valeur + 1);
            }
            index.put(key, frequence);
        }
        
        System.out.println(index);
        Set<Integer> keys = index.keySet();
        for(Integer i : keys){
            Integer f = index.get(i);
            System.out.println(i.intValue() + " \t:" + f.intValue() + " \t:fois");
        }
    }
}
