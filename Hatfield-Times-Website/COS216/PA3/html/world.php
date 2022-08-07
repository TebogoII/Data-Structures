<!--- Tebogo Thage, u19054018 --->
<!doctype html>
<title>World - Hatfield Times</title>
<style>
  body { text-align: center; padding: 150px; }
  h2 {text-align: center;  text-shadow: 2px 2px #000000; color:#9e0000;}
  h3 {text-align: center;  text-shadow: 2px 2px #000000;}
  body { 
    font: 20px Helvetica, sans-serif; 
    background-image: url('../img/World.webp');
    background-size: length;
    background-attachment: fixed;}
  article { display: block; text-align: left; width: 650px; margin: 0 auto; }
  a { color: #dc8100; text-decoration: none; }
  a:hover { color: #9e0000; text-decoration: none; }
  h1 {text-align: center;}
  /*NAV BAR*/
  /* Add a black background color to the top navigation */
  .topnav {
    background-color: #333;
    overflow: hidden;
  }

  /* Style the links inside the navigation bar */
  .topnav a {
    float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
  }

  /* Change the color of links on hover */
  .topnav a:hover {
    background-color: #ddd;
    color: black;
  }

  /* Add a color to the active/current link */
  .topnav a.active {
    background-color: #9e0000;
    color: white;
  }

  /* BACKGROUND  */


  /*Search*/
  .topnav input[type=text] 
  {
    float: right;
    padding: 5px;
    border: none;
    margin-top: 8px;
    margin-right: 2px;
    font-size: 17px;
  }

  /*font*/
  @font-face 
  {
    font-family: Canterbury; 
    src: url("../Canterbury.ttf");
  }

   /* Dropdown Button */
  .dropbtn {
    background-color: #9e0000;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
  }

  /* The container <div> - needed to position the dropdown content */
  .dropdown {
    position: relative;
    display: inline-block;
  }

  /* Dropdown Content (Hidden by Default) */
  .dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
  }

  .dropdown-content:hover {
    color: #9e0000;
  }

  /* Links inside the dropdown */
  .dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
  }

  /* Change color of dropdown links on hover */
  .dropdown-content a:hover {background-color: #ddd;}

  /* Show the dropdown menu on hover */
  .dropdown:hover .dropdown-content {display: block;}

  /* Change the background color of the dropdown button when the dropdown content is shown */
  .dropdown:hover .dropbtn {background-color: #333333;} 

  /*header*/
  .topper
  {
    margin-top: -100px;
  }



.hidden {
  display: none;
}
</style>
<script type="text/javascript">
  function hideLoadingDiv() {
  setTimeout(function(){
    document.getElementById('LOADING').classList.add('hidden');
  },5000)
}
</script>


<head> 
  <link rel="icon" type="image/x-icon" href="../img/favicon.ico">
  <script src="https://kit.fontawesome.com/633bb9df8f.js" crossorigin="anonymous"></script> 
</head>

<header class="topper">

  <div class="center" style="top: 10px">
    <h2 style="color:#9e0000;">Hatfield Times</h2>
    <br>
    <h3 style="color:#ae0000;"><b>WORLD<i class="fa-solid fa-earth-africa"></i><b></h3>
    <style>
      h2 {
           font-family: Canterbury;
           font-size: 100px;
        }
      h1 {
           font-family: Canterbury;
           font-size: 150px;
        }
    </style>
  </div> 
</header>

<article>
  <?php include "../php/header.php";?>
  <style>
    .container {
      height: 200px;
      position: relative;
    }

    .centers {
      margin: 0;
      position: absolute;
      top: 50%;
      left: 50%;
      -ms-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
    }
    .center2 {
      margin: 0;
      position: absolute;
      text-align: center;
      left: -68%;
      -ms-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
    }
  </style>
 
</article>

<marquee behavior="scroll" direction="right"><h3 style="color: #9e0000;">LATEST WORLD NEWS</h3></marquee>

<br>

<body>
  <style>
    h5{
      color:  white;
              text-shadow:
        -1px -1px 0 #000,
        1px -1px 0 #000,
        -1px 1px 0 #000,
        1px 1px 0 #000; 
    }
    .strokeme
    {
        color: white;
        text-shadow:
        -1px -1px 0 #000,
        1px -1px 0 #000,
        -1px 1px 0 #000,
        1px 1px 0 #000;  
    }
  </style>

<body onload="hideLoadingDiv()">
      <div class="LOADING" id="LOADING" name="LOADING"><img src="../img/load.svg" style="width:100px;height:100px;"></div>
</body>

    <br><br><br>
  <div id="news"></div>
  <div id="news1"></div>
  <div id="news2"></div>
  <div id="news3"></div>
  <div id="news4"></div>
  <script src="../js/world.js"></script>
</body>

<?php include "../php/footer.php";?>