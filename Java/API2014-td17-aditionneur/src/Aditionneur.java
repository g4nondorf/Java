/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class Aditionneur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double somme = 0;
        for(int i = 0; i < args.length; i++){
            double d = Double.parseDouble(args[i]);
            somme += d;
            System.out.print(d + (i==args.length-1?" = " : " + "));
        }
        System.out.println(somme);
    }
}
