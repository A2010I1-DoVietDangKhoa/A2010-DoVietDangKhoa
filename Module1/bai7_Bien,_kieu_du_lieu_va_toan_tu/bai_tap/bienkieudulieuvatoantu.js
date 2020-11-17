function scoreCalc() {
    let phys = document.getElementById("physics").value;
    let chem = document.getElementById("chemistry").value;
    let bio = document.getElementById("biology").value;
    let avrg;
    let total;
    if(!isNaN(phys)){
        if(!isNaN(chem)){
            if(!isNaN(bio)){
                total = parseInt(phys) + parseInt(chem) + parseInt(bio);
                avrg = total/3
                document.getElementById("total").innerText = total;
                document.getElementById("average").innerText = avrg;
            }
            else {
                document.getElementById("total").innerText = "Vui lòng nhập số";
                document.getElementById("average").innerText = "Vui lòng nhập số";
            }
        }
        else {
            document.getElementById("total").innerText = "Vui lòng nhập số";
            document.getElementById("average").innerText = "Vui lòng nhập số";
        }
    }
    else {
        document.getElementById("total").innerText = "Vui lòng nhập số";
        document.getElementById("average").innerText = "Vui lòng nhập số";
    }
}
function temp() {
    let cels = document.getElementById("celsius").value;
    let fahr;
    if (!isNaN(cels)){
        fahr = (parseInt(cels)*1.8) + 32;
        document.getElementById("fahrenheit").innerText = fahr;
    }
    else {
        document.getElementById("fahrenheit").innerText = "Vui lòng nhập số";
    }
}
function circleCalc() {
    let rad = document.getElementById("radius").value;
    let s;
    let p;
    if(!isNaN(rad)){
        p = parseInt(rad)*2*3.14;
        s = parseInt(rad)*parseInt(rad)*3.14;
        document.getElementById("perimeter").innerText = p + "cm";
        document.getElementById("stretch").innerText = s + "cm";
    }
    else {
        document.getElementById("perimeter").innerText = "Vui lòng nhập số";
        document.getElementById("stretch").innerText = "Vui lòng nhập số";
    }
}