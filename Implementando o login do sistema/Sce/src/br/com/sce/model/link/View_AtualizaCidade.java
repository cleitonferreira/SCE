package br.com.sce.model.link;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.dao.InterfaceCidadeDAO;

public class View_AtualizaCidade implements InterfaceComando {

	private InterfaceCidadeDAO cidadeDAO;
	

	public View_AtualizaCidade(InterfaceCidadeDAO cidadeDAO) {
		super();
		this.cidadeDAO = cidadeDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			request.setAttribute("cidade", cidadeDAO.getCidade(Integer.valueOf(request.getParameter("cid_codigo"))));
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor do código inválido: "+request.getParameter("cid_codigo"));
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problema com o acesso a base de dados: "+e.getMessage());
			e.printStackTrace();
		}
		
		request.setAttribute("titulo", "Atualização - Cidade");
		
		return "atualiza_cidade.jsp";
	}

}
