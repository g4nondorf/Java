/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Actions;

import Entites.ZipArchive;
import IO.ExtractZipFile;
import java.io.IOException;

/**
 *
 * @author Hadj
 */
public class ActionExtraireZip {
    public void executer() throws MyZipException{
        ZipArchive zip = ZipArchive.getZipArchive();
        ExtractZipFile extracter = new ExtractZipFile();
        try{
            extracter.extract(zip);
        }catch(IOException e){
            throw new MyZipException("Ecriture impossible");
        }
    }
}
