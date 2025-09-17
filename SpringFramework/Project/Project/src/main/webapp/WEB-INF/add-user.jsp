<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add User</title>
</head>
<body>
<h2>Add User</h2>

<form action="admin/add-user" method="post">
    Username: <input type="text" name="username" required /><br/>
    Password: <input type="password" name="password" required /><br/>
    Role: 
    <select name="role">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
    </select><br/>
    <button type="submit">Add</button>
</form>

<a href="admin/users">Back</a>
</body>
</html>
