<%@page import="bestseller.tungnk.BestSellerDTO"%>
<%@page import="java.util.Set"%>
<%@page import="tungnk.cart.CartItemDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="tungnk.account.AccountDTO"%>
<%@page import="java.util.List"%>
<%@page import="tungnk.pizza.PizzaDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="HomeServlet">Pizza Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">

                    <ul class="navbar-nav m-auto">
                        <% AccountDTO user = (AccountDTO) session.getAttribute("USER");%>

                        <li class="nav-item">
                            <p class="nav-link"><%= user.getUserName()%></p>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="HomeServlet?action=Logout">Log out</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">The pizza world at your fingertips</h1>
                <p class="lead text-muted mb-0">The leading place to buy pizza in Vietnam</p>
            </div>
        </section>
        <!--end of menu-->
        <div class="container">
            <span style="color: red">${message}</span>
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="HomeServlet?action=Clear">Back</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <h1>Best Seller</h1>
            <% List<BestSellerDTO> list = (List<BestSellerDTO>) request.getAttribute("BEST_SELLER");
                int count = 0;
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Saled</th>
                    </tr>
                </thead>

                <tbody>
                    <% for (BestSellerDTO item : list) {%>
                    <tr>
                        <td><%= ++count%></td>
                        <td><%= item.getId()%></td>
                        <td><%= item.getName()%></td>
                        <td><%= item.getPrice()%></td>
                        <td><%= item.getSaled()%></td>
                    </tr>

                    <% }%>
                </tbody>
            </table>
        </div>

        <!-- Footer -->
        <footer class="text-light" style="background-color: black" >
            <div class="container" style="margin-top: 100px">
                <div class="row" >
                    <div class="col-md-3 col-lg-4 col-xl-3" style="margin-top: 50px">
                        <h5>About</h5>
                        <hr class="bg-dark mb-2 mt-0 d-inline-block mx-auto w-25">
                        <p class="mb-0">
                            This place provides the number one phone service in Vietnam
                        </p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto" style="margin-top: 50px">
                        <h5>Informations</h5>
                        <hr class="bg-dark mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><h6>Facility 1: 1 Nguyen Hue, District 1, Ho Chi Minh City</h6></li>
                            <li><h6>Facility 2: Landmark 81, 5th floor, Binh Thanh District, Ho Chi Minh City</h6></li>

                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto" style="margin-top: 50px">
                        <h4>Country & Region</h4>
                        <hr class="bg-dark mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><h6>Singapore</h6></li>
                            <li><h6>Vietnam</h6></li>
                            <li><h6>Thailand</h6></li>
                            <li><h6>Indonesia</h6></li>
                            <li><h6>Taiwan</h6></li>
                        </ul>
                    </div>

                    <div class="col-md-4 col-lg-3 col-xl-3" style="margin-top: 50px">
                        <h5>Contact</h5>
                        <hr class="bg-dark mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> Contact information of the store</li>
                            <li><i class="fa fa-envelope mr-2"></i> tungnkss160730@fpt.edu.vn</li>
                            <li><i class="fa fa-phone mr-2"></i> +84 123456789</li>
                            <li><i class="fa fa-print mr-2"></i> +84 987654321</li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>

                    </div>
                </div>
            </div>
        </footer>
    </body>

</html>

