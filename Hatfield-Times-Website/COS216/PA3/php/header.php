<?php
echo '<div class="topnav">
	    <a class="active" href="../../../index.html">HOME</a>
	    <a href="../html/today.php">TODAY</a>
	    <a href="../html/covid.php">COVID</a>
	    <a href="../html/southafrica.php">SOUTH AFRICA</a>';
  $host = $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI'];
  //echo $host;
  if ($host=="wheatley.cs.up.ac.za/u19054018/COS216/PA3/html/today.php")
  {
  	echo '<input type="text" placeholder="Search.." id=search>
  		  <a class="active" onclick="Search()" style="width: 20px" style="float: right"><i class="fa-solid fa-search"></i></a>';
  }
  else
  {
  	echo '<a href="../html/world.php">WORLD</a>
    <a class="active" href="../php/login.php" style="width: 71px" style="float: right"><i class="fa-solid fa-user"></i></a>';
  }
  echo '</div>';
?>