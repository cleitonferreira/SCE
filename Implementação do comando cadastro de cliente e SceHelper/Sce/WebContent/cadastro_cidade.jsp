<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="js/validacao/jquery.js" type="text/javascript"></script>
<script language="JavaScript" src="js/validacao/jquery.validate.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Eletrônico</title>

		<style type="text/css">
            
            label { display: block; margin-top: 10px; }
            label.error { float: none; color: red; margin: 0 .5em 0 0; vertical-align: top; font-size: 10px }
            p { clear: both; }
            .submit { margin-top: 1em; }
            em { font-weight: bold; padding-right: 1em; vertical-align: top; }
        </style>


        <script type="text/javascript">
            $(document).ready( function() {
                $("#form_cidade").validate({
                    // Define as regras
                    rules:{
                        cid_nome:{

                            required: true
                        },
						 cid_uf:{
                            
                            required: true
                        }
                    },
                    // Define as mensagens de erro para cada regra
                    messages:{
                        cid_nome:{
                            required: "Digite o nome da cidade"
                        },
						cid_uf:{
                            required: "Selecione a uf cidade"
                        }
                    }
                });
            });
        </script>


</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<div align="center">
	<form id="form_cidade" action="SceControle" style="width:300px; border-width:thin; border-style:dashed; border-color:navy; color: #0080FF; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif"
	 onsubmit="return validacaoform(this);">
	<h3>${mensagem}</h3>
	<input type="hidden" name="cmd" value="cadastrarCidade"></input>
<table
		style="color: #004080; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif;"
		border="1" bordercolor="gray" cellpadding="5">
		<thead>
			<tr
				style="color: #004080; font-size: 12px; font-family: Tahoma, Verdana, Arial, Sans-Serif; font-weight: bold">
				<th>Atributo</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tr>
			<td>Cidade</td>
			<td><input name="cid_nome" id="nome" style="height: 20px" value="${cidade.cid_nome}" maxlength="30"></input></td>
		</tr>
		<tr>
			<td>Uf</td>
			<td><input id="uf" name="cid_uf" style="height: 20px" value="${cidade.cid_uf}" maxlength="2"></input></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Cadastrar" style="height: 23px"></input></td>
		</tr>		
	</table>
	<br>
	</form>
</div>
<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>