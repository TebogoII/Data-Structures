<?php
  $username_err;
  function signin(){
    $usr=$_POST['username'];
    $nme=$_POST['name'];
    $snm=$_POST['surname'];
    $eml=$_POST['email'];
    $pss=$_POST['password'];
    $cps=$_POST['confirm_password'];
    include "config.php";
    $hsh = hash('sha256', $pss);
    //check if exists
    $sql = "SELECT * FROM users WHERE id='$usr'";
  $result = $conn->query($sql);
  $valid=1;

  if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) 
    {
      $valid=0;
      echo "<script>alert('The Username already exists!');</script>";
    }
  }

  if (!strpos($eml, '@')!==false)
  {
    echo "<script>alert('Invalid email');</script>";
    $valid=0;
      $sql = "SELECT * FROM users WHERE email='$usr'";
    $result = $conn->query($sql);
    if ($result->num_rows > 0)
    {
      echo "<script>alert('Email already exists');</script>";
    }
  }

  if (!(strlen($pss)>=8))
  {
    echo "<script>alert('Password error (must be more than 8 charachters, have capital and small letters and at least 1 digit)');</script>";
    $valid=0;
  }

  if ($pss!=$cps)
  {
    echo "<script>alert('The passwords do not match');</script>";
    $valid=0;
  }

  if ($valid==1){
    $sql = "INSERT INTO users (id, name, surname, email, password)
    VALUES ('$usr', '$nme', '$snm', '$eml', '$hsh')";
      if ($conn->query($sql) === TRUE) {
        echo "\nYour API Key=" . hash('sha256', $usr);
        echo "\nNew user created successfully";
      } else {
        echo "\nError: " . $sql . "<br>" . $conn->error;
      }
  }
    $conn->close();
  }
  if (isset($_POST['log'])) {
    //echo "we in this";
    signin();
  }
?>