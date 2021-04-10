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
			<h2>Destination Category</h2>
			<h3>Below Are a List of Destination Types</h3>
		</hgroup>
</div>
<!-- headline end -->

<!-- mainbody start -->
<div id="container">
	<aside class="sidebar">
		<div class="side dest">
			<h2>Destinations</h2>
			<div class="tag">
				<ul>
					<li><a href="###">Bangkok(7)</a></li>
					<li><a href="###">Tokyo(5)</a></li>
					<li><a href="###">Seoul(6)</a></li>
					<li><a href="###">Bali(3)</a></li>
					<li><a href="###">Turkey(6)</a></li>
					<li><a href="###">Hawaii(3)</a></li>
					<li><a href="###">Mauritius(2)</a></li>
					<li><a href="###">Greece(1)</a></li>
					<li><a href="###">Maldives(5)</a></li>
					<li><a href="###">Egypt(2)</a></li>
					<li><a href="###">Dubai(7)</a></li>
					<li><a href="###">Srilanka(6)</a></li>
					<li><a href="###">Manhattan(3)</a></li>
					<li><a href="###">Osaka(4)</a></li>
					<li><a href="###">HongKong(2)</a></li>
					<li><a href="###">Malaysia(8)</a></li>
					<li><a href="###">France(7)</a></li>
					<li><a href="###">Germany(5)</a></li>
					<li><a href="###">Canada(11)</a></li>
					<li><a href="###">Australia(9)</a></li>
					<li><a href="###">Singapore(4)</a></li>
				</ul>
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
	<div class="list information">
		<h2>Travel information</h2>
		<?php 
		if (isset($destinations)) {
			foreach ($destinations->result as $dest){
          ?>
			<figure class="tour">
				<img src="<?php echo $dest->img_link ?>" alt="Bangkok for 6 days">
			<figcaption>
					<article>
						<header>
							<hgroup>
								<h2><?php echo $dest->destType;?></h2>
								<h3 class="sm-hidden">Special for group travelling with no extra cost...</h3>
							</hgroup>
						</header>
						<ol class="sm-hidden">
							<!-- <li><mark>Flight</mark> Southern Airlines, non-stop</li> -->
							<!-- <li><mark>Date</mark> 11/01, 11/05, 11/08...</li> -->
						</ol>
						<div class="buy" style="margin-top:70px; margin-right:20px">
							<!-- <div class="price">$<strong>1864</strong></div> -->
							<div class="book sm-hidden"><a href="viewDestType.php?viewDest=<?= $dest->id ?>">View List</a></div>
						</div>
						<div class="type">Popular</div>
						<!-- <div class="disc"><span>35%Off</span></div> -->
						<!-- <footer class="sm-hidden">
							The special price will end at <time>01/10/2016</time>
						</footer> -->
					</article>
				</figcaption>
			</figure>
	<?php }
		}
		?>
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
</body>
</html>