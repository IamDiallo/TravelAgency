<?php 
	include("traitement.php");
    $dest_id = $_GET['viewDest'];
    echo $dest_id;
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
				<li><a href="index.html">Home</a></li>
				<li class="active"><a href="tour.html">Tours</a></li>
				<li><a href="flight.html">Flights</a></li>
				<li><a href="gallery.html">Gallery</a></li>
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
			<h2>Travel Info</h2>
			<h3>The latest travel information, news, and tips.</h3>
		</hgroup>
</div>
<div id="container">
	<div class="list information" style="width: 100%">
		<h2>Travel information</h2>
        <div class="row">
        <?php 
        $param = new stdClass();
        $param->idDestType = $dest_id;
        try {
		$listDestination = $clientSOAP->__soapCall("getDestName", array($param));
		if (isset($listDestination)) {
			foreach ($listDestination->result as $listDest){
          ?>
          <div class="col-6">
          <figure class="tour">
			<img src="img/tour1.jpg" alt="Bangkok for 6 days">
			<figcaption>
					<article>
						<header>
							<hgroup>
								<h4 style="margin-left:15px"><?php  echo $listDest->nameDest;?></h4>
								<!-- <h6 class="sm-hidden">Special for group travelling with no extra cost...</h6> -->
							</hgroup>
						</header>
						<ol class="sm-hidden" style="margin-top:0px">
							<li><em>Flight</em> Southern Airlines, non-stop</li>
							<li><em>Date</em> 11/01, 11/05, 11/08...</li>
						</ol>
						<div class="buy" style="margin-top:50px">
							<!-- <div class="price">$<strong>1864</strong> <s>$2980</s></div> -->
							<div class="book sm-hidden"><a href="###">View Details</a></div>
						</div>
						<div class="type"><?php echo   $listDest->cityName; ?></div>
						<!-- <div class="disc"><span>35%Off</span></div> -->
						<!-- <footer class="sm-hidden">
							The special price will end at <time>01/10/2016</time>
						</footer> -->
					</article>
				</figcaption>
			</figure>
          </div>
			
	<?php
    }
	  }

    } catch(Exception $e) {
        var_dump($e);
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
			<h2>Partnership</h2>
			<hr>
			<ul>
				<li><a href="###">YHA China</a></li>
				<li><a href="###">Qunar Travel</a></li>
				<li><a href="###">Ali Trip</a></li>
				<li><a href="###">Youth Travel Service</a></li>
			</ul>
		</div>
		<div class="column mid">
			<h2>FAQ</h2>
			<hr>
			<ul>
				<li><a href="###">When shall I sign the contract.</a></li>
				<li><a href="###">How about the discount for children.</a></li>
				<li><a href="###">What is the best time travel to Australia.</a></li>
				<li><a href="###">How many kinds of travel insurance.</a></li>
				<li><a href="###">Can I change the date, is that free.</a></li>
			</ul>			
		</div>
		<div class="column right">
			<h2>Contact</h2>
			<hr>
			<ul>
				<li><a href="###">Email: info@dreamtour.com</a></li>
				<li><a href="###">Phone: 010-23504668.</a></li>
				<li><a href="###">Address: 33 Nanjing rd, Beijing, China.</a></li>
			</ul>			
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="bottom">Copyright &copy; Dream Tour 2016 | Developed by Bright</div>
</footer>
<!-- footer end -->
</body>
</html>