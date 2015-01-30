/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class VueEquation {
    
    public Equation creerEquation(){
        System.out.println("Rentrer les valeur a, b, c tel que ax²+bx+c = 0");
        System.out.print("a : ");
        float a = Clavier.lireFloat();
        System.out.print("b : ");
        float b = Clavier.lireFloat();
        System.out.print("c : ");
        float c = Clavier.lireFloat();
        Equation equ = new Equation(a, b, c);
        return equ;
    }
    
}
