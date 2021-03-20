package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ApproveDenyReimbursement;
import com.revature.models.CreateReimbursement;
import com.revature.models.Employee;
import com.revature.models.LoginTemplate;
import com.revature.models.Reimbursement;
import com.revature.models.UserUpdate;
import com.revature.models.ViewAllByIdStatus;
import com.revature.services.EmployeeService;

public class RequestHelper {

	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();

	public static void processLogin(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class); // from JSON --> Java Object

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		log.info("User attempted to login with username: " + username);

		Employee e = EmployeeService.confirmLogin(username, password);

		if (e.roleId != 2) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(e));

			log.info(username + " has successfully logged in");
		} else {
			res.setStatus(204);
		}

	}

	public static void processLogin2(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class); // from JSON --> Java Object

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		log.info("User attempted to login with username: " + username);

		Employee e = EmployeeService.confirmLogin(username, password);

		if (e.roleId != 1) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(e));

			log.info(username + " has successfully logged in");
		} else {
			res.setStatus(204);
		}

	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false);

		log.info("Processing logout");

		if (session != null) {

			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out");

			session.invalidate();
		}

		res.setStatus(200);

	}

	// Returns all Employees from the DB in JSON form
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {

		// 1. Set the content type to app/json because we will be sending json data back
		// to the client,
		// stuck alongside the response
		log.info(EmployeeService.findAll());
		res.setContentType("application/json");

		// 2. Get a list of all Employees in the DB
		List<Employee> allEmps = EmployeeService.findAll();

		// 3. Turn the list of Java Objs into a JSON string
		String json = om.writeValueAsString(allEmps);

		// 4. Use getWriter() from the response object to return the json string
		PrintWriter pw = res.getWriter();
		pw.println(json);

	}

	public static void processError(HttpServletRequest req, HttpServletResponse res) throws IOException {

		try {
			req.getRequestDispatcher("error.html").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void viewAllById(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		int reimb_author = Integer.parseInt(body);

		log.info("User attempted to view Tickets with Id: " + reimb_author);

		List<Reimbursement> r = EmployeeService.findTicketsById(reimb_author);
		log.info(r);

		if (r != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("authorId", reimb_author);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(r));

			log.info("User with Id " + reimb_author + " has successfully accessed Tickets");
		} else {
			res.setStatus(204);
		}

	}

	public static void viewAllByIdStatus(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		ViewAllByIdStatus idStatus = om.readValue(body, ViewAllByIdStatus.class); // from JSON --> Java Object

		int id = idStatus.getId();
		int status = idStatus.getStatus();

		log.info("User attempted to view Tickets with Id: " + id);

		List<Reimbursement> r = EmployeeService.findTicketsByIdStatus(id, status);
		log.info(r);

		if (r != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("reimb_status_id", status);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(r));

			log.info("User with Id " + id + " has successfully accessed Tickets");
		} else {
			res.setStatus(204);
		}

	}

	public static void viewAll(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		//log.info("Manager attempted to view Tickets with Id: " + reimb_author);

		List<Reimbursement> r = EmployeeService.findAllTickets();
		log.info(r);

		if (r != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			//session.setAttribute("authorId", reimb_author);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(r));

			//log.info("Manager with Id " + reimb_author + " has successfully accessed Tickets");
		} else {
			res.setStatus(204);
		}

	}

	public static void viewAllByStatus(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		ViewAllByIdStatus idStatus = om.readValue(body, ViewAllByIdStatus.class); // from JSON --> Java Object
		int status = idStatus.getStatus();

		List<Reimbursement> r = EmployeeService.findTicketsByStatus(status);
		log.info(r);

		if (r != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("reimb_status_id", status);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(r));

			log.info("Manager has successfully accessed Tickets");
		} else {
			res.setStatus(204);
		}

	}
	
	public static void viewMyInfo(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		Employee employee = om.readValue(body, Employee.class); // from JSON --> Java Object

		String username = employee.getUsername();

		log.info("User attempted to login with username: " + username);

		Employee e = EmployeeService.findByUsername(username);

		if (e != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);

			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			pw.println(om.writeValueAsString(e));

			log.info(username + " has successfully logged in");
		} else {
			res.setStatus(204);
		}

	}

	public static void createReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// turn whatever we receive as the request into a string to process
				BufferedReader reader = req.getReader();
				StringBuilder s = new StringBuilder();

				// logic to transfer everything from our reader to our string builder
				String line = reader.readLine();
				while (line != null) {
					s.append(line);
					line = reader.readLine();
				}

				String body = s.toString();
				log.info(body);
				
				CreateReimbursement createReimbursement = om.readValue(body, CreateReimbursement.class); // from JSON --> Java Object

				
				
				EmployeeService.createRequest(createReimbursement);
				
		
	}
	
	public static void approveDenyReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// turn whatever we receive as the request into a string to process
				BufferedReader reader = req.getReader();
				StringBuilder s = new StringBuilder();

				// logic to transfer everything from our reader to our string builder
				String line = reader.readLine();
				while (line != null) {
					s.append(line);
					line = reader.readLine();
				}

				String body = s.toString();
				log.info(body);
				
				ApproveDenyReimbursement approveDenyReimbursement = om.readValue(body, ApproveDenyReimbursement.class); // from JSON --> Java Object
				
				EmployeeService.approveDenyRequest(approveDenyReimbursement);
				
		
	}
	
	public static void userUpdate(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		log.info(body);

		UserUpdate userUpdate = om.readValue(body, UserUpdate.class); // from JSON --> Java Object


		EmployeeService.userUpdate(userUpdate);

	}

}
