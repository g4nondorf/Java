/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
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
@Table(name = "lienetudesecteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lienetudesecteur.findAll", query = "SELECT l FROM Lienetudesecteur l"),
    @NamedQuery(name = "Lienetudesecteur.findByNumeroetude", query = "SELECT l FROM Lienetudesecteur l WHERE l.lienetudesecteurPK.numeroetude = :numeroetude"),
    @NamedQuery(name = "Lienetudesecteur.findByNumerosecteur", query = "SELECT l FROM Lienetudesecteur l WHERE l.lienetudesecteurPK.numerosecteur = :numerosecteur"),
    @NamedQuery(name = "Lienetudesecteur.findByNumeroiris", query = "SELECT l FROM Lienetudesecteur l WHERE l.lienetudesecteurPK.numeroiris = :numeroiris")})
public class Lienetudesecteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LienetudesecteurPK lienetudesecteurPK;
    @JoinColumn(name = "numerosecteur", referencedColumnName = "numerosecteur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Secteur secteur;
    @JoinColumn(name = "numeroiris", referencedColumnName = "numeroiris", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Iris iris;
    @JoinColumn(name = "numeroetude", referencedColumnName = "numeroetude", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etude etude;

    public Lienetudesecteur() {
    }

    public Lienetudesecteur(LienetudesecteurPK lienetudesecteurPK) {
        this.lienetudesecteurPK = lienetudesecteurPK;
    }

    public Lienetudesecteur(int numeroetude, int numerosecteur, String numeroiris) {
        this.lienetudesecteurPK = new LienetudesecteurPK(numeroetude, numerosecteur, numeroiris);
    }

    public LienetudesecteurPK getLienetudesecteurPK() {
        return lienetudesecteurPK;
    }

    public void setLienetudesecteurPK(LienetudesecteurPK lienetudesecteurPK) {
        this.lienetudesecteurPK = lienetudesecteurPK;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Iris getIris() {
        return iris;
    }

    public void setIris(Iris iris) {
        this.iris = iris;
    }

    public Etude getEtude() {
        return etude;
    }

    public void setEtude(Etude etude) {
        this.etude = etude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lienetudesecteurPK != null ? lienetudesecteurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lienetudesecteur)) {
            return false;
        }
        Lienetudesecteur other = (Lienetudesecteur) object;
        if ((this.lienetudesecteurPK == null && other.lienetudesecteurPK != null) || (this.lienetudesecteurPK != null && !this.lienetudesecteurPK.equals(other.lienetudesecteurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Lienetudesecteur[ lienetudesecteurPK=" + lienetudesecteurPK + " ]";
    }
    
}
