/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "habitudes_utilisation_mode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HabitudesUtilisationMode.findAll", query = "SELECT h FROM HabitudesUtilisationMode h"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByApied", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.apied = :apied"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByBicicletteconducteur", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.bicicletteconducteur = :bicicletteconducteur"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByMoto", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.moto = :moto"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByVoiturepersonnellecoducteur", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.voiturepersonnellecoducteur = :voiturepersonnellecoducteur"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByVoiturepersonnellepassager", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.voiturepersonnellepassager = :voiturepersonnellepassager"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByEnsemblereseauurban", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.ensemblereseauurban = :ensemblereseauurban"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByNumeropersonne", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.habitudesUtilisationModePK.numeropersonne = :numeropersonne"),
    @NamedQuery(name = "HabitudesUtilisationMode.findByNumeromenage", query = "SELECT h FROM HabitudesUtilisationMode h WHERE h.habitudesUtilisationModePK.numeromenage = :numeromenage")})
public class HabitudesUtilisationMode implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HabitudesUtilisationModePK habitudesUtilisationModePK;
    @Basic(optional = false)
    @Column(name = "apied")
    private int apied;
    @Basic(optional = false)
    @Column(name = "bicicletteconducteur")
    private int bicicletteconducteur;
    @Basic(optional = false)
    @Column(name = "moto")
    private int moto;
    @Basic(optional = false)
    @Column(name = "voiturepersonnellecoducteur")
    private int voiturepersonnellecoducteur;
    @Basic(optional = false)
    @Column(name = "voiturepersonnellepassager")
    private int voiturepersonnellepassager;
    @Basic(optional = false)
    @Column(name = "ensemblereseauurban")
    private int ensemblereseauurban;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession")
    @ManyToOne(optional = false)
    private Sessions numerosession;
    @JoinColumns({
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Panel panel;

    public HabitudesUtilisationMode() {
    }

    public HabitudesUtilisationMode(HabitudesUtilisationModePK habitudesUtilisationModePK) {
        this.habitudesUtilisationModePK = habitudesUtilisationModePK;
    }

    public HabitudesUtilisationMode(HabitudesUtilisationModePK habitudesUtilisationModePK, int apied, int bicicletteconducteur, int moto, int voiturepersonnellecoducteur, int voiturepersonnellepassager, int ensemblereseauurban) {
        this.habitudesUtilisationModePK = habitudesUtilisationModePK;
        this.apied = apied;
        this.bicicletteconducteur = bicicletteconducteur;
        this.moto = moto;
        this.voiturepersonnellecoducteur = voiturepersonnellecoducteur;
        this.voiturepersonnellepassager = voiturepersonnellepassager;
        this.ensemblereseauurban = ensemblereseauurban;
    }

    public HabitudesUtilisationMode(int numeropersonne, int numeromenage) {
        this.habitudesUtilisationModePK = new HabitudesUtilisationModePK(numeropersonne, numeromenage);
    }

    public HabitudesUtilisationModePK getHabitudesUtilisationModePK() {
        return habitudesUtilisationModePK;
    }

    public void setHabitudesUtilisationModePK(HabitudesUtilisationModePK habitudesUtilisationModePK) {
        this.habitudesUtilisationModePK = habitudesUtilisationModePK;
    }

    public int getApied() {
        return apied;
    }

    public void setApied(int apied) {
        this.apied = apied;
    }

    public int getBicicletteconducteur() {
        return bicicletteconducteur;
    }

    public void setBicicletteconducteur(int bicicletteconducteur) {
        this.bicicletteconducteur = bicicletteconducteur;
    }

    public int getMoto() {
        return moto;
    }

    public void setMoto(int moto) {
        this.moto = moto;
    }

    public int getVoiturepersonnellecoducteur() {
        return voiturepersonnellecoducteur;
    }

    public void setVoiturepersonnellecoducteur(int voiturepersonnellecoducteur) {
        this.voiturepersonnellecoducteur = voiturepersonnellecoducteur;
    }

    public int getVoiturepersonnellepassager() {
        return voiturepersonnellepassager;
    }

    public void setVoiturepersonnellepassager(int voiturepersonnellepassager) {
        this.voiturepersonnellepassager = voiturepersonnellepassager;
    }

    public int getEnsemblereseauurban() {
        return ensemblereseauurban;
    }

    public void setEnsemblereseauurban(int ensemblereseauurban) {
        this.ensemblereseauurban = ensemblereseauurban;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habitudesUtilisationModePK != null ? habitudesUtilisationModePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitudesUtilisationMode)) {
            return false;
        }
        HabitudesUtilisationMode other = (HabitudesUtilisationMode) object;
        if ((this.habitudesUtilisationModePK == null && other.habitudesUtilisationModePK != null) || (this.habitudesUtilisationModePK != null && !this.habitudesUtilisationModePK.equals(other.habitudesUtilisationModePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.HabitudesUtilisationMode[ habitudesUtilisationModePK=" + habitudesUtilisationModePK + " ]";
    }
    
}
