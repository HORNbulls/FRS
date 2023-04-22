package com.sf.frs.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.Bean.PassengerBean;
import com.sf.frs.Bean.ReservationBean;
import com.sf.frs.Bean.RouteBean;
import com.sf.frs.Bean.ScheduleBean;
import com.sf.frs.Dao.CustomerDao;

@Service
public class CustomerService {
   @Autowired
   private CustomerDao cdao;
   
   public List<ReservationBean> getReservationByDate(Date type) {
		return cdao.getReservationByDate(type);
	}
   
   public ArrayList<RouteBean> getRouteBySourceDestination(String source, String destination){
	   return cdao.getRouteBySourceDestination(source, destination);
   }
   
   public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date journeyDate){
	   return cdao.viewScheduleByRoute(source, destination, journeyDate);
   }
	public Map<ReservationBean, PassengerBean> viewTicket(int reservationId) {
	   return cdao.viewTicket(reservationId);
   }
	
	public boolean cancelTicket(int reservationId) {
		return cdao.cancelTicket(reservationId);
	}
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers) {
	return cdao.reserveTicket(reservationBean, passengers);
	}
//   public Map<ReservationBean, List<PassengerBean>> viewTicket(String reservationId){
//	   return cdao.viewTicket(reservationId);
//   }
//	public ReservationBean viewTicket(int reservationId){
//		return cdao.viewTicket(reservationId);
//	}

}
