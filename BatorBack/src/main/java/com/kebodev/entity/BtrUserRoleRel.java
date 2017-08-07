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
@Table(name = "BTR_USER_ROLE_REL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrUserRoleRel.findAll", query = "SELECT b FROM BtrUserRoleRel b"),
    @NamedQuery(name = "BtrUserRoleRel.findByUsroId", query = "SELECT b FROM BtrUserRoleRel b WHERE b.usroId = :usroId"),
    @NamedQuery(name = "BtrUserRoleRel.findByDateFrom", query = "SELECT b FROM BtrUserRoleRel b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrUserRoleRel.findByDateTo", query = "SELECT b FROM BtrUserRoleRel b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrUserRoleRel.findByCrDate", query = "SELECT b FROM BtrUserRoleRel b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrUserRoleRel.findByModDate", query = "SELECT b FROM BtrUserRoleRel b WHERE b.modDate = :modDate")})
public class BtrUserRoleRel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USRO_ID")
    private BigDecimal usroId;
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
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false)
    private BtrDRole roleId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser userId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;

    public BtrUserRoleRel() {
    }

    public BtrUserRoleRel(BigDecimal usroId) {
        this.usroId = usroId;
    }

    public BtrUserRoleRel(BigDecimal usroId, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.usroId = usroId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getUsroId() {
        return usroId;
    }

    public void setUsroId(BigDecimal usroId) {
        this.usroId = usroId;
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

    public BtrDRole getRoleId() {
        return roleId;
    }

    public void setRoleId(BtrDRole roleId) {
        this.roleId = roleId;
    }

    public BtrUser getUserId() {
        return userId;
    }

    public void setUserId(BtrUser userId) {
        this.userId = userId;
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
        hash += (usroId != null ? usroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrUserRoleRel)) {
            return false;
        }
        BtrUserRoleRel other = (BtrUserRoleRel) object;
        if ((this.usroId == null && other.usroId != null) || (this.usroId != null && !this.usroId.equals(other.usroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrUserRoleRel[ usroId=" + usroId + " ]";
    }
    
}
