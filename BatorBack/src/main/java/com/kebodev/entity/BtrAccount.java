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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrAccount.findAll", query = "SELECT b FROM BtrAccount b"),
    @NamedQuery(name = "BtrAccount.findByAccoId", query = "SELECT b FROM BtrAccount b WHERE b.accoId = :accoId"),
    @NamedQuery(name = "BtrAccount.findByAccoActualDebt", query = "SELECT b FROM BtrAccount b WHERE b.accoActualDebt = :accoActualDebt"),
    @NamedQuery(name = "BtrAccount.findByAccoActualDebtTelco", query = "SELECT b FROM BtrAccount b WHERE b.accoActualDebtTelco = :accoActualDebtTelco"),
    @NamedQuery(name = "BtrAccount.findByAccoActualDebtHw", query = "SELECT b FROM BtrAccount b WHERE b.accoActualDebtHw = :accoActualDebtHw"),
    @NamedQuery(name = "BtrAccount.findByAccoNumber", query = "SELECT b FROM BtrAccount b WHERE b.accoNumber = :accoNumber"),
    @NamedQuery(name = "BtrAccount.findByCrDate", query = "SELECT b FROM BtrAccount b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrAccount.findByModDate", query = "SELECT b FROM BtrAccount b WHERE b.modDate = :modDate")})
public class BtrAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCO_ID")
    private BigDecimal accoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCO_ACTUAL_DEBT")
    private BigInteger accoActualDebt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCO_ACTUAL_DEBT_TELCO")
    private BigInteger accoActualDebtTelco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCO_ACTUAL_DEBT_HW")
    private BigInteger accoActualDebtHw;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCO_NUMBER")
    private BigInteger accoNumber;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accoId")
    private List<BtrContact> btrContactList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accoId")
    private List<BtrPayment> btrPaymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accoId")
    private List<BtrExternalData> btrExternalDataList;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne(optional = false)
    private BtrCustomer custId;
    @JoinColumn(name = "BOOL_ID_IS_ACTIVE", referencedColumnName = "BOOL_ID")
    @ManyToOne(optional = false)
    private BtrDBoolean boolIdIsActive;
    @JoinColumn(name = "LOLE_ID", referencedColumnName = "LOLE_ID")
    @ManyToOne(optional = false)
    private BtrDLoadLevel loleId;
    @JoinColumn(name = "SYST_ID", referencedColumnName = "SYST_ID")
    @ManyToOne(optional = false)
    private BtrDSystem systId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accoId")
    private List<BtrInvoiceHeader> btrInvoiceHeaderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accoId")
    private List<BtrAddress> btrAddressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accoId")
    private List<BtrCollectionController> btrCollectionControllerList;

    public BtrAccount() {
    }

    public BtrAccount(BigDecimal accoId) {
        this.accoId = accoId;
    }

    public BtrAccount(BigDecimal accoId, BigInteger accoActualDebt, BigInteger accoActualDebtTelco, BigInteger accoActualDebtHw, BigInteger accoNumber, Date crDate, Date modDate) {
        this.accoId = accoId;
        this.accoActualDebt = accoActualDebt;
        this.accoActualDebtTelco = accoActualDebtTelco;
        this.accoActualDebtHw = accoActualDebtHw;
        this.accoNumber = accoNumber;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getAccoId() {
        return accoId;
    }

    public void setAccoId(BigDecimal accoId) {
        this.accoId = accoId;
    }

    public BigInteger getAccoActualDebt() {
        return accoActualDebt;
    }

    public void setAccoActualDebt(BigInteger accoActualDebt) {
        this.accoActualDebt = accoActualDebt;
    }

    public BigInteger getAccoActualDebtTelco() {
        return accoActualDebtTelco;
    }

    public void setAccoActualDebtTelco(BigInteger accoActualDebtTelco) {
        this.accoActualDebtTelco = accoActualDebtTelco;
    }

    public BigInteger getAccoActualDebtHw() {
        return accoActualDebtHw;
    }

    public void setAccoActualDebtHw(BigInteger accoActualDebtHw) {
        this.accoActualDebtHw = accoActualDebtHw;
    }

    public BigInteger getAccoNumber() {
        return accoNumber;
    }

    public void setAccoNumber(BigInteger accoNumber) {
        this.accoNumber = accoNumber;
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
    public List<BtrContact> getBtrContactList() {
        return btrContactList;
    }

    public void setBtrContactList(List<BtrContact> btrContactList) {
        this.btrContactList = btrContactList;
    }

    @XmlTransient
    public List<BtrPayment> getBtrPaymentList() {
        return btrPaymentList;
    }

    public void setBtrPaymentList(List<BtrPayment> btrPaymentList) {
        this.btrPaymentList = btrPaymentList;
    }

    @XmlTransient
    public List<BtrExternalData> getBtrExternalDataList() {
        return btrExternalDataList;
    }

    public void setBtrExternalDataList(List<BtrExternalData> btrExternalDataList) {
        this.btrExternalDataList = btrExternalDataList;
    }

    public BtrCustomer getCustId() {
        return custId;
    }

    public void setCustId(BtrCustomer custId) {
        this.custId = custId;
    }

    public BtrDBoolean getBoolIdIsActive() {
        return boolIdIsActive;
    }

    public void setBoolIdIsActive(BtrDBoolean boolIdIsActive) {
        this.boolIdIsActive = boolIdIsActive;
    }

    public BtrDLoadLevel getLoleId() {
        return loleId;
    }

    public void setLoleId(BtrDLoadLevel loleId) {
        this.loleId = loleId;
    }

    public BtrDSystem getSystId() {
        return systId;
    }

    public void setSystId(BtrDSystem systId) {
        this.systId = systId;
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
    public List<BtrInvoiceHeader> getBtrInvoiceHeaderList() {
        return btrInvoiceHeaderList;
    }

    public void setBtrInvoiceHeaderList(List<BtrInvoiceHeader> btrInvoiceHeaderList) {
        this.btrInvoiceHeaderList = btrInvoiceHeaderList;
    }

    @XmlTransient
    public List<BtrAddress> getBtrAddressList() {
        return btrAddressList;
    }

    public void setBtrAddressList(List<BtrAddress> btrAddressList) {
        this.btrAddressList = btrAddressList;
    }

    @XmlTransient
    public List<BtrCollectionController> getBtrCollectionControllerList() {
        return btrCollectionControllerList;
    }

    public void setBtrCollectionControllerList(List<BtrCollectionController> btrCollectionControllerList) {
        this.btrCollectionControllerList = btrCollectionControllerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accoId != null ? accoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrAccount)) {
            return false;
        }
        BtrAccount other = (BtrAccount) object;
        if ((this.accoId == null && other.accoId != null) || (this.accoId != null && !this.accoId.equals(other.accoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrAccount[ accoId=" + accoId + " ]";
    }
    
}
