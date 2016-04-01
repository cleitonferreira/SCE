<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, br.com.sce.model.bean.Cidade" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="JavaScript" src="js/validacao/jquery.js" type="text/javascript"></script>
<script language="JavaScript" src="js/validacao/jquery.validate.js" type="text/javascript"></script>
<script language="javascript" src="js/funcoes.js"></script>
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
                $("#form_cliente").validate({
                    // Define as regras
                    rules:{
                        cli_nome:{
                            // campoNome será obrigatorio (required) e terá tamanho minimo (minLength)
                            required: true, minlength: 5
                        },
						 cli_endereco:{
                            
                            required: true
                        },
						cli_bairro:{
                       
                            required: true
                        },
						cid_codigo:{
                       
                            required: true
                        },
						cli_numero:{
                       
                            required: true
                        },
						cli_complemento:{
                       
                            required: true
                        },
						cli_cep:{
                       
                            required: true
                        },
						cli_cpf:{
                       
                            required: true
                        }, 
						cli_rg:{
                       
                            required: true
                        },
						/* cli_cnpj:{
                       
                            required: true
                        }, */
						cli_insest:{
                       
                            required: true
                        },
						cli_foneres:{
                       
                            required: true
                        },
						cli_fonecel:{
                       
                            required: true
                        },
						cli_datanasc:{
                       
                            required: true
                        },
						cli_datacad:{
                       
                            required: true
                        },
						cli_email:{
							
                            required: true, email: true
                        },
						cli_sexo:{
                       
                            required: true
                        },
						cli_estadocivil:{
                       
                            required: true
                        },

                        cli_obs:{
                            // campoMensagem será obrigatorio (required) e terá tamanho máximo (maxlength)
                            required: true, maxlength: 100
                        }
                    },
                    // Define as mensagens de erro para cada regra
                    messages:{
                        cli_nome:{
                            required: "Digite o seu nome",
                            minlength: "Por Favor, digite seu nome completo"
                        },
						cli_endereco:{
                            required: "Digite o seu endereço"
                        },
						cli_bairro:{
                            required: "Digite o seu bairro"
                        },
						cid_codigo:{
                            required: "Selecione a sua cidade"
                        },
						cli_numero:{
                            required: "Digite o seu número"
                        },
						cli_complemento:{
                            required: "Digite o seu complemento"
                        },
						cli_cep:{
                            required: "Digite o seu cep"
                        },
						 cli_cpf:{
                            required: "Digite o seu cpf"
                        }, 
						cli_rg:{
                            required: "Digite o seu rg"
                        },
						/* cli_cnpj:{
                            required: "Digite o seu CNPJ"
                        }, */
						cli_insest:{
                            required: "Digite a sua inscrição estadual"
                        },
						cli_foneres:{
                            required: "Digite o seu telefone"
                        },
						cli_fonecel:{
                            required: "Digite o seu celular"
                        },
						cli_datanasc:{
                            required: "Digite sua data de nascimento"
                        },
						cli_datacad:{
                            required: "Digite a sua data de cadastro"
                        },
						cli_email:{
                            required: "Digite o seu e-mail para contato",
                            email: "Digite um e-mail válido"
                        },
						cli_sexo:{
                            required: "Selecione seu sexo"
                        },
						cli_estadocivil:{
                            required: "Selecione o seu estado civil"
                        },
                        cli_obs:{
                            required: "Digite a sua mensagem",
                            maxlength: "A sua mensagem deve conter, no máximo, 100 caracteres"
                        }
                    }
                });
            });
        </script>

</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<div align="center">
	<form id="form_cliente" action="SceControle" style="width:300px; border-width:thin; border-style:dashed; border-color:navy; color: #0080FF; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif"
	 onsubmit="return validacaoform(this);">
	<h3>${mensagem}</h3>
	<input type="hidden" name="cmd" value="cadastrarCliente"></input>
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
			<td>Nome</td>
			<td><input name="cli_nome" id="nome" style="height: 20px" value="${cliente.cli_nome}" maxlength="40"></input></td>
		</tr>
		<tr>
			<td>Endereço</td>
			<td><input name="cli_endereco" id="endereco" style="height: 20px" value="${cliente.cli_endereco}" maxlength="40"></input></td>
		</tr>
		<tr>
			<td>Bairro</td>
			<td><input name="cli_bairro" id="bairro" style="height: 20px" value="${cliente.cli_bairro}" maxlength="40"></input></td>
		</tr>
		<tr>
			<td>Cidade:</td>
			<td>
			<select id="cid_codigo" name="cid_codigo">
			<%
				List<Cidade> cidades = (List<Cidade>)request.getAttribute("cidades");
				for(Cidade cidade: cidades){
					out.println("<option value='"+cidade.getCid_codigo()+"'>"+cidade.getCid_nome());	
				}
			%>
			</select>
			</td>
		</tr>
		<tr>
		<tr>
			<td>Numero</td>
			<td><input name="cli_numero" id="numero" style="height: 20px" value="${cliente.cli_numero}" maxlength="10"></input></td>
		</tr>
		<tr>
			<td>Complemento</td>
			<td><input name="cli_complemento" id="complemento" style="height: 20px" value="${cliente.cli_complemento}" maxlength="10"></input></td>
		</tr>
		<tr>
			<td>Cep</td>
			<td><input id="cep" name="cli_cep" style="height: 20px" value="${cliente.cli_cep}" maxlength="9" onkeydown="Mascara(this,Cep);" onkeypress="Mascara(this,Cep);" onkeyup="Mascara(this,Cep);" ></input></td>
		</tr>
		<tr>
			<td>Cpf</td>
			<td><input id="cpf" name="cli_cpf" style="height: 20px" value="${cliente.cli_cpf}" maxlength="14" onkeydown="Mascara(this,Cpf);" onkeypress="Mascara(this,Cpf);" onkeyup="Mascara(this,Cpf);" ></input></td>
		</tr>
		<tr>
			<td>Rg</td>
			<td><input name="cli_rg" id="rg" style="height: 20px" value="${cliente.cli_rg}" maxlength="12"></input></td>
		</tr>
		<tr>
			<td>Cnpj</td>
			<td><input id="cnpj" name="cli_cnpj" style="height: 20px" value="${cliente.cli_cnpj}" maxlength="18" onkeydown="Mascara(this,Cnpj);" onkeypress="Mascara(this,Cnpj);" onkeyup="Mascara(this,Cnpj);" ></input></td>
		</tr>
		<tr>
			<td>Inscrição Estadual</td>
			<td><input name="cli_insest" id="insest" style="height: 20px" value="${cliente.cli_insest}" maxlength="20"></input></td>
		</tr>
		<tr>
			<td>Telefone</td>
			<td><input id="foneres" name="cli_foneres" style="height: 20px" value="${cliente.cli_foneres}" maxlength="14" onkeydown="Mascara(this,Telefone);" onkeypress="Mascara(this,Telefone);" onkeyup="Mascara(this,Telefone);" ></input></td>
		</tr>
		<tr>
			<td>Celular</td>
			<td><input id="fonecel" name="cli_fonecel" style="height: 20px" value="${cliente.cli_fonecel}" maxlength="14" onkeydown="Mascara(this,Telefone);" onkeypress="Mascara(this,Telefone);" onkeyup="Mascara(this,Telefone);" ></input></td>
		</tr>
		<tr>
			<td>Data de Nascimento</td>
			<td><input id="datanasc" name="cli_datanasc" style="height: 20px" value="${cliente.cli_datanasc}" maxlength="10" onkeydown="Mascara(this,Data);" onkeypress="Mascara(this,Data);" onkeyup="Mascara(this,Data);" ></input></td>
		</tr>
		<tr>
			<td>Data de Cadastro</td>
			<td><input id="datacad" name="cli_datacad" style="height: 20px" value="${cliente.cli_datacad}" maxlength="10" onkeydown="Mascara(this,Data);" onkeypress="Mascara(this,Data);" onkeyup="Mascara(this,Data);" ></input></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input name="cli_email" id="email" style="height: 20px" value="${cliente.cli_email}" maxlength="50"></input></td>
		</tr>
		<tr>
			<td>Sexo</td>
			<!-- <td><input id="sexo" name="cli_sexo" style="height: 20px" value="${cliente.cli_sexo}"></input></td> -->
			<td><input type="radio" name="cli_sexo" VALUE="M" CHECKED> Masculino</input><br>
			<input type="radio" name="cli_sexo" VALUE="F"> Feminino</input></td>
		</tr>
		<tr>
			<td>Estado Civil</td>
			<!-- <td><input id="estadocivil" name="cli_estadocivil" style="height: 20px" value="${cliente.cli_estadocivil}"></input></td>  -->
			<td><input type="radio" name="cli_estadocivil" VALUE="S" CHECKED> Solteiro</input><br>
			<input type="radio" name="cli_estadocivil" VALUE="C"> Casado</input></td>
		</tr>
		<tr>
			<td>Observação:</td>
			<td><input name="cli_obs" id="obs" style="height: 20px" value="${cliente.cli_obs}" maxlength="100"></input></td>
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