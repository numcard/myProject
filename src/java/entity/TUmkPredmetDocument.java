/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "tUmkPredmetDocument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUmkPredmetDocument.findAll", query = "SELECT t FROM TUmkPredmetDocument t")
    , @NamedQuery(name = "TUmkPredmetDocument.findByDataDocum", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.dataDocum = :dataDocum")
    , @NamedQuery(name = "TUmkPredmetDocument.findByDescript", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.descript = :descript")
    , @NamedQuery(name = "TUmkPredmetDocument.findByStatus", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.status = :status")
    , @NamedQuery(name = "TUmkPredmetDocument.findByPrepod", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.prepod = :prepod")
    , @NamedQuery(name = "TUmkPredmetDocument.findByIdUmkPredmetDocument", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.idUmkPredmetDocument = :idUmkPredmetDocument")
    , @NamedQuery(name = "TUmkPredmetDocument.findByCelPredmet", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.celPredmet = :celPredmet")
    , @NamedQuery(name = "TUmkPredmetDocument.findByIdUmkPredmetDocumentOLD", query = "SELECT t FROM TUmkPredmetDocument t WHERE t.idUmkPredmetDocumentOLD = :idUmkPredmetDocumentOLD")})
public class TUmkPredmetDocument implements Serializable {

    /*@Column(name = "Prepod")
    private Integer prepod;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUmkPredmetDocument")
    private Collection<TRPDZadachi> tRPDZadachiCollection;
    
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataDocum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDocum;
    @Size(max = 255)
    @Column(name = "Descript")
    private String descript;
    @Size(max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "prepod", referencedColumnName = "ID_teacher")
    @ManyToOne
    private TPrepod prepod;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUmkPredmetDocument")
    private Integer idUmkPredmetDocument;
    @Size(max = 2147483647)
    @Column(name = "CelPredmet")
    private String celPredmet;
    @Column(name = "idUmkPredmetDocumentOLD")
    private Integer idUmkPredmetDocumentOLD;
    @Column(name = "idFileDoc")
    private int idFileDoc;
    @JoinColumn(name = "IDUmkPredmet", referencedColumnName = "IDUmkPredmet")
    @ManyToOne(optional = false)
    private TUmkTPredmet iDUmkPredmet;
    @JoinColumn(name = "VidDocum", referencedColumnName = "VidDocum")
    @ManyToOne(optional = false)
    private TVidDocument vidDocum;

    public TUmkPredmetDocument() {
    }

    public TUmkPredmetDocument(Integer idUmkPredmetDocument) {
        this.idUmkPredmetDocument = idUmkPredmetDocument;
    }

    public TUmkPredmetDocument(Integer idUmkPredmetDocument, Date dataDocum) {
        this.idUmkPredmetDocument = idUmkPredmetDocument;
        this.dataDocum = dataDocum;
    }

    public String getDataDocum() {
        Format formatter = new SimpleDateFormat("dd.MM.YY");
        return formatter.format(dataDocum);
    }

    public void setDataDocum(Date dataDocum) {
        this.dataDocum = dataDocum;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TPrepod getPrepod() {
        return prepod;
    }

    public void setPrepod(TPrepod prepod) {
        this.prepod = prepod;
    }

    public Integer getIdUmkPredmetDocument() {
        return idUmkPredmetDocument;
    }

    public void setIdUmkPredmetDocument(Integer idUmkPredmetDocument) {
        this.idUmkPredmetDocument = idUmkPredmetDocument;
    }

    public String getCelPredmet() {
        return celPredmet;
    }

    public void setCelPredmet(String celPredmet) {
        this.celPredmet = celPredmet;
    }

    public Integer getIdUmkPredmetDocumentOLD() {
        return idUmkPredmetDocumentOLD;
    }

    public void setIdUmkPredmetDocumentOLD(Integer idUmkPredmetDocumentOLD) {
        this.idUmkPredmetDocumentOLD = idUmkPredmetDocumentOLD;
    }

    public int getIdFileDoc() {
        return idFileDoc;
    }

    public void setIdFileDoc(int idFileDoc) {
        this.idFileDoc = idFileDoc;
    }

    public TUmkTPredmet getIDUmkPredmet() {
        return iDUmkPredmet;
    }

    public void setIDUmkPredmet(TUmkTPredmet iDUmkPredmet) {
        this.iDUmkPredmet = iDUmkPredmet;
    }

    public TVidDocument getVidDocum() {
        return vidDocum;
    }

    public void setVidDocum(TVidDocument vidDocum) {
        this.vidDocum = vidDocum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUmkPredmetDocument != null ? idUmkPredmetDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUmkPredmetDocument)) {
            return false;
        }
        TUmkPredmetDocument other = (TUmkPredmetDocument) object;
        if ((this.idUmkPredmetDocument == null && other.idUmkPredmetDocument != null) || (this.idUmkPredmetDocument != null && !this.idUmkPredmetDocument.equals(other.idUmkPredmetDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUmkPredmetDocument[ idUmkPredmetDocument=" + idUmkPredmetDocument + " ]";
    }

    /*public Integer getPrepod() {
        return prepod;
    }

    public void setPrepod(Integer prepod) {
        this.prepod = prepod;
    }*/

    @XmlTransient
    public Collection<TRPDZadachi> getTRPDZadachiCollection() {
        return tRPDZadachiCollection;
    }

    public void setTRPDZadachiCollection(Collection<TRPDZadachi> tRPDZadachiCollection) {
        this.tRPDZadachiCollection = tRPDZadachiCollection;
    }
    
}
