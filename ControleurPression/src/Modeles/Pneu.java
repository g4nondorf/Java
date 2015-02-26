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
public class Pneu {
    private double pression;
    
    public boolean comparerPression(Pneu p){
        boolean resu = false;
        double compar = (Math.max(this.pression, p.pression)-Math.min(this.pression, p.pression))/Math.max(this.pression, p.pression);
        
        if(compar < 0.03){
            resu = true;
        }
        
        return resu;
    }

    public void setPression(double pression) {
        this.pression = pression;
    }

    public double getPression() {
        return pression;
    }
    
    public Pneu(double pression){
        this.pression = pression;
    }
    
    public void ajuster(double p){
        this.pression += p;
    }
    
    public Etat_Pneu etatPneu(boolean position){
        Etat_Pneu etatPneu;
        double pressionAjust = 0;
        int etat = 0;
        
        if(position){
            if(pression < Voiture.PRESSION_AVANT_Min){
                etat = 1;
                pressionAjust = Voiture.PRESSION_AVANT_Min-pression;
            }else if(pression > Voiture.PRESSION_AVANT_Max){
                etat = 2;
                pressionAjust = Voiture.PRESSION_AVANT_Max-pression;
            }else{
                etat = 0;
            }
        }else{
            if(pression < Voiture.PRESSION_ARRIERE_Min){
                etat = 1;
                pressionAjust = Voiture.PRESSION_ARRIERE_Min-pression;
            }else if(pression > Voiture.PRESSION_ARRIERE_Max){
                etat = 2;
                pressionAjust = Voiture.PRESSION_ARRIERE_Max-pression;
            }else{
                etat = 0;
            }
        }
        
        return etatPneu = new Etat_Pneu(etat, pressionAjust);
    }
}
