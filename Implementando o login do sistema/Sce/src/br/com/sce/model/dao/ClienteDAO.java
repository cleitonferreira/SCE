package br.com.sce.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.model.bean.Cliente;

public class ClienteDAO implements InterfaceClienteDAO {

	private InterfacePool pool;
	
	public ClienteDAO(InterfacePool pool)
	{
		this.pool = pool;
	}
	
	@Override
	public void atualizar(Cliente cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		
		String sqlAtualizar = "UPDATE cliente SET cli_obs = ?," +
				"cli_estadocivil = ?, cli_sexo = ?, cli_email = ?," +
				"cli_datacad = ?, cli_datanasc = ?, cli_fonecel = ?," +
				"cli_foneres = ?, cli_insest = ?, cli_cnpj = ?," +
				"cli_rg = ?, cli_cpf = ?, cli_cep = ?, cli_complemento = ?," +
				"cli_numero = ?, cli_endereco = ?, cli_nome = ?," +
				"cli_bairro = ?, cid_codigo = ? WHERE cli_codigo = ? ;";
		
		try {
			ps = con.prepareStatement(sqlAtualizar);
			
			setPreparedStatement(cliente, ps);
			
			ps.executeUpdate();
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}
		
	}
	
	
	@Override
	public void excluir(Integer cli_codigo) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlExcluir = "DELETE FROM cliente WHERE cli_codigo = ?;";
		
		try {
			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, cli_codigo);
			ps.executeUpdate();
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}

	}
	
	
	@Override
	public Cliente getCliente(Integer cli_codigo) throws SQLException {

		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM cliente WHERE cli_codigo = ?;";
		
		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, cli_codigo);
			
			rs = ps.executeQuery();
			
			List<Cliente> resultado = getListaCliente(rs);
			if(resultado.size() > 0)
				return resultado.get(0);
			
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}
		return null;
	}
	
	
	@Override
	public List<Cliente> getClientes() throws SQLException {
		List<Cliente> resultado = new ArrayList<Cliente>();
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlSelect = "SELECT * FROM cliente; ";
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();
			
			resultado = getListaCliente(rs);

			rs.close();
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}
		return resultado;
	}

	private List<Cliente> getListaCliente(ResultSet rs) throws SQLException
	{
		List<Cliente> resultado = new ArrayList<Cliente>();
		while(rs.next())
		{
			Cliente cliente = new Cliente();
			
			CidadeDAO cidadeDAO = new CidadeDAO(this.pool);
			
			cliente.setCli_bairro(rs.getString("cli_bairro"));

			cliente.setCidade(cidadeDAO.getCidade(rs.getInt("cid_codigo")));
			
			cliente.setCli_cep(rs.getString("cli_cep"));
			cliente.setCli_cnpj(rs.getString("cli_cnpj"));
			cliente.setCli_codigo(rs.getInt("cli_codigo"));
			cliente.setCli_complemento(rs.getString("cli_complemento"));
			cliente.setCli_cpf(rs.getString("cli_cpf"));
			cliente.setCli_datacad(rs.getDate("cli_datacad"));
			cliente.setCli_datanasc(rs.getDate("cli_datanasc"));
			cliente.setCli_email(rs.getString("cli_email"));
			cliente.setCli_endereco(rs.getString("cli_endereco"));
			cliente.setCli_estadocivil(rs.getString("cli_estadocivil"));
			cliente.setCli_fonecel(rs.getString("cli_fonecel"));
			cliente.setCli_foneres(rs.getString("cli_foneres"));
			cliente.setCli_insest(rs.getString("cli_insest"));
			cliente.setCli_nome(rs.getString("cli_nome"));
			cliente.setCli_numero(rs.getString("cli_numero"));
			cliente.setCli_obs(rs.getString("cli_obs"));
			cliente.setCli_rg(rs.getString("cli_rg"));
			cliente.setCli_sexo(rs.getString("cli_sexo"));
			resultado.add(cliente);
			
		}
		return resultado;
	}
	
	@Override
	public void salvar(Cliente cliente) throws SQLException {
		
		Connection con = pool.getConnection();
		PreparedStatement ps;
		
		String sqlInsert = "INSERT INTO cliente(cli_obs, cli_estadocivil, cli_sexo, cli_email, " +
				"cli_datacad, cli_datanasc, cli_fonecel, cli_foneres, cli_insest, cli_cnpj, " +
				"cli_rg, cli_cpf, cli_cep, cli_complemento, cli_numero, cli_endereco, " +
				"cli_nome, cli_bairro, cid_codigo) VALUES " +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
		
		try {
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, cliente.getCli_obs());
			ps.setString(2, cliente.getCli_estadocivil());
			ps.setString(3, cliente.getCli_sexo());
			ps.setString(4, cliente.getCli_email());
			ps.setDate(5, (Date) cliente.getCli_datacad());
			ps.setDate(6, (Date) cliente.getCli_datanasc());
			ps.setString(7, cliente.getCli_fonecel());
			ps.setString(8, cliente.getCli_foneres());
			ps.setString(9, cliente.getCli_insest());
			ps.setString(10, cliente.getCli_cnpj());
			ps.setString(11, cliente.getCli_rg());
			ps.setString(12, cliente.getCli_cpf());
			ps.setString(13, cliente.getCli_cep());
			ps.setString(14, cliente.getCli_complemento());
			ps.setString(15, cliente.getCli_numero());
			ps.setString(16, cliente.getCli_endereco());
			ps.setString(17, cliente.getCli_nome());
			ps.setString(18, cliente.getCli_bairro());
			ps.setInt(19, cliente.getCidade().getCid_codigo());
			
			
			ps.executeUpdate();
			ps.close();
		} finally {
			pool.liberarConexao(con);
		}
		

	}

	private void setPreparedStatement(Cliente cliente, PreparedStatement ps)
			throws SQLException {
		ps.setString(1, cliente.getCli_obs());
		ps.setString(2, cliente.getCli_estadocivil());
		ps.setString(3, cliente.getCli_sexo());
		ps.setString(4, cliente.getCli_email());
		ps.setDate(5, (Date) cliente.getCli_datacad());
		ps.setDate(6, (Date) cliente.getCli_datanasc());
		ps.setString(7, cliente.getCli_fonecel());
		ps.setString(8, cliente.getCli_foneres());
		ps.setString(9, cliente.getCli_insest());
		ps.setString(10, cliente.getCli_cnpj());
		ps.setString(11, cliente.getCli_rg());
		ps.setString(12, cliente.getCli_cpf());
		ps.setString(13, cliente.getCli_cep());
		ps.setString(14, cliente.getCli_complemento());
		ps.setString(15, cliente.getCli_numero());
		ps.setString(16, cliente.getCli_endereco());
		ps.setString(17, cliente.getCli_nome());
		ps.setString(18, cliente.getCli_bairro());
		ps.setInt(19, cliente.getCidade().getCid_codigo());
		ps.setInt(20, cliente.getCli_codigo());
	}


}
