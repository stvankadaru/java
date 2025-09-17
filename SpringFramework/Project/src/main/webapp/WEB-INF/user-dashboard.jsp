<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
<h2>Welcome, ${sessionScope.currentUser.username}</h2>

<ul>
    <li><a href="user/tasks">My Tasks</a></li>
    <li><a href="logout">Logout</a></li>
</ul>
</body>
</html>
 