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
    
    public void créerEquation(Equation equ){
        System.out.println("Rentrer les valeur a, b, c tel que ax²+bx+c = 0");
        System.out.print("a : ");
        equ.setA(Clavier.lireFloat());
        System.out.print("b : ");
        equ.setB(Clavier.lireFloat());
        System.out.print("c : ");
        equ.setC(Clavier.lireFloat());
    }
    
    public void resoudreEquation(float a1, float b1, float c1){
        
        float delta = (b1 * b1)-(4 * a1 * c1);
        
        if(delta > 0)
        {
            float x1 = ((-b1 + (float)Math.sqrt(delta)) / 2.0F*a1);
            float x2 = ((-b1 - (float)Math.sqrt(delta)) / 2.0F*a1);
            System.out.println("Il y a deux solution a l'equation \nx1 = " + x2 + " et x2 = " + x2);
        }else if(delta == 0)
        {
            float x = (-b1/(2*a1));
            System.out.println("Il y a une seule solution x = " + x);
        }else if(delta < 0)
        {
            delta = -delta;
            a1 = 2*a1;
            System.out.println("Il y a deux solution IMAGINAIRE a l'equation \n"
                    + "x1 = (-" + b1 + "+ i*\u221A(" + delta + ")/"+ a1 + " et x2 = (-" + b1 + "- i*'\u221A'(" + delta + ")/"+ a1);
        }else
        {
            System.out.println("Il y a un probléme");
        }
        
    }
    
}
