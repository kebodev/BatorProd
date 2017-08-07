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
@Table(name = "BTR_COLL_INV_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCollInvRel.findAll", query = "SELECT b FROM BtrCollInvRel b"),
    @NamedQuery(name = "BtrCollInvRel.findByCireId", query = "SELECT b FROM BtrCollInvRel b WHERE b.cireId = :cireId"),
    @NamedQuery(name = "BtrCollInvRel.findByDateFrom", query = "SELECT b FROM BtrCollInvRel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrCollInvRel.findByDateTo", query = "SELECT b FROM BtrCollInvRel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrCollInvRel.findByCrDate", query = "SELECT b FROM BtrCollInvRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCollInvRel.findByModDate", query = "SELECT b FROM BtrCollInvRel b WHERE b.modDate = :modDate")})
public class BtrCollInvRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CIRE_ID")
    private BigDecimal cireId;
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
    @JoinColumn(name = "COLL_ID", referencedColumnName = "COLL_ID")
    @ManyToOne(optional = false)
    private BtrCollection collId;
    @JoinColumn(name = "CIRT_ID", referencedColumnName = "CIRT_ID")
    @ManyToOne(optional = false)
    private BtrDCollInvRelType cirtId;
    @JoinColumn(name = "INHE_ID", referencedColumnName = "INHE_ID")
    @ManyToOne(optional = false)
    private BtrInvoiceHeader inheId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrCollInvRel() {
    }

    public BtrCollInvRel(BigDecimal cireId) {
        this.cireId = cireId;
    }

    public BtrCollInvRel(BigDecimal cireId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cireId = cireId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCireId() {
        return cireId;
    }

    public void setCireId(BigDecimal cireId) {
        this.cireId = cireId;
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

    public BtrCollection getCollId() {
        return collId;
    }

    public void setCollId(BtrCollection collId) {
        this.collId = collId;
    }

    public BtrDCollInvRelType getCirtId() {
        return cirtId;
    }

    public void setCirtId(BtrDCollInvRelType cirtId) {
        this.cirtId = cirtId;
    }

    public BtrInvoiceHeader getInheId() {
        return inheId;
    }

    public void setInheId(BtrInvoiceHeader inheId) {
        this.inheId = inheId;
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
        hash += (cireId != null ? cireId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCollInvRel)) {
            return false;
        }
        BtrCollInvRel other = (BtrCollInvRel) object;
        if ((this.cireId == null && other.cireId != null) || (this.cireId != null && !this.cireId.equals(other.cireId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCollInvRel[ cireId=" + cireId + " ]";
    }
    
}
