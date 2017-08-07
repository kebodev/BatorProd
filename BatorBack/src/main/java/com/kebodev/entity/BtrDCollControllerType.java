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
@Table(name = "BTR_D_COLL_CONTROLLER_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDCollControllerType.findAll", query = "SELECT b FROM BtrDCollControllerType b"),
    @NamedQuery(name = "BtrDCollControllerType.findByCctyId", query = "SELECT b FROM BtrDCollControllerType b WHERE b.cctyId = :cctyId"),
    @NamedQuery(name = "BtrDCollControllerType.findByCctyName", query = "SELECT b FROM BtrDCollControllerType b WHERE b.cctyName = :cctyName"),
    @NamedQuery(name = "BtrDCollControllerType.findByDateFrom", query = "SELECT b FROM BtrDCollControllerType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDCollControllerType.findByDateTo", query = "SELECT b FROM BtrDCollControllerType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDCollControllerType.findByCrDate", query = "SELECT b FROM BtrDCollControllerType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDCollControllerType.findByModDate", query = "SELECT b FROM BtrDCollControllerType b WHERE b.modDate = :modDate")})
public class BtrDCollControllerType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCTY_ID")
    private BigDecimal cctyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CCTY_NAME")
    private String cctyName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cctyId")
    private List<BtrDCollectionEventType> btrDCollectionEventTypeList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cctyId")
    private List<BtrCollectionController> btrCollectionControllerList;

    public BtrDCollControllerType() {
    }

    public BtrDCollControllerType(BigDecimal cctyId) {
        this.cctyId = cctyId;
    }

    public BtrDCollControllerType(BigDecimal cctyId, String cctyName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cctyId = cctyId;
        this.cctyName = cctyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCctyId() {
        return cctyId;
    }

    public void setCctyId(BigDecimal cctyId) {
        this.cctyId = cctyId;
    }

    public String getCctyName() {
        return cctyName;
    }

    public void setCctyName(String cctyName) {
        this.cctyName = cctyName;
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
    public List<BtrDCollectionEventType> getBtrDCollectionEventTypeList() {
        return btrDCollectionEventTypeList;
    }

    public void setBtrDCollectionEventTypeList(List<BtrDCollectionEventType> btrDCollectionEventTypeList) {
        this.btrDCollectionEventTypeList = btrDCollectionEventTypeList;
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
    public List<BtrCollectionController> getBtrCollectionControllerList() {
        return btrCollectionControllerList;
    }

    public void setBtrCollectionControllerList(List<BtrCollectionController> btrCollectionControllerList) {
        this.btrCollectionControllerList = btrCollectionControllerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cctyId != null ? cctyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDCollControllerType)) {
            return false;
        }
        BtrDCollControllerType other = (BtrDCollControllerType) object;
        if ((this.cctyId == null && other.cctyId != null) || (this.cctyId != null && !this.cctyId.equals(other.cctyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDCollControllerType[ cctyId=" + cctyId + " ]";
    }
    
}
