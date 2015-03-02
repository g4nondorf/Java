
public class Carré extends FigureGéométrique{
    private double cote;
    
    public Carré(double cote){
        super(new Point(0, 0));
        this.cote = cote;
    }
    
    public Carré(double cote, Point centre){
        super(centre);
        this.cote = cote;
    }


    @Override
    public double getPerimetre() {
        return 4.0 * cote;
    }

    @Override
    public double getAire() {
        return cote * cote;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj instanceof Carré) {
            if ((((Carré)obj).cote == this.cote) && (this.centre.equals(((Carré)obj).centre))) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.cote) ^ (Double.doubleToLongBits(this.cote) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        String s = "";
        s = "Côté: "+this.cote+"\nPérimètre: "+this.getPerimetre()+"\nAire: "+this.getAire()+"\nCoordonnées du centre:\n"+super.getPoint().toString();
        return s;
    }

}
