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
@Table(name = "tVidDocument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TVidDocument.findAll", query = "SELECT t FROM TVidDocument t")
    , @NamedQuery(name = "TVidDocument.findByVidDocum", query = "SELECT t FROM TVidDocument t WHERE t.vidDocum = :vidDocum")
    , @NamedQuery(name = "TVidDocument.findByTipDcum", query = "SELECT t FROM TVidDocument t WHERE t.tipDcum = :tipDcum")})
public class TVidDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VidDocum")
    private String vidDocum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipDcum")
    private String tipDcum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vidDocum")
    private Collection<TUmkPredmetDocument> tUmkPredmetDocumentCollection;

    public TVidDocument() {
    }

    public TVidDocument(String vidDocum) {
        this.vidDocum = vidDocum;
    }

    public TVidDocument(String vidDocum, String tipDcum) {
        this.vidDocum = vidDocum;
        this.tipDcum = tipDcum;
    }

    public String getVidDocum() {
        return vidDocum;
    }

    public void setVidDocum(String vidDocum) {
        this.vidDocum = vidDocum;
    }

    public String getTipDcum() {
        return tipDcum;
    }

    public void setTipDcum(String tipDcum) {
        this.tipDcum = tipDcum;
    }

    @XmlTransient
    public Collection<TUmkPredmetDocument> getTUmkPredmetDocumentCollection() {
        return tUmkPredmetDocumentCollection;
    }

    public void setTUmkPredmetDocumentCollection(Collection<TUmkPredmetDocument> tUmkPredmetDocumentCollection) {
        this.tUmkPredmetDocumentCollection = tUmkPredmetDocumentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vidDocum != null ? vidDocum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TVidDocument)) {
            return false;
        }
        TVidDocument other = (TVidDocument) object;
        if ((this.vidDocum == null && other.vidDocum != null) || (this.vidDocum != null && !this.vidDocum.equals(other.vidDocum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TVidDocument[ vidDocum=" + vidDocum + " ]";
    }
    
}
