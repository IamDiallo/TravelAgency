      /// OpenWeatherMap API. Do not share it publicly.
      const api = 'cf3b11c7586d99f6b2c42cb25283ccfb';
      //DOM elements 
      const tempC = document.querySelector('.c');
      const desc = document.querySelector('.desc');
      const sunriseDOM = document.querySelector('.sunrise');
      const sunsetDOM = document.querySelector('.sunset');
      
      // check for the event load of the page
      window.addEventListener('load', () => {
        // get the the value of the element latitude and longitude from the DOM
        const citLat = document.getElementById("lat").value;
        const citLong = document.getElementById("long").value;
        
        // change their declaration type from constante to let so we can reassigne them
        let long = citLong;  
        let lat =   citLat;
        ///console.log("lat:"+lat + "long:" + long);
        // call the weather API
        const base = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${api}&units=metric`;
        // Using fetch to get data
        fetch(base)
          .then((response) => {
            return response.json();
          })
          .then((data) => {
            //get the data needed in the response
            const { temp } = data.main; // temperature
            const place = data.name; // location
            const { description, icon } = data.weather[0]; 
            const { sunrise, sunset } = data.sys;
          
            // Converting Epoch(Unix) time to GMT
            const sunriseGMT = new Date(sunrise * 1000);
            const sunsetGMT = new Date(sunset * 1000);
            
            desc.textContent = `${description}`;
            tempC.textContent = `${temp.toFixed(2)} °C`;
            // get sunrise and sunset date and time
            sunriseDOM.textContent = `${sunriseGMT.toLocaleDateString()}, ${sunriseGMT.toLocaleTimeString()}`;
            sunsetDOM.textContent = `${sunsetGMT.toLocaleDateString()}, ${sunsetGMT.toLocaleTimeString()}`;
          });
      });