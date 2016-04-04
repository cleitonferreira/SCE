<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Eletrônico</title>
<script type="text/javascript">
	if(top.location != self.location)
	{
		top.location = self.location;
		
	}
</script>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<div align="center">
	<form action="SceControle" style="width:300px; border-width:thin; border-style:dashed; border-color:navy; color: #0080FF; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif"
	 name="form1" method="post">
	<h3>${mensagem}</h3>
	<input type="hidden" name="cmd" value="acessarUsuario"></input>	
<table
		style="color: #004080; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif;;"
		border="1" bordercolor="gray" cellpadding="5">
		
		<tr>
			<td>Login:</td>
			<td><input type="text" id="login" name="login" style="height: 20px" value="${usuario.usu_login}"></input></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password"  id="senha" name="senha" style="height: 20px" value="${usuario.usu_senha}"></input></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Entrar" style="height: 23px"></input></td>
		</tr>		
	</table>
	<br>
	</form>
	<script language='JavaScript' type='text/javascript'>
  		document.form1.login.focus()
	</script>
</div>
<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>