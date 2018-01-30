<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/header.css">
<link rel="stylesheet" href="${css}/footer.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/registration.js"></script>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form action="" method="post" id="fileForm" role="form">
					<fieldset>
						<legend class="text-center">
							Valid information is required to register. <span class="req"><small>
									required *</small></span>
						</legend>

						<div class="form-group">
							<label for="phonenumber"><span class="req">* </span>
								Phone Number: </label> <input required type="text" name="phonenumber"
								id="phone" class="form-control phone" maxlength="28"
								onkeyup="validatephone(this);"
								placeholder="not used for marketing" />
						</div>

						<div class="form-group">
							<label for="firstname"><span class="req">* </span> First
								name: </label> <input class="form-control" type="text" name="firstname"
								id="txt" onkeyup="Validate(this)" required />
							<div id="errFirst"></div>
						</div>

						<div class="form-group">
							<label for="lastname"><span class="req">* </span> Last
								name: </label> <input class="form-control" type="text" name="lastname"
								id="txt" onkeyup="Validate(this)"
								placeholder="hyphen or single quote OK" required />
							<div id="errLast"></div>
						</div>

						<div class="form-group">
							<label for="email"><span class="req">* </span> Email
								Address: </label> <input class="form-control" required type="text"
								name="email" id="email" onchange="email_validate(this.value);" />
							<div class="status" id="status"></div>
						</div>

						<div class="form-group">
							<label for="username"><span class="req">* </span> User
								name: <small>This will be your login user name</small> </label> <input
								class="form-control" type="text" name="username" id="txt"
								onkeyup="Validate(this)" placeholder="minimum 6 letters"
								required />
							<div id="errLast"></div>
						</div>

						<div class="form-group">
							<label for="password"><span class="req">* </span>
								Password: </label> <input required name="password" type="password"
								class="form-control inputpass"  maxlength="16" id="pass1" /> <label for="password"><span class="req">*
							</span> Password Confirm: </label> <input required name="password"
								type="password" class="form-control inputpass" maxlength="16" placeholder="Enter again to validate" id="pass2"
								onkeyup="checkPass(); return false;" /> <span
								id="confirmMessage" class="confirmMessage"></span>
						</div>

						<div class="form-group">

							<?php //$date_entered = date('m/d/Y H:i:s'); ?>
							<input type="hidden" value="<?php //echo $date_entered; ?>"
								name="dateregistered"> <input type="hidden" value="0"
								name="activate" />
							<hr>

							<input type="checkbox" required name="terms"
								onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');"
								id="field_terms"> � <label for="terms">I agree
								with the <a href="terms.php"
								title="You may read our terms and conditions by clicking on this link">terms
									and conditions</a> for Registration.
							</label><span class="req">* </span>
						</div>

						<div class="form-group">
							<input class="btn btn-success" type="submit" name="submit_reg"
								value="Register">
						</div>
						<h5>You will receive an email to complete the registration
							and validation process.</h5>
						<h5>Be sure to check your spam folders.</h5>


					</fieldset>
				</form>
				<!-- ends register form -->

				<script type="text/javascript">
					document
							.getElementById("field_terms")
							.setCustomValidity(
									"Please indicate that you accept the Terms and Conditions");
				</script>
			</div>
			<!-- ends col-6 -->
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>