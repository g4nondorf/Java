/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Iterateur {
    private Element premier;
    private Element courant;
    
    public Iterateur(Element e){
        this.premier = e;
        this.courant = e;
    }
    
    public Element courant(){
        return courant;
    }
    
    public void seek(int n){
        raz();
        for(int i = 0; i < n; i++){
            avancer();
        }
    }
    
    public Object getObject(){
        if(fin()){
            return null;
        }
        return courant.getObj();
    }
    
    public void raz(){
        courant = premier;
    }
    
    public boolean fin(){
        return courant == null;
    }
    
    public boolean dernier(){
        return fin() || (courant.getSuivant()==null);
    }
    
    public void avancer(){
        if (!fin())courant = courant.getSuivant();
    }
}
