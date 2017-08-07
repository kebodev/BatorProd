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
@Table(name = "BTR_D_BOOLEAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDBoolean.findAll", query = "SELECT b FROM BtrDBoolean b"),
    @NamedQuery(name = "BtrDBoolean.findByBoolId", query = "SELECT b FROM BtrDBoolean b WHERE b.boolId = :boolId"),
    @NamedQuery(name = "BtrDBoolean.findByBoolName", query = "SELECT b FROM BtrDBoolean b WHERE b.boolName = :boolName"),
    @NamedQuery(name = "BtrDBoolean.findByDateFrom", query = "SELECT b FROM BtrDBoolean b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDBoolean.findByDateTo", query = "SELECT b FROM BtrDBoolean b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDBoolean.findByCrDate", query = "SELECT b FROM BtrDBoolean b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDBoolean.findByModDate", query = "SELECT b FROM BtrDBoolean b WHERE b.modDate = :modDate")})
public class BtrDBoolean implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOL_ID")
    private BigDecimal boolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BOOL_NAME")
    private String boolName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boolIdIsKaller")
    private List<BtrDCollectionStepType> btrDCollectionStepTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boolIdIsActive")
    private List<BtrAccount> btrAccountList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDBoolean() {
    }

    public BtrDBoolean(BigDecimal boolId) {
        this.boolId = boolId;
    }

    public BtrDBoolean(BigDecimal boolId, String boolName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.boolId = boolId;
        this.boolName = boolName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getBoolId() {
        return boolId;
    }

    public void setBoolId(BigDecimal boolId) {
        this.boolId = boolId;
    }

    public String getBoolName() {
        return boolName;
    }

    public void setBoolName(String boolName) {
        this.boolName = boolName;
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
    public List<BtrDCollectionStepType> getBtrDCollectionStepTypeList() {
        return btrDCollectionStepTypeList;
    }

    public void setBtrDCollectionStepTypeList(List<BtrDCollectionStepType> btrDCollectionStepTypeList) {
        this.btrDCollectionStepTypeList = btrDCollectionStepTypeList;
    }

    @XmlTransient
    public List<BtrAccount> getBtrAccountList() {
        return btrAccountList;
    }

    public void setBtrAccountList(List<BtrAccount> btrAccountList) {
        this.btrAccountList = btrAccountList;
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
        hash += (boolId != null ? boolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDBoolean)) {
            return false;
        }
        BtrDBoolean other = (BtrDBoolean) object;
        if ((this.boolId == null && other.boolId != null) || (this.boolId != null && !this.boolId.equals(other.boolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDBoolean[ boolId=" + boolId + " ]";
    }
    
}
