package com.kebodev.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BTR_CUSTOMER database table.
 * 
 */
@Entity
@Table(name="BTR_CUSTOMER")
@NamedQuery(name="BtrCustomer.findAll", query="SELECT b FROM BtrCustomer b")
public class BtrCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BTR_CUSTOMER_CUSTID_GENERATOR", sequenceName="CUST_CUST_ID_SEQ", allocationSize=1)
	@GeneratedValue( generator="BTR_CUSTOMER_CUSTID_GENERATOR")
	@Column(name="CUST_ID", unique=true)
	private long custId;

	@Temporal(TemporalType.DATE)
	@Column(name="CR_DATE", nullable=false)
	private Date crDate;

	@Column(name="CR_USER_ID", nullable=false)
	private BigDecimal crUserId;

	@Column(name="CUST_COMP_REGID", length=100)
	private String custCompRegid;

	@Column(name="CUST_COMP_TAX_NUMBER", length=50)
	private String custCompTaxNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="CUST_DATE_OF_BIRTH")
	private Date custDateOfBirth;

	@Column(name="CUST_FAMILY_NAME", nullable=false, length=100)
	private String custFamilyName;

	@Column(name="CUST_GIVEN_NAME", length=500)
	private String custGivenName;

	@Column(name="CUST_MOTHER_NAME", length=500)
	private String custMotherName;

	@Column(name="CUST_PLACE_OF_BIRTH", length=100)
	private String custPlaceOfBirth;

	@Column(nullable=false, length=100)
	private String customerno;

	@Column(name="CUTY_ID", nullable=false)
	private BigDecimal cutyId;

	@Temporal(TemporalType.DATE)
	@Column(name="MOD_DATE", nullable=false)
	private Date modDate;

	@Column(name="MOD_USER_ID", nullable=false)
	private BigDecimal modUserId;

	@Column(name="MT_ID", unique=true, nullable=false)
	private BigDecimal mtId;

	//bi-directional many-to-one association to BtrAccount
	@OneToMany(mappedBy="btrCustomer")
	private List<BtrAccount> btrAccounts;

	public BtrCustomer() {
	}

	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
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

	public String getCustCompRegid() {
		return this.custCompRegid;
	}

	public void setCustCompRegid(String custCompRegid) {
		this.custCompRegid = custCompRegid;
	}

	public String getCustCompTaxNumber() {
		return this.custCompTaxNumber;
	}

	public void setCustCompTaxNumber(String custCompTaxNumber) {
		this.custCompTaxNumber = custCompTaxNumber;
	}

	public Date getCustDateOfBirth() {
		return this.custDateOfBirth;
	}

	public void setCustDateOfBirth(Date custDateOfBirth) {
		this.custDateOfBirth = custDateOfBirth;
	}

	public String getCustFamilyName() {
		return this.custFamilyName;
	}

	public void setCustFamilyName(String custFamilyName) {
		this.custFamilyName = custFamilyName;
	}

	public String getCustGivenName() {
		return this.custGivenName;
	}

	public void setCustGivenName(String custGivenName) {
		this.custGivenName = custGivenName;
	}

	public String getCustMotherName() {
		return this.custMotherName;
	}

	public void setCustMotherName(String custMotherName) {
		this.custMotherName = custMotherName;
	}

	public String getCustPlaceOfBirth() {
		return this.custPlaceOfBirth;
	}

	public void setCustPlaceOfBirth(String custPlaceOfBirth) {
		this.custPlaceOfBirth = custPlaceOfBirth;
	}

	public String getCustomerno() {
		return this.customerno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	public BigDecimal getCutyId() {
		return this.cutyId;
	}

	public void setCutyId(BigDecimal cutyId) {
		this.cutyId = cutyId;
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

	public BigDecimal getMtId() {
		return this.mtId;
	}

	public void setMtId(BigDecimal mtId) {
		this.mtId = mtId;
	}

	public List<BtrAccount> getBtrAccounts() {
		return this.btrAccounts;
	}

	public void setBtrAccounts(List<BtrAccount> btrAccounts) {
		this.btrAccounts = btrAccounts;
	}

	public BtrAccount addBtrAccount(BtrAccount btrAccount) {
		getBtrAccounts().add(btrAccount);
		btrAccount.setBtrCustomer(this);

		return btrAccount;
	}

	public BtrAccount removeBtrAccount(BtrAccount btrAccount) {
		getBtrAccounts().remove(btrAccount);
		btrAccount.setBtrCustomer(null);

		return btrAccount;
	}

}