/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparateurs;

import Modeles.Planete;
import java.util.Comparator;

/**
 *
 * @author Moi
 */
public class Trie_Nom implements Comparator<Planete>{

    @Override
    public int compare(Planete t, Planete t1) {
        return t.compareTo(t1);
    }
    
}
