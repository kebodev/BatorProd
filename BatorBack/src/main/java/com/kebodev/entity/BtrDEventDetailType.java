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
@Table(name = "BTR_D_EVENT_DETAIL_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDEventDetailType.findAll", query = "SELECT b FROM BtrDEventDetailType b"),
    @NamedQuery(name = "BtrDEventDetailType.findByEdtyId", query = "SELECT b FROM BtrDEventDetailType b WHERE b.edtyId = :edtyId"),
    @NamedQuery(name = "BtrDEventDetailType.findByEdtyName", query = "SELECT b FROM BtrDEventDetailType b WHERE b.edtyName = :edtyName"),
    @NamedQuery(name = "BtrDEventDetailType.findByEdtyDetailType", query = "SELECT b FROM BtrDEventDetailType b WHERE b.edtyDetailType = :edtyDetailType"),
    @NamedQuery(name = "BtrDEventDetailType.findByDateFrom", query = "SELECT b FROM BtrDEventDetailType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDEventDetailType.findByDateTo", query = "SELECT b FROM BtrDEventDetailType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDEventDetailType.findByCrDate", query = "SELECT b FROM BtrDEventDetailType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDEventDetailType.findByModDate", query = "SELECT b FROM BtrDEventDetailType b WHERE b.modDate = :modDate")})
public class BtrDEventDetailType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDTY_ID")
    private BigDecimal edtyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EDTY_NAME")
    private String edtyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EDTY_DETAIL_TYPE")
    private String edtyDetailType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edtyId")
    private List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edtyId")
    private List<BtrEventDetail> btrEventDetailList;

    public BtrDEventDetailType() {
    }

    public BtrDEventDetailType(BigDecimal edtyId) {
        this.edtyId = edtyId;
    }

    public BtrDEventDetailType(BigDecimal edtyId, String edtyName, String edtyDetailType, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.edtyId = edtyId;
        this.edtyName = edtyName;
        this.edtyDetailType = edtyDetailType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getEdtyId() {
        return edtyId;
    }

    public void setEdtyId(BigDecimal edtyId) {
        this.edtyId = edtyId;
    }

    public String getEdtyName() {
        return edtyName;
    }

    public void setEdtyName(String edtyName) {
        this.edtyName = edtyName;
    }

    public String getEdtyDetailType() {
        return edtyDetailType;
    }

    public void setEdtyDetailType(String edtyDetailType) {
        this.edtyDetailType = edtyDetailType;
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
    public List<BtrEventTyDetailTyRel> getBtrEventTyDetailTyRelList() {
        return btrEventTyDetailTyRelList;
    }

    public void setBtrEventTyDetailTyRelList(List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList) {
        this.btrEventTyDetailTyRelList = btrEventTyDetailTyRelList;
    }

    @XmlTransient
    public List<BtrEventDetail> getBtrEventDetailList() {
        return btrEventDetailList;
    }

    public void setBtrEventDetailList(List<BtrEventDetail> btrEventDetailList) {
        this.btrEventDetailList = btrEventDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edtyId != null ? edtyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDEventDetailType)) {
            return false;
        }
        BtrDEventDetailType other = (BtrDEventDetailType) object;
        if ((this.edtyId == null && other.edtyId != null) || (this.edtyId != null && !this.edtyId.equals(other.edtyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDEventDetailType[ edtyId=" + edtyId + " ]";
    }
    
}
