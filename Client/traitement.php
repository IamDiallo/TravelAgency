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
	if (isset($_GET['view'])) {
		$dest_id = $_GET['view'];
	}

	if (isset($_POST['add'])) {
		$image = 'img/destination/'.$_FILES['mon_image']['name'];
		$idCity = $_POST['city'];
		$idTypeDest = $_POST['typeDest'];
		$name = $_POST['name'];
	}
	
	
	$wsdl = 'http://localhost:8080/com.travel.webservice/services/TravelPort?wsdl';
	$options = array('cache_wsdl' => WSDL_CACHE_NONE);

	try {
		$clientSOAP = new SoapClient($wsdl, $options);

		$countries = $clientSOAP->__soapCall("getCountry",array());

		$destinations = $clientSOAP->__soapCall("getDestinations",array());

	    $cities = $clientSOAP->__soapCall("getCities",array());
		$destGroup = $clientSOAP->__soapCall("getDestGroup",array());
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
			$url = 'http://localhost:8080/travels.management.web/api/travels'; 
			$cities1 = new SimpleXMLElement(file_get_contents($url.'/cities'));
			if (isset($cityId)) {
				$destinationsCity1 = new SimpleXMLElement(file_get_contents($url.'/city/'.$cityId));
			}

			$destinations1 = new SimpleXMLElement(file_get_contents($url.'/typesDests'));
            $destGroup1 = new SimpleXMLElement(file_get_contents($url.'/destGroups'));
			// print_r($destGroup1);
			if (isset($dest_id)) {
				
				$listDestination1 = new SimpleXMLElement(file_get_contents($url.'/destinations/'.$dest_id));
			}
			if (isset($name)) {
				//The XML string that you want to send.
					$xml = '<?xml version="1.0" encoding="UTF-8"?>
					<destination>
						<cityDest>'.$idCity.'</cityDest>
						<img>'.$image.'</img>
						<nameDest>'.$name.'</nameDest>
						<typeDest>'.$idTypeDest.'</typeDest>
					</destination>';
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
			$AllDest = new SimpleXMLElement($resp);
			
			if (isset($_GET['idDest'])) {
				$idDest = $_GET['idDest'];
				$url = $url.'/'.$idDest;

				$curl = curl_init($url);
				curl_setopt($curl, CURLOPT_URL, $url);
				curl_setopt($curl, CURLOPT_DELETE, true);
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

				//for debug only!
				curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
				curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);

				$resp = curl_exec($curl);
				curl_close($curl);
				var_dump($resp);
			}


		} catch (Exception $e) {
				echo $e->getMessage();
		}
	}



	

	
	
	
 ?>