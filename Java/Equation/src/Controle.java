/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Controle {
    
    public static void main(String[] args){
        
        Equation equa = new Equation();
        equa.créerEquation(equa);
        float a1 = equa.getA();
        float b1 = equa.getB();
        float c1 = equa.getC();
        equa.resoudreEquation(a1, b1, c1);
        
    }
    
}
