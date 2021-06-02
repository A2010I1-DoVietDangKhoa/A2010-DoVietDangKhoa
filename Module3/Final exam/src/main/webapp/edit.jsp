<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
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
            <a href="/flats">Back to list</a><br>
            <p>Placeholder one</p>
            <p>Placeholder two</p>
        </div>
        <!--body-->
        <div class="col-lg-10">
            <legend style="text-align: center">UPDATE</legend>
            <form action="/flats?action=edit&id=${employee.getId()}" method="post" style="margin-top: 7%">
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="code" placeholder="Code"
                               value="<c:out value='${flat.getCode()}'/>"><br>
                        <c:if test='${requestScope["codeMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["codeMessage"]}</span>
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="area" placeholder="Area"
                               value="<c:out value='${flat.getArea()}'/>"><br>
                        <c:if test='${requestScope["areaMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["areaMessage"]}</span>
                        </c:if>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <select class="form-select" aria-label="Default select example" name="status">
                            <option value="Trong">Trống</option>
                            <option value="Ha tang">Hạ tầng</option>
                            <option value="Day du">Đầy đủ</option>
                        </select><br>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="floors" placeholder="Floors"
                               value="<c:out value='${flat.getFloors()}'/>"><br>
                        <c:if test='${requestScope["floorsMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["floorsMessage"]}</span>
                        </c:if>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <select class="form-select" aria-label="Default select example" name="type">
                            <option value="Cho thue">Cho thuê</option>
                            <option value="Chia se">Chia sẻ</option>
                            <option value="Tron goi">Trọn gói</option>
                        </select><br>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="description" placeholder="Description"
                               value="<c:out value='${flat.getDescription()}'/>"><br>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="startDate" type="date"
                               value="<c:out value='${flat.getStart()}'/>"><br>
                    </div>
                    <div class="col-lg-4">
                        <input class="form-control" name="endDate" type="date"
                               value="<c:out value='${flat.getEnd()}'/>"><br>
                    </div>
                </div>
                <div class="row mt-4" style="justify-content: center">
                    <div class="col-lg-4" style="margin-right: 3%">
                        <input class="form-control" name="price" placeholder="Price"
                               value="<c:out value='${flat.getPrice()}'/>"><br>
                        <c:if test='${requestScope["priceMessage"] != null}'>
                            <span style="color: red" class="message">${requestScope["priceMessage"]}</span>
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Create flat
                        </button>

                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Update flat's info?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Update</button>
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


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
