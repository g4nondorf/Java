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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "sessions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s"),
    @NamedQuery(name = "Sessions.findByNumerosession", query = "SELECT s FROM Sessions s WHERE s.numerosession = :numerosession")})
public class Sessions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerosession")
    private Integer numerosession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerosession")
    private Collection<VoitureTourisme> voitureTourismeCollection;
    @JoinColumns({
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage"),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne")})
    @ManyToOne(optional = false)
    private Panel panel;
    @JoinColumn(name = "numeroetude", referencedColumnName = "numeroetude")
    @ManyToOne(optional = false)
    private Etude numeroetude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerosession")
    private Collection<Personne> personneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerosession")
    private Collection<Menage> menageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerosession")
    private Collection<Velo> veloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessions")
    private Collection<Occupationprincipale> occupationprincipaleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessions")
    private Collection<Activite> activiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerosession")
    private Collection<Moto> motoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerosession")
    private Collection<HabitudesUtilisationMode> habitudesUtilisationModeCollection;

    public Sessions() {
    }

    public Sessions(Integer numerosession) {
        this.numerosession = numerosession;
    }

    public Integer getNumerosession() {
        return numerosession;
    }

    public void setNumerosession(Integer numerosession) {
        this.numerosession = numerosession;
    }

    @XmlTransient
    public Collection<VoitureTourisme> getVoitureTourismeCollection() {
        return voitureTourismeCollection;
    }

    public void setVoitureTourismeCollection(Collection<VoitureTourisme> voitureTourismeCollection) {
        this.voitureTourismeCollection = voitureTourismeCollection;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public Etude getNumeroetude() {
        return numeroetude;
    }

    public void setNumeroetude(Etude numeroetude) {
        this.numeroetude = numeroetude;
    }

    @XmlTransient
    public Collection<Personne> getPersonneCollection() {
        return personneCollection;
    }

    public void setPersonneCollection(Collection<Personne> personneCollection) {
        this.personneCollection = personneCollection;
    }

    @XmlTransient
    public Collection<Menage> getMenageCollection() {
        return menageCollection;
    }

    public void setMenageCollection(Collection<Menage> menageCollection) {
        this.menageCollection = menageCollection;
    }

    @XmlTransient
    public Collection<Velo> getVeloCollection() {
        return veloCollection;
    }

    public void setVeloCollection(Collection<Velo> veloCollection) {
        this.veloCollection = veloCollection;
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

    @XmlTransient
    public Collection<Moto> getMotoCollection() {
        return motoCollection;
    }

    public void setMotoCollection(Collection<Moto> motoCollection) {
        this.motoCollection = motoCollection;
    }

    @XmlTransient
    public Collection<HabitudesUtilisationMode> getHabitudesUtilisationModeCollection() {
        return habitudesUtilisationModeCollection;
    }

    public void setHabitudesUtilisationModeCollection(Collection<HabitudesUtilisationMode> habitudesUtilisationModeCollection) {
        this.habitudesUtilisationModeCollection = habitudesUtilisationModeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerosession != null ? numerosession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.numerosession == null && other.numerosession != null) || (this.numerosession != null && !this.numerosession.equals(other.numerosession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Sessions[ numerosession=" + numerosession + " ]";
    }
    
}
