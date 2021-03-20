package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.ApproveDenyReimbursement;
import com.revature.models.CreateReimbursement;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.UserUpdate;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	private static Logger log = Logger.getLogger(EmployeeService.class);

	public static EmployeeDAO eDao = new EmployeeDAOImpl();

	public static boolean insert(Employee e) {

		return eDao.insert(e);
	}

	public static boolean update(Employee e) {

		return eDao.update(e);
	}

	public static List<Employee> findAll() {
		return eDao.findAll();
	}

	// find by username...
	public static Employee findByUsername(String username) {
		List<Employee> all = eDao.findAll();

		for (Employee e : all) { // filtering with an enhanced for-loop!
			if (e.getUsername().equals(username)) {
				return e; // we return the Employee object with a matching ID
			} else {
				continue; // if username doesn't match the username prop of the Employee element
							// then continue the loop to the next element.
			}
		}

		return null;
	}

	// confirm login method
	public static Employee confirmLogin(String username, String password) {

		Employee e = findByUsername(username);

		if (e == null) {
			return null;
		}

		if (e.getPassword().equals(password)) {
			return e;
		} else {
			return null;
		}
	}

	public static List<Reimbursement> findTicketsById(int reimb_author) {
		List<Reimbursement> all = eDao.findAllTicketsById(reimb_author);

		for (Reimbursement r : all) {
			while (r.getAuthorId() == reimb_author) {
				List<Reimbursement> list = new ArrayList<Reimbursement>();
				list.add(r);
				return all;
			} 
		} 

		return null;
	}

	public static List<Reimbursement> findTicketsByIdStatus(int reimb_author, int reimb_status_id) {
		List<Reimbursement> all = eDao.findAllTicketsByIdStatus(reimb_author, reimb_status_id);
		
		for (Reimbursement r : all) {
			while (r.getStatusId() == reimb_status_id) {
				List<Reimbursement> list = new ArrayList<Reimbursement>();
				list.add(r);
				return all;
			} 
		} 

		return null;
	}
	
	public static List<Reimbursement> findAllTickets() {
		List<Reimbursement> all = eDao.findAllTickets();

		for (Reimbursement r : all) {
			while (r != null) {
				List<Reimbursement> list = new ArrayList<Reimbursement>();
				list.add(r);
				return all;
			} 
		} 

		return null;
	}

	public static List<Reimbursement> findTicketsByStatus(int reimb_status_id) {
		List<Reimbursement> all = eDao.findAllTicketsByStatus(reimb_status_id);
		
		for (Reimbursement r : all) {
			while (r.getStatusId() == reimb_status_id) {
				List<Reimbursement> list = new ArrayList<Reimbursement>();
				list.add(r);
				return all;
			} 
		} 

		return null;
	}
	
	public static int createRequest(CreateReimbursement createReimbursement) {
		int count = 0;
		count = eDao.createRequest(createReimbursement);
		
	return count;
}
	
	public static int approveDenyRequest(ApproveDenyReimbursement approveDenyReimbursement) {
		int count = 0;
		count = eDao.approveDenyRequest(approveDenyReimbursement);
		
	return count;
}
	
	public static int userUpdate(UserUpdate userUpdate) {
		int count = 0;
		count = eDao.userUpdate(userUpdate);
		
	return count;
}


}
