/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import Interfaces.Surfacable;

/**
 *
 * @author Moi
 */
public class Triangle extends Polygone implements Surfacable {
    @Override
    public double getSurface() {
        double a = sommets[0].distanceTo(sommets[1]);
        double b = sommets[1].distanceTo(sommets[2]);
        double c = sommets[2].distanceTo(sommets[0]);
        double d = 0.5*(a+b+c);
        return Math.sqrt(d*(d-a)*(d-b)*(d-c));
    }
    
    @Override
    public int compareTo(Object o){
        int resu = 100;
        if(o instanceof Surfacable){
            if(this.getSurface() < ((Surfacable)o).getSurface()){
                resu = -1;
            }else if(this.getSurface() > ((Surfacable)o).getSurface()){
                resu = 1;
            }else{
                resu = 0;
            }
        }
        return resu;
    }
}
