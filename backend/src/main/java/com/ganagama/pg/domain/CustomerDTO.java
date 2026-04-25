package com.ganagama.pg.domain;

import java.sql.Date;

import jakarta.persistence.Column;

public class CustomerDTO {

	private Long customerID;
	private String name;
	private String emailID;
	private String mobileNo;
	private String address;
	private String gender;	
    private String roomType;
	private Integer monthlyPkg;
	private Integer advancePayment;
	private Integer roomNo;
	private Date joiningDate;
	private Integer pgNo;
	private String addharCard;
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Integer getMonthlyPkg() {
		return monthlyPkg;
	}
	public void setMonthlyPkg(Integer monthlyPkg) {
		this.monthlyPkg = monthlyPkg;
	}
	public Integer getAdvancePayment() {
		return advancePayment;
	}
	public void setAdvancePayment(Integer advancePayment) {
		this.advancePayment = advancePayment;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Integer getPgNo() {
		return pgNo;
	}
	public void setPgNo(Integer pgNo) {
		this.pgNo = pgNo;
	}
	public String getAddharCard() {
		return addharCard;
	}
	public void setAddharCard(String addharCard) {
		this.addharCard = addharCard;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerID=" + customerID + ", name=" + name + ", emailID=" + emailID + ", mobileNo="
				+ mobileNo + ", address=" + address + ", gender=" + gender + ", roomType=" + roomType + ", monthlyPkg="
				+ monthlyPkg + ", advancePayment=" + advancePayment + ", roomNo=" + roomNo + ", joiningDate="
				+ joiningDate + ", pgNo=" + pgNo + ", addharCard=" + addharCard + "]";
	}
	
	
	
}
