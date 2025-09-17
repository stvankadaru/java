<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Assign Task</title>
</head>
<body>
<h2>Assign Task</h2>

<form action="admin/assign-task" method="post">
    Title: <input type="text" name="title" required /><br/>
    Description: <textarea name="description"></textarea><br/>
    Assign to:
    <select name="userId">
        <c:forEach var="user" items="${users}">
            <option value="${user.id}">${user.username}</option>
        </c:forEach>
    </select><br/>
    <button type="submit">Assign</button>
</form>

<a href="admin/tasks">Back</a>
</body>
</html>
