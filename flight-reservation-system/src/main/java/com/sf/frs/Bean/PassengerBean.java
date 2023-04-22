package com.sf.frs.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="FRS_TBL_PASSENGER")
public class PassengerBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int passengerId;
	@ManyToOne
	@JoinColumn(name="reservationId")
	private ReservationBean reservationBean;
	@Column 
	private String name;
	@Column
	private String gender;
	@Column 
	private int age;
	@Column
	private int seatNo;
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public ReservationBean getReservationBean() {
		return reservationBean;
	}
	public void setReservationBean(ReservationBean reservationBean) {
		this.reservationBean = reservationBean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public String toString() {
		return "PassengerBean [passengerId=" + passengerId + ", reservationBean=" + reservationBean + ", name=" + name
				+ ", gender=" + gender + ", age=" + age + ", seatNo=" + seatNo + "]";
	}
	

}
