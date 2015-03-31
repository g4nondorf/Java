/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Salarié extends Employe {
    private int serviceStatutaire;
    private int serviceReel;
    private static double tarifHoraire;
    private static double tarifDiff;

    public static void setTarifHoraire(double tarifHoraire) {
        Salarié.tarifHoraire = tarifHoraire;
    }

    public static void setTarifDiff(double tarifDiff) {
        Salarié.tarifDiff = tarifDiff;
    }

    public static double getTarifHoraire() {
        return tarifHoraire;
    }

    public static double getTarifDiff() {
        return tarifDiff;
    }
    
    @Override
    public double getSalaire(){
        double resu = 0;
        if(this.serviceReel<this.serviceStatutaire){
            resu = (this.serviceReel-this.serviceStatutaire)*getTarifHoraire();
        }else{
            resu = (this.serviceReel-this.serviceStatutaire)*getTarifDiff();
        }
        return this.serviceStatutaire*getTarifHoraire() + resu;
    }
}
