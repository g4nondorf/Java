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
public class HabitudesUtilisationModePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "numeropersonne")
    private int numeropersonne;
    @Basic(optional = false)
    @Column(name = "numeromenage")
    private int numeromenage;

    public HabitudesUtilisationModePK() {
    }

    public HabitudesUtilisationModePK(int numeropersonne, int numeromenage) {
        this.numeropersonne = numeropersonne;
        this.numeromenage = numeromenage;
    }

    public int getNumeropersonne() {
        return numeropersonne;
    }

    public void setNumeropersonne(int numeropersonne) {
        this.numeropersonne = numeropersonne;
    }

    public int getNumeromenage() {
        return numeromenage;
    }

    public void setNumeromenage(int numeromenage) {
        this.numeromenage = numeromenage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeropersonne;
        hash += (int) numeromenage;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitudesUtilisationModePK)) {
            return false;
        }
        HabitudesUtilisationModePK other = (HabitudesUtilisationModePK) object;
        if (this.numeropersonne != other.numeropersonne) {
            return false;
        }
        if (this.numeromenage != other.numeromenage) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.HabitudesUtilisationModePK[ numeropersonne=" + numeropersonne + ", numeromenage=" + numeromenage + " ]";
    }
    
}
