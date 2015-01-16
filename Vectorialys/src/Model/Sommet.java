/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Moi
 */
public class Sommet {
    
    private double x, y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Sommet(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void translater(double val_trans){
        x = x + val_trans;
        y = y + val_trans;
    }
    
}
