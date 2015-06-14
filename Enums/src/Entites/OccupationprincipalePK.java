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
public class OccupationprincipalePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "numeropersonne")
    private int numeropersonne;
    @Basic(optional = false)
    @Column(name = "numeromenage")
    private int numeromenage;
    @Basic(optional = false)
    @Column(name = "numerosession")
    private int numerosession;

    public OccupationprincipalePK() {
    }

    public OccupationprincipalePK(int numeropersonne, int numeromenage, int numerosession) {
        this.numeropersonne = numeropersonne;
        this.numeromenage = numeromenage;
        this.numerosession = numerosession;
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

    public int getNumerosession() {
        return numerosession;
    }

    public void setNumerosession(int numerosession) {
        this.numerosession = numerosession;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeropersonne;
        hash += (int) numeromenage;
        hash += (int) numerosession;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationprincipalePK)) {
            return false;
        }
        OccupationprincipalePK other = (OccupationprincipalePK) object;
        if (this.numeropersonne != other.numeropersonne) {
            return false;
        }
        if (this.numeromenage != other.numeromenage) {
            return false;
        }
        if (this.numerosession != other.numerosession) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.OccupationprincipalePK[ numeropersonne=" + numeropersonne + ", numeromenage=" + numeromenage + ", numerosession=" + numerosession + " ]";
    }
    
}
