/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "velo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Velo.findAll", query = "SELECT v FROM Velo v"),
    @NamedQuery(name = "Velo.findByNumerov", query = "SELECT v FROM Velo v WHERE v.veloPK.numerov = :numerov"),
    @NamedQuery(name = "Velo.findByLieustationnementnuit", query = "SELECT v FROM Velo v WHERE v.lieustationnementnuit = :lieustationnementnuit"),
    @NamedQuery(name = "Velo.findByAssistanceelectrique", query = "SELECT v FROM Velo v WHERE v.assistanceelectrique = :assistanceelectrique"),
    @NamedQuery(name = "Velo.findByNumeromenage", query = "SELECT v FROM Velo v WHERE v.veloPK.numeromenage = :numeromenage")})
public class Velo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VeloPK veloPK;
    @Basic(optional = false)
    @Column(name = "lieustationnementnuit")
    private boolean lieustationnementnuit;
    @Basic(optional = false)
    @Column(name = "assistanceelectrique")
    private boolean assistanceelectrique;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession")
    @ManyToOne(optional = false)
    private Sessions numerosession;
    @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menage menage;

    public Velo() {
    }

    public Velo(VeloPK veloPK) {
        this.veloPK = veloPK;
    }

    public Velo(VeloPK veloPK, boolean lieustationnementnuit, boolean assistanceelectrique) {
        this.veloPK = veloPK;
        this.lieustationnementnuit = lieustationnementnuit;
        this.assistanceelectrique = assistanceelectrique;
    }

    public Velo(int numerov, int numeromenage) {
        this.veloPK = new VeloPK(numerov, numeromenage);
    }

    public VeloPK getVeloPK() {
        return veloPK;
    }

    public void setVeloPK(VeloPK veloPK) {
        this.veloPK = veloPK;
    }

    public boolean getLieustationnementnuit() {
        return lieustationnementnuit;
    }

    public void setLieustationnementnuit(boolean lieustationnementnuit) {
        this.lieustationnementnuit = lieustationnementnuit;
    }

    public boolean getAssistanceelectrique() {
        return assistanceelectrique;
    }

    public void setAssistanceelectrique(boolean assistanceelectrique) {
        this.assistanceelectrique = assistanceelectrique;
    }

    public Sessions getNumerosession() {
        return numerosession;
    }

    public void setNumerosession(Sessions numerosession) {
        this.numerosession = numerosession;
    }

    public Menage getMenage() {
        return menage;
    }

    public void setMenage(Menage menage) {
        this.menage = menage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (veloPK != null ? veloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Velo)) {
            return false;
        }
        Velo other = (Velo) object;
        if ((this.veloPK == null && other.veloPK != null) || (this.veloPK != null && !this.veloPK.equals(other.veloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Velo[ veloPK=" + veloPK + " ]";
    }
    
}
