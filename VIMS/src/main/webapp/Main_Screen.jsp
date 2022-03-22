<%-- 
    Document   : Main_Screen
    Created on : 21-Mar-2022, 9:11:48 am
    Author     : satvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VIMS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        
        <style type="text/css">
            .button {
                /*background-color: #4CAF50;*/
                border: 2px;
                border-color: black;
                border-style: solid;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
              }
        </style>
    </head>
    <body>
        <table width="100%">
            <tr>
                <td style="text-align: center" colspan="2">Welcome To VIMS</td>
            </tr>
            <tr>
                <td style="text-align: center"><a class="button" href="Login_Screen.jsp">Login</a></td>
                <td style="text-align: center"><a class="button" href="Sign_up_Screen.jsp">Sign Up</a></td>
            </tr>
        </table>
    </body>
</html>

