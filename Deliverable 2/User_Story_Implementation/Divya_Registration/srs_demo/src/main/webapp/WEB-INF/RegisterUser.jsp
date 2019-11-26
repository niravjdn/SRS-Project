<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/custom.css" rel="stylesheet" />
	<script type="text/javascript" src="scripts/car-catalog-script.js"></script>  
	<link href="styles/car-catalog-style.css" rel="stylesheet" type="text/css">
	<script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
</head>

<body style="backgorund-color: #E6E6FA; text-align: center;">
	<h2><font color="red"> ${message}</font></h2>
	<form name="myForm" method="post">
	
	<div class="container" align="center">
	<h1>User Registration</h1>
	<br><br>
	<div>
		<label>Email Id</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="email" name="emailId" placeholder="Email Id" Required>
	</div>
	
	<br>
	
	<div>
		<label>Password</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="password" pattern=".{8,}"   required title="password should have minimum 8 characters" name="password" placeholder="Password" Required>	
	</div>
	<br>
	<div>
		<label>User First Name</label>&nbsp&nbsp
		<input type="first name" name="user_firstname" placeholder="First Name" Required>
	</div><br>
	<div>
		<label>User Last Name</label>&nbsp&nbsp
		<input type="last name" name="user_lastname" placeholder="Last Name" Required>
	</div><br>
	
	<div>
		<label>Address</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="address" name="address" placeholder="address">
	</div><br>
	
	<div>
		<label>Phone Number</label>&nbsp&nbsp
		<input type="phone_number" pattern=".{10}" required title="phone number must have 10 characters" name="phone_number" placeholder="Phone Number" Required>
	</div><br>
	
	<br>
	<br>
		<button type="submit"  formaction="/userRegistered" class="btn btn-primary btn-md">Register</button>
		<button type="reset"  class="btn btn-primary btn-md" >Reset</button>
	</div>
	</form>
</body>
</html>