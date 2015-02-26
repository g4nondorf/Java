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
public class Voiture {
    private Voiture instance;
    private Pneu[] pneus;
    public static final double PRESSION_AVANT_Min = 2.0;
    public static final double PRESSION_AVANT_Max = 2.4;
    public static final double PRESSION_ARRIERE_Min = 2.0;
    public static final double PRESSION_ARRIERE_Max = 2.2;
    
    public Voiture getInstance() {
        return instance;
    }

    public void setPneus(Pneu[] pneus) {
        this.pneus = pneus;
    }

    public Pneu[] getPneus() {
        return pneus;
    }
    
    private Voiture(Pneu[] pneus){
        this.pneus = pneus;
    }
    
    public void Creation(Pneu[] pneus){
        instance = new Voiture(pneus);
    }
    
    public boolean[] verifierEqui(){
        Pneu[] p = this.instance.getPneus();
        boolean[] equilibreTotal = new boolean[2];
        equilibreTotal[0] = p[0].comparerPression(p[1]);
        equilibreTotal[1] = p[2].comparerPression(p[3]);
        return equilibreTotal;
    }
    
    public Etat_Pneu[] diagnostique(){
        Pneu[] p = this.instance.getPneus();
        Etat_Pneu[] etatPneu = new Etat_Pneu[4];
        
        for(int i = 0; i < 4; i++){
            etatPneu[i] = p[i].etatPneu(i<2);
        }
        
        return etatPneu;
    }
}
