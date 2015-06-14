/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IO;

import Entites.Fichier;
import Entites.Repertoire;
import Entites.ZipArchive;
import Entites.ZipContent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Hadj
 */
public class LoadZipFile {
    public ZipArchive load(String nomFichier) throws IOException{
        ZipArchive zip =  ZipArchive.creerZipArchive();
        zip.setNomFichier(nomFichier);
        File fd = new File(nomFichier);
        if(fd.exists()){
            ZipInputStream zipFile = new ZipInputStream(new FileInputStream(fd));
            ZipEntry ze = zipFile.getNextEntry();
            File f = null;
            Repertoire parent = null;
            ZipContent z = null;
            while(ze != null ){
                if(ze.isDirectory()){
                    z = new Repertoire();
                    Repertoire r = (Repertoire) z;
                    f = new File(ze.getName());
                    r.setFile(f);
                    r.setNom(ze.getName());
                    String s = f.getParent();
                    parent = zip.getRepertoire(s);
                }else{
                    z = new Fichier();
                    Fichier fichier = (Fichier) z;
                    f = new File(ze.getName());
                    fichier.setFile(f);
                    fichier.setNom(ze.getName());

                    String s = f.getParent();
                    parent= zip.getRepertoire(s);
                    if(s!= null && !s.equals("") && parent==null){
                        parent = new Repertoire();
                        File dir = new File(s);
                        parent.setFile(dir);
                        parent.setNom(ze.getName());
                    }
                }
                if(parent != null)
                    parent.add(z);
                else
                    zip.add(z);

                zipFile.closeEntry();
                ze = zipFile.getNextEntry();
            }
            zipFile.close();
        }
        return zip;
    }
}
