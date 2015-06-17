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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByNumeropersonne", query = "SELECT p FROM Personne p WHERE p.personnePK.numeropersonne = :numeropersonne"),
    @NamedQuery(name = "Personne.findByNumeromenage", query = "SELECT p FROM Personne p WHERE p.personnePK.numeromenage = :numeromenage"),
    @NamedQuery(name = "Personne.findByLienpersonnereference", query = "SELECT p FROM Personne p WHERE p.lienpersonnereference = :lienpersonnereference"),
    @NamedQuery(name = "Personne.findBySexe", query = "SELECT p FROM Personne p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Personne.findByPossessionstelportable", query = "SELECT p FROM Personne p WHERE p.possessionstelportable = :possessionstelportable"),
    @NamedQuery(name = "Personne.findByPossessionspermis", query = "SELECT p FROM Personne p WHERE p.possessionspermis = :possessionspermis"),
    @NamedQuery(name = "Personne.findByEMail", query = "SELECT p FROM Personne p WHERE p.eMail = :eMail"),
    @NamedQuery(name = "Personne.findByOccupationprincepale", query = "SELECT p FROM Personne p WHERE p.occupationprincepale = :occupationprincepale"),
    @NamedQuery(name = "Personne.findByNiveauetude", query = "SELECT p FROM Personne p WHERE p.niveauetude = :niveauetude")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonnePK personnePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lienpersonnereference")
    private int lienpersonnereference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexe")
    private int sexe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "possessionstelportable")
    private boolean possessionstelportable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "possessionspermis")
    private int possessionspermis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "e_mail")
    private int eMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "occupationprincepale")
    private int occupationprincepale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "niveauetude")
    private int niveauetude;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession")
    @ManyToOne(optional = false)
    private Sessions numerosession;
    @JoinColumns({
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Panel panel;

    public Personne() {
    }

    public Personne(PersonnePK personnePK) {
        this.personnePK = personnePK;
    }

    public Personne(PersonnePK personnePK, int lienpersonnereference, int sexe, boolean possessionstelportable, int possessionspermis, int eMail, int occupationprincepale, int niveauetude) {
        this.personnePK = personnePK;
        this.lienpersonnereference = lienpersonnereference;
        this.sexe = sexe;
        this.possessionstelportable = possessionstelportable;
        this.possessionspermis = possessionspermis;
        this.eMail = eMail;
        this.occupationprincepale = occupationprincepale;
        this.niveauetude = niveauetude;
    }

    public Personne(int numeropersonne, int numeromenage) {
        this.personnePK = new PersonnePK(numeropersonne, numeromenage);
    }

    public PersonnePK getPersonnePK() {
        return personnePK;
    }

    public void setPersonnePK(PersonnePK personnePK) {
        this.personnePK = personnePK;
    }

    public int getLienpersonnereference() {
        return lienpersonnereference;
    }

    public void setLienpersonnereference(int lienpersonnereference) {
        this.lienpersonnereference = lienpersonnereference;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public boolean getPossessionstelportable() {
        return possessionstelportable;
    }

    public void setPossessionstelportable(boolean possessionstelportable) {
        this.possessionstelportable = possessionstelportable;
    }

    public int getPossessionspermis() {
        return possessionspermis;
    }

    public void setPossessionspermis(int possessionspermis) {
        this.possessionspermis = possessionspermis;
    }

    public int getEMail() {
        return eMail;
    }

    public void setEMail(int eMail) {
        this.eMail = eMail;
    }

    public int getOccupationprincepale() {
        return occupationprincepale;
    }

    public void setOccupationprincepale(int occupationprincepale) {
        this.occupationprincepale = occupationprincepale;
    }

    public int getNiveauetude() {
        return niveauetude;
    }

    public void setNiveauetude(int niveauetude) {
        this.niveauetude = niveauetude;
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
        hash += (personnePK != null ? personnePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.personnePK == null && other.personnePK != null) || (this.personnePK != null && !this.personnePK.equals(other.personnePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Personne[ personnePK=" + personnePK + " ]";
    }
    
}
