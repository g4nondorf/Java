/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Exception {
    public static void main(String[] args){
        boolean reussi = false;
        do{
            int n = Clavier.lireInt();
            try{
                int m = 10/n;
                reussi = true;
            }catch(ArithmeticException e){
                System.out.println("0 n'est pas accépter pour une division");
            }
        }while(!reussi);
    }
}
