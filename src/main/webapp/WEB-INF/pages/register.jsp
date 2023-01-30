<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Login">
    <div class="container position-absolute top-50 start-50 translate-middle d-flex justify-content-center">
        <div class="row w-100 d-flex justify-content-center">
            <div class="col col-11 col-lg-5">
                <div class="bg-light shadow-lg rounded-3">
                    <div class="rounded-top shadow-sm py-1 px-3">
                        <h1 class="h3  font-weight-normal">Sign up</h1>
                    </div>
                    <form class="form-signin p-3" method="POST" action="${pageContext.request.contextPath}/Register">
                        <div class="p-2 m">
                            <label for="email" class="sr-only">Email</label>
                            <input type="text" id="email" name="email" class="form-control"
                                   placeholder="Email"
                                   required autofocus/>
                        </div>
                        <div class="p-2 m">
                            <label for="username" class="sr-only">Username</label>
                            <input type="text" id="username" name="username" class="form-control"
                                   placeholder="Username"
                                   required autofocus/>
                        </div>
                        <div class="p-2">
                            <label for="password" class="sr-only">Password</label>
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="Password"
                                   required/>
                        </div>
                        <div class="p-2">
                            <label for="confirmPassword" class="sr-only">Confirm Password</label>
                            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control"
                                   placeholder="Confirm Password"
                                   required/>
                        </div>
                        <c:if test="${message != null}">
                            <div class="alert alert-warning m-2" role="alert">
                                    ${message}
                            </div>
                        </c:if>
                        <div class="p-2 w-100 d-flex justify-content-center">
                            <button class="btn btn-lg mx-2 btn-primary btn-block" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>