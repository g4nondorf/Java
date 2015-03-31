
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Cadre extends Employe {
    private ArrayList<Prime> listePrimes = new ArrayList<Prime>();
    private double forfait;

    public void setListePrimes(ArrayList<Prime> listePrimes) {
        this.listePrimes = listePrimes;
    }

    public void setPrime(Prime e) {
        this.listePrimes.add(e);
    }

    public void setForfait(double forfait) {
        this.forfait = forfait;
    }

    public ArrayList<Prime> getListePrimes() {
        return listePrimes;
    }

    public double getForfait() {
        return forfait;
    }
    
    @Override
    public double getSalaire(){
        double salaire = this.forfait;
        for(Prime p : listePrimes){
            if(p.isPériode()){
                salaire += p.getMontant();
            }else{
                salaire += p.getMontant()/12;
            }
        }
        return salaire;
    }
}
