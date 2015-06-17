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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "iris")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iris.findAll", query = "SELECT i FROM Iris i"),
    @NamedQuery(name = "Iris.findByNumeroiris", query = "SELECT i FROM Iris i WHERE i.numeroiris = :numeroiris")})
public class Iris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numeroiris")
    private String numeroiris;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iris")
    private Collection<Lienetudesecteur> lienetudesecteurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroiris")
    private Collection<Numerocarreau> numerocarreauCollection;

    public Iris() {
    }

    public Iris(String numeroiris) {
        this.numeroiris = numeroiris;
    }

    public String getNumeroiris() {
        return numeroiris;
    }

    public void setNumeroiris(String numeroiris) {
        this.numeroiris = numeroiris;
    }

    @XmlTransient
    public Collection<Lienetudesecteur> getLienetudesecteurCollection() {
        return lienetudesecteurCollection;
    }

    public void setLienetudesecteurCollection(Collection<Lienetudesecteur> lienetudesecteurCollection) {
        this.lienetudesecteurCollection = lienetudesecteurCollection;
    }

    @XmlTransient
    public Collection<Numerocarreau> getNumerocarreauCollection() {
        return numerocarreauCollection;
    }

    public void setNumerocarreauCollection(Collection<Numerocarreau> numerocarreauCollection) {
        this.numerocarreauCollection = numerocarreauCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroiris != null ? numeroiris.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iris)) {
            return false;
        }
        Iris other = (Iris) object;
        if ((this.numeroiris == null && other.numeroiris != null) || (this.numeroiris != null && !this.numeroiris.equals(other.numeroiris))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Iris[ numeroiris=" + numeroiris + " ]";
    }
    
}
