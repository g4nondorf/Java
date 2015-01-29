/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class TestFraction {
    
    public static void main(String[] args){
        
        for(int i = 2; i<=10; i++){
            Fraction frac = new Fraction();
            frac.creerFraction(1, i);
            System.out.println(frac.toString());
            //System.out.println(frac);
        }
        
    }
    
}
