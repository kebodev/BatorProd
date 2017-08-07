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
@Table(name = "BTR_COLLECTION_STEP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCollectionStep.findAll", query = "SELECT b FROM BtrCollectionStep b"),
    @NamedQuery(name = "BtrCollectionStep.findByCostId", query = "SELECT b FROM BtrCollectionStep b WHERE b.costId = :costId"),
    @NamedQuery(name = "BtrCollectionStep.findByStepStartDebt", query = "SELECT b FROM BtrCollectionStep b WHERE b.stepStartDebt = :stepStartDebt"),
    @NamedQuery(name = "BtrCollectionStep.findByDateFrom", query = "SELECT b FROM BtrCollectionStep b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrCollectionStep.findByDateTo", query = "SELECT b FROM BtrCollectionStep b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrCollectionStep.findByCrDate", query = "SELECT b FROM BtrCollectionStep b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCollectionStep.findByModDate", query = "SELECT b FROM BtrCollectionStep b WHERE b.modDate = :modDate")})
public class BtrCollectionStep implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COST_ID")
    private BigDecimal costId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEP_START_DEBT")
    private BigInteger stepStartDebt;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costId")
    private List<BtrCollectionEvent> btrCollectionEventList;
    @JoinColumn(name = "COLL_ID", referencedColumnName = "COLL_ID")
    @ManyToOne(optional = false)
    private BtrCollection collId;
    @JoinColumn(name = "CSTY_ID", referencedColumnName = "CSTY_ID")
    @ManyToOne(optional = false)
    private BtrDCollectionStepType cstyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costId")
    private List<BtrCollectionPackageRel> btrCollectionPackageRelList;

    public BtrCollectionStep() {
    }

    public BtrCollectionStep(BigDecimal costId) {
        this.costId = costId;
    }

    public BtrCollectionStep(BigDecimal costId, BigInteger stepStartDebt, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.costId = costId;
        this.stepStartDebt = stepStartDebt;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCostId() {
        return costId;
    }

    public void setCostId(BigDecimal costId) {
        this.costId = costId;
    }

    public BigInteger getStepStartDebt() {
        return stepStartDebt;
    }

    public void setStepStartDebt(BigInteger stepStartDebt) {
        this.stepStartDebt = stepStartDebt;
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
    public List<BtrCollectionEvent> getBtrCollectionEventList() {
        return btrCollectionEventList;
    }

    public void setBtrCollectionEventList(List<BtrCollectionEvent> btrCollectionEventList) {
        this.btrCollectionEventList = btrCollectionEventList;
    }

    public BtrCollection getCollId() {
        return collId;
    }

    public void setCollId(BtrCollection collId) {
        this.collId = collId;
    }

    public BtrDCollectionStepType getCstyId() {
        return cstyId;
    }

    public void setCstyId(BtrDCollectionStepType cstyId) {
        this.cstyId = cstyId;
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
        hash += (costId != null ? costId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCollectionStep)) {
            return false;
        }
        BtrCollectionStep other = (BtrCollectionStep) object;
        if ((this.costId == null && other.costId != null) || (this.costId != null && !this.costId.equals(other.costId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCollectionStep[ costId=" + costId + " ]";
    }
    
}
