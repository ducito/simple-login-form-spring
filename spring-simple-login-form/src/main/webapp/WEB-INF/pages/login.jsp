<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container col-md-12">
    <div class="content">
        <h2>Login</h2>
        <h4 style="color: red">${message}</h4>

        <form action="login" method="post" name="user">
            <label for="username">Username:</label>
            <input type="text" class="form-control" name="username" id="username"required="required"/>
            <br/>
            <label for="password">Password:</label>
            <input type="password" class="form-control" name="password" id="password" required="required"/>
            <br/>
            <input type="submit" class="btn btn-primary" value="Login"/>
        </form>
    </div>

</div>

</body>
</html>
