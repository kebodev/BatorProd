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
@Table(name = "BTR_D_CUS_REL_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDCusRelType.findAll", query = "SELECT b FROM BtrDCusRelType b"),
    @NamedQuery(name = "BtrDCusRelType.findByCrtyId", query = "SELECT b FROM BtrDCusRelType b WHERE b.crtyId = :crtyId"),
    @NamedQuery(name = "BtrDCusRelType.findByCrtyName", query = "SELECT b FROM BtrDCusRelType b WHERE b.crtyName = :crtyName"),
    @NamedQuery(name = "BtrDCusRelType.findByDateFrom", query = "SELECT b FROM BtrDCusRelType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDCusRelType.findByDateTo", query = "SELECT b FROM BtrDCusRelType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDCusRelType.findByCrDate", query = "SELECT b FROM BtrDCusRelType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDCusRelType.findByModDate", query = "SELECT b FROM BtrDCusRelType b WHERE b.modDate = :modDate")})
public class BtrDCusRelType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRTY_ID")
    private BigDecimal crtyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CRTY_NAME")
    private String crtyName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crtyId")
    private List<BtrCustomerRel> btrCustomerRelList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDCusRelType() {
    }

    public BtrDCusRelType(BigDecimal crtyId) {
        this.crtyId = crtyId;
    }

    public BtrDCusRelType(BigDecimal crtyId, String crtyName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.crtyId = crtyId;
        this.crtyName = crtyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCrtyId() {
        return crtyId;
    }

    public void setCrtyId(BigDecimal crtyId) {
        this.crtyId = crtyId;
    }

    public String getCrtyName() {
        return crtyName;
    }

    public void setCrtyName(String crtyName) {
        this.crtyName = crtyName;
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
    public List<BtrCustomerRel> getBtrCustomerRelList() {
        return btrCustomerRelList;
    }

    public void setBtrCustomerRelList(List<BtrCustomerRel> btrCustomerRelList) {
        this.btrCustomerRelList = btrCustomerRelList;
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
        hash += (crtyId != null ? crtyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDCusRelType)) {
            return false;
        }
        BtrDCusRelType other = (BtrDCusRelType) object;
        if ((this.crtyId == null && other.crtyId != null) || (this.crtyId != null && !this.crtyId.equals(other.crtyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDCusRelType[ crtyId=" + crtyId + " ]";
    }
    
}
