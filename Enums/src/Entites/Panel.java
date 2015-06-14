/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "panel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Panel.findAll", query = "SELECT p FROM Panel p"),
    @NamedQuery(name = "Panel.findByNumeromenage", query = "SELECT p FROM Panel p WHERE p.panelPK.numeromenage = :numeromenage"),
    @NamedQuery(name = "Panel.findByNumeropersonne", query = "SELECT p FROM Panel p WHERE p.panelPK.numeropersonne = :numeropersonne")})
public class Panel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PanelPK panelPK;
    @ManyToMany(mappedBy = "panelCollection")
    private Collection<Etude> etudeCollection;
    @JoinColumn(name = "numerocarreau", referencedColumnName = "numeroc")
    @ManyToOne(optional = false)
    private Numerocarreau numerocarreau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panel")
    private Collection<Sessions> sessionsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "panel")
    private Personne personne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panel")
    private Collection<Menage> menageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panel")
    private Collection<Occupationprincipale> occupationprincipaleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panel")
    private Collection<Activite> activiteCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "panel")
    private HabitudesUtilisationMode habitudesUtilisationMode;

    public Panel() {
    }

    public Panel(PanelPK panelPK) {
        this.panelPK = panelPK;
    }

    public Panel(int numeromenage, int numeropersonne) {
        this.panelPK = new PanelPK(numeromenage, numeropersonne);
    }

    public PanelPK getPanelPK() {
        return panelPK;
    }

    public void setPanelPK(PanelPK panelPK) {
        this.panelPK = panelPK;
    }

    @XmlTransient
    public Collection<Etude> getEtudeCollection() {
        return etudeCollection;
    }

    public void setEtudeCollection(Collection<Etude> etudeCollection) {
        this.etudeCollection = etudeCollection;
    }

    public Numerocarreau getNumerocarreau() {
        return numerocarreau;
    }

    public void setNumerocarreau(Numerocarreau numerocarreau) {
        this.numerocarreau = numerocarreau;
    }

    @XmlTransient
    public Collection<Sessions> getSessionsCollection() {
        return sessionsCollection;
    }

    public void setSessionsCollection(Collection<Sessions> sessionsCollection) {
        this.sessionsCollection = sessionsCollection;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @XmlTransient
    public Collection<Menage> getMenageCollection() {
        return menageCollection;
    }

    public void setMenageCollection(Collection<Menage> menageCollection) {
        this.menageCollection = menageCollection;
    }

    @XmlTransient
    public Collection<Occupationprincipale> getOccupationprincipaleCollection() {
        return occupationprincipaleCollection;
    }

    public void setOccupationprincipaleCollection(Collection<Occupationprincipale> occupationprincipaleCollection) {
        this.occupationprincipaleCollection = occupationprincipaleCollection;
    }

    @XmlTransient
    public Collection<Activite> getActiviteCollection() {
        return activiteCollection;
    }

    public void setActiviteCollection(Collection<Activite> activiteCollection) {
        this.activiteCollection = activiteCollection;
    }

    public HabitudesUtilisationMode getHabitudesUtilisationMode() {
        return habitudesUtilisationMode;
    }

    public void setHabitudesUtilisationMode(HabitudesUtilisationMode habitudesUtilisationMode) {
        this.habitudesUtilisationMode = habitudesUtilisationMode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (panelPK != null ? panelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panel)) {
            return false;
        }
        Panel other = (Panel) object;
        if ((this.panelPK == null && other.panelPK != null) || (this.panelPK != null && !this.panelPK.equals(other.panelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Panel[ panelPK=" + panelPK + " ]";
    }
    
}
