package br.com.sce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.model.bean.Usuario;

public class UsuarioDAO implements InterfaceUsuarioDAO {

	
	private InterfacePool pool;
	

	public UsuarioDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	@Override
	public void atualizar(Usuario usuario) throws SQLException {
		// TODO Implementar atualizar
	}
	
	@Override
	public void excluir(Integer usu_codigo) throws SQLException {
		// TODO Implementar excluir
	}
	
	@Override
	public Usuario getUsuario(Integer usu_codigo) throws SQLException {
		
		Usuario usuario = null;
		Connection con = null;
		
		try{
			
			con = pool.getConnection();
			PreparedStatement ps;
			
			String sqlSelect = "SELECT * FROM usuario WHERE usu_codigo = ? ;";
			
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, usu_codigo);
			ResultSet rs = ps.executeQuery();
			
			List<Usuario> resultado = getListaUsuarios(rs);
			if(resultado.size() > 0)
				usuario = resultado.get(0);
			
			rs.close();
			ps.close();
			
		}finally{
			pool.liberarConexao(con);
		}
		return usuario;
	}

	@Override
	public Usuario getUsuario(String login) throws SQLException {
		
		Usuario usuario = null;
		Connection con = null;
		
		try{
			
			con = pool.getConnection();
			PreparedStatement ps;
			
			String sqlSelect = "SELECT * FROM usuario WHERE usu_login = ? ;";
			
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			
			List<Usuario> resultado = getListaUsuarios(rs);
			if(resultado.size() > 0)
				usuario = resultado.get(0);
			
			rs.close();
			ps.close();
			
		}finally{
			pool.liberarConexao(con);
		}
		return usuario;
		
		
	}
	
	@Override
	public List<Usuario> getUsuarios() throws SQLException {
		
		List<Usuario> resultado = null;
		Connection con = null;
		
		try {
			resultado = new ArrayList<Usuario>();
			con = pool.getConnection();
			PreparedStatement ps;
			
			String sqlSelect = "SELECT * FROM usuario;";
			

			ps = con.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();
			
			resultado = getListaUsuarios(rs);		
			
			rs.close();
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}
				
		return resultado;
	}

	private List<Usuario> getListaUsuarios(ResultSet rs)
			throws SQLException {
		
		List<Usuario> resultado = new ArrayList<Usuario>();
		
		while(rs.next())
		{
			Usuario usuario = new Usuario();
			
			usuario.setUsu_codigo(rs.getInt("usu_codigo"));
			usuario.setUsu_nome(rs.getString("usu_nome"));
			usuario.setUsu_login(rs.getString("usu_login"));
			usuario.setUsu_senha(rs.getString("usu_senha"));
			
			resultado.add(usuario);

		}
		
		return resultado;
		
	}

	@Override
	public void salvar(Usuario usuario) throws SQLException {
		// TODO Implementar salvar

	}

	
}
