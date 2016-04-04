package br.com.sce.model.link;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.dao.CidadeDAO;
import br.com.sce.model.dao.InterfaceClienteDAO;

public class View_AtualizaCliente implements InterfaceComando {

	private InterfaceClienteDAO clienteDAO;
	private CidadeDAO cidadeDAO;
	

	public View_AtualizaCliente(InterfaceClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
		super();
		this.clienteDAO = clienteDAO;
		this.cidadeDAO = cidadeDAO;
	}



	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			
			request.setAttribute("cidades", cidadeDAO.getCidades());
		
			request.setAttribute("cliente", clienteDAO.getCliente(Integer.valueOf(request.getParameter("cli_codigo"))));
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor do código inválido: "+request.getParameter("cli_codigo"));
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problema com o acesso a base de dados: "+e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("titulo", "Atualização - Cliente");
		
		return "atualiza_cliente.jsp";
	}

}
