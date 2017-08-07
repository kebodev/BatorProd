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
@Table(name = "BTR_EXTERNAL_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrExternalData.findAll", query = "SELECT b FROM BtrExternalData b"),
    @NamedQuery(name = "BtrExternalData.findByExdaId", query = "SELECT b FROM BtrExternalData b WHERE b.exdaId = :exdaId"),
    @NamedQuery(name = "BtrExternalData.findByExdaValueStr", query = "SELECT b FROM BtrExternalData b WHERE b.exdaValueStr = :exdaValueStr"),
    @NamedQuery(name = "BtrExternalData.findByExdaValueInt", query = "SELECT b FROM BtrExternalData b WHERE b.exdaValueInt = :exdaValueInt"),
    @NamedQuery(name = "BtrExternalData.findByExdaValueDate", query = "SELECT b FROM BtrExternalData b WHERE b.exdaValueDate = :exdaValueDate"),
    @NamedQuery(name = "BtrExternalData.findByDateFrom", query = "SELECT b FROM BtrExternalData b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrExternalData.findByDateTo", query = "SELECT b FROM BtrExternalData b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrExternalData.findByCrDate", query = "SELECT b FROM BtrExternalData b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrExternalData.findByModDate", query = "SELECT b FROM BtrExternalData b WHERE b.modDate = :modDate")})
public class BtrExternalData implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXDA_ID")
    private BigDecimal exdaId;
    @Size(max = 4000)
    @Column(name = "EXDA_VALUE_STR")
    private String exdaValueStr;
    @Column(name = "EXDA_VALUE_INT")
    private BigInteger exdaValueInt;
    @Column(name = "EXDA_VALUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exdaValueDate;
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
    @JoinColumn(name = "DATY_ID", referencedColumnName = "DATY_ID")
    @ManyToOne(optional = false)
    private BtrDExternalDataType datyId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrExternalData() {
    }

    public BtrExternalData(BigDecimal exdaId) {
        this.exdaId = exdaId;
    }

    public BtrExternalData(BigDecimal exdaId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.exdaId = exdaId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getExdaId() {
        return exdaId;
    }

    public void setExdaId(BigDecimal exdaId) {
        this.exdaId = exdaId;
    }

    public String getExdaValueStr() {
        return exdaValueStr;
    }

    public void setExdaValueStr(String exdaValueStr) {
        this.exdaValueStr = exdaValueStr;
    }

    public BigInteger getExdaValueInt() {
        return exdaValueInt;
    }

    public void setExdaValueInt(BigInteger exdaValueInt) {
        this.exdaValueInt = exdaValueInt;
    }

    public Date getExdaValueDate() {
        return exdaValueDate;
    }

    public void setExdaValueDate(Date exdaValueDate) {
        this.exdaValueDate = exdaValueDate;
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

    public BtrDExternalDataType getDatyId() {
        return datyId;
    }

    public void setDatyId(BtrDExternalDataType datyId) {
        this.datyId = datyId;
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
        hash += (exdaId != null ? exdaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrExternalData)) {
            return false;
        }
        BtrExternalData other = (BtrExternalData) object;
        if ((this.exdaId == null && other.exdaId != null) || (this.exdaId != null && !this.exdaId.equals(other.exdaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrExternalData[ exdaId=" + exdaId + " ]";
    }
    
}
