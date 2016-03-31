package br.com.sce.model.helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import br.com.sce.model.comando.InterfaceComando;

public class SceHelper 
{
	//Esta classe vai fazer o controle das regras de negócio
	//Vai também controlar o destino das requisições Http
	
	private HashMap<String, InterfaceComando> mapaComandos;
	private HttpServletRequest request;
	
	public SceHelper(HttpServletRequest request)
	{
		this.request = request;
		
	}

	public InterfaceComando getComando()
	{
		return mapaComandos.get(request.getParameter("cmd"));	
	}
	
}
