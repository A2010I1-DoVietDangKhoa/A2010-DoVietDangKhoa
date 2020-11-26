function setForm(value) {
    if(value == 1){
        document.getElementById('form1').style.display = "block";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 2) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "block";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 3) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "block";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 4) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "block";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 5) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "block";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 6) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "block";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 7) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "block";
        document.getElementById('form8').style.display = "none";
    }
    else if (value == 8) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
        document.getElementById('form8').style.display = "block";
    }
}

function bai1() {
    /*for(let i = 1; i <= 100; i++){
        document.getElementById("result1").innerHTML += i + " ";
        if(i === 99){
            document.getElementById("result1").innerHTML += i + " ";
            alert("Hoàn thành!")
        }
    }*/
    let i = 1;
    while (i<100){
        document.getElementById("result1").innerHTML += i + " ";
        if(i === 99) {
            document.getElementById("result1").innerHTML += i + " ";
            alert("Hoàn thành!")
        }
        i++;
    }
}