<?php 
	include("traitement.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" href="css/bootstrap/js/bootstrap.min.js"></script>
    <title>Document</title>
</head>
<style>
    @import url('https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500');

body {
  overflow-x: hidden;
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
}

/* Toggle Styles */
#viewport {
  padding-left: 250px;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#content {
  width: 100%;
  position: relative;
  margin-right: 0;
}

/* Sidebar Styles */

#sidebar {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 250px;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: #215169;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#sidebar header {
  background-color: #F39539;
  font-size: 20px;
  line-height: 52px;
  color: black;
  text-align: center;
}

#sidebar header a {
  color: #fff;
  display: block;
  text-decoration: none;
}

#sidebar header a:hover {
  color: #fff;
}

#sidebar .nav{
  
}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 7px 7px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
#sidebar .nav a{
  background: none;
  border-bottom: 1px solid #455A64;
  color: #CFD8DC;
  font-size: 14px;
  padding: 16px 24px;
}

#sidebar .nav a:hover{
  background: none;
  color: #ECEFF1;
}

#sidebar .nav a i{
  margin-right: 16px;
}
#bar{
  background: #215169;
  color: white;
}
a{
  /* text-decoration: none; */
  text-decoration: inherit; /* no underline */
}
</style>
<body>
<div id="viewport">
  <!-- Sidebar -->
  <div id="sidebar">
    <header>
      <a href="index.php">Travel Agency</a>
    </header>
    <ul class="nav">
      <li>
        <a href="#">
          <i class="zmdi zmdi-view-dashboard"></i> Tableau de bord
        </a>
      </li>
      <li>
        <a href="#">
          <i class="zmdi zmdi-widgets"></i> Add Destination
        </a>
      </li>
    </ul>
  </div>
  <!-- Content -->
  <div id="content">
    <nav class="navbar navbar-default" id="bar">
      <div class="container-fluid">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="#"><i class="icofont-logout" style="color:white; wh"></i></i>
            </a>
          </li>
          <li><a href="logout.php" style="color:white" 
         >Déconnexion</a></li>
        </ul>
      </div>
    </nav>
    <div class="container-fluid">
      <h1>Admin Board</h1>
      <div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <div class="panel-title" style="font-size:30px; display:flex">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1" style="text-decoration: none;">
            Add Destination
        </a>
      </div>
    </div>
    <div id="collapse1" class="panel-collapse collapse in">
      <div class="panel-body">
        <form method="post" action="#" enctype="multipart/form-data">
          <div class="form-group">
            <label>Image</label>
            <input type="file" name="mon_image" />
          </div>
          <div class="form-group">
            <label>City</label>
            <select class="form-control" name="city">
              <?php if(isset($cities1)){
                foreach ($cities1->City as $cit){ ?>
                  <option value="<?php echo $cit->id; ?>"><?php echo $cit->name; ?></option>
              <?php }} ?>
            </select>
          </div>
          <div class="form-group">
            <label>Destination Type</label>
            <select class="form-control" name="typeDest">
              <?php if (isset($destinations1)) {
                foreach ($destinations1->destType as $dest){
              ?>
                <option value="<?php echo $dest->id; ?>" ><?php echo $dest->destType; ?></option>
              <?php }} ?>
            </select>
          </div>
          <div class="form-group">
            <label>Name</label>
            <input class="form-control" type="text" name="name">
          </div>

          <button type="submit"  name="add" class="btn btn-primary">Save</button>
        </form>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <div class="panel-title" style="font-size:30px">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" style="text-decoration: none;">
        Liste des destinations</a>
      </div>
    </div>
    <div id="collapse3" class="panel-collapse collapse">
      <form>
        <table id="example2"  class="table table-bordered" style="width:100%; margin-top:20px">
                <thead>
                    <tr>
                      <th>ID</th>
                      <th>NAME</th>
                      <th>TYPE</th>
                      <th>CITY</th>
                      <th>DELETE</th>
                    </tr>
                </thead>
                <tbody>
                  <?php if (isset($AllDest)) 
                    {
                      foreach ($AllDest->destName as $listDest){
                      ?>
                      <tr>
                        <td><?php echo $listDest->id; ?></td>
                        <td><?php echo $listDest->nameDest;?></td>
                        <td><?php echo $listDest->nameTypeDest;?></td>
                        <td><?php echo $listDest->cityName;?></td>
                        <td><button type="submit" class="btn btn-danger"><a href="admin.php?idDest=<?php echo $listDest->id; ?>"  style="color: none;">DELETE</a></button></td>
                      </tr>
                  <?php }} ?>
                </tbody>
            </table>
          </form>
      </div>
  </div>
</div>
    </div>
  </div>
</div>
  <script>
       $(document).ready(function() {
       $('#example2').DataTable({
        "order": [[ 3, "desc" ]],
       })      
       } );
       $(document).ready(function() {
       $('#example').DataTable({
        "order": [[ 3, "desc" ]],
       })      
       } );
  </script>
  <script>
    function hideMessage() {
    document.getElementById("msg").style.display = "none";
    };
    setTimeout(hideMessage, 6000);
  </script>
</body>
</html>