DROP TABLE IF EXISTS ers_reimbursement_status CASCADE;
CREATE TABLE ers_reimbursement_status (
	reimb_status_id INTEGER PRIMARY KEY,
	reimb_status VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS ers_reimbursement_type CASCADE;
CREATE TABLE ers_reimbursement_type (
	reimb_type_id INTEGER PRIMARY KEY,
	reimb_type VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS ers_reimbursement_roles CASCADE;
CREATE TABLE ers_reimbursement_roles (
	ers_user_role_id INTEGER PRIMARY KEY,
	user_role VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS ers_users CASCADE;
CREATE TABLE ers_users (
	ers_users_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(50) UNIQUE,
	ers_password VARCHAR(50),
	user_first_name VARCHAR(100),
	user_last_name VARCHAR(100),
	user_email VARCHAR(150) UNIQUE,
	user_role_id INTEGER,
	FOREIGN KEY (user_role_id) REFERENCES ers_reimbursement_roles(ers_user_role_id)
);

DROP TABLE IF EXISTS ers_reimbursement CASCADE;
CREATE TABLE ers_reimbursement (
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount INTEGER,
	reimb_submitted TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR(250),
	reimb_receipt BYTEA,
	reimb_author INTEGER,
	reimb_resolver INTEGER,
	reimb_status_id INTEGER,
	reimb_type_id INTEGER,
	FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id),
	FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id),
	FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
	FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)
);

INSERT INTO ers_reimbursement_roles (ers_user_role_id, user_role)
VALUES
(1, 'Employee'),
(2, 'Manager');

INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
VALUES
(1, 'Pending'),
(2, 'Approved'),
(3, 'Denied');

INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
VALUES
(1, 'AmbasProg'),
(2, 'AsTravelEx'),
(3, 'Certif'),
(4, 'RelocTrain'),
(5, 'SeTravelEx');

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES
('JohnDoe', 'password123', 'John', 'Doe', 'JohnDoe@example.com', 1),
('JaneDoe', 'password456', 'Jane', 'Doe', 'JaneDoe@example.com', 1),
('JimmyDoe', 'password789', 'Jimmy', 'Doe', 'JimmyDoe@example.com', 2);

INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES
(250, Current_timestamp, null, 'Relocation to Training', 1, null, 1, 2),
(250, Current_timestamp, current_timestamp, 'Relocation to Training', 1, 3, 2, 2),
(250, Current_timestamp, null, 'Relocation to Training', 2, null, 1, 2),
(250, Current_timestamp, current_timestamp, 'Relocation to Training', 2, 3, 3, 2);

SELECT * FROM ers_reimbursement;

SELECT * FROM ers_reimbursement WHERE reimb_id =1;

UPDATE ers_reimbursement WHERE reimb_id =1,
(reimb_resolved = current_timestamp, reimb_resolver = 3, reimb_status_id = 2);

SELECT * FROM ers_reimbursement WHERE reimb_author = 1 AND reimb_status_id = 1;

UPDATE employee_reimbursement_system.ers_reimbursement SET reimb_resolved = current_timestamp, reimb_resolver = 3, reimb_status_id = 2 WHERE reimb_id = 1;