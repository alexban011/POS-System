<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddJobs">
    <h1>Add Jobs</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddJob">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="jobTitle">Job Title:</label>
                <input class="form-control" type="text" id="jobTitle" name="jobTitle"><br><br>
                <div class="invalid-feedback">
                    jobTitle is required.
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