<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers list</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>

<h2 style="text-align: center; padding-top: 2%; padding-bottom: 1%">View Customers</h2>
<div class="container-fluid" align="right">
    <form method="get" action="/customers?action=create">
        <input type="hidden" name="action" value="search">
        <label>Search customer's name: </label><input type="text" name="key">
        <button type="submit" class="btn-primary">Search</button>
    </form>
</div>
<div class="container-fluid">
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthday</th>
            <th>Personal ID</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Gender</th>
            <th>Type</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.getId()}"></c:out></td>
                <td><c:out value="${customer.getFirstName()}"></c:out></td>
                <td><c:out value="${customer.getLastName()}"></c:out></td>
                <td><c:out value="${customer.getDateOfBirth()}"></c:out></td>
                <td><c:out value="${customer.getPersonalID()}"></c:out></td>
                <td><c:out value="${customer.getPhoneNumber()}"></c:out></td>
                <td><c:out value="${customer.getEmail()}"></c:out></td>
                <td><c:out value="${customer.getAddress()}"></c:out></td>
                <td><c:out value="${customer.getGender()}"></c:out></td>
                <td><c:out value="${customer.getCustomerType()}"></c:out></td>
                <td><button class="btn-primary"><a style="color: white" href="/customers?action=edit&id=${customer.getId()}">Edit</a></button></td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>

                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Delete customer?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-danger"><a style="color:white;" href="/customers?action=delete&id=${customer.getId()}">
                                        Delete</a></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-outline-dark" style="float: right; text-decoration: none; color: red">
        <a href="/customers?action=create" style="text-decoration: none">Create customer</a>
    </button>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
