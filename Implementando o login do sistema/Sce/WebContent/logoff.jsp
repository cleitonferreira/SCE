<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Sistema de Controle Eletrônico </title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
body, td, a:link, a:visited {
font-family: Verdana;
font-size: 10px;
color: #000000;
text-decoration: none;
}
a:hover{
color: #FF0000;
}
input {
font-family: Verdana, Arial, Helvetica, sans-serif;
font-size: 10px;
background-color: #FFFFFF;
border: 1px solid #000000;
}
</style>
</head>
<body>
<%
//Destroi as sessions
session.invalidate();

    response.sendRedirect("login_usuario.jsp");
%>

</body>
</html>