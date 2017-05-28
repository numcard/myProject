<%-- 
    Document   : prepod
    Created on : May 26, 2017, 7:24:52 PM
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:forEach var="TUmkTPredmet" items="${TUmkTPredmet}">
    <form action="umkPredmetDocument">
        <input type="hidden" name="IDUmkPredmet" value="${TUmkTPredmet.getIDUmkPredmet()}">
        <input size="8" type="text" value="${TUmkTPredmet.getNumNapravl().getShifrNapravl()}">
        <input size="8" type="text" value="${TUmkTPredmet.getNumUchCikl().getNumUchCikl()}">
        <input size="4" type="text" value="${TUmkTPredmet.getNumPorjadok()}">
        <input size="28" type="text" value="${TUmkTPredmet.getIDPredmet().getNamePredmet()}">
        <input size="28" type="text" value="${TUmkTPredmet.getPrepod().getSurName()} ${TUmkTPredmet.getPrepod().getName()} ${TUmkTPredmet.getPrepod().getPatronymic()}">
        <input type="submit" value="Select"> 
    </form>
</c:forEach>