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

    <jsp:include page="header.jsp"/>
</head>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border">
            <div class="container w-25">
                <form:form method="post" modelAttribute="prisoner" class="padding-small text-center">
                    <h1 class="text-color-darker">Dodaj osadzonego</h1>
                    <div class="form-group">
                        <form:input path="name" type="text" class="form-control" name="firstName" placeholder="Imie"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="form-group">
                        <form:input path="surname" type="text" class="form-control" name="lastName" placeholder="Nazwisko"/>
                        <form:errors path="surname"/>
                    </div>
                    <div class="form-group">
                        <form:input path="nickname" type="text" class="form-control" name="Ksywa"
                                    placeholder="Ksywa"/>
                        <form:errors path="nickname"/>
                    </div>
                    <div class="form-group">
                        <form:input path="judgment" type="text" class="form-control" name="Wyrok"
                                    placeholder="Wyrok"/>
                        <form:errors path="judgment"/>
                    </div>
                    <div class="form-group">
                        <form:input path="gridBegin" type="text" class="form-control" name="Poczatek"
                                    placeholder="Poczatek wyroku"/>
                        <form:errors path="gridBegin"/>
<%--                    </div>--%>
                    <button class="btn btn-color rounded-0" type="submit">Dodaj osadzonego</button>
                </form:form>
            </div>
        </div>
    </div>
</section>