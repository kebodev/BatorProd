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
@Table(name = "BTR_D_CONTACT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDContactType.findAll", query = "SELECT b FROM BtrDContactType b"),
    @NamedQuery(name = "BtrDContactType.findByCotyId", query = "SELECT b FROM BtrDContactType b WHERE b.cotyId = :cotyId"),
    @NamedQuery(name = "BtrDContactType.findByCotyName", query = "SELECT b FROM BtrDContactType b WHERE b.cotyName = :cotyName"),
    @NamedQuery(name = "BtrDContactType.findByDateFrom", query = "SELECT b FROM BtrDContactType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDContactType.findByDateTo", query = "SELECT b FROM BtrDContactType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDContactType.findByCrDate", query = "SELECT b FROM BtrDContactType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDContactType.findByModDate", query = "SELECT b FROM BtrDContactType b WHERE b.modDate = :modDate")})
public class BtrDContactType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COTY_ID")
    private BigDecimal cotyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COTY_NAME")
    private String cotyName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotyId")
    private List<BtrContact> btrContactList;

    public BtrDContactType() {
    }

    public BtrDContactType(BigDecimal cotyId) {
        this.cotyId = cotyId;
    }

    public BtrDContactType(BigDecimal cotyId, String cotyName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cotyId = cotyId;
        this.cotyName = cotyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCotyId() {
        return cotyId;
    }

    public void setCotyId(BigDecimal cotyId) {
        this.cotyId = cotyId;
    }

    public String getCotyName() {
        return cotyName;
    }

    public void setCotyName(String cotyName) {
        this.cotyName = cotyName;
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
    public List<BtrContact> getBtrContactList() {
        return btrContactList;
    }

    public void setBtrContactList(List<BtrContact> btrContactList) {
        this.btrContactList = btrContactList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotyId != null ? cotyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDContactType)) {
            return false;
        }
        BtrDContactType other = (BtrDContactType) object;
        if ((this.cotyId == null && other.cotyId != null) || (this.cotyId != null && !this.cotyId.equals(other.cotyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDContactType[ cotyId=" + cotyId + " ]";
    }
    
}
