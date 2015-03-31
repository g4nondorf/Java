/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Commercial extends Employe {
    private double salaireMin;
    private double chiffreAffaire;
    private static double pourcentage;

    public void setSalaireMin(double salaireMin) {
        this.salaireMin = salaireMin;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public static void setPourcentage(double pourcentage) {
        Commercial.pourcentage = pourcentage;
    }

    public double getSalaireMin() {
        return salaireMin;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public static double getPourcentage() {
        return pourcentage;
    }
    
    @Override
    public double getSalaire(){
        return Commercial.pourcentage*this.chiffreAffaire + this.salaireMin;
    }
}
