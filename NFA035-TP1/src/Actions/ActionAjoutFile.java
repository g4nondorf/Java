/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Actions;

import Entites.Fichier;
import Entites.Repertoire;
import Entites.ZipArchive;
import Entites.ZipContent;
import java.io.File;

/**
 *
 * @author Hadj
 */
public class ActionAjoutFile {
    public ZipArchive executer(String s) throws MyZipException {
        ZipArchive zip = ZipArchive.getZipArchive();
        if(zip == null){
            throw new MyZipException("Aucun ZipArchive créé ! ");
        }
        File f = new File(s);
        if(! f.exists()){
            throw new MyZipException("Fichier " + s + " n'existe pas ! ");
        }
        zip.add(f, s);

        return zip;
    }
}
