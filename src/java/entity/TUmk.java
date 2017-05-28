/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tUmk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUmk.findAll", query = "SELECT t FROM TUmk t")
    , @NamedQuery(name = "TUmk.findAllOrderByShifrNapravl", query = "SELECT t FROM TUmk t ORDER BY t.shifrNapravl")
    , @NamedQuery(name = "TUmk.findByShifrNapravl", query = "SELECT t FROM TUmk t WHERE t.shifrNapravl = :shifrNapravl")
    , @NamedQuery(name = "TUmk.findByNameNapravl", query = "SELECT t FROM TUmk t WHERE t.nameNapravl = :nameNapravl")
    , @NamedQuery(name = "TUmk.findByKvalifikac", query = "SELECT t FROM TUmk t WHERE t.kvalifikac = :kvalifikac")
    , @NamedQuery(name = "TUmk.findByProfil", query = "SELECT t FROM TUmk t WHERE t.profil = :profil")
    , @NamedQuery(name = "TUmk.findByFormaObuch", query = "SELECT t FROM TUmk t WHERE t.formaObuch = :formaObuch")
    , @NamedQuery(name = "TUmk.findByDataStart", query = "SELECT t FROM TUmk t WHERE t.dataStart = :dataStart")
    , @NamedQuery(name = "TUmk.findBySrokObuch", query = "SELECT t FROM TUmk t WHERE t.srokObuch = :srokObuch")
    , @NamedQuery(name = "TUmk.findByTrudoemk", query = "SELECT t FROM TUmk t WHERE t.trudoemk = :trudoemk")
    , @NamedQuery(name = "TUmk.findByOblastDejaneln", query = "SELECT t FROM TUmk t WHERE t.oblastDejaneln = :oblastDejaneln")
    , @NamedQuery(name = "TUmk.findByObjektDejateln", query = "SELECT t FROM TUmk t WHERE t.objektDejateln = :objektDejateln")
    , @NamedQuery(name = "TUmk.findByNameProgram", query = "SELECT t FROM TUmk t WHERE t.nameProgram = :nameProgram")
    , @NamedQuery(name = "TUmk.findByFgos", query = "SELECT t FROM TUmk t WHERE t.fgos = :fgos")
    , @NamedQuery(name = "TUmk.findByIdUMK", query = "SELECT t FROM TUmk t WHERE t.idUMK = :idUMK")
    , @NamedQuery(name = "TUmk.findByNumNapravl", query = "SELECT t FROM TUmk t WHERE t.numNapravl = :numNapravl")
    , @NamedQuery(name = "TUmk.findByNameNapravlSokr", query = "SELECT t FROM TUmk t WHERE t.nameNapravlSokr = :nameNapravlSokr")
    , @NamedQuery(name = "TUmk.findByProfilSokr", query = "SELECT t FROM TUmk t WHERE t.profilSokr = :profilSokr")})
public class TUmk implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numNapravl")
    private Collection<TUmkTPredmet> tUmkTPredmetCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ShifrNapravl")
    private String shifrNapravl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NameNapravl")
    private String nameNapravl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Kvalifikac")
    private String kvalifikac;
    @Size(max = 200)
    @Column(name = "Profil")
    private String profil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FormaObuch")
    private String formaObuch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataStart")
    @Temporal(TemporalType.DATE)
    private Date dataStart;
    @Size(max = 10)
    @Column(name = "SrokObuch")
    private String srokObuch;
    @Column(name = "Trudoemk")
    private Short trudoemk;
    @Size(max = 2147483647)
    @Column(name = "OblastDejaneln")
    private String oblastDejaneln;
    @Size(max = 2147483647)
    @Column(name = "ObjektDejateln")
    private String objektDejateln;
    @Size(max = 250)
    @Column(name = "NameProgram")
    private String nameProgram;
    @Size(max = 1000)
    @Column(name = "FGOS")
    private String fgos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUMK")
    private int idUMK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NumNapravl")
    private String numNapravl;
    @Size(max = 10)
    @Column(name = "NameNapravlSokr")
    private String nameNapravlSokr;
    @Size(max = 10)
    @Column(name = "ProfilSokr")
    private String profilSokr;

    public TUmk() {
    }

    public TUmk(String shifrNapravl) {
        this.shifrNapravl = shifrNapravl;
    }

    public TUmk(String shifrNapravl, String nameNapravl, String kvalifikac, String formaObuch, Date dataStart, int idUMK, String numNapravl) {
        this.shifrNapravl = shifrNapravl;
        this.nameNapravl = nameNapravl;
        this.kvalifikac = kvalifikac;
        this.formaObuch = formaObuch;
        this.dataStart = dataStart;
        this.idUMK = idUMK;
        this.numNapravl = numNapravl;
    }

    public String getShifrNapravl() {
        return shifrNapravl;
    }

    public void setShifrNapravl(String shifrNapravl) {
        this.shifrNapravl = shifrNapravl;
    }

    public String getNameNapravl() {
        return nameNapravl;
    }

    public void setNameNapravl(String nameNapravl) {
        this.nameNapravl = nameNapravl;
    }

    public String getKvalifikac() {
        return kvalifikac;
    }

    public void setKvalifikac(String kvalifikac) {
        this.kvalifikac = kvalifikac;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getFormaObuch() {
        return formaObuch;
    }

    public void setFormaObuch(String formaObuch) {
        this.formaObuch = formaObuch;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public String getSrokObuch() {
        return srokObuch;
    }

    public void setSrokObuch(String srokObuch) {
        this.srokObuch = srokObuch;
    }

    public Short getTrudoemk() {
        return trudoemk;
    }

    public void setTrudoemk(Short trudoemk) {
        this.trudoemk = trudoemk;
    }

    public String getOblastDejaneln() {
        return oblastDejaneln;
    }

    public void setOblastDejaneln(String oblastDejaneln) {
        this.oblastDejaneln = oblastDejaneln;
    }

    public String getObjektDejateln() {
        return objektDejateln;
    }

    public void setObjektDejateln(String objektDejateln) {
        this.objektDejateln = objektDejateln;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public String getFgos() {
        return fgos;
    }

    public void setFgos(String fgos) {
        this.fgos = fgos;
    }

    public int getIdUMK() {
        return idUMK;
    }

    public void setIdUMK(int idUMK) {
        this.idUMK = idUMK;
    }

    public String getNumNapravl() {
        return numNapravl;
    }

    public void setNumNapravl(String numNapravl) {
        this.numNapravl = numNapravl;
    }

    public String getNameNapravlSokr() {
        return nameNapravlSokr;
    }

    public void setNameNapravlSokr(String nameNapravlSokr) {
        this.nameNapravlSokr = nameNapravlSokr;
    }

    public String getProfilSokr() {
        return profilSokr;
    }

    public void setProfilSokr(String profilSokr) {
        this.profilSokr = profilSokr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shifrNapravl != null ? shifrNapravl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUmk)) {
            return false;
        }
        TUmk other = (TUmk) object;
        if ((this.shifrNapravl == null && other.shifrNapravl != null) || (this.shifrNapravl != null && !this.shifrNapravl.equals(other.shifrNapravl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUmk[ shifrNapravl=" + shifrNapravl + " ]";
    } 

    @XmlTransient
    public Collection<TUmkTPredmet> getTUmkTPredmetCollection() {
        return tUmkTPredmetCollection;
    }

    public void setTUmkTPredmetCollection(Collection<TUmkTPredmet> tUmkTPredmetCollection) {
        this.tUmkTPredmetCollection = tUmkTPredmetCollection;
    }
}
