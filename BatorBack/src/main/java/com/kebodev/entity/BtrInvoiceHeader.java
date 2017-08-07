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
@Table(name = "BTR_INVOICE_HEADER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrInvoiceHeader.findAll", query = "SELECT b FROM BtrInvoiceHeader b"),
    @NamedQuery(name = "BtrInvoiceHeader.findByInheId", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.inheId = :inheId"),
    @NamedQuery(name = "BtrInvoiceHeader.findByInvoiceNumber", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "BtrInvoiceHeader.findByInvTypeName", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.invTypeName = :invTypeName"),
    @NamedQuery(name = "BtrInvoiceHeader.findByInvCrDate", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.invCrDate = :invCrDate"),
    @NamedQuery(name = "BtrInvoiceHeader.findByInvDueDate", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.invDueDate = :invDueDate"),
    @NamedQuery(name = "BtrInvoiceHeader.findByPeriodStartDate", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.periodStartDate = :periodStartDate"),
    @NamedQuery(name = "BtrInvoiceHeader.findByPeriodEndDate", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.periodEndDate = :periodEndDate"),
    @NamedQuery(name = "BtrInvoiceHeader.findByAmountNetTotal", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.amountNetTotal = :amountNetTotal"),
    @NamedQuery(name = "BtrInvoiceHeader.findByAmountGrossTotal", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.amountGrossTotal = :amountGrossTotal"),
    @NamedQuery(name = "BtrInvoiceHeader.findByAmountOpen", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.amountOpen = :amountOpen"),
    @NamedQuery(name = "BtrInvoiceHeader.findByDwClinvheaId", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.dwClinvheaId = :dwClinvheaId"),
    @NamedQuery(name = "BtrInvoiceHeader.findByDwClinvheaIdOrigInv", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.dwClinvheaIdOrigInv = :dwClinvheaIdOrigInv"),
    @NamedQuery(name = "BtrInvoiceHeader.findByDwClinvtypId", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.dwClinvtypId = :dwClinvtypId"),
    @NamedQuery(name = "BtrInvoiceHeader.findByDwClinvreaId", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.dwClinvreaId = :dwClinvreaId"),
    @NamedQuery(name = "BtrInvoiceHeader.findByCrDate", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrInvoiceHeader.findByModDate", query = "SELECT b FROM BtrInvoiceHeader b WHERE b.modDate = :modDate")})
public class BtrInvoiceHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INHE_ID")
    private BigDecimal inheId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;
    @Size(max = 500)
    @Column(name = "INV_TYPE_NAME")
    private String invTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INV_CR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invCrDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INV_DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invDueDate;
    @Column(name = "PERIOD_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodStartDate;
    @Column(name = "PERIOD_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_NET_TOTAL")
    private BigInteger amountNetTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_GROSS_TOTAL")
    private BigInteger amountGrossTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT_OPEN")
    private BigInteger amountOpen;
    @Column(name = "DW_CLINVHEA_ID")
    private BigInteger dwClinvheaId;
    @Column(name = "DW_CLINVHEA_ID_ORIG_INV")
    private BigInteger dwClinvheaIdOrigInv;
    @Column(name = "DW_CLINVTYP_ID")
    private BigInteger dwClinvtypId;
    @Column(name = "DW_CLINVREA_ID")
    private BigInteger dwClinvreaId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inheId")
    private List<BtrInvPayRel> btrInvPayRelList;
    @JoinColumn(name = "ACCO_ID", referencedColumnName = "ACCO_ID")
    @ManyToOne(optional = false)
    private BtrAccount accoId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inheId")
    private List<BtrCollInvRel> btrCollInvRelList;

    public BtrInvoiceHeader() {
    }

    public BtrInvoiceHeader(BigDecimal inheId) {
        this.inheId = inheId;
    }

    public BtrInvoiceHeader(BigDecimal inheId, String invoiceNumber, Date invCrDate, Date invDueDate, BigInteger amountNetTotal, BigInteger amountGrossTotal, BigInteger amountOpen, Date crDate, Date modDate) {
        this.inheId = inheId;
        this.invoiceNumber = invoiceNumber;
        this.invCrDate = invCrDate;
        this.invDueDate = invDueDate;
        this.amountNetTotal = amountNetTotal;
        this.amountGrossTotal = amountGrossTotal;
        this.amountOpen = amountOpen;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getInheId() {
        return inheId;
    }

    public void setInheId(BigDecimal inheId) {
        this.inheId = inheId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvTypeName() {
        return invTypeName;
    }

    public void setInvTypeName(String invTypeName) {
        this.invTypeName = invTypeName;
    }

    public Date getInvCrDate() {
        return invCrDate;
    }

    public void setInvCrDate(Date invCrDate) {
        this.invCrDate = invCrDate;
    }

    public Date getInvDueDate() {
        return invDueDate;
    }

    public void setInvDueDate(Date invDueDate) {
        this.invDueDate = invDueDate;
    }

    public Date getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(Date periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public Date getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(Date periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public BigInteger getAmountNetTotal() {
        return amountNetTotal;
    }

    public void setAmountNetTotal(BigInteger amountNetTotal) {
        this.amountNetTotal = amountNetTotal;
    }

    public BigInteger getAmountGrossTotal() {
        return amountGrossTotal;
    }

    public void setAmountGrossTotal(BigInteger amountGrossTotal) {
        this.amountGrossTotal = amountGrossTotal;
    }

    public BigInteger getAmountOpen() {
        return amountOpen;
    }

    public void setAmountOpen(BigInteger amountOpen) {
        this.amountOpen = amountOpen;
    }

    public BigInteger getDwClinvheaId() {
        return dwClinvheaId;
    }

    public void setDwClinvheaId(BigInteger dwClinvheaId) {
        this.dwClinvheaId = dwClinvheaId;
    }

    public BigInteger getDwClinvheaIdOrigInv() {
        return dwClinvheaIdOrigInv;
    }

    public void setDwClinvheaIdOrigInv(BigInteger dwClinvheaIdOrigInv) {
        this.dwClinvheaIdOrigInv = dwClinvheaIdOrigInv;
    }

    public BigInteger getDwClinvtypId() {
        return dwClinvtypId;
    }

    public void setDwClinvtypId(BigInteger dwClinvtypId) {
        this.dwClinvtypId = dwClinvtypId;
    }

    public BigInteger getDwClinvreaId() {
        return dwClinvreaId;
    }

    public void setDwClinvreaId(BigInteger dwClinvreaId) {
        this.dwClinvreaId = dwClinvreaId;
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
    public List<BtrCollInvRel> getBtrCollInvRelList() {
        return btrCollInvRelList;
    }

    public void setBtrCollInvRelList(List<BtrCollInvRel> btrCollInvRelList) {
        this.btrCollInvRelList = btrCollInvRelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inheId != null ? inheId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrInvoiceHeader)) {
            return false;
        }
        BtrInvoiceHeader other = (BtrInvoiceHeader) object;
        if ((this.inheId == null && other.inheId != null) || (this.inheId != null && !this.inheId.equals(other.inheId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrInvoiceHeader[ inheId=" + inheId + " ]";
    }
    
}
