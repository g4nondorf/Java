/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Fraction {
    
    private int denom;
    private int num;

    @Override
    public String toString() {
        return "(" + num + "/" + denom + ") = " + afficherResultat();
    }
    
    public double afficherResultat(){
        double resultat;
        resultat = ((double)num/(double)denom);
        resultat = (double)Math.round(resultat*100)/100;
        return resultat;
    }
    
    public Fraction creerFraction(int num, int denom){
        Fraction frac = new Fraction();
        this.num = num;
        this.denom= denom;
        return frac;
    }
    
}
