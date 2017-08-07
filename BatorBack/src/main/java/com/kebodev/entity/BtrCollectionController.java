/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kebodev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_COLLECTION_CONTROLLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCollectionController.findAll", query = "SELECT b FROM BtrCollectionController b"),
    @NamedQuery(name = "BtrCollectionController.findByCocoId", query = "SELECT b FROM BtrCollectionController b WHERE b.cocoId = :cocoId"),
    @NamedQuery(name = "BtrCollectionController.findByDateFrom", query = "SELECT b FROM BtrCollectionController b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrCollectionController.findByDateTo", query = "SELECT b FROM BtrCollectionController b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrCollectionController.findByCrDate", query = "SELECT b FROM BtrCollectionController b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCollectionController.findByModDate", query = "SELECT b FROM BtrCollectionController b WHERE b.modDate = :modDate")})
public class BtrCollectionController implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COCO_ID")
    private BigDecimal cocoId;
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
    @JoinColumn(name = "COLL_ID", referencedColumnName = "COLL_ID")
    @ManyToOne(optional = false)
    private BtrCollection collId;
    @JoinColumn(name = "COEV_ID", referencedColumnName = "COEV_ID")
    @ManyToOne(optional = false)
    private BtrCollectionEvent coevId;
    @JoinColumn(name = "CCTY_ID", referencedColumnName = "CCTY_ID")
    @ManyToOne(optional = false)
    private BtrDCollControllerType cctyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrCollectionController() {
    }

    public BtrCollectionController(BigDecimal cocoId) {
        this.cocoId = cocoId;
    }

    public BtrCollectionController(BigDecimal cocoId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.cocoId = cocoId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCocoId() {
        return cocoId;
    }

    public void setCocoId(BigDecimal cocoId) {
        this.cocoId = cocoId;
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

    public BtrCollection getCollId() {
        return collId;
    }

    public void setCollId(BtrCollection collId) {
        this.collId = collId;
    }

    public BtrCollectionEvent getCoevId() {
        return coevId;
    }

    public void setCoevId(BtrCollectionEvent coevId) {
        this.coevId = coevId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cocoId != null ? cocoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCollectionController)) {
            return false;
        }
        BtrCollectionController other = (BtrCollectionController) object;
        if ((this.cocoId == null && other.cocoId != null) || (this.cocoId != null && !this.cocoId.equals(other.cocoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCollectionController[ cocoId=" + cocoId + " ]";
    }
    
}
