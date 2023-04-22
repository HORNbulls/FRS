package com.sf.frs.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FRS_TBL_FLIGHT")
public class FlightBean {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int flightID;
@Column
private String flightName;
@Column
private int seatingCapacity;
@Column 
private int reservationCapacity;

public FlightBean() {
	
}
public int getFlightID() {
	return flightID;
}
public void setFlightID(int flightID) {
	this.flightID = flightID;
}
public String getFlightName() {
	return flightName;
}
public void setFlightName(String flightName) {
	this.flightName = flightName;
}
public int getSeatingCapacity() {
	return seatingCapacity;
}
public void setSeatingCapacity(int seatingCapacity) {
	this.seatingCapacity = seatingCapacity;
}
public int getReservationCapacity() {
	return reservationCapacity;
}
public void setReservationCapacity(int reservationCapacity) {
	this.reservationCapacity = reservationCapacity;
}
@Override
public String toString() {
	return "FlightBean [flightID=" + flightID + ", flightName=" + flightName + ", seatingCapacity=" + seatingCapacity
			+ ", reservationCapacity=" + reservationCapacity + "]";
}

}
