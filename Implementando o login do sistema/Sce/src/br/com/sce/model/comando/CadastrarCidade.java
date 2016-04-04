package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.bean.Cidade;
import br.com.sce.model.dao.InterfaceCidadeDAO;

public class CadastrarCidade implements InterfaceComando {

	private InterfaceCidadeDAO cidadeDAO;
	
	
	public CadastrarCidade(InterfaceCidadeDAO cidadeDAO) {
		super();
		this.cidadeDAO = cidadeDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Cidade cidade = new Cidade();
		
		cidade.setCid_nome(request.getParameter("cid_nome"));
		cidade.setCid_uf(request.getParameter("cid_uf"));
		
		try {
			cidadeDAO.salvar(cidade);
			request.setAttribute("mensagem", "Cidade ("+cidade.getCid_nome()+") gravado com sucesso!");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());
			e.printStackTrace();
		}
		
		request.setAttribute("titulo", "Cadastro - Cidade");
		return "SceControle?cmd=viewCidade";
	}

}
