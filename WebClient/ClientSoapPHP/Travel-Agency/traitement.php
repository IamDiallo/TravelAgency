<?php 
	/* Test d'appel a un WEBService */
	$wsdl = 'http://localhost:8080/com.travel.webservice/services/TravelPort?wsdl';
	$options = array('cache_wsdl' => WSDL_CACHE_NONE);

	try {
		$clientSOAP = new SoapClient($wsdl, $options);
		
	} catch (SoapFault $fault) {
		trigger_error("SOAP Fault: (faultcode: {$fault->faultcode}, faultstring: {$fault->faultstring})", E_USER_ERROR);
	}
	
	$countries = $clientSOAP->__soapCall("getCountry",array());
	//$destinations = $clientSOAP->__soapCall("getAllDestinations",array());
	// print_r($cities);
	if (isset($countries)) {
		foreach ($countries->result as $country){
			echo $country->name;
			echo "----------";
		}
	}
	$destinations = $clientSOAP->__soapCall("getDestinations",array());
	// print_r($cities);
	if (isset($destinations)) {
		foreach ($destinations->result as $dest){
			echo $dest->destType;
			echo "----------";
		}
	}

	//$array = json_decode(json_encode($cities), true);
	//var_dump( (array) $cities );
	//print_r($array);
	// if(isset($cities)){ 
	// 	print_r($cities);
	// 	echo "<br>";
  	// 	foreach ($cities->return as $ct){
  	// 		echo($ct->countryName);
  	// 		echo "<br>";
    // 	 } 
	// } 
	
 ?>