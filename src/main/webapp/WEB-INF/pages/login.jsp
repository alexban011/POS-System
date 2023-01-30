<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Login">
    <div class="container position-absolute top-50 start-50 translate-middle d-flex justify-content-center">
        <div class="row w-100 d-flex justify-content-center">
            <div class="col col-11 col-lg-5">
                <div class="bg-light shadow-lg rounded-3">
                    <div class="rounded-top shadow-sm py-1 px-3">
                        <h1 class="h3  font-weight-normal">Sign in</h1>
                    </div>
                    <form class="form-signin p-3" method="POST" action="j_security_check">
                        <div class="p-2 m">
                            <label for="username" class="sr-only">Username</label>
                            <input type="text" id="username" name="j_username" class="form-control"
                                   placeholder="Username"
                                   required autofocus/>
                        </div>
                        <div class="p-2">
                            <label for="password" class="sr-only">Password</label>
                            <input type="password" id="password" name="j_password" class="form-control"
                                   placeholder="Password"
                                   required/>
                        </div>
                        <c:if test="${message != null}">
                            <div class="alert alert-warning m-2" role="alert">
                                    ${message}
                            </div>
                        </c:if>
                        <div class="p-2 w-100 d-flex justify-content-center">
                            <button class="btn btn-lg mx-2 btn-primary btn-block" type="submit">Sign in</button>
                            <a class="btn btn-lg mx-2 btn-success btn-block" href="${pageContext.request.contextPath}/Register">Sign up</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>