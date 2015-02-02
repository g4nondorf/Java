/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Phrase {

    String chaine;
    
    public Phrase(String chaine) {
        this.chaine = chaine;
    }
    
    public int getTaille(){
        int taille = chaine.length();
        return taille;
    }
    
    public String inverserLettres(){
        String inverse = "";
        int taille = getTaille();
        
        for(int i = 0; i < taille; i++ ){
            inverse += chaine.charAt(taille-i-1);
        }
        
        return inverse;
    }
    
    public boolean estPalindrome(){
        String inverse = inverserLettres();
        boolean oui;
        int taille = chaine.length();
        String chaine1 = chaine.replaceAll(" ", "");
        String newInverse = inverse.replaceAll(" ", "");
        
        if(newInverse.equals(chaine1)){
            oui = true;
            return oui;
        }else if(!newInverse.equals(chaine1)){
            oui = false;
            return oui;
        }else{
            System.out.println("Y'a un probléme");
            oui = false;
            return oui;
        }
    }
    
    public static void main(String[] args){
        
        System.out.print("Faites un mot ou phrase pour voir si c'est un palyndrome\nAllez y : ");
        String maPhrase = Clavier.lireString();
        Phrase objet = new Phrase(maPhrase);
        boolean palyndrome = objet.estPalindrome();
        
        if(palyndrome){
            System.out.println("C'en est un");
        }else if(!palyndrome){
            System.out.println("C'en est pas un");
        }else{
            System.out.println("Y'a un probléme");
        }
            
    }
}
