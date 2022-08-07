//I chose an asynchronous function in the java script because i found that the page runs and loads faster when the function doesnt have to wait for the API to return data and instead
//load other elements of the page first while the callback is made to the API, this method is beneficial to the site because we can load most elements without the API data
//which is populated after the page has loaded and API data is recieved.
const api_url = 'https://disease.sh/v3/covid-19/all';

async function render() {
    const xhttp = new XMLHttpRequest();
    const scroll = document.getElementById('scroll');
    scroll.innerHTML='<marquee behavior="scroll" direction="right"><h3 style="color: #528AAE;">COVID-19 Newest Data</h3></marquee>'
    const response = await fetch(api_url);
    const results = await response.json();
    console.log(results);

//---------------
    const n = document.getElementById('deductions');
    const n2 = document.getElementById('stats');
    const data = '<h5>Overall COVID Cases: '+results.cases+'</h5>'+
    '<h5>Overall COVID Recoveries: '+results.recovered+'</h5>'+
    '<h5>Overall COVID Deaths: '+results.deaths+'</h5>'+
    '<h5>Daily Cases Stats: '+results.todayCases+'</h5>';
    n2.innerHTML += data;

    var infected= results.todayCases;
    var dead= results.todayDeaths;
    var ifr=dead/infected*100;
    infected= results.cases;
    dead= results.deaths;
    var cfr=dead/infected*100;
    const data2 = '<h5>IFR - Infection Fatality Ratio: '+ifr.toFixed(2)+'%</h5>'+
    '<h5>CFR - Case Fatality Ratio: '+(cfr*2).toFixed(2)+'%</h5>'+
    '<h5>Mortality Rate: '+cfr.toFixed(2)+'%</h5>'+
    '<h5>Cases:Recoveries:Death Ratio: '+results.cases+':'+dead+':'+results.recovered+'</h5>';

    n.innerHTML += data2;
}
render()