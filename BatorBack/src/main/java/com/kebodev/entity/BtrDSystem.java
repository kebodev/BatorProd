/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kebodev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_D_SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDSystem.findAll", query = "SELECT b FROM BtrDSystem b"),
    @NamedQuery(name = "BtrDSystem.findBySystId", query = "SELECT b FROM BtrDSystem b WHERE b.systId = :systId"),
    @NamedQuery(name = "BtrDSystem.findBySystName", query = "SELECT b FROM BtrDSystem b WHERE b.systName = :systName"),
    @NamedQuery(name = "BtrDSystem.findByDateFrom", query = "SELECT b FROM BtrDSystem b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDSystem.findByDateTo", query = "SELECT b FROM BtrDSystem b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDSystem.findByCrDate", query = "SELECT b FROM BtrDSystem b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDSystem.findByModDate", query = "SELECT b FROM BtrDSystem b WHERE b.modDate = :modDate")})
public class BtrDSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYST_ID")
    private BigDecimal systId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SYST_NAME")
    private String systName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systId")
    private List<BtrAccount> btrAccountList;

    public BtrDSystem() {
    }

    public BtrDSystem(BigDecimal systId) {
        this.systId = systId;
    }

    public BtrDSystem(BigDecimal systId, String systName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.systId = systId;
        this.systName = systName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getSystId() {
        return systId;
    }

    public void setSystId(BigDecimal systId) {
        this.systId = systId;
    }

    public String getSystName() {
        return systName;
    }

    public void setSystName(String systName) {
        this.systName = systName;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public BtrUser getCrUserId() {
        return crUserId;
    }

    public void setCrUserId(BtrUser crUserId) {
        this.crUserId = crUserId;
    }

    public BtrUser getModUserId() {
        return modUserId;
    }

    public void setModUserId(BtrUser modUserId) {
        this.modUserId = modUserId;
    }

    @XmlTransient
    public List<BtrAccount> getBtrAccountList() {
        return btrAccountList;
    }

    public void setBtrAccountList(List<BtrAccount> btrAccountList) {
        this.btrAccountList = btrAccountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systId != null ? systId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDSystem)) {
            return false;
        }
        BtrDSystem other = (BtrDSystem) object;
        if ((this.systId == null && other.systId != null) || (this.systId != null && !this.systId.equals(other.systId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDSystem[ systId=" + systId + " ]";
    }
    
}
