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
import javax.persistence.OneToOne;
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
@Table(name = "BTR_CUSTOMER_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrCustomerRel.findAll", query = "SELECT b FROM BtrCustomerRel b"),
    @NamedQuery(name = "BtrCustomerRel.findByCureId", query = "SELECT b FROM BtrCustomerRel b WHERE b.cureId = :cureId"),
    @NamedQuery(name = "BtrCustomerRel.findByCrDate", query = "SELECT b FROM BtrCustomerRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrCustomerRel.findByModDate", query = "SELECT b FROM BtrCustomerRel b WHERE b.modDate = :modDate")})
public class BtrCustomerRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURE_ID")
    private BigDecimal cureId;
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
    @JoinColumn(name = "CUST_ID_CHILD", referencedColumnName = "CUST_ID")
    @OneToOne(optional = false)
    private BtrCustomer custIdChild;
    @JoinColumn(name = "CUST_ID_MOTHER", referencedColumnName = "CUST_ID")
    @ManyToOne(optional = false)
    private BtrCustomer custIdMother;
    @JoinColumn(name = "CRTY_ID", referencedColumnName = "CRTY_ID")
    @ManyToOne(optional = false)
    private BtrDCusRelType crtyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrCustomerRel() {
    }

    public BtrCustomerRel(BigDecimal cureId) {
        this.cureId = cureId;
    }

    public BtrCustomerRel(BigDecimal cureId, Date crDate, Date modDate) {
        this.cureId = cureId;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getCureId() {
        return cureId;
    }

    public void setCureId(BigDecimal cureId) {
        this.cureId = cureId;
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

    public BtrCustomer getCustIdChild() {
        return custIdChild;
    }

    public void setCustIdChild(BtrCustomer custIdChild) {
        this.custIdChild = custIdChild;
    }

    public BtrCustomer getCustIdMother() {
        return custIdMother;
    }

    public void setCustIdMother(BtrCustomer custIdMother) {
        this.custIdMother = custIdMother;
    }

    public BtrDCusRelType getCrtyId() {
        return crtyId;
    }

    public void setCrtyId(BtrDCusRelType crtyId) {
        this.crtyId = crtyId;
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
        hash += (cureId != null ? cureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrCustomerRel)) {
            return false;
        }
        BtrCustomerRel other = (BtrCustomerRel) object;
        if ((this.cureId == null && other.cureId != null) || (this.cureId != null && !this.cureId.equals(other.cureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrCustomerRel[ cureId=" + cureId + " ]";
    }
    
}
