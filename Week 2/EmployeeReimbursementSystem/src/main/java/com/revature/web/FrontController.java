package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.util.RequestHelper;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String URI = request.getRequestURI().replace("/EmployeeReimbursementSystem/", "");
		
		switch(URI) {
		case "login":
			RequestHelper.processLogin(request, response);
			break;
		case "login2":
			RequestHelper.processLogin2(request, response);
			break;
		case "viewallbyid":
			RequestHelper.viewAllById(request, response);
			break;
		case "viewall":
			RequestHelper.viewAll(request, response);
			break;
		case "viewallbyidstatus":
			RequestHelper.viewAllByIdStatus(request, response);
			break;
		case "viewallbystatus":
			RequestHelper.viewAllByStatus(request, response);
			break;
		case "viewmyinfo":
			RequestHelper.viewMyInfo(request, response);
			break;
		case "createreimbursement":
			RequestHelper.createReimbursement(request, response);
			break;
		case "approvedenyreimbursement":
			RequestHelper.approveDenyReimbursement(request, response);
			break;
		case "viewallemployees":
			RequestHelper.processEmployees(request, response);
			break;
		case "userupdate":
			RequestHelper.userUpdate(request, response);
			break;
		case "logout":
			RequestHelper.processLogout(request, response);
			break;
		case "error":
			RequestHelper.processError(request, response);
			break;
		} 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
