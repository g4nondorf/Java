/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Complexe {
    private double u, v;
    
    public Complexe(double x, double y){
        u = x;
        v = y;
    }
    
    public String chaine(){
        return u + "+" + v + "i";
    }
}
