<?php 
	/* Test d'appel a un WEBService */
	$wsdl = 'http://localhost:8080/com.travel.webservice/services/TravelPort?wsdl';
	$options = array('cache_wsdl' => WSDL_CACHE_NONE);

	try {
		$clientSOAP = new SoapClient($wsdl, $options);
        //var_dump($clientSOAP->__getFunctions());
		
	} catch (SoapFault $fault) {
		trigger_error("SOAP Fault: (faultcode: {$fault->faultcode}, faultstring: {$fault->faultstring})", E_USER_ERROR);
	}
	
	$countries = $clientSOAP->__soapCall("getCountry",array());
	$destinations = $clientSOAP->__soapCall("getDestinations",array());
    $cities = $clientSOAP->__soapCall("getCities",array());
    // Set request params
    $param = new stdClass();
    $param->idDestType = 1;
    try {
        $listDestination = $clientSOAP->__soapCall("getDestinationName", array($param));
    } catch(Exception $e) {
        var_dump($e);
    }
    #print_r($clientSOAP->__getLastRequest());

	$destinationsCity = $clientSOAP->__soapCall("getDestinationsByCity",array());
	// #print_r($cities);
	// if (isset($cities)) {
	// 	foreach ($cities->result as $cit){
	// 		echo $cit->name;
    //         echo $cit->countryName;
    //         #echo $cit->countryName;
	// 		echo "----------";
	// 	}
	//}
	
 ?>