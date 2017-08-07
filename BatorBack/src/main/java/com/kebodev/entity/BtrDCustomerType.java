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
@Table(name = "BTR_D_CUSTOMER_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDCustomerType.findAll", query = "SELECT b FROM BtrDCustomerType b"),
    @NamedQuery(name = "BtrDCustomerType.findByCutyId", query = "SELECT b FROM BtrDCustomerType b WHERE b.cutyId = :cutyId"),
    @NamedQuery(name = "BtrDCustomerType.findByCutyName", query = "SELECT b FROM BtrDCustomerType b WHERE b.cutyName = :cutyName"),
    @NamedQuery(name = "BtrDCustomerType.findByDateFrom", query = "SELECT b FROM BtrDCustomerType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDCustomerType.findByDateTo", query = "SELECT b FROM BtrDCustomerType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDCustomerType.findByCrDate", query = "SELECT b FROM BtrDCustomerType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDCustomerType.findByModDate", query = "SELECT b FROM BtrDCustomerType b WHERE b.modDate = :modDate")})
public class BtrDCustomerType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUTY_ID")
    private BigDecimal cutyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUTY_NAME")
    private String cutyName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cutyId")
    private List<BtrCustomer> btrCustomerList;

    public BtrDCustomerType() {
    }

    public BtrDCustomerType(BigDecimal cutyId) {
        this.cutyId = cutyId;
    }

    public BtrDCustomerType(BigDecimal cutyId, String cutyName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cutyId = cutyId;
        this.cutyName = cutyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCutyId() {
        return cutyId;
    }

    public void setCutyId(BigDecimal cutyId) {
        this.cutyId = cutyId;
    }

    public String getCutyName() {
        return cutyName;
    }

    public void setCutyName(String cutyName) {
        this.cutyName = cutyName;
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
    public List<BtrCustomer> getBtrCustomerList() {
        return btrCustomerList;
    }

    public void setBtrCustomerList(List<BtrCustomer> btrCustomerList) {
        this.btrCustomerList = btrCustomerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cutyId != null ? cutyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDCustomerType)) {
            return false;
        }
        BtrDCustomerType other = (BtrDCustomerType) object;
        if ((this.cutyId == null && other.cutyId != null) || (this.cutyId != null && !this.cutyId.equals(other.cutyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDCustomerType[ cutyId=" + cutyId + " ]";
    }
    
}
