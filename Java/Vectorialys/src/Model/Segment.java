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
    
    public void rotation(double angle, double x, double y){//effectue une rotation du segment et enregistre les nouvelles données
        double x1 = s1.getX();
        double y1 = s1.getY();
        double x2 = s2.getX();
        double y2 = s2.getY();
        
        double radians = Math.toRadians(angle);
        
        x1 = (x1-x)*Math.cos(radians)-(y1-y)*Math.sin(radians)+x;
        y1 = (x1-x)*Math.sin(radians)+(y1-y)*Math.cos(radians)+y;
        
        x2 = (x2-x)*Math.cos(radians)-(y2-y)*Math.sin(radians)+x;
        y2 = (x2-x)*Math.sin(radians)+(y2-y)*Math.cos(radians)+y;
        
        s1.setX(x1);
        s1.setY(y1);
        
        s2.setX(x2);
        s2.setY(y2);
        
        Canvas.setSeg(this);//enregistrement des nouvelles données
    }
    
    public double longueur(){//calcul la longueur du segment et retourne un double
        double x1 = s1.getX();
        double y1 = s1.getY();
        double x2 = s2.getX();
        double y2 = s2.getY();
        
        double longr = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
        
        return longr;
    }
    
}
