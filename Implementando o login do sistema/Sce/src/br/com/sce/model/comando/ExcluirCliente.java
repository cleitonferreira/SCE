package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.dao.InterfaceClienteDAO;

public class ExcluirCliente implements InterfaceComando {

	private InterfaceClienteDAO clienteDAO;
	
	
	public ExcluirCliente(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}

	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			clienteDAO.excluir(Integer.valueOf(request.getParameter("cli_codigo")));
			request.setAttribute("mensagem", "Cliente excluído com sucesso!");
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Código inválido: "+request.getParameter("cli_codigo"));
			e.printStackTrace();
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problemas com a base de dados: "+e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("titulo", "Consulta - Cliente");
		return "SceControle?cmd=consultarCliente";
	}

}
