<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<ul>
    <h4>POLNI ZDRAVNIKI</h4>
    <c:forEach var="zdravnik" items="${osebe}">
        <li><c:out value="${zdravnik.priimek}" /> <c:out value="${zdravnik.ime}" />
            [<a href="Krmilnik?akcija=pregledZdravnik&id=${zdravnik.id}">pregled</a>]
            [<a href="Krmilnik?akcija=PosodobiZdravnika&id=${zdravnik.id}">posodobi</a>]
            [<a href="Krmilnik?akcija=izbrisZdravnika&id=${zdravnik.id}">izbrisi</a>]
        </li>
    </c:forEach>
</ul>

<hr />
<a href="vse.jsp">Nazaj</a>

<jsp:include page="include/footer.jsp" />