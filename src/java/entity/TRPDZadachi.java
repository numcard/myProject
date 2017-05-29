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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "tRPDZadachi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRPDZadachi.findAll", query = "SELECT t FROM TRPDZadachi t")
    , @NamedQuery(name = "TRPDZadachi.findByIdRPDZadachi", query = "SELECT t FROM TRPDZadachi t WHERE t.idRPDZadachi = :idRPDZadachi")
    , @NamedQuery(name = "TRPDZadachi.findByRPDZadacha", query = "SELECT t FROM TRPDZadachi t WHERE t.rPDZadacha = :rPDZadacha")})
public class TRPDZadachi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRPDZadachi")
    private Integer idRPDZadachi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "RPDZadacha")
    private String rPDZadacha;
    @JoinColumn(name = "idUmkPredmetDocument", referencedColumnName = "idUmkPredmetDocument")
    @ManyToOne(optional = false)
    private TUmkPredmetDocument idUmkPredmetDocument;

    public TRPDZadachi() {
    }

    public TRPDZadachi(Integer idRPDZadachi) {
        this.idRPDZadachi = idRPDZadachi;
    }

    public TRPDZadachi(Integer idRPDZadachi, String rPDZadacha) {
        this.idRPDZadachi = idRPDZadachi;
        this.rPDZadacha = rPDZadacha;
    }

    public Integer getIdRPDZadachi() {
        return idRPDZadachi;
    }

    public void setIdRPDZadachi(Integer idRPDZadachi) {
        this.idRPDZadachi = idRPDZadachi;
    }

    public String getRPDZadacha() {
        return rPDZadacha;
    }

    public void setRPDZadacha(String rPDZadacha) {
        this.rPDZadacha = rPDZadacha;
    }

    public TUmkPredmetDocument getIdUmkPredmetDocument() {
        return idUmkPredmetDocument;
    }

    public void setIdUmkPredmetDocument(TUmkPredmetDocument idUmkPredmetDocument) {
        this.idUmkPredmetDocument = idUmkPredmetDocument;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRPDZadachi != null ? idRPDZadachi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRPDZadachi)) {
            return false;
        }
        TRPDZadachi other = (TRPDZadachi) object;
        if ((this.idRPDZadachi == null && other.idRPDZadachi != null) || (this.idRPDZadachi != null && !this.idRPDZadachi.equals(other.idRPDZadachi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TRPDZadachi[ idRPDZadachi=" + idRPDZadachi + " ]";
    }
    
}
