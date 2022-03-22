<%-- 
    Document   : Login_Screen
    Created on : 21-Mar-2022, 9:34:20 am
    Author     : satvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form>
            <table width="100%">
                <tr>
                    <td colspan="2" style="text-align: center"><h1>Please Enter Your Details</h1></td>
                </tr>
                <tr>
                    <td style="text-align: center">Name:</td>
                    <td style="text-align: center"><input type="text" pattern="[a-zA-z ]+"></td>
                </tr>
                <tr>
                    <td style="text-align: center">Email-ID</td>
                    <td style="text-align: center"><input type="text" pattern="[a-zA-z1-9]+@gmail.com"></td>
                </tr>
                <tr>
                    <td style="text-align: center">Password</td>
                    <td style="text-align: center"><input type="password"></td>
                </tr>
                <tr>
                    <td style="text-align: center">ID-Type</td>
                            <td style="text-align: center"><select>
                                    <option>Aadhar</option>
                                    <option>Passport</option>
                        </select></td>
                </tr>
                <tr>
                    <td style="text-align: center">ID</td>
                    <td style="text-align: center"><input type="text"></td>
                </tr>
                <tr>
                    <td style="text-align: center">Contact no:</td>
                    <td style="text-align: center"><input type="text" pattern="\d{10}"></td>
                </tr>
                <tr>
                    <td style="text-align: left" colspan="2">Meeting Host Details:</td>
                </tr>
                <tr>
                    <td style="text-align: center">Name</td>
                    <td style="text-align: center"><input type="text" pattern="[a-zA-z ]+"></td>
                </tr>
                <tr>
                    <td style="text-align: center">Email-ID</td>
                    <td style="text-align: center"><input type="text" pattern="[a-zA-z1-9]+@gmail.com"></td>
                </tr>
                <tr>
                    <td style="text-align: left" colspan="2">Venue Details:</td>
                </tr>
                <tr>
                    <td style="text-align: center">ID-Type</td>
                            <td style="text-align: center"><select>
                                    <option>Building A</option>
                                    <option>Buildiing B</option>
                        </select></td>
                </tr>
                <tr>
                    <td style="text-align: center">Days</td>
                    <td style="text-align: center"><input type="text" pattern="\d\d?\d?"></td>
                </tr>
                <tr>
                    <td style="text-align: center">Photograph</td>
                    <td style="text-align: center"><input type="file" accept="image/*" capture ="camera"></td>
                </tr>
                <tr>
                    <td style="text-align: center" colspan="2"><input type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>