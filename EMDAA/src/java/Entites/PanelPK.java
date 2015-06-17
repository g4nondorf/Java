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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Moi
 */
@Embeddable
public class PanelPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeromenage")
    private int numeromenage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeropersonne")
    private int numeropersonne;

    public PanelPK() {
    }

    public PanelPK(int numeromenage, int numeropersonne) {
        this.numeromenage = numeromenage;
        this.numeropersonne = numeropersonne;
    }

    public int getNumeromenage() {
        return numeromenage;
    }

    public void setNumeromenage(int numeromenage) {
        this.numeromenage = numeromenage;
    }

    public int getNumeropersonne() {
        return numeropersonne;
    }

    public void setNumeropersonne(int numeropersonne) {
        this.numeropersonne = numeropersonne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeromenage;
        hash += (int) numeropersonne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PanelPK)) {
            return false;
        }
        PanelPK other = (PanelPK) object;
        if (this.numeromenage != other.numeromenage) {
            return false;
        }
        if (this.numeropersonne != other.numeropersonne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.PanelPK[ numeromenage=" + numeromenage + ", numeropersonne=" + numeropersonne + " ]";
    }
    
}
