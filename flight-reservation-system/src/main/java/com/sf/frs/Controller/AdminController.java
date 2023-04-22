package com.sf.frs.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.frs.Bean.FlightBean;
import com.sf.frs.Bean.PassengerBean;
import com.sf.frs.Bean.ReservationBean;
import com.sf.frs.Bean.RouteBean;
import com.sf.frs.Bean.ScheduleBean;
import com.sf.frs.Service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	@Autowired
	private AdminService adserv;
	@PostMapping("/addFlight")
	public String addFlight(@RequestBody FlightBean flightBean) {
		System.out.println(flightBean);
		return adserv.addFlight(flightBean);
	}
	@GetMapping("/getFlights")
	public List<FlightBean> viewFlights(){
		return adserv.viewFlights();
	}
	@PutMapping("/updateFlight")
	public boolean modifyFlight(@RequestBody FlightBean flightBean) {
		return adserv.modifyFlight(flightBean);
	}
	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable(value="id") int flightId)
	{
		return adserv.deleteFlight(flightId)+" record deleted successfully";
	}
	@PostMapping("/addSchedule")
	public String addSchedule(@RequestBody ScheduleBean scheduleBean) {
		return adserv.addSchedule(scheduleBean);
	}
	@GetMapping("/viewSchedule")
	public ArrayList<ScheduleBean>viewByAllSchedule(){
		return adserv.viewByAllSchedule();
	}
	@PutMapping("/updateSchedule")
	public boolean modifySchedule(@RequestBody ScheduleBean scheduleBean) {
		return adserv.modifySchedule(scheduleBean);
	}
	@DeleteMapping("/deleteSchedule/{Id}")
	public String deleteSchedule(@PathVariable (value="Id")int scheduleId)
	{
		return adserv.deleteSchedule(scheduleId);
	}
	@PostMapping("/addRoute")
	public String addRoute(@RequestBody RouteBean routeBean) {
		return adserv.addRoute(routeBean);
	}
	@GetMapping("/getRoute")
	public ArrayList<RouteBean> viewAllRoute(){
		return adserv.viewAllRoute();
	}
	@PutMapping("/updateRoute")
	public boolean modifyRoute(@RequestBody RouteBean routeBean) {
		return adserv.modifyRoute(routeBean);
	}
	@DeleteMapping("/deleteRoute/{Id}")
	public String removeRoute(@PathVariable (value="Id")int routeId) {
		return adserv.removeRoute(routeId);
	}
	@GetMapping("/ViewFlightById/{Id}")
	public FlightBean viewByFlightId(@PathVariable (value="Id")String flightId) {
		return adserv.viewByFlightId(flightId);
	}
	@GetMapping("/viewByRouteId/{Id}")
	public RouteBean viewByRouteId(@PathVariable (value="Id")String routeId) {
		return adserv.viewByRouteId(routeId);
	}@GetMapping("/viewByScheduleId/{Id}")
	public ScheduleBean viewByScheduleId(@PathVariable (value="Id")int scheduleId) {
		return adserv.viewByScheduleId(scheduleId);
	}
	@GetMapping("/sche/{Id}")
	public ArrayList<PassengerBean> viewPassengersByFlight(@PathVariable (value="Id") int scheduleId){
		System.out.println("Under controller "+scheduleId);
		return adserv.viewPassengersByFlight(scheduleId);
	}
	@GetMapping("/getRes/{id}")
	public ArrayList<ReservationBean> getReservationById(@PathVariable (value="id")int reservid) {
	    return adserv.getReservationById(reservid);
	}

	@GetMapping("/getpass/{Id}")
	public ArrayList<PassengerBean> getPassengerById(@PathVariable (value="Id")int reservationId){
		System.out.println("Under controller "+reservationId);
		return adserv.getPassengerById(reservationId);
	}
    }

