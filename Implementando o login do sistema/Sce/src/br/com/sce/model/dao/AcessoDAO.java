package br.com.sce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.model.bean.Acesso;

public class AcessoDAO {

	private InterfacePool pool;

	public AcessoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	
	public Map<String, Acesso> getAcessosUsuario(Integer codigoUsuario) throws SQLException
	{
		Map<String, Acesso> resultado = new HashMap<String, Acesso>();
		String sqlSelect = "SELECT * FROM acesso AS a LEFT JOIN acesso_usuario AS af " +
				" ON a.codigo = af.codigo AND af.usu_codigo = ? ORDER BY a.codigo;";
		Connection con = pool.getConnection();
		PreparedStatement ps;
		try{
			
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigoUsuario);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Acesso acesso = new Acesso();

				acesso.setCodigo(rs.getInt("codigo"));
				acesso.setComando(rs.getString("comando"));
				acesso.setDescricao(rs.getString("descricao"));
				acesso.setUsu_codigo(rs.getInt("usu_codigo"));
				resultado.put(acesso.getComando(), acesso);
			}
			rs.close();
			ps.close();
			return resultado;
		}
		finally
		{
			pool.liberarConexao(con);	
		}
		
	}
}


