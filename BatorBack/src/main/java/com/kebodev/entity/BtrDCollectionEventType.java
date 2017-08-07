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
@Table(name = "BTR_D_COLLECTION_EVENT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDCollectionEventType.findAll", query = "SELECT b FROM BtrDCollectionEventType b"),
    @NamedQuery(name = "BtrDCollectionEventType.findByCetyId", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.cetyId = :cetyId"),
    @NamedQuery(name = "BtrDCollectionEventType.findByCetyName", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.cetyName = :cetyName"),
    @NamedQuery(name = "BtrDCollectionEventType.findByCetyDirection", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.cetyDirection = :cetyDirection"),
    @NamedQuery(name = "BtrDCollectionEventType.findByDateFrom", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDCollectionEventType.findByDateTo", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDCollectionEventType.findByCrDate", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDCollectionEventType.findByModDate", query = "SELECT b FROM BtrDCollectionEventType b WHERE b.modDate = :modDate")})
public class BtrDCollectionEventType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CETY_ID")
    private BigDecimal cetyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CETY_NAME")
    private String cetyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CETY_DIRECTION")
    private String cetyDirection;
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
    @JoinColumn(name = "CCTY_ID", referencedColumnName = "CCTY_ID")
    @ManyToOne(optional = false)
    private BtrDCollControllerType cctyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cetyId")
    private List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cetyId")
    private List<BtrCollectionEvent> btrCollectionEventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cetyId")
    private List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList;

    public BtrDCollectionEventType() {
    }

    public BtrDCollectionEventType(BigDecimal cetyId) {
        this.cetyId = cetyId;
    }

    public BtrDCollectionEventType(BigDecimal cetyId, String cetyName, String cetyDirection, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cetyId = cetyId;
        this.cetyName = cetyName;
        this.cetyDirection = cetyDirection;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCetyId() {
        return cetyId;
    }

    public void setCetyId(BigDecimal cetyId) {
        this.cetyId = cetyId;
    }

    public String getCetyName() {
        return cetyName;
    }

    public void setCetyName(String cetyName) {
        this.cetyName = cetyName;
    }

    public String getCetyDirection() {
        return cetyDirection;
    }

    public void setCetyDirection(String cetyDirection) {
        this.cetyDirection = cetyDirection;
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

    public BtrDCollControllerType getCctyId() {
        return cctyId;
    }

    public void setCctyId(BtrDCollControllerType cctyId) {
        this.cctyId = cctyId;
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

    @XmlTransient
    public List<BtrEventTyDetailTyRel> getBtrEventTyDetailTyRelList() {
        return btrEventTyDetailTyRelList;
    }

    public void setBtrEventTyDetailTyRelList(List<BtrEventTyDetailTyRel> btrEventTyDetailTyRelList) {
        this.btrEventTyDetailTyRelList = btrEventTyDetailTyRelList;
    }

    @XmlTransient
    public List<BtrCollectionEvent> getBtrCollectionEventList() {
        return btrCollectionEventList;
    }

    public void setBtrCollectionEventList(List<BtrCollectionEvent> btrCollectionEventList) {
        this.btrCollectionEventList = btrCollectionEventList;
    }

    @XmlTransient
    public List<BtrDStepTyEventTyRel> getBtrDStepTyEventTyRelList() {
        return btrDStepTyEventTyRelList;
    }

    public void setBtrDStepTyEventTyRelList(List<BtrDStepTyEventTyRel> btrDStepTyEventTyRelList) {
        this.btrDStepTyEventTyRelList = btrDStepTyEventTyRelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cetyId != null ? cetyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDCollectionEventType)) {
            return false;
        }
        BtrDCollectionEventType other = (BtrDCollectionEventType) object;
        if ((this.cetyId == null && other.cetyId != null) || (this.cetyId != null && !this.cetyId.equals(other.cetyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDCollectionEventType[ cetyId=" + cetyId + " ]";
    }
    
}
