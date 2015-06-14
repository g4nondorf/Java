/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Actions;

import Entites.ZipArchive;
import IO.StoreZipFile;
import java.io.IOException;

/**
 *
 * @author Hadj
 */
public class ActionSauvegarderZip {
    public void executer(String fichier) throws MyZipException{
        ZipArchive zip = ZipArchive.getZipArchive();
        StoreZipFile writer = new StoreZipFile();
        try{
            writer.write(zip, fichier);
        }catch(IOException e){
            throw new MyZipException("Ecriture impossible");
        }
    }

}
