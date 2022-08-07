<!--- Tebogo Thage, u19054018 --->
<!doctype html>
<title>Covid - Hatfield Times</title>
<style>
  body { text-align: center; padding: 150px; }
  h2 {text-align: center;  text-shadow: 2px 2px #000000; color:#528AAE;}
  h3 {text-align: center;  text-shadow: 2px 2px #000000;}
  body { 
    font: 20px Helvetica, sans-serif; 
    background-image: url('../img/mask.webp');
    background-attachment: fixed;}
  .bg-image {filter: blur(8px); -webkit-filter: blur(8px);}
  article { display: block; text-align: left; width: 650px; margin: 0 auto; }
  a { color: #dc8100; text-decoration: none; }
  a:hover { color: #333; text-decoration: none; }
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
    background-color: #528AAE;
    color: white;
  }

  /* BACKGROUND  */

  @keyframes fadeInAnimation {
      0% {
          opacity: 0;
      }
      100% {
          opacity: 1;
       }
  }

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

  /*header*/
  .topper
  {
    margin-top: -100px;
  }
</style>

<head> 
  <link rel="icon" type="image/x-icon" href="../img/favicon.ico"> 
  <script src="https://kit.fontawesome.com/633bb9df8f.js" crossorigin="anonymous"></script>
</head>

<header class="topper">

  <div class="center" style="top: 10px">
    <h2 style="color:#528AAE;">Hatfield Times</h2>
    <br>
    <h3 style="color:#528AAE;"><b>COVID<i class="fa-solid fa-virus-covid"></i><b></h3>
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

  <!-- <div>
    <ul>
      <style> ul{text-align: center; style="color:#9e0000;" text-shadow: 2px 2px #000000;}</style>
      <li>Accurate</li>
      <li>Impartsfghfsghsdfghsdfiasl</li>
      <li>Unbiased</li>
    </ul>
  </div> -->

</article>

<div id="scroll"></div>

<br>

<div>
  <div>
    <img src="https://corona.dnsforfamily.com/graph.png?c=ZA">
  </div>
  <div>
    <div id="stats">
      <h3 style="color: #528AAE;">WORLDWIDE:</h3>
    </div> 
    <br>
    <h3 style="color: #528AAE;">Graph Statistics: </h3>
    <iframe src="https://public.domo.com/cards/31O7r" width="900" height="600" marginheight="0" marginwidth="0" frameborder="0"></iframe>
    <br>
    <h3 style="color: #528AAE;">Deductions: </h3>
    <div id="deductions">
    </div>  
  </div>
</div>

<?php include "../php/footer.php";?>
<script src="../js/covid.js"></script>