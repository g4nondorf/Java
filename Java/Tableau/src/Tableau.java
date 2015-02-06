
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Tableau {
    private int[] tab;
    
    public Tableau(){//une méthode de constructeur
        System.out.print("Quelle longueur voulez vous pour votre tableau?\n : ");
        int nbrCase = Clavier.lireInt();
        tab = new int[nbrCase];
        
        for(int i = 0; i<nbrCase; i++){
            System.out.print("Quelle valeur pour la case " + i + " ?");
            tab[i] = Clavier.lireInt();
        }
    }
    
    public Tableau(int nbrCase){//Autre méthode d'initialisation
        Random r = new Random();
        tab = new int[nbrCase];
        
        for(int i = 0; i < nbrCase; i++){
            tab[i] = r.nextInt(100);
        }
    }
    
    public int getTaille(){
        return tab.length;
    }
    
    public int getElement(int place){
        return tab[place];
    }
    
    public void setElement(int place, int valeur){
        tab[place] = valeur;
    }
    
    public int getMax(){
        int valeur = tab[0];
        
        for(int i = 1; i < tab.length; i++){
            if(tab[i]>valeur){
                valeur = tab[i];
            }
        }
        
        return valeur; 
    }
    
    public int getMin(){
        int valeur = tab[0];
        
        for(int i = 1; i < tab.length; i++){
            if(tab[i]<valeur){
                valeur = tab[i];
            }
        }
        
        return valeur;
    }
    
    public double getMoyenne(){
        double valeur = 0;
        
        for(int i = 0; i < getTaille(); i++){
            valeur += (double)tab[i];
        }
        
        return valeur/(double)getTaille();
    }
    
    public void trierTab(){
        for(int i = 1; i < tab.length; i++){
            int x = tab[i];
            int j = i;
            
            while(j>0 && tab[j-1]>x){
                tab[j] = tab[j-1];
                j--;
            }
            
            tab[j] = x;
        }
    }
    
    @Override
    public String toString(){
        String chaine = "";
        for(int i = 0; i < tab.length; i++){
            if(i == tab.length-1){
                chaine += tab[i] + "]";
            }else if(i == 0){
                chaine += "[" + tab[i] + ", ";
            }else{
                chaine += tab[i] + ", ";
            }
        }
        return chaine;
    }
    
    public int getNbSousMoy(){
        int valeur = 0;
        double moy = this.getMoyenne();
        for(int i = 0; i < tab.length; i++){
            if(tab[i] < moy){
                valeur++;
            }
        }
        return valeur;
    }
    
    public int getNbSurMoy(){
        int valeur = 0;
        double moy = this.getMoyenne();
        for(int i = 0; i < tab.length; i++){
            if(tab[i] > moy){
                valeur++;
            }
        }
        return valeur;
    }
}
