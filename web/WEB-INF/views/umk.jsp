<%-- 
    Document   : prepod
    Created on : May 26, 2017, 7:24:52 PM
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:forEach var="TUmk" items="${TUmk}">
    <form action="umkPredmet">
        <input size="12" type="text" value="${TUmk.getNameNapravlSokr()}">
        <input size="40" type="text" value="${TUmk.getNameNapravl()}">
        <input size="12" type="text" name="shifrNapravl" value="${TUmk.getShifrNapravl()}">
        <input size="24" type="text" value="${TUmk.getKvalifikac()}">
        <input size="12" type="text" value="${TUmk.getProfil()}">
        <input size="12" type="text" value="${TUmk.getFormaObuch()}">
        <input type="submit" value="Select"> 
    </form>
</c:forEach>
