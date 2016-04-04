<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.sce.model.bean.Cidade" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Eletrônico</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<div align="center">
	<h3>${mensagem}</h3>
<table
		style="color: #004080; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif;;"
		border="1" bordercolor="gray" cellpadding="5">
		<thead>
			<tr
				style="color: #004080; font-size: 12px; font-family: Tahoma, Verdana, Arial, Sans-Serif; font-weight: bold">
				<th>Cód.</th>
				<th>Cidade</th>
				<th>Uf</th>
				<th colspan="2">Editar</th>
			</tr>
		</thead>
		<%
		String style = "'color: navy; text-align: center; font-size:small;'";
		List<Cidade> cidades = (List<Cidade>)request.getAttribute("cidades");
		for(Cidade cidade: cidades){
		%>
		<tr style=<%=style %>>
			<td><%=cidade.getCid_codigo()%></td>
			<td><%=cidade.getCid_nome()%></td>
			<td><%=cidade.getCid_uf()%></td>
			<td><a href='SceControle?cmd=view_AtualizaCidade&cid_codigo=<%=cidade.getCid_codigo()%>'><img src="imagens/180213182746_32.png" width="26" height="26" /></a></td>
			<td><a href='SceControle?cmd=excluirCidade&cid_codigo=<%=cidade.getCid_codigo()%>'><img src="imagens/180213182916_32.png" width="26" height="26" /></a></td>
		</tr>
		<%
			style = style.equals("'color: navy; text-align: center; font-size:small;'") ?
					"'background-color: #66C; color: white; text-align: center; font-size:small;'" : 
					"'color: navy; text-align: center; font-size:small;'";
		} %>
	</table>
</div>
<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>