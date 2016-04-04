package br.com.sce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.model.bean.Cidade;

public class CidadeDAO implements InterfaceCidadeDAO {

	private InterfacePool pool;
	
	public CidadeDAO(InterfacePool pool)
	{
		super();
		this.pool = pool;
	}
	
	@Override
	public void atualizar(Cidade cidade) throws SQLException {
		
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		
		String sqlAtualizar = " UPDATE cidade SET cid_nome = ?, cid_uf = ? WHERE cid_codigo = ? ;";
		
		try {
			ps = con.prepareStatement(sqlAtualizar);
			
			setPreparedStatement(cidade, ps);
			
			ps.executeUpdate();
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}

	}
	
	
	@Override
	public void excluir(Integer cid_codigo) throws SQLException {
		
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		
		String sqlExcluir = "DELETE FROM cidade WHERE cid_codigo = ?;";
		
		try {
			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, cid_codigo);
			
			ps.executeUpdate();
			
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}

	}


	@Override
	public Cidade getCidade(Integer cid_codigo) throws SQLException {
		
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sqlSelect = "SELECT * FROM cidade WHERE cid_codigo = ?;";
		
		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, cid_codigo);
			
			rs = ps.executeQuery();
			
			List<Cidade> resultado = getListaCidade(rs);
			if(resultado.size() > 0)
				return resultado.get(0);
			
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}
		
		
		return null;
	}

	@Override
	public List<Cidade> getCidades() throws SQLException {
		
		List<Cidade> resultado = new ArrayList<Cidade>();
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		
		String sqlSelect = "SELECT * FROM cidade; ";
		
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			
			resultado = getListaCidade(rs);
			
			rs.close();
			ps.close();
			
		} finally {
			pool.liberarConexao(con);
		}
		
		return resultado;
	}
	
	
	@Override
	public void salvar(Cidade cidade) throws SQLException {
		
		Connection con = pool.getConnection();
		PreparedStatement ps;
		
		String sqlInsert = "INSERT INTO cidade(cid_nome, cid_uf) VALUES (?,?); ";
		
		try {
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, cidade.getCid_nome());
			ps.setString(2, cidade.getCid_uf());

			ps.executeUpdate();
			ps.close();
			
		} finally {
			pool.liberarConexao(con);
		}

	}
	
	private List<Cidade> getListaCidade (ResultSet rs) throws SQLException{
		
		List<Cidade> resultado = new ArrayList<Cidade>();
		
		while(rs.next())
		{
			Cidade cidade = new Cidade();
			
			
			cidade.setCid_nome(rs.getString("cid_nome"));
			cidade.setCid_uf(rs.getString("cid_uf"));
			cidade.setCid_codigo(rs.getInt("cid_codigo"));
			resultado.add(cidade);
		}
		
		return resultado;
	}
 
	private void setPreparedStatement(Cidade cidade, PreparedStatement ps)
			throws SQLException {
		
		ps.setString(1, cidade.getCid_nome());
		ps.setString(2, cidade.getCid_uf());
		ps.setInt(3, cidade.getCid_codigo());
	}

}
