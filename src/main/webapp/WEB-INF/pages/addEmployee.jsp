<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddEmployees">
    <h1>Add Jobs</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddEmployee">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Employee user:</label>
                <input class="form-control" type="text" id="username" name="username"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="jobTitle">job title:</label>
                <input class="form-control" type="text" id="jobTitle" name="jobTitle"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="salary">salary:</label>
                <input class="form-control" type="text" id="salary" name="salary"><br><br>
                <div class="invalid-feedback">
                    user is required.
                </div>
            </div>
            Pagina asta trb sa te lase sa selectezi un user (ii scrie username-ul), un job si salariul
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <input class="btn btn-primary btn-lg" type="submit" value="Submit" name="submit">
            </div>
        </div>
    </form>
</t:pageTemplate>