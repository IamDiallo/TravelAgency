<?php 
	include("traitement.php");
 ?>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
	<title>Travel Agency</title>
	 <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    .menu {
      background-color: #f1f1f1;
      height: 50px;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
	<div class="container-fluid">
	  <div class="row content">
	    <div class="col-sm-3 sidenav">
	    	<div class="input-group" style="margin-top: 10px;">
	        <input type="text" class="form-control" placeholder="City or Destination..">
	        <span class="input-group-btn">
	          <button class="btn btn-default" type="button">
	            <span class="glyphicon glyphicon-search"></span>
	          </button>
	        </span>
	      </div>
	      <h4>Pays</h4>
	      <ul class="nav nav-pills nav-stacked">
			<?php if(isset($countries)){ ?>
			<?php foreach ($countries->result as $country){ ?>
		    <li class="active" >
				<a href="index.php?chercher=<?= $country->name ?>"><?php echo $country->name; ?></a>
			</li>
			<?php } ?>
			<?php } else{ ?>
			<li>No Country Was Returned</li>
			<?php } ?>
	      </ul><br>
	      <h4>Destinatison</h4>
	      <ul class="nav nav-pills nav-stacked">
		  <?php if(isset($destinations)){ ?>
			<?php foreach ($destinations->result as $dest){ ?>
		    <li class="active" >
				<a href="index.php?chercher=<?= $dest->destType ?>"><?php echo $dest->destType; ?></a>
			</li>
			<?php } ?>
			<?php } else{ ?>
			<li>No Country Was Returned</li>
			<?php } ?>
	      </ul><br>
	      
	    </div>

	    <div class="col-sm-9">
	    	<h2><center>Travel Agengy</center></h2>
	  		<hr>
	  		<div class="row">
				<div class="col-md-8">
			    <div class="thumbnail">
				<img src="images/franceTouristMap.jpeg" usemap="#image-map" width=700 height=532">
				<map name="image-map">
					<area target="" alt="Paris" title="Paris" href="paris.html" coords="374,180,41" shape="circle">
					<area target="" alt="Marseille" title="Marseille" href="marseille.html" coords="462,416,40" shape="circle">
					<area target="" alt="Lyon" title="Lyon" href="lyon.html" coords="467,294,52" shape="circle">
				</map>
			  </div>
			</div>
	    </div>
	  </div>
	</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
</body>
</html>