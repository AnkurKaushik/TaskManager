<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
	table, th, td {
	  border: 1px solid black;
	  	  margin: auto;
	  
	}
	.center {
 		text-align: center;
 	}
	</style>
</head>
<body style="background-color:lightblue;">
	<nav class="navbar navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/">Task Manager</a>
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0"> 
	      	<li><a class="nav-link active" aria-current="page" href="/about">About</a></li>
	      </ul>
	      
	  </div>
	</nav>
	
	<div class="d-flex justify-content-center">
		<div class="w-75 p-3">
		 <div class="center">
			<h1 class="display-4">Add Tasks</h1>
				<div class="jumbotron">
					<p class="lead">Fill out the form below to add a task</p>
					<br>
					<form method="post" action="update2" class="w-50 mx-auto">
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">Task Name</span>
					    	<input type="text" class="form-control" name="taskname" id="taskname"  required>
					  	</div>
					  	<br>
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">Start Date</span>
					    	<input type="date" class="form-control" name="taskstart" id="taskstart" required>
					  	</div>
						<br>
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">End Date</span>
					    	<input type="date" class="form-control" name="taskend" id="taskend" required>
					  	</div>
						<br>
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">Description</span>
					    	<input type="text" class="form-control" name="taskdesc" id="taskdesc" required>
					  	</div>
					  	<br>
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">Email</span>
					    	<input type="text" class="form-control" name="taskemail" id="taskemail" required>
					  	</div>
					  	<br>
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">Severity</span>
					    	<select class="form-select" aria-label="Default select example" >
							  <option selected>Select...</option>
							  <option value="1">High</option>
							  <option value="2">Medium</option>
							  <option value="3">Low</option>
							</select>
					  	</div>
					  	 	
						<br><br><input type="submit" value="Enter" class="btn btn-secondary mb-2"/>
					</form>	
				</div>
		 </div>
		</div>
	</div>
</body>
</html>