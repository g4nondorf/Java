/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparateurs;

import java.util.Comparator;
import Modeles.Planete;

/**
 *
 * @author Moi
 */
public class Trie_Volume implements Comparator<Planete>{

    @Override
    public int compare(Planete t, Planete t1) {
        Integer d1 = (Integer)t.getDiametre();
        Integer d2 = (Integer)t1.getDiametre();
        return d1.compareTo(d2);
    }
    
}
