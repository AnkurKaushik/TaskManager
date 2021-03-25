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
			<h1 class="display-4">Register Here</h1>
				<div class="jumbotron">
					<h3 class="display-5">Create Account</h3>
					
					<br>
					
					<p class="lead">Get Started</p>
					
					<br>
					
					<form method="post" action="add" class="w-50 mx-auto">
						<div class="input-group">
							<span data-octicon="alert"></span>
					    	<span class="input-group-addon"><i class="fas fa-user fa-2x"></i>&nbsp;&nbsp;</span>
					    	<input type="text" class="form-control" name="nameadd" placeholder="Name" id="nameadd"  required>
					  	</div>
						<br>
						<div class="input-group">
					    	<span class="input-group-addon"><i class="fas fa-envelope fa-2x"></i>&nbsp;&nbsp;</span>
					    	<input type="text" class="form-control" name="emailadd" placeholder="Email" id="emailadd" required>
					  	</div>
						<br>
						<div class="input-group">
					    	<span class="input-group-addon"><i class="fas fa-user-lock fa-2x"></i>&nbsp;&nbsp;</span>
					    	<input type="text" class="form-control" name="passwordadd" placeholder="Password" id="passwordadd" required>
					  	</div>
					  	 	
						<br><br><input type="submit" value="Enter" class="btn btn-secondary mb-2"/>
					</form>
				
				</div>
		 </div>
		</div>
	</div>
</body>
</html>

