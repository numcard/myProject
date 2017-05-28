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
@Table(name = "tUchCikl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUchCikl.findAll", query = "SELECT t FROM TUchCikl t")
    , @NamedQuery(name = "TUchCikl.findByNumUchCikl", query = "SELECT t FROM TUchCikl t WHERE t.numUchCikl = :numUchCikl")
    , @NamedQuery(name = "TUchCikl.findByNameUchCikl", query = "SELECT t FROM TUchCikl t WHERE t.nameUchCikl = :nameUchCikl")
    , @NamedQuery(name = "TUchCikl.findByNumPP", query = "SELECT t FROM TUchCikl t WHERE t.numPP = :numPP")
    , @NamedQuery(name = "TUchCikl.findByNumSort", query = "SELECT t FROM TUchCikl t WHERE t.numSort = :numSort")
    , @NamedQuery(name = "TUchCikl.findByNumCikl", query = "SELECT t FROM TUchCikl t WHERE t.numCikl = :numCikl")})
public class TUchCikl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NumUchCikl")
    private String numUchCikl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NameUchCikl")
    private String nameUchCikl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumPP")
    private short numPP;
    @Column(name = "NumSort")
    private Integer numSort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumCikl")
    private int numCikl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numUchCikl")
    private Collection<TUmkTPredmet> tUmkTPredmetCollection;

    public TUchCikl() {
    }

    public TUchCikl(String numUchCikl) {
        this.numUchCikl = numUchCikl;
    }

    public TUchCikl(String numUchCikl, String nameUchCikl, short numPP, int numCikl) {
        this.numUchCikl = numUchCikl;
        this.nameUchCikl = nameUchCikl;
        this.numPP = numPP;
        this.numCikl = numCikl;
    }

    public String getNumUchCikl() {
        return numUchCikl;
    }

    public void setNumUchCikl(String numUchCikl) {
        this.numUchCikl = numUchCikl;
    }

    public String getNameUchCikl() {
        return nameUchCikl;
    }

    public void setNameUchCikl(String nameUchCikl) {
        this.nameUchCikl = nameUchCikl;
    }

    public short getNumPP() {
        return numPP;
    }

    public void setNumPP(short numPP) {
        this.numPP = numPP;
    }

    public Integer getNumSort() {
        return numSort;
    }

    public void setNumSort(Integer numSort) {
        this.numSort = numSort;
    }

    public int getNumCikl() {
        return numCikl;
    }

    public void setNumCikl(int numCikl) {
        this.numCikl = numCikl;
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
        hash += (numUchCikl != null ? numUchCikl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUchCikl)) {
            return false;
        }
        TUchCikl other = (TUchCikl) object;
        if ((this.numUchCikl == null && other.numUchCikl != null) || (this.numUchCikl != null && !this.numUchCikl.equals(other.numUchCikl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUchCikl[ numUchCikl=" + numUchCikl + " ]";
    }
    
}
