<%@ page import="java.sql.Connection, br.com.sce.conexao.Pool" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/menuVertical.css" media="all" rel="stylesheet" type="text/css" />   
    <script src="js/jquery-latest.min.js"></script>    
	<script type="text/javascript">
        $(document).ready(function(){
            $(".conteudoMenu").hide();
            $(".itemMenu").click(function(){
                $(".conteudoMenu").slideUp("slow");
                $(this).next(".conteudoMenu").slideDown("slow");
            });
        })
    </script>
</head>
<body style="background-color: silver; color: navy;">
	Usuário: ${usuario.usu_nome}
	<a href="<% 
	Pool pool = new Pool(); 
	Connection con = pool.getConnection();

	con.close();
	pool.liberarConexao(con); 


	%>">
	<a href='logoff.jsp'><img src="imagens/sair.png" /></a><br><br>
    <img src="imagens/sce.png" width="240" height="58" /><br><br>

<div id="main" class="clearfix">
    <aside>
        <nav>
            <ul id="menu">
                <li><a href="#" class="itemMenu">Inicio<img src="imagens/set.png" align="right"></a></li>
                <li>
                    <a href="#" class="itemMenu">Cliente<img src="imagens/set.png" align="right"></a>
                    
						<div class="conteudoMenu">
                       <a href="SceControle?cmd=viewCliente" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Cadastrar Cliente</a>
                       <a href="SceControle?cmd=consultarCliente" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Consultar Clientes</a>
                       </div>     
                </li>
				
				<li>
                    <a href="#" class="itemMenu">Cidade<img src="imagens/set.png" align="right"></a>
                    
						<div class="conteudoMenu">
                        <a href="SceControle?cmd=viewCidade" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Cadastrar Cidade</a>
                        <a href="SceControle?cmd=consultarCidade" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Consultar Cidades</a>  
						</div>
                    
                </li>
                          
            </ul>
        </nav>
  </aside>
    

</div>
</html>