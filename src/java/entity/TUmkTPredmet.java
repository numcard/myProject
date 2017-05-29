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
@Table(name = "tUmkTPredmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUmkTPredmet.findAll", query = "SELECT t FROM TUmkTPredmet t")
    , @NamedQuery(name = "TUmkTPredmet.findByNumPorjadok", query = "SELECT t FROM TUmkTPredmet t WHERE t.numPorjadok = :numPorjadok")
    , @NamedQuery(name = "TUmkTPredmet.findByIDUmkPredmet", query = "SELECT t FROM TUmkTPredmet t WHERE t.iDUmkPredmet = :iDUmkPredmet")
    , @NamedQuery(name = "TUmkTPredmet.findByIDUmkPredmetOLD", query = "SELECT t FROM TUmkTPredmet t WHERE t.iDUmkPredmetOLD = :iDUmkPredmetOLD")})
public class TUmkTPredmet implements Serializable {    
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NumPorjadok")
    private String numPorjadok;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUmkPredmet")
    private Integer iDUmkPredmet;
    @Column(name = "IDUmkPredmetOLD")
    private Integer iDUmkPredmetOLD;
    @JoinColumn(name = "IDPredmet", referencedColumnName = "IDPredmet")
    @ManyToOne(optional = false)
    private TPredmet iDPredmet;
    @JoinColumn(name = "prepod", referencedColumnName = "ID_teacher")
    @ManyToOne
    private TPrepod prepod;
    @JoinColumn(name = "NumUchCikl", referencedColumnName = "NumUchCikl")
    @ManyToOne(optional = false)
    private TUchCikl numUchCikl;
    @JoinColumn(name = "NumNapravl", referencedColumnName = "ShifrNapravl")
    @ManyToOne(optional = false)
    private TUmk numNapravl;

    public TUmkTPredmet() {
    }

    public TUmkTPredmet(Integer iDUmkPredmet) {
        this.iDUmkPredmet = iDUmkPredmet;
    }

    public TUmkTPredmet(Integer iDUmkPredmet, String numPorjadok, boolean prBRS) {
        this.iDUmkPredmet = iDUmkPredmet;
        this.numPorjadok = numPorjadok;
    }

    public String getNumPorjadok() {
        return numPorjadok;
    }

    public void setNumPorjadok(String numPorjadok) {
        this.numPorjadok = numPorjadok;
    }

    public Integer getIDUmkPredmet() {
        return iDUmkPredmet;
    }

    public void setIDUmkPredmet(Integer iDUmkPredmet) {
        this.iDUmkPredmet = iDUmkPredmet;
    }

    public Integer getIDUmkPredmetOLD() {
        return iDUmkPredmetOLD;
    }

    public void setIDUmkPredmetOLD(Integer iDUmkPredmetOLD) {
        this.iDUmkPredmetOLD = iDUmkPredmetOLD;
    }

    public TPredmet getIDPredmet() {
        return iDPredmet;
    }

    public void setIDPredmet(TPredmet iDPredmet) {
        this.iDPredmet = iDPredmet;
    }

    public TPrepod getPrepod() {
        return prepod;
    }

    public void setPrepod(TPrepod prepod) {
        this.prepod = prepod;
    }

    public TUchCikl getNumUchCikl() {
        return numUchCikl;
    }

    public void setNumUchCikl(TUchCikl numUchCikl) {
        this.numUchCikl = numUchCikl;
    }

    public TUmk getNumNapravl() {
        return numNapravl;
    }

    public void setNumNapravl(TUmk numNapravl) {
        this.numNapravl = numNapravl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUmkPredmet != null ? iDUmkPredmet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUmkTPredmet)) {
            return false;
        }
        TUmkTPredmet other = (TUmkTPredmet) object;
        if ((this.iDUmkPredmet == null && other.iDUmkPredmet != null) || (this.iDUmkPredmet != null && !this.iDUmkPredmet.equals(other.iDUmkPredmet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUmkTPredmet[ iDUmkPredmet=" + iDUmkPredmet + " ]";
    }    
}
