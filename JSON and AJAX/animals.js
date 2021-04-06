var pageCounter = 1;
var emptyDiv = document.getElementById("animal-info");
var button = document.getElementById("btn");



button.addEventListener("click", function () {

    // AJAX - Asynchronous Javascript And XML
    var ourRequest = new XMLHttpRequest();

    // If you want to recieve data use 'GET'
    // If you want to recieve data use 'POST'
    // Then the url you want to get JSON data from
    ourRequest.open('GET', 'https://learnwebcode.github.io/json-example/animals-' + pageCounter + '.json');

    ourRequest.onload = function () {
        if (ourRequest.status >= 200 && ourRequest.status < 400) {
            var ourData = JSON.parse(ourRequest.responseText);
            renderHTML(ourData);
        } else {
            alert('The server returned an error.');
        }

    };

    ourRequest.onerror = function () {
        alert('Connection error');
    }

    ourRequest.send();
    pageCounter++;
    if (pageCounter > 3) {
        button.classList.add("hide-me");
    }
});

// This function will add our data to our empty div element
function renderHTML(data) {
    var htmlString = '';

    for (i = 0; i < data.length; i++) {
        htmlString += '<p>' + data[i].name + ' is a ' + data[i].species + ' that loves to eat ';

        for (j = 0; j < data[i].foods.likes.length; j++) {
            if (j == 0) {
                htmlString += data[i].foods.likes[j];
            } else {
                htmlString += ' and ' + data[i].foods.likes[j];
            }
        }
        htmlString += ' and hates ';
        for (k = 0; k < data[i].foods.dislikes.length; k++) {
            if (k == 0) {
                htmlString += data[i].foods.dislikes[k];
            } else {
                htmlString += ' and ' + data[i].foods.dislikes[k];
            }
        }
        htmlString += ".</p>"
    }
    emptyDiv.insertAdjacentHTML('beforeend', htmlString);
}
