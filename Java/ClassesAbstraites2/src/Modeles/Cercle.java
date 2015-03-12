package Modeles;

import ClassesAbstraites.Forme;
import Interfaces.Coloriable;
import Interfaces.Perimetrable;
import Interfaces.Surfaçable;


public class Cercle extends Forme implements Perimetrable, Coloriable, Surfaçable {

    private double rayon;
    private Point centre;
    private String couleur = "Incolore";

    public Cercle(double rayon) {
        this.centre = new Point(0, 0);
        this.rayon = rayon;
    }

    public Cercle(double rayon, Point centre) {
        this.centre = new Point(0, 0);
        this.rayon = rayon;
    }

    @Override
    public double getSurface(){
        return Math.pow(rayon, 2) * Math.PI;
    }
    
    @Override
    public void translater(double dx, double dy) {
        this.centre.translater(dx, dy);
    }

    @Override
    public void afficher() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String s = "Cercle:\nRayon: " + this.rayon + "\nCentre: X: " + this.centre.getX() + " ;Y: " + this.centre.getY() + "\n";
        return s;
    }

    @Override
    public double getPerimetre() {
        return (double) Math.round((Math.PI * 2.0 * this.rayon) * 100) / 100;
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
