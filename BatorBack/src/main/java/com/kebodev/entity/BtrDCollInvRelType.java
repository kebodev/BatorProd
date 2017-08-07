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
@Table(name = "BTR_D_COLL_INV_REL_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDCollInvRelType.findAll", query = "SELECT b FROM BtrDCollInvRelType b"),
    @NamedQuery(name = "BtrDCollInvRelType.findByCirtId", query = "SELECT b FROM BtrDCollInvRelType b WHERE b.cirtId = :cirtId"),
    @NamedQuery(name = "BtrDCollInvRelType.findByCirtName", query = "SELECT b FROM BtrDCollInvRelType b WHERE b.cirtName = :cirtName"),
    @NamedQuery(name = "BtrDCollInvRelType.findByDateFrom", query = "SELECT b FROM BtrDCollInvRelType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDCollInvRelType.findByDateTo", query = "SELECT b FROM BtrDCollInvRelType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDCollInvRelType.findByCrDate", query = "SELECT b FROM BtrDCollInvRelType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDCollInvRelType.findByModDate", query = "SELECT b FROM BtrDCollInvRelType b WHERE b.modDate = :modDate")})
public class BtrDCollInvRelType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CIRT_ID")
    private BigDecimal cirtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CIRT_NAME")
    private String cirtName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cirtId")
    private List<BtrCollInvRel> btrCollInvRelList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDCollInvRelType() {
    }

    public BtrDCollInvRelType(BigDecimal cirtId) {
        this.cirtId = cirtId;
    }

    public BtrDCollInvRelType(BigDecimal cirtId, String cirtName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cirtId = cirtId;
        this.cirtName = cirtName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCirtId() {
        return cirtId;
    }

    public void setCirtId(BigDecimal cirtId) {
        this.cirtId = cirtId;
    }

    public String getCirtName() {
        return cirtName;
    }

    public void setCirtName(String cirtName) {
        this.cirtName = cirtName;
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
    public List<BtrCollInvRel> getBtrCollInvRelList() {
        return btrCollInvRelList;
    }

    public void setBtrCollInvRelList(List<BtrCollInvRel> btrCollInvRelList) {
        this.btrCollInvRelList = btrCollInvRelList;
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
        hash += (cirtId != null ? cirtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDCollInvRelType)) {
            return false;
        }
        BtrDCollInvRelType other = (BtrDCollInvRelType) object;
        if ((this.cirtId == null && other.cirtId != null) || (this.cirtId != null && !this.cirtId.equals(other.cirtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDCollInvRelType[ cirtId=" + cirtId + " ]";
    }
    
}
