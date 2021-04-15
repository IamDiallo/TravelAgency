<?php 
	/* check if the post variable is not empty if not empty iniatialise the city attribut latitude, longitude...*/
	if(isset($_POST['donnee'])){
	 	$lat = $_POST['lat'];
	  	$long = $_POST['long'];
	 	$cityId = $_POST['cityId'];
	  	$cityName = $_POST['cityName'];
	}
	/*check of get variable is not empty */
	if (isset($_GET['viewDest'])) {
		$dest_id = $_GET['viewDest']; // initialise the destination id
	}
	if (isset($_GET['view'])) {
		$dest_id = $_GET['view'];
	}
   /*check of post variable is not empty */
	if (isset($_POST['add']) || isset($_POST['update'])) {
		$image = 'img/destination/'.$_FILES['mon_image']['name'];
		$idCity = $_POST['city'];
		$idTypeDest = $_POST['typeDest'];
		$name = $_POST['name'];
		
		//The XML string that you want to send.
		$xml = '<?xml version="1.0" encoding="UTF-8"?>
		<destination>
			<cityDest>'.$idCity.'</cityDest>
			<img>'.$image.'</img>
			<nameDest>'.$name.'</nameDest>
			<typeDest>'.$idTypeDest.'</typeDest>
		</destination>';
	}
	
	// get the wdsl url 
	$wsdl = 'http://localhost:8080/com.travel.webservice/services/TravelPort?wsdl';
	// set the wdsl cache to none
	$options = array('cache_wsdl' => WSDL_CACHE_NONE);

	// if the jaxws service is avaialble use the  jaxws service 
	try {
		// instantiate a Soap client and pass it the wdsl url and the options
		$clientSOAP = new SoapClient($wsdl, $options);
        
		// call the webservice and specify the operation that we want
		// get all countries
		$countries = $clientSOAP->__soapCall("getCountry",array());
        // get all destinations type
		$destinations = $clientSOAP->__soapCall("getDestinations",array());
        // get all cities
	    $cities = $clientSOAP->__soapCall("getCities",array());
		// get all destinations group
		$destGroup = $clientSOAP->__soapCall("getDestGroup",array());
	    
		// get all destinations 
		$AllDest = $clientSOAP->__soapCall("getAllDest",array());

		// get destination by id
		if (isset($_GET['update_id'])) {
			$param = new stdClass();
	        $param->id = $_GET['update_id'];
			$getDest = $clientSOAP->__soapCall("getDest",array($param));
		}
        
		// delete a destination
		if (isset($_GET['delete_id'])) {
			$idDest = $_GET['delete_id'];
             // Set request params
			$paramDest = new stdClass();
			$paramDest->id = $idDest;
			// get all destinations 
		    $deleteDest = $clientSOAP->__soapCall("deleteDest",array($paramDest));

		    header("Location: admin.php");
		}
		// check if the cityId is not empty then call the webservice 
    	if (isset($cityId)) {
			 // Set request params
			$paramCity = new stdClass();
			$paramCity->idCity = $cityId;
			// specify the operation and pass the parameter
			$destinationsCity = $clientSOAP->__soapCall("getDestinationsByCity",array($paramCity));
		}
		// check if the dest_id is not empty then call the webservice 
		if (isset($dest_id)) {
			 // Set request params
			$param = new stdClass();
	        $param->idDestType = $dest_id;
			// specify the operation and pass the parameter
			$listDestination = $clientSOAP->__soapCall("getDestinationName", array($param));
		}

		if (isset($_POST['add'])) {
			// call the webservice and specify the operation that we want
			// Set request params
			$paramDestination = new stdClass();
			$paramDestination->dest = $name;
			$paramDestination->typeDest = $idTypeDest;
			$paramDestination->city_id = $idCity;
			$paramDestination->img = $image;
		    $addDestination = $clientSOAP->__soapCall("addDest",array($paramDestination));

		    header("Location: admin.php");
		}

		if(isset($_POST['update'])) {
			// call the webservice and specify the operation that we want
			// Set request params
			$paramDestination = new stdClass();
			$paramDestination->dest = $name;
			$paramDestination->typeDest = $idTypeDest;
			$paramDestination->city_id = $idCity;
			$paramDestination->img = $image;
			$paramDestination->id = $_GET['update_id'];
		    $addDestination = $clientSOAP->__soapCall("updateDest",array($paramDestination));

		    header("Location: admin.php");
		}
	} 
	// if jaxws is not available then try to use jaxrs
	catch (SoapFault $fault) {
		try {
			// get the service url
			$url = 'http://localhost:8080/travels.management.web/api/travels'; 
			$cities1 = new SimpleXMLElement(file_get_contents($url.'/cities'));
			if (isset($cityId)) {
				$destinationsCity1 = new SimpleXMLElement(file_get_contents($url.'/city/'.$cityId));
			}

			//get destination types
			$destinations1 = new SimpleXMLElement(file_get_contents($url.'/typesDests'));


            $destGroup1 = new SimpleXMLElement(file_get_contents($url.'/destGroups'));

            // get a destination by by
            if(isset($_GET['update_id'])) {
            	$getDestination = new SimpleXMLElement(file_get_contents($url.'/'.$_GET['update_id']));
            }
			
			// get all destinations by type of destination
			if (isset($dest_id)) {
				
				$listDestination1 = new SimpleXMLElement(file_get_contents($url.'/destinations/'.$dest_id));
			}

			// add a destination
			if (isset($_POST['add'])) {
				
				//Initiate cURL
				$curl = curl_init($url);

				//Set the Content-Type to text/xml.
				curl_setopt ($curl, CURLOPT_HTTPHEADER, array("Content-Type: application/xml"));

				//Set CURLOPT_POST to true to send a POST request.
				curl_setopt($curl, CURLOPT_POST, true);

				//Attach the XML string to the body of our request.
				curl_setopt($curl, CURLOPT_POSTFIELDS, $xml);

				//Tell cURL that we want the response to be returned as
				//a string instead of being dumped to the output.
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

				//Execute the POST request and send our XML.
				$result = curl_exec($curl);

				//Do some basic error checking.
				if(curl_errno($curl)){
				    throw new Exception(curl_error($curl));
				}

				//Close the cURL handle.
				curl_close($curl);		 
			}

			// update a destination
			if(isset($_POST['update'])) {

				$url = $url.'/'.$_GET['update_id'];

				$curl = curl_init($url);
				$headers = array(
				   "Content-Type: application/xml",
				);
				curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);

				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
				curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "PUT");
				curl_setopt($curl, CURLOPT_POSTFIELDS, $xml);

				$response = curl_exec($curl);

				header("Location: admin.php");
			}
			
			// get all deestinations
			$curl = curl_init($url);
			curl_setopt($curl, CURLOPT_URL, $url);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

			$headers = array(
			   "Accept: application/xml",
			);
			curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);
			//for debug only!
			curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
			curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);

			$resp = curl_exec($curl);
			
			curl_close($curl);
			$AllDest1 = new SimpleXMLElement($resp);

			// Delete a destination
			if(isset($_GET['delete_id'])) {
				$url = $url.'/'.$_GET['delete_id'];
                #echo $url;
				$curl = curl_init($url);
				curl_setopt($curl, CURLOPT_URL, $url);
				curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "DELETE");
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
				//for debug only!
				curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
				curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);

				$resp = curl_exec($curl);
				curl_close($curl);

				header("Location: admin.php");
				
			}



		} catch (Exception $e) {
				echo $e->getMessage();
		}
	}
 ?>