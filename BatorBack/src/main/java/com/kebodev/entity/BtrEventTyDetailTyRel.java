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
@Table(name = "BTR_EVENT_TY_DETAIL_TY_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrEventTyDetailTyRel.findAll", query = "SELECT b FROM BtrEventTyDetailTyRel b"),
    @NamedQuery(name = "BtrEventTyDetailTyRel.findByEdreId", query = "SELECT b FROM BtrEventTyDetailTyRel b WHERE b.edreId = :edreId"),
    @NamedQuery(name = "BtrEventTyDetailTyRel.findByDateFrom", query = "SELECT b FROM BtrEventTyDetailTyRel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrEventTyDetailTyRel.findByDateTo", query = "SELECT b FROM BtrEventTyDetailTyRel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrEventTyDetailTyRel.findByCrDate", query = "SELECT b FROM BtrEventTyDetailTyRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrEventTyDetailTyRel.findByModDate", query = "SELECT b FROM BtrEventTyDetailTyRel b WHERE b.modDate = :modDate")})
public class BtrEventTyDetailTyRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDRE_ID")
    private BigDecimal edreId;
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
    @JoinColumn(name = "CETY_ID", referencedColumnName = "CETY_ID")
    @ManyToOne(optional = false)
    private BtrDCollectionEventType cetyId;
    @JoinColumn(name = "EDTY_ID", referencedColumnName = "EDTY_ID")
    @ManyToOne(optional = false)
    private BtrDEventDetailType edtyId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrEventTyDetailTyRel() {
    }

    public BtrEventTyDetailTyRel(BigDecimal edreId) {
        this.edreId = edreId;
    }

    public BtrEventTyDetailTyRel(BigDecimal edreId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.edreId = edreId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getEdreId() {
        return edreId;
    }

    public void setEdreId(BigDecimal edreId) {
        this.edreId = edreId;
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

    public BtrDCollectionEventType getCetyId() {
        return cetyId;
    }

    public void setCetyId(BtrDCollectionEventType cetyId) {
        this.cetyId = cetyId;
    }

    public BtrDEventDetailType getEdtyId() {
        return edtyId;
    }

    public void setEdtyId(BtrDEventDetailType edtyId) {
        this.edtyId = edtyId;
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
        hash += (edreId != null ? edreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrEventTyDetailTyRel)) {
            return false;
        }
        BtrEventTyDetailTyRel other = (BtrEventTyDetailTyRel) object;
        if ((this.edreId == null && other.edreId != null) || (this.edreId != null && !this.edreId.equals(other.edreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrEventTyDetailTyRel[ edreId=" + edreId + " ]";
    }
    
}
