function sendLogin() {
	console.log("send login triggered");
    // save the uName
    let uName = document.getElementById('uName').value;
    // save the pWord....
    let pWord = document.getElementById('pWord').value;

    console.log(`Username: ${uName}`);
    console.log(`Password: ${pWord}`);

    // build an obj literal with the user credentials
    let loginTemplate = {
        username: uName,
        password: pWord
    }


    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('currentUser', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/employeemenu.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            let currentUser = JSON.parse(userString);
            console.log(currentUser);
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url for the loginServlet")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/login")

    // 4. xhr.send();
    xhr.send(JSON.stringify(loginTemplate)) // this is converting the js object to JSON

}

function sendLogin2() {
	console.log("send login triggered");
    // save the uName
    let uName = document.getElementById('uName').value;
    // save the pWord....
    let pWord = document.getElementById('pWord').value;

    console.log(`Username: ${uName}`);
    console.log(`Password: ${pWord}`);

    // build an obj literal with the user credentials
    let loginTemplate = {
        username: uName,
        password: pWord
    }


    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('currentUser', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/managermenu.html";
            

            console.log(sessionStorage.getItem('currentUser'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url for the loginServlet")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/login2")

    // 4. xhr.send();
    xhr.send(JSON.stringify(loginTemplate)) // this is converting the js object to JSON

}

function sendViewAllById() {
	console.log("send view all by id triggered");
    let currentUser = JSON.parse(userString);
    console.log(currentUser.id);
    id=currentUser.id;

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewall', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewall.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewall'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyid")

    // 4. xhr.send();
    xhr.send(JSON.stringify(id)) // this is converting the js object to JSON

}

function sendViewAllByIdStatus1() {
	console.log("send view all by id triggered");
    let currentUser = JSON.parse(userString);
    console.log(currentUser.id);
    let viewByStatus = {
        id: currentUser.id,
        status: 1
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewpending', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewpending.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewpending'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyidstatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewAllByIdStatus2() {
	console.log("send view all by id triggered");
    let currentUser = JSON.parse(userString);
    console.log(currentUser.id);
    let viewByStatus = {
        id: currentUser.id,
        status: 2
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewapproved', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewapproved.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewapproved'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyidstatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewAllByIdStatus3() {
	console.log("send view all by id triggered");
    let currentUser = JSON.parse(userString);
    console.log(currentUser.id);
    let viewByStatus = {
        id: currentUser.id,
        status: 3
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewdenied', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewdenied.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewdenied'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyidstatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewAll() {
	console.log("send view all by id triggered");
    let currentUser = JSON.parse(userString);

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewall', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewall.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewall'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewall")

    // 4. xhr.send();
    xhr.send(JSON.stringify()) // this is converting the js object to JSON

}

function sendViewAllByStatus1() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let viewByStatus = {
        status: 1
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewpending', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewpending.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewpending'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbystatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewAllByStatus2() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let viewByStatus = {
        status: 2
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewapproved', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewapproved.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewapproved'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbystatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewAllByStatus3() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let viewByStatus = {
        status: 3
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewdenied', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewdenied.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewdenied'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbystatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewMyInfo() {
	console.log("send view all by id triggered");
    let currentUser = JSON.parse(userString);
    

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewmyinfo', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/userprofile.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewmyinfo'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewmyinfo")

    // 4. xhr.send();
    xhr.send(JSON.stringify(currentUser)) // this is converting the js object to JSON

}

function sendApproveDeny() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let viewByStatus = {
        status: 1
    }
    

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewpending', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/approvedeny.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewpending'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbystatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendAllEmployees() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let viewByStatus = {
        status: 1
    }
    

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('employees', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewallemployees.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('employees'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallemployees")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewAllByEmployee() {
	console.log("send view all by id triggered");
    let eId = document.getElementById('eId').value;
    console.log(eId);
    id = parseInt(eId);

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewall', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewall.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewall'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyid")

    // 4. xhr.send();
    xhr.send(JSON.stringify(id)) // this is converting the js object to JSON

}

function sendViewEmployeeByStatus1() {
	console.log("send view all by Status triggered");
    let eId = document.getElementById('eId').value;
    console.log(parseInt(eId));
    let viewByStatus = {
        id: parseInt(eId),
        status: 1
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewpending', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewpending.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewpending'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyidstatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewEmployeeByStatus2() {
	console.log("send view all by Status triggered");
    let eId = document.getElementById('eId').value;
    let viewByStatus = {
        id: parseInt(eId),
        status: 2
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewapproved', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewapproved.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewapproved'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyidstatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendViewEmployeeByStatus3() {
	console.log("send view all by Status triggered");
    let eId = document.getElementById('eId').value;
    let viewByStatus = {
        id: parseInt(eId),
        status: 3
    }

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('viewdenied', this.responseText)
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/viewdenied.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            console.log(sessionStorage.getItem('viewdenied'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/viewallbyidstatus")

    // 4. xhr.send();
    xhr.send(JSON.stringify(viewByStatus)) // this is converting the js object to JSON

}

function sendCreateReimbursement() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let reimbtype = document.getElementById('reimbtype').value;
    let createreimbursement = {
        amount: amount,
        description: description,
        authorId: currentUser.id,
        typeId: reimbtype
    }
    console.log(createreimbursement)

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/reimburementrequest.html";
            

            console.log(sessionStorage.getItem('currentUser'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/createreimbursement")

    // 4. xhr.send();
    xhr.send(JSON.stringify(createreimbursement)) // this is converting the js object to JSON

}

function sendApproveReimbursement() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let rId = document.getElementById('rId').value;
    console.log(rId);
    let approvedenyreimbursement = {
        resolverId: currentUser.id,
        statusId: 2,
        reimbId: rId
    }
    console.log(approvedenyreimbursement)

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/approvedeny.html";
            

            console.log(sessionStorage.getItem('currentUser'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/approvedenyreimbursement")

    // 4. xhr.send();
    xhr.send(JSON.stringify(approvedenyreimbursement)) // this is converting the js object to JSON

}

function sendDenyReimbursement() {
	console.log("send view all by Status triggered");
    let currentUser = JSON.parse(userString);
    let rId = document.getElementById('rId').value;
    console.log(rId);
    let approvedenyreimbursement = {
        resolverId: currentUser.id,
        statusId: 3,
        reimbId: rId
    }
    console.log(approvedenyreimbursement)

    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/approvedeny.html";
            

            console.log(sessionStorage.getItem('currentUser'));
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/approvedenyreimbursement")

    // 4. xhr.send();
    xhr.send(JSON.stringify(approvedenyreimbursement)) // this is converting the js object to JSON

}

function sendUserUpdate() {
	console.log("send login triggered");
    let currentUser = JSON.parse(userString);
    let updateColumn = document.getElementById('updateColumn').value;
    let updateInfo = document.getElementById('updateInfo').value;
    console.log(currentUser.id);
    console.log(updateColumn);
    console.log(updateInfo);

    // build an obj literal with the user credentials
    let userUpdate = {
        id: currentUser.id,
        updateColumn: updateColumn,
        updateInfo: updateInfo
    }


    // begin AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");
            
             window.location = "http://localhost:8080/EmployeeReimbursementSystem/index.html";
            

            console.log(sessionStorage.getItem('currentUser'));
            let currentUser = JSON.parse(userString);
            console.log(currentUser);
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username of Password is incorrect"
        }
    }
    
    // 3. xhr.open("POST, "http:/localhost:8080/EmployeeReimbursementSystem/url for the loginServlet")
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/userupdate")

    // 4. xhr.send();
    xhr.send(JSON.stringify(userUpdate)) // this is converting the js object to JSON

}

function logout() {
		
    let xhr = new XMLHttpRequest();
    
    xhr.open("POST", "http://localhost:8080/EmployeeReimbursementSystem/logout");
    xhr.send();
    
    sessionStorage.removeItem('currentUser');
    window.location = "http://localhost:8080/EmployeeReimbursementSystem/";
    
}




