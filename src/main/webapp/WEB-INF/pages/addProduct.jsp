<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddProduct">
    <div class="container bg-light shadow-lg rounded-3 pb-4">
        <div class="row">
            <div class="col bg-light shadow-sm py-1 px-3 rounded-top">
                <h1 class="h3  font-weight-normal">Add Product</h1>
            </div>
        </div>
        <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/AddProduct">
            <div class="row justify-content-between g-3 mt-3">
                <div class="col col-12 col-md-6 p-2">
                    <label for="name">Name:</label>
                    <input class="form-control" type="text" required id="name" name="name">
                    <div class="invalid-feedback">
                        Name is required.
                    </div>
                </div>
                <div class="col col-12 col-md-6 p-2">
                    <label for="price">Price:</label>
                    <input class="form-control" type="text" required id="price" name="price">
                    <div class="invalid-feedback">
                        Price is required.
                    </div>
                </div>
                <div class="col col-12 col-md-6 p-2">
                    <label for="quantity">Quantity:</label>
                    <input class="form-control" type="text" required id="quantity" name="quantity">
                    <div class="invalid-feedback">
                        Quantity is required.
                    </div>
                </div>
                <div class="col col-12 col-md-6 p-2">
                    <label for="category">Category:</label>
                    <input class="form-control" type="text" required id="category" name="category">
                    <div class="invalid-feedback">
                        Category is required.
                    </div>
                </div>
            </div>
            <div class="row g-3">
                <div class="col col-12 justify-content-center d-flex p-2">
                    <input class="btn btn-success" type="submit" value="Submit" name="submit"/>
                </div>
            </div>
        </form>
    </div>
</t:pageTemplate>