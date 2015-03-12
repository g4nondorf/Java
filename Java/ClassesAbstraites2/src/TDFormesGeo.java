
import Modeles.Cercle;
import Modeles.EnsembleLignes;
import Modeles.Point;
import Modeles.Polygone;
import Modeles.Segment;
import Modeles.Structure;


public class TDFormesGeo {

    public static void main(String[] args) {
        Structure struct = new Structure();

        Polygone poly1 = new Polygone();
        poly1.addSommet(new Point(3, 2));
        poly1.addSommet(new Point(3, 4));
        poly1.addSommet(new Point(6, 4));
        poly1.addSommet(new Point(6, 2));
        poly1.afficher();

        struct.add(poly1);

        Polygone poly2 = new Polygone();
        poly2.addSommet(new Point(2, -3));
        poly2.addSommet(new Point(6, -6));
        poly2.addSommet(new Point(2, -9));
        poly2.afficher();

        struct.add(poly2);

        Cercle c = new Cercle(2.0, new Point(-3, 0));
        c.afficher();

        struct.add(c);

        EnsembleLignes ens = new EnsembleLignes();
        ens.addLigne(new Segment(new Point(0, 0), new Point(2, 8)));
        ens.addLigne(new Segment(new Point(2, 8), new Point(-4, 8)));
        ens.addLigne(new Segment(new Point(-4, 8), new Point(0, 9)));
        ens.afficher();

        struct.add(ens);

        struct.afficherTout();
        struct.afficherPerimetres();
    }
}
