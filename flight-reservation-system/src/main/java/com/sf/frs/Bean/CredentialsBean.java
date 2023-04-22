package com.sf.frs.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FRS_TBL_CREDENTIALS")
public class CredentialsBean {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int userID;
@Column
private String password;
@Column 
private String userType;
@Column
private int loginStatus;
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public int getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(int loginStatus) {
	this.loginStatus = loginStatus;
}

}
