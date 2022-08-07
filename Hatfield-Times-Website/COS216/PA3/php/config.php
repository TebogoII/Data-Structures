 <?php
$servername = "localhost";
$username = "root";
$password = "juniorthage";
$dbname = "hatfieldtimes";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
echo "\nConnected successfully";

$loggedin=0;
?> 