<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<ul>
    <h4>ZDRAVNIKI</h4>
    <a href="Krmilnik?akcija=PregledVsehZdravnikov">Upravljanje zdravnikov</a>
    <h4>PACIENTI</h4>
    <a href="Krmilnik?akcija=PregledVsehPacientov">Upravljanje pacientov</a>

</ul>
<jsp:include page="include/footer.jsp" />