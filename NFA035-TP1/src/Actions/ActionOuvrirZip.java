/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Actions;

import Entites.ZipArchive;
import IO.LoadZipFile;
import java.io.IOException;

/**
 *
 * @author Hadj
 */
public class ActionOuvrirZip {
    public ZipArchive executer(String s) throws MyZipException{
        LoadZipFile reader = new LoadZipFile();
        ZipArchive zip = null;
        try{
            zip = reader.load(s);
        }catch(IOException e){
            throw new MyZipException("Ouverture impossible");
        }
        return zip;
    }
}
