package com.ganagama.pg.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerID;
	@Column(name = "name", length=20)
	private String name;
	@Column(name = "email_id", length=20)
	private String emailID;
	@Column(name = "mobile_no", length=12)
	private String mobileNo;
	@Column(name = "address", length=30)
	private String address;
	@Column(name = "gender", length = 8)
	private String gender;
	@Column(name = "room_type", length = 15)
	private String roomType;
	@Column(name = "monthly_pkg", length=10)
	private Integer monthlyPkg;
	@Column(name = "advance_payment", length=10)
	private Integer advancePayment;
	@Column(name = "room_no", length=10)
	private Integer roomNo;
	
	 @Column(name = "joining_date") 
	 private Date joiningDate;
	 
	@Column(name = "pg_no", length=10)
	private Integer pgNo;
	@Column(name = "adharcard", length=20)
	private String addharCard;


}
