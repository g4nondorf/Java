/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

/**
 *
 * @author l.glimois
 */
public class Form_Creation {
    private String nom;
    private long distance;
    private int diametre;

    public String getNom() {
        return nom;
    }

    public long getDistance() {
        return distance;
    }

    public int getDiametre() {
        return diametre;
    }

    public Form_Creation(String nom, long distance, int diametre) {
        this.nom = nom;
        this.distance = distance;
        this.diametre = diametre;
    }
}
