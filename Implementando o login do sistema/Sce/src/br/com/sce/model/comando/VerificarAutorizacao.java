package br.com.sce.model.comando;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.bean.Acesso;
import br.com.sce.model.bean.Usuario;
import br.com.sce.model.dao.AcessoDAO;

public class VerificarAutorizacao implements InterfaceComando {

	private AcessoDAO acessoDAO;
	public VerificarAutorizacao(AcessoDAO acessoDAO) {
		super();
		this.acessoDAO = acessoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String cmd = request.getParameter("cmd");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario"); 
		if(usuario == null)
			return "SceControle?cmd=acessarUsuario";
		try {
			Map<String, Acesso> acessos = acessoDAO.getAcessosUsuario(usuario.getUsu_codigo());
			Acesso acesso = acessos.get(cmd); 
			
			if(acesso != null && acesso.getUsu_codigo() != usuario.getUsu_codigo())
			{
								
				request.setAttribute("titulo", "Acesso negado");
				request.setAttribute("mensagem", "Nome/Cód. da transação: "+acesso.getDescricao()+" / "+acesso.getComando());
				return "acesso_negado.jsp";
			}
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problemas com acesso ao banco de dados: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
