<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Jobs">
    <h1>Jobs</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Employees">
        <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddEmployee">Add employee</a>
            <button class="btn btn-danger" type="submit">Delete Jobs</button>
            <p>Pagina asta ar arata defapt ca cea de Users de la parkinglot: Lista cu toti angajatii, posibilitatea de a
                selecta mai multi angajati iar angajatii sa aibe butoane de edit pentru a putea schimba jobul/salariul</p>
        </c:if>

    </form>
</t:pageTemplate>