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
        
        VueEquation vue = new VueEquation();
        Equation equa = vue.creerEquation();
        equa.resoudreEquation();
        
    }
    
}
