package br.com.sce.model.comando;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.bean.Cliente;
import br.com.sce.model.bean.Data;
import br.com.sce.model.dao.InterfaceCidadeDAO;
import br.com.sce.model.dao.InterfaceClienteDAO;

public class CadastrarCliente implements InterfaceComando {

	private InterfaceClienteDAO clienteDAO;
	private InterfaceCidadeDAO cidadeDAO;
	
	
	public CadastrarCliente(InterfaceClienteDAO clienteDAO, InterfaceCidadeDAO cidadeDAO) {
		super();
		this.clienteDAO = clienteDAO;
		this.cidadeDAO = cidadeDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
		Cliente cliente = new Cliente();
		
		
		
		cliente.setCidade(cidadeDAO.getCidade(Integer.valueOf(request.getParameter("cid_codigo"))));
		
		cliente.setCli_bairro(request.getParameter("cli_bairro"));
		cliente.setCli_cep(request.getParameter("cli_cep"));
		cliente.setCli_cnpj(request.getParameter("cli_cnpj"));
		cliente.setCli_complemento(request.getParameter("cli_complemento"));
		cliente.setCli_cpf(request.getParameter("cli_cpf"));
		
		try {
			cliente.setCli_datacad(new Data().formata(request.getParameter("cli_datacad")));
			cliente.setCli_datanasc(new Data().formata(request.getParameter("cli_datanasc")));
		} catch (Exception e) {
			request.setAttribute("mensagem", "Problemas com a gravação da Data: "+e.getMessage());
			e.printStackTrace();
		}
		
		cliente.setCli_email(request.getParameter("cli_email"));
		cliente.setCli_endereco(request.getParameter("cli_endereco"));
		cliente.setCli_estadocivil(request.getParameter("cli_estadocivil"));
		cliente.setCli_fonecel(request.getParameter("cli_fonecel"));
		cliente.setCli_foneres(request.getParameter("cli_foneres"));
		cliente.setCli_insest(request.getParameter("cli_insest"));
		cliente.setCli_nome(request.getParameter("cli_nome"));
		cliente.setCli_numero(request.getParameter("cli_numero"));
		cliente.setCli_obs(request.getParameter("cli_obs"));
		cliente.setCli_rg(request.getParameter("cli_rg"));
		cliente.setCli_sexo(request.getParameter("cli_sexo"));
		

		
		clienteDAO.salvar(cliente);
		request.setAttribute("mensagem", "Cliente ("+cliente.getCli_nome()+") gravado com sucesso!");
	} catch (SQLException e) {
		request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());			
		e.printStackTrace();
	}catch (NumberFormatException e) {
		request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		e.printStackTrace();
	}
	request.setAttribute("titulo", "Cadastro - Cliente");
	return "SceControle?cmd=viewCliente";
}

}
