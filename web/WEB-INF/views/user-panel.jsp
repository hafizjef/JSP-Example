<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:User-Base title="Ward Management System">
    <div class="grid padding20">
        <div class="row cells3">
            <div class="cell colspan2">
                <div class="panel alert">
                    <div class="heading">
                        <span class="icon mif-ambulance" style="background-color: #75241f"></span>
                        <span class="title">Patient Info</span>
                    </div>
                    <div class="content padding20">
                        <table class="table striped hovered" id="users-table">
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
                    </div>
                </div>
            </div>
            <div class="cell">
                <div class="panel">
                    <div class="heading">
                        <span class="icon mif-organization"></span>
                        <span class="title">Hospital Info</span>
                    </div>
                    <div class="content padding20">
                        <p>Number of Patients: 2</p>
                        <p>Number of Doctors: 23</p>
                        <p>Wards Occupied: 23</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:User-Base>
