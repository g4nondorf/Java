/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import Actions.ActionCreerZip;
import Actions.ActionAjoutFile;
import Actions.ActionSearchZip;
import Actions.ActionSauvegarderZip;
import Actions.ActionOuvrirZip;
import Actions.ActionExtraireZip;
import Actions.MyZipException;
import Entites.ZipArchive;
import vues.VueAjoutFichier;
import vues.VueErreur;
import vues.VueLectureZip;
import vues.VueMenu;
import vues.VueSauvegarde;
import vues.VueZip;



/**
 * 
 * @author Hadj
 */
public class ControleurPrincipal {
  public static void main(String[] args)
  {
        int choix = 6;
        VueMenu menu = new VueMenu();
        do{
            choix = menu.lireChoix();
            try{
                switch(choix){
                    case 0 ://créer
                       ZipArchive z1 = (new ActionCreerZip()).executer();
                       (new VueZip()).afficher(z1);
                       break;
                    case 1 ://ajouter
                       String fichier1 = (new VueAjoutFichier()).lire();
                        ZipArchive z2  =  (new ActionAjoutFile()).executer(fichier1);
                       (new VueZip()).afficher(z2);
                       break;
                    case 2 ://afficher
                       ZipArchive z3 =  (new ActionSearchZip()).executer();
                      (new VueZip()).afficher(z3);
                       break;
                    case 3 ://sauvegarde
                       String fichier2 = (new VueSauvegarde()).lire();
                      (new ActionSauvegarderZip()).executer(fichier2);
                       break;
                    case 4 ://ouvrir
                       String fichier3 = (new VueLectureZip()).lire();
                      ZipArchive z4 = (new ActionOuvrirZip()).executer(fichier3);
                      (new VueZip()).afficher(z4);
                       break;
                    case 5 ://extraire
                      (new ActionExtraireZip()).executer();
                       break;
                }

            }catch(MyZipException e){
                (new VueErreur()).afficher(e);
            }
        }while (choix != 6);
  }

}
