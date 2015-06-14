/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vues;

import Entites.Repertoire;
import Entites.ZipArchive;
import Entites.ZipContent;
import java.util.Set;

/**
 *
 * @author Hadj
 */
public class VueZip {
    public void afficher(ZipArchive zip){
        String retrait = "";
        Set<ZipContent> set = zip.getListContents();
        for(ZipContent z : set){
            afficher(z, retrait);
        }
    }

    public void afficher(ZipContent z, String r){
       System.out.println(r + z.getNom());
       if(z instanceof Repertoire){
            r += "\t";
            Set<ZipContent> liste = ((Repertoire) z).getListContents();
            for(ZipContent c : liste){
                afficher(c, r);
            }
        }

    }
}
