/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;
import Modeles.*;
/**
 *
 * @author l.glimois
 */
public class AfficherPlanetesVue {
    public void afficher(Planete[] planetes){
        for(int i=0;i<planetes.length;i++){
            System.out.println(planetes[i].toString());
        }
    }
}
