<h1>Travel Agency:DIAMS</h1>
We provide a web service for travel agency following the protocol of SOAP and the Rest Architeture. The service was built into two different frameworks in Java JAXWS and JAXRS. Besides the service, we built a client in php that consumes both services depending of the availability of the service by default it calls the JAXWS service if the service called is down it automatically use the JAXRS service
<h2>A.1. Service Description:</h2>
   The service that we provide is composed of 10 operations. 
    <h3>1.getCountries:</h3>   
      This operations return all the countries that our travel agency is serving.
    <h3>2.getCities</h3>   
       This operations return all the cities that our travel agency is serving.
    <h3>3.getDestinationsByCity:</h3>  
       This operations return all the destinations that our travel agency is serving and group them by city.
   <h3>4.getDestinations:</h3>
        This operations return all the destinations that our travel agency is serving and group them by type of destinations.
    <h3>5.Add Destination:</h3> 
   This operation allows you to dynamically add a destination
    <h3>6.Delete Destinations:</h3>  
       This operation allows you to dynamically delete a destination without losing any data.
    <h3>7.Update Destinations Info:</h3>  
       This operation allows you to dynamically update a destination.
    <h3>And other Operations...:</h3> 
        for getting all destinations, all cities, number of destinations of a cities
    <hr>
<h2>A.2 WDSL:</h2>
 The wdsl file describes how our webservice should be called it is generated based on the annotation that we added in the interface class where we added the annotation of the @WebService, @WebMethod, @WebResult and @PathParm. We also specified the portName of our service, targetNameSpace, endpointInterface that the wsdl will use to generate the types, message, portType, the binding and the webservice name.
<h2>B.Client:</h2>
The client which was written in php has an interactive interface built with html and css where the client can find cities by countries, destinations to visit, information on destinations and cities.
Furthermore, we built an interface for the admin where it is possible to dynamically add destinations, update destination's info.
<h2>C.Weather Service:</h2>
We also called the openweathermap API that gives the weather condition of each city that we serve. Information such the temperature, the date and time of sunset and sunrise and the sky description.
<h2>D.Use Case:</h2>
for example if a person wants to in holliday in europe, the user firstly can go through a list of countries that we provide our travel service. For each country, there are a list of cities that we provide information. For each city, the user can get all destination available in that city: montaign, beaches, zoo, monuments, forest, parc and that city. Before visiting, the user can also check what is the weather condition of the city like the temperature, weather the sky is clear....
For the admin he can easily add destination if the a city or remove a destination it they no longuer serve there.
<h2>Group Members: </h2> 
  Name:DIALLO Mamadou Bella  </br>
  Email: mamadou-bella.diallo9@etu.cyu.fr  </br>
  Name:DIAWARE Mourtalla Faty  </br>
  Email: mourtalla-faty.diawara@etu.cyu.fr 
