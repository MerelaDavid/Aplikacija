<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ include file="include/header.jsp" %>

Ime: <strong>${pacient.ime}</strong><br/>
Priimek: <strong>${pacient.priimek}</strong><br/>
Email: <strong>${pacient.email}</strong><br/>
rojstniDatum: <strong>${pacient.rojstniDatum}</strong><br/>
Posebnosti: <strong>${pacient.posebnosti}</strong><br>
Zdravnik: <strong>${zdravnik.ime}</strong><strong>${zdravnik.priimek}</strong>
<hr/>

${sporocilo}<br/>

<a href="Krmilnik?akcija=PregledVsehPacientov">Nazaj</a>

<jsp:include page="include/footer.jsp"/>