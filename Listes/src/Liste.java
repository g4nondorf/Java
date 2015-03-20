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
        if(i != null){
            Element courant = i.courant();
            courant.chainer(new Element(o, courant.getSuivant()));
        }
    }
    
    public void supprimerSucc(Iterateur i){
        if(!i.dernier()){
            (i.courant()).chainer(((i.courant()).getSuivant()).getSuivant());
        }
    }
    
    public void supprimerQueue(){
        if(!estVide()){
            Iterateur i = this.iterateur();
            if(i.dernier()){
                tete = null;
            }else{
                while(((i.courant()).getSuivant()).getSuivant()!= null){
                    i.avancer();
                }
            }
            (i.courant()).chainer(null);
        }
    }
    
    public Iterateur getPred(Object o){
        Iterateur i = this.iterateur();
        while(i.courant().getSuivant().getObj() != o){
            i.avancer();
        }
        return i;
    }
    
    public Iterateur iterateur(){
        return new Iterateur(tete);
    }
    
    public void supprimer(Object o){
        supprimerSucc(getPred(o));
    }
}
