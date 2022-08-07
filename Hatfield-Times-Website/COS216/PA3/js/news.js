//I chose an asynchronous function in the java script because i found that the page runs and loads faster when the function doesnt have to wait for the API to return data and instead
//load other elements of the page first while the callback is made to the API, this method is beneficial to the site because we can load most elements without the API data
//which is populated after the page has loaded and API data is recieved.
var api_url = 'https://api.thenewsapi.com/v1/news/all?api_token=dk0R0SrHCgiIqKLfJW0nuWQO5aEGAXBw9p7TydhK&language=en';

async function pubdate(val){
    console.log(val);
    api_url = 'https://api.thenewsapi.com/v1/news/all?api_token=dk0R0SrHCgiIqKLfJW0nuWQO5aEGAXBw9p7TydhK&language=en&published_on='+val;
    console.log(api_url);
    getArticles();
}

async function Search(){
    var val = document.getElementById("search").value;
    console.log(val);
    api_url = 'https://api.thenewsapi.com/v1/news/all?api_token=dk0R0SrHCgiIqKLfJW0nuWQO5aEGAXBw9p7TydhK&language=en&search='+val;
    console.log(api_url);
    getArticles();
}

async function pol(){
    var val = "politics";
    console.log(val);
    api_url = 'https://api.thenewsapi.com/v1/news/all?api_token=dk0R0SrHCgiIqKLfJW0nuWQO5aEGAXBw9p7TydhK&language=en&categories='+val;
    console.log(api_url);
    getArticles();
}

async function ent(){
    var val = "entertainment";
    console.log(val);
    api_url = 'https://api.thenewsapi.com/v1/news/all?api_token=dk0R0SrHCgiIqKLfJW0nuWQO5aEGAXBw9p7TydhK&language=en&categories='+val;
    console.log(api_url);
    getArticles();
}

async function tech(){
    var val = "tech";
    console.log(val);
    api_url = 'https://api.thenewsapi.com/v1/news/all?api_token=dk0R0SrHCgiIqKLfJW0nuWQO5aEGAXBw9p7TydhK&language=en&categories='+val;
    console.log(api_url);
    getArticles();
}

async function getArticles() {
    const xhttp = new XMLHttpRequest();
    const response = await fetch(api_url);
    const results = await response.json();
    console.log(results.data);

//---------------
    const n = document.getElementById('news');
    var date=results.data[0].published_at;
    const imgData = `<br><img src=${results.data[0].image_url} width="500" style="center"/>`;
    const body = `<br><a href=${results.data[0].url} class="strokeme">${results.data[0].title}</a>`+
    `<h5>${date.substring(0,10)}</h5>`+
    `<h5>${results.data[0].source}</h5>`+
    `<h5>Keywords: ${results.data[0].categories[0]}</h5>`+
    `<h5>${results.data[0].snippet}</h5>`;

    n.innerHTML = imgData + body;
//---------------
    const n1 = document.getElementById('news1');
    date=results.data[1].published_at;
    const imgData1 = `<br><img src=${results.data[1].image_url} width="500" style="center"/>`;
    const body1 = `<br><a href=${results.data[1].url} class="strokeme">${results.data[1].title}</a>`+
    `<h5>${date.substring(0,10)}</h5>`+
    `<h5>${results.data[1].source}</h5>`+
    `<h5>Keywords: ${results.data[1].categories[0]}</h5>`+
    `<h5>${results.data[1].snippet}</h5>`;

    n1.innerHTML = imgData1 + body1;
//---------------
    const n2 = document.getElementById('news2');
    date=results.data[2].published_at;
    const imgData2 = `<br><img src=${results.data[2].image_url} width="500" style="center"/>`;
    const body2 = `<br><a href=${results.data[2].url} class="strokeme">${results.data[2].title}</a>`+
    `<h5>${date.substring(0,10)}</h5>`+
    `<h5>${results.data[2].source}</h5>`+
    `<h5>Keywords: ${results.data[2].categories[0]}</h5>`+
    `<h5>${results.data[2].snippet}</h5>`;

    n2.innerHTML = imgData2 + body2;
//---------------
    const n3 = document.getElementById('news3');
    date=results.data[3].published_at;
    const imgData3 = `<br><img src=${results.data[3].image_url} width="500" style="center"/>`;
    const body3 = `<br><a href=${results.data[3].url} class="strokeme">${results.data[3].title}</a>`+
    `<h5>${date.substring(0,10)}</h5>`+
    `<h5>${results.data[3].source}</h5>`+
    `<h5>Keywords: ${results.data[3].categories[0]}</h5>`+
    `<h5>${results.data[3].snippet}</h5>`;

    n3.innerHTML = imgData3 + body3;
//---------------
    const n4 = document.getElementById('news4');
    date=results.data[4].published_at;
    const imgData4 = `<br><img src=${results.data[4].image_url} width="500" style="center"/>`;
    const body4 = `<br><a href=${results.data[4].url} class="strokeme">${results.data[4].title}</a>`+
    `<h5>${date.substring(0,10)}</h5>`+
    `<h5>${results.data[4].source}</h5>`+
    `<h5>Keywords: ${results.data[4].categories[0]}</h5>`+
    `<h5>${results.data[4].snippet}</h5>`;

    n4.innerHTML = imgData4 + body4;
}
getArticles()

