/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Александр
 */
@Entity
@Table(name = "tDolgnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDolgnost.findAll", query = "SELECT t FROM TDolgnost t")
    , @NamedQuery(name = "TDolgnost.findByDolgnost", query = "SELECT t FROM TDolgnost t WHERE t.dolgnost = :dolgnost")
    , @NamedQuery(name = "TDolgnost.findByDolgnostSkr", query = "SELECT t FROM TDolgnost t WHERE t.dolgnostSkr = :dolgnostSkr")
    , @NamedQuery(name = "TDolgnost.findByKolChasStavka", query = "SELECT t FROM TDolgnost t WHERE t.kolChasStavka = :kolChasStavka")})
public class TDolgnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "Dolgnost")
    private String dolgnost;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "DolgnostSkr")
    private String dolgnostSkr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KolChasStavka")
    private int kolChasStavka;
    @OneToMany(mappedBy = "dolgnostSkr")
    private Collection<TPrepod> tPrepodCollection;

    public TDolgnost() {
    }

    public TDolgnost(String dolgnostSkr) {
        this.dolgnostSkr = dolgnostSkr;
    }

    public TDolgnost(String dolgnostSkr, int kolChasStavka) {
        this.dolgnostSkr = dolgnostSkr;
        this.kolChasStavka = kolChasStavka;
    }

    public String getDolgnost() {
        return dolgnost;
    }

    public void setDolgnost(String dolgnost) {
        this.dolgnost = dolgnost;
    }

    public String getDolgnostSkr() {
        return dolgnostSkr;
    }

    public void setDolgnostSkr(String dolgnostSkr) {
        this.dolgnostSkr = dolgnostSkr;
    }

    public int getKolChasStavka() {
        return kolChasStavka;
    }

    public void setKolChasStavka(int kolChasStavka) {
        this.kolChasStavka = kolChasStavka;
    }

    @XmlTransient
    public Collection<TPrepod> getTPrepodCollection() {
        return tPrepodCollection;
    }

    public void setTPrepodCollection(Collection<TPrepod> tPrepodCollection) {
        this.tPrepodCollection = tPrepodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dolgnostSkr != null ? dolgnostSkr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDolgnost)) {
            return false;
        }
        TDolgnost other = (TDolgnost) object;
        if ((this.dolgnostSkr == null && other.dolgnostSkr != null) || (this.dolgnostSkr != null && !this.dolgnostSkr.equals(other.dolgnostSkr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TDolgnost[ dolgnostSkr=" + dolgnostSkr + " ]";
    }
    
}
