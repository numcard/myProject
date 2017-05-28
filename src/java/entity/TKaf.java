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
@Table(name = "tKaf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TKaf.findAll", query = "SELECT t FROM TKaf t")
    , @NamedQuery(name = "TKaf.findByNamekafsokr", query = "SELECT t FROM TKaf t WHERE t.namekafsokr = :namekafsokr")
    , @NamedQuery(name = "TKaf.findByNamekaf", query = "SELECT t FROM TKaf t WHERE t.namekaf = :namekaf")
    , @NamedQuery(name = "TKaf.findByZavKaf", query = "SELECT t FROM TKaf t WHERE t.zavKaf = :zavKaf")
    , @NamedQuery(name = "TKaf.findByPrim", query = "SELECT t FROM TKaf t WHERE t.prim = :prim")})
public class TKaf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name_kaf_sokr")
    private String namekafsokr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Name_kaf")
    private String namekaf;
    @Column(name = "zav_kaf")
    private Integer zavKaf;
    @Size(max = 150)
    @Column(name = "Prim")
    private String prim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "namekafsokr")
    private Collection<TPrepod> tPrepodCollection;

    public TKaf() {
    }

    public TKaf(String namekafsokr) {
        this.namekafsokr = namekafsokr;
    }

    public TKaf(String namekafsokr, String namekaf) {
        this.namekafsokr = namekafsokr;
        this.namekaf = namekaf;
    }

    public String getNamekafsokr() {
        return namekafsokr;
    }

    public void setNamekafsokr(String namekafsokr) {
        this.namekafsokr = namekafsokr;
    }

    public String getNamekaf() {
        return namekaf;
    }

    public void setNamekaf(String namekaf) {
        this.namekaf = namekaf;
    }

    public Integer getZavKaf() {
        return zavKaf;
    }

    public void setZavKaf(Integer zavKaf) {
        this.zavKaf = zavKaf;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
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
        hash += (namekafsokr != null ? namekafsokr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TKaf)) {
            return false;
        }
        TKaf other = (TKaf) object;
        if ((this.namekafsokr == null && other.namekafsokr != null) || (this.namekafsokr != null && !this.namekafsokr.equals(other.namekafsokr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TKaf[ namekafsokr=" + namekafsokr + " ]";
    }
    
}
