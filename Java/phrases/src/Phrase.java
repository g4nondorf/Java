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
        String inverse = this.inverserLettres();
        String chaine1 = chaine.replaceAll(" ", "");
        String newInverse = inverse.replaceAll(" ", "");
        return chaine1.equalsIgnoreCase(newInverse);
    } 
    
    public String phraseRetournee(){
        String newChaine = "";
        int d = chaine.length();
        
        for(int i = chaine.length()-1; i>=0; i--){
            if (chaine.charAt(i) == ' '){
                newChaine += chaine.substring(i+1, d) + " ";
                d = i;
            }else if(i == 0){
                newChaine += chaine.substring(i, d);
            }
        }
        
        return newChaine;
    }
    
    public int getNbMot(){
        String sTemp = chaine.replaceAll("  ", "").trim();
        int result = 0;
        
        if(sTemp.length()!=0) result++;
        while(sTemp.indexOf(' ')!=-1){
            result++;
            sTemp = sTemp.substring(sTemp.indexOf(' ')).trim();
        }
        return result;
    }
    
}
