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
@Table(name = "BTR_D_EXTERNAL_DATA_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDExternalDataType.findAll", query = "SELECT b FROM BtrDExternalDataType b"),
    @NamedQuery(name = "BtrDExternalDataType.findByDatyId", query = "SELECT b FROM BtrDExternalDataType b WHERE b.datyId = :datyId"),
    @NamedQuery(name = "BtrDExternalDataType.findByDatyName", query = "SELECT b FROM BtrDExternalDataType b WHERE b.datyName = :datyName"),
    @NamedQuery(name = "BtrDExternalDataType.findByDatyDetailType", query = "SELECT b FROM BtrDExternalDataType b WHERE b.datyDetailType = :datyDetailType"),
    @NamedQuery(name = "BtrDExternalDataType.findByDateFrom", query = "SELECT b FROM BtrDExternalDataType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDExternalDataType.findByDateTo", query = "SELECT b FROM BtrDExternalDataType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDExternalDataType.findByCrDate", query = "SELECT b FROM BtrDExternalDataType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDExternalDataType.findByModDate", query = "SELECT b FROM BtrDExternalDataType b WHERE b.modDate = :modDate")})
public class BtrDExternalDataType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATY_ID")
    private BigDecimal datyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DATY_NAME")
    private String datyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DATY_DETAIL_TYPE")
    private String datyDetailType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datyId")
    private List<BtrExternalData> btrExternalDataList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDExternalDataType() {
    }

    public BtrDExternalDataType(BigDecimal datyId) {
        this.datyId = datyId;
    }

    public BtrDExternalDataType(BigDecimal datyId, String datyName, String datyDetailType, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.datyId = datyId;
        this.datyName = datyName;
        this.datyDetailType = datyDetailType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getDatyId() {
        return datyId;
    }

    public void setDatyId(BigDecimal datyId) {
        this.datyId = datyId;
    }

    public String getDatyName() {
        return datyName;
    }

    public void setDatyName(String datyName) {
        this.datyName = datyName;
    }

    public String getDatyDetailType() {
        return datyDetailType;
    }

    public void setDatyDetailType(String datyDetailType) {
        this.datyDetailType = datyDetailType;
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

    @XmlTransient
    public List<BtrExternalData> getBtrExternalDataList() {
        return btrExternalDataList;
    }

    public void setBtrExternalDataList(List<BtrExternalData> btrExternalDataList) {
        this.btrExternalDataList = btrExternalDataList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datyId != null ? datyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDExternalDataType)) {
            return false;
        }
        BtrDExternalDataType other = (BtrDExternalDataType) object;
        if ((this.datyId == null && other.datyId != null) || (this.datyId != null && !this.datyId.equals(other.datyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDExternalDataType[ datyId=" + datyId + " ]";
    }
    
}
