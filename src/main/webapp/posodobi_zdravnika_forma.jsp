<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp" %>
<jsp:include page="include/header.jsp"/>

<form name="form1" action="Krmilnik" method="get">
  <input type="hidden" name="akcija" value="shraniPosZdravnika" />
  <h4>DODAJANJE NOVEGA ZDRAVNIKA</h4>
  <table border="1">
    <tr>
      <td>Id Zdravnika</td>
      <td><input value=${zdravnik.id}  name="id" readonly/></td>
    </tr>
    <tr>
      <td>Ime Zdravnika</td>
      <td><input value=${zdravnik.ime} type="text" name="ime"/></td>
    </tr>
    <tr>
      <td>Priimek Zdravnika</td>
      <td><input value=${zdravnik.priimek} type="text" name="priimek"/></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input value=${zdravnik.email} type="text" name="email"/></td>
    </tr>
    <tr>
      <td>Kvota Pacientov</td>
      <td><input value=${zdravnik.kvotaPacientov} type="text" name="kvotaPacientov"/></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="submit" value="posodobi"/></td>
    </tr>
  </table>
</form>

<jsp:include page="include/footer.jsp"/>