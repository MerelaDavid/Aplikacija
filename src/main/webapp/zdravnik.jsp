<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="include/header.jsp" %>
<h3>ZDRAVNIKOVI PODATKI</h3>
<br>
Ime: <strong>${oseba.ime}</strong><br/>
Priimek: <strong>${oseba.priimek}</strong><br/>
Email: <strong>${oseba.email}</strong><br/>
Kvota Pacientov: <strong>${oseba.kvotaPacientov}</strong><br/>


<h4>ZDRAVNIKOVI PACIENTI</h4>
<h4>Prosta mesta:  <strong>${prostaMesta}</strong></h4>


<ol>
    <c:forEach var="pac" items="${pacienti}">
        <li><c:out value="${pac.priimek}" /> <c:out value="${pac.ime}" />
        </li>
    </c:forEach>
</ol>

<a href="Krmilnik?akcija=PregledVsehZdravnikov">Nazaj</a>

<jsp:include page="include/footer.jsp"/>