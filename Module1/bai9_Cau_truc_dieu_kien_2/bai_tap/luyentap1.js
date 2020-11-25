function setForm(value) {
    if(value == 1){
        document.getElementById('form1').style.display = "block";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
    }
    else if (value == 2) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "block";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
    }
    else if (value == 3) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "block";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
    }
    else if (value == 4) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "block";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
    }
    else if (value == 5) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "block";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "none";
    }
    else if (value == 6) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "block";
        document.getElementById('form7').style.display = "none";
    }
    else if (value == 7) {
        document.getElementById('form1').style.display = "none";
        document.getElementById('form2').style.display = "none";
        document.getElementById('form3').style.display = "none";
        document.getElementById('form4').style.display = "none";
        document.getElementById('form5').style.display = "none";
        document.getElementById('form6').style.display = "none";
        document.getElementById('form7').style.display = "block";
    }
}

function bai1() {
    let a = document.getElementById("number1").value;
    let b = document.getElementById("number2").value;
    if (a % b == 0){
        document.getElementById("result1").innerHTML = "a chia hết cho b.";
    }
    else {
        document.getElementById("result1").innerHTML = "a không chia hết cho b.";
    }
}

function bai2() {
    let a = document.getElementById("age").value;
    if (a < 15){
        document.getElementById("result2").innerHTML = "Không đủ tuổi vào lớp 10.";
    }
    else {
        document.getElementById("result2").innerHTML = "Đủ tuổi vào lớp 10.";
    }
}

function bai3() {
    let a = document.getElementById("num").value;
    if (a > 0){
        document.getElementById("result3").innerHTML = a + " là số dương.";
    }
    else {
        document.getElementById("result3").innerHTML = a + " là số âm.";
    }
}

function bai4() {
    let a = document.getElementById("numa").value;
    let b = document.getElementById("numb").value;
    let c = document.getElementById("numc").value;
    if (parseInt(a) > parseInt(b)){
        if(parseInt(a) > parseInt(c)){
            document.getElementById("result4").innerHTML = a + " là số lớn nhất.";
        }
        else{
            document.getElementById("result4").innerHTML = c + " là số lớn nhất.";
        }
    }
    else{
        if(parseInt(b) > parseInt(c)){
            document.getElementById("result4").innerHTML = b + " là số lớn nhất.";
        }
        else{
            document.getElementById("result4").innerHTML = c + " là số lớn nhất.";
        }
    }
}

function bai5() {
    let a = document.getElementById("score1").value;
    let b = document.getElementById("score2").value;
    let c = document.getElementById("score3").value;
    let tb = (parseInt(a) + parseInt(b)*2 + parseInt(c)*3)/6;
    console.log(tb);
    if (tb >= 8.5){
        document.getElementById("result5").innerHTML = "Xếp loại giỏi";
    }
    else if (tb < 8.5 && tb >= 6.5){
        document.getElementById("result5").innerHTML = "Xếp loại khá";
    }
    else if (tb < 6.5 && tb >= 4.5){
        document.getElementById("result5").innerHTML = "Xếp loại trung bình";
    }
    else if (tb < 4.5){
        document.getElementById("result5").innerHTML = "Xếp loại yếu";
    }
}

function bai6() {
    let a = document.getElementById("income").value;
    let money = (parseInt(a)*5)/100;
    let bonus1 =(parseInt(a)*1)/100;
    let bonus2 =(parseInt(a)*2)/100;
    let bonus3 =(parseInt(a)*3)/100;
    console.log(bonus1);
    console.log(bonus2);
    console.log(bonus3);
    if (a >= 10000000 && a < 30000000){
        document.getElementById("result51").innerHTML = "" + money;
        document.getElementById("result52").innerHTML = "Không có.";
        document.getElementById("result53").innerHTML = "Không có.";
    }
    else if (a >= 30000000 && a < 40000000){
        document.getElementById("result51").innerHTML = "" + money;
        document.getElementById("result53").innerHTML = "" + bonus1;
        document.getElementById("result52").innerHTML = "Mức 1";
    }
    else if (a >= 40000000 && a < 50000000){
        document.getElementById("result51").innerHTML = "" + money;
        document.getElementById("result53").innerHTML = "" + bonus2;
        document.getElementById("result52").innerHTML = "Mức 2";
    }
    else if (a > 50000000){
        document.getElementById("result51").innerHTML = "" + money;
        document.getElementById("result53").innerHTML = "" + bonus3;
        document.getElementById("result52").innerHTML = "Mức 3";
    }
    else if (a < 10000000){
        document.getElementById("result51").innerHTML = "Làm việc chăm chỉ hơn.";
        document.getElementById("result53").innerHTML = "Làm việc chăm chỉ hơn.";
        document.getElementById("result52").innerHTML = "Làm việc chăm chỉ hơn.";
    }
}

function bai7() {
    let a = document.getElementById("min").value;
    let standard = parseInt(a)*1000;
    let total = parseInt(standard) + 25000;
    let muc1 = (parseInt(a) - 120)*200 + parseInt(total);
    let muc2 = (parseInt(a) - 180)*300 + parseInt(total);
    let muc3 = (parseInt(a) - 240)*400 + parseInt(total);
    let muc4 = (parseInt(a) - 300)*500 + parseInt(total);
    if (a <= 120){
        document.getElementById("result72").innerHTML = "" + standard;
        document.getElementById("result71").innerHTML = "Mức chuẩn";
        document.getElementById("result73").innerHTML = "" + total;
    }
    else if (a > 120 && a <= 180){
        document.getElementById("result72").innerHTML = "" + standard;
        document.getElementById("result71").innerHTML = "Mức 1";
        document.getElementById("result73").innerHTML = "" + muc1;
    }
    else if (a > 180 && a <= 240){
        document.getElementById("result72").innerHTML = "" + standard;
        document.getElementById("result71").innerHTML = "Mức 2";
        document.getElementById("result73").innerHTML = "" + muc2;
    }
    else if (a > 240 && a <= 300){
        document.getElementById("result72").innerHTML = "" + standard;
        document.getElementById("result71").innerHTML = "Mức 3";
        document.getElementById("result73").innerHTML = "" + muc3;
    }
    else if (a > 300){
        document.getElementById("result72").innerHTML = "" + standard;
        document.getElementById("result71").innerHTML = "Mức 4";
        document.getElementById("result73").innerHTML = "" + muc4;
    }
}