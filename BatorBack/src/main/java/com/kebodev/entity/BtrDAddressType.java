/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kebodev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "BTR_D_ADDRESS_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDAddressType.findAll", query = "SELECT b FROM BtrDAddressType b"),
    @NamedQuery(name = "BtrDAddressType.findByAdtyId", query = "SELECT b FROM BtrDAddressType b WHERE b.adtyId = :adtyId"),
    @NamedQuery(name = "BtrDAddressType.findByAdtyName", query = "SELECT b FROM BtrDAddressType b WHERE b.adtyName = :adtyName"),
    @NamedQuery(name = "BtrDAddressType.findByDateFrom", query = "SELECT b FROM BtrDAddressType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDAddressType.findByDateTo", query = "SELECT b FROM BtrDAddressType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDAddressType.findByCrDate", query = "SELECT b FROM BtrDAddressType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDAddressType.findByModDate", query = "SELECT b FROM BtrDAddressType b WHERE b.modDate = :modDate")})
public class BtrDAddressType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADTY_ID")
    private BigDecimal adtyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADTY_NAME")
    private String adtyName;
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
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adtyId")
    private List<BtrAddress> btrAddressList;

    public BtrDAddressType() {
    }

    public BtrDAddressType(BigDecimal adtyId) {
        this.adtyId = adtyId;
    }

    public BtrDAddressType(BigDecimal adtyId, String adtyName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.adtyId = adtyId;
        this.adtyName = adtyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getAdtyId() {
        return adtyId;
    }

    public void setAdtyId(BigDecimal adtyId) {
        this.adtyId = adtyId;
    }

    public String getAdtyName() {
        return adtyName;
    }

    public void setAdtyName(String adtyName) {
        this.adtyName = adtyName;
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

    @XmlTransient
    public List<BtrAddress> getBtrAddressList() {
        return btrAddressList;
    }

    public void setBtrAddressList(List<BtrAddress> btrAddressList) {
        this.btrAddressList = btrAddressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adtyId != null ? adtyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDAddressType)) {
            return false;
        }
        BtrDAddressType other = (BtrDAddressType) object;
        if ((this.adtyId == null && other.adtyId != null) || (this.adtyId != null && !this.adtyId.equals(other.adtyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDAddressType[ adtyId=" + adtyId + " ]";
    }
    
}
