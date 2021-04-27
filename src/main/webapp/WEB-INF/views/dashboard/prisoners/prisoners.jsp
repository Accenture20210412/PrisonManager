<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/html/css/landingAdminPage.css'/>">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<header>
    <a href="<c:url value='/'/>" class="btn btn-info" role="button">Strona Główna</a>
    <a href="<c:url value="/osadzeni/dodaj"/>" class="btn btn-info" role="button">Dodaj osadzonego</a>
    <a href="<c:url value='/straznicy/dodaj'/>" class="btn btn-info" role="button">Dodaj straznika</a>
    <a href="<c:url value='/straznicy'/>" class="btn btn-info" role="button">Straznicy</a>
    <a href="<c:url value='/cele'/>" class="btn btn-info" role="button">Stan cel</a>
    <a> <form class="topright" action="/osadzeni/search">
        <input type="text" placeholder="Search.." name="keyword" id="search" >
        <button type="submit" class="btn btn-info">szukaj</button>
    </form></a>
</header>
<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <h2 class="analytics-main" style="text-align: center">Lista osadzonych</h2>
                <br>
                <table class="table table-striped bg-light" width="100%">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Imie</th>
                        <th scope="col">Nazwisko</th>
                        <th scope="col">Ksywa</th>
                        <th scope="col">Wyrok</th>
                        <th scope="col">Poczatek wyroku</th>
                        <th scope="col">Koniec wyroku</th>
                        <th scope="col">Cela</th>
                        <th scope="col">Dodaj/usun cele</th>
                        <th scope="col">Wypusc</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${prisoners}" var="prisoner">
                            <form:form method="post" modelAttribute="onePrisoner" action="/osadzeni" >
                        <tr>
                            <td><form:input size="4" readonly="true" path="id" value="${prisoner.id}"/></td>
                            <td><form:input size="10" type="text" readonly="true" path="name" value="${prisoner.name}"/></td>
                            <td><form:input size="10" type="text" readonly="true" path="surname" value="${prisoner.surname}"/></td>
                            <td><form:input size="10" type="text" readonly="true" path="nickname" value="${prisoner.nickname}"/></td>
                            <td><form:input size="10" type="text" readonly="true" path="judgment" value="${prisoner.judgment}"/></td>
                            <td><form:input size="8" type="text" readonly="true" path="gridBegin" value="${prisoner.gridBegin}"/></td>
                            <td><form:input size="8" type="text" readonly="true" path="gridEnd" value="${prisoner.gridEnd}"/></td>
                            <c:if test="${prisoner.cell==null}">
                            <td> <form:select path="cell">
                                <c:forEach items="${cells}" var="cela">
                                    <form:option value="${cela.id}"/>
                                </c:forEach>
                                </form:select>
                                </c:if>
                                <c:if test="${prisoner.cell!=null}">
                            <td><c:out value="${prisoner.cell.id}"/></td>
                            </c:if>
                            <td>
                                <button type="submit" class="btn btn-secondary">Dodaj/Usun</button>
                            </td>
                            <td><a href="<c:url value="/osadzeni/delete/${prisoner.id}"/>" class="btn btn-info" role="button">Usuń</a></td>
                        </tr>
                            </form:form>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>