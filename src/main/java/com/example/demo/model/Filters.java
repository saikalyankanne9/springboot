package com.example.demo.model;

public class Filters {

	private String matchRegion;
	public String getMatchRegion() {
		return matchRegion;
	}
	public void setMatchRegion(String matchRegion) {
		this.matchRegion = matchRegion;
	}
	public String getIncomeLevel() {
		return incomeLevel;
	}
	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}
	public String getLendingType() {
		return lendingType;
	}
	public void setLendingType(String lendingType) {
		this.lendingType = lendingType;
	}
	private String incomeLevel;
	private String lendingType;
}
