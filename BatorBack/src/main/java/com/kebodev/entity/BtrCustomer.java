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
import javax.persistence.OneToOne;
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
@Table(name = "BTR_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCustomer.findAll", query = "SELECT b FROM BtrCustomer b"),
    @NamedQuery(name = "BtrCustomer.findByCustId", query = "SELECT b FROM BtrCustomer b WHERE b.custId = :custId"),
    @NamedQuery(name = "BtrCustomer.findByMtId", query = "SELECT b FROM BtrCustomer b WHERE b.mtId = :mtId"),
    @NamedQuery(name = "BtrCustomer.findByCustomerno", query = "SELECT b FROM BtrCustomer b WHERE b.customerno = :customerno"),
    @NamedQuery(name = "BtrCustomer.findByCustGivenName", query = "SELECT b FROM BtrCustomer b WHERE b.custGivenName = :custGivenName"),
    @NamedQuery(name = "BtrCustomer.findByCustFamilyName", query = "SELECT b FROM BtrCustomer b WHERE b.custFamilyName = :custFamilyName"),
    @NamedQuery(name = "BtrCustomer.findByCustMotherName", query = "SELECT b FROM BtrCustomer b WHERE b.custMotherName = :custMotherName"),
    @NamedQuery(name = "BtrCustomer.findByCustPlaceOfBirth", query = "SELECT b FROM BtrCustomer b WHERE b.custPlaceOfBirth = :custPlaceOfBirth"),
    @NamedQuery(name = "BtrCustomer.findByCustDateOfBirth", query = "SELECT b FROM BtrCustomer b WHERE b.custDateOfBirth = :custDateOfBirth"),
    @NamedQuery(name = "BtrCustomer.findByCustCompRegid", query = "SELECT b FROM BtrCustomer b WHERE b.custCompRegid = :custCompRegid"),
    @NamedQuery(name = "BtrCustomer.findByCustCompTaxNumber", query = "SELECT b FROM BtrCustomer b WHERE b.custCompTaxNumber = :custCompTaxNumber"),
    @NamedQuery(name = "BtrCustomer.findByCrDate", query = "SELECT b FROM BtrCustomer b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCustomer.findByModDate", query = "SELECT b FROM BtrCustomer b WHERE b.modDate = :modDate")})
public class BtrCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUST_ID")
    private BigDecimal custId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MT_ID")
    private BigInteger mtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUSTOMERNO")
    private String customerno;
    @Size(max = 500)
    @Column(name = "CUST_GIVEN_NAME")
    private String custGivenName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUST_FAMILY_NAME")
    private String custFamilyName;
    @Size(max = 500)
    @Column(name = "CUST_MOTHER_NAME")
    private String custMotherName;
    @Size(max = 100)
    @Column(name = "CUST_PLACE_OF_BIRTH")
    private String custPlaceOfBirth;
    @Column(name = "CUST_DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date custDateOfBirth;
    @Size(max = 100)
    @Column(name = "CUST_COMP_REGID")
    private String custCompRegid;
    @Size(max = 50)
    @Column(name = "CUST_COMP_TAX_NUMBER")
    private String custCompTaxNumber;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "custIdChild")
    private BtrCustomerRel btrCustomerRel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custIdMother")
    private List<BtrCustomerRel> btrCustomerRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private List<BtrAccount> btrAccountList;
    @JoinColumn(name = "CUTY_ID", referencedColumnName = "CUTY_ID")
    @ManyToOne(optional = false)
    private BtrDCustomerType cutyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrCustomer() {
    }

    public BtrCustomer(BigDecimal custId) {
        this.custId = custId;
    }

    public BtrCustomer(BigDecimal custId, BigInteger mtId, String customerno, String custFamilyName, Date crDate, Date modDate) {
        this.custId = custId;
        this.mtId = mtId;
        this.customerno = customerno;
        this.custFamilyName = custFamilyName;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCustId() {
        return custId;
    }

    public void setCustId(BigDecimal custId) {
        this.custId = custId;
    }

    public BigInteger getMtId() {
        return mtId;
    }

    public void setMtId(BigInteger mtId) {
        this.mtId = mtId;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getCustGivenName() {
        return custGivenName;
    }

    public void setCustGivenName(String custGivenName) {
        this.custGivenName = custGivenName;
    }

    public String getCustFamilyName() {
        return custFamilyName;
    }

    public void setCustFamilyName(String custFamilyName) {
        this.custFamilyName = custFamilyName;
    }

    public String getCustMotherName() {
        return custMotherName;
    }

    public void setCustMotherName(String custMotherName) {
        this.custMotherName = custMotherName;
    }

    public String getCustPlaceOfBirth() {
        return custPlaceOfBirth;
    }

    public void setCustPlaceOfBirth(String custPlaceOfBirth) {
        this.custPlaceOfBirth = custPlaceOfBirth;
    }

    public Date getCustDateOfBirth() {
        return custDateOfBirth;
    }

    public void setCustDateOfBirth(Date custDateOfBirth) {
        this.custDateOfBirth = custDateOfBirth;
    }

    public String getCustCompRegid() {
        return custCompRegid;
    }

    public void setCustCompRegid(String custCompRegid) {
        this.custCompRegid = custCompRegid;
    }

    public String getCustCompTaxNumber() {
        return custCompTaxNumber;
    }

    public void setCustCompTaxNumber(String custCompTaxNumber) {
        this.custCompTaxNumber = custCompTaxNumber;
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

    public BtrCustomerRel getBtrCustomerRel() {
        return btrCustomerRel;
    }

    public void setBtrCustomerRel(BtrCustomerRel btrCustomerRel) {
        this.btrCustomerRel = btrCustomerRel;
    }

    @XmlTransient
    public List<BtrCustomerRel> getBtrCustomerRelList() {
        return btrCustomerRelList;
    }

    public void setBtrCustomerRelList(List<BtrCustomerRel> btrCustomerRelList) {
        this.btrCustomerRelList = btrCustomerRelList;
    }

    @XmlTransient
    public List<BtrAccount> getBtrAccountList() {
        return btrAccountList;
    }

    public void setBtrAccountList(List<BtrAccount> btrAccountList) {
        this.btrAccountList = btrAccountList;
    }

    public BtrDCustomerType getCutyId() {
        return cutyId;
    }

    public void setCutyId(BtrDCustomerType cutyId) {
        this.cutyId = cutyId;
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
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCustomer)) {
            return false;
        }
        BtrCustomer other = (BtrCustomer) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCustomer[ custId=" + custId + " ]";
    }
    
}
