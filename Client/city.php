<?php 
//Using GET
if(isset($_POST['donnee'])){
  $lat = $_POST['lat'];
  $long = $_POST['long'];
  $cityId = $_POST['cityId'];
  $cityName = $_POST['cityName'];
}
include("traitement.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	<title>DreamTour</title>
	<link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/weather.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,700;1,600&display=swap" rel="stylesheet">
</head>
<body>
<!-- header bar start -->
<header id="header">
	<div class="center">
		<h1 class="logo">dream tour travel agency</h1>
		<nav class="link">
			<h2 class="hidden">navigation</h2>
			<ul>
				<li><a href="index.php">Home</a></li>
				<li><a href="tour.php">Tours</a></li>
				<li><a href="flight.html">Flights</a></li>
				<li><a href="about.html">About</a></li>
			</ul>
		</nav>
	</div>
</header>
<!-- header bar end -->	

<!-- headline start -->
<div id="headline">
		<img src="img/headline.jpg" alt="headline">
		<hgroup>
			<h2><?php echo $cityName?></h2>
			<h3>City, art, sea, mount, and people ...</h3>
		</hgroup>
</div>
<!-- headline end -->

<!-- mainbody start -->
<div id="container">
	<aside class="sidebar">
		<div class="side dest">
			<h2>Weather Info</h2>
			<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="">
        <!-- <img src="" alt="" srcset="" id="weather-icon" style="margin-left:30px"> -->
        <div id="location" style="margin-top:10px"><?php echo $cityName?></div>
        <div class="desc" style="font-size:20px;margin-top:10px">No Information Available.</div>
        <div class="weather" style="font-size:20px;margin-top:20px">
            <div class="c" style="margin-left:40px">Error</div>
            <div class="circle"></div>
        </div>
        <div class="info">
            <h5>Sunrise: <span class="sunrise">No Information Available</span></h5>
            <h5>Sunset: <span class="sunset">No Information Available</span></h5>
        </div>
        </div>
    </div>
</div>
		</div>
		<div class="side hot">
			<h2>Hot Deals</h2>
			<div class="figure">
				<figure>
					<img src="img/hot1.jpg" alt="Bangkok for 6 days">
					<figcaption>Bangkok for 6 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot2.jpg" alt="Maldives for 4 days">
					<figcaption>Maldives for 4 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot3.jpg" alt="Xian for 5 days">
					<figcaption>Xian for 5 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot4.jpg" alt="Tokyo for 8 days">
					<figcaption>Tokyo for 8 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot5.jpg" alt="Australia for 7 days">
					<figcaption>Australia for 7 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot6.jpg" alt="Silk Road for 4 days">
					<figcaption>Silk Road for 4 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot7.jpg" alt="Europe for 9 days">
					<figcaption>Europe for 9 days</figcaption>
				</figure>
				<figure>
					<img src="img/hot8.jpg" alt="HongKong for 3 days">
					<figcaption>HongKong for 3 days</figcaption>
				</figure>
			</div>
		</div>
		<div class="side box">
			<h2>Tools</h2>
			<div class="tool">
				<ul>
					<li><a href="###" class="tool1">Weather</a></li>
					<li><a href="###" class="tool2">Train</a></li>
					<li><a href="###" class="tool3">Flight</a></li>
					<li><a href="###" class="tool4">Subway</a></li>
				</ul>
			</div>
		</div>
	</aside>
	<div class="list scenery">
		<section>
			<h2>Explore the Beauty of <?php echo $cityName?></h2>
    <?php try 
    {
      $paramCity = new stdClass();
      $paramCity->idCity = $cityId;
      $destinationsCity = $clientSOAP->__soapCall("getDestinationsByCity",array($paramCity));
      if (isset($destinations)) 
      {
        foreach ($destinationsCity->result as $destCity)
        {
        ?>
            <figure>
              <img src="img/gallery1.jpg" alt="Bangkok - Pattaya">
              <figcaption><?php echo $destCity->nameDest?></figcaption>
              <figcaption><?php echo $destCity->destName?></figcaption>
            </figure>
          <?php 
        }
      }
    }
      catch(Exception $e) {
        var_dump($e);
    }?>
		<div class="clearfix"></div>
		<div class="more">More...</div>
	</div>
</div>
<!-- mainbody end -->

<!-- footer start -->
<footer id="footer">
	<div class="top sm-hidden">
		<div class="column left">
			<h2>Travel Agency</h2>
			<hr>
			<ul>
				<li><a href="###">Discover City</a></li>
				<li><a href="###">Discover Destinations</a></li>
				<li><a href="###">Get Weather Info</a></li>
			</ul>
		</div>
		<div class="column mid">
			<h2>FAQ</h2>
			<hr>
			<ul>
				<li><a href="###">How about the discount for children.</a></li>
				<li><a href="###">What is the best time travel to Australia.</a></li>
				<li><a href="###">How many kinds of travel insurance.</a></li>
			</ul>			
		</div>
		<div class="column right">
			<h2>Authors</h2>
			<hr>
			<ul>
				<li><a href="###">DIALLO Mamadou Bella</a></li>
				<li><a href="###">DIAWARA Mourtalla Faty</a></li>
				<li><a href="###">Design Inspired by Dream Tour</a></li>
			</ul>			
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="bottom">Web Services University Project</div>
</footer>
<!-- footer end -->
<script src="weatherAPI.js"></script>
<form action="">
<input type="hidden" id="lat" name="lat" value="<?php echo $lat; ?>">
<input type="hidden" id="long" name="long" value="<?php echo $long; ?>">
</form>

</body>
</html>