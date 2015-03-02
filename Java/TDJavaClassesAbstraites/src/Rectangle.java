
public class Rectangle extends FigureGéométrique{
    private double longueur, largeur;

    public Rectangle(double longueur, double largeur) {
        super(new Point(0,0));
        this.longueur = longueur;
        this.largeur = largeur;
    }
    
    public Rectangle(double longueur, double largeur, Point centre){
        super(centre);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double getPerimetre() {
        return 2.0 * longueur + 2.0 * largeur; 
    }

    @Override
    public double getAire() {
        return longueur * largeur;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if(obj instanceof Rectangle){
            if(((Rectangle)obj).longueur == this.longueur && ((Rectangle)obj).largeur == this.largeur && this.centre.equals(((Cercle) obj).centre)){
                b = true;
            }
        }
        return b;
    }

    @Override
    public String toString() {
        String s = "";
        s = "Longueur: "+this.longueur+"\nLargeur: "+this.largeur+"\nPérimètre: "+this.getPerimetre()+"\nAire: "+this.getAire()+"\nCoordonnées du centre:\n"+super.getPoint().toString();
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

}
