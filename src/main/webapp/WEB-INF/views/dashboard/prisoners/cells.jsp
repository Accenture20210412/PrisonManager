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
    <link rel="stylesheet" href="<c:url value='/resources/html/css/style.css'/>">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<header>
    <a href="<c:url value='/'/>" class="btn btn-info" role="button">Strona Główna</a>
    <a href="<c:url value="/cells/add"/>" class="btn btn-info" role="button">Dodaj nowa cela</a>
</header>
<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-12">
            <h2 class="analytics-main" style="text-align: center">Stan cel</h2>
                <br>
                <table class="table table-striped bg-light">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Numer celi</th>
                        <th scope="col">Ilość osób w celi</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cells}" var="cell">
                    <tr>
                        <td>${cell.cellNumber}</td>
                        <td>${cell.prisoners.size()}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>