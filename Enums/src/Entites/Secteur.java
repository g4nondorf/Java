/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "secteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secteur.findAll", query = "SELECT s FROM Secteur s"),
    @NamedQuery(name = "Secteur.findByNumerosecteur", query = "SELECT s FROM Secteur s WHERE s.numerosecteur = :numerosecteur")})
public class Secteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numerosecteur")
    private Integer numerosecteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secteur")
    private Collection<Lienetudesecteur> lienetudesecteurCollection;
    @JoinColumn(name = "numeroetude", referencedColumnName = "numeroetude")
    @ManyToOne(optional = false)
    private Etude numeroetude;

    public Secteur() {
    }

    public Secteur(Integer numerosecteur) {
        this.numerosecteur = numerosecteur;
    }

    public Integer getNumerosecteur() {
        return numerosecteur;
    }

    public void setNumerosecteur(Integer numerosecteur) {
        this.numerosecteur = numerosecteur;
    }

    @XmlTransient
    public Collection<Lienetudesecteur> getLienetudesecteurCollection() {
        return lienetudesecteurCollection;
    }

    public void setLienetudesecteurCollection(Collection<Lienetudesecteur> lienetudesecteurCollection) {
        this.lienetudesecteurCollection = lienetudesecteurCollection;
    }

    public Etude getNumeroetude() {
        return numeroetude;
    }

    public void setNumeroetude(Etude numeroetude) {
        this.numeroetude = numeroetude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerosecteur != null ? numerosecteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secteur)) {
            return false;
        }
        Secteur other = (Secteur) object;
        if ((this.numerosecteur == null && other.numerosecteur != null) || (this.numerosecteur != null && !this.numerosecteur.equals(other.numerosecteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Secteur[ numerosecteur=" + numerosecteur + " ]";
    }
    
}
