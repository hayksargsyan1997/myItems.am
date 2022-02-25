<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ՄՈՒՏՔ</title>
    <style>
        Body {
            font-family: Calibri, Helvetica, sans-serif;
        }
        button {
            background-color: antiquewhite;
            width: 100%;
            color: orange;
            padding: 15px;
            margin: 50px 50px;
            border: none;
            cursor: pointer;
        }
        form {
            padding-left: 30%;
            padding-right: 30%;
        }
        input[type=text], input[type=password] {
            width: 100%;
            margin: 8px 0;
            padding: 12px 20px;
            display: inline-block;
            border: 2px turquoise;
            box-sizing: border-box;
        }
        button:hover {
            opacity: 0.7;
        }
        cancelbtn {
            width: auto;
            padding: 10px 18px;
            margin: 10px 5px;
        }
        container {
            padding: 25px;
            background-color: darkturquoise;
        }
    </style>
</head>
<body>

<div style="text-align: center;"> <h1> ՄՈՒՏՔ</h1> </div>
<form action="/login" method="post">
    <div class="container">
        <h2>WELCOME BACK</h2>
        <label>
            <span>Email</span>
            <input type="text" placeholder="Email" name="email" required>
        </label>
        <label>
            <span>Password</span>
            <input type="password" placeholder="Password" name="password" required>
        </label>
        <button type="submit" >Login</button>
    </div>
</form>
</body>
</html>
