<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddEmployees">
    <div class="container position-absolute top-50 start-50 translate-middle d-flex justify-content-center">
        <div class="row w-100 d-flex justify-content-center">
            <div class="col col-11 col-lg-5">
                <div class="bg-light shadow-lg rounded-3">
                    <div class="rounded-top shadow-sm py-1 px-3">
                        <h1 class="h3  font-weight-normal">Add Employee</h1>
                    </div>
                    <form class="needs-validation p-3" novalidate method="POST" action="${pageContext.request.contextPath}/AddEmployee">
                        <div class="p-2">
                            <label for="userId" class="sr-only">Username</label>
                            <select required class="form-select" id="userId" name="userId">
                                <c:forEach var="user" items="${users}">
                                    <option value="${user.id}">${user.username}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="p-2">
                            <label for="jobId" class="sr-only">Job</label>
                            <select required class="form-select" id="jobId" name="jobId">
                                <c:forEach var="job" items="${jobs}">
                                    <option value="${job.id}">${job.jobTitle}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="p-2">
                            <label for="salary" class="sr-only">Salary</label>
                            <input type="text" id="salary" name="salary" class="form-control"
                                   placeholder="Salary"
                                   required/>
                        </div>
                        <div class="p-2 w-100 d-flex justify-content-center">
                            <button class="btn btn-lg mx-2 btn-primary btn-block" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>