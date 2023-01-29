<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow z-index-100">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">NextGen POS</a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/Candidates.jsp">Candidates</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Posts.jsp">Posts</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Employees.jsp">Employees</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Return.jsp">Return</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Sell.jsp">Sell</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Products.jsp">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Login">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
