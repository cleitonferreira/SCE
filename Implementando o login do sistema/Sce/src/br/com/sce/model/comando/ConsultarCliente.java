package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.dao.InterfaceClienteDAO;

public class ConsultarCliente implements InterfaceComando {

	private InterfaceClienteDAO clienteDAO;
	
	
	public ConsultarCliente(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	request.setAttribute("titulo", "Consulta - Cliente");
	
	try {
		request.setAttribute("clientes", clienteDAO.getClientes());
	} catch (SQLException e) {
		
		request.setAttribute("mensagem", "Problemas com o acesso a base de dados!");
		e.printStackTrace();
	}
	
		return "consulta_cliente.jsp";
	}

}
