<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Admin - Tasks</title>
</head>
<body>
<h2>Task List</h2>

<a href="assign-task">Assign Task</a><br/><br/>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Assigned To</th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${task.description}</td>
            <td>${task.assignedUser.username}</td>
        </tr>
    </c:forEach>
</table>

<a href="admin/dashboard">Back</a>
</body>
</html>
