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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_PACKAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrPackage.findAll", query = "SELECT b FROM BtrPackage b"),
    @NamedQuery(name = "BtrPackage.findByPackId", query = "SELECT b FROM BtrPackage b WHERE b.packId = :packId"),
    @NamedQuery(name = "BtrPackage.findByDnSumDebt", query = "SELECT b FROM BtrPackage b WHERE b.dnSumDebt = :dnSumDebt"),
    @NamedQuery(name = "BtrPackage.findByDnSumDebtTelco", query = "SELECT b FROM BtrPackage b WHERE b.dnSumDebtTelco = :dnSumDebtTelco"),
    @NamedQuery(name = "BtrPackage.findByDnSumDebtHw", query = "SELECT b FROM BtrPackage b WHERE b.dnSumDebtHw = :dnSumDebtHw"),
    @NamedQuery(name = "BtrPackage.findByDnCountColl", query = "SELECT b FROM BtrPackage b WHERE b.dnCountColl = :dnCountColl"),
    @NamedQuery(name = "BtrPackage.findByDateFrom", query = "SELECT b FROM BtrPackage b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrPackage.findByDateTo", query = "SELECT b FROM BtrPackage b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrPackage.findByCrDate", query = "SELECT b FROM BtrPackage b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrPackage.findByModDate", query = "SELECT b FROM BtrPackage b WHERE b.modDate = :modDate")})
public class BtrPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PACK_ID")
    private BigDecimal packId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DN_SUM_DEBT")
    private BigInteger dnSumDebt;
    @Column(name = "DN_SUM_DEBT_TELCO")
    private BigInteger dnSumDebtTelco;
    @Column(name = "DN_SUM_DEBT_HW")
    private BigInteger dnSumDebtHw;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DN_COUNT_COLL")
    private BigInteger dnCountColl;
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
    @JoinColumn(name = "PATY_ID", referencedColumnName = "PATY_ID")
    @ManyToOne(optional = false)
    private BtrDPackageType patyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packId")
    private List<BtrCollectionPackageRel> btrCollectionPackageRelList;

    public BtrPackage() {
    }

    public BtrPackage(BigDecimal packId) {
        this.packId = packId;
    }

    public BtrPackage(BigDecimal packId, BigInteger dnSumDebt, BigInteger dnCountColl, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.packId = packId;
        this.dnSumDebt = dnSumDebt;
        this.dnCountColl = dnCountColl;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getPackId() {
        return packId;
    }

    public void setPackId(BigDecimal packId) {
        this.packId = packId;
    }

    public BigInteger getDnSumDebt() {
        return dnSumDebt;
    }

    public void setDnSumDebt(BigInteger dnSumDebt) {
        this.dnSumDebt = dnSumDebt;
    }

    public BigInteger getDnSumDebtTelco() {
        return dnSumDebtTelco;
    }

    public void setDnSumDebtTelco(BigInteger dnSumDebtTelco) {
        this.dnSumDebtTelco = dnSumDebtTelco;
    }

    public BigInteger getDnSumDebtHw() {
        return dnSumDebtHw;
    }

    public void setDnSumDebtHw(BigInteger dnSumDebtHw) {
        this.dnSumDebtHw = dnSumDebtHw;
    }

    public BigInteger getDnCountColl() {
        return dnCountColl;
    }

    public void setDnCountColl(BigInteger dnCountColl) {
        this.dnCountColl = dnCountColl;
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

    public BtrDPackageType getPatyId() {
        return patyId;
    }

    public void setPatyId(BtrDPackageType patyId) {
        this.patyId = patyId;
    }

    public BtrUser getModUserId() {
        return modUserId;
    }

    public void setModUserId(BtrUser modUserId) {
        this.modUserId = modUserId;
    }

    public BtrUser getCrUserId() {
        return crUserId;
    }

    public void setCrUserId(BtrUser crUserId) {
        this.crUserId = crUserId;
    }

    @XmlTransient
    public List<BtrCollectionPackageRel> getBtrCollectionPackageRelList() {
        return btrCollectionPackageRelList;
    }

    public void setBtrCollectionPackageRelList(List<BtrCollectionPackageRel> btrCollectionPackageRelList) {
        this.btrCollectionPackageRelList = btrCollectionPackageRelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packId != null ? packId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrPackage)) {
            return false;
        }
        BtrPackage other = (BtrPackage) object;
        if ((this.packId == null && other.packId != null) || (this.packId != null && !this.packId.equals(other.packId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrPackage[ packId=" + packId + " ]";
    }
    
}
