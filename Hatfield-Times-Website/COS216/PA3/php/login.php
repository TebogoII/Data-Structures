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
      <h2 class="display-4 pt-3">Login</h2>
          <p class="text-center">Please fill this form to create an account.</p>
          <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="POST">
            <div class="form-group <?php (!empty($username_err))?'has_error':'';?>">
              <label for="username">Username</label>
              <input type="text" name="username" id="username" class="form-control" value="">
            </div>

            <div class="form-group <?php (!empty($password_err))?'has_error':'';?>">
              <label for="password">Password</label>
              <input type="password" name="password" id="password" class="form-control" value="">
            </div>

            <div class="form-group">
              <input method="post" type="submit" name="log" class="btn btn-block btn-outline-primary" value="Login">
            </div>
            <p>Don't have an account? <a href="signup.php">Sign in</a>.</p>
            <p><a href="../html/today.php">Back Home</a>.</p>
          </form>
    </section>
  </main>
</body>
</html>
<?php
  /*function login(){
    include "config.php";
    $sql = "INSERT INTO users (id, name, surname, email, password)
    VALUES ('2','Jam', 'Dock', 'joedoe@example.com','doejon')";

    if ($conn->query($sql) === TRUE) {
      echo "New record created successfully";
    } else {
      echo "Error: " . $sql . "<br>" . $conn->error;
    }
    $conn->close();
  }
  if (isset($_POST['log'])) {
    //echo "we in this";
    login();
  }*/
?>
<?php include "../php/footer.php";?>