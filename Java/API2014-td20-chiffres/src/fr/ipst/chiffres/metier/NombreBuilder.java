package fr.ipst.chiffres.metier;


import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class NombreBuilder {
    private static String[] mots = null;
    public static Nombre construireNombre(String s){
         String[] tab = s.split(" ");
        for(String x:tab){
            if(x != null && ! x.equals("")){
                ajouter(x);
            }
        }
       Nombre n = new Nombre(mots);
       return n;
    }

    private static void ajouter(String x){
        if(mots == null){
            mots = new String[1];  
            mots[0] = x;
        }else{
            String [] tab = Arrays.copyOf(mots, mots.length + 1);
            tab[mots.length] = x;
            mots = tab;
        }
    }

}
