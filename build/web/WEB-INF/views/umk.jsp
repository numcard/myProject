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
        <th>Направл. сокр.</th>
        <th>Направление</th>
        <th>Номер направления</th>
        <th>Квалификация</th>
        <th>Профиль</th>
        <th>Форма обучения</th>
        <th>*</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="TUmk" items="${TUmk}">
        <tr>
            <td>${TUmk.getNameNapravlSokr()}</td>
            <td>${TUmk.getNameNapravl()}</td>
            <td>${TUmk.getShifrNapravl()}</td>
            <td>${TUmk.getKvalifikac()}</td>
            <td>${TUmk.getProfil()}</td>
            <td>${TUmk.getFormaObuch()}</td>
            <td>
                <form action="umkPredmet">
                    <input type="hidden" name="shifrNapravl" value="${TUmk.getShifrNapravl()}">
                    <input type="submit" class="btn btn-default" value="Выбрать"> 
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>