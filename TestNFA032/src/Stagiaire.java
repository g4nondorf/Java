/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Stagiaire extends Employe {
    private double gratification;
    
    @Override
    public double getSalaire(){
        return this.gratification;
    }
}
