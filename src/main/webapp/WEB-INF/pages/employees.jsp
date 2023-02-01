<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Jobs">
    <%--    <h1>Jobs</h1>--%>
    <%--    <form method="POST" action="${pageContext.request.contextPath}/Employees">--%>
    <%--        <c:if test="${pageContext.request.isUserInRole('HR') || pageContext.request.isUserInRole('ADMIN')}">--%>
    <%--            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddEmployee">Add employee</a>--%>
    <%--            <button class="btn btn-danger" type="submit">Delete Jobs</button>--%>
    <%--            <p>Pagina asta ar arata defapt ca cea de Users de la parkinglot: Lista cu toti angajatii, posibilitatea de a--%>
    <%--                selecta mai multi angajati iar angajatii sa aibe butoane de edit pentru a putea schimba--%>
    <%--                jobul/salariul</p>--%>
    <%--        </c:if>--%>
    <%--    </form>--%>
    <div class="container bg-light shadow-lg rounded-3 pb-4">
        <div class="row">
            <div class="col bg-light shadow-sm py-1 px-3 rounded-top">
                <h1 class="h3  font-weight-normal">Employees</h1>
            </div>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/Employees">
            <c:if test="${pageContext.request.isUserInRole('ADMIN') || pageContext.request.isUserInRole('HR')}">
                <div class="row mt-3">
                    <div class="col col-12">
                        <a class="btn btn-success" href="${pageContext.request.contextPath}/AddEmployee">Add
                            Employee</a>
                        <button type="submit" class="btn btn-danger">Delete Selected</button>
                    </div>
                </div>
            </c:if>
            <div class="row justify-content-between g-3 mt-3">
                <div class="col col-12">
                    <table class="table align-middle">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Username</th>
                            <th scope="col">Job Title</th>
                            <th scope="col">Salary</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <th class="">
                                    <c:if test="${pageContext.request.isUserInRole('HR') || pageContext.request.isUserInRole('ADMIN')}">
                                        <input type="checkbox" name="employeeId" value="${employee.id}"/>
                                    </c:if>
                                </th>
                                <td>${employee.username}</td>
                                <td>${employee.jobTitle}</td>
                                <td>${employee.salary}</td>
                                <td>
<%--                                    <a class="btn btn-primary">Edit</a>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
    </div>
</t:pageTemplate>