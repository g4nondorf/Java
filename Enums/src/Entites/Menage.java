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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "menage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menage.findAll", query = "SELECT m FROM Menage m"),
    @NamedQuery(name = "Menage.findByNumeromenage", query = "SELECT m FROM Menage m WHERE m.numeromenage = :numeromenage"),
    @NamedQuery(name = "Menage.findByTelephonfixe", query = "SELECT m FROM Menage m WHERE m.telephonfixe = :telephonfixe"),
    @NamedQuery(name = "Menage.findByTypeabonnementtelephonefixe", query = "SELECT m FROM Menage m WHERE m.typeabonnementtelephonefixe = :typeabonnementtelephonefixe"),
    @NamedQuery(name = "Menage.findByInternet", query = "SELECT m FROM Menage m WHERE m.internet = :internet"),
    @NamedQuery(name = "Menage.findByHabitat", query = "SELECT m FROM Menage m WHERE m.habitat = :habitat"),
    @NamedQuery(name = "Menage.findByPossessions", query = "SELECT m FROM Menage m WHERE m.possessions = :possessions")})
public class Menage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeromenage")
    private Integer numeromenage;
    @Basic(optional = false)
    @Column(name = "telephonfixe")
    private boolean telephonfixe;
    @Basic(optional = false)
    @Column(name = "typeabonnementtelephonefixe")
    private int typeabonnementtelephonefixe;
    @Basic(optional = false)
    @Column(name = "internet")
    private boolean internet;
    @Basic(optional = false)
    @Column(name = "habitat")
    private int habitat;
    @Basic(optional = false)
    @Column(name = "possessions")
    private int possessions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menage")
    private Collection<VoitureTourisme> voitureTourismeCollection;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession")
    @ManyToOne(optional = false)
    private Sessions numerosession;
    @JoinColumns({
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne")})
    @ManyToOne(optional = false)
    private Panel panel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menage")
    private Collection<Velo> veloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menage")
    private Collection<Moto> motoCollection;

    public Menage() {
    }

    public Menage(Integer numeromenage) {
        this.numeromenage = numeromenage;
    }

    public Menage(Integer numeromenage, boolean telephonfixe, int typeabonnementtelephonefixe, boolean internet, int habitat, int possessions) {
        this.numeromenage = numeromenage;
        this.telephonfixe = telephonfixe;
        this.typeabonnementtelephonefixe = typeabonnementtelephonefixe;
        this.internet = internet;
        this.habitat = habitat;
        this.possessions = possessions;
    }

    public Integer getNumeromenage() {
        return numeromenage;
    }

    public void setNumeromenage(Integer numeromenage) {
        this.numeromenage = numeromenage;
    }

    public boolean getTelephonfixe() {
        return telephonfixe;
    }

    public void setTelephonfixe(boolean telephonfixe) {
        this.telephonfixe = telephonfixe;
    }

    public int getTypeabonnementtelephonefixe() {
        return typeabonnementtelephonefixe;
    }

    public void setTypeabonnementtelephonefixe(int typeabonnementtelephonefixe) {
        this.typeabonnementtelephonefixe = typeabonnementtelephonefixe;
    }

    public boolean getInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public int getHabitat() {
        return habitat;
    }

    public void setHabitat(int habitat) {
        this.habitat = habitat;
    }

    public int getPossessions() {
        return possessions;
    }

    public void setPossessions(int possessions) {
        this.possessions = possessions;
    }

    @XmlTransient
    public Collection<VoitureTourisme> getVoitureTourismeCollection() {
        return voitureTourismeCollection;
    }

    public void setVoitureTourismeCollection(Collection<VoitureTourisme> voitureTourismeCollection) {
        this.voitureTourismeCollection = voitureTourismeCollection;
    }

    public Sessions getNumerosession() {
        return numerosession;
    }

    public void setNumerosession(Sessions numerosession) {
        this.numerosession = numerosession;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    @XmlTransient
    public Collection<Velo> getVeloCollection() {
        return veloCollection;
    }

    public void setVeloCollection(Collection<Velo> veloCollection) {
        this.veloCollection = veloCollection;
    }

    @XmlTransient
    public Collection<Moto> getMotoCollection() {
        return motoCollection;
    }

    public void setMotoCollection(Collection<Moto> motoCollection) {
        this.motoCollection = motoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeromenage != null ? numeromenage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menage)) {
            return false;
        }
        Menage other = (Menage) object;
        if ((this.numeromenage == null && other.numeromenage != null) || (this.numeromenage != null && !this.numeromenage.equals(other.numeromenage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Menage[ numeromenage=" + numeromenage + " ]";
    }
    
}
