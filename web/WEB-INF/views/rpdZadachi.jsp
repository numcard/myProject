<%-- 
    Document   : prepod
    Created on : May 26, 2017, 7:24:52 PM
    Author     : Александр
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<table class="table">
    <thead>
    <tr>
        <th>Номер направления</th>
        <th>Дисциплина</th>
        <th>Цель РПД</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td><button type="button" class="btn btn-info">${TUmkPredmetDocument.getIDUmkPredmet().getNumNapravl().getShifrNapravl()}</button></td>
            <td><button type="button" class="btn btn-info">${TUmkPredmetDocument.getIDUmkPredmet().getIDPredmet().getNamePredmet()}</button></td>
            <td>${TUmkPredmetDocument.getCelPredmet()}</td>
        </tr>
    </tbody>
</table>
        
<table class="table table-hover">
    <thead>
    <tr>
        <th>Задачи в РПД</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="zadachi" items="${TRPDZadachi}">
        <tr>
            <form action="edit_zadachi">
            <td  class="col-md-5">
                <textarea class="form-control" name="RPDZadacha" rows="3">${zadachi.getRPDZadacha()}</textarea>
            </td>
            <td  class="col-md-1">
                    <input type="hidden" name="idRPDZadachi" value="${zadachi.getIdRPDZadachi()}">
                    <input type="submit" class="btn btn-success" value="Сохранить">
            </form>
                <button type="button" class="btn btn-danger">Удалить</button>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <form action="add_zadachi">
                <input type="hidden" name="idUmkPredmetDocument" value="${TUmkPredmetDocument.getIdUmkPredmetDocument()}">
                <td  class="col-md-5">
                    <textarea class="form-control" name="RPDZadacha" rows="3"></textarea>
                </td>
                <td  class="col-md-1">
                    <input type="submit" class="btn btn-success" value="Сохранить">
                </td>
            </form>
        </tr>
    </tbody>
</table>