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
@Table(name = "BTR_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrAddress.findAll", query = "SELECT b FROM BtrAddress b"),
    @NamedQuery(name = "BtrAddress.findByAdreId", query = "SELECT b FROM BtrAddress b WHERE b.adreId = :adreId"),
    @NamedQuery(name = "BtrAddress.findByCity", query = "SELECT b FROM BtrAddress b WHERE b.city = :city"),
    @NamedQuery(name = "BtrAddress.findByAddress", query = "SELECT b FROM BtrAddress b WHERE b.address = :address"),
    @NamedQuery(name = "BtrAddress.findByZip", query = "SELECT b FROM BtrAddress b WHERE b.zip = :zip"),
    @NamedQuery(name = "BtrAddress.findByAdFloor", query = "SELECT b FROM BtrAddress b WHERE b.adFloor = :adFloor"),
    @NamedQuery(name = "BtrAddress.findByAdDoor", query = "SELECT b FROM BtrAddress b WHERE b.adDoor = :adDoor"),
    @NamedQuery(name = "BtrAddress.findByAdBuilding", query = "SELECT b FROM BtrAddress b WHERE b.adBuilding = :adBuilding"),
    @NamedQuery(name = "BtrAddress.findByAdEtc", query = "SELECT b FROM BtrAddress b WHERE b.adEtc = :adEtc"),
    @NamedQuery(name = "BtrAddress.findByDateFrom", query = "SELECT b FROM BtrAddress b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrAddress.findByDateTo", query = "SELECT b FROM BtrAddress b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrAddress.findByCrDate", query = "SELECT b FROM BtrAddress b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrAddress.findByModDate", query = "SELECT b FROM BtrAddress b WHERE b.modDate = :modDate")})
public class BtrAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADRE_ID")
    private BigDecimal adreId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    private BigInteger zip;
    @Size(max = 100)
    @Column(name = "AD_FLOOR")
    private String adFloor;
    @Size(max = 100)
    @Column(name = "AD_DOOR")
    private String adDoor;
    @Size(max = 100)
    @Column(name = "AD_BUILDING")
    private String adBuilding;
    @Size(max = 100)
    @Column(name = "AD_ETC")
    private String adEtc;
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
    @JoinColumn(name = "ACCO_ID", referencedColumnName = "ACCO_ID")
    @ManyToOne(optional = false)
    private BtrAccount accoId;
    @JoinColumn(name = "ADTY_ID", referencedColumnName = "ADTY_ID")
    @ManyToOne(optional = false)
    private BtrDAddressType adtyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrAddress() {
    }

    public BtrAddress(BigDecimal adreId) {
        this.adreId = adreId;
    }

    public BtrAddress(BigDecimal adreId, String city, String address, BigInteger zip, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.adreId = adreId;
        this.city = city;
        this.address = address;
        this.zip = zip;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getAdreId() {
        return adreId;
    }

    public void setAdreId(BigDecimal adreId) {
        this.adreId = adreId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getZip() {
        return zip;
    }

    public void setZip(BigInteger zip) {
        this.zip = zip;
    }

    public String getAdFloor() {
        return adFloor;
    }

    public void setAdFloor(String adFloor) {
        this.adFloor = adFloor;
    }

    public String getAdDoor() {
        return adDoor;
    }

    public void setAdDoor(String adDoor) {
        this.adDoor = adDoor;
    }

    public String getAdBuilding() {
        return adBuilding;
    }

    public void setAdBuilding(String adBuilding) {
        this.adBuilding = adBuilding;
    }

    public String getAdEtc() {
        return adEtc;
    }

    public void setAdEtc(String adEtc) {
        this.adEtc = adEtc;
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

    public BtrAccount getAccoId() {
        return accoId;
    }

    public void setAccoId(BtrAccount accoId) {
        this.accoId = accoId;
    }

    public BtrDAddressType getAdtyId() {
        return adtyId;
    }

    public void setAdtyId(BtrDAddressType adtyId) {
        this.adtyId = adtyId;
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
        hash += (adreId != null ? adreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrAddress)) {
            return false;
        }
        BtrAddress other = (BtrAddress) object;
        if ((this.adreId == null && other.adreId != null) || (this.adreId != null && !this.adreId.equals(other.adreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrAddress[ adreId=" + adreId + " ]";
    }
    
}
