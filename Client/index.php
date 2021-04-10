<?php 
	include("traitement.php");
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	<title>DreamTour</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<!-- header bar start -->
<header id="header">
	<div class="center">
		<h1 class="logo">dream tour travel agency</h1>
		<nav class="link">
			<h2 class="hidden">navigation</h2>
			<ul>
				<li class="active"><a href="index.php">Home</a></li>
				<li><a href="tour.php">Tours</a></li>
				<li><a href="flight.html">Flights</a></li>
				<li><a href="gallery.html">Gallery</a></li>
				<li><a href="about.html">About</a></li>
			</ul>
		</nav>
	</div>
</header>
<!-- header bar end -->	

<!-- search start -->
<div id="adver">
	<img src="img/headline.jpg" alt="bgimage of adver">
	<div class="center"></div>
	<div class="center copy">
		<input type="text" class="search" placeholder="Enter a place you like">
		<button class="button">Search</button>		
	</div>
</div>
<!-- search end -->

<!-- popular tours start -->
<div id="tour">
	<section class="center">
		<h2>Popular Tours</h2>
		<p>Our Most Popluar Cities to Visit</p>
	</section>

		<?php 
		if (isset($cities)) {
			foreach ($cities->result as $cit){?>
			<form method="post" action="city.php">
				<figure>
					<img src="<?php echo  $cit->cityImg ?>" alt="Bangkok - Pattaya for 6 days" style="height:250px">
					<figcaption>
						<div class="tour_title">
							<h4><strong class="title"><?php echo $cit->name; ?></strong></h4> 
						</div>
						<div>
							<em class="sat">Rating 87%</em>
							<span class="price">From $ <strong>698</strong></span>
						</div>
					<div class="type"><?php  echo $cit->countryName;?></div>
					<input type="hidden" name="lat" value="<?php echo $cit->latitude;?>">
					<input type="hidden" name="long" value="<?php echo $cit->longitude;?>">
					<input type="hidden" name="cityName" value="<?php echo $cit->name;?>">
					<input type="hidden" name="cityId" value="<?php echo $cit->id;?>">
					<a href="city.php"><input type="submit" class="btn btn-info" value="view more" name="donnee"></a>
					</figcaption>
				</figure>
				</form>
		<?php	}
		}else{
			echo "Nothing came";
		}
	?>
</div>
<!-- popular tours end -->
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
</body>
</html>