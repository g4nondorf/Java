package Modeles;

import ClassesAbstraites.Forme;


public class EnsembleLignes extends Forme {

    private Segment[] tabLignes = new Segment[100];
    private int nbLignes = 0;

    public void addLigne(Segment s) {
        tabLignes[nbLignes] = s;
        nbLignes++;
    }

    @Override
    public void translater(double dx, double dy) {
        if (nbLignes > 0) {
            for (int i = 0; i < nbLignes; i++) {
                tabLignes[i].translater(dx, dy);
            }
        }
    }

    @Override
    public void afficher() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String s = "Ensemble de lignes:\n";
        if (nbLignes > 0) {
            for (int i = 0; i < nbLignes; i++) {
                s += "Segment n°" + i + ":\nX1: " + tabLignes[i].p1.getX() + " ;Y1: " + tabLignes[i].p1.getY() + "\nX2: " + tabLignes[i].p2.getX() + " ;Y2: " + tabLignes[i].p2.getY() + "\n\n";
            }
            return s;
        } else {
            return null;
        }
    }
}
