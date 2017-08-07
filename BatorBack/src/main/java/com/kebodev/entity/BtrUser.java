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
@Table(name = "BTR_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrUser.findAll", query = "SELECT b FROM BtrUser b"),
    @NamedQuery(name = "BtrUser.findByUserId", query = "SELECT b FROM BtrUser b WHERE b.userId = :userId"),
    @NamedQuery(name = "BtrUser.findByUserRes", query = "SELECT b FROM BtrUser b WHERE b.userRes = :userRes"),
    @NamedQuery(name = "BtrUser.findByUserJazz", query = "SELECT b FROM BtrUser b WHERE b.userJazz = :userJazz"),
    @NamedQuery(name = "BtrUser.findByUserName", query = "SELECT b FROM BtrUser b WHERE b.userName = :userName"),
    @NamedQuery(name = "BtrUser.findByUserMail", query = "SELECT b FROM BtrUser b WHERE b.userMail = :userMail"),
    @NamedQuery(name = "BtrUser.findByUserMobile", query = "SELECT b FROM BtrUser b WHERE b.userMobile = :userMobile"),
    @NamedQuery(name = "BtrUser.findByDateFrom", query = "SELECT b FROM BtrUser b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrUser.findByDateTo", query = "SELECT b FROM BtrUser b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrUser.findByCrUserId", query = "SELECT b FROM BtrUser b WHERE b.crUserId = :crUserId"),
    @NamedQuery(name = "BtrUser.findByCrDate", query = "SELECT b FROM BtrUser b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrUser.findByModUserId", query = "SELECT b FROM BtrUser b WHERE b.modUserId = :modUserId"),
    @NamedQuery(name = "BtrUser.findByModDate", query = "SELECT b FROM BtrUser b WHERE b.modDate = :modDate")})
public class BtrUser implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_RES")
    private String userRes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_JAZZ")
    private String userJazz;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_MAIL")
    private String userMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_MOBILE")
    private BigInteger userMobile;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDCollectionStepType> btrDCollectionStepTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDCollectionStepType> btrDCollectionStepTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDCollectionEventType> btrDCollectionEventTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDCollectionEventType> btrDCollectionEventTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDCollControllerType> btrDCollControllerTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDCollControllerType> btrDCollControllerTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDEventDetailType> btrDEventDetailTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDEventDetailType> btrDEventDetailTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrInvPayRel> btrInvPayRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrInvPayRel> btrInvPayRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDContactType> btrDContactTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDContactType> btrDContactTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrContact> btrContactList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrContact> btrContactList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDAddressType> btrDAddressTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDAddressType> btrDAddressTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCustomerRel> btrCustomerRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCustomerRel> btrCustomerRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BtrUserRoleRel> btrUserRoleRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrUserRoleRel> btrUserRoleRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrUserRoleRel> btrUserRoleRelList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDSystem> btrDSystemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDSystem> btrDSystemList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrPackage> btrPackageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrPackage> btrPackageList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrExternalData> btrExternalDataList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrExternalData> btrExternalDataList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDPackageType> btrDPackageTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDPackageType> btrDPackageTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDCustomerType> btrDCustomerTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDCustomerType> btrDCustomerTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrAccount> btrAccountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrAccount> btrAccountList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCollectionEvent> btrCollectionEventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCollectionEvent> btrCollectionEventList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCollectionStep> btrCollectionStepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCollectionStep> btrCollectionStepList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDExternalDataType> btrDExternalDataTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDExternalDataType> btrDExternalDataTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCollection> btrCollectionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCollection> btrCollectionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDRole> btrDRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDRole> btrDRoleList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCollectionPackageRel> btrCollectionPackageRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCollectionPackageRel> btrCollectionPackageRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDCusRelType> btrDCusRelTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDCusRelType> btrDCusRelTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrInvoiceHeader> btrInvoiceHeaderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrInvoiceHeader> btrInvoiceHeaderList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDBoolean> btrDBooleanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDBoolean> btrDBooleanList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCustomer> btrCustomerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCustomer> btrCustomerList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrAddress> btrAddressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrAddress> btrAddressList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCollInvRel> btrCollInvRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCollInvRel> btrCollInvRelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDLoadLevel> btrDLoadLevelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDLoadLevel> btrDLoadLevelList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrEventDetail> btrEventDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrEventDetail> btrEventDetailList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrCollectionController> btrCollectionControllerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrCollectionController> btrCollectionControllerList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crUserId")
    private List<BtrDCollInvRelType> btrDCollInvRelTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modUserId")
    private List<BtrDCollInvRelType> btrDCollInvRelTypeList1;

    public BtrUser() {
    }

    public BtrUser(BigDecimal userId) {
        this.userId = userId;
    }

    public BtrUser(BigDecimal userId, String userRes, String userJazz, String userName, String userMail, BigInteger userMobile, Date dateFrom, Date dateTo, BigInteger crUserId, Date crDate, BigInteger modUserId, Date modDate) {
        this.userId = userId;
        this.userRes = userRes;
        this.userJazz = userJazz;
        this.userName = userName;
        this.userMail = userMail;
        this.userMobile = userMobile;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crUserId = crUserId;
        this.crDate = crDate;
        this.modUserId = modUserId;
        this.modDate = modDate;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getUserRes() {
        return userRes;
    }

    public void setUserRes(String userRes) {
        this.userRes = userRes;
    }

    public String getUserJazz() {
        return userJazz;
    }

    public void setUserJazz(String userJazz) {
        this.userJazz = userJazz;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public BigInteger getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(BigInteger userMobile) {
        this.userMobile = userMobile;
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
    public List<BtrDCollectionStepType> getBtrDCollectionStepTypeList() {
        return btrDCollectionStepTypeList;
    }

    public void setBtrDCollectionStepTypeList(List<BtrDCollectionStepType> btrDCollectionStepTypeList) {
        this.btrDCollectionStepTypeList = btrDCollectionStepTypeList;
    }

    @XmlTransient
    public List<BtrDCollectionStepType> getBtrDCollectionStepTypeList1() {
        return btrDCollectionStepTypeList1;
    }

    public void setBtrDCollectionStepTypeList1(List<BtrDCollectionStepType> btrDCollectionStepTypeList1) {
        this.btrDCollectionStepTypeList1 = btrDCollectionStepTypeList1;
    }

    @XmlTransient
    public List<BtrDCollectionEventType> getBtrDCollectionEventTypeList() {
        return btrDCollectionEventTypeList;
    }

    public void setBtrDCollectionEventTypeList(List<BtrDCollectionEventType> btrDCollectionEventTypeList) {
        this.btrDCollectionEventTypeList = btrDCollectionEventTypeList;
    }

    @XmlTransient
    public List<BtrDCollectionEventType> getBtrDCollectionEventTypeList1() {
        return btrDCollectionEventTypeList1;
    }

    public void setBtrDCollectionEventTypeList1(List<BtrDCollectionEventType> btrDCollectionEventTypeList1) {
        this.btrDCollectionEventTypeList1 = btrDCollectionEventTypeList1;
    }

    @XmlTransient
    public List<BtrDCollControllerType> getBtrDCollControllerTypeList() {
        return btrDCollControllerTypeList;
    }

    public void setBtrDCollControllerTypeList(List<BtrDCollControllerType> btrDCollControllerTypeList) {
        this.btrDCollControllerTypeList = btrDCollControllerTypeList;
    }

    @XmlTransient
    public List<BtrDCollControllerType> getBtrDCollControllerTypeList1() {
        return btrDCollControllerTypeList1;
    }

    public void setBtrDCollControllerTypeList1(List<BtrDCollControllerType> btrDCollControllerTypeList1) {
        this.btrDCollControllerTypeList1 = btrDCollControllerTypeList1;
    }

    @XmlTransient
    public List<BtrDEventDetailType> getBtrDEventDetailTypeList() {
        return btrDEventDetailTypeList;
    }

    public void setBtrDEventDetailTypeList(List<BtrDEventDetailType> btrDEventDetailTypeList) {
        this.btrDEventDetailTypeList = btrDEventDetailTypeList;
    }

    @XmlTransient
    public List<BtrDEventDetailType> getBtrDEventDetailTypeList1() {
        return btrDEventDetailTypeList1;
    }

    public void setBtrDEventDetailTypeList1(List<BtrDEventDetailType> btrDEventDetailTypeList1) {
        this.btrDEventDetailTypeList1 = btrDEventDetailTypeList1;
    }

    @XmlTransient
    public List<BtrInvPayRel> getBtrInvPayRelList() {
        return btrInvPayRelList;
    }

    public void setBtrInvPayRelList(List<BtrInvPayRel> btrInvPayRelList) {
        this.btrInvPayRelList = btrInvPayRelList;
    }

    @XmlTransient
    public List<BtrInvPayRel> getBtrInvPayRelList1() {
        return btrInvPayRelList1;
    }

    public void setBtrInvPayRelList1(List<BtrInvPayRel> btrInvPayRelList1) {
        this.btrInvPayRelList1 = btrInvPayRelList1;
    }

    @XmlTransient
    public List<BtrDContactType> getBtrDContactTypeList() {
        return btrDContactTypeList;
    }

    public void setBtrDContactTypeList(List<BtrDContactType> btrDContactTypeList) {
        this.btrDContactTypeList = btrDContactTypeList;
    }

    @XmlTransient
    public List<BtrDContactType> getBtrDContactTypeList1() {
        return btrDContactTypeList1;
    }

    public void setBtrDContactTypeList1(List<BtrDContactType> btrDContactTypeList1) {
        this.btrDContactTypeList1 = btrDContactTypeList1;
    }

    @XmlTransient
    public List<BtrContact> getBtrContactList() {
        return btrContactList;
    }

    public void setBtrContactList(List<BtrContact> btrContactList) {
        this.btrContactList = btrContactList;
    }

    @XmlTransient
    public List<BtrContact> getBtrContactList1() {
        return btrContactList1;
    }

    public void setBtrContactList1(List<BtrContact> btrContactList1) {
        this.btrContactList1 = btrContactList1;
    }

    @XmlTransient
    public List<BtrDAddressType> getBtrDAddressTypeList() {
        return btrDAddressTypeList;
    }

    public void setBtrDAddressTypeList(List<BtrDAddressType> btrDAddressTypeList) {
        this.btrDAddressTypeList = btrDAddressTypeList;
    }

    @XmlTransient
    public List<BtrDAddressType> getBtrDAddressTypeList1() {
        return btrDAddressTypeList1;
    }

    public void setBtrDAddressTypeList1(List<BtrDAddressType> btrDAddressTypeList1) {
        this.btrDAddressTypeList1 = btrDAddressTypeList1;
    }

    @XmlTransient
    public List<BtrCustomerRel> getBtrCustomerRelList() {
        return btrCustomerRelList;
    }

    public void setBtrCustomerRelList(List<BtrCustomerRel> btrCustomerRelList) {
        this.btrCustomerRelList = btrCustomerRelList;
    }

    @XmlTransient
    public List<BtrCustomerRel> getBtrCustomerRelList1() {
        return btrCustomerRelList1;
    }

    public void setBtrCustomerRelList1(List<BtrCustomerRel> btrCustomerRelList1) {
        this.btrCustomerRelList1 = btrCustomerRelList1;
    }

    @XmlTransient
    public List<BtrEventTyDetailTyRel> getBtrEventTyDetailTyRelList() {
        return btrEventTyDetailTyRelList;
    }

    public void setBtrEventTyDetailTyRelList(List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList) {
        this.btrEventTyDetailTyRelList = btrEventTyDetailTyRelList;
    }

    @XmlTransient
    public List<BtrEventTyDetailTyRel> getBtrEventTyDetailTyRelList1() {
        return btrEventTyDetailTyRelList1;
    }

    public void setBtrEventTyDetailTyRelList1(List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList1) {
        this.btrEventTyDetailTyRelList1 = btrEventTyDetailTyRelList1;
    }

    @XmlTransient
    public List<BtrUserRoleRel> getBtrUserRoleRelList() {
        return btrUserRoleRelList;
    }

    public void setBtrUserRoleRelList(List<BtrUserRoleRel> btrUserRoleRelList) {
        this.btrUserRoleRelList = btrUserRoleRelList;
    }

    @XmlTransient
    public List<BtrUserRoleRel> getBtrUserRoleRelList1() {
        return btrUserRoleRelList1;
    }

    public void setBtrUserRoleRelList1(List<BtrUserRoleRel> btrUserRoleRelList1) {
        this.btrUserRoleRelList1 = btrUserRoleRelList1;
    }

    @XmlTransient
    public List<BtrUserRoleRel> getBtrUserRoleRelList2() {
        return btrUserRoleRelList2;
    }

    public void setBtrUserRoleRelList2(List<BtrUserRoleRel> btrUserRoleRelList2) {
        this.btrUserRoleRelList2 = btrUserRoleRelList2;
    }

    @XmlTransient
    public List<BtrDSystem> getBtrDSystemList() {
        return btrDSystemList;
    }

    public void setBtrDSystemList(List<BtrDSystem> btrDSystemList) {
        this.btrDSystemList = btrDSystemList;
    }

    @XmlTransient
    public List<BtrDSystem> getBtrDSystemList1() {
        return btrDSystemList1;
    }

    public void setBtrDSystemList1(List<BtrDSystem> btrDSystemList1) {
        this.btrDSystemList1 = btrDSystemList1;
    }

    @XmlTransient
    public List<BtrPackage> getBtrPackageList() {
        return btrPackageList;
    }

    public void setBtrPackageList(List<BtrPackage> btrPackageList) {
        this.btrPackageList = btrPackageList;
    }

    @XmlTransient
    public List<BtrPackage> getBtrPackageList1() {
        return btrPackageList1;
    }

    public void setBtrPackageList1(List<BtrPackage> btrPackageList1) {
        this.btrPackageList1 = btrPackageList1;
    }

    @XmlTransient
    public List<BtrExternalData> getBtrExternalDataList() {
        return btrExternalDataList;
    }

    public void setBtrExternalDataList(List<BtrExternalData> btrExternalDataList) {
        this.btrExternalDataList = btrExternalDataList;
    }

    @XmlTransient
    public List<BtrExternalData> getBtrExternalDataList1() {
        return btrExternalDataList1;
    }

    public void setBtrExternalDataList1(List<BtrExternalData> btrExternalDataList1) {
        this.btrExternalDataList1 = btrExternalDataList1;
    }

    @XmlTransient
    public List<BtrDPackageType> getBtrDPackageTypeList() {
        return btrDPackageTypeList;
    }

    public void setBtrDPackageTypeList(List<BtrDPackageType> btrDPackageTypeList) {
        this.btrDPackageTypeList = btrDPackageTypeList;
    }

    @XmlTransient
    public List<BtrDPackageType> getBtrDPackageTypeList1() {
        return btrDPackageTypeList1;
    }

    public void setBtrDPackageTypeList1(List<BtrDPackageType> btrDPackageTypeList1) {
        this.btrDPackageTypeList1 = btrDPackageTypeList1;
    }

    @XmlTransient
    public List<BtrDCustomerType> getBtrDCustomerTypeList() {
        return btrDCustomerTypeList;
    }

    public void setBtrDCustomerTypeList(List<BtrDCustomerType> btrDCustomerTypeList) {
        this.btrDCustomerTypeList = btrDCustomerTypeList;
    }

    @XmlTransient
    public List<BtrDCustomerType> getBtrDCustomerTypeList1() {
        return btrDCustomerTypeList1;
    }

    public void setBtrDCustomerTypeList1(List<BtrDCustomerType> btrDCustomerTypeList1) {
        this.btrDCustomerTypeList1 = btrDCustomerTypeList1;
    }

    @XmlTransient
    public List<BtrAccount> getBtrAccountList() {
        return btrAccountList;
    }

    public void setBtrAccountList(List<BtrAccount> btrAccountList) {
        this.btrAccountList = btrAccountList;
    }

    @XmlTransient
    public List<BtrAccount> getBtrAccountList1() {
        return btrAccountList1;
    }

    public void setBtrAccountList1(List<BtrAccount> btrAccountList1) {
        this.btrAccountList1 = btrAccountList1;
    }

    @XmlTransient
    public List<BtrCollectionEvent> getBtrCollectionEventList() {
        return btrCollectionEventList;
    }

    public void setBtrCollectionEventList(List<BtrCollectionEvent> btrCollectionEventList) {
        this.btrCollectionEventList = btrCollectionEventList;
    }

    @XmlTransient
    public List<BtrCollectionEvent> getBtrCollectionEventList1() {
        return btrCollectionEventList1;
    }

    public void setBtrCollectionEventList1(List<BtrCollectionEvent> btrCollectionEventList1) {
        this.btrCollectionEventList1 = btrCollectionEventList1;
    }

    @XmlTransient
    public List<BtrCollectionStep> getBtrCollectionStepList() {
        return btrCollectionStepList;
    }

    public void setBtrCollectionStepList(List<BtrCollectionStep> btrCollectionStepList) {
        this.btrCollectionStepList = btrCollectionStepList;
    }

    @XmlTransient
    public List<BtrCollectionStep> getBtrCollectionStepList1() {
        return btrCollectionStepList1;
    }

    public void setBtrCollectionStepList1(List<BtrCollectionStep> btrCollectionStepList1) {
        this.btrCollectionStepList1 = btrCollectionStepList1;
    }

    @XmlTransient
    public List<BtrDExternalDataType> getBtrDExternalDataTypeList() {
        return btrDExternalDataTypeList;
    }

    public void setBtrDExternalDataTypeList(List<BtrDExternalDataType> btrDExternalDataTypeList) {
        this.btrDExternalDataTypeList = btrDExternalDataTypeList;
    }

    @XmlTransient
    public List<BtrDExternalDataType> getBtrDExternalDataTypeList1() {
        return btrDExternalDataTypeList1;
    }

    public void setBtrDExternalDataTypeList1(List<BtrDExternalDataType> btrDExternalDataTypeList1) {
        this.btrDExternalDataTypeList1 = btrDExternalDataTypeList1;
    }

    @XmlTransient
    public List<BtrCollection> getBtrCollectionList() {
        return btrCollectionList;
    }

    public void setBtrCollectionList(List<BtrCollection> btrCollectionList) {
        this.btrCollectionList = btrCollectionList;
    }

    @XmlTransient
    public List<BtrCollection> getBtrCollectionList1() {
        return btrCollectionList1;
    }

    public void setBtrCollectionList1(List<BtrCollection> btrCollectionList1) {
        this.btrCollectionList1 = btrCollectionList1;
    }

    @XmlTransient
    public List<BtrDRole> getBtrDRoleList() {
        return btrDRoleList;
    }

    public void setBtrDRoleList(List<BtrDRole> btrDRoleList) {
        this.btrDRoleList = btrDRoleList;
    }

    @XmlTransient
    public List<BtrDRole> getBtrDRoleList1() {
        return btrDRoleList1;
    }

    public void setBtrDRoleList1(List<BtrDRole> btrDRoleList1) {
        this.btrDRoleList1 = btrDRoleList1;
    }

    @XmlTransient
    public List<BtrDStepTyEventTyRel> getBtrDStepTyEventTyRelList() {
        return btrDStepTyEventTyRelList;
    }

    public void setBtrDStepTyEventTyRelList(List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList) {
        this.btrDStepTyEventTyRelList = btrDStepTyEventTyRelList;
    }

    @XmlTransient
    public List<BtrDStepTyEventTyRel> getBtrDStepTyEventTyRelList1() {
        return btrDStepTyEventTyRelList1;
    }

    public void setBtrDStepTyEventTyRelList1(List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList1) {
        this.btrDStepTyEventTyRelList1 = btrDStepTyEventTyRelList1;
    }

    @XmlTransient
    public List<BtrCollectionPackageRel> getBtrCollectionPackageRelList() {
        return btrCollectionPackageRelList;
    }

    public void setBtrCollectionPackageRelList(List<BtrCollectionPackageRel> btrCollectionPackageRelList) {
        this.btrCollectionPackageRelList = btrCollectionPackageRelList;
    }

    @XmlTransient
    public List<BtrCollectionPackageRel> getBtrCollectionPackageRelList1() {
        return btrCollectionPackageRelList1;
    }

    public void setBtrCollectionPackageRelList1(List<BtrCollectionPackageRel> btrCollectionPackageRelList1) {
        this.btrCollectionPackageRelList1 = btrCollectionPackageRelList1;
    }

    @XmlTransient
    public List<BtrDCusRelType> getBtrDCusRelTypeList() {
        return btrDCusRelTypeList;
    }

    public void setBtrDCusRelTypeList(List<BtrDCusRelType> btrDCusRelTypeList) {
        this.btrDCusRelTypeList = btrDCusRelTypeList;
    }

    @XmlTransient
    public List<BtrDCusRelType> getBtrDCusRelTypeList1() {
        return btrDCusRelTypeList1;
    }

    public void setBtrDCusRelTypeList1(List<BtrDCusRelType> btrDCusRelTypeList1) {
        this.btrDCusRelTypeList1 = btrDCusRelTypeList1;
    }

    @XmlTransient
    public List<BtrInvoiceHeader> getBtrInvoiceHeaderList() {
        return btrInvoiceHeaderList;
    }

    public void setBtrInvoiceHeaderList(List<BtrInvoiceHeader> btrInvoiceHeaderList) {
        this.btrInvoiceHeaderList = btrInvoiceHeaderList;
    }

    @XmlTransient
    public List<BtrInvoiceHeader> getBtrInvoiceHeaderList1() {
        return btrInvoiceHeaderList1;
    }

    public void setBtrInvoiceHeaderList1(List<BtrInvoiceHeader> btrInvoiceHeaderList1) {
        this.btrInvoiceHeaderList1 = btrInvoiceHeaderList1;
    }

    @XmlTransient
    public List<BtrDBoolean> getBtrDBooleanList() {
        return btrDBooleanList;
    }

    public void setBtrDBooleanList(List<BtrDBoolean> btrDBooleanList) {
        this.btrDBooleanList = btrDBooleanList;
    }

    @XmlTransient
    public List<BtrDBoolean> getBtrDBooleanList1() {
        return btrDBooleanList1;
    }

    public void setBtrDBooleanList1(List<BtrDBoolean> btrDBooleanList1) {
        this.btrDBooleanList1 = btrDBooleanList1;
    }

    @XmlTransient
    public List<BtrCustomer> getBtrCustomerList() {
        return btrCustomerList;
    }

    public void setBtrCustomerList(List<BtrCustomer> btrCustomerList) {
        this.btrCustomerList = btrCustomerList;
    }

    @XmlTransient
    public List<BtrCustomer> getBtrCustomerList1() {
        return btrCustomerList1;
    }

    public void setBtrCustomerList1(List<BtrCustomer> btrCustomerList1) {
        this.btrCustomerList1 = btrCustomerList1;
    }

    @XmlTransient
    public List<BtrAddress> getBtrAddressList() {
        return btrAddressList;
    }

    public void setBtrAddressList(List<BtrAddress> btrAddressList) {
        this.btrAddressList = btrAddressList;
    }

    @XmlTransient
    public List<BtrAddress> getBtrAddressList1() {
        return btrAddressList1;
    }

    public void setBtrAddressList1(List<BtrAddress> btrAddressList1) {
        this.btrAddressList1 = btrAddressList1;
    }

    @XmlTransient
    public List<BtrCollInvRel> getBtrCollInvRelList() {
        return btrCollInvRelList;
    }

    public void setBtrCollInvRelList(List<BtrCollInvRel> btrCollInvRelList) {
        this.btrCollInvRelList = btrCollInvRelList;
    }

    @XmlTransient
    public List<BtrCollInvRel> getBtrCollInvRelList1() {
        return btrCollInvRelList1;
    }

    public void setBtrCollInvRelList1(List<BtrCollInvRel> btrCollInvRelList1) {
        this.btrCollInvRelList1 = btrCollInvRelList1;
    }

    @XmlTransient
    public List<BtrDLoadLevel> getBtrDLoadLevelList() {
        return btrDLoadLevelList;
    }

    public void setBtrDLoadLevelList(List<BtrDLoadLevel> btrDLoadLevelList) {
        this.btrDLoadLevelList = btrDLoadLevelList;
    }

    @XmlTransient
    public List<BtrDLoadLevel> getBtrDLoadLevelList1() {
        return btrDLoadLevelList1;
    }

    public void setBtrDLoadLevelList1(List<BtrDLoadLevel> btrDLoadLevelList1) {
        this.btrDLoadLevelList1 = btrDLoadLevelList1;
    }

    @XmlTransient
    public List<BtrEventDetail> getBtrEventDetailList() {
        return btrEventDetailList;
    }

    public void setBtrEventDetailList(List<BtrEventDetail> btrEventDetailList) {
        this.btrEventDetailList = btrEventDetailList;
    }

    @XmlTransient
    public List<BtrEventDetail> getBtrEventDetailList1() {
        return btrEventDetailList1;
    }

    public void setBtrEventDetailList1(List<BtrEventDetail> btrEventDetailList1) {
        this.btrEventDetailList1 = btrEventDetailList1;
    }

    @XmlTransient
    public List<BtrCollectionController> getBtrCollectionControllerList() {
        return btrCollectionControllerList;
    }

    public void setBtrCollectionControllerList(List<BtrCollectionController> btrCollectionControllerList) {
        this.btrCollectionControllerList = btrCollectionControllerList;
    }

    @XmlTransient
    public List<BtrCollectionController> getBtrCollectionControllerList1() {
        return btrCollectionControllerList1;
    }

    public void setBtrCollectionControllerList1(List<BtrCollectionController> btrCollectionControllerList1) {
        this.btrCollectionControllerList1 = btrCollectionControllerList1;
    }

    @XmlTransient
    public List<BtrDCollInvRelType> getBtrDCollInvRelTypeList() {
        return btrDCollInvRelTypeList;
    }

    public void setBtrDCollInvRelTypeList(List<BtrDCollInvRelType> btrDCollInvRelTypeList) {
        this.btrDCollInvRelTypeList = btrDCollInvRelTypeList;
    }

    @XmlTransient
    public List<BtrDCollInvRelType> getBtrDCollInvRelTypeList1() {
        return btrDCollInvRelTypeList1;
    }

    public void setBtrDCollInvRelTypeList1(List<BtrDCollInvRelType> btrDCollInvRelTypeList1) {
        this.btrDCollInvRelTypeList1 = btrDCollInvRelTypeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrUser)) {
            return false;
        }
        BtrUser other = (BtrUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrUser[ userId=" + userId + " ]";
    }
    
}
