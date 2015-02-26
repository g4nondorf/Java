/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

/**
 *
 * @author Moi
 */
public class Form_Initialisation {
    private double p1;
    private double p2;
    private double p3;
    private double p4;

    public double getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
    }

    public double getP3() {
        return p3;
    }

    public double getP4() {
        return p4;
    }
    
    public Form_Initialisation(double p1, double p2, double p3, double p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
}
