
import Modeles.Cercle;
import Modeles.EnsembleLignes;
import Modeles.Point;
import Modeles.Polygone;
import Modeles.Segment;
import Modeles.Structure;
import Modeles.Triangle;
import Modeles.Carre;
import Modeles.Rectangle;


public class TDFormesGeo {

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,3);
        Point p3 = new Point(2,3);
        Point p4 = new Point(2,0);
        
        Structure struct = new Structure();

        Polygone poly1 = new Polygone();
        poly1.addSommet(new Point(3, 2));
        poly1.addSommet(new Point(3, 4));
        poly1.addSommet(new Point(6, 4));
        poly1.addSommet(new Point(6, 2));
        poly1.afficher();

        struct.add(poly1);
        

        Triangle poly2 = new Triangle();
        poly2.addSommet(new Point(2, -3));
        poly2.addSommet(new Point(6, -6));
        poly2.addSommet(new Point(2, -9));
        poly2.afficher();

        struct.add(poly2);
        
        Rectangle poly3 = new Rectangle();
        poly3.addSommet(p1);
        poly3.addSommet(p2);
        poly3.addSommet(p3);
        poly3.addSommet(p4);
        poly3.afficher();

        struct.add(poly3);

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
        System.out.print("\n");
        struct.afficherSurface();
        System.out.println("\n" + poly2.compareTo(poly3));//Test sur le compare
        System.out.println(poly2.compareTo(c));
        System.out.println(poly2.compareTo(ens));
        
        /*p1.translater(5, 5);      //Test sur le clonage!!!!
        p2.translater(5, 5);
        p3.translater(5, 5);
        p4.translater(5, 5);
        System.out.println("\n" + poly3.getPerimetre());*/
    }
}
