package br.com.sce.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.sce.model.bean.Usuario;

public interface InterfaceUsuarioDAO {
	
	Usuario getUsuario(Integer usu_codigo) throws SQLException;
	Usuario getUsuario(String login) throws SQLException;
	void excluir(Integer usu_codigo) throws SQLException;
	void atualizar(Usuario usuario) throws SQLException;
	void salvar (Usuario usuario) throws SQLException;
	List<Usuario> getUsuarios() throws SQLException;
	

}
