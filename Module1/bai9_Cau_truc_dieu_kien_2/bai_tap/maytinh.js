document.getElementById("display").readOnly = true;
function hienThi(x) {
    switch (x) {
        case 0:
            document.getElementById("display").value += document.getElementById("0").value;
            break;
        case 1:
            document.getElementById("display").value += document.getElementById("1").value;
            break;
        case 2:
            document.getElementById("display").value += document.getElementById("2").value;
            break;
        case 3:
            document.getElementById("display").value += document.getElementById("3").value;
            break;
        case 4:
            document.getElementById("display").value += document.getElementById("4").value;
            break;
        case 5:
            document.getElementById("display").value += document.getElementById("5").value;
            break;
        case 6:
            document.getElementById("display").value += document.getElementById("6").value;
            break;
        case 7:
            document.getElementById("display").value += document.getElementById("7").value;
            break;
        case 8:
            document.getElementById("display").value += document.getElementById("8").value;
            break;
        case 9:
            document.getElementById("display").value += document.getElementById("9").value;
            break;
        case 10:
            document.getElementById("display").value += document.getElementById("10").value;
            break;
        case 11:
            document.getElementById("display").value += document.getElementById("11").value;
            break;
         case 12:
            document.getElementById("display").value += document.getElementById("12").value;
            break;
        case cong:
            document.getElementById("display").value += document.getElementById("cong").value;
            break;
        case tru:
            document.getElementById("display").value += document.getElementById("tru").value;
            break;
        case nhan:
            document.getElementById("display").value += document.getElementById("nhan").value;
            break;
        case chia:
            document.getElementById("display").value += document.getElementById("chia").value;
            break;
        case laydu:
            document.getElementById("display").value += document.getElementById("laydu").value;
            break;
        default:
    }
}
function ansWer() {
    let Exp = document.getElementById("display");
    let Exp1 = Exp.value;
    let result = eval(Exp1);
    //alert(result);
    Exp.value = result;
}