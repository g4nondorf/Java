package Modeles;

import ClassesAbstraites.Forme;
import Interfaces.Perimetrable;


public class Structure {

    private Forme[] formes = new Forme[100];
    private int nbFormes = 0;

    public Forme[] getFormes() {
        return formes;
    }

    public void add(Forme f) {
        if (nbFormes < formes.length) {
            formes[nbFormes] = f;
            nbFormes++;
        } else {
            System.out.println("Impossible, plus de place");
        }
    }

    public void afficherTout() {
        for (int i = 0; i < nbFormes; i++) {
            formes[i].afficher();
        }
    }

    public void afficherPerimetres() {
        for (int i = 0; i < nbFormes; i++) {
            if (formes[i] instanceof Perimetrable) {
                System.out.println("Forme n°" + (i + 1) + ": " + ((Perimetrable) formes[i]).getPerimetre());
            } else {
                System.out.println("Pas de périmètre à définir !!");
            }
        }
    }
}
