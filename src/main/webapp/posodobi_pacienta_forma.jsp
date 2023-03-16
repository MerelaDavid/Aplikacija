<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include/header.jsp"/>

<form name="form1" action="Krmilnik" method="get">
    <input type="hidden" name="akcija" value="shraniPosPacienta" />
    <h4>DODAJANJE NOVEGA PACIENTA</h4>
    <table border="1">
        <tr>
            <td>Id Pacienta</td>
            <td><input value=${pacient.id}  name="id" readonly/></td>
        </tr>
        <tr>
            <td>Ime Pacienta</td>
            <td><input value=${pacient.ime} type="text" name="ime"/></td>
        </tr>
        <tr>
            <td>Priimek Pacienta</td>
            <td><input value=${pacient.priimek} type="text" name="priimek"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input value=${pacient.email} type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Rojstni Datum</td>
            <td><input value=${pacient.rojstniDatum} type="text" name="rojstniDatum"/></td>
        </tr>
        <tr>
            <td>Posebnosti</td>
            <td><input value=${pacient.posebnosti} type="text" name="posebnosti"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="submit" value="dodaj"/></td>
        </tr>
    </table>
</form>

<hr>

<ul>
    <h4>IZBERI ZDRAVNIKA</h4>
    <c:forEach var="zdravnik" items="${zdravniki}">
        <li><c:out value="${zdravnik.priimek}" /> <c:out value="${zdravnik.ime}"/> <c:out value="${zdravnik.kvotaPacientov}" />
            [<a href="Krmilnik?akcija=dodajZDPacientu&id=${zdravnik.id}&pacientId=${pacient.id}">izberi</a>]
        </li>
    </c:forEach>
</ul>

<jsp:include page="include/footer.jsp"/>