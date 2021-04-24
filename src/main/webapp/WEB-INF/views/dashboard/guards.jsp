
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<meta charset="utf-8">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/html/css/landingAdminPage.css'/>">
</head>
<header>
    <a href="<c:url value='/'/>" class="btn btn-info" role="button">Strona Główna</a>
    <a href="<c:url value="/search"/>" class="btn btn-info" role="button">Wyszukaj</a>
    <a href="<c:url value="/straznicy/dodaj"/>" class="btn btn-info" role="button">Nowy strażnik</a>
    <a href="<c:url value='/cele'/>" class="btn btn-info" role="button">Stan cel</a>
    <a href="<c:url value='/'/>"class="btn btn-info" role="button">Wyloguj</a>


</header>
<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <h2 class="analytics-main" style="text-align: center">Lista straznikow</h2>
            <br>
            <table class="table table-striped bg-light">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Imię</th>
                    <th scope="col">Nazwisko</th>
                    <th scope="col">Wiek</th>
                    <th scope="col"></th>
                    <th scope="col"></th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${guards}" var="guard">
                    <tr>
                        <td>${guard.name}</td>
                        <td>${guard.surname}</td>
                        <td>${guard.age}</td>
                        <td><a href="<c:url value="/straznicy/delete/${guard.id}"/>" class="btn btn-info" role="button">Usuń</a></td>
                        <td></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>