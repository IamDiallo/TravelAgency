<?php 
	include("traitement.php");
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<title>DreamTour</title>
	<link rel="stylesheet" href="css/style.css">
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
				<li class="active"><a href="tour.php">Tours</a></li>
			</ul>
		</nav>
	</div>
</header>
<!-- header bar end -->	

<!-- headline start -->
<div id="headline">
		<img src="img/headline.jpg" alt="headline">
		<hgroup>
			<h2>Travel Info</h2>
			<h3>The latest travel information, news, and tips.</h3>
		</hgroup>
</div>
<div id="container">
	<div class="list information" style="width: 100%">
		<h2>Travel information</h2>
        <div class="row">
        <?php 
		if (isset($listDestination)) {
			foreach ($listDestination->result as $listDest){
          ?>
          <div class="col-6">
          <figure class="tour">
			<img src="<?php echo $listDest->img ?>" alt="Bangkok for 6 days">
			<figcaption>
					<article>
						<header>
							<hgroup>
								<h4 style="margin-left:15px"><?php  echo $listDest->nameDest;?></h4>
							</hgroup>
						</header>
						<div class="buy" style="margin-top:40px">
							<!-- <div class="book sm-hidden"><a href="###">View Details</a></div> -->
						</div>
						<div class="type"><?php echo   $listDest->cityName; ?></div>
					</article>
				</figcaption>
			</figure>
          </div>	
	<?php
    }
	}elseif (isset($listDestination1)) {
		foreach ($listDestination1->destName as $listDest)
       	{
       	?>
       		<div class="col-6">
          <figure class="tour">
			<img src="<?php echo $listDest->img ?>" style="height: 150px" alt="Bangkok for 6 days">
			<figcaption>
					<article>
						<header>
							<hgroup>
								<h4 style="margin-left:15px"><?php  echo $listDest->nameDest;?></h4>
							</hgroup>
						</header>
						<ol class="sm-hidden" style="margin-top:0px">
						</ol>
						<div class="buy" style="margin-top:40px">
							<!-- <div class="book sm-hidden"><a href="###">View Details</a></div> -->
						</div>
						<div class="type"><?php echo   $listDest->cityName; ?></div>
					</article>
				</figcaption>
			</figure>
          </div>	
    <?php
		}
	}
	?>
        </div>
		
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
				<li><a href="admin.php">Admin</a></li>
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