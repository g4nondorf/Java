package Modeles;

import ClassesAbstraites.Forme;
import Interfaces.Coloriable;
import Interfaces.Perimetrable;


public class Polygone extends Forme implements Perimetrable, Coloriable {
    
    private Point[] sommets = new Point[100];
    private int nbSommets = 0;
    private String couleur = "Incolore";
    
    public void addSommet(Point s) {
        sommets[nbSommets] = s;
        nbSommets++;
    }
    
    @Override
    public void translater(double dx, double dy) {
        if (nbSommets > 0) {
            for (int i = 0; i < nbSommets; i++) {
                sommets[i].translater(dx, dy);
            }
        } else {
            System.out.println("Pas de sommets définis !!");
        }
    }
    
    @Override
    public void afficher() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        String s = "Polygone:\n";
        if (nbSommets > 0) {
            for (int i = 0; i < nbSommets; i++) {
                s += "Sommet n°" + (i + 1) + ":\nX" + (i + 1) + ": " + sommets[i].getX() + " ;Y" + (i + 1) + ": " + sommets[i].getY() + "\n";
            }
            return s;
        } else {
            return null;
        }
    }
    
    @Override
    public double getPerimetre() {
        int p = 0;
        if (nbSommets > 2) {
            for (int i = 0; i < nbSommets - 1; i++) {
                p += sommets[i].distanceTo(sommets[i + 1]);
            }
            p += sommets[nbSommets - 1].distanceTo(sommets[0]);
        }
        return p;
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
