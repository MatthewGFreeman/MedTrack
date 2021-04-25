let loggedInUser = document.cookie;
let userId = parseInt(loggedInUser.split('=')[1]);
let tableElement = document.getElementById('viewRecordsTable');
let shotLocations = {
    1 : "Right Arm",
    2 : "Left Arm",
    3 : "Right Leg",
    4 : "Left Leg",
    5 : "Right Hip",
    6 : "Left Hip",
    7 : "Stomach"
}
let medNames = [];
let logOutBtn = document.getElementById('logOut');

fetch(`api/medname/`)
    .then(res => res.json())
    .then(data => medNames.push(data)), 


fetch(`api/viewrecords/${userId}`)
    .then(res => res.json())
    .then(data => generateTable(tableElement, data))

let generateTable = function(table, data) {
    for(let element of data) {
        let row = table.insertRow();
        for(key in element) {
            if(key === "srId" || key == "usId") {
                continue;
            }
            let cell = row.insertCell();
            let text = document.createTextNode(element[key]);
            if(key == "slId"){
                text = document.createTextNode(shotLocations[element[key]]);
            }
            if(key == "mId") {
                text = document.createTextNode(medNames[0][element[key]-1]["mName"]);
            }
            cell.appendChild(text);
        }
    }
}

let removeCookie = function(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

logOutBtn.addEventListener("click", removeCookie);