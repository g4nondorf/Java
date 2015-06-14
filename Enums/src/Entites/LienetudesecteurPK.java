/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Moi
 */
@Embeddable
public class LienetudesecteurPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "numeroetude")
    private int numeroetude;
    @Basic(optional = false)
    @Column(name = "numerosecteur")
    private int numerosecteur;
    @Basic(optional = false)
    @Column(name = "numeroiris")
    private String numeroiris;

    public LienetudesecteurPK() {
    }

    public LienetudesecteurPK(int numeroetude, int numerosecteur, String numeroiris) {
        this.numeroetude = numeroetude;
        this.numerosecteur = numerosecteur;
        this.numeroiris = numeroiris;
    }

    public int getNumeroetude() {
        return numeroetude;
    }

    public void setNumeroetude(int numeroetude) {
        this.numeroetude = numeroetude;
    }

    public int getNumerosecteur() {
        return numerosecteur;
    }

    public void setNumerosecteur(int numerosecteur) {
        this.numerosecteur = numerosecteur;
    }

    public String getNumeroiris() {
        return numeroiris;
    }

    public void setNumeroiris(String numeroiris) {
        this.numeroiris = numeroiris;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroetude;
        hash += (int) numerosecteur;
        hash += (numeroiris != null ? numeroiris.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LienetudesecteurPK)) {
            return false;
        }
        LienetudesecteurPK other = (LienetudesecteurPK) object;
        if (this.numeroetude != other.numeroetude) {
            return false;
        }
        if (this.numerosecteur != other.numerosecteur) {
            return false;
        }
        if ((this.numeroiris == null && other.numeroiris != null) || (this.numeroiris != null && !this.numeroiris.equals(other.numeroiris))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.LienetudesecteurPK[ numeroetude=" + numeroetude + ", numerosecteur=" + numerosecteur + ", numeroiris=" + numeroiris + " ]";
    }
    
}
