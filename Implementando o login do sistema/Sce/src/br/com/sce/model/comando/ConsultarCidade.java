package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.dao.InterfaceCidadeDAO;

public class ConsultarCidade implements InterfaceComando {

	private InterfaceCidadeDAO cidadeDAO;
	

	public ConsultarCidade(InterfaceCidadeDAO cidadeDAO) {
		super();
		this.cidadeDAO = cidadeDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("titulo", "Consulta - Cidade");
		
		try {
			request.setAttribute("cidades", cidadeDAO.getCidades());
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problemas com o acesso a base de dados!");
			
			e.printStackTrace();
		}
		
		return "consulta_cidade.jsp";
	}

}
