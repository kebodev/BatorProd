/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kebodev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_COLLECTION_PACKAGE_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCollectionPackageRel.findAll", query = "SELECT b FROM BtrCollectionPackageRel b"),
    @NamedQuery(name = "BtrCollectionPackageRel.findByCpreId", query = "SELECT b FROM BtrCollectionPackageRel b WHERE b.cpreId = :cpreId"),
    @NamedQuery(name = "BtrCollectionPackageRel.findByDateFrom", query = "SELECT b FROM BtrCollectionPackageRel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrCollectionPackageRel.findByDateTo", query = "SELECT b FROM BtrCollectionPackageRel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrCollectionPackageRel.findByCrDate", query = "SELECT b FROM BtrCollectionPackageRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCollectionPackageRel.findByModDate", query = "SELECT b FROM BtrCollectionPackageRel b WHERE b.modDate = :modDate")})
public class BtrCollectionPackageRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPRE_ID")
    private BigDecimal cpreId;
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
    @JoinColumn(name = "COST_ID", referencedColumnName = "COST_ID")
    @ManyToOne(optional = false)
    private BtrCollectionStep costId;
    @JoinColumn(name = "PACK_ID", referencedColumnName = "PACK_ID")
    @ManyToOne(optional = false)
    private BtrPackage packId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrCollectionPackageRel() {
    }

    public BtrCollectionPackageRel(BigDecimal cpreId) {
        this.cpreId = cpreId;
    }

    public BtrCollectionPackageRel(BigDecimal cpreId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cpreId = cpreId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCpreId() {
        return cpreId;
    }

    public void setCpreId(BigDecimal cpreId) {
        this.cpreId = cpreId;
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

    public BtrCollectionStep getCostId() {
        return costId;
    }

    public void setCostId(BtrCollectionStep costId) {
        this.costId = costId;
    }

    public BtrPackage getPackId() {
        return packId;
    }

    public void setPackId(BtrPackage packId) {
        this.packId = packId;
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
        hash += (cpreId != null ? cpreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCollectionPackageRel)) {
            return false;
        }
        BtrCollectionPackageRel other = (BtrCollectionPackageRel) object;
        if ((this.cpreId == null && other.cpreId != null) || (this.cpreId != null && !this.cpreId.equals(other.cpreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCollectionPackageRel[ cpreId=" + cpreId + " ]";
    }
    
}
