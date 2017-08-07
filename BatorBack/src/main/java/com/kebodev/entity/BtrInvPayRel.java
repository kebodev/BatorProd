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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_INV_PAY_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrInvPayRel.findAll", query = "SELECT b FROM BtrInvPayRel b"),
    @NamedQuery(name = "BtrInvPayRel.findByInpaId", query = "SELECT b FROM BtrInvPayRel b WHERE b.inpaId = :inpaId"),
    @NamedQuery(name = "BtrInvPayRel.findByAmount", query = "SELECT b FROM BtrInvPayRel b WHERE b.amount = :amount"),
    @NamedQuery(name = "BtrInvPayRel.findByDateFrom", query = "SELECT b FROM BtrInvPayRel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrInvPayRel.findByDateTo", query = "SELECT b FROM BtrInvPayRel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrInvPayRel.findByCrDate", query = "SELECT b FROM BtrInvPayRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrInvPayRel.findByModDate", query = "SELECT b FROM BtrInvPayRel b WHERE b.modDate = :modDate")})
public class BtrInvPayRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INPA_ID")
    private BigDecimal inpaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private BigInteger amount;
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
    @JoinColumn(name = "INHE_ID", referencedColumnName = "INHE_ID")
    @ManyToOne(optional = false)
    private BtrInvoiceHeader inheId;
    @JoinColumn(name = "PAYM_ID", referencedColumnName = "PAYM_ID")
    @ManyToOne(optional = false)
    private BtrPayment paymId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrInvPayRel() {
    }

    public BtrInvPayRel(BigDecimal inpaId) {
        this.inpaId = inpaId;
    }

    public BtrInvPayRel(BigDecimal inpaId, BigInteger amount, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.inpaId = inpaId;
        this.amount = amount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getInpaId() {
        return inpaId;
    }

    public void setInpaId(BigDecimal inpaId) {
        this.inpaId = inpaId;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
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

    public BtrInvoiceHeader getInheId() {
        return inheId;
    }

    public void setInheId(BtrInvoiceHeader inheId) {
        this.inheId = inheId;
    }

    public BtrPayment getPaymId() {
        return paymId;
    }

    public void setPaymId(BtrPayment paymId) {
        this.paymId = paymId;
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
        hash += (inpaId != null ? inpaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrInvPayRel)) {
            return false;
        }
        BtrInvPayRel other = (BtrInvPayRel) object;
        if ((this.inpaId == null && other.inpaId != null) || (this.inpaId != null && !this.inpaId.equals(other.inpaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrInvPayRel[ inpaId=" + inpaId + " ]";
    }
    
}
