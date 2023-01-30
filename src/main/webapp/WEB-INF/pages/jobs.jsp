<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Jobs">
    <h1>Jobs</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Jobs">
        <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddJob">Add Job</a>
            <button class="btn btn-danger" type="submit">Delete Jobs</button>
        </c:if>
        <div class="container text-center">
            <c:forEach var="job" items="${jobs}">
                <div class="row">
                    <div class="col">
                        <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
                            <input type="checkbox" name="job_ids" value="${job.id}" />
                        </c:if>
                    </div>
                    <div class="col">
                            ${job.jobTitle}
                    </div>
                </div>
            </c:forEach>
        </div>
    </form>
</t:pageTemplate>