package br.com.sce.model.comando;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.bean.Usuario;
import br.com.sce.model.dao.InterfaceUsuarioDAO;

public class AcessarUsuario implements InterfaceComando {

	private InterfaceUsuarioDAO usuarioDAO;
	

	public AcessarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Usuario usuario = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		request.setAttribute("titulo", "Acesso ao Sistema de Controle Eletrônico");
		
		if(login == null)
			return "login_usuario.jsp";
		
		try {
			usuario = usuarioDAO.getUsuario(login);
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Problemas com a base de dados: "+e.getMessage());
			e.printStackTrace();
		}
		if(usuario == null || !usuario.getUsu_senha().equals(senha))
		{
			request.setAttribute("mensagem", "Login ou senha inválido: ");
			return "login_usuario.jsp";
		}
		
		request.getSession().setAttribute("usuario", usuario);
		return "SceControle?cmd=iniciarSce";
	}

}
