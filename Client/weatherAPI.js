      /// OpenWeatherMap API. Do not share it publicly.
      const api = 'cf3b11c7586d99f6b2c42cb25283ccfb'; //Replace with your API
      // const iconImg = document.getElementById('weather-icon');
      const tempC = document.querySelector('.c');
      const desc = document.querySelector('.desc');
      const sunriseDOM = document.querySelector('.sunrise');
      const sunsetDOM = document.querySelector('.sunset');
      
      window.addEventListener('load', () => {
        const citLat = document.getElementById("lat").value;
        const citLong = document.getElementById("long").value;
        let long = citLong;
        let lat =   citLat;
        console.log("lat:"+lat + "long:" + long);
        const base = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${api}&units=metric`;
        // Using fetch to get data
        fetch(base)
          .then((response) => {
            return response.json();
          })
          .then((data) => {
            console.log(data);
            const { temp } = data.main;
            const place = data.name;
            const { description, icon } = data.weather[0];
            const { sunrise, sunset } = data.sys;
      
            const fahrenheit = (temp * 9) / 5 + 32;
            //console.log("Retour Donnèes:" + temp);
             // console.log("Retour Donnèes fahrenheit:" + fahrenheit);
            // Converting Epoch(Unix) time to GMT
            const sunriseGMT = new Date(sunrise * 1000);
            const sunsetGMT = new Date(sunset * 1000);
            
            desc.textContent = `${description}`;
            tempC.textContent = `${temp.toFixed(2)} °C`;
            sunriseDOM.textContent = `${sunriseGMT.toLocaleDateString()}, ${sunriseGMT.toLocaleTimeString()}`;
            sunsetDOM.textContent = `${sunsetGMT.toLocaleDateString()}, ${sunsetGMT.toLocaleTimeString()}`;
          });
      });