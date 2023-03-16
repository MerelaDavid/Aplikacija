<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<ul>
  <h4>PACIENTI Z ZDRAVNIKI</h4>
  <c:forEach var="pcz" items="${pacientiZZdravnikom}">
    <li><c:out value="${pcz.priimek}" /> <c:out value="${pcz.ime}" />
      [<a href="Krmilnik?akcija=pregledPacient&id=${pcz.id}">pregled</a>]
      [<a href="Krmilnik?akcija=PosodobiPacienta&id=${pcz.id}">posodobi</a>]
      [<a href="Krmilnik?akcija=izbrisPacienta&id=${pcz.id}">izbrisi</a>]
    </li>
  </c:forEach>
</ul>

<hr><br>

<ul>
  <h4>PACIENTI BREZ ZDRAVNIKA</h4>
  <c:forEach var="pac" items="${pacientiBrezZdravnika}">
    <li><c:out value="${pac.priimek}" /> <c:out value="${pac.ime}" />
      [<a href="Krmilnik?akcija=pregledPacient&id=${pac.id}">pregled</a>]
      [<a href="Krmilnik?akcija=PosodobiPacienta&id=${pac.id}">posodobi</a>]
      [<a href="Krmilnik?akcija=izbrisPacienta&id=${pac.id}">izbrisi</a>]
    </li>
  </c:forEach>
  <a href="pacient_forma.jsp">Dodaj pacienta</a>
</ul>

<hr />
<a href="vse.jsp">Nazaj</a>

<jsp:include page="include/footer.jsp" />