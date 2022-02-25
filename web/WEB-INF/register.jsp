<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>

        body {
            background: linear-gradient(to right, #78a7ba 0%, #385D6C 50%, #78a7ba 99%);
        }

        .signup-form {
            font-family: "Roboto", sans-serif;
            width: 650px;
            margin: 30px auto;
            background: linear-gradient(to right, #ffffff 0%, #fafafa 50%, #ffffff 99%);
            border-radius: 10px;
        }

        .form-header {
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


        input[type=text], input[type=date], input[type=email], input[type=password], select {
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
<div style="  width: 800px;text-align: center  ">
    <div style="width: 50%;text-align: center">
        ԳՐԱՆՑՈՒՄ։<br>
        <form class="signup-form" action="/register" method="post">
            <input type="text" name="name" placeholder="name"><br>
            <input type="text" name="surname" placeholder="surname"><br>
            <input type="email" name="email" placeholder="email"><br>
            <input type="password" name="password" placeholder="password"><br>
            <input type="submit" value="ԳՐԱՆՑՈՒՄ">
        </form>
    </div>
</div>
</body>
</html>
