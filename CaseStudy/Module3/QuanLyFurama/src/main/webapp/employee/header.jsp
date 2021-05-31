<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<%--    <div class="header">--%>
<%--        <div class="container-fluid">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-5">--%>
<%--                    <a href="#"></a>--%>
<%--                    <img src="resources/img/logo@2x.png">--%>
<%--                </div>--%>
<%--                <div class="col-lg-4">--%>
<%--                    <p>--%>
<%--                        103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam--%>

<%--                        7.0 km từ Sân bay Quốc tế Đà Nẵng--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3">--%>
<%--                    <i class="fas fa-phone"></i><p>84-236-3847 333/888</p>--%>
<%--                    <i class="fas fa-envelope"></i><p>reservation@furamavietnam.com</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="header bg-light py-5">--%>
<%--            <div class="container-fluid">--%>
<%--                <div class="row">--%>
<%--                    <div class="col-6">--%>
<%--                        Header--%>
<%--                    </div>--%>
<%--                    <div class="col-6 text-right">--%>
<%--                        000 000 0000--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <!--/row-->--%>
<%--            </div>--%>
<%--            <!--container-->--%>
<%--        </div>--%>
<%--        <nav class="navbar navbar-expand-sm sticky-top navbar-light bg-light">--%>
<%--            <div class="container">--%>
<%--                <a class="navbar-brand" href="#">Brand</a>--%>
<%--                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar1">--%>
<%--                    <span class="navbar-toggler-icon"></span>--%>
<%--                </button>--%>
<%--                <div class="collapse navbar-collapse" id="navbar1">--%>
<%--                    <ul class="navbar-nav mr-auto">--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#">Home</a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#">Employee</a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#">Customer</a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                        <a class="nav-link" href="#">Service</a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#">Contract</a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                    <ul class="navbar-nav ml-auto">--%>
<%--                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </nav>--%>
<%--    </div>--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-3">--%>
<%--                <div class="sidebar-sticky sticky-top">--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<!--menu-->
<%--<div class="container-fluid">--%>
<%--                <div class="row">--%>
<%--                    <div class="col-lg-2">--%>
<%--                        <a href="#"></a>--%>
<%--                        <img src="/img/logo@2x.png" width="40%" height="40%">--%>
<%--                    </div>--%>
<%--                    <div class="col-lg-5">--%>
<%--                        <p>--%>
<%--                            103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam--%>

<%--                            7.0 km từ Sân bay Quốc tế Đà Nẵng--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                    <div class="col-lg-5">--%>
<%--                        <i class="fas fa-phone"></i><p>84-236-3847 333/888</p>--%>
<%--                        <i class="fas fa-envelope"></i><p>reservation@furamavietnam.com</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light menu">
    <div class="container-fluid">
        <a class="navbar-brand" href="/"><img style="max-width: 100px; height: auto" src="/img/logo@2x.png" class="img-thumbnail"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employees?action=showEmployees">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers?action=showCustomers">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
