/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entites;

import java.io.File;

/**
 *
 * @author Hadj
 */
public abstract class ZipContent {
    protected File file;
    protected String nom;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
