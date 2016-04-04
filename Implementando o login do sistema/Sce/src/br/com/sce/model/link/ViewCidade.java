package br.com.sce.model.link;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.dao.InterfaceCidadeDAO;

public class ViewCidade implements InterfaceComando {

	private InterfaceCidadeDAO cidadeDAO;
	

	public ViewCidade(InterfaceCidadeDAO cidadeDAO) {
		super();
		this.cidadeDAO = cidadeDAO;
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("titulo", "Cadastro - Cidade");
		return "cadastro_cidade.jsp";
	}
	
	
}
