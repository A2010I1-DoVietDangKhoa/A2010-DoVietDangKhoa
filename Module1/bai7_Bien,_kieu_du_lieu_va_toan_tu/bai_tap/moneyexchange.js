
function exchangeFunction(){
    let amount = document.getElementById("amount").value;
    let from = document.getElementById("from").value;
    let to = document.getElementById("to").value;
    let result;
   if (!isNaN(amount)) {
       if (from == "VND" && to == "USD") {
           result = parseInt(amount) / 23000;
           document.getElementById("display").innerText = result + " USD";
       } else if (from == "USD" && to == "VND") {
           result = parseInt(amount) * 23000;
           document.getElementById("display").innerText = result + " VND";
       } else if (from == "VND" && to == "VND") {
           result = amount;
           document.getElementById("display").innerText = result + " VND";
       } else if (from == "USD" && to == "USD") {
           result = amount;
           document.getElementById("display").innerText = result + " USD";
       }
   }
   else{
       alert("Xin nhập số tiền hợp lệ!");
   }
}