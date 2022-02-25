<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ԻՄ ԷՋ</title>
</head>
<body>

<%User user = (User) request.getSession().getAttribute("user");%>


<h1>ԲԱՐԻ ԳԱԼՈՒՍՏ <%=user.getName() + " " + user.getSurname()%></h1>

<h2><a href="/adsMod">ԱՎԵԼԱՑՆԵԼ ՀԱՅՏԱՐԱՐՈՒԹՅՈՒՆ</a></h2>

<h2><a href="/myAdsMod">ԻՄ ՀԱՅՏԱՐԱՐՈՒԹՅՈՒՆՆԵՐԸ</a> </h2>

<h2><a href="/logout">ԴՈՒՐՍ ԳԱԼ</a> </h2>



</body>
</html>
