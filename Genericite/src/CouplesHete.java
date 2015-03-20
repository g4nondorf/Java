/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class CouplesHete<T,S> {
    private T a;
    private S b;

    public void setA(T a) {
        this.a = a;
    }

    public void setB(S b) {
        this.b = b;
    }

    public T getA() {
        return a;
    }

    public S getB() {
        return b;
    }
    
    public CouplesHete(T a, S b){
        this.a = a;
        this.b = b;
    }
}
