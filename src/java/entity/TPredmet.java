/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tPredmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPredmet.findAll", query = "SELECT t FROM TPredmet t")
    , @NamedQuery(name = "TPredmet.findByIDPredmet", query = "SELECT t FROM TPredmet t WHERE t.iDPredmet = :iDPredmet")
    , @NamedQuery(name = "TPredmet.findByNamePredmet", query = "SELECT t FROM TPredmet t WHERE t.namePredmet = :namePredmet")
    , @NamedQuery(name = "TPredmet.findBySrNamePredmet", query = "SELECT t FROM TPredmet t WHERE t.srNamePredmet = :srNamePredmet")})
public class TPredmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPredmet")
    private Integer iDPredmet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NamePredmet")
    private String namePredmet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SrNamePredmet")
    private String srNamePredmet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDPredmet")
    private Collection<TUmkTPredmet> tUmkTPredmetCollection;

    public TPredmet() {
    }

    public TPredmet(Integer iDPredmet) {
        this.iDPredmet = iDPredmet;
    }

    public TPredmet(Integer iDPredmet, String namePredmet, String srNamePredmet) {
        this.iDPredmet = iDPredmet;
        this.namePredmet = namePredmet;
        this.srNamePredmet = srNamePredmet;
    }

    public Integer getIDPredmet() {
        return iDPredmet;
    }

    public void setIDPredmet(Integer iDPredmet) {
        this.iDPredmet = iDPredmet;
    }

    public String getNamePredmet() {
        return namePredmet;
    }

    public void setNamePredmet(String namePredmet) {
        this.namePredmet = namePredmet;
    }

    public String getSrNamePredmet() {
        return srNamePredmet;
    }

    public void setSrNamePredmet(String srNamePredmet) {
        this.srNamePredmet = srNamePredmet;
    }

    @XmlTransient
    public Collection<TUmkTPredmet> getTUmkTPredmetCollection() {
        return tUmkTPredmetCollection;
    }

    public void setTUmkTPredmetCollection(Collection<TUmkTPredmet> tUmkTPredmetCollection) {
        this.tUmkTPredmetCollection = tUmkTPredmetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPredmet != null ? iDPredmet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPredmet)) {
            return false;
        }
        TPredmet other = (TPredmet) object;
        if ((this.iDPredmet == null && other.iDPredmet != null) || (this.iDPredmet != null && !this.iDPredmet.equals(other.iDPredmet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TPredmet[ iDPredmet=" + iDPredmet + " ]";
    }
    
}
