package com.sf.frs.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FRS_TBL_ROUTE")
public class RouteBean {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int routeID;
@Column
private String source;
@Column 
private String destination;
@Column 
private int distance;
@Column 
private double fare;
public int getRouteID() {
	return routeID;
}
public void setRouteID(int routeID) {
	this.routeID = routeID;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public int getDistance() {
	return distance;
}
public void setDistance(int distance) {
	this.distance = distance;
}
public double getFare() {
	return fare;
}
public void setFare(double fare) {
	this.fare = fare;
}
@Override
public String toString() {
	return "RouteBean [routeID=" + routeID + ", source=" + source + ", destination=" + destination + ", distance="
			+ distance + ", fare=" + fare + "]";
}

}
