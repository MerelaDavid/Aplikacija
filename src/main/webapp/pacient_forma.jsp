<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp" %>
<jsp:include page="include/header.jsp"/>

<form name="form1" action="Krmilnik" method="get">
    <input type="hidden" name="akcija" value="vnosPacient" />
    <h4>DODAJANJE NOVEGA PACIENTA</h4>
    <table border="1">
        <tr>
            <td>Ime Pacienta</td>
            <td><input type="text" name="ime"/></td>
        </tr>
        <tr>
            <td>Priimek Pacienta</td>
            <td><input type="text" name="priimek"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Rojstni Datum</td>
            <td><input type="text" name="rojstniDatum"/></td>
        </tr>
        <tr>
            <td>Posebnosti</td>
            <td><input type="text" name="posebnosti"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="submit" value="dodaj"/></td>
        </tr>
    </table>
</form>

<jsp:include page="include/footer.jsp"/>