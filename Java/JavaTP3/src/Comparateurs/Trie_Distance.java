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
public class Trie_Distance implements Comparator<Planete>{

    @Override
    public int compare(Planete t, Planete t1) {
        Long d1 = t.getDistance_soleil();
        Long d2 = t.getDistance_soleil();
        return d1.compareTo(d2);
    }
    
}
