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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tPrepod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPrepod.findAll", query = "SELECT t FROM TPrepod t")
    , @NamedQuery(name = "TPrepod.findByIDteacher", query = "SELECT t FROM TPrepod t WHERE t.iDteacher = :iDteacher")
    , @NamedQuery(name = "TPrepod.findBySurName", query = "SELECT t FROM TPrepod t WHERE t.surName = :surName")
    , @NamedQuery(name = "TPrepod.findByName", query = "SELECT t FROM TPrepod t WHERE t.name = :name")
    , @NamedQuery(name = "TPrepod.findByPatronymic", query = "SELECT t FROM TPrepod t WHERE t.patronymic = :patronymic")
    , @NamedQuery(name = "TPrepod.findByObrazovanie", query = "SELECT t FROM TPrepod t WHERE t.obrazovanie = :obrazovanie")
    , @NamedQuery(name = "TPrepod.findByMestoprog", query = "SELECT t FROM TPrepod t WHERE t.mestoprog = :mestoprog")
    , @NamedQuery(name = "TPrepod.findByVidrabot", query = "SELECT t FROM TPrepod t WHERE t.vidrabot = :vidrabot")
    , @NamedQuery(name = "TPrepod.findByStagRaboti", query = "SELECT t FROM TPrepod t WHERE t.stagRaboti = :stagRaboti")
    , @NamedQuery(name = "TPrepod.findByStagPedRaboti", query = "SELECT t FROM TPrepod t WHERE t.stagPedRaboti = :stagPedRaboti")
    , @NamedQuery(name = "TPrepod.findByTemaDisser", query = "SELECT t FROM TPrepod t WHERE t.temaDisser = :temaDisser")})
public class TPrepod implements Serializable {

    @OneToMany(mappedBy = "prepod")
    private Collection<TUmkTPredmet> tUmkTPredmetCollection;
    
    @OneToMany(mappedBy = "prepod")
    private Collection<TUmkPredmetDocument> tUmkPredmetDocumentCollection;
      
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_teacher")
    private Integer iDteacher;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SurName")
    private String surName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Patronymic")
    private String patronymic;
    @Size(max = 500)
    @Column(name = "Obrazovanie")
    private String obrazovanie;
    @Size(max = 10)
    @Column(name = "Mesto_prog")
    private String mestoprog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vid_rabot")
    private short vidrabot;
    @Column(name = "StagRaboti")
    private Integer stagRaboti;
    @Column(name = "StagPedRaboti")
    private Integer stagPedRaboti;
    @Size(max = 2000)
    @Column(name = "TemaDisser")
    private String temaDisser;
    @JoinColumn(name = "DolgnostSkr", referencedColumnName = "DolgnostSkr")
    @ManyToOne
    private TDolgnost dolgnostSkr;
    @JoinColumn(name = "Name_kaf_sokr", referencedColumnName = "Name_kaf_sokr")
    @ManyToOne(optional = false)
    private TKaf namekafsokr;
    @JoinColumn(name = "ID_sc_degree", referencedColumnName = "ID_sc_degree")
    @ManyToOne
    private TUchStepen iDscdegree;
    @JoinColumn(name = "ID_sc_rank", referencedColumnName = "ID_sc_rank")
    @ManyToOne
    private TUchZvan iDscrank;

    public TPrepod() {
    }

    public TPrepod(Integer iDteacher) {
        this.iDteacher = iDteacher;
    }

    public TPrepod(Integer iDteacher, String surName, String name, String patronymic, short vidrabot) {
        this.iDteacher = iDteacher;
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.vidrabot = vidrabot;
    }

    public Integer getIDteacher() {
        return iDteacher;
    }

    public void setIDteacher(Integer iDteacher) {
        this.iDteacher = iDteacher;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getObrazovanie() {
        return obrazovanie;
    }

    public void setObrazovanie(String obrazovanie) {
        this.obrazovanie = obrazovanie;
    }

    public String getMestoprog() {
        return mestoprog;
    }

    public void setMestoprog(String mestoprog) {
        this.mestoprog = mestoprog;
    }

    public short getVidrabot() {
        return vidrabot;
    }

    public void setVidrabot(short vidrabot) {
        this.vidrabot = vidrabot;
    }

    public Integer getStagRaboti() {
        return stagRaboti;
    }

    public void setStagRaboti(Integer stagRaboti) {
        this.stagRaboti = stagRaboti;
    }

    public Integer getStagPedRaboti() {
        return stagPedRaboti;
    }

    public void setStagPedRaboti(Integer stagPedRaboti) {
        this.stagPedRaboti = stagPedRaboti;
    }

    public String getTemaDisser() {
        return temaDisser;
    }

    public void setTemaDisser(String temaDisser) {
        this.temaDisser = temaDisser;
    }

    public TDolgnost getDolgnostSkr() {
        return dolgnostSkr;
    }

    public void setDolgnostSkr(TDolgnost dolgnostSkr) {
        this.dolgnostSkr = dolgnostSkr;
    }

    public TKaf getNamekafsokr() {
        return namekafsokr;
    }

    public void setNamekafsokr(TKaf namekafsokr) {
        this.namekafsokr = namekafsokr;
    }

    public TUchStepen getIDscdegree() {
        return iDscdegree;
    }

    public void setIDscdegree(TUchStepen iDscdegree) {
        this.iDscdegree = iDscdegree;
    }

    public TUchZvan getIDscrank() {
        return iDscrank;
    }

    public void setIDscrank(TUchZvan iDscrank) {
        this.iDscrank = iDscrank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDteacher != null ? iDteacher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPrepod)) {
            return false;
        }
        TPrepod other = (TPrepod) object;
        if ((this.iDteacher == null && other.iDteacher != null) || (this.iDteacher != null && !this.iDteacher.equals(other.iDteacher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TPrepod[ iDteacher=" + iDteacher + " ]";
    }

    @XmlTransient
    public Collection<TUmkTPredmet> getTUmkTPredmetCollection() {
        return tUmkTPredmetCollection;
    }

    public void setTUmkTPredmetCollection(Collection<TUmkTPredmet> tUmkTPredmetCollection) {
        this.tUmkTPredmetCollection = tUmkTPredmetCollection;
    }
    
    @XmlTransient
    public Collection<TUmkPredmetDocument> getTUmkPredmetDocumentCollection() {
        return tUmkPredmetDocumentCollection;
    }

    public void setTUmkPredmetDocumentCollection(Collection<TUmkPredmetDocument> tUmkPredmetDocumentCollection) {
        this.tUmkPredmetDocumentCollection = tUmkPredmetDocumentCollection;
    }
}
