<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body class="" style="background: #e2e2e2;">
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Complex Form</h3>
						<div class="alert alert-danger" role="alert">
  							Error alert, need attention!
						<form:errors path="student.*" />
						</div>
						<form action="handleform" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Your Name</label> <input
									name="name" ytpe="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter name"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									name with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Your id</label> 
									<input name="id" type="text" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder="Enter Id">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Your date-of-birth</label> 
								<input name="date" type="text" class="form-control"id="exampleInputEmail1" 
								placeholder="dd/mm/yyy" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleFromControlSelect1">Select Courses</label> 
								<select name="courses" type="text" class="form-control"  id="exampleFromControlSelect1" multiple> 
									<option>Java</option>
									<option>Python</option>
									<option>Spring</option>
									<option>Hibernate</option>
									<option>JPA</option>
								</select> 
							</div>
							<div class="form-group">
								<span class="mr-3">Select Gender</span>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="male"> 
										<label class="form-check-lable" for="inlineRadio1">Male</label>
								</div>
								<div class="form-check- form-check-inline">
									<input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="female">
										<label class="form-check-lable" for="inlineRadio2">Female</label>
								</div>
							</div>
							<div class="form-group">
								<label for="">Select Type</label>
								<select class="form-control" name="type">
									<option value="oldstudent">Old Student</option>
									<option value="normalstudent">Normal Student</option>
								</select>
							</div>
							<div class="card">
							<div class="card-body">
							<p>Your address</p>
							<div class="form-group">
								<input 
								name="address.street" 
								type="text" 
								class="form-control" 
								placeholder="Enter street"></div>
							<div class="form-group">
							<input name="address.city" 
							type="text" 
							class="form-control" 
							placeholder="Enter city"></div>
							</div></div>
							<div class="container- text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>