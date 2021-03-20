package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.revature.models.ApproveDenyReimbursement;
import com.revature.models.CreateReimbursement;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.UserUpdate;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	public boolean insert(Employee e) {

		PreparedStatement stmt = null;

		try {

			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_e-mail, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getUsername());
			stmt.setString(2, e.getPassword());
			stmt.setString(3, e.getFirstName());
			stmt.setString(4, e.getLastName());
			stmt.setString(5, e.getUserEmail());
			stmt.setLong(6, e.getRoleId());

			if (!stmt.execute()) {
				return false;
			}

		} catch (SQLException ex) {
			log.warn("Unable to insert user", ex);
			return false;
		}
		// If everything is successful, we return true
		return true;
	}

	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Employee> findAll() {

		List<Employee> list = new ArrayList<Employee>();

		try {

			Connection conn = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ers_users";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ers_users_id");
				String username = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String first_name = rs.getString("user_first_name");
				String last_name = rs.getString("user_last_name");
				String user_email = rs.getString("user_email");
				int role_id = rs.getInt("user_role_id");

				Employee e = new Employee(id, username, password, first_name, last_name, user_email, role_id);
				list.add(e);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}

	public List<Reimbursement> findAllTickets() {

		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {

			Connection conn = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ers_reimbursement";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				String receipt = rs.getString("reimb_receipt");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");

				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, receipt, authorId,
						resolverId, statusId, typeId);
				list.add(r);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}

	public List<Reimbursement> findAllTicketsById(int reimb_author) {

		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {

			Connection conn = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = '" + reimb_author + "'";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				String receipt = rs.getString("reimb_receipt");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");

				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, receipt, authorId,
						resolverId, statusId, typeId);
				list.add(r);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}

	public List<Reimbursement> findAllTicketsByIdStatus(int reimb_author, int reimb_status_id) {

		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {

			Connection conn = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = " + reimb_author + " AND reimb_status_id = " + reimb_status_id + "";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				String receipt = rs.getString("reimb_receipt");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");

				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, receipt, authorId,
						resolverId, statusId, typeId);
				list.add(r);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}
	
	public List<Reimbursement> findAllTicketsByStatus(int reimb_status_id) {

		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {

			Connection conn = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = " + reimb_status_id + "";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				String receipt = rs.getString("reimb_receipt");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");

				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, receipt, authorId,
						resolverId, statusId, typeId);
				list.add(r);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}

	@Override
	public int createRequest(CreateReimbursement createReimbursement) {
		int count = 0;
		try {

			Connection conn = ConnectionUtil.getConnection();

			String sql = "INSERT INTO employee_reimbursement_system.ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)"
					+ "VALUES (?, current_timestamp, ?, ?, 1, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setInt(1, createReimbursement.getAmount());
			stmt.setString(2, createReimbursement.getDescription());
			stmt.setInt(3, createReimbursement.getAuthorId());
			stmt.setInt(4, createReimbursement.getTypeId());
			count = stmt.executeUpdate();

		} catch (SQLException ex) {
			log.warn("Unable to insert into Database", ex);

		}

		return count;
	}

	@Override
	public int approveDenyRequest(ApproveDenyReimbursement approveDenyReimbursement) {
		int count = 0;
		try {

			Connection conn = ConnectionUtil.getConnection();
			int reimbId = approveDenyReimbursement.getReimbId();
			int resolverId = approveDenyReimbursement.getResolverId();
			int statusId = approveDenyReimbursement.getStatusId();

			String sql = "UPDATE employee_reimbursement_system.ers_reimbursement SET reimb_resolved = current_timestamp, reimb_resolver = " + resolverId + ", reimb_status_id = " + statusId + " WHERE reimb_id = " + reimbId + "";

			PreparedStatement stmt = conn.prepareStatement(sql);

			count = stmt.executeUpdate();

		} catch (SQLException ex) {
			log.warn("Unable to insert into Database", ex);

		}

		return count;
	}

	@Override
	public int userUpdate(UserUpdate userUpdate) {
		int count = 0;
		try {

			Connection conn = ConnectionUtil.getConnection();
			int id = userUpdate.getId();
			String updateColumn = userUpdate.getUpdateColumn();
			String updateInfo = userUpdate.getUpdateInfo();

			String sql = "UPDATE employee_reimbursement_system.ers_users SET " + updateColumn + " = '" + updateInfo + "' WHERE ers_users_id = " + id + "";

			PreparedStatement stmt = conn.prepareStatement(sql);

			count = stmt.executeUpdate();

		} catch (SQLException ex) {
			log.warn("Unable to insert into Database", ex);

		}

		return count;
	}

}
