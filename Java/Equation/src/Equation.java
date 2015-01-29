/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Equation {

    public Equation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private float a;
    private float b;
    private float c;

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setC(float c) {
        this.c = c;
    }
    
    public void resoudreEquation(){
        
        float delta = (b * b)-(4 * a * c);
        
        if(delta > 0)
        {
            float x1 = ((-b + (float)Math.sqrt(delta)) / 2.0F*a);
            float x2 = ((-b - (float)Math.sqrt(delta)) / 2.0F*a);
            System.out.println("Il y a deux solution a l'equation \nx1 = " + x2 + " et x2 = " + x2);
        }else if(delta == 0)
        {
            float x = (-b/(2*a));
            System.out.println("Il y a une seule solution x = " + x);
        }else if(delta < 0)
        {
            delta = -delta;
            a = 2*a;
            System.out.println("Il y a deux solution IMAGINAIRE a l'equation \n"
                    + "x1 = (-" + b + "+ i*\u221A(" + delta + ")/"+ a + " et x2 = (-" + b + "- i*\u221A(" + delta + ")/"+ a);
        }else
        {
            System.out.println("Il y a un probléme");
        }
        
    }
    
}
