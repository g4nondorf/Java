/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vues.*;
import Actions.*;
import Modeles.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author l.glimois
 */
public class ControleurPrincipal {

    public static void main(String[] args) {
        int choix = 0;
        do {
            MenuVue VM = new MenuVue();
            choix = VM.afficher();
            switch (choix) {
                case 0:
                    AjoutPlaneteVue VI = new AjoutPlaneteVue();
                    AjoutPlaneteAction AI = new AjoutPlaneteAction();
                    AI.executer(VI.saisir());
                    break;
                case 1:
                    if(SystemeSolaire.getInstance() != null){
                        ChercherPlaneteVue CV = new ChercherPlaneteVue();
                        ChercherPlaneteAction CA = new ChercherPlaneteAction();
                        AfficherPlanetesVue APV = new AfficherPlanetesVue();
                        APV.afficher(CA.executer(CV.saisir()));
                    }else{
                        System.out.println("Pas de planete a dans la base de données");
                    }
                    break;
                case 2:
                    TrierPlanetesVues TV = new TrierPlanetesVues();
                    TrierPlaneteAction TA = new TrierPlaneteAction();
                    AfficherTrieVue ATV = new AfficherTrieVue();
                    ATV.afficher(TA.executer(TV.saisir()));
                    break;
                case 3:
                    if(SystemeSolaire.getInstance() != null){
                        AfficherDistanceVue AV = new AfficherDistanceVue();
                        CalculerDistanceVue CDV = new CalculerDistanceVue();
                        CalculDistanceAction CDA = new CalculDistanceAction();
                        AV.afficher(CDA.executer(CDV.saisir()));
                    }else{
                        System.out.println("Pas de planete a comparer");
                    }
                    break;
                case 4:
                    AfficherPlanetesVue APV2 = new AfficherPlanetesVue();
                    SystemeSolaire ss = SystemeSolaire.getInstance();
                    if(ss.getInstance() != null){
                        Iterator<Planete> iterator = ss.iterator();
                        Planete[] planetes = new Planete[ss.size()];
                        for(int i=0;i<ss.size();i++){
                            planetes[i]=iterator.next();
                        }
                        APV2.afficher(planetes);
                    }else{
                        System.out.println("Pas de planete a afficher");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("erreur");
            }
        } while (choix != 5);
    }
}
