function addCustomer() {
    document.getElementById("customerMenu").style.display = "none";
    document.getElementById("employeeMenu").style.display = "none";
    document.getElementById("menu").style.display = "none";
    document.getElementById("inputfield1").style.display = "block";
    document.getElementById("caddbuttons").style.display = "block";
    document.getElementById("ceditbuttons").style.display = "none";
    document.getElementById("customerDetails").style.display = "none";
}

function confirmAddCustomer() {
    let customer = new Customer();
    let a = document.getElementById("customerName").value;
        let name = checkName(a);
        if(name !== 1) {
            customer.setName(name);
        }
        else {
            alert("Tên khách hàng trống.");
        }
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

    let address = document.getElementById("customerAddress").value;
    address = checkAddress(address);
    customer.setAddress(address);
    let date = document.getElementById("customerBirthday").value;
    let checkDate = checkBirth(date);
    if(checkDate){
        customer.setBirthday(date);
    }
    else {
        alert("Ngày tháng năm sinh không đúng định dạng DD/MM/YYYY.");
    }
    //customer.setBirthday(document.getElementById("employeeBirthday").value);
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

    if(checkD === true && checkC === true && checkE === true && checkCMND === true && checkDate === true){
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
    document.getElementById("outputfield1").style.display = "none";
    document.getElementById("outputfield2").style.display = "none";
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
    let name = checkName(a);
    if(name !== 1) {
        customerList[i].setName(name);
    }
    else {
        alert("Tên khách hàng trống.");
    }
    let ID = document.getElementById("customerID").value;
    let checkCmnd = checkID(ID);
    if(!checkCmnd){
        alert("CMND không đúng định dạng.");
    }

    let date = document.getElementById("customerBirthday").value;
    let checkDate = checkBirth(date);
    if(!checkDate){
        alert("Ngày tháng năm sinh không đúng định dạng DD/MM/YYYY.");
    }
    let email = document.getElementById("customerEmail").value;
    let checkE = checkEmail(email);
    if(!checkE){
        alert("Email khách hàng không hợp lệ.");
    }

    let address = document.getElementById("customerAddress").value;
    address = checkAddress(address);
    customerList[i].setAddress(address);

    let company = document.getElementById("companySize").value;
    let checkC = checkCompany(company);
    if(!checkC){
        alert("Số người không hợp lệ.");
    }
    let duration = document.getElementById("duration").value;
    let checkD = checkDuration(duration);
    if(!checkD){
        alert("Số ngày không hợp lệ.");
    }
    if(checkD === true && checkC === true && checkE === true && checkCmnd === true && checkCmnd === true && checkDate === true){
        customerList[i].setCmnd(ID);
        customerList[i].setEmail(email);
        customerList[i].setBirthday(date);
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

    document.getElementById("durationdisplay").innerHTML = "" + duration;
        if (duration < 2 && duration > 0) {
            //price = price + 0;
            document.getElementById("durationdiscount").innerHTML = "Số ngày thuê không đủ để nhận ưu đãi.";
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