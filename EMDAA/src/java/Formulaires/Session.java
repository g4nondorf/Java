/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

/**
 *
 * @author Moi
 */
public class Session {
    private int dateEtHeure;
    private int duree;
    private int codeUtilisateur;

    public Session(int dateEtHeure, int duree, int codeUtilisateur) {
        this.dateEtHeure = dateEtHeure;
        this.duree = duree;
        this.codeUtilisateur = codeUtilisateur;
    }

    public int getDateEtHeure() {
        return dateEtHeure;
    }

    public int getDuree() {
        return duree;
    }

    public int getCodeUtilisateur() {
        return codeUtilisateur;
    }
}
