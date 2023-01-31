<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddProduct">
    <h1>Add Jobs</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddProduct">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="name">Name:</label>
                <input class="form-control" type="text" id="name" name="name"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="price">Price:</label>
                <input class="form-control" type="text" id="price" name="price"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="quantity">Quantity:</label>
                <input class="form-control" type="text" id="quantity" name="quantity"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="category">Category:</label>
                <input class="form-control" type="text" id="category" name="category"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <input class="btn btn-primary btn-lg" type="submit" value="Submit" name="submit">
            </div>
        </div>
    </form>
</t:pageTemplate>