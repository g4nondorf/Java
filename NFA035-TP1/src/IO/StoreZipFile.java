/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Entites.Repertoire;
import Entites.ZipArchive;
import Entites.ZipContent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Moi
 */
public class StoreZipFile {
    private ZipOutputStream zipFile;
    
    public void write(ZipArchive zip, String fichier) throws IOException{
        zipFile = new ZipOutputStream(new FileOutputStream(fichier));
        zipFile.setMethod(ZipOutputStream.DEFLATED);
        Set<ZipContent> files = zip.getListContents();
        for(ZipContent zc : files){
            write(zc);
        }
        zipFile.close();
    }
    
    public void write(ZipContent zc) throws IOException{
        ZipEntry e;
        File f = zc.getFile();
        if(f.exists()){
            if(f.isDirectory()){
                Set<ZipContent> contents = ((Repertoire)zc).getListContents();
                for(ZipContent c : contents){
                    write(c);
                }
            }else{
                e = new ZipEntry(f.getPath());
                zipFile.putNextEntry(e);
                BufferedInputStream ins = new BufferedInputStream(new FileInputStream(f));
                byte[] bin = new byte[4096];
                int bread;
                while((bread = ins.read(bin,0,4096)) > -1) zipFile.write(bin,0,bread);
                zipFile.closeEntry();
                ins.close();
            }
        }
    }
}
