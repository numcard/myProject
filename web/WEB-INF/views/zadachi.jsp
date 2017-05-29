<%-- 
    Document   : prepod
    Created on : May 26, 2017, 7:24:52 PM
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<input size="42" type="text" value="${TUmkPredmetDocument.getIDUmkPredmet().getNumNapravl().getShifrNapravl()}"><br>
<input size="42" type="text" value="${TUmkPredmetDocument.getIDUmkPredmet().getIDPredmet().getNamePredmet()}"><br>
<textarea style="margin: 0px; width: 600px; height: 100px;">${TUmkPredmetDocument.getCelPredmet()}</textarea><br>
<c:forEach var="zadachi" items="${TUmkPredmetDocument.getTRPDZadachiCollection()}">
    <textarea style="margin: 0px; width: 600px; height: 100px;">${zadachi.getRPDZadacha()}</textarea><br>
</c:forEach>