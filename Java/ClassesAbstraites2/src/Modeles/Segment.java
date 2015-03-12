package Modeles;


import Interfaces.Coloriable;


public class Segment implements Coloriable{
    
    Point p1, p2;
    private String couleur = "Incolore";
    
    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public double getLongueur() {
        return p1.distanceTo(p2);
    }
    
    public void translater(double dx, double dy) {
        this.p1.translater(dx, dy);
        this.p2.translater(dx, dy);
    }
    
    @Override
    public String getCouleur() {
        return couleur;
    }

    @Override
    public void setCouleur(String c) {
        this.couleur = c;
    }
}
