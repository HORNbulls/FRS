package com.sf.frs.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.Bean.FlightBean;
import com.sf.frs.Bean.PassengerBean;
import com.sf.frs.Bean.ReservationBean;
import com.sf.frs.Bean.RouteBean;
import com.sf.frs.Bean.ScheduleBean;
import com.sf.frs.Dao.AdminDao;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
@Autowired
private AdminDao adao;

public String addFlight(FlightBean flightBean) {
	return adao.addFlight(flightBean);
}
public List<FlightBean> viewFlights(){
	return adao.viewFlights();
}
public boolean modifyFlight(FlightBean flightBean) {
	return adao.modifyFlight(flightBean);
}

public String deleteFlight(int flightId)
{
	return adao.deleteFlight(flightId);
}
public String addSchedule(ScheduleBean scheduleBean) {
	return adao.addSchedule(scheduleBean);
}
public ArrayList<ScheduleBean>viewByAllSchedule(){
	return adao.viewByAllSchedule();
}
public boolean modifySchedule(ScheduleBean scheduleBean) {
	return adao.modifySchedule(scheduleBean);
}
public String deleteSchedule(int scheduleId)
{
	return adao.deleteSchedule(scheduleId);
}
public String addRoute(RouteBean routeBean) {
	return adao.addRoute(routeBean);
}
public ArrayList<RouteBean> viewAllRoute(){
	return adao.viewByAllRoutes();
}
public boolean modifyRoute(RouteBean routeBean) {
	return adao.modifyRoute(routeBean);
}
public String removeRoute(int routeId) {
	return adao.removeRoute(routeId);
}
public FlightBean viewByFlightId(String flightId) {
	return adao.viewByFlightId(flightId);
}
public RouteBean viewByRouteId(String routeId) {
	return adao.viewByRouteId(routeId);
}
public ScheduleBean viewByScheduleId(int scheduleId) {
	return adao.viewByScheduleId(scheduleId);
}
public ArrayList<PassengerBean> viewPassengersByFlight(int scheduleId){
	return adao.viewPassengersByFlight(scheduleId);
}
public ArrayList<ReservationBean> getReservationById(int reservid) {
	return adao.getReservationById(reservid);
}
public ArrayList<PassengerBean> getPassengerById(int reservationId){
	return adao.getPassengerById(reservationId);
}


}
