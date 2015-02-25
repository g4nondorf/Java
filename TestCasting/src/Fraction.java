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
    private int u,v;
    
    public Fraction(int x, int y){
       u = x;
       v = y;
    }
    
    public String chaine(){
        return u + "/" + v;
    }
    
    public Fraction add(Object obj){
        if(obj instanceof Fraction){
            Fraction frac = new Fraction(this.u*((Fraction)obj).v + ((Fraction)obj).u*this.v , this.v*((Fraction)obj).v);
            return frac;
        }else{
            return null;
        }
    }
    
    public boolean equals(Object obj){
        return ((this.u*((Fraction)obj).v) == (((Fraction)obj).u*this.v));
    }
}
