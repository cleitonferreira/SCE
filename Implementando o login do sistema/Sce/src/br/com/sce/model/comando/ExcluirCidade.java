package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.dao.InterfaceCidadeDAO;

public class ExcluirCidade implements InterfaceComando {

	private InterfaceCidadeDAO cidadeDAO;
	

	public ExcluirCidade(InterfaceCidadeDAO cidadeDAO) {
		super();
		this.cidadeDAO = cidadeDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			cidadeDAO.excluir(Integer.valueOf(request.getParameter("cid_codigo")));
			request.setAttribute("mensagem", "Cidade excluída com sucesso!");
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Código inválido: "+request.getParameter("cid_codigo"));
			e.printStackTrace();
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problemas com a base de dados: "+e.getMessage());
			e.printStackTrace();
		}
		
		request.setAttribute("titulo", "Consulta - Cidade");
		return "SceControle?cmd=consultarCidade";
	}

}
