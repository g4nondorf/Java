/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Moi
 */
public class Segment {
    
    private Sommet s1;
    
    private Sommet s2;

    public void setS1(Sommet s1) {
        this.s1 = s1;
    }

    public void setS2(Sommet s2) {
        this.s2 = s2;
    }

    public Sommet getS1() {
        return s1;
    }

    public Sommet getS2() {
        return s2;
    }

    public Segment(Sommet s1, Sommet s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    
    public void rotation(double angle){
        double x1 = s1.getX();
        double y1 = s1.getY();
        double x2 = s2.getX();
        double y2 = s2.getY();
        
        x1 = x1*Math.cos(angle)-y2*Math.sin(angle);
        y1 = y1*Math.cos(angle)-x2*Math.sin(angle);
        
        s1.setX(x1);
        s1.setY(y1);
        
        Canvas.setSeg(this);
    }
    
    public double longueur(){
        double x1 = s1.getX();
        double y1 = s1.getY();
        double x2 = s2.getX();
        double y2 = s2.getY();
        
        double longr = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
        
        return longr;
    }
    
}
