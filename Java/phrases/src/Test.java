/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Test {
    
    public static void main(String[] args){
        
        System.out.print("Faites un mot ou phrase pour voir si c'est un palyndrome\nAllez y : ");
        String maPhrase = Clavier.lireString();
        Phrase objet = new Phrase(maPhrase);
        boolean palyndrome = objet.estPalindrome();
        int nbMot = objet.getNbMot();
        
        String chaineInverse = objet.phraseRetournee();
        System.out.println(chaineInverse);
        System.out.println("Il comporte : " + nbMot + " Mots");
        if(palyndrome){
            System.out.println("C'en est un");
        }else if(!palyndrome){
            System.out.println("C'en est pas un");
        }else{
            System.out.println("Y'a un probléme");
        }
        
    }
           
}
