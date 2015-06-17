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
public class VeloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerov")
    private int numerov;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeromenage")
    private int numeromenage;

    public VeloPK() {
    }

    public VeloPK(int numerov, int numeromenage) {
        this.numerov = numerov;
        this.numeromenage = numeromenage;
    }

    public int getNumerov() {
        return numerov;
    }

    public void setNumerov(int numerov) {
        this.numerov = numerov;
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
        hash += (int) numerov;
        hash += (int) numeromenage;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VeloPK)) {
            return false;
        }
        VeloPK other = (VeloPK) object;
        if (this.numerov != other.numerov) {
            return false;
        }
        if (this.numeromenage != other.numeromenage) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.VeloPK[ numerov=" + numerov + ", numeromenage=" + numeromenage + " ]";
    }
    
}
