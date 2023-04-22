package com.sf.frs.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.frs.Bean.PassengerBean;
import com.sf.frs.Bean.ReservationBean;
import com.sf.frs.Bean.RouteBean;
import com.sf.frs.Bean.ScheduleBean;
import com.sf.frs.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService cserv;
	@GetMapping("/getres/{date}")
	public List<ReservationBean> getReservationByDate(@PathVariable (value="date")Date type) {
		return cserv.getReservationByDate(type);
	}
	@GetMapping("/bysd/{source}/{destination}")
	public ArrayList<RouteBean> getRouteBySourceDestination(@PathVariable(value="source") String source, @PathVariable(value="destination") String destination){
	    return cserv.getRouteBySourceDestination(source, destination);
	}
	@GetMapping("/sdj/{source}/{destination}/{journeyDate}")
	public ArrayList<ScheduleBean> viewScheduleByRoute(@PathVariable(value="source") String source,@PathVariable(value="destination") String destination,@PathVariable(value="journeyDate") Date journeyDate){
		   return cserv.viewScheduleByRoute(source, destination, journeyDate);
	   }
@GetMapping("/rp/{id}")
public Map<ReservationBean, PassengerBean> viewTicket(@PathVariable(value="id")int reservationId){
		   return cserv.viewTicket(reservationId);
	   }

@DeleteMapping("/cancelTicket/{id}")
public boolean cancelTicket(@PathVariable (value="id")int reservationId) {
	return cserv.cancelTicket(reservationId);
}
@PostMapping("/addtc")
public String reserveTicket(@RequestBody ReservationBean reservationBean, ArrayList<PassengerBean> passengers) {
	return cserv.reserveTicket(reservationBean, passengers);
	}
//@GetMapping("/rp/{id}")
////public Map<ReservationBean, List<PassengerBean>> viewTicket(@PathVariable(value=("id")) int reservationId) {
////	   return cserv.viewTicket(reservationId);
////}


//public ReservationBean viewTicket(@PathVariable(value="id") int reservationId){
//	return cserv.viewTicket(reservationId);
//}
}


