<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sign in</title>
	<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-qdQEsAI45WFCO5QwXBelBe1rR9Nwiss4rGEqiszC+9olH1ScrLrMQr1KmDR964uZ" crossorigin="anonymous">
	<style>
	    h2 {text-align: center;  
	      text-shadow: 2px 2px #000000; 
	      color:#428fe6; 
	      font-family: Canterbury; 
	      font-size: 100px;
	    }
        .wrapper{ 
        	width: 500px; 
        	padding: 20px; 
        }
        .wrapper h2 {text-align: center}
        .wrapper form .form-group span {color: red;}
	</style>
</head>
<body>
	<main>
		<section class="container wrapper">
			<h2 class="display-4 pt-3">Sign Up</h2>
        	<p class="text-center">Please fill in your credentials.</p>
        	<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="POST">
        		<div class="form-group <?php (!empty($username_err))?'has_error':'';?>">
        			<label for="username">Username</label>
        			<input type="text" name="username" id="username" class="form-control" value="">
        		</div>

        		<div class="form-group <?php (!empty($password_err))?'has_error':'';?>">
        			<label for="name">Name</label>
        			<input type="text" name="name" id="name" class="form-control" value="">
        		</div>

        		<div class="form-group <?php (!empty($password_err))?'has_error':'';?>">
        			<label for="surname">Surname</label>
        			<input type="text" name="surname" id="surname" class="form-control" value="">
        		</div>

        		<div class="form-group <?php (!empty($password_err))?'has_error':'';?>">
        			<label for="email">Email</label>
        			<input type="text" name="email" id="email" class="form-control" value="">
        		</div>

        		<div class="form-group <?php (!empty($password_err))?'has_error':'';?>">
        			<label for="password">Password</label>
        			<input type="password" name="password" id="password" class="form-control" value="">
        		</div>

        		<div class="form-group <?php (!empty($confirm_password_err))?'has_error':'';?>">
        			<label for="confirm_password">Confirm Password</label>
        			<input type="password" name="confirm_password" id="confirm_password" class="form-control" value="">
        		</div>

        		<div class="form-group">
        			<input method="post" type="submit" name="log" class="btn btn-block btn-outline-success" value="Submit">
        			<input type="reset" class="btn btn-block btn-outline-primary" value="Reset">
        		</div>
        		<p>Already have an account? <a href="login.php">Login here</a>.</p>
        		<p><a href="../html/today.php">Back Home</a>.</p>
        	</form>
		</section>
	</main>
</body>
</html>
<?php include "../php/validate-signup.php";?>
<?php include "footer.php";?>