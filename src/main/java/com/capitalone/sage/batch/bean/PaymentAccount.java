package com.capitalone.sage.batch.bean;

import java.util.*;

//import org.apache.commons.lang3.builder.HashCodeBuilder;
//import org.apache.commons.lang3.builder.ToStringBuilde;
public class PaymentAccount {
	private int id;
	private String name;
	private String abaNum;
	private String bankAccountNumberTokenized;
	private UUID pmtAcctUnqId;

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

	public String getAbaNum() {
		return abaNum;
	}

	public void setAbaNum(String abaNum) {
		this.abaNum = abaNum;
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

	@Override
	public String toString() {
		return "PaymentAccount [id=" + id + ", name=" + name + ", abaNum=" + abaNum + ", bankAccountNumberTokenized="
				+ bankAccountNumberTokenized + ", pmtAcctUnqId=" + pmtAcctUnqId + "]";
	}

	

	// @Override
	// public int hashCode() {
	// return HashCodeBuilder.reflectionHashCode(this, false);
	// }
	// @Override
	// public String toString() {
	// return ToStringBuilder.reflectionToString(this);
	// }

}
