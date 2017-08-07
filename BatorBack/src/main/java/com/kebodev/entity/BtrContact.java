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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabor_dev
 */
@Entity
@Table(name = "BTR_CONTACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrContact.findAll", query = "SELECT b FROM BtrContact b"),
    @NamedQuery(name = "BtrContact.findByContId", query = "SELECT b FROM BtrContact b WHERE b.contId = :contId"),
    @NamedQuery(name = "BtrContact.findByContValue", query = "SELECT b FROM BtrContact b WHERE b.contValue = :contValue"),
    @NamedQuery(name = "BtrContact.findByDateFrom", query = "SELECT b FROM BtrContact b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrContact.findByDateTo", query = "SELECT b FROM BtrContact b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrContact.findByCrDate", query = "SELECT b FROM BtrContact b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrContact.findByModDate", query = "SELECT b FROM BtrContact b WHERE b.modDate = :modDate")})
public class BtrContact implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_ID")
    private BigDecimal contId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "CONT_VALUE")
    private String contValue;
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
    @JoinColumn(name = "COTY_ID", referencedColumnName = "COTY_ID")
    @ManyToOne(optional = false)
    private BtrDContactType cotyId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrContact() {
    }

    public BtrContact(BigDecimal contId) {
        this.contId = contId;
    }

    public BtrContact(BigDecimal contId, String contValue, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.contId = contId;
        this.contValue = contValue;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getContId() {
        return contId;
    }

    public void setContId(BigDecimal contId) {
        this.contId = contId;
    }

    public String getContValue() {
        return contValue;
    }

    public void setContValue(String contValue) {
        this.contValue = contValue;
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

    public BtrDContactType getCotyId() {
        return cotyId;
    }

    public void setCotyId(BtrDContactType cotyId) {
        this.cotyId = cotyId;
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
        hash += (contId != null ? contId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrContact)) {
            return false;
        }
        BtrContact other = (BtrContact) object;
        if ((this.contId == null && other.contId != null) || (this.contId != null && !this.contId.equals(other.contId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrContact[ contId=" + contId + " ]";
    }
    
}
