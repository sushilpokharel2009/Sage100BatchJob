package com.capitalone.sage.batch.bean;

import java.util.UUID;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class ReconDTO {
	private int id;
	private String name;
	private String abaNumber;
	private String bankAccountNumberTokenized;
	private UUID pmtAcctUnqId;
	private String bankAccountNumber;
	// private ReasonCodes reasonCodes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbaNumber() {
		return abaNumber;
	}

	public void setAbaNumber(String abaNumber) {
		this.abaNumber = abaNumber;
	}

	public String getBankAccountNumberTokenized() {
		return bankAccountNumberTokenized;
	}

	public void setBankAccountNumberTokenized(String bankAccountNumberTokenized) {
		this.bankAccountNumberTokenized = bankAccountNumberTokenized;
	}

	public UUID getPmtAcctUnqId() {
		return pmtAcctUnqId;
	}

	public void setPmtAcctUnqId(UUID pmtAcctUnqId) {
		this.pmtAcctUnqId = pmtAcctUnqId;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@Override
	public String toString() {
		return "ReconDTO [id=" + id + ", name=" + name + ", abaNumber=" + abaNumber + ", bankAccountNumberTokenized="
				+ bankAccountNumberTokenized + ", pmtAcctUnqId=" + pmtAcctUnqId + ", bankAccountNumber="
				+ bankAccountNumber + "]";
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}
	// @Override
	// public String toString() {
	// return ToStringBuilder.reflectionToString(this);
	// }

}
