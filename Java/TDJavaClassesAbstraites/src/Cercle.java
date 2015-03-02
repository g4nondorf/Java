
public class Cercle extends FigureGéométrique {

    private double rayon;

    public Cercle(double rayon) {
        super(new Point(0, 0));
        this.rayon = rayon;
    }

    public Cercle(double rayon, Point centre) {
        super(centre);
        this.rayon = rayon;
    }

    @Override
    public double getPerimetre() {
        return Math.PI * rayon * 2.0;
    }

    @Override
    public double getAire() {
        return Math.PI * (rayon * rayon);
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj instanceof Cercle) {
            if (((Cercle) obj).rayon == this.rayon && this.centre.equals(((Cercle) obj).centre)){
                b = true;
            }
        }
        return b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.rayon) ^ (Double.doubleToLongBits(this.rayon) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        String s = "";
        s = "Rayon: " + this.rayon + "\nPérimètre: " + this.getPerimetre() + "\nAire: " + this.getAire() + "\nCoordonnées du centre: \n" + super.getPoint().toString();
        return s;
    }
}