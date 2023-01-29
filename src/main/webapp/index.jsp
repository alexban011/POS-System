<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="Home">
    <div class="container position-absolute d-flex justify-content-center top-50 start-50 translate-middle">
        <div class="row justify-content-center">
            <div class="col col-lg-6 col-12 d-flex justify-content-center align-items-center">
                <img id="warehouse" src="${pageContext.request.contextPath}/styles/warehouse.png" />
            </div>
            <div class="col col-lg-6 col-12 d-flex align-items-center">
                <div class="h-fit">
                    <p class="text-center">
                        “The great thing about the Internet isn't that you can reconnect with old friends or stay up to date with developing world events or send pictures of newborns immediately around the
                        world. It is simply that you can log on to jcpenney.com from anywhere and order fresh underwear immediately after seeing your life flash before your eyes.”
                    </p>
                    <p class="text-end"><b>David C Holley, Write like no one is reading</b></p>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>