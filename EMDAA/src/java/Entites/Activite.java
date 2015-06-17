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
import javax.persistence.JoinColumns;
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
@Table(name = "activite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a"),
    @NamedQuery(name = "Activite.findByNumeroa", query = "SELECT a FROM Activite a WHERE a.activitePK.numeroa = :numeroa"),
    @NamedQuery(name = "Activite.findByHeurearrivee", query = "SELECT a FROM Activite a WHERE a.heurearrivee = :heurearrivee"),
    @NamedQuery(name = "Activite.findByHeuredepart", query = "SELECT a FROM Activite a WHERE a.heuredepart = :heuredepart"),
    @NamedQuery(name = "Activite.findByModetransport", query = "SELECT a FROM Activite a WHERE a.modetransport = :modetransport"),
    @NamedQuery(name = "Activite.findByTypeactivite", query = "SELECT a FROM Activite a WHERE a.typeactivite = :typeactivite"),
    @NamedQuery(name = "Activite.findByStationnement", query = "SELECT a FROM Activite a WHERE a.stationnement = :stationnement"),
    @NamedQuery(name = "Activite.findByNbpersonnes", query = "SELECT a FROM Activite a WHERE a.nbpersonnes = :nbpersonnes"),
    @NamedQuery(name = "Activite.findByNumeropersonne", query = "SELECT a FROM Activite a WHERE a.activitePK.numeropersonne = :numeropersonne"),
    @NamedQuery(name = "Activite.findByNumeromenage", query = "SELECT a FROM Activite a WHERE a.activitePK.numeromenage = :numeromenage"),
    @NamedQuery(name = "Activite.findByNumerosession", query = "SELECT a FROM Activite a WHERE a.activitePK.numerosession = :numerosession"),
    @NamedQuery(name = "Activite.findByNumerocarreau", query = "SELECT a FROM Activite a WHERE a.numerocarreau = :numerocarreau")})
public class Activite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivitePK activitePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heurearrivee")
    @Temporal(TemporalType.DATE)
    private Date heurearrivee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heuredepart")
    @Temporal(TemporalType.DATE)
    private Date heuredepart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modetransport")
    private int modetransport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeactivite")
    private int typeactivite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stationnement")
    private int stationnement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbpersonnes")
    private int nbpersonnes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocarreau")
    private int numerocarreau;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sessions sessions;
    @JoinColumns({
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Panel panel;

    public Activite() {
    }

    public Activite(ActivitePK activitePK) {
        this.activitePK = activitePK;
    }

    public Activite(ActivitePK activitePK, Date heurearrivee, Date heuredepart, int modetransport, int typeactivite, int stationnement, int nbpersonnes, int numerocarreau) {
        this.activitePK = activitePK;
        this.heurearrivee = heurearrivee;
        this.heuredepart = heuredepart;
        this.modetransport = modetransport;
        this.typeactivite = typeactivite;
        this.stationnement = stationnement;
        this.nbpersonnes = nbpersonnes;
        this.numerocarreau = numerocarreau;
    }

    public Activite(int numeroa, int numeropersonne, int numeromenage, int numerosession) {
        this.activitePK = new ActivitePK(numeroa, numeropersonne, numeromenage, numerosession);
    }

    public ActivitePK getActivitePK() {
        return activitePK;
    }

    public void setActivitePK(ActivitePK activitePK) {
        this.activitePK = activitePK;
    }

    public Date getHeurearrivee() {
        return heurearrivee;
    }

    public void setHeurearrivee(Date heurearrivee) {
        this.heurearrivee = heurearrivee;
    }

    public Date getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(Date heuredepart) {
        this.heuredepart = heuredepart;
    }

    public int getModetransport() {
        return modetransport;
    }

    public void setModetransport(int modetransport) {
        this.modetransport = modetransport;
    }

    public int getTypeactivite() {
        return typeactivite;
    }

    public void setTypeactivite(int typeactivite) {
        this.typeactivite = typeactivite;
    }

    public int getStationnement() {
        return stationnement;
    }

    public void setStationnement(int stationnement) {
        this.stationnement = stationnement;
    }

    public int getNbpersonnes() {
        return nbpersonnes;
    }

    public void setNbpersonnes(int nbpersonnes) {
        this.nbpersonnes = nbpersonnes;
    }

    public int getNumerocarreau() {
        return numerocarreau;
    }

    public void setNumerocarreau(int numerocarreau) {
        this.numerocarreau = numerocarreau;
    }

    public Sessions getSessions() {
        return sessions;
    }

    public void setSessions(Sessions sessions) {
        this.sessions = sessions;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activitePK != null ? activitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activite)) {
            return false;
        }
        Activite other = (Activite) object;
        if ((this.activitePK == null && other.activitePK != null) || (this.activitePK != null && !this.activitePK.equals(other.activitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Activite[ activitePK=" + activitePK + " ]";
    }
    
}
