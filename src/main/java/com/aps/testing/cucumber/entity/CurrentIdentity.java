package com.aps.testing.cucumber.entity;

import java.math.BigDecimal;
import java.util.Date;


public class CurrentIdentity {
private static final long serialVersionUID = 1L;

	private long identityId;
	private String actionFlag;
	private String activeInd;
	private Date alertDate;
	private String createdBy;
	private Date createdDate;
	private Date dateIncorporated;
	private Date dob;
	private Date dod;
	private String ein;
	private String entitySubType;
	private String entityType;
	private String firstName;
	private String gender;
	private String lastName;
	private String legalName;
	private BigDecimal medicareCount;
	private String medicareId;
	private String middleName;
	private String namePrefix;
	private String nameSuffix;
	private String npi;
	private BigDecimal npiCount;
	private String prvdrTypeCd;
	private String sourceCode;
	private String sourceId;
	private String ssn;
	private CurrIdentityAddr currIdentityAddr;
	private CurrIdentityLicense currIdentityLicense;

	public long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(long identityId) {
		this.identityId = identityId;
	}

	public String getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}

	public Date getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDateIncorporated() {
		return dateIncorporated;
	}

	public void setDateIncorporated(Date dateIncorporated) {
		this.dateIncorporated = dateIncorporated;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDod() {
		return dod;
	}

	public void setDod(Date dod) {
		this.dod = dod;
	}

	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

	public String getEntitySubType() {
		return entitySubType;
	}

	public void setEntitySubType(String entitySubType) {
		this.entitySubType = entitySubType;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public BigDecimal getMedicareCount() {
		return medicareCount;
	}

	public void setMedicareCount(BigDecimal medicareCount) {
		this.medicareCount = medicareCount;
	}

	public String getMedicareId() {
		return medicareId;
	}

	public void setMedicareId(String medicareId) {
		this.medicareId = medicareId;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public BigDecimal getNpiCount() {
		return npiCount;
	}

	public void setNpiCount(BigDecimal npiCount) {
		this.npiCount = npiCount;
	}

	public String getPrvdrTypeCd() {
		return prvdrTypeCd;
	}

	public void setPrvdrTypeCd(String prvdrTypeCd) {
		this.prvdrTypeCd = prvdrTypeCd;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getStIncorporated() {
		return stIncorporated;
	}

	public void setStIncorporated(String stIncorporated) {
		this.stIncorporated = stIncorporated;
	}

	public String getTinTypeCd() {
		return tinTypeCd;
	}

	public void setTinTypeCd(String tinTypeCd) {
		this.tinTypeCd = tinTypeCd;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CurrIdentityAddr getCurrIdentityAddr() {
		return currIdentityAddr;
	}

	public void setCurrIdentityAddr(CurrIdentityAddr currIdentityAddr) {
		this.currIdentityAddr = currIdentityAddr;
	}

	public CurrIdentityLicense getCurrIdentityLicense() {
		return currIdentityLicense;
	}

	public void setCurrIdentityLicense(CurrIdentityLicense currIdentityLicense) {
		this.currIdentityLicense = currIdentityLicense;
	}

	private String stIncorporated;

	private String tinTypeCd;

	private String updatedBy;

	private Date updatedDate;
}
