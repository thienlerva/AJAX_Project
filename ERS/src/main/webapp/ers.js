window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#viewTicketsNav').on('click', loadTicketsView);
	$('#userNav').on('click', loadUserView);
	$('#authorNav').on('click', loadAuthorView);

}

function loadHomeView(){
	/*
	 * AJAX functions can be used to retrieve all types 
	 * of data from a server. Including HTML!
	 * We will send a request to a servlet which will 
	 * forward our desired HTML page as a response, 
	 * then, in the onreadystatechange function, we will 
	 * designate what we would like to do with the response 
	 * as usual -- but in this case, we will apply event listeners
	 * to the new DOM elements
	 */
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}

function loadTicketsView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
			console.log(xhr.responseText);
			getTickets();
		}
	}
	xhr.open("GET", "reimbursement.view", true);
	xhr.send();	
}

function getTickets(){
	//send request to /reimbursements
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let reims = JSON.parse(xhr.responseText);
			console.log(reims);
			
			for(let r of reims){
				appendToTicketList(r);
			}
		}
	}
	xhr.open("GET", "reimbursements");
	xhr.send();
}

function appendToTicketList(r){
	var li = $(`<li>${r.reimbSubmitted}</li>`);
	$('#reimbursementList').append(li);
}

function loadUserView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
			// manipulate user view
			getUsers();
			$('#addUser').on('click', addUser);
		}
	}
	xhr.open("GET", "user.view", true);
	xhr.send();	
}

function getUsers(){
	//send request to /users
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		
			let users = JSON.parse(xhr.responseText);
		
			$('#userName').html(`Welcome${users.firstName}`);
			for(let u of users){
				appendToUserList(u);
			}
		}
	}
	xhr.open("GET", "users");
	xhr.send();
}

function appendToUserList(u){
	var li = $(`<li>${u.firstName}</li>`);
	$('#userList').append(li);
}


function addUser(){
	
	var genre = $('#newUser').val();
	var obj = {
			name: genre
	};
	var toSend = JSON.stringify(obj);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.status);
			console.log(xhr.responseText);
			console.log(xhr.responseType);
			appendToGenreList(obj);
		}
	}
	xhr.open("POST", "users");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(toSend);

}

function loadAuthorView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "author.view", true);
	xhr.send();	
}