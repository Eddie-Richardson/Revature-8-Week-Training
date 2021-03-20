package com.revature.repositories;

import java.util.List;

import com.revature.models.ApproveDenyReimbursement;
import com.revature.models.CreateReimbursement;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.UserUpdate;

public interface EmployeeDAO {
	// DAO is for CRUD methods 
	public boolean insert(Employee e); // returns true if successfully inserted	
	public boolean update(Employee e);
	
	public List<Employee> findAll(); // this will return ALL employee objects from the DB
	public List<Reimbursement> findAllTickets();
	public List<Reimbursement> findAllTicketsById(int reimb_author);
	public List<Reimbursement> findAllTicketsByIdStatus(int reimb_author, int reimb_status_id);
	public List<Reimbursement> findAllTicketsByStatus(int reimb_status_id);
	public int createRequest(CreateReimbursement createReimbursement);
	public int approveDenyRequest(ApproveDenyReimbursement approveDenyReimbursement);
	public int userUpdate(UserUpdate userUpdate);
	
	
	

}
