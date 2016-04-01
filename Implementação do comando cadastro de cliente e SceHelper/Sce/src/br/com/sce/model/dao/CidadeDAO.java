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
	public void atualizar(Cidade cidade) {
		// TODO Implementar atualizar
	}
	
	
	@Override
	public void excluir(Integer cid_codigo) {
		// TODO Implementar excluir
	}


	@Override
	public Cidade getCidade(Integer cid_codigo) throws SQLException {

		// TODO Implementar getCidade

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
	
	private List<Cidade> getListaCidade (ResultSet rs) {
		// TODO Implementar getListaCidade
		return null;
	}
 
}
