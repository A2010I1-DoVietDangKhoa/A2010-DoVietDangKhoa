function addCustomer() {
    document.getElementById("customerMenu").style.display = "none";
    document.getElementById("employeeMenu").style.display = "none";
    document.getElementById("menu").style.display = "none";
    document.getElementById("inputfield1").style.display = "block";
    document.getElementById("caddbuttons").style.display = "block";
    document.getElementById("ceditbuttons").style.display = "none";
    document.getElementById("customerDetails").style.display = "none";
    // document.getElementById("customerName").readOnly = false;
    // document.getElementById("customerID").readOnly = false;
    // document.getElementById("customerBirthday").readOnly = false;
    // document.getElementById("customerEmail").readOnly = false;
    // document.getElementById("customerAddress").readOnly = false;
    // document.getElementById("companySize").readOnly = false;
    // document.getElementById("duration").readOnly = false;
    // document.getElementById("serviceType").disabled = false;
    // document.getElementById("discountType").disabled = false;
    // document.getElementById("customerType").disabled = false;
    // document.getElementById("roomType").disabled = false;
}

function confirmAddCustomer() {
    let customer = new Customer();
    let a = document.getElementById("customerName").value;
        let name = checkName(a);
        customer.setName(name);
        //customer.setName(temp);
    let ID = document.getElementById("customerID").value;
    let checkCMND = checkID(ID);
    if(checkCMND){
        customer.setCmnd(ID);
    }
    else {
        alert("CMND không đúng định dạng.");
    }
    let email = document.getElementById("customerEmail").value;
    let checkE = checkEmail(email);
    if(checkE){
        customer.setEmail(email);
    }
    else {
        alert("Email khách hàng không hợp lệ.");
    }
    // if (!checkValid){
    //     alert("Email khách hàng không hợp lệ.");
    // }
    // else {
    //     customer.setEmail(email);
    //     checkEmail= true;
    // }
    let address = document.getElementById("customerAddress").value;
    address = checkAddress(address);
    customer.setAddress(address);
    customer.setBirthday(document.getElementById("employeeBirthday").value);
    customer.setType(document.getElementById("customerType").value);
    customer.setDiscount(document.getElementById("discountType").value);
    customer.setRoom(document.getElementById("roomType").value);
    customer.setService(document.getElementById("serviceType").value);
    let company = document.getElementById("companySize").value;
    let checkC = checkCompany(company);
    if(checkC){
        customer.setCompany(company);
    }
    else {
        alert("Số người không hợp lệ.");
    }

    let duration = document.getElementById("duration").value;
    let checkD = checkDuration(duration);
    if(checkD){
        customer.setDuration(duration);
    }
    else {
        alert("Số ngày không hợp lệ.");
    }

    if(checkD === true && checkC === true && checkE === true && checkCMND === true){
        //temp = "";
        customerList.push(customer);
        document.getElementById("inputfield1").style.display = "none";
        document.getElementById("customerMenu").style.display = "block";
        document.getElementById("menu").style.display = "block";
        document.getElementById("customerName").value = null;
        document.getElementById("customerID").value = null;
        document.getElementById("customerEmail").value = null;
        document.getElementById("customerAddress").value = null;
        document.getElementById("companySize").value = null;
        document.getElementById("duration").value = null;
        displayCustomerList();
    }

}

function exitCustomerEdit() {
    document.getElementById("inputfield1").style.display = "none";
    document.getElementById("customerMenu").style.display = "block";
    document.getElementById("menu").style.display = "block";
    document.getElementById("customerName").value = null;
    document.getElementById("customerID").value = null;
    document.getElementById("customerEmail").value = null;
    document.getElementById("customerAddress").value = null;
    document.getElementById("companySize").value = null;
    document.getElementById("duration").value = null;
}

function checkCustomer(i){
    document.getElementById("customerDetails").style.display = "block";
    document.getElementById("inputfield1").style.display = "none";
    document.getElementById("cdName").innerHTML = customerList[i].getName();
    document.getElementById("cdID").innerHTML = customerList[i].getCmnd();
    document.getElementById("cdEmail").innerHTML = customerList[i].getEmail();
    document.getElementById("cdAddress").innerHTML = customerList[i].getAddress();
    document.getElementById("cdBirthday").innerHTML = customerList[i].getBirthday();
    document.getElementById("cdCompany").innerHTML = customerList[i].getCompany();
    document.getElementById("cdDuration").innerHTML = customerList[i].getDuration();

    let discount = parseInt(customerList[i].getDiscount());
    //console.log(discount);
    if(discount == 0){
        document.getElementById("cdDiscount").innerHTML = "Không có giảm giá";
    }
    else if(discount == 10){
        document.getElementById("cdDiscount").innerHTML = "10%";
    }
    else if(discount == 20){
        document.getElementById("cdDiscount").innerHTML = "20%";
    }
    else if(discount == 30){
        document.getElementById("cdDiscount").innerHTML = "30%";
    }
    else if(discount == 40){
        document.getElementById("cdDiscount").innerHTML = "40%";
    }

    let type = parseInt(customerList[i].getType());
    if(type == 0){
        document.getElementById("cdType").innerHTML = "Thông thường";
    }
    else if(type == 2){
        document.getElementById("cdType").innerHTML = "Bạc";
    }
    else if(type == 5){
        document.getElementById("cdType").innerHTML = "Vàng";
    }
    else if(type == 10){
        document.getElementById("cdType").innerHTML = "Bạch kim";
    }
    else if(type == 15){
        document.getElementById("cdType").innerHTML = "Kim cương";
    }

    let service = parseInt(customerList[i].getService());
    //console.log(service);
    if(service == 500){
        document.getElementById("cdService").innerHTML = "Villa";
    }
    else if(service == 300){
        document.getElementById("cdService").innerHTML = "House";
    }
    else if(service == 100){
        document.getElementById("cdService").innerHTML = "Room";
    }

    let room = customerList[i].getRoom();
    if (room == "normal"){
        document.getElementById("cdRoom").innerHTML = "Thường";
    }
    else if (room == "business"){
        document.getElementById("cdRoom").innerHTML = "Business";
    }
    else if (room == "vip"){
        document.getElementById("cdRoom").innerHTML = "VIP";
    }

    document.getElementById("customerDetailsButtons").innerHTML = '<button type="button" onclick="editCustomer('+i+')">Chỉnh sửa</button>\n' +
        '            <button type="button" onclick="makeReceipt(' + i + ')">Tính tiền</button>\n' +
        '    <button type="button" onclick="exitCustomerDetails()">Quay về</button>';
}

function exitCustomerDetails() {
    document.getElementById("customerDetails").style.display = "none";
}

function editCustomer(i) {
    document.getElementById("caddbuttons").style.display = "none";
    document.getElementById("customerDetails").style.display = "none";
    document.getElementById("inputfield1").style.display = "block";
    document.getElementById("ceditbuttons").style.display = "block";
    document.getElementById("customerName").value = customerList[i].getName();
    document.getElementById("customerID").value = customerList[i].getCmnd();
    document.getElementById("customerEmail").value = customerList[i].getEmail();
    document.getElementById("customerType").value = customerList[i].getType();
    document.getElementById("discountType").value = customerList[i].getDiscount();
    document.getElementById("serviceType").value = customerList[i].getService();
    document.getElementById("roomType").value = customerList[i].getRoom();
    document.getElementById("customerAddress").value = customerList[i].getAddress();
    document.getElementById("companySize").value = customerList[i].getCompany();
    document.getElementById("duration").value = customerList[i].getDuration();

    document.getElementById("ceditbuttons").innerHTML = '<button type="button" onclick="confirmEditCustomer('+i+')">Xác nhận</button>\n' +
        '            <button type="button" onclick="exitCustomerEdit()">Quay về</button>'    ;
}

function confirmEditCustomer(i) {
    let a = document.getElementById("customerName").value;
    let temp = "";
    if(a !== null && a!== "") {
        let b = a.trim().toLowerCase();
        for(let j = 0; j<b.length; j++){
            if(b.charAt(j) === " " && b.charAt(j+1) === " "){
                continue;
            }
            else if(j === 0 || b.charAt(j-1) === " "){
                temp += b.charAt(j).toUpperCase();
                continue;
            }
            temp += b.charAt(j);
        }
        customerList[i].setName(temp);
    }
    let ID = document.getElementById("customerID").value;
    let checkID = false;
    if(!isNaN(ID)){
        ID = Number.parseFloat(ID);
        if(Number.isInteger(ID)){
            if(ID > 100000000 && ID < 999999999){
                //customerList[i].setCmnd(ID);
                checkID = true;
            }
            else {
                alert("CMND không đúng định dạng.");
            }
        }
        else {
            alert("CMND không đúng định dạng.");
        }
    }
    else {
        alert("CMND không đúng định dạng.");
    }
    let email = document.getElementById("customerEmail").value;
    let checkEmail = false;
    let checkValid = false;
    let regexEmail = /\S+@\S+\.\S+/;
    // for(let i = 0; i < email.length; i++){
    //     if(email.charAt(i) === "@"){
    //         countAt++;
    //         for(let j = i + 1; j < email.length; j++){
    //             if(email.charAt(j) === "."){
    //                 countDot++;
    //             }
    //         }
    //     }
    // }
    do{
        if(regexEmail.test(email)){
            // customerList[i].setEmail(email);
            checkEmail= true;
            checkValid = true;
        }
        else {
            alert("Email khách hàng không hợp lệ.");
            break;
        }
    }while(!checkValid);

    // if (!checkValid){
    //     alert("Email khách hàng không hợp lệ.");
    // }
    // else {
    //     customer.setEmail(email);
    //     checkEmail= true;
    // }
    let tempAdd = "";
    let address = document.getElementById("customerAddress").value;
    address = address.trim();
    for (let i = 0; i < address.length; i++){
        if(address.charAt(i) === " " && address.charAt(i+1) === " "){
            continue;
        }
        tempAdd += address.charAt(i);
    }
    let company = document.getElementById("companySize").value;
    let checkCompany = false;
    if(!isNaN(company)){
        company = Number.parseFloat(company);
        if(Number.isInteger(company)) {
            if (company > 0) {
                // customerList[i].setCompany(company);
                checkCompany = true;
            }
            else {
                alert("Số lượng không hợp lệ");
            }
        }
        else {
            alert("Số lượng không hợp lệ");
        }
    }
    else {
        alert("Số lượng không hợp lệ");
    }

    let duration = document.getElementById("duration").value;
    let checkDuration = false;
    if(!isNaN(duration)){
        duration = Number.parseFloat(duration);
        if(Number.isInteger(duration)){
            if (duration > 0){
                //customerList[i].setDuration(duration);
                checkDuration = true;
            }
            else {
                alert("Số ngày không hợp lệ");
            }
        }
        else {
            alert("Số ngày không hợp lệ");
        }
    }
    else {
        alert("Số ngày không hợp lệ");
    }
    if(checkDuration === true && checkCompany === true && checkEmail === true && checkID === true){
        customerList[i].setCmnd(ID);
        customerList[i].setEmail(email);
        customerList[i].setAddress(tempAdd);
        customerList[i].setBirthday(document.getElementById("customerBirthday").value);
        customerList[i].setType(document.getElementById("customerType").value);
        customerList[i].setDiscount(document.getElementById("discountType").value);
        customerList[i].setRoom(document.getElementById("roomType").value);
        customerList[i].setService(document.getElementById("serviceType").value);
        customerList[i].setCompany(company);
        customerList[i].setDuration(duration);
        document.getElementById("caddbuttons").style.display = "none";
        document.getElementById("customerDetails").style.display = "none";
        document.getElementById("inputfield1").style.display = "none";
        document.getElementById("ceditbuttons").style.display = "none";
        displayCustomerList();
    }
}

function removeCustomer(i) {
    let check = confirm("Xác nhận xóa khách hàng " + customerList[i].getName() + "?");
    if(check) {
        customerList.splice(i, 1);
    }
    displayCustomerList();
    document.getElementById("customerDetails").style.display = "none";
}

function makeReceipt(i) {
    let type = customerList[i].getType();
    let discount = customerList[i].getDiscount();
    let service = customerList[i].getService();
    let duration = customerList[i].getDuration();
    let room = customerList[i].getRoom();
    let price = parseInt(service)*parseInt(duration)*(1 - parseInt(discount)/100) - parseInt(type);
    document.getElementById("outputfield1").style.display = "block";
    document.getElementById("outputfield2").style.display = "none";
    document.getElementById("namedisplay1").innerHTML = customerList[i].getName();
    document.getElementById("iddisplay1").innerHTML = customerList[i].getCmnd();
    document.getElementById("emaildisplay1").innerHTML = customerList[i].getEmail();
    document.getElementById("birthdisplay1").innerHTML = customerList[i].getBirthday();
    document.getElementById("addressdisplay1").innerHTML = customerList[i].getAddress();
    document.getElementById("companydisplay").innerHTML = customerList[i].getCompany();

    if(type == 0){
        document.getElementById("ctypedisplay").innerHTML = "Thông thường, không có ưu đãi.";
    }
    else if(type == 2){
        document.getElementById("ctypedisplay").innerHTML = "Bạc, khuyến mãi 2$.";
    }
    else if(type == 5){
        document.getElementById("ctypedisplay").innerHTML = "Vàng, khuyến mãi 5$.";
    }
    else if(type == 10){
        document.getElementById("ctypedisplay").innerHTML = "Bạch kim, khuyến mãi 10$.";
    }
    else if(type == 15){
        document.getElementById("ctypedisplay").innerHTML = "Kim cương, khuyến mãi 15$.";
    }

    if(customerList[i].getAddress().includes("Đà Nẵng")){
        price = price - 20;
        document.getElementById("addressdiscount").innerHTML = "Khách hàng đến từ Đà Nẵng, được giảm 20$."
    }
    else if(customerList[i].getAddress().includes("Huế")){
        price = price - 10;
        document.getElementById("addressdiscount").innerHTML = "Khách hàng đến từ Huế, được giảm 10$."
    }
    else if(customerList[i].getAddress().includes("Quảng Nam")){
        price = price - 5;
        document.getElementById("addressdiscount").innerHTML = "Khách hàng đến từ Quảng Nam, được giảm 5$."
    }
    else {
        document.getElementById("addressdiscount").innerHTML = "Khách hàng không đến từ nơi được giảm giá."
    }

    if(discount == 0){
        document.getElementById("discountdisplay").innerHTML = "Không có ưu đãi.";
    }
    else if(discount == 10){
        document.getElementById("discountdisplay").innerHTML = "10%.";
    }
    else if(discount == 20){
        document.getElementById("discountdisplay").innerHTML = "20%.";
    }
    else if(discount == 30){
        document.getElementById("discountdisplay").innerHTML = "30%.";
    }
    else if(discount == 40){
        document.getElementById("discountdisplay").innerHTML = "40%.";
    }

    document.getElementById("durationdisplay").innerHTML = "Số ngày thuê: " + duration;
    if(Number.isInteger(duration)) {
        if (duration < 2 && duration > 0) {
            //price = price + 0;
            document.getElementById("durationdiscount").innerHTML = "Không có giảm giá.";
        } else if (duration >= 2 && duration <= 4) {
            price = price - 10;
            document.getElementById("durationdiscount").innerHTML = "Giảm 10$.";
        } else if (duration >= 5 && duration <= 7) {
            price = price - 20;
            document.getElementById("durationdiscount").innerHTML = "Giảm 20$.";
        } else if (duration > 7) {
            price = price - 30;
            document.getElementById("durationdiscount").innerHTML = "Giảm 30$.";
        }
    }

    if(service == 500){
        document.getElementById("stypedisplay").innerHTML = "Villa.";
    }
    else if(service == 300){
        document.getElementById("stypedisplay").innerHTML = "House.";
    }
    else if(service == 100){
        document.getElementById("stypedisplay").innerHTML = "Room.";
    }

    switch (room) {
        case "normal":
            document.getElementById("rtypedisplay").innerHTML = "Phòng thường.";
            break;
        case "business":
            document.getElementById("rtypedisplay").innerHTML = "Phòng hạng thương gia, giá dịch vụ phát sinh 1000$.";
            price = price + 1000;
            break;
        case "vip":
            document.getElementById("rtypedisplay").innerHTML = "Phòng hạng VIP, giá dịch vụ phát sinh 2000$.";
            price = price + 2000;
            break;
    }

    document.getElementById("totaldisplay").innerHTML = price + "$";
}