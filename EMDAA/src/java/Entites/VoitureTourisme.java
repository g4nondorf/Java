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
@Table(name = "voiture_tourisme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoitureTourisme.findAll", query = "SELECT v FROM VoitureTourisme v"),
    @NamedQuery(name = "VoitureTourisme.findByNumerov", query = "SELECT v FROM VoitureTourisme v WHERE v.voitureTourismePK.numerov = :numerov"),
    @NamedQuery(name = "VoitureTourisme.findByAnnee", query = "SELECT v FROM VoitureTourisme v WHERE v.annee = :annee"),
    @NamedQuery(name = "VoitureTourisme.findByPuissance", query = "SELECT v FROM VoitureTourisme v WHERE v.puissance = :puissance"),
    @NamedQuery(name = "VoitureTourisme.findByLieustationnementnuit", query = "SELECT v FROM VoitureTourisme v WHERE v.lieustationnementnuit = :lieustationnementnuit"),
    @NamedQuery(name = "VoitureTourisme.findByTypestationnementnuit", query = "SELECT v FROM VoitureTourisme v WHERE v.typestationnementnuit = :typestationnementnuit"),
    @NamedQuery(name = "VoitureTourisme.findByGenrev", query = "SELECT v FROM VoitureTourisme v WHERE v.genrev = :genrev"),
    @NamedQuery(name = "VoitureTourisme.findByEnergiev", query = "SELECT v FROM VoitureTourisme v WHERE v.energiev = :energiev"),
    @NamedQuery(name = "VoitureTourisme.findByPossessionsv", query = "SELECT v FROM VoitureTourisme v WHERE v.possessionsv = :possessionsv"),
    @NamedQuery(name = "VoitureTourisme.findByNumeromenage", query = "SELECT v FROM VoitureTourisme v WHERE v.voitureTourismePK.numeromenage = :numeromenage")})
public class VoitureTourisme implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VoitureTourismePK voitureTourismePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee")
    @Temporal(TemporalType.DATE)
    private Date annee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puissance")
    private int puissance;
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
    @Column(name = "genrev")
    private int genrev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "energiev")
    private int energiev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "possessionsv")
    private int possessionsv;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession")
    @ManyToOne(optional = false)
    private Sessions numerosession;
    @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menage menage;

    public VoitureTourisme() {
    }

    public VoitureTourisme(VoitureTourismePK voitureTourismePK) {
        this.voitureTourismePK = voitureTourismePK;
    }

    public VoitureTourisme(VoitureTourismePK voitureTourismePK, Date annee, int puissance, int lieustationnementnuit, int typestationnementnuit, int genrev, int energiev, int possessionsv) {
        this.voitureTourismePK = voitureTourismePK;
        this.annee = annee;
        this.puissance = puissance;
        this.lieustationnementnuit = lieustationnementnuit;
        this.typestationnementnuit = typestationnementnuit;
        this.genrev = genrev;
        this.energiev = energiev;
        this.possessionsv = possessionsv;
    }

    public VoitureTourisme(int numerov, int numeromenage) {
        this.voitureTourismePK = new VoitureTourismePK(numerov, numeromenage);
    }

    public VoitureTourismePK getVoitureTourismePK() {
        return voitureTourismePK;
    }

    public void setVoitureTourismePK(VoitureTourismePK voitureTourismePK) {
        this.voitureTourismePK = voitureTourismePK;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
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

    public int getGenrev() {
        return genrev;
    }

    public void setGenrev(int genrev) {
        this.genrev = genrev;
    }

    public int getEnergiev() {
        return energiev;
    }

    public void setEnergiev(int energiev) {
        this.energiev = energiev;
    }

    public int getPossessionsv() {
        return possessionsv;
    }

    public void setPossessionsv(int possessionsv) {
        this.possessionsv = possessionsv;
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
        hash += (voitureTourismePK != null ? voitureTourismePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoitureTourisme)) {
            return false;
        }
        VoitureTourisme other = (VoitureTourisme) object;
        if ((this.voitureTourismePK == null && other.voitureTourismePK != null) || (this.voitureTourismePK != null && !this.voitureTourismePK.equals(other.voitureTourismePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.VoitureTourisme[ voitureTourismePK=" + voitureTourismePK + " ]";
    }
    
}
