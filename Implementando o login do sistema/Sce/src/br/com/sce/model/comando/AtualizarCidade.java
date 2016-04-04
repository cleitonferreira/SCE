package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.bean.Cidade;
import br.com.sce.model.dao.InterfaceCidadeDAO;

public class AtualizarCidade implements InterfaceComando {

	private InterfaceCidadeDAO cidadeDAO;
	

	public AtualizarCidade(InterfaceCidadeDAO cidadeDAO) {
		super();
		this.cidadeDAO = cidadeDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Cidade cidade = new Cidade();
		
		cidade.setCid_codigo(Integer.valueOf(request.getParameter("cid_codigo")));
		cidade.setCid_nome(request.getParameter("cid_nome"));
		cidade.setCid_uf(request.getParameter("cid_uf"));
		
		try {
			cidadeDAO.atualizar(cidade);
			request.setAttribute("mensagem", "Cidade ("+cidade.getCid_nome()+") atualizado com sucesso!");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problemas com a atualização: "+e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
		}
		
		request.setAttribute("titulo", "Atualização - Cidade");
		return "SceControle?cmd=consultarCidade";
	}

}
