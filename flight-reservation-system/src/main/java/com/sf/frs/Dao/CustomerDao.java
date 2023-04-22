package com.sf.frs.Dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.frs.Bean.PassengerBean;
import com.sf.frs.Bean.ReservationBean;
import com.sf.frs.Bean.RouteBean;
import com.sf.frs.Bean.ScheduleBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class CustomerDao {
	@Autowired
	private AdminDao adao;
	@Autowired
	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Session session;
	private Query q;
	
	public List<ReservationBean> getReservationByDate(Date journeyDate) {
		session=sessionFactory.openSession();
		Query q=session.createQuery("from ReservationBean where journeyDate=:type");
		q.setParameter("type", journeyDate);
		return (List<ReservationBean>) q.getResultList();
	}
	
	public ArrayList<RouteBean> getRouteBySourceDestination(String source, String destination) {
		session = sessionFactory.openSession();
		Query q2 = session.createQuery("from RouteBean where source=:source AND destination=:destination");
		q2.setParameter("source", source);
		q2.setParameter("destination", destination);
		return (ArrayList<RouteBean>)q2.getResultList();
	}

	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date journeyDate){
	    ArrayList<ScheduleBean> all = new ArrayList<>();
	    session = sessionFactory.openSession();
	    
	    // Get reservations for the given date
	    ArrayList<ReservationBean> reservations = (ArrayList<ReservationBean>) getReservationByDate(journeyDate);
	    
	    // Get routes for the given source and destination
	    ArrayList<RouteBean> routes = (ArrayList<RouteBean>) getRouteBySourceDestination(source,destination);
	    
	    // For each route, find the schedules that match the route and date
	    for(RouteBean route: routes) {
	        Query query = session.createQuery("from ScheduleBean where routeBean = :route ");
	        Query q4=session.createQuery("from ReservationBean where journeyDate=:journeyDate");
	        query.setParameter("route", route);
	        q4.setParameter("journeyDate", journeyDate);
	        List<ScheduleBean> schedules = query.getResultList();
	        
	        // For each schedule, check if there are any available seats
	        for(ScheduleBean schedule: schedules) {
	            boolean available = true;
	            for(ReservationBean reservation: reservations) {
	                if(reservation.getScheduleBean().getScheduleID() == schedule.getScheduleID()) {
	                    available = false;
	                    break;
	                }
	            }
	            
	            // If there are available seats, add the schedule to the list
	            if(available) {
	                all.add(schedule);
	            }
	        }
	    }
	    
	    session.close();
	    return all;
	}



	public Map<ReservationBean, PassengerBean> viewTicket(int reservationId) {
	    ArrayList<ReservationBean> rall = adao.getReservationById(reservationId);
	    ReservationBean reservation = new ReservationBean();
	    for (ReservationBean r : rall) {
	        reservation = r;
	    }

	    ArrayList<PassengerBean> pall = adao.getPassengerById(reservationId);
	    PassengerBean passenger = new PassengerBean();
	    for (PassengerBean p : pall) {
	        passenger = p;
	    }

	    Map<ReservationBean, PassengerBean> map = new HashMap<>();
	    map.put(reservation, passenger);
	    return map;
	}

public boolean cancelTicket(int reservationId) {
	boolean isSucces=true;
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	Query q7=session.createQuery("delete from ReservationBean where reservationId=:reservation");
	q7.setParameter("reservation", reservationId);
	q7.executeUpdate();
	transaction.commit();
	session.close();
	return isSucces;
	
}

public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers) {
    Session session = null;
    Transaction transaction = null;
    try {
        if (reservationBean == null) {
            return "error: reservationBean is null";
        }
        if (passengers == null || passengers.isEmpty()) {
            return "error: passengers list is null or empty";
        }
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        session.save(reservationBean);
        ArrayList<PassengerBean> pall = adao.getPassengerById(reservationId);
	    PassengerBean passenger = new PassengerBean();
        for (PassengerBean passenger1 : pall) {
            session.save(passenger);
        }
        transaction.commit();
        return "success";
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return "error";
    } finally {
        if (session != null) {
            session.close();
        }
    }
}


	}

