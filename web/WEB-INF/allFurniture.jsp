<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ԿԱՀՈՒՅՔ</title>
</head>
<body>

<%
    List<Item> furniture = (List<Item>) request.getAttribute("allFurniture");
%>

<%for (Item furnitures : furniture) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/getImage?path=<%=furnitures.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=furnitures.getTitle()%></h3>
        <h3><%=furnitures.getPrice()%> $</h3>
    </div>
</div>
<%}%>

</body>
</html>
