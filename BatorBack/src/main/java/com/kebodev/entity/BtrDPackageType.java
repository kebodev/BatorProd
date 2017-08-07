/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kebodev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "BTR_D_PACKAGE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDPackageType.findAll", query = "SELECT b FROM BtrDPackageType b"),
    @NamedQuery(name = "BtrDPackageType.findByPatyId", query = "SELECT b FROM BtrDPackageType b WHERE b.patyId = :patyId"),
    @NamedQuery(name = "BtrDPackageType.findByPatyName", query = "SELECT b FROM BtrDPackageType b WHERE b.patyName = :patyName"),
    @NamedQuery(name = "BtrDPackageType.findByPatyDurationDays", query = "SELECT b FROM BtrDPackageType b WHERE b.patyDurationDays = :patyDurationDays"),
    @NamedQuery(name = "BtrDPackageType.findByDateFrom", query = "SELECT b FROM BtrDPackageType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDPackageType.findByDateTo", query = "SELECT b FROM BtrDPackageType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDPackageType.findByCrDate", query = "SELECT b FROM BtrDPackageType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDPackageType.findByModDate", query = "SELECT b FROM BtrDPackageType b WHERE b.modDate = :modDate")})
public class BtrDPackageType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PATY_ID")
    private BigDecimal patyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PATY_NAME")
    private String patyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PATY_DURATION_DAYS")
    private BigInteger patyDurationDays;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patyId")
    private List<BtrPackage> btrPackageList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDPackageType() {
    }

    public BtrDPackageType(BigDecimal patyId) {
        this.patyId = patyId;
    }

    public BtrDPackageType(BigDecimal patyId, String patyName, BigInteger patyDurationDays, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.patyId = patyId;
        this.patyName = patyName;
        this.patyDurationDays = patyDurationDays;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getPatyId() {
        return patyId;
    }

    public void setPatyId(BigDecimal patyId) {
        this.patyId = patyId;
    }

    public String getPatyName() {
        return patyName;
    }

    public void setPatyName(String patyName) {
        this.patyName = patyName;
    }

    public BigInteger getPatyDurationDays() {
        return patyDurationDays;
    }

    public void setPatyDurationDays(BigInteger patyDurationDays) {
        this.patyDurationDays = patyDurationDays;
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

    @XmlTransient
    public List<BtrPackage> getBtrPackageList() {
        return btrPackageList;
    }

    public void setBtrPackageList(List<BtrPackage> btrPackageList) {
        this.btrPackageList = btrPackageList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patyId != null ? patyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDPackageType)) {
            return false;
        }
        BtrDPackageType other = (BtrDPackageType) object;
        if ((this.patyId == null && other.patyId != null) || (this.patyId != null && !this.patyId.equals(other.patyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDPackageType[ patyId=" + patyId + " ]";
    }
    
}
