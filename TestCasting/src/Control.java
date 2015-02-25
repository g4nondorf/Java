
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Control {
    public static void main(String[] args){
        Fraction v1 = new Fraction(10, 20);
        System.out.println(v1.chaine());
        Fraction v2 = new Fraction(5, 7);
        System.out.println(v2.chaine());
        Fraction v3 = v1.add(v2);
        
        if(v3 != null){
            System.out.println(v3.chaine());
        }
        
        System.out.println("\nLiaison statique et dynamique");
        Random r =  new Random();
        Object[] tab = new Object[10];
        for(int i = 0; i < 10; i++){
            if(Math.random()>0.5){
                tab[i] = new Fraction(r.nextInt(20),r.nextInt(20));
            }else{
                double a = Math.round(r.nextDouble()*1000);
                double b = Math.round(r.nextDouble()*1000);
                tab[i] = new Complexe(a/1000,b/1000);
            }
        }
        
        for(int i = 0; i < 10; i++){
            if(tab[i] instanceof Fraction){
                System.out.println(((Fraction)tab[i]).chaine());
            }else{
                System.out.println(((Complexe)tab[i]).chaine());
            }
        }
        
        System.out.println("\nMéthode equals");
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction(1,2);
        Fraction c = new Fraction(2,4);
        boolean b1 = a == b;
        boolean b2 = a.equals(b);
        boolean b3 = a.equals(c);
        System.out.println("b1 : " + b1);
        System.out.println("b2 : " + b2);
        System.out.println("b3 : " + b3);
    }
}
