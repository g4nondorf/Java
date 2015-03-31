
import java.util.Comparator;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
abstract public class Employe implements Comparable<Employe>{
    protected int numero;
    protected String nom;
    protected String prenom;
    protected Date dateEmbauche;

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    @Override
    public int compareTo(Employe t) {
        Integer emp1 = this.numero;
        Integer emp2 = t.getNumero();
        return emp1.compareTo(emp2);
    }
    
    @Override
    public boolean equals(Object obj){
        boolean b = false;
        if(obj instanceof Employe){
            if(this.numero == ((Employe)obj).getNumero()){
                b = true;
            }
        }
        return b;
    }
    
    abstract public double getSalaire();
}
