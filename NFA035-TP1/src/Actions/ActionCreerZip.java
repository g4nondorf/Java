/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Actions;

import Entites.ZipArchive;

/**
 *
 * @author Hadj
 */
public class ActionCreerZip {
    public ZipArchive executer(){
        ZipArchive zip = ZipArchive.creerZipArchive();
        return zip;
    }
}
