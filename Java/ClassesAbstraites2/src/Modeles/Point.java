package Modeles;

import Interfaces.Coloriable;


public class Point implements Coloriable, Cloneable{

    private double x, y;
    private String couleur = "Incolore";

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void translater(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }
    
    @Override
    public String getCouleur() {
        return couleur;
    }

    @Override
    public void setCouleur(String c) {
        this.couleur = c;
    }
    
    public Object clone(){
        return new Point(this.getX(),this.getY());
    }
}
