package Entites;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class Repertoire extends ZipContent{
    private Set<ZipContent> listContents;

    public Repertoire() {
        listContents = new HashSet<ZipContent>();
    }


    public Set<ZipContent> getListContents() {
        return listContents;
    }

    public void setListContents(Set<ZipContent> listFile) {
        this.listContents = listFile;
    }

    public void add(ZipContent c){
        listContents.add(c);
    }

    public Repertoire getRepertoire(String s){
        Repertoire r = null;
        if(nom.equalsIgnoreCase(s+"/")){
            r = this;
        }else{
            for(ZipContent c : listContents){
                if(c instanceof Repertoire){
                    r = ((Repertoire)c).getRepertoire(s);
                    if(r != null) break;
                }
            }
        }
        return r;
    }

    public Repertoire getParentRepertoire(ZipContent c){
        Repertoire x = null;
        String s = c.getFile().getParent();
        if(nom.equals(s + "/")){
            return this;
        }
        for(ZipContent z : listContents){
            if(z.getFile().isDirectory()){
                x = ((Repertoire)z).getParentRepertoire(c);
                if(x != null) break;
            }
        }
        return x;
    }
}
