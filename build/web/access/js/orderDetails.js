function CaculatePrice(selectedTable) {
    let tableSelected = document.getElementById(selectedTable);
    var numA = document.getElementsByClassName("sAdult");
    var numberAdult = numA[0].innerText.substring(0, 1);
    console.log(numberAdult);
    var numK = document.getElementsByClassName("sKid");
    var typePriceA = document.getElementsByClassName("typePriceA");
    console.log(typePriceA);
    typePriceA = typePriceA[0].innerText.split(",").join('');
    var totalA = numberAdult * typePriceA;
    var totalPriceA = tableSelected.getElementsByClassName("totalPriceA");
    totalPriceA[0].innerText = parseInt(totalA, 10).toLocaleString() + " VND";
    var totalK = 0;
    if (numK.length > 0) {
        var numberKid = numK[0].innerText.substring(0, 1);
        console.log(numberKid);
        var typePriceK = document.getElementsByClassName("typePriceK");
        typePriceK = typePriceK[0].innerText.split(",").join('');
        console.log(typePriceK);
        totalK = numberKid * typePriceK;
        var totalPriceK = tableSelected.getElementsByClassName("totalPriceK");
        totalPriceK[0].innerText = parseInt(totalK, 10).toLocaleString() + " VND";
    }
    let luggageItem = tableSelected.getElementsByClassName("valuehanhlyld");
    let luggageValue = luggageItem[0].innerText.slice(0, -4).split(",").join('');
    var finalTotal = tableSelected.getElementsByClassName("finalTotal");
    var total = totalA * 1.1 + totalK * 1.1 + parseInt(luggageValue);
    finalTotal[0].value = parseInt(total, 10).toLocaleString() + " VND";
}

function CaculateTotalPrice(tableGo, tableBack) {
    let itemTableGo = document.getElementById(tableGo);
    let itemTableBack = document.getElementById(tableBack);
    let totalGo = itemTableGo.getElementsByClassName("finalTotal");
    let totalGoValue = totalGo[0].value.slice(0, -4).split(",").join('');
    console.log(totalGoValue);
    let totalBack = itemTableBack.getElementsByClassName("finalTotal");
    let totalBackValue = totalBack[0].value.slice(0, -4).split(",").join('');
    console.log(totalBackValue);
    let finalTotal = parseInt(totalGoValue) + parseInt(totalBackValue);
    let finalTotalItem = document.getElementById("total");
    finalTotalItem.value = finalTotal.toLocaleString() + " VND";
}


function AddLuggage(itemLuggage, selectedTable) {
    let arrLuggage = document.getElementsByClassName(itemLuggage);
    let totalLuggage = 0;
    for (var i = 0; i < arrLuggage.length; i++) {
        let luggageOption = arrLuggage[i].querySelector("option:checked");
        let luggagePrice = luggageOption.getAttribute("data");
        totalLuggage += parseInt(luggagePrice);
    }
    let tableSelected = document.getElementById(selectedTable);
    let luggageItem = tableSelected.getElementsByClassName("valuehanhlyld");
    luggageItem[0].innerText = totalLuggage.toLocaleString() + " VND";
    CaculatePrice(selectedTable);
}



