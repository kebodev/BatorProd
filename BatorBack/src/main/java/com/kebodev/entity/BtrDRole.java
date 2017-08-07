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
@Table(name = "BTR_D_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BtrDRole.findAll", query = "SELECT b FROM BtrDRole b"),
    @NamedQuery(name = "BtrDRole.findByRoleId", query = "SELECT b FROM BtrDRole b WHERE b.roleId = :roleId"),
    @NamedQuery(name = "BtrDRole.findByRoleName", query = "SELECT b FROM BtrDRole b WHERE b.roleName = :roleName"),
    @NamedQuery(name = "BtrDRole.findByDateFrom", query = "SELECT b FROM BtrDRole b WHERE b.dateFrom = :dateFrom"),
    @NamedQuery(name = "BtrDRole.findByDateTo", query = "SELECT b FROM BtrDRole b WHERE b.dateTo = :dateTo"),
    @NamedQuery(name = "BtrDRole.findByCrDate", query = "SELECT b FROM BtrDRole b WHERE b.crDate = :crDate"),
    @NamedQuery(name = "BtrDRole.findByModDate", query = "SELECT b FROM BtrDRole b WHERE b.modDate = :modDate")})
public class BtrDRole implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private BigDecimal roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ROLE_NAME")
    private String roleName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<BtrUserRoleRel> btrUserRoleRelList;
    @JoinColumn(name = "CR_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser crUserId;
    @JoinColumn(name = "MOD_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private BtrUser modUserId;

    public BtrDRole() {
    }

    public BtrDRole(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public BtrDRole(BigDecimal roleId, String roleName, Date dateFrom, Date dateTo, Date crDate, Date modDate) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.crDate = crDate;
        this.modDate = modDate;
    }

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public List<BtrUserRoleRel> getBtrUserRoleRelList() {
        return btrUserRoleRelList;
    }

    public void setBtrUserRoleRelList(List<BtrUserRoleRel> btrUserRoleRelList) {
        this.btrUserRoleRelList = btrUserRoleRelList;
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
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BtrDRole)) {
            return false;
        }
        BtrDRole other = (BtrDRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebodev.entity.BtrDRole[ roleId=" + roleId + " ]";
    }
    
}
