/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import IO.Clavier;
/**
 * 
 * @author Hadj
 */
public class VueMenu {
  public int lireChoix() {
			System.out.println("0 : Créer un nouveau Zip");
			System.out.println("1 : ajouter un fichier ou un répertoire");
			System.out.println("2 : Afficher le contenu du zip");
			System.out.println("3 : Sauvegarder le fichier zip");
			System.out.println("4 : Ouvrir un fichier zip");
			System.out.println("5 : Extraire le contenu du zip");
			System.out.println("6 : Quitter");
			System.out.print("Quel est votre choix ? ");
			int choix = Clavier.lireInt();
			return choix;
  }

}
