<?php 
	/* Test d'appel a un WEBService */
	if(isset($_POST['donnee'])){
	 	$lat = $_POST['lat'];
	  	$long = $_POST['long'];
	 	$cityId = $_POST['cityId'];
	  	$cityName = $_POST['cityName'];
	}
	 
	if (isset($_GET['viewDest'])) {
		$dest_id = $_GET['viewDest'];
	}
	
	
	$wsdl = 'http://localhost:8080/com.travel.webservice/services/TravelPort?wsdl';
	$options = array('cache_wsdl' => WSDL_CACHE_NONE);

	try {
		$clientSOAP = new SoapClient($wsdl, $options);

		$countries = $clientSOAP->__soapCall("getCountry",array());

		$destinations = $clientSOAP->__soapCall("getDestinations",array());

	    $cities = $clientSOAP->__soapCall("getCities",array());
	    // Set request params
	    $param = new stdClass();
	    $param->idDestType = 1;
	   	$listDestination = $clientSOAP->__soapCall("getDestinationName", array($param));
	    
    	if (isset($cityId)) {
			$paramCity = new stdClass();
			$paramCity->idCity = $cityId;
			$destinationsCity = $clientSOAP->__soapCall("getDestinationsByCity",array($paramCity));
		}

		if (isset($dest_id)) {
			$param = new stdClass();
	        $param->idDestType = $dest_id;
			$listDestination = $clientSOAP->__soapCall("getDestinationName", array($param));
		}
			
	} catch (SoapFault $fault) {
		//trigger_error("SOAP Fault: (faultcode: {$fault->faultcode}, faultstring: {$fault->faultstring})", E_USER_ERROR);
		try {
			$url = 'http://localhost:8080/travels.management.web/api/travels/'; 
			$cities1 = new SimpleXMLElement(file_get_contents($url.'cities'));
			if (isset($cityId)) {
				$destinationsCity1 = new SimpleXMLElement(file_get_contents($url.'city/'.$cityId));
			}

			$destinations1 = new SimpleXMLElement(file_get_contents($url.'typesDests'));

			if (isset($dest_id)) {
				
				$listDestination1 = new SimpleXMLElement(file_get_contents($url.'destinations/'.$dest_id));
			}
			// echo "<pre>";
			// 	print_r($listDestination);
			// echo "</pre>";

		} catch (Exception $e) {
				echo $e->getMessage();
		}
	}



	

	
	
	
 ?>