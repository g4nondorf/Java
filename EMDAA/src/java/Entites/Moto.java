/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "moto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moto.findAll", query = "SELECT m FROM Moto m"),
    @NamedQuery(name = "Moto.findByNumerov", query = "SELECT m FROM Moto m WHERE m.motoPK.numerov = :numerov"),
    @NamedQuery(name = "Moto.findByAnnee", query = "SELECT m FROM Moto m WHERE m.annee = :annee"),
    @NamedQuery(name = "Moto.findByPuissancefiscal", query = "SELECT m FROM Moto m WHERE m.puissancefiscal = :puissancefiscal"),
    @NamedQuery(name = "Moto.findByPuissancem", query = "SELECT m FROM Moto m WHERE m.puissancem = :puissancem"),
    @NamedQuery(name = "Moto.findByGenrem", query = "SELECT m FROM Moto m WHERE m.genrem = :genrem"),
    @NamedQuery(name = "Moto.findByLieustationnementnuit", query = "SELECT m FROM Moto m WHERE m.lieustationnementnuit = :lieustationnementnuit"),
    @NamedQuery(name = "Moto.findByTypestationnementnuit", query = "SELECT m FROM Moto m WHERE m.typestationnementnuit = :typestationnementnuit"),
    @NamedQuery(name = "Moto.findByTypemoteur", query = "SELECT m FROM Moto m WHERE m.typemoteur = :typemoteur"),
    @NamedQuery(name = "Moto.findByNumeromenage", query = "SELECT m FROM Moto m WHERE m.motoPK.numeromenage = :numeromenage")})
public class Moto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MotoPK motoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee")
    @Temporal(TemporalType.DATE)
    private Date annee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puissancefiscal")
    private int puissancefiscal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puissancem")
    private int puissancem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genrem")
    private int genrem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lieustationnementnuit")
    private int lieustationnementnuit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typestationnementnuit")
    private int typestationnementnuit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typemoteur")
    private int typemoteur;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession")
    @ManyToOne(optional = false)
    private Sessions numerosession;
    @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menage menage;

    public Moto() {
    }

    public Moto(MotoPK motoPK) {
        this.motoPK = motoPK;
    }

    public Moto(MotoPK motoPK, Date annee, int puissancefiscal, int puissancem, int genrem, int lieustationnementnuit, int typestationnementnuit, int typemoteur) {
        this.motoPK = motoPK;
        this.annee = annee;
        this.puissancefiscal = puissancefiscal;
        this.puissancem = puissancem;
        this.genrem = genrem;
        this.lieustationnementnuit = lieustationnementnuit;
        this.typestationnementnuit = typestationnementnuit;
        this.typemoteur = typemoteur;
    }

    public Moto(int numerov, int numeromenage) {
        this.motoPK = new MotoPK(numerov, numeromenage);
    }

    public MotoPK getMotoPK() {
        return motoPK;
    }

    public void setMotoPK(MotoPK motoPK) {
        this.motoPK = motoPK;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public int getPuissancefiscal() {
        return puissancefiscal;
    }

    public void setPuissancefiscal(int puissancefiscal) {
        this.puissancefiscal = puissancefiscal;
    }

    public int getPuissancem() {
        return puissancem;
    }

    public void setPuissancem(int puissancem) {
        this.puissancem = puissancem;
    }

    public int getGenrem() {
        return genrem;
    }

    public void setGenrem(int genrem) {
        this.genrem = genrem;
    }

    public int getLieustationnementnuit() {
        return lieustationnementnuit;
    }

    public void setLieustationnementnuit(int lieustationnementnuit) {
        this.lieustationnementnuit = lieustationnementnuit;
    }

    public int getTypestationnementnuit() {
        return typestationnementnuit;
    }

    public void setTypestationnementnuit(int typestationnementnuit) {
        this.typestationnementnuit = typestationnementnuit;
    }

    public int getTypemoteur() {
        return typemoteur;
    }

    public void setTypemoteur(int typemoteur) {
        this.typemoteur = typemoteur;
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
        hash += (motoPK != null ? motoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moto)) {
            return false;
        }
        Moto other = (Moto) object;
        if ((this.motoPK == null && other.motoPK != null) || (this.motoPK != null && !this.motoPK.equals(other.motoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Moto[ motoPK=" + motoPK + " ]";
    }
    
}
