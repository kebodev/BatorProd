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
@Table(name = "BTR_D_COLLECTION_STEP_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDCollectionStepType.findAll", query = "SELECT b FROM BtrDCollectionStepType b"),
    @NamedQuery(name = "BtrDCollectionStepType.findByCstyId", query = "SELECT b FROM BtrDCollectionStepType b WHERE b.cstyId = :cstyId"),
    @NamedQuery(name = "BtrDCollectionStepType.findByCstyName", query = "SELECT b FROM BtrDCollectionStepType b WHERE b.cstyName = :cstyName"),
    @NamedQuery(name = "BtrDCollectionStepType.findByDateFrom", query = "SELECT b FROM BtrDCollectionStepType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDCollectionStepType.findByDateTo", query = "SELECT b FROM BtrDCollectionStepType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDCollectionStepType.findByCrDate", query = "SELECT b FROM BtrDCollectionStepType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDCollectionStepType.findByModDate", query = "SELECT b FROM BtrDCollectionStepType b WHERE b.modDate = :modDate")})
public class BtrDCollectionStepType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CSTY_ID")
    private BigDecimal cstyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CSTY_NAME")
    private String cstyName;
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
    @JoinColumn(name = "BOOL_ID_IS_KALLER", referencedColumnName = "BOOL_ID")
    @ManyToOne(optional = false)
    private BtrDBoolean boolIdIsKaller;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cstyId")
    private List<BtrCollectionStep> btrCollectionStepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cstyId")
    private List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList;

    public BtrDCollectionStepType() {
    }

    public BtrDCollectionStepType(BigDecimal cstyId) {
        this.cstyId = cstyId;
    }

    public BtrDCollectionStepType(BigDecimal cstyId, String cstyName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cstyId = cstyId;
        this.cstyName = cstyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCstyId() {
        return cstyId;
    }

    public void setCstyId(BigDecimal cstyId) {
        this.cstyId = cstyId;
    }

    public String getCstyName() {
        return cstyName;
    }

    public void setCstyName(String cstyName) {
        this.cstyName = cstyName;
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

    public BtrDBoolean getBoolIdIsKaller() {
        return boolIdIsKaller;
    }

    public void setBoolIdIsKaller(BtrDBoolean boolIdIsKaller) {
        this.boolIdIsKaller = boolIdIsKaller;
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
    public List<BtrCollectionStep> getBtrCollectionStepList() {
        return btrCollectionStepList;
    }

    public void setBtrCollectionStepList(List<BtrCollectionStep> btrCollectionStepList) {
        this.btrCollectionStepList = btrCollectionStepList;
    }

    @XmlTransient
    public List<BtrDStepTyEventTyRel> getBtrDStepTyEventTyRelList() {
        return btrDStepTyEventTyRelList;
    }

    public void setBtrDStepTyEventTyRelList(List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList) {
        this.btrDStepTyEventTyRelList = btrDStepTyEventTyRelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cstyId != null ? cstyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDCollectionStepType)) {
            return false;
        }
        BtrDCollectionStepType other = (BtrDCollectionStepType) object;
        if ((this.cstyId == null && other.cstyId != null) || (this.cstyId != null && !this.cstyId.equals(other.cstyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDCollectionStepType[ cstyId=" + cstyId + " ]";
    }
    
}
