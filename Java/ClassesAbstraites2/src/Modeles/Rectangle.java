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
public class Rectangle extends Polygone implements Surfacable{
    @Override
    public double getSurface() {
        return sommets[0].distanceTo(sommets[1])*sommets[1].distanceTo(sommets[2]);
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
