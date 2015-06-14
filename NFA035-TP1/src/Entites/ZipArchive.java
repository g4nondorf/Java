/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entites;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hadj
 */
public class ZipArchive {
    private String nomFichier;
    private Set<ZipContent> listContents;
    private static ZipArchive zip = null;

    public static ZipArchive getZipArchive(){
        return zip;
    }

    public static ZipArchive creerZipArchive(){
        zip = new ZipArchive();
        return zip;
    }

    private ZipArchive() {
        listContents = new HashSet<ZipContent>();
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public Set<ZipContent> getListContents() {
        return listContents;
    }

    public void setListContents(Set<ZipContent> listContent) {
        this.listContents = listContent;
    }

    public Repertoire getRepertoire (String s){
        Repertoire x = null;
        if(s != null && !s.equals("")){
            for(ZipContent c : listContents){
                if(c instanceof Repertoire){
                    x = ((Repertoire) c).getRepertoire(s);
                    if(x != null) break;
                }
            }
        }
        return x;
    }

    public Repertoire getRepertoire (ZipContent c){
        Repertoire x = null;
        if(c != null){
            for(ZipContent z : listContents){
                File f = z.getFile();
                if(f.isDirectory()){
                    x = ((Repertoire)z).getParentRepertoire(c);
                    if(x != null) {
                        break;
                    }
                }
            }
        }
        return x;
    }

    public void add(File file, String s){
        ZipContent c;
        if(file.isDirectory()){
            c = new Repertoire();
        }else{
            c = new Fichier();
        }
        c.setFile(file);
        c.setNom(s);

        Repertoire x = getRepertoire(c);
        if(x != null){
            ((Repertoire)x).add(c);
        }else{
            listContents.add(c);
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i < files.length; i++){
                add(files[i], files[i].getName());
            }
        }
    }

   public void add(ZipContent c){
        Repertoire x = getRepertoire(c);
        if(x != null){
            ((Repertoire)x).add(c);
        }else{
            listContents.add(c);
        }
    }
   
   public void remove(String s){
       
   }
}
