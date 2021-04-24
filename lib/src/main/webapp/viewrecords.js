let loggedInUser = document.cookie;
let userId = parseInt(loggedInUser.split('=')[1]);
//Will need to remove soon
let uId = 4;
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

fetch(`api/viewrecords/${uId}`)
    .then(res => res.json())
    .then(data => generateTable(tableElement, data))

let generateTable = function(table, data) {
    for(let element of data) {
        console.log(element);
        let row = table.insertRow();
        for(key in element) {
            console.log(key);
            if(key === "srId" || key == "usId") {
                continue;
            }
            let cell = row.insertCell();
            let text = document.createTextNode(element[key]);
            if(key == "slId"){
                text = document.createTextNode(shotLocations[element[key]]);
            }
            cell.appendChild(text);
        }
    }
}