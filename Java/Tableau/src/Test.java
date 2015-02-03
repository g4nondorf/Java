/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Test {
    public static void main(String[] args){
        Tableau tab = new Tableau(1000);
        System.out.println("Taille : " + tab.getTaille());
        System.out.println("Max : " + tab.getMax());
        System.out.println("Min : " + tab.getMin());
        System.out.println("Moyenne : " + tab.getMoyenne());
        /*System.out.print("Quel valeur? : ");
        int valeur = Clavier.lireInt();
        System.out.print("A quelle place? : ");
        int place = Clavier.lireInt();
        tab.setElement(place, valeur);
        System.out.println(tab.getElement(place) + " a bien été ajouté");*/
        System.out.println("Il y a " + tab.getNbSousMoy() + " elements sous la moyenne.");
        System.out.println("Il y a " + tab.getNbSurMoy() + " elements sous la moyenne.");
        tab.trierTab();
        System.out.println(tab);
    }
}
