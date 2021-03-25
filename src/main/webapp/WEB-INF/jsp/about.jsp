<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
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
		 
			<h1 class="display-4" align="center">About This Project</h1>
				<div class="jumbotron">
					<h1 class="display-4">Phase 3 End Project - Create a Task Manager</h1>
					<h3>Application</h3>
					<h3>Project Objective:</h3>
					<p class="lead">Create a task manager application with spring boot and spring Data JPA.</p>
					<hr/>
					<p class="lead">The Task Manager is for organizing tasks (or to-dos) for workers.

					The logged in user should be able to create, display, delete, and update tasks (basically to-do items.)

					Tasks are the user's own tasks. 
					</p>
					<p class="lead">Users create and edit tasks to themselves but can neither create tasks for others, reassign existing tasks to other users or even view tasks that do not belong to them.

					The application will have UI in JSP.
					</p>
					
					<p class="lead">Suggested JSP Pages:
						<br>-create task
						<br>-display tasks
						<br>-delete tasks
						<br>-update task.
						<br>-Login
						<br>-User Registration
						<br>-Index/Welcome
					</p>
					<hr/>
					
					<h3>Important Notes:</h3>
					<p class="lead">-Project must be well organized in packages.
						<br>-Usage of Repository, Service, Entity, and custom exception handling
						<br>-All data must persist in the database. (User information should also be stored in database)
						<br>-User must be logged in before adding or seeing the tasks. (spring boot security is acceptable but not mandatory.)
						<br>-User must get registered, to perform the login.
						<br>-Either monolithic or microservice based architecture is acceptable.
					</p>
					
					<h3>Important Fields:</h3>
					<p class="lead">-Project must be well organized in packages.
						<br>-Task Name
						<br>-Start date (date picker)
						<br>-End date (date picker)
						<br>-Description (text area)
						<br>-Email (text box)
						<br>-Severity (drop down) (High, medium, low)
						<br>-User (tasks should belong to a user)
					</p>
					
				</div>
		</div>
	</div>
</body>
</html>

