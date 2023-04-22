package com.sf.frs.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.frs.Bean.FlightBean;
import com.sf.frs.Bean.PassengerBean;
import com.sf.frs.Bean.ReservationBean;
import com.sf.frs.Bean.RouteBean;
import com.sf.frs.Bean.ScheduleBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query q;
	

	public String addFlight(FlightBean flightBean) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(flightBean);
		transaction.commit();
		session.close();
		return "success";
		
	} 
	public List<FlightBean> viewFlights(){
		session=session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		 q=session.createQuery("from FlightBean");
		return (ArrayList<FlightBean>) q.list();
		
	}
	public boolean modifyFlight(FlightBean flightBean) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(flightBean);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        e.printStackTrace();
	    }
	    return isSuccess;
	}
	public String deleteFlight(int flightID){
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q=session.createQuery("delete from FlightBean where flightID=:flightID");
		q.setParameter("flightID",flightID);
		q.executeUpdate();
        transaction.commit();
        return "SUCCESS";
	}

public String addSchedule(ScheduleBean scheduleBean) {
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	session.save(scheduleBean);
	transaction.commit();
	session.close();
	return "success";
}
public ArrayList<ScheduleBean>viewByAllSchedule(){
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	q=session.createQuery("from ScheduleBean");
	return (ArrayList<ScheduleBean>) q.list();
}
public boolean modifySchedule(ScheduleBean scheduleBean) {
    boolean isSuccess = true;
    try {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(scheduleBean);
        transaction.commit();
        session.close();
    } catch (Exception e) {
        isSuccess = false;
        e.printStackTrace();
    }
    return isSuccess;
}
public String deleteSchedule(int scheduleID){
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	Query q=session.createQuery("delete from ScheduleBean where scheduleID=:scheduleID");
	q.setParameter("scheduleID",scheduleID);
	q.executeUpdate();
    transaction.commit();
    return "SUCCESS";
}
public String addRoute(RouteBean routeBean) {
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	session.save(routeBean);
	transaction.commit();
	session.close();
	return "success";
}
public ArrayList<RouteBean>viewByAllRoutes(){
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	Query q=session.createQuery("from RouteBean");
//	session.close();
	return (ArrayList<RouteBean>) q.list();
}
public boolean modifyRoute(RouteBean routeBean) {
    boolean isSuccess = true;
    try {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(routeBean);
        transaction.commit();
        session.close();
    } catch (Exception e) {
        isSuccess = false;
        e.printStackTrace();
    }
    return isSuccess;
}
public String removeRoute(int routeId) {
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	Query q=session.createQuery("delete from RouteBean where routeID=:routeID");
	q.setParameter("routeID", routeId);
	q.executeUpdate();
	transaction.commit();
	return "success";
}
//public FlightBean viewByFlightId(String flightId) {
//	FlightBean flightBean=new FlightBean();
//	session=sessionFactory.openSession();
//	transaction=session.beginTransaction();
//	Query q=session.createQuery("from FlightBean where flightID=:flightID");
//			q.setParameter("flightID", flightId);
//	q.executeUpdate();
//	transaction.commit();
//return flightBean;
//	
//}
public FlightBean viewByFlightId(String flightId) {
    FlightBean flightBean = null; // initialize to null instead of creating a new object
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    Query q = session.createQuery("from FlightBean where flightID=:flightID");
    q.setParameter("flightID", flightId);
    flightBean = (FlightBean) q.uniqueResult(); // retrieve the result of the query
    transaction.commit();
    session.close(); // close the session after committing the transaction
    return flightBean;
}
public RouteBean viewByRouteId(String routeId) {
	RouteBean routeBean = null; // initialize to null instead of creating a new object
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    Query q = session.createQuery("from RouteBean where routeID=:routeID");
    q.setParameter("routeID", routeId);
    routeBean = (RouteBean) q.uniqueResult(); // retrieve the result of the query
    transaction.commit();
    session.close(); // close the session after committing the transaction
    return routeBean;
}
public ScheduleBean viewByScheduleId(int scheduleId) {
	ScheduleBean scheduleBean=null;
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	Query q=session.createQuery("from ScheduleBean where scheduleID=:sid");
	q.setParameter("sid", scheduleId);
//	q.executeUpdate();
	scheduleBean=(ScheduleBean)q.uniqueResult();
	transaction.commit();
	session.close();
	return scheduleBean;
}

public ArrayList<ReservationBean> getReservationById(int schid) {
    session = sessionFactory.openSession();
    Query<ReservationBean> q3 = session.createQuery("from ReservationBean where scheduleBean.scheduleID=:rid");
    q3.setParameter("rid", schid);
    System.out.println(schid);
    ArrayList<ReservationBean> reservationList = (ArrayList<ReservationBean>) q3.list();
    session.close();
    return reservationList;
}



public ArrayList<PassengerBean> viewPassengersByFlight(int scheduleId) {
	System.out.println("Under dao "+scheduleId);
    ArrayList<PassengerBean> all = new ArrayList<PassengerBean>();
    Session session = sessionFactory.openSession();
//    ScheduleBean sb = viewByScheduleId(scheduleId);
//    System.out.println(sb);
//    ArrayList<ReservationBean> rb = getReservationById(scheduleId);
//    System.out.println(rb);
//    for (ReservationBean reservation : rb) {
//        if (reservation.getScheduleBean().getScheduleID() == sb.getScheduleID()) {
//            all.addAll(getPassengerById(reservation.getReservationId()));
//        }
//    }
    Query q7=session.createQuery("from ScheduleBean sb inner Join ReservationBean rb where sb.scheduleID=:sid");
    q7.setParameter("sid", scheduleId);
    
    System.out.println(q7.list());
    ArrayList<PassengerBean> all1=(ArrayList<PassengerBean>) q7.list();
    session.close();
    return all1;
}
public ArrayList<PassengerBean> getPassengerById(int reservationId){
	session=sessionFactory.openSession();
	Query<PassengerBean> q9=session.createQuery("from PassengerBean where reservationBean.reservationId=:reid");
	q9.setParameter("reid", reservationId);
	ArrayList<PassengerBean> pb= (ArrayList<PassengerBean>) q9.list();
	session.close();
	return pb;
}





}


