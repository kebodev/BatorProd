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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_EVENT_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrEventDetail.findAll", query = "SELECT b FROM BtrEventDetail b"),
    @NamedQuery(name = "BtrEventDetail.findByEvdeId", query = "SELECT b FROM BtrEventDetail b WHERE b.evdeId = :evdeId"),
    @NamedQuery(name = "BtrEventDetail.findByEvdeValueStr", query = "SELECT b FROM BtrEventDetail b WHERE b.evdeValueStr = :evdeValueStr"),
    @NamedQuery(name = "BtrEventDetail.findByEvdeValueInt", query = "SELECT b FROM BtrEventDetail b WHERE b.evdeValueInt = :evdeValueInt"),
    @NamedQuery(name = "BtrEventDetail.findByEvdeValueDate", query = "SELECT b FROM BtrEventDetail b WHERE b.evdeValueDate = :evdeValueDate"),
    @NamedQuery(name = "BtrEventDetail.findByDateFrom", query = "SELECT b FROM BtrEventDetail b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrEventDetail.findByDateTo", query = "SELECT b FROM BtrEventDetail b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrEventDetail.findByCrDate", query = "SELECT b FROM BtrEventDetail b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrEventDetail.findByModDate", query = "SELECT b FROM BtrEventDetail b WHERE b.modDate = :modDate")})
public class BtrEventDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVDE_ID")
    private BigDecimal evdeId;
    @Size(max = 4000)
    @Column(name = "EVDE_VALUE_STR")
    private String evdeValueStr;
    @Column(name = "EVDE_VALUE_INT")
    private BigInteger evdeValueInt;
    @Column(name = "EVDE_VALUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evdeValueDate;
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
    @JoinColumn(name = "COEV_ID", referencedColumnName = "COEV_ID")
    @ManyToOne(optional = false)
    private BtrCollectionEvent coevId;
    @JoinColumn(name = "EDTY_ID", referencedColumnName = "EDTY_ID")
    @ManyToOne(optional = false)
    private BtrDEventDetailType edtyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrEventDetail() {
    }

    public BtrEventDetail(BigDecimal evdeId) {
        this.evdeId = evdeId;
    }

    public BtrEventDetail(BigDecimal evdeId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.evdeId = evdeId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getEvdeId() {
        return evdeId;
    }

    public void setEvdeId(BigDecimal evdeId) {
        this.evdeId = evdeId;
    }

    public String getEvdeValueStr() {
        return evdeValueStr;
    }

    public void setEvdeValueStr(String evdeValueStr) {
        this.evdeValueStr = evdeValueStr;
    }

    public BigInteger getEvdeValueInt() {
        return evdeValueInt;
    }

    public void setEvdeValueInt(BigInteger evdeValueInt) {
        this.evdeValueInt = evdeValueInt;
    }

    public Date getEvdeValueDate() {
        return evdeValueDate;
    }

    public void setEvdeValueDate(Date evdeValueDate) {
        this.evdeValueDate = evdeValueDate;
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

    public BtrCollectionEvent getCoevId() {
        return coevId;
    }

    public void setCoevId(BtrCollectionEvent coevId) {
        this.coevId = coevId;
    }

    public BtrDEventDetailType getEdtyId() {
        return edtyId;
    }

    public void setEdtyId(BtrDEventDetailType edtyId) {
        this.edtyId = edtyId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evdeId != null ? evdeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrEventDetail)) {
            return false;
        }
        BtrEventDetail other = (BtrEventDetail) object;
        if ((this.evdeId == null && other.evdeId != null) || (this.evdeId != null && !this.evdeId.equals(other.evdeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrEventDetail[ evdeId=" + evdeId + " ]";
    }
    
}
