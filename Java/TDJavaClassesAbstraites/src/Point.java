
public class Point {
    private double x,y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    @Override
    public String toString(){
        String s = "";
        s = "X = "+this.getX()+"\nY = "+this.getY();
        return s;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean b = false;
        if (obj instanceof Point) {
            if (this.x == ((Point)obj).x && this.y == ((Point)obj).y){
                b = true;
            }
        }
        return b;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }
}
