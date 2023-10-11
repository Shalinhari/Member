package com.project.Member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Member")
public class Member {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@NotBlank(message="Null values are not Accepted")
private String memberName;
private long phoneNumber;

public Member() {
	
}

@Override
public String toString() {
	return "Member [id=" + id + ", memberName=" + memberName + ", phoneNumber=" + phoneNumber + "]";
}
public Member(Integer id, String memberName, long phoneNumber) {
	super();
	this.id = id;
	this.memberName = memberName;
	this.phoneNumber = phoneNumber;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

}
