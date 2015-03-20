/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparateurs;
import Modeles.Planete;
import Formulaires.TriForm;
import java.util.Comparator;

/**
 *
 * @author Moi
 */
public class Trie_Factory {
    public Comparator creeComparat(int comp){
        Comparator c;
        if(comp ==1){
            c = new Trie_Nom();
        }else if(comp ==2){
            c = new Trie_Distance();
        }else{
            c = new Trie_Volume();
        }
        return c;
    }
}
