/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class CouplesHomogenes<T> {
    private T a;
    private T b;

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public void setA(T a) {
        this.a = a;
    }

    public void setB(T b) {
        this.b = b;
    }
    
    public CouplesHomogenes(T a, T b){
        this.a = a;
        this.b = b;
    }
    
    public void echanger(){
        T temp = a;
        a = b;
        b = temp;
    }
}
