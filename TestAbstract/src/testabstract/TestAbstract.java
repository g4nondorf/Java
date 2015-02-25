/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabstract;

import java.util.Random;

/**
 *
 * @author Moi
 */
public class TestAbstract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[] tab = new Animaux[10];
        Random r = new Random();
        //remplissage d'un tableau d'animaux
        for(int i = 0; i < 10; i++){
            int h = r.nextInt(3);
            switch(h){
                case 0 :
                    tab[i] = new Chien();
                    break;
                case 1 :
                    tab[i] = new Lapin();
                    break;
                case 2 :
                    tab[i] = new Chat();
                    break;
            }
        }
        
        //Faire s'éxprimer les animaux
        for(int i = 0; i<10; i++){
            if (!(tab[i] instanceof Lapin)){
                AnimauxAvecCris avc = (AnimauxAvecCris)tab[i];
                avc.crier();
            }
        }
    }
    
}
