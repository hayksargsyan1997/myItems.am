<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Գլխավոր էջ</title>


</head>
<body>
<h1>ԲԱՐԻ ԳԱԼՈՒՍՏ</h1>
<header style="text-align: right">
    <nav style="vertical-align: baseline">
        <h2><a href= "/RegisterMedServlet">ԳՐԱՆՑՈՒՄ</a></h2>
        <h2><a href="/LogMedServlet">ՄՈՒՏՔ</a></h2>
    </nav>
</header>
<%List<Category> categoryList = (List<Category>) request.getAttribute("categories"); %>
<div >
 <h2> <header style="text-align: center">
<nav style="vertical-align: baseline">
    <a href="/?Գլխավոր=<%="Գլխավոր"%>">Գլխավոր</a>|
    <a href="/itemDetail?Ավտոմեքենաներ=<%="Ավտոմեքենաներ"%>">Ավտոմեքենաներ</a>|
    <a href="/itemDetail?Տներ=<%="Տներ"%>">Տներ</a>|
    <a href="/itemDetail?Կոմերցիոն=<%="Կոմերցիոն"%>">Կոմերցիոն</a>|
    <a href="/itemDetail?Կոմերցիոն=<%="Կոմերցիոն"%>">Կահույք</a>|
</nav>



  </header>
 </h2>

</div>

<%
    List<Item> allItems = (List<Item>) request.getAttribute("items");
%>

<%for (Item item : allItems) {%>
<div style="padding-left: 40px">
    <div style="width: 250px; height: 350px;float: left;padding-right: 20px">
        <img src="/getImage?path=<%=item.getPicUrl()%>" width="200px" height="300px"><br>
        <h3><%=item.getTitle()%></h3>
        <h3><%=item.getPrice()%> $</h3>
    </div>
</div>
<%}%>

</body>
</html>
