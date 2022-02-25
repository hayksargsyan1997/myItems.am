<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ավելացնել Հայտարարություն</title>

    <style>

        body {
            background: linear-gradient(to right, green 0%, darkgrey 50%, seashell 99%);
        }

        signup-form {
            font-family: "Roboto", sans-serif;
            width: 650px;
            margin: 30px auto;
            background: linear-gradient(to right, #ffffff 0%, #fafafa 50%, #ffffff 99%);
            border-radius: 10px;
        }

        form-header {
            background-color: #EFF0F1;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .form-header h1 {
            font-size: 30px;
            text-align: center;
            color: #666;
            padding: 20px 0;
            border-bottom: 1px solid #cccccc;
        }


        input[type=text], input[type=number], input[type=file],  select {
            width: 100%;
            padding: 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid antiquewhite;
            border-radius: 4px;
            box-sizing: border-box;


        }


        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;

        } </style>
</head>
<body>
<%List<Category> categoryList = (List<Category>) request.getAttribute("categories"); %>
<%User user =(User) session.getAttribute("user"); %>

<div style="  width: 800px;float: left  ">
    <div style="width: 50%;float: left">
        Add Ads:<br>
        <form action="/AdsServlet" method="post" enctype="multipart/form-data">
            <input type="text" name="title" placeholder="title"><br>
            <input type="number" name="price" placeholder="price">$<br>
            <select name="category_id">

                <%
                    for (Category category : categoryList) {%>
                <option value="<%=category.getId()%>"><%=category.getName()%>
                </option>
                <% }
                %>
            </select><br>
            picture: <input type="file" name="pic_url" placeholder="image"> <br>
            <select name="user_id">
                <option value="<%=user.getId()%>" <%=user.getName()%>></option>
            </select>



            <input type="submit" value="Register">
        </form>
    </div>
</div>
</body>
</html>
