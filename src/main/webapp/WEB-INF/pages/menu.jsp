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
                        <a class="nav-link" href="${pageContext.request.contextPath}/Jobs">Posts</a>
                    </li>
                    <c:if test="${pageContext.request.isUserInRole('HR') || pageContext.request.isUserInRole('ADMIN')}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Employees">Employees</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Products">Products</a>
                    </li>
                    <c:if test="${pageContext.request.isUserInRole('CASHIER') || pageContext.request.isUserInRole('ADMIN')}">
                        <li class="nav-item">
                            <a class="nav-link position-relative" href="${pageContext.request.contextPath}/Cart">
                                Cart
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${pageContext.request.getRemoteUser() == null}">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <c:if test="${pageContext.request.getRemoteUser() == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Register">Register</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
