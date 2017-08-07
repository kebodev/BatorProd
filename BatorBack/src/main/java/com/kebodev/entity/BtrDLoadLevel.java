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
@Table(name = "BTR_D_LOAD_LEVEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDLoadLevel.findAll", query = "SELECT b FROM BtrDLoadLevel b"),
    @NamedQuery(name = "BtrDLoadLevel.findByLoleId", query = "SELECT b FROM BtrDLoadLevel b WHERE b.loleId = :loleId"),
    @NamedQuery(name = "BtrDLoadLevel.findByLoleName", query = "SELECT b FROM BtrDLoadLevel b WHERE b.loleName = :loleName"),
    @NamedQuery(name = "BtrDLoadLevel.findByDateFrom", query = "SELECT b FROM BtrDLoadLevel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDLoadLevel.findByDateTo", query = "SELECT b FROM BtrDLoadLevel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDLoadLevel.findByCrDate", query = "SELECT b FROM BtrDLoadLevel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDLoadLevel.findByModDate", query = "SELECT b FROM BtrDLoadLevel b WHERE b.modDate = :modDate")})
public class BtrDLoadLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOLE_ID")
    private BigDecimal loleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LOLE_NAME")
    private String loleName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loleId")
    private List<BtrAccount> btrAccountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loleId")
    private List<BtrCollection> btrCollectionList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDLoadLevel() {
    }

    public BtrDLoadLevel(BigDecimal loleId) {
        this.loleId = loleId;
    }

    public BtrDLoadLevel(BigDecimal loleId, String loleName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.loleId = loleId;
        this.loleName = loleName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getLoleId() {
        return loleId;
    }

    public void setLoleId(BigDecimal loleId) {
        this.loleId = loleId;
    }

    public String getLoleName() {
        return loleName;
    }

    public void setLoleName(String loleName) {
        this.loleName = loleName;
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
    public List<BtrAccount> getBtrAccountList() {
        return btrAccountList;
    }

    public void setBtrAccountList(List<BtrAccount> btrAccountList) {
        this.btrAccountList = btrAccountList;
    }

    @XmlTransient
    public List<BtrCollection> getBtrCollectionList() {
        return btrCollectionList;
    }

    public void setBtrCollectionList(List<BtrCollection> btrCollectionList) {
        this.btrCollectionList = btrCollectionList;
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
        hash += (loleId != null ? loleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDLoadLevel)) {
            return false;
        }
        BtrDLoadLevel other = (BtrDLoadLevel) object;
        if ((this.loleId == null && other.loleId != null) || (this.loleId != null && !this.loleId.equals(other.loleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDLoadLevel[ loleId=" + loleId + " ]";
    }
    
}
