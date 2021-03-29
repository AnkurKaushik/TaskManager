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
			<h1 class="display-4">Tasks</h1>
				<div class="jumbotron">
					<p class="lead">All tasks for current user:</p>
					
					
					<table style="float:inherit">
					   <tr><th>ID</th><th>Name</th><th>Start</th><th>End</th><th>Severity</th><th>Description</th><th>Email</th></tr>
					   <c:forEach items="${alltasks}" var="task" varStatus="count">
					    <tr id="${count.index}">
					    	<td>${task.id}</td>
					        <td>${task.name}</td>
					        <td>${task.startDate}</td>
					        <td>${task.endDate}</td>
					        <td>${task.severity}</td>
					        <td>${task.description}</td>
					        <td>${task.email}</td>
					    </tr>
					  </c:forEach>
					</table>
					
					<br><br>
					
					<hr/>
					
					<p class="lead">Delete a task</p>
					
					<form method="get" action="delete" class="w-25 mx-auto">
						<div class="input-group">
					    	<span class="input-group-text" id="basic-addon1">Enter the ID that you want to delete:</span>
					    	<input type="number" class="form-control" name="taskid" id="taskid">
					  	</div>
						<br><input type="submit" value="Submit" class="btn btn-primary mb-2"/>
					</form>
					
					<hr/>
					
					<br><br>
					
					<form method="get" action="dashboard">
						<input type="submit" value="Return" class="btn btn-secondary mb-2"/>
					</form>
				</div>
		 </div>
		</div>
	</div>
</body>
</html>