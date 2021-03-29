<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/801e5a8a65.js" crossorigin="anonymous"></script>
	
	<style>
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
			<h1 class="display-4">Dashboard</h1>
				<div class="jumbotron">
					<p class="lead" align="right"><span class="badge bg-success">Name: ${userName}</span></p>
					
					<strong>${sTask}</strong>
					
					<p class="lead">You are logged in.</p>
					<p class="lead">Select an option below</p>			
					
					<div class="btn-group">
					  <a href="update" class="btn btn-primary">Add Task</a>
					  <a href="tasks" class="btn btn-primary">View and Delete Tasks</a>
					</div>
						
				</div>
		 </div>
		</div>
	</div>
</body>
</html>

