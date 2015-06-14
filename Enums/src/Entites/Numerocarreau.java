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
@Table(name = "numerocarreau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numerocarreau.findAll", query = "SELECT n FROM Numerocarreau n"),
    @NamedQuery(name = "Numerocarreau.findByNumeroc", query = "SELECT n FROM Numerocarreau n WHERE n.numeroc = :numeroc")})
public class Numerocarreau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroc")
    private String numeroc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerocarreau")
    private Collection<Panel> panelCollection;
    @JoinColumn(name = "numeroiris", referencedColumnName = "numeroiris")
    @ManyToOne(optional = false)
    private Iris numeroiris;

    public Numerocarreau() {
    }

    public Numerocarreau(String numeroc) {
        this.numeroc = numeroc;
    }

    public String getNumeroc() {
        return numeroc;
    }

    public void setNumeroc(String numeroc) {
        this.numeroc = numeroc;
    }

    @XmlTransient
    public Collection<Panel> getPanelCollection() {
        return panelCollection;
    }

    public void setPanelCollection(Collection<Panel> panelCollection) {
        this.panelCollection = panelCollection;
    }

    public Iris getNumeroiris() {
        return numeroiris;
    }

    public void setNumeroiris(Iris numeroiris) {
        this.numeroiris = numeroiris;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroc != null ? numeroc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Numerocarreau)) {
            return false;
        }
        Numerocarreau other = (Numerocarreau) object;
        if ((this.numeroc == null && other.numeroc != null) || (this.numeroc != null && !this.numeroc.equals(other.numeroc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Numerocarreau[ numeroc=" + numeroc + " ]";
    }
    
}
