<%@page import="tungnk.order.OrderDTO"%>
<%@page import="tungnk.category.CategoriesDTO"%>
<%@page import="tungnk.category.CategoriesDAO"%>
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
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
                        <% AccountDTO user = (AccountDTO) session.getAttribute("USER");
                            if (user == null) {%>
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp">Sign In</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="SignUp.jsp">Sign Up</a>
                        </li>
                        <%} else {
                            if (user.getIsAdmin() != true) {%>
                        <li class="nav-item">
                            <p class="nav-link"><%= user.getUserName()%></p>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="HomeServlet?action=Logout">Log out</a>
                        </li>
                        <%} else {%>
                        <li class="nav-item">
                            <p class="nav-link">Welcome, Admin <%= user.getUserName()%></p>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="HomeServlet?action=Logout">Log out</a>
                        </li>
                        <%}
                            }%>
                    </ul>

                    <form action="HomeServlet" method="POST" class="form-inline my-2 my-lg-0">        
                        <div class="input-group input-group-sm">
                            <input name="txtSearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search" value="${param.txtSearch}">
                        </div>
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary btn-number" name="action" value="Search">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>

                        <% boolean isAdmin = false;
                            try {
                                isAdmin = user.getIsAdmin();
                            } catch (Exception ex) {
                                isAdmin = false;
                            }
                            if (isAdmin) {

                            } else {%>

                        <a class="btn btn-success btn-sm ml-3" href="HomeServlet?action=ViewCart">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light"></span>
                        </a>
                        <a class="btn btn-success btn-sm ml-3" href="HomeServlet?action=View+History+Orders">
                            View History Orders
                        </a>
                        <%}%>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">The pizza world at your fingertips</h1>
                <p class="lead text-muted mb-0">The leading place to order pizza in Vietnam</p>
            </div>
        </section>
        <!--end of menu-->
        <div class="container">
            <span style="color: red">${message}</span>
            <div class="row">
                <div class="col" >
                    <nav aria-label="breadcrumb" >
                        <ol class="breadcrumb" style="display: flex; align-items: center;">
                            <li class="breadcrumb-item"><a href="HomeServlet">Home</a></li> <!--  nút bấm quay về trang home-->
                            <li class="breadcrumb-item" style="display: flex; justify-content: center; align-items: center">Filter by price <form action="HomeServlet" method="POST" class="form-inline my-2 my-lg-0">

                                    <div class="input-group input-group-sm">
                                        <input name="numSearch1" type="number" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Min" required="">
                                    </div>
                                    <div class="input-group input-group-sm">
                                        <input name="numSearch2" type="number" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Max" required="">
                                    </div>
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-secondary btn-number" name="action" value="Purchase">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </form></li>
                                <% if (isAdmin) { %>
     
                            <li class="breadcrumb-item"><a href="HomeServlet?action=View+All+Orders">View All Orders</a></li> 
                            <li class="breadcrumb-item"><a href="Report.jsp">Report</a></li> 
                                <%}%>
                            <li style="margin-left:  300px"><% String msg = (String) request.getAttribute("MESSAGE");
                                if (msg != null) {
                                %>
                                <font color="red"><%= msg%></font>
                                <% } %>
                            </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase">
                            <i class="fa fa-list"></i> 
                            Category
                        </div>
                        <% List<CategoriesDTO> cList = (List<CategoriesDTO>) request.getAttribute("LIST_CATEGORY"); %>
                        <ul class="list-group category_block">
                            <%for (CategoriesDTO item : cList) {%>

                            <li class="list-group-item text-white">
                                <a href=<%= "HomeServlet?action=Search&txtCategoryID=" + item.getCid()%>><%= item.getCname()%></a>
                            </li>
                            <%}%>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <form action="HomeServlet" method="POST">
                        <div class="input-group input-group-sm">
                            <input name="date1" type="date" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" required="">
                        </div>
                        <div class="input-group input-group-sm">
                            <input name="date2" type="date" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" required="">
                        </div>
                            <input type="submit" name="action" value="Report">
                        </form>
                        <%if(request.getAttribute("LIST_ORDER") == null) {
                            
                        }else {%>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">No.</th>
                                    <th scope="col">Order ID</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <% List<OrderDTO> list = (List<OrderDTO>) request.getAttribute("LIST_ORDER"); 
                                double revenue = (double)request.getAttribute("REVENUE"); %>
                            <tbody>
                                <% int count = 0;
                                    for (OrderDTO o : list) {%>
                                <tr>
                            <form action="HomeServlet" method="POST">
                                <th scope="row"><%= ++count%></th>
                                <td><%= o.getOrder_id() %></td>
                                <input type="hidden" name="txtOrderID" value=<%= o.getOrder_id() %>>
                                <td><%= o.getOrder_date() %></td>
                                <td><%= o.getAddress()%></td>
                                <td><%= o.getPhone()%></td>
                                <td>
                                    <input type="submit" class="btn btn-outline-primary" name="action" value="View Order Detail">
                                </td>
                            </form>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                            <h3>Revenue: <%= revenue %></h3>
                            <%}%>
                              
                    </div>
                </div>

            </div>
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

