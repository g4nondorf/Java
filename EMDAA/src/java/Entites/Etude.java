/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "etude")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etude.findAll", query = "SELECT e FROM Etude e"),
    @NamedQuery(name = "Etude.findByNumeroetude", query = "SELECT e FROM Etude e WHERE e.numeroetude = :numeroetude"),
    @NamedQuery(name = "Etude.findByTitre", query = "SELECT e FROM Etude e WHERE e.titre = :titre"),
    @NamedQuery(name = "Etude.findByDatedebut", query = "SELECT e FROM Etude e WHERE e.datedebut = :datedebut"),
    @NamedQuery(name = "Etude.findByDatefin", query = "SELECT e FROM Etude e WHERE e.datefin = :datefin")})
public class Etude implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroetude")
    private Integer numeroetude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titre")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @JoinTable(name = "lienetudepanel", joinColumns = {
        @JoinColumn(name = "numeroetude", referencedColumnName = "numeroetude")}, inverseJoinColumns = {
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage"),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne")})
    @ManyToMany
    private Collection<Panel> panelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroetude")
    private Collection<Sessions> sessionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etude")
    private Collection<Lienetudesecteur> lienetudesecteurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroetude")
    private Collection<Secteur> secteurCollection;

    public Etude() {
    }

    public Etude(Integer numeroetude) {
        this.numeroetude = numeroetude;
    }

    public Etude(Integer numeroetude, String titre, Date datedebut, Date datefin) {
        this.numeroetude = numeroetude;
        this.titre = titre;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Integer getNumeroetude() {
        return numeroetude;
    }

    public void setNumeroetude(Integer numeroetude) {
        this.numeroetude = numeroetude;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @XmlTransient
    public Collection<Panel> getPanelCollection() {
        return panelCollection;
    }

    public void setPanelCollection(Collection<Panel> panelCollection) {
        this.panelCollection = panelCollection;
    }

    @XmlTransient
    public Collection<Sessions> getSessionsCollection() {
        return sessionsCollection;
    }

    public void setSessionsCollection(Collection<Sessions> sessionsCollection) {
        this.sessionsCollection = sessionsCollection;
    }

    @XmlTransient
    public Collection<Lienetudesecteur> getLienetudesecteurCollection() {
        return lienetudesecteurCollection;
    }

    public void setLienetudesecteurCollection(Collection<Lienetudesecteur> lienetudesecteurCollection) {
        this.lienetudesecteurCollection = lienetudesecteurCollection;
    }

    @XmlTransient
    public Collection<Secteur> getSecteurCollection() {
        return secteurCollection;
    }

    public void setSecteurCollection(Collection<Secteur> secteurCollection) {
        this.secteurCollection = secteurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroetude != null ? numeroetude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etude)) {
            return false;
        }
        Etude other = (Etude) object;
        if ((this.numeroetude == null && other.numeroetude != null) || (this.numeroetude != null && !this.numeroetude.equals(other.numeroetude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Etude[ numeroetude=" + numeroetude + " ]";
    }
    
}
