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
@Table(name = "BTR_D_STEP_TY_EVENT_TY_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDStepTyEventTyRel.findAll", query = "SELECT b FROM BtrDStepTyEventTyRel b"),
    @NamedQuery(name = "BtrDStepTyEventTyRel.findBySterId", query = "SELECT b FROM BtrDStepTyEventTyRel b WHERE b.sterId = :sterId"),
    @NamedQuery(name = "BtrDStepTyEventTyRel.findByDateFrom", query = "SELECT b FROM BtrDStepTyEventTyRel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDStepTyEventTyRel.findByDateTo", query = "SELECT b FROM BtrDStepTyEventTyRel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDStepTyEventTyRel.findByCrDate", query = "SELECT b FROM BtrDStepTyEventTyRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDStepTyEventTyRel.findByModDate", query = "SELECT b FROM BtrDStepTyEventTyRel b WHERE b.modDate = :modDate")})
public class BtrDStepTyEventTyRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STER_ID")
    private BigDecimal sterId;
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
    @JoinColumn(name = "CSTY_ID", referencedColumnName = "CSTY_ID")
    @ManyToOne(optional = false)
    private BtrDCollectionStepType cstyId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDStepTyEventTyRel() {
    }

    public BtrDStepTyEventTyRel(BigDecimal sterId) {
        this.sterId = sterId;
    }

    public BtrDStepTyEventTyRel(BigDecimal sterId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.sterId = sterId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getSterId() {
        return sterId;
    }

    public void setSterId(BigDecimal sterId) {
        this.sterId = sterId;
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

    public BtrDCollectionStepType getCstyId() {
        return cstyId;
    }

    public void setCstyId(BtrDCollectionStepType cstyId) {
        this.cstyId = cstyId;
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
        hash += (sterId != null ? sterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDStepTyEventTyRel)) {
            return false;
        }
        BtrDStepTyEventTyRel other = (BtrDStepTyEventTyRel) object;
        if ((this.sterId == null && other.sterId != null) || (this.sterId != null && !this.sterId.equals(other.sterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDStepTyEventTyRel[ sterId=" + sterId + " ]";
    }
    
}
