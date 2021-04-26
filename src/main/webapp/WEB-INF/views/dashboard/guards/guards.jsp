
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
    <a href="<c:url value="/straznicy/dodaj"/>" class="btn btn-info" role="button">Nowy strażnik</a>
    <a href="<c:url value='/cele'/>" class="btn btn-info" role="button">Stan cel</a>
    <a> <form class="topright" action="/straznicy/search">
        <input type="text" placeholder="Search.." name="keyword" id="search" >
        <button type="submit" class="btn btn-info">szukaj</button>
    </form></a>

</header>
<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <h2 class="analytics-main" style="text-align: center">Lista straznikow</h2>
            <br>
            <table class="table table-striped bg-light">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Imie</th>
                    <th scope="col">Nazwisko</th>
                    <th scope="col">Wiek</th>
                    <th scope="col">Cele pod opieka</th>
                    <th scope="col">Dodaj/usun cele</th>
                    <th scope="col">Zwolnij straznika</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${guards}" var="guard">
                <form:form method="post" modelAttribute="oneGuard" action="/straznicy">
                    <tr>
                        <td><form:input readonly="true" path="id" value="${guard.id}"/></td>
                        <td><form:input type="text" readonly="true" path="name" value="${guard.name}"/></td>
                        <td><form:input type="text" readonly="true" path="surname" value="${guard.surname}"/></td>
                        <td><form:input type="text" readonly="true" path="age" value="${guard.age}"/></td>
                        <c:if test="${guard.cell==null}">
                                <td> <form:select path="cell">
                                     <c:forEach items="${cells}" var="cela">
                                         <form:option value="${cela.id}"/>
                                     </c:forEach>
                                 </form:select>
                         </c:if>
                        <c:if test="${guard.cell!=null}">
                        <td><c:out value="${guard.cell.id}"/></td>
                        </c:if>
                        <td>
                            <button type="submit" class="btn btn-secondary">Dodaj</button>
                        </td>
                        <td><a href="<c:url value="/straznicy/delete/${guard.id}"/>" class="btn btn-info" role="button">Usuń</a></td>
                    </tr>
                </form:form>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>