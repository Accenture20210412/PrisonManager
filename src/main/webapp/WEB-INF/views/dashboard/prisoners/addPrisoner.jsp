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
    <link rel="stylesheet" href="<c:url value='/resources/html/css/addForm.css'/>">

</head>
<header>
    <a href="<c:url value='/'/>" class="btn btn-info" role="button">Strona Główna</a>
    <a href="<c:url value='/osadzeni'/>" class="btn btn-info" role="button">Lista osadzonych</a>
</header>

<section class="dashboard-section">
                <form:form method="post" modelAttribute="prisoner" class="padding-small text-center">
                    <div class="container">
                        <h1>Dodaj osadzonego</h1>
                        <p>Wpisz dane osadzonego</p>
                        <hr>
                        <form:input path="name" type="text" class="form-control" name="firstName" placeholder="Imie"/>
                        <form:errors path="name" cssClass="error"/>

                        <form:input path="surname" type="text" class="form-control" name="lastName" placeholder="Nazwisko"/>
                        <form:errors path="surname" cssClass="error"/>

                        <form:input path="nickname" type="text" class="form-control" name="Ksywa"
                                    placeholder="Ksywa"/>
                        <form:errors path="nickname" cssClass="error" />

                        <form:input path="judgment" type="text" class="form-control" name="Wyrok"
                                    placeholder="Wyrok"/>
                        <form:errors path="judgment" cssClass="error"/>
                        <form:input path="gridBegin" type="date" class="form-control" name="Odsiadka"
                                placeholder="Czas odsiadki"/>
                        <form:errors path="gridBegin" cssClass="error"/>
                    <form:input path="gridEnd" type="date" class="form-control" name="Odsiadka"
                                placeholder="Czas odsiadki"/> </div>
                    <form:errors path="gridEnd" cssClass="error"/>
        </div>
    </div>
                        <hr>
                        <hr>
                    <button type="submit" class="registerbtn">Dodaj osadzonego</button>
                    </div>
                </form:form>

</section>