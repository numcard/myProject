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
@Table(name = "tUchZvan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUchZvan.findAll", query = "SELECT t FROM TUchZvan t")
    , @NamedQuery(name = "TUchZvan.findByIDscrank", query = "SELECT t FROM TUchZvan t WHERE t.iDscrank = :iDscrank")
    , @NamedQuery(name = "TUchZvan.findByShortScRank", query = "SELECT t FROM TUchZvan t WHERE t.shortScRank = :shortScRank")
    , @NamedQuery(name = "TUchZvan.findByScRank", query = "SELECT t FROM TUchZvan t WHERE t.scRank = :scRank")
    , @NamedQuery(name = "TUchZvan.findByNumZvan", query = "SELECT t FROM TUchZvan t WHERE t.numZvan = :numZvan")})
public class TUchZvan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_sc_rank")
    private Short iDscrank;
    @Size(max = 8)
    @Column(name = "short_sc_rank")
    private String shortScRank;
    @Size(max = 50)
    @Column(name = "sc_rank")
    private String scRank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_zvan")
    private short numZvan;
    @OneToMany(mappedBy = "iDscrank")
    private Collection<TPrepod> tPrepodCollection;

    public TUchZvan() {
    }

    public TUchZvan(Short iDscrank) {
        this.iDscrank = iDscrank;
    }

    public TUchZvan(Short iDscrank, short numZvan) {
        this.iDscrank = iDscrank;
        this.numZvan = numZvan;
    }

    public Short getIDscrank() {
        return iDscrank;
    }

    public void setIDscrank(Short iDscrank) {
        this.iDscrank = iDscrank;
    }

    public String getShortScRank() {
        return shortScRank;
    }

    public void setShortScRank(String shortScRank) {
        this.shortScRank = shortScRank;
    }

    public String getScRank() {
        return scRank;
    }

    public void setScRank(String scRank) {
        this.scRank = scRank;
    }

    public short getNumZvan() {
        return numZvan;
    }

    public void setNumZvan(short numZvan) {
        this.numZvan = numZvan;
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
        hash += (iDscrank != null ? iDscrank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUchZvan)) {
            return false;
        }
        TUchZvan other = (TUchZvan) object;
        if ((this.iDscrank == null && other.iDscrank != null) || (this.iDscrank != null && !this.iDscrank.equals(other.iDscrank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUchZvan[ iDscrank=" + iDscrank + " ]";
    }
    
}
