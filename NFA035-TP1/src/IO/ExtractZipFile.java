/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IO;

import Entites.ZipArchive;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Hadj
 */
public class ExtractZipFile {
    public void extract(ZipArchive zip) throws IOException{
        String nomFichier = zip.getNomFichier();
	FileOutputStream dezip;
        File fd = new File(nomFichier);
        if(fd.exists()){
              ZipInputStream zipFile = new ZipInputStream(new FileInputStream(fd));
              ZipEntry ze = zipFile.getNextEntry();
              while(ze != null ){
                      if(ze.isDirectory()){
                              File dir = new File(ze.getName());
                              dir.mkdirs();
                      }else{
                            File f = new File(ze.getName());
                            String s = f.getParent();
                            File g = new File(s);
                            if(!g.exists())
                                    g.mkdir();
                            dezip = new FileOutputStream(ze.getName());
                            byte[] bin = new byte[4096];
                            int bread ;
                            while ((bread = zipFile.read(bin, 0, 4096))>-1) {
                                    dezip.write(bin, 0, bread);
                            }
                            dezip.close();
                      }
                      zipFile.closeEntry();
                      ze = zipFile.getNextEntry();
              }
              zipFile.close();
        }
        return ;
    }
}

