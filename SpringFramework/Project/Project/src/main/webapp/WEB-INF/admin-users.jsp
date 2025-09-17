<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin - Users</title>
</head>
<body>
<h2>User List</h2>

<a href="add-user">Add User</a><br/><br/>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Role</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>

<a href="admin/dashboard">Back</a>
</body>
</html>
