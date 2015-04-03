package fr.ipst.chiffres.metier;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class Chiffre {
    static String [] lettres = {
        "zero",
        "un",
        "deux",
        "trois",
        "quatre",
        "cinq",
        "six",
        "sept",
        "huit",
        "neuf",
        "dix",
        "onze",
        "douze",
        "trieze",
        "quatorze",
        "quinze",
        "seize",
        "vingt",
        "trente",
        "quarante",
        "cinquante",
        "soixante",
        "septante",
        "nonante",
        "cent",
        "cents",
        "mille",
        "milles",
        "million",
        "millions",
        "milliard",
        "milliars"};  
    long [] valeurs ={
        0,
        1,
        2, 
        3,
        4,
        5,
        6, 
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        20,
        30,
        40,
        50,
        60,
        70, 
        90,
        100,
        100,
        1000,
        1000,
        1000000,
        1000000,
        1000000000,
        1000000000};
    private long valeur;

    public long getValeur() {
        return valeur;
    }
    public Chiffre(String x){
        for(int i=0; i < lettres.length; i++){
            if(x.equalsIgnoreCase(lettres[i])){
                valeur = valeurs[i];
                break;
            }
        }
    }
    public long valeur(String x){
        long r = 0;
        for(int i=0; i < lettres.length; i++){
            if(x.equalsIgnoreCase(lettres[i])){
                r = valeurs[i];
                break;
            }
        }
        return r;
    }
}
