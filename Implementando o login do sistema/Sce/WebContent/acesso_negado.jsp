<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acesso não autorizado</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<div align="center" style="color: #004080; font-size: 14px; font-family: Tahoma, Verdana, Arial, Sans-Serif;">
	Atenção, você não possui autorização para esta transação. Solicite ao seu gerente responsável. 
	<h3>${mensagem}</h3>	
    <center><img src="imagens/CSTADS.png"></center>
</div>
<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>