<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Products">
    <div class="container bg-light shadow-lg rounded-3 pb-4">
        <div class="row">
            <div class="col bg-light shadow-sm py-1 px-3 rounded-top">
                <h1 class="h3  font-weight-normal">Products</h1>
            </div>
        </div>
        <div class="row">
            <div class="col col-12 col-md-6 col-lg-4">
                <form class="form-signin p-3">
                    <div class="py-2">
                        <label for="name" class="sr-only">Name</label>
                        <input type="text" id="name" name="name" class="form-control"
                               placeholder="Name"
                               autofocus/>
                    </div>
                    <div class="py-2">
                        <label for="category" class="sr-only">Category</label>
                        <select class="form-select" id="category" name="category">
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <div class="py-2">
                        <button class="btn btn-primary btn-block" type="submit">Search</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <hr class="hr hr-blurry"/>
            </div>
        </div>

        <div class="row justify-content-center">
            <c:forEach var="product" items="${products}">
                <div class="col col-12 col-md-6 col-lg-4 d-flex justify-content-center">
                    <div class="card" style="width: 18rem;">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <div class="d-flex justify-content-between">
                                <div class="d-flex align-items-center">
                                    <div>
                                        <h5>${product.name}</h5>
                                        <p>${product.category}</p>
                                    </div>
                                </div>
                                <div class="d-flex align-items-center">
                                    <p>${product.price} lei</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>

    <%--    <form method="POST" action="${pageContext.request.contextPath}/Products">--%>
    <%--        <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">--%>
    <%--            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddProduct">Add Car</a>--%>
    <%--            <button class="btn btn-danger" type="submit">Delete Products</button>--%>
    <%--        </c:if>--%>
    <%--        <div class="container text-center">--%>
    <%--            <div class="row">--%>
    <%--                <div class="col">--%>
    <%--                    Nume produs--%>
    <%--                </div>--%>
    <%--                <div class="col">--%>
    <%--                    Pret--%>
    <%--                </div>--%>
    <%--                <div class="col">--%>
    <%--                    Cantitate--%>
    <%--                </div>--%>
    <%--                <div class="col">--%>
    <%--                    Categorie--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <c:forEach var="product" items="${products}">--%>
    <%--                <div class="row">--%>
    <%--                    <div class="col">--%>
    <%--                        <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">--%>
    <%--                            <input type="checkbox" name="products_ids" value="${product.id}" />--%>
    <%--                        </c:if>--%>
    <%--                    </div>--%>
    <%--                    <div class="col">--%>
    <%--                            ${product.name}--%>
    <%--                    </div>--%>
    <%--                    <div class="col">--%>
    <%--                            ${product.price}--%>
    <%--                    </div>--%>
    <%--                    <div class="col">--%>
    <%--                            ${product.quantity}--%>
    <%--                    </div>--%>
    <%--                    <div class="col">--%>
    <%--                            ${product.category}--%>
    <%--                    </div>--%>
    <%--                    <div class="col">--%>
    <%--                        <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">--%>
    <%--                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCar?id=${product.id}">Edit Product</a>--%>
    <%--                        </c:if>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </c:forEach>--%>
    <%--        </div>--%>
    <%--    </form>--%>

</t:pageTemplate>