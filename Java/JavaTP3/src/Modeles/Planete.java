/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

/**
 *
 * @author l.glimois
 */
public class Planete implements Comparable<Planete>{
    private String nom;
    private long distance_soleil;
    private int diametre;

    public String getNom() {
        return nom;
    }

    public long getDistance_soleil() {
        return distance_soleil;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDistance_soleil(long distance_soleil) {
        this.distance_soleil = distance_soleil;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public Planete(String nom, long distance_soleil, int diametre) {
        this.nom = nom;
        this.distance_soleil = distance_soleil;
        this.diametre = diametre;
    }
    
    public boolean equals(Object planete1){
        boolean b=false;
        if(planete1 instanceof Planete){
            Planete p=(Planete)planete1;
            if(this.nom.equals(p.getNom())&&this.diametre==p.getDiametre()&&this.distance_soleil==p.getDistance_soleil()){
                b=true;
            }
        }
        return b;
    }

    @Override
    public String toString() {
        return "Nom : "+getNom()+", distance : "+getDistance_soleil()
            +", diamètre : "+getDiametre(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public double calculerDistance(Planete p){
        return Math.abs(p.getDistance_soleil()-distance_soleil);
    }

    public int compareTo(Planete t) {
        int result = this.nom.compareTo(t.getNom());
        return result;
    }
}
