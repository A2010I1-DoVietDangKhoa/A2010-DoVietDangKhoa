function addEmployee() {
    document.getElementById("customerMenu").style.display = "none";
    document.getElementById("employeeMenu").style.display = "none";
    document.getElementById("menu").style.display = "none";
    document.getElementById("inputfield2").style.display = "block";
    document.getElementById("eaddbuttons").style.display = "block";
    document.getElementById("eeditbuttons").style.display = "none";
    document.getElementById("employeeDetails").style.display = "none";
}

function confirmAddEmployee() {
    let employee = new Employee();
    let a = document.getElementById("employeeName").value;
    if(a !== null && a!== "") {
        let name = checkName(a);
        employee.setName(name);
    }
    let ID = document.getElementById("employeeID").value;
    let checkCMND = checkID(ID);
    if(checkCMND){
        employee.setCmnd(ID);
    }
    else {
        alert("CMND không đúng định dạng.");
    }
    let email = document.getElementById("employeeEmail").value;
    let checkE = checkEmail(email);
    if(checkE){
        employee.setEmail(email);
    }
    else {
        alert("Email nhân viên không hợp lệ.");
    }

    // if (!checkValid){
    //     alert("Email khách hàng không hợp lệ.");
    // }
    // else {
    //     customer.setEmail(email);
    //     checkEmail= true;
    // }
    let duration = document.getElementById("workDuration").value;
    let checkD = checkDuration(duration);
    if(checkD){
        employee.setDuration(duration);
    }
    else {
        alert("Số tháng không hợp lệ.");
    }
    let address = document.getElementById("employeeAddress").value;
    address = checkAddress(address);
    employee.setAddress(address);
    employee.setBirthday(document.getElementById("employeeBirthday").value);
    employee.setPos(document.getElementById("employeeType").value);
    if(checkD === true && checkE === true && checkCMND === true){
        employeeList.push(employee);
        document.getElementById("inputfield2").style.display = "none";
        document.getElementById("employeeMenu").style.display = "block";
        document.getElementById("menu").style.display = "block";
        document.getElementById("employeeName").value = null;
        document.getElementById("employeeID").value = null;
        document.getElementById("employeeEmail").value = null;
        document.getElementById("employeeAddress").value = null;
        document.getElementById("workDuration").value = null;
        displayEmployeeList();
    }

}

function exitEmployeeEdit() {
    document.getElementById("inputfield2").style.display = "none";
    document.getElementById("employeeMenu").style.display = "block";
    document.getElementById("menu").style.display = "block";
    document.getElementById("employeeName").value = null;
    document.getElementById("employeeID").value = null;
    document.getElementById("employeeEmail").value = null;
    document.getElementById("employeeAddress").value = null;
    document.getElementById("workDuration").value = null;
}

function checkEmployee(i){
    document.getElementById("employeeDetails").style.display = "block";
    document.getElementById("inputfield2").style.display = "none";
    document.getElementById("edName").innerHTML = employeeList[i].getName();
    document.getElementById("edID").innerHTML = employeeList[i].getCmnd();
    document.getElementById("edEmail").innerHTML = employeeList[i].getEmail();
    document.getElementById("edAddress").innerHTML = employeeList[i].getAddress();
    document.getElementById("edBirthday").innerHTML = employeeList[i].getBirthday();
    document.getElementById("edWorkduration").innerHTML = employeeList[i].getDuration();
    let pos = employeeList[i].getPos();
    if(pos == 0){
        document.getElementById("edPos").innerHTML = "Nhân viên thông thường.";
    }
    if(pos == 200){
        document.getElementById("edPos").innerHTML = "Marketing.";
    }
    if(pos == 300){
        document.getElementById("edPos").innerHTML = "Sale.";
    }
    if(pos == 500){
        document.getElementById("edPos").innerHTML = "Manager.";
    }


    document.getElementById("employeeDetailsButtons").innerHTML = '<button type="button" onclick="editEmployee('+i+')">Chỉnh sửa</button>\n' +
        '            <button type="button" onclick="calcSalary(' + i + ')">Tính lương</button>\n' +
        '    <button type="button" onclick="exitEmployeeDetails()">Quay về</button>';
}

function editEmployee(i) {
    document.getElementById("eaddbuttons").style.display = "none";
    document.getElementById("employeeDetails").style.display = "none";
    document.getElementById("inputfield2").style.display = "block";
    document.getElementById("eeditbuttons").style.display = "block";
    document.getElementById("employeeName").value = employeeList[i].getName();
    document.getElementById("employeeID").value = employeeList[i].getCmnd();
    document.getElementById("employeeEmail").value = employeeList[i].getEmail();
    document.getElementById("employeeType").value = employeeList[i].getPos();
    document.getElementById("customerAddress").value = employeeList[i].getAddress();
    document.getElementById("workDuration").value = employeeList[i].getDuration();

    document.getElementById("eeditbuttons").innerHTML = '<button type="button" onclick="confirmEditEmployee('+i+')">Xác nhận</button>\n' +
        '            <button type="button" onclick="exitEmployeeEdit()">Quay về</button>'    ;
}

function confirmEditEmployee(i) {
    let a = document.getElementById("employeeName").value;
    if(a !== null && a!== "") {
        let name = checkName(a);
        employeeList[i].setName(name);
    }
    let ID = document.getElementById("employeeID").value;
    let checkCMND = checkID(ID);
    if(!checkCMND){
        alert("CMND không đúng định dạng.");
    }
    let email = document.getElementById("employeeEmail").value;
    let checkE = checkEmail(email);
    if(!checkE){
        alert("Email nhân viên không hợp lệ.");
    }

    // if (!checkValid){
    //     alert("Email khách hàng không hợp lệ.");
    // }
    // else {
    //     customer.setEmail(email);
    //     checkEmail= true;
    // }
    let duration = document.getElementById("workDuration").value;
    let checkD = checkDuration(duration);
    if(!checkD){
        alert("Số tháng không hợp lệ.");
    }
    let address = document.getElementById("employeeAddress").value;
    address = checkAddress(address);
    if(checkD === true && checkE === true && checkCMND === true){
        employeeList[i].setCmnd(ID);
        employeeList[i].setEmail(email);
        employeeList[i].setAddress(address);
        employeeList[i].setBirthday(document.getElementById("employeeBirthday").value);
        employeeList[i].setPos(document.getElementById("employeeType").value);
        employeeList[i].setDuration(duration);
        document.getElementById("eaddbuttons").style.display = "none";
        document.getElementById("emoloyeeDetails").style.display = "none";
        document.getElementById("inputfield2").style.display = "none";
        document.getElementById("eeditbuttons").style.display = "none";
        displayEmployeeList();
    }
}

function removeEmployee(i) {
    let check = confirm("Xác nhận xóa nhân viên " + employeeList[i].getName() + "?");
    if(check) {
        employeeList.splice(i, 1);
    }
    displayEmployeeList();
    document.getElementById("emoloyeeDetails").style.display = "none";
}

function calcSalary(i) {
    let pos = employeeList[i].getPos();
    let duration = employeeList[i].getDuration();
    let salary = 2000*parseInt(duration);
    let bonus = parseInt(pos)*parseInt(duration);
    document.getElementById("outputfield2").style.display = "block";
    document.getElementById("outputfield1").style.display = "none";
    document.getElementById("namedisplay2").innerHTML = employeeList[i].getName();
    document.getElementById("iddisplay2").innerHTML = employeeList[i].getCmnd();
    document.getElementById("emaildisplay2").innerHTML = employeeList[i].getEmail();
    document.getElementById("birthdisplay2").innerHTML = employeeList[i].getBirthday();
    document.getElementById("addressdisplay2").innerHTML = employeeList[i].getAddress();


    if(pos == 0){
        document.getElementById("posdisplay2").innerHTML = "Nhân viên thông thường, không có thưởng thêm.";
    }
    else if(pos == 200){
        document.getElementById("posdisplay2").innerHTML = "Marketing, thưởng 200$/tháng.";
    }
    else if(pos == 300){
        document.getElementById("posdisplay2").innerHTML = "Sale, thưởng 300$/tháng.";
    }
    else if(pos == 500){
        document.getElementById("posdisplay2").innerHTML = "Manager, thưởng 500$/tháng.";
    }

    document.getElementById("salarydisplay").innerHTML = salary + "$";
    document.getElementById("bonusdisplay").innerHTML = bonus + "$";
    document.getElementById("total").innerHTML = (salary+bonus) + "$";
}