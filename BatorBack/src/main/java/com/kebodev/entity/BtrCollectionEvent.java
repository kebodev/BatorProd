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
@Table(name = "BTR_COLLECTION_EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCollectionEvent.findAll", query = "SELECT b FROM BtrCollectionEvent b"),
    @NamedQuery(name = "BtrCollectionEvent.findByCoevId", query = "SELECT b FROM BtrCollectionEvent b WHERE b.coevId = :coevId"),
    @NamedQuery(name = "BtrCollectionEvent.findByCoevText", query = "SELECT b FROM BtrCollectionEvent b WHERE b.coevText = :coevText"),
    @NamedQuery(name = "BtrCollectionEvent.findByCrDate", query = "SELECT b FROM BtrCollectionEvent b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCollectionEvent.findByModDate", query = "SELECT b FROM BtrCollectionEvent b WHERE b.modDate = :modDate")})
public class BtrCollectionEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COEV_ID")
    private BigDecimal coevId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "COEV_TEXT")
    private String coevText;
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
    @JoinColumn(name = "COST_ID", referencedColumnName = "COST_ID")
    @ManyToOne(optional = false)
    private BtrCollectionStep costId;
    @JoinColumn(name = "CETY_ID", referencedColumnName = "CETY_ID")
    @ManyToOne(optional = false)
    private BtrDCollectionEventType cetyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coevId")
    private List<BtrEventDetail> btrEventDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coevId")
    private List<BtrCollectionController> btrCollectionControllerList;

    public BtrCollectionEvent() {
    }

    public BtrCollectionEvent(BigDecimal coevId) {
        this.coevId = coevId;
    }

    public BtrCollectionEvent(BigDecimal coevId, String coevText, Date crDate, Date modDate) {
        this.coevId = coevId;
        this.coevText = coevText;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCoevId() {
        return coevId;
    }

    public void setCoevId(BigDecimal coevId) {
        this.coevId = coevId;
    }

    public String getCoevText() {
        return coevText;
    }

    public void setCoevText(String coevText) {
        this.coevText = coevText;
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

    public BtrCollectionStep getCostId() {
        return costId;
    }

    public void setCostId(BtrCollectionStep costId) {
        this.costId = costId;
    }

    public BtrDCollectionEventType getCetyId() {
        return cetyId;
    }

    public void setCetyId(BtrDCollectionEventType cetyId) {
        this.cetyId = cetyId;
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
    public List<BtrEventDetail> getBtrEventDetailList() {
        return btrEventDetailList;
    }

    public void setBtrEventDetailList(List<BtrEventDetail> btrEventDetailList) {
        this.btrEventDetailList = btrEventDetailList;
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
        hash += (coevId != null ? coevId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCollectionEvent)) {
            return false;
        }
        BtrCollectionEvent other = (BtrCollectionEvent) object;
        if ((this.coevId == null && other.coevId != null) || (this.coevId != null && !this.coevId.equals(other.coevId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCollectionEvent[ coevId=" + coevId + " ]";
    }
    
}
