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
@Table(name = "tUchStepen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUchStepen.findAll", query = "SELECT t FROM TUchStepen t")
    , @NamedQuery(name = "TUchStepen.findByIDscdegree", query = "SELECT t FROM TUchStepen t WHERE t.iDscdegree = :iDscdegree")
    , @NamedQuery(name = "TUchStepen.findByShortScDegree", query = "SELECT t FROM TUchStepen t WHERE t.shortScDegree = :shortScDegree")
    , @NamedQuery(name = "TUchStepen.findByScDegree", query = "SELECT t FROM TUchStepen t WHERE t.scDegree = :scDegree")
    , @NamedQuery(name = "TUchStepen.findByNumStepen", query = "SELECT t FROM TUchStepen t WHERE t.numStepen = :numStepen")})
public class TUchStepen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_sc_degree")
    private Short iDscdegree;
    @Size(max = 10)
    @Column(name = "short_sc_degree")
    private String shortScDegree;
    @Size(max = 50)
    @Column(name = "sc_degree")
    private String scDegree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_stepen")
    private short numStepen;
    @OneToMany(mappedBy = "iDscdegree")
    private Collection<TPrepod> tPrepodCollection;

    public TUchStepen() {
    }

    public TUchStepen(Short iDscdegree) {
        this.iDscdegree = iDscdegree;
    }

    public TUchStepen(Short iDscdegree, short numStepen) {
        this.iDscdegree = iDscdegree;
        this.numStepen = numStepen;
    }

    public Short getIDscdegree() {
        return iDscdegree;
    }

    public void setIDscdegree(Short iDscdegree) {
        this.iDscdegree = iDscdegree;
    }

    public String getShortScDegree() {
        return shortScDegree;
    }

    public void setShortScDegree(String shortScDegree) {
        this.shortScDegree = shortScDegree;
    }

    public String getScDegree() {
        return scDegree;
    }

    public void setScDegree(String scDegree) {
        this.scDegree = scDegree;
    }

    public short getNumStepen() {
        return numStepen;
    }

    public void setNumStepen(short numStepen) {
        this.numStepen = numStepen;
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
        hash += (iDscdegree != null ? iDscdegree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUchStepen)) {
            return false;
        }
        TUchStepen other = (TUchStepen) object;
        if ((this.iDscdegree == null && other.iDscdegree != null) || (this.iDscdegree != null && !this.iDscdegree.equals(other.iDscdegree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUchStepen[ iDscdegree=" + iDscdegree + " ]";
    }
    
}
