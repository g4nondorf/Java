/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Liste {
    private Element tete;
    
    public Liste(){
        this.tete = null;
    }
    
    public boolean estVide(){
        boolean estVide = false;
        if(this.tete == null){
            estVide = true;
        }
        return estVide;
    }
    
    public void vider(){
        this.tete = null;
    }
    
    public void insererTete(Object o){
        tete = new Element(o, tete);
    }
    
    public void insererSucc(Iterateur i,Object o){
        
    }
    
    public void supprimerSucc(Iterateur i){
        
    }
    
    public void supprimerQueue(){
        
    }
    
    public Iterateur getPred(Object o){
        
    }
    
    public Iterateur iterateur(){
        
    }
}
