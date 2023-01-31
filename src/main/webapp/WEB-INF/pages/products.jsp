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
            <div class="col col-12 p-0 m-0">
                <div class="accordion" id="accordionExample">
                    <div class="accordion-item bg-transparent border-0">
                        <h2 class="accordion-header" id="headingOne">
                            <button class="accordion-button bg-transparent collapsed" type="button"
                                    data-bs-toggle="collapse"
                                    data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Filter
                            </button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne"
                             data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                <form id="filterForm" method="get" class="form-signin p-3">
                                    <div class="py-2">
                                        <label for="name" class="sr-only">Name</label>
                                        <input type="text" id="name" name="name" class="form-control"
                                               placeholder="Name"
                                               autofocus/>
                                    </div>
                                    <div class="py-2">
                                        <label for="category" class="sr-only">Category</label>
                                        <select class="form-select" id="category" name="category">
                                            <option value="all">All</option>
                                            <option value="food">Food</option>
                                            <option value="electronics">Electronics</option>
                                        </select>
                                    </div>
                                    <div class="py-2">
                                        <button class="btn btn-primary btn-block" type="submit">Search</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
            <div class="row">
                <div class="col col-12">
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/AddProduct">Add Product</a>
                </div>
            </div>
        </c:if>
        <div class="row">
            <div class="col">
                <hr class="hr hr-blurry"/>
            </div>
        </div>
        <div class="row justify-content-center g-3">
            <c:forEach var="product" items="${products}">
                <div class="col col-12 col-md-6 col-lg-4 col-xl-3 d-flex justify-content-center">
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
                            <div class="d-flex justify-content-around mt-2">
                                <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}/AddToCart?productId=${product.id}">Add to cart</a>
                                    <a class="btn btn-danger"
                                       href="${pageContext.request.contextPath}/Return">Return</a>
                                </c:if>
                                <c:if test="${pageContext.request.isUserInRole('ADMIN') || pageContext.request.isUserInRole('CEO')}">
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/EditProduct?productId=${product.id}">Edit</a>
                                    <a class="btn btn-danger"
                                       href="${pageContext.request.contextPath}/DeleteProduct?productId=${product.id}">Delete</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</t:pageTemplate>
