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
    for(let i = 1; i <= 100; i++){
        document.getElementById("result1").innerHTML += i + " ";
        if(i === 99){
            setTimeout(noti, 150);
        }
    }
    /*let i = 1;
    while (i<100){
        document.getElementById("result1").innerHTML += i + " ";
        if(i === 99) {
            document.getElementById("result1").innerHTML += i + " ";
            alert("Hoàn thành!")
        }
        i++;
    }*/
}
function noti() {
    alert("Hoàn thành!");
}

function bai2() {
    while (true){
        let temp = prompt("Nhập vào nhiệt độ:");
        if (temp < 20){
            //document.getElementById("result2").innerHTML = "Hãy tăng nhiệt độ.";
            alert("Hãy tăng nhiệt độ.");
        }
        else if(temp >= 20 && temp <= 100){
            //document.getElementById("result2").innerHTML = "Không cần thay đổi.";
            alert("Không cần thay đổi.");
        }
        else if(temp > 100){
            //document.getElementById("result2").innerHTML = "Hãy giảm nhiệt độ.";
            alert("Hãy giảm nhiệt độ.");
        }
    }
}

function bai3() {
    //let count = 0;
    let a = 0;
    let b = 1;
    let c = "";
    document.getElementById("result3").innerHTML = a + ", " + b + ", ";
    for(let i = 0; i < 18; i++){
        c = a + b;
        document.getElementById("result3").innerHTML += c + ", ";
        a = b;
        b = c;
        }
}

function bai4() {
    let count = 0;
    let a = 0;
    let b = 1;
    let c = "";
    while (count < 5){
        c = a + b;
        let flag = true;
        if(c%5 != 0){
            flag = false;
        }
        else {
            flag = true;
        }
        if(flag == true){
            document.getElementById("result4").innerHTML += c + ", ";
            count++;
        }
        a = b;
        b = c;
    }
}

function  bai5() {
    let a = 0;
    let b = 1;
    let c = "";
    let total = 0;
    document.getElementById("result51").innerHTML = a + ", " + b + ", ";
    for(let i = 0; i < 18; i++){
        c = a + b;
        document.getElementById("result51").innerHTML += c + ", ";
        a = b;
        b = c;
        total += c;
    }
    document.getElementById("result52").innerHTML = "" + total;
}

function bai6() {
    let count = 0;
    let a = 0;
    let total = 0;
    while (count < 30){
        a++;
        let flag = true;
        if(a%7 != 0){
            flag = false;
        }
        else {
            flag = true;
        }
        if(flag == true){
            document.getElementById("result61").innerHTML += a + ", ";
            count++;
            total += a;
        }
    }
    document.getElementById("result62").innerHTML = "" + total;
}

function bai7() {
    for(let i = 1; i <= 100; i++){
        if(i%3 == 0 && i%5 != 0){
            document.getElementById("result7").innerHTML += "Fizz" + ", ";
        }
        else if(i%3 != 0 && i%5 == 0){
            document.getElementById("result7").innerHTML += "Buzz" + ", ";
        }
        else if(i%3 == 0 && i%5 == 0){
            document.getElementById("result7").innerHTML += "FizzBuzz" + ", ";
        }
        else if (i%3 != 0 && i%5 != 0){
            document.getElementById("result7").innerHTML += i + ", ";
        }
    }
}

function bai8() {
    document.getElementById("result81").innerHTML = "";
    document.getElementById("result82").innerHTML = "";
    let range = prompt("Nhập vào khoảng từ 0 đến");
    let num = Math.floor(Math.random() * parseInt(range) + 1);
    let count = 0;
    while (count < 3){
        let guess = prompt("Nhập vào số bạn dự đoán");
        if (guess < num){
            alert("Số nhỏ hơn số cần đoán");
            count++;
        }
        else if ( guess > num){
            alert("Số lớn hơn số cần đoán");
            count++;
        }
        else if ( guess == num){
            document.getElementById("result81").innerHTML = "Chính xác!";
            break;
        }
    }
    document.getElementById("result82").innerHTML = "" + num;
}