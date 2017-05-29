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
        <th>Номер направления</th>
        <th>№ цикла</th>
        <th>№ п.п.</th>
        <th>Дисциплина</th>
        <th>Ответственный</th>
        <th>*</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="TUmkTPredmet" items="${TUmkTPredmet}">
        <tr>
            <td><button type="button" class="btn btn-info">${TUmkTPredmet.getNumNapravl().getShifrNapravl()}</button></td>
            <td>${TUmkTPredmet.getNumUchCikl().getNumUchCikl()}</td>
            <td>${TUmkTPredmet.getNumPorjadok()}</td>
            <td>${TUmkTPredmet.getIDPredmet().getNamePredmet()}</td>
            <td>${TUmkTPredmet.getPrepod().getSurName()} ${TUmkTPredmet.getPrepod().getName()} ${TUmkTPredmet.getPrepod().getPatronymic()}</td>
            <td>
                <form action="umkPredmetDocument">
                    <input type="hidden" name="IDUmkPredmet" value="${TUmkTPredmet.getIDUmkPredmet()}">
                    <input type="submit" class="btn btn-default" value="Документы"> 
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>