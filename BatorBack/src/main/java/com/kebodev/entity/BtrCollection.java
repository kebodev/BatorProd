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
@Table(name = "BTR_COLLECTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCollection.findAll", query = "SELECT b FROM BtrCollection b"),
    @NamedQuery(name = "BtrCollection.findByCollId", query = "SELECT b FROM BtrCollection b WHERE b.collId = :collId"),
    @NamedQuery(name = "BtrCollection.findByAccoId", query = "SELECT b FROM BtrCollection b WHERE b.accoId = :accoId"),
    @NamedQuery(name = "BtrCollection.findByCollStartDebt", query = "SELECT b FROM BtrCollection b WHERE b.collStartDebt = :collStartDebt"),
    @NamedQuery(name = "BtrCollection.findByCollActualDebt", query = "SELECT b FROM BtrCollection b WHERE b.collActualDebt = :collActualDebt"),
    @NamedQuery(name = "BtrCollection.findByDateFrom", query = "SELECT b FROM BtrCollection b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrCollection.findByDateTo", query = "SELECT b FROM BtrCollection b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrCollection.findByCrDate", query = "SELECT b FROM BtrCollection b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCollection.findByModDate", query = "SELECT b FROM BtrCollection b WHERE b.modDate = :modDate")})
public class BtrCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COLL_ID")
    private BigDecimal collId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCO_ID")
    private BigInteger accoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COLL_START_DEBT")
    private BigInteger collStartDebt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COLL_ACTUAL_DEBT")
    private BigInteger collActualDebt;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collId")
    private List<BtrCollectionStep> btrCollectionStepList;
    @JoinColumn(name = "LOLE_ID", referencedColumnName = "LOLE_ID")
    @ManyToOne(optional = false)
    private BtrDLoadLevel loleId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collId")
    private List<BtrCollInvRel> btrCollInvRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collId")
    private List<BtrCollectionController> btrCollectionControllerList;

    public BtrCollection() {
    }

    public BtrCollection(BigDecimal collId) {
        this.collId = collId;
    }

    public BtrCollection(BigDecimal collId, BigInteger accoId, BigInteger collStartDebt, BigInteger collActualDebt, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.collId = collId;
        this.accoId = accoId;
        this.collStartDebt = collStartDebt;
        this.collActualDebt = collActualDebt;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCollId() {
        return collId;
    }

    public void setCollId(BigDecimal collId) {
        this.collId = collId;
    }

    public BigInteger getAccoId() {
        return accoId;
    }

    public void setAccoId(BigInteger accoId) {
        this.accoId = accoId;
    }

    public BigInteger getCollStartDebt() {
        return collStartDebt;
    }

    public void setCollStartDebt(BigInteger collStartDebt) {
        this.collStartDebt = collStartDebt;
    }

    public BigInteger getCollActualDebt() {
        return collActualDebt;
    }

    public void setCollActualDebt(BigInteger collActualDebt) {
        this.collActualDebt = collActualDebt;
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
    public List<BtrCollectionStep> getBtrCollectionStepList() {
        return btrCollectionStepList;
    }

    public void setBtrCollectionStepList(List<BtrCollectionStep> btrCollectionStepList) {
        this.btrCollectionStepList = btrCollectionStepList;
    }

    public BtrDLoadLevel getLoleId() {
        return loleId;
    }

    public void setLoleId(BtrDLoadLevel loleId) {
        this.loleId = loleId;
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
    public List<BtrCollInvRel> getBtrCollInvRelList() {
        return btrCollInvRelList;
    }

    public void setBtrCollInvRelList(List<BtrCollInvRel> btrCollInvRelList) {
        this.btrCollInvRelList = btrCollInvRelList;
    }

    @XmlTransient
    public List<BtrCollectionController> getBtrCollectionControllerList() {
        return btrCollectionControllerList;
    }

    public void setBtrCollectionControllerList(List<BtrCollectionController> btrCollectionControllerList) {
        this.btrCollectionControllerList = btrCollectionControllerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collId != null ? collId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCollection)) {
            return false;
        }
        BtrCollection other = (BtrCollection) object;
        if ((this.collId == null && other.collId != null) || (this.collId != null && !this.collId.equals(other.collId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCollection[ collId=" + collId + " ]";
    }
    
}
