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
			<h2>Number of Destinations of Cities</h2>
			<div class="tag">
				<ul>
				<?php 
				if (isset($destGroup)) {
				foreach ($destGroup->result as $group){?>
				<form action="">
						<li><a href="#"><?php echo $group->cityName ."(".$group->destCount.")"?></a></li>		
					<?php }
			    }
				elseif(isset($destGroup1)){
				foreach ($destGroup1->DestGroup as $group1){?>
				<form action="">
						<li><a href="#"><?php echo $group1->cityName ."(".$group1->destCount.")"?></a></li>	
					<?php }
				}?>
				</ul>
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
							</hgroup>
						</header>
						<ol class="sm-hidden">
						</ol>
						<div class="buy" style="margin-top:70px; margin-right:20px">
							<div class="book sm-hidden"><a href="viewDestType.php?viewDest=<?= $dest->id ?>">View List</a></div>
						</div>
					</article>
				</figcaption>
			</figure>
	<?php }
		}elseif (isset($destinations1)) 
		{
			foreach ($destinations1->destType as $dest)
	       	{
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
						</ol>
						<div class="buy" style="margin-top:70px; margin-right:20px">
							<div class="book sm-hidden"><a href="viewDestType.php?viewDest=<?= $dest->id ?>">View List</a></div>
						</div>
					</article>
				</figcaption>
			</figure>

	   <?php
			}
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