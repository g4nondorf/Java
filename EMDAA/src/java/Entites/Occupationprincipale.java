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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "occupationprincipale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Occupationprincipale.findAll", query = "SELECT o FROM Occupationprincipale o"),
    @NamedQuery(name = "Occupationprincipale.findByNumerocarreau", query = "SELECT o FROM Occupationprincipale o WHERE o.numerocarreau = :numerocarreau"),
    @NamedQuery(name = "Occupationprincipale.findByDispovoiture", query = "SELECT o FROM Occupationprincipale o WHERE o.dispovoiture = :dispovoiture"),
    @NamedQuery(name = "Occupationprincipale.findByProblemestationnement", query = "SELECT o FROM Occupationprincipale o WHERE o.problemestationnement = :problemestationnement"),
    @NamedQuery(name = "Occupationprincipale.findByProblemestationnementpossible", query = "SELECT o FROM Occupationprincipale o WHERE o.problemestationnementpossible = :problemestationnementpossible"),
    @NamedQuery(name = "Occupationprincipale.findByStationnementvelopossible", query = "SELECT o FROM Occupationprincipale o WHERE o.stationnementvelopossible = :stationnementvelopossible"),
    @NamedQuery(name = "Occupationprincipale.findByTypeoccupation", query = "SELECT o FROM Occupationprincipale o WHERE o.typeoccupation = :typeoccupation"),
    @NamedQuery(name = "Occupationprincipale.findByNumeropersonne", query = "SELECT o FROM Occupationprincipale o WHERE o.occupationprincipalePK.numeropersonne = :numeropersonne"),
    @NamedQuery(name = "Occupationprincipale.findByNumeromenage", query = "SELECT o FROM Occupationprincipale o WHERE o.occupationprincipalePK.numeromenage = :numeromenage"),
    @NamedQuery(name = "Occupationprincipale.findByNumerosession", query = "SELECT o FROM Occupationprincipale o WHERE o.occupationprincipalePK.numerosession = :numerosession")})
public class Occupationprincipale implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OccupationprincipalePK occupationprincipalePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocarreau")
    private int numerocarreau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dispovoiture")
    private int dispovoiture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "problemestationnement")
    private int problemestationnement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "problemestationnementpossible")
    private int problemestationnementpossible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stationnementvelopossible")
    private int stationnementvelopossible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeoccupation")
    private int typeoccupation;
    @JoinColumn(name = "numerosession", referencedColumnName = "numerosession", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sessions sessions;
    @JoinColumns({
        @JoinColumn(name = "numeromenage", referencedColumnName = "numeromenage", insertable = false, updatable = false),
        @JoinColumn(name = "numeropersonne", referencedColumnName = "numeropersonne", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Panel panel;

    public Occupationprincipale() {
    }

    public Occupationprincipale(OccupationprincipalePK occupationprincipalePK) {
        this.occupationprincipalePK = occupationprincipalePK;
    }

    public Occupationprincipale(OccupationprincipalePK occupationprincipalePK, int numerocarreau, int dispovoiture, int problemestationnement, int problemestationnementpossible, int stationnementvelopossible, int typeoccupation) {
        this.occupationprincipalePK = occupationprincipalePK;
        this.numerocarreau = numerocarreau;
        this.dispovoiture = dispovoiture;
        this.problemestationnement = problemestationnement;
        this.problemestationnementpossible = problemestationnementpossible;
        this.stationnementvelopossible = stationnementvelopossible;
        this.typeoccupation = typeoccupation;
    }

    public Occupationprincipale(int numeropersonne, int numeromenage, int numerosession) {
        this.occupationprincipalePK = new OccupationprincipalePK(numeropersonne, numeromenage, numerosession);
    }

    public OccupationprincipalePK getOccupationprincipalePK() {
        return occupationprincipalePK;
    }

    public void setOccupationprincipalePK(OccupationprincipalePK occupationprincipalePK) {
        this.occupationprincipalePK = occupationprincipalePK;
    }

    public int getNumerocarreau() {
        return numerocarreau;
    }

    public void setNumerocarreau(int numerocarreau) {
        this.numerocarreau = numerocarreau;
    }

    public int getDispovoiture() {
        return dispovoiture;
    }

    public void setDispovoiture(int dispovoiture) {
        this.dispovoiture = dispovoiture;
    }

    public int getProblemestationnement() {
        return problemestationnement;
    }

    public void setProblemestationnement(int problemestationnement) {
        this.problemestationnement = problemestationnement;
    }

    public int getProblemestationnementpossible() {
        return problemestationnementpossible;
    }

    public void setProblemestationnementpossible(int problemestationnementpossible) {
        this.problemestationnementpossible = problemestationnementpossible;
    }

    public int getStationnementvelopossible() {
        return stationnementvelopossible;
    }

    public void setStationnementvelopossible(int stationnementvelopossible) {
        this.stationnementvelopossible = stationnementvelopossible;
    }

    public int getTypeoccupation() {
        return typeoccupation;
    }

    public void setTypeoccupation(int typeoccupation) {
        this.typeoccupation = typeoccupation;
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
        hash += (occupationprincipalePK != null ? occupationprincipalePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occupationprincipale)) {
            return false;
        }
        Occupationprincipale other = (Occupationprincipale) object;
        if ((this.occupationprincipalePK == null && other.occupationprincipalePK != null) || (this.occupationprincipalePK != null && !this.occupationprincipalePK.equals(other.occupationprincipalePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Occupationprincipale[ occupationprincipalePK=" + occupationprincipalePK + " ]";
    }
    
}
