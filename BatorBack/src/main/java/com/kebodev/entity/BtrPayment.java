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
@Table(name = "BTR_PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrPayment.findAll", query = "SELECT b FROM BtrPayment b"),
    @NamedQuery(name = "BtrPayment.findByPaymId", query = "SELECT b FROM BtrPayment b WHERE b.paymId = :paymId"),
    @NamedQuery(name = "BtrPayment.findByPaymentDate", query = "SELECT b FROM BtrPayment b WHERE b.paymentDate = :paymentDate"),
    @NamedQuery(name = "BtrPayment.findByCreatedDate", query = "SELECT b FROM BtrPayment b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BtrPayment.findByAmount", query = "SELECT b FROM BtrPayment b WHERE b.amount = :amount"),
    @NamedQuery(name = "BtrPayment.findByOriginalAmount", query = "SELECT b FROM BtrPayment b WHERE b.originalAmount = :originalAmount"),
    @NamedQuery(name = "BtrPayment.findByPaymentType", query = "SELECT b FROM BtrPayment b WHERE b.paymentType = :paymentType"),
    @NamedQuery(name = "BtrPayment.findByPaymentSubType", query = "SELECT b FROM BtrPayment b WHERE b.paymentSubType = :paymentSubType"),
    @NamedQuery(name = "BtrPayment.findByDwClpaymenId", query = "SELECT b FROM BtrPayment b WHERE b.dwClpaymenId = :dwClpaymenId"),
    @NamedQuery(name = "BtrPayment.findByDwBalanceImpactCode", query = "SELECT b FROM BtrPayment b WHERE b.dwBalanceImpactCode = :dwBalanceImpactCode"),
    @NamedQuery(name = "BtrPayment.findByCrUserId", query = "SELECT b FROM BtrPayment b WHERE b.crUserId = :crUserId"),
    @NamedQuery(name = "BtrPayment.findByCrDate", query = "SELECT b FROM BtrPayment b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrPayment.findByModUserId", query = "SELECT b FROM BtrPayment b WHERE b.modUserId = :modUserId"),
    @NamedQuery(name = "BtrPayment.findByModDate", query = "SELECT b FROM BtrPayment b WHERE b.modDate = :modDate")})
public class BtrPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAYM_ID")
    private BigDecimal paymId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private BigInteger amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORIGINAL_AMOUNT")
    private BigInteger originalAmount;
    @Size(max = 100)
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
    @Size(max = 500)
    @Column(name = "PAYMENT_SUB_TYPE")
    private String paymentSubType;
    @Column(name = "DW_CLPAYMEN_ID")
    private BigInteger dwClpaymenId;
    @Size(max = 100)
    @Column(name = "DW_BALANCE_IMPACT_CODE")
    private String dwBalanceImpactCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CR_USER_ID")
    private BigInteger crUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_USER_ID")
    private BigInteger modUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymId")
    private List<BtrInvPayRel> btrInvPayRelList;
    @JoinColumn(name = "ACCO_ID", referencedColumnName = "ACCO_ID")
    @ManyToOne(optional = false)
    private BtrAccount accoId;

    public BtrPayment() {
    }

    public BtrPayment(BigDecimal paymId) {
        this.paymId = paymId;
    }

    public BtrPayment(BigDecimal paymId, Date paymentDate, Date createdDate, BigInteger amount, BigInteger originalAmount, BigInteger crUserId, Date crDate, BigInteger modUserId, Date modDate) {
        this.paymId = paymId;
        this.paymentDate = paymentDate;
        this.createdDate = createdDate;
        this.amount = amount;
        this.originalAmount = originalAmount;
        this.crUserId = crUserId;
        this.crDate = crDate;
        this.modUserId = modUserId;
        this.modDate = modDate;
    }

    public BigDecimal getPaymId() {
        return paymId;
    }

    public void setPaymId(BigDecimal paymId) {
        this.paymId = paymId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigInteger originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentSubType() {
        return paymentSubType;
    }

    public void setPaymentSubType(String paymentSubType) {
        this.paymentSubType = paymentSubType;
    }

    public BigInteger getDwClpaymenId() {
        return dwClpaymenId;
    }

    public void setDwClpaymenId(BigInteger dwClpaymenId) {
        this.dwClpaymenId = dwClpaymenId;
    }

    public String getDwBalanceImpactCode() {
        return dwBalanceImpactCode;
    }

    public void setDwBalanceImpactCode(String dwBalanceImpactCode) {
        this.dwBalanceImpactCode = dwBalanceImpactCode;
    }

    public BigInteger getCrUserId() {
        return crUserId;
    }

    public void setCrUserId(BigInteger crUserId) {
        this.crUserId = crUserId;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public BigInteger getModUserId() {
        return modUserId;
    }

    public void setModUserId(BigInteger modUserId) {
        this.modUserId = modUserId;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    @XmlTransient
    public List<BtrInvPayRel> getBtrInvPayRelList() {
        return btrInvPayRelList;
    }

    public void setBtrInvPayRelList(List<BtrInvPayRel> btrInvPayRelList) {
        this.btrInvPayRelList = btrInvPayRelList;
    }

    public BtrAccount getAccoId() {
        return accoId;
    }

    public void setAccoId(BtrAccount accoId) {
        this.accoId = accoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymId != null ? paymId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrPayment)) {
            return false;
        }
        BtrPayment other = (BtrPayment) object;
        if ((this.paymId == null && other.paymId != null) || (this.paymId != null && !this.paymId.equals(other.paymId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrPayment[ paymId=" + paymId + " ]";
    }
    
}
