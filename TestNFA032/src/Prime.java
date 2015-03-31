/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Prime {
    private String intitule;
    private double montant;
    private boolean période;

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setPériode(boolean période) {
        this.période = période;
    }

    public String getIntitule() {
        return intitule;
    }

    public double getMontant() {
        return montant;
    }

    public boolean isPériode() {
        return période;
    }
}
