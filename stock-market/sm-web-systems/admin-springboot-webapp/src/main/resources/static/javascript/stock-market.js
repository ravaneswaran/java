function hideAndShow(stockDivId, stockStatDivId){
    var stockDiv = document.getElementById(stockDivId);
    var stockStatDiv = document.getElementById(stockStatDivId);

    if(stockDiv.style.visibility == 'visible' || stockDiv.style.visibility == ''){
         stockDiv.style.width = "0%";
         stockDiv.style.height = "0%";
         stockDiv.style.visibility = "hidden";

         stockStatDiv.style.width = "100%";
         stockStatDiv.style.height = "70%";
         stockStatDiv.style.visibility = "visible";
    } else {
         stockStatDiv.style.width = "0%";
         stockStatDiv.style.height = "0%";
         stockStatDiv.style.visibility = "hidden";

         stockDiv.style.width = "100%";
         stockDiv.style.height = "70%";
         stockDiv.style.visibility = "visible";
    }
}
