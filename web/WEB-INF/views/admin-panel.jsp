<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="userBean" class="wis.datastore.userBean" scope="request">
    <jsp:setProperty name="userBean" property="name" value="John"/>
</jsp:useBean>

<t:Base-Panel title="Admin Panel">
    <table class="table striped border bordered hovered" id="users-table">
        <thead>
            <th style="text-align: center; max-width: 1px">User ID</th>
            <th style="text-align: center">Username</th>
            <th>User is Admin</th>
            <th>Action</th>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td style="max-width: 1px; text-align: center">${user.id}</td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.isAdmin}"/></td>
                    <td><button class="button small-button danger"><span class="icon mif-bin"></span></button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    
    <p>Name : <jsp:getProperty name="userBean" property="name"/></p>
</t:Base-Panel>