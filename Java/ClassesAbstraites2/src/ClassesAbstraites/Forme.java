package ClassesAbstraites;

import Interfaces.Nommable;


abstract public class Forme implements Nommable{
    private String nom;

    abstract public void translater(double dx, double dy);

    abstract public void afficher();
    
    @Override
    public void setNom(String nom){
        this.nom = nom;
    }
    
    @Override
    public String getNom(){
        return nom;
    }

}
