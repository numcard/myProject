<%-- 
    Document   : prepod
    Created on : May 26, 2017, 7:24:52 PM
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:forEach var="TUmkPredmetDocument" items="${TUmkPredmetDocument}">
    <nobr>
    <input size="38" type="text" value="${TUmkPredmetDocument.getIDUmkPredmet().getIDPredmet().getNamePredmet()}">
    <input size="14" type="text" value="${TUmkPredmetDocument.getVidDocum().getVidDocum()}">
    <input size="6" type="text" value="${TUmkPredmetDocument.getDataDocum()}">
    <input size="8" type="text" value="${TUmkPredmetDocument.getStatus()}">
    <input size="28" type="text" value="${TUmkPredmetDocument.getPrepod().getSurName()} ${TUmkPredmetDocument.getPrepod().getName()} ${TUmkPredmetDocument.getPrepod().getPatronymic()}">
    <form action="zadachi" style="display: inline;">
        <input type="hidden" name="IDUmkPredmetDocument" value="${TUmkPredmetDocument.getIdUmkPredmetDocument()}">
        <input type="hidden" name="IDPredmet" value="${TUmkPredmetDocument.getIDUmkPredmet().getIDPredmet().getIDPredmet()}">
        <input type="submit" value="Задачи"> 
    </form>
    </nobr>
</c:forEach>