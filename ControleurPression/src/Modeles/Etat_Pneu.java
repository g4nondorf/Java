/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

/**
 *
 * @author Moi
 */
public class Etat_Pneu {
    private int etat;
    private double pressionAjust;

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setPressionAjust(double pressionAjust) {
        this.pressionAjust = pressionAjust;
    }

    public int getEtat() {
        return etat;
    }

    public double getPressionAjust() {
        return pressionAjust;
    }
    
    public Etat_Pneu(int etat, double pression){
        this.pressionAjust = pression;
        this.etat = etat;
    }
}
