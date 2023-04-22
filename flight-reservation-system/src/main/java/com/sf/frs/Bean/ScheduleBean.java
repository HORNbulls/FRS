package com.sf.frs.Bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="FRS_TBL_SCHEDULE")
public class ScheduleBean {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int scheduleID;
@ManyToOne
@JoinColumn(name="flightID")
private FlightBean flightBean;
@ManyToOne
@JoinColumn(name="routeID")
private RouteBean routeBean;
@Column
private int travelDuration;
@Column
private String availableDays;
@Column
private String departureTime;
public int getScheduleID() {
	return scheduleID;
}
public void setScheduleID(int scheduleID) {
	this.scheduleID = scheduleID;
}
public FlightBean getFlightBean() {
	return flightBean;
}
public void setFlightBean(FlightBean flightBean) {
	this.flightBean = flightBean;
}
public RouteBean getRouteBean() {
	return routeBean;
}
public void setRouteBean(RouteBean routeBean) {
	this.routeBean = routeBean;
}
public int getTravelDuration() {
	return travelDuration;
}
public void setTravelDuration(int travelDuration) {
	this.travelDuration = travelDuration;
}
public String getAvailableDays() {
	return availableDays;
}
public void setAvailableDays(String availableDays) {
	this.availableDays = availableDays;
}
public String getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(String departureTime) {
	this.departureTime = departureTime;
}
@Override
public String toString() {
	return "ScheduleBean [scheduleID=" + scheduleID + ", flightBean=" + flightBean + ", routeBean=" + routeBean
			+ ", travelDuration=" + travelDuration + ", availableDays=" + availableDays + ", departureTime="
			+ departureTime + "]";
}


}
