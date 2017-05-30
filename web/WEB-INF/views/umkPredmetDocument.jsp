<%-- 
    Document   : prepod
    Created on : May 26, 2017, 7:24:52 PM
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Предмет</th>
        <th>Вид документа</th>
        <th>Дата</th>
        <th>Статус</th>
        <th>Ответственный</th>
        <th>*</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="TUmkPredmetDocument" items="${TUmkPredmetDocument}">
        <tr>
            <td>
                <a href="umkPredmet?shifrNapravl=${TUmkPredmetDocument.getIDUmkPredmet().getNumNapravl().getShifrNapravl()}" class="btn btn-info">
                    ${TUmkPredmetDocument.getIDUmkPredmet().getIDPredmet().getNamePredmet()}
                </a>
            </td>
            <td>${TUmkPredmetDocument.getVidDocum().getVidDocum()}</td>
            <td>${TUmkPredmetDocument.getDataDocum()}</td>
            <td>${TUmkPredmetDocument.getStatus()}</td>
            <td>${TUmkPredmetDocument.getPrepod().getSurName()} ${TUmkPredmetDocument.getPrepod().getName()} ${TUmkPredmetDocument.getPrepod().getPatronymic()}</td>
            <td>
                <form action="zadachi">
                    <input type="hidden" name="IDUmkPredmetDocument" value="${TUmkPredmetDocument.getIdUmkPredmetDocument()}">
                    <input type="submit" class="btn btn-default" value="Задачи"> 
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>