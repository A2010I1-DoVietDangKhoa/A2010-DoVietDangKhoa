<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>

<div class="container-fluid">
    <div class="row">
        <!--menu_left-->
        <div class="col-lg-2">
            <a href="/employees">Back to list</a><br>
            <p>Placeholder one</p>
            <p>Placeholder two</p>
        </div>
        <!--body-->
        <div class="col-lg-10">
            <legend style="text-align: center">CREATE EMPLOYEE</legend>
            <form action="/employees?action=create" method="post" style="margin-top: 7%">
                <div class="row" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <select class="form-select" aria-label="Default select example" name="education">
                            <option value="Sau dai hoc">Sau đại học</option>
                            <option value="Dai hoc">Đại học</option>
                            <option value="Cao dang">Cao đẳng</option>
                            <option value="Trung cap">Trung cấp</option>
                        </select><br>
                    </div>
                    <div class="col-lg-4">
                        <select class="form-select" aria-label="Default select example" name="division">
                            <option value="Phuc vu">Phục vụ</option>
                            <option value="Quan ly">Quản lý</option>
                            <option value="Hanh chinh">Hành chính</option>
                            <option value="Marketing">Marketing</option>
                        </select><br>
<%--                        <input class="form-control" name="firstname" placeholder="First Name">--%>
<%--                        <input class="form-control" name="lastname" placeholder="Last Name">--%>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="birthday" type="date"
                               value="<c:out value='${employee.getDateOfBirth()}'/>"><br>
                    </div>
                    <div class="col-lg-4">
                        <select class="form-select" aria-label="Default select example" name="position">
                            <option value="Le tan">Lễ tân</option>
                            <option value="Phuc vu">Phục vụ</option>
                            <option value="Chuyen vien">Chuyên viên</option>
                            <option value="Giam sat">Giám sát</option>
                            <option value="Quan ly">Quản lý</option>
                            <option value="Giam doc">Giám đốc</option>
                        </select><br>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="firstname" placeholder="First Name"
                               value="<c:out value='${employee.getFirstName()}'/>"><br>
                        <c:if test='${requestScope["nameMessage1"] != null}'>
                            <span style="color: red" class="message">${requestScope["nameMessage1"]}</span>
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="lastname" placeholder="Last Name"
                               value="<c:out value='${employee.getLastName()}'/>"><br>
                        <c:if test='${requestScope["nameMessage2"] != null}'>
                            <span style="color: red" class="message">${requestScope["nameMessage2"]}</span>
                        </c:if>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="cmnd" placeholder="Id card"
                               value="<c:out value='${employee.getPersonalID()}'/>"><br>
                        <c:if test='${requestScope["cardMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["cardMessage"]}</span>
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="phone" placeholder="Phone Number"
                               value="<c:out value='${employee.getPhoneNumber()}'/>"><br>
                        <c:if test='${requestScope["phoneMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["phoneMessage"]}</span>
                        </c:if>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="email" placeholder="Email"
                               value="<c:out value='${employee.getEmail()}'/>"><br>
                        <c:if test='${requestScope["emailMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["emailMessage"]}</span>
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="address" placeholder="Address"
                               value="<c:out value='${employee.getAddress()}'/>">
                        <br>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="salary" placeholder="Salary"
                               value="<c:out value='${employee.getSalary()}'/>"><br>
                        <c:if test='${requestScope["salaryMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["salaryMessage"]}</span>
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Create employee
                        </button>

                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Create new employee?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Create</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>--%>
<%--                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                Create new employee?--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                <button type="submit" class="btn btn-primary"><a style="color: white" href="/employees?action=create">Create</a></button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
