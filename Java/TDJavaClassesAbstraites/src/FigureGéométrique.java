
abstract public class FigureGéométrique {
    protected Point centre;
    
    public FigureGéométrique(Point centre){
        this.centre = centre;
    }
    
    public Point getPoint(){
        return this.centre;
    }
    
    public void translater(double x, double y){
        this.centre.setX(this.centre.getX()+x);
        this.centre.setY(this.centre.getY()+y);
    }
    
    abstract public double getPerimetre();
    abstract public double getAire();
    @Override
    abstract public boolean equals(Object obj);
    @Override
    abstract public String toString();

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
}
