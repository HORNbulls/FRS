package com.sf.frs.Bean;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="FRS_TBL_RESERVATION")
public class ReservationBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reservationId;
	@ManyToOne
	@JoinColumn(name="userId")
	private CredentialsBean credentialsBean;
	@ManyToOne
	@JoinColumn(name="scheduleId")
	private ScheduleBean scheduleBean;
	@Column
	private String reservationType;
	@Column
	private String bookingDate;
	@Column
	private Date journeyDate;
	@Column 
	private int noOfSeats;
	@Column 
	private int totalFare;
	@Column 
	private int bookingStatus;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}
	public ScheduleBean getScheduleBean() {
		return scheduleBean;
	}
	public void setScheduleBean(ScheduleBean scheduleBean) {
		this.scheduleBean = scheduleBean;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	public int getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "ReservationBean [reservationId=" + reservationId + ", credentialsBean=" + credentialsBean
				+ ", scheduleBean=" + scheduleBean + ", reservationType=" + reservationType + ", bookingDate="
				+ bookingDate + ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats + ", totalFare=" + totalFare
				+ ", bookingStatus=" + bookingStatus + "]";
	}
	

}
