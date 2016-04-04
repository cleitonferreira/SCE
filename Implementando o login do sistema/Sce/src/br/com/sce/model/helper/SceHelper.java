package br.com.sce.model.helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.model.comando.AcessarUsuario;
import br.com.sce.model.comando.AtualizarCidade;
import br.com.sce.model.comando.AtualizarCliente;
import br.com.sce.model.comando.CadastrarCidade;
import br.com.sce.model.comando.CadastrarCliente;
import br.com.sce.model.comando.ConsultarCidade;
import br.com.sce.model.comando.ConsultarCliente;
import br.com.sce.model.comando.ExcluirCidade;
import br.com.sce.model.comando.ExcluirCliente;
import br.com.sce.model.comando.IniciarSce;
import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.dao.CidadeDAO;
import br.com.sce.model.dao.ClienteDAO;
import br.com.sce.model.dao.UsuarioDAO;
import br.com.sce.model.link.ViewCidade;
import br.com.sce.model.link.ViewCliente;
import br.com.sce.model.link.View_AtualizaCidade;
import br.com.sce.model.link.View_AtualizaCliente;

public class SceHelper 
{
	//Esta classe vai fazer o controle das regras de negócio
	//Vai também controlar o destino das requisições Http
	
	private HashMap<String, InterfaceComando> mapaComandos;
	private HttpServletRequest request;
	private InterfacePool pool;
	
	public SceHelper(InterfacePool pool)
	{
		this.pool = pool;
		
		
		mapaComandos = new HashMap<String, InterfaceComando>();
		
		
		// ############################################
		//Comandos para chamar as Views
		
		mapaComandos.put("viewCidade", new ViewCidade(new CidadeDAO(pool)));
		mapaComandos.put("viewCliente", new ViewCliente(new ClienteDAO(pool), new CidadeDAO(pool)));

		
		mapaComandos.put("view_AtualizaCidade", new View_AtualizaCidade(new CidadeDAO(pool)));
		mapaComandos.put("view_AtualizaCliente", new View_AtualizaCliente(new ClienteDAO(pool), new CidadeDAO(pool)));
		
		
		// ############################################
		
		
		//Comandos para a Cidade
		mapaComandos.put("cadastrarCidade", new CadastrarCidade(new CidadeDAO(pool)));
		mapaComandos.put("consultarCidade", new ConsultarCidade(new CidadeDAO(pool)));
		mapaComandos.put("atualizarCidade", new AtualizarCidade(new CidadeDAO(pool)));
		mapaComandos.put("excluirCidade", new ExcluirCidade(new CidadeDAO(pool)));
		
		
		//Comandos para o Cliente
		mapaComandos.put("cadastrarCliente", new CadastrarCliente(new ClienteDAO(pool), new CidadeDAO(pool)));
		mapaComandos.put("consultarCliente", new ConsultarCliente(new ClienteDAO(pool)));
		mapaComandos.put("atualizarCliente", new AtualizarCliente(new ClienteDAO(pool), new CidadeDAO(pool)));
		mapaComandos.put("excluirCliente", new ExcluirCliente(new ClienteDAO(pool)));
		
		
		//Comando para Inciar a pagina principal
		mapaComandos.put("iniciarSce", new IniciarSce());
		
		mapaComandos.put("acessarUsuario", new AcessarUsuario(new UsuarioDAO(pool)));
		
		
	}

	public InterfaceComando getComando()
	{
		String cmd = request.getParameter("cmd");
		if(cmd == null || request.getSession().getAttribute("usuario") == null)
			return mapaComandos.get("acessarUsuario");/*acessarUsuario*/
		
		return mapaComandos.get(cmd);
		
		
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
