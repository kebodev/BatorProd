package com.kebodev.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the BTR_ACCOUNT database table.
 * 
 */
@Entity
@Table(name="BTR_ACCOUNT")
@NamedQuery(name="BtrAccount.findAll", query="SELECT b FROM BtrAccount b")
public class BtrAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BTR_ACCOUNT_ACCOID_GENERATOR", sequenceName="ACCO_ACCO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BTR_ACCOUNT_ACCOID_GENERATOR")
	@Column(name="ACCO_ID", unique=true, nullable=false)
	private long accoId;

	@Column(name="ACCO_ACTUAL_DEBT", nullable=false)
	private BigDecimal accoActualDebt;

	@Column(name="ACCO_ACTUAL_DEBT_HW", nullable=false)
	private BigDecimal accoActualDebtHw;

	@Column(name="ACCO_ACTUAL_DEBT_TELCO", nullable=false)
	private BigDecimal accoActualDebtTelco;

	@Column(name="ACCO_NUMBER", nullable=false)
	private BigDecimal accoNumber;

	@Column(name="BOOL_ID_IS_ACTIVE", nullable=false)
	private BigDecimal boolIdIsActive;

	@Temporal(TemporalType.DATE)
	@Column(name="CR_DATE", nullable=false)
	private Date crDate;

	@Column(name="CR_USER_ID", nullable=false)
	private BigDecimal crUserId;

	@Column(name="LOLE_ID", nullable=false)
	private BigDecimal loleId;

	@Temporal(TemporalType.DATE)
	@Column(name="MOD_DATE", nullable=false)
	private Date modDate;

	@Column(name="MOD_USER_ID", nullable=false)
	private BigDecimal modUserId;

	@Column(name="SYST_ID", nullable=false)
	private BigDecimal systId;

	//bi-directional many-to-one association to BtrCustomer
	@ManyToOne
	@JoinColumn(name="CUST_ID", nullable=false)
	private BtrCustomer btrCustomer;

	public BtrAccount() {
	}

	public long getAccoId() {
		return this.accoId;
	}

	public void setAccoId(long accoId) {
		this.accoId = accoId;
	}

	public BigDecimal getAccoActualDebt() {
		return this.accoActualDebt;
	}

	public void setAccoActualDebt(BigDecimal accoActualDebt) {
		this.accoActualDebt = accoActualDebt;
	}

	public BigDecimal getAccoActualDebtHw() {
		return this.accoActualDebtHw;
	}

	public void setAccoActualDebtHw(BigDecimal accoActualDebtHw) {
		this.accoActualDebtHw = accoActualDebtHw;
	}

	public BigDecimal getAccoActualDebtTelco() {
		return this.accoActualDebtTelco;
	}

	public void setAccoActualDebtTelco(BigDecimal accoActualDebtTelco) {
		this.accoActualDebtTelco = accoActualDebtTelco;
	}

	public BigDecimal getAccoNumber() {
		return this.accoNumber;
	}

	public void setAccoNumber(BigDecimal accoNumber) {
		this.accoNumber = accoNumber;
	}

	public BigDecimal getBoolIdIsActive() {
		return this.boolIdIsActive;
	}

	public void setBoolIdIsActive(BigDecimal boolIdIsActive) {
		this.boolIdIsActive = boolIdIsActive;
	}

	public Date getCrDate() {
		return this.crDate;
	}

	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

	public BigDecimal getCrUserId() {
		return this.crUserId;
	}

	public void setCrUserId(BigDecimal crUserId) {
		this.crUserId = crUserId;
	}

	public BigDecimal getLoleId() {
		return this.loleId;
	}

	public void setLoleId(BigDecimal loleId) {
		this.loleId = loleId;
	}

	public Date getModDate() {
		return this.modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public BigDecimal getModUserId() {
		return this.modUserId;
	}

	public void setModUserId(BigDecimal modUserId) {
		this.modUserId = modUserId;
	}

	public BigDecimal getSystId() {
		return this.systId;
	}

	public void setSystId(BigDecimal systId) {
		this.systId = systId;
	}

	public BtrCustomer getBtrCustomer() {
		return this.btrCustomer;
	}

	public void setBtrCustomer(BtrCustomer btrCustomer) {
		this.btrCustomer = btrCustomer;
	}

}