/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "tFileDoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFileDoc.findAll", query = "SELECT t FROM TFileDoc t")
    , @NamedQuery(name = "TFileDoc.findByIdFileDoc", query = "SELECT t FROM TFileDoc t WHERE t.idFileDoc = :idFileDoc")
    , @NamedQuery(name = "TFileDoc.findByIdTableFileDoc", query = "SELECT t FROM TFileDoc t WHERE t.idTableFileDoc = :idTableFileDoc")})
public class TFileDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFileDoc")
    private Integer idFileDoc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "FileDoc")
    private byte[] fileDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTableFileDoc")
    private int idTableFileDoc;

    public TFileDoc() {
    }

    public TFileDoc(Integer idFileDoc) {
        this.idFileDoc = idFileDoc;
    }

    public TFileDoc(Integer idFileDoc, byte[] fileDoc, int idTableFileDoc) {
        this.idFileDoc = idFileDoc;
        this.fileDoc = fileDoc;
        this.idTableFileDoc = idTableFileDoc;
    }

    public Integer getIdFileDoc() {
        return idFileDoc;
    }

    public void setIdFileDoc(Integer idFileDoc) {
        this.idFileDoc = idFileDoc;
    }

    public byte[] getFileDoc() {
        return fileDoc;
    }

    public void setFileDoc(byte[] fileDoc) {
        this.fileDoc = fileDoc;
    }

    public int getIdTableFileDoc() {
        return idTableFileDoc;
    }

    public void setIdTableFileDoc(int idTableFileDoc) {
        this.idTableFileDoc = idTableFileDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFileDoc != null ? idFileDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFileDoc)) {
            return false;
        }
        TFileDoc other = (TFileDoc) object;
        if ((this.idFileDoc == null && other.idFileDoc != null) || (this.idFileDoc != null && !this.idFileDoc.equals(other.idFileDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TFileDoc[ idFileDoc=" + idFileDoc + " ]";
    }
    
}
