package br.com.sce.model.helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.conexao.Pool;
import br.com.sce.model.comando.CadastrarCidade;
import br.com.sce.model.comando.CadastrarCliente;
import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.dao.CidadeDAO;
import br.com.sce.model.dao.ClienteDAO;
import br.com.sce.model.link.ViewCidade;
import br.com.sce.model.link.ViewCliente;

public class SceHelper 
{
	//Esta classe vai fazer o controle das regras de negócio
	//Vai também controlar o destino das requisições Http
	
	private HashMap<String, InterfaceComando> mapaComandos;
	private HttpServletRequest request;

	private InterfacePool pool;
	
	public SceHelper()
	{
		this.pool = new Pool();
		
		this.request = request;
		mapaComandos = new HashMap<String, InterfaceComando>();
		
		// ############################################
		//Comandos para chamar as Views
		mapaComandos.put("viewCliente", new ViewCliente(new ClienteDAO(pool), new CidadeDAO(pool)));
		mapaComandos.put("viewCidade", new ViewCidade(new CidadeDAO(pool)));
		
		
		// ############################################
		
		//Comandos para o Cliente
		mapaComandos.put("cadastrarCliente", new CadastrarCliente(new ClienteDAO(pool), new CidadeDAO(pool)));
		mapaComandos.put("cadastrarCidade", new CadastrarCidade(new CidadeDAO(pool)));
		
	}

	public InterfaceComando getComando()
	{
		return mapaComandos.get(request.getParameter("cmd"));	
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
